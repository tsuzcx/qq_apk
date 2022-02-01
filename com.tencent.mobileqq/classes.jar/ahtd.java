import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ahtd
  extends anrc
{
  public ahtd(AIOImageProviderService paramAIOImageProviderService) {}
  
  private void a(bfjs parambfjs, MessageForTroopFile paramMessageForTroopFile)
  {
    if (FileUtils.fileExistsAndNotEmpty(parambfjs.jdField_d_of_type_JavaLangString)) {
      this.a.jdField_a_of_type_Ahts.a(paramMessageForTroopFile.uniseq, 0, 16, 1, parambfjs.jdField_d_of_type_JavaLangString, false);
    }
    label157:
    do
    {
      for (;;)
      {
        if (!FileUtils.fileExistsAndNotEmpty(parambfjs.jdField_c_of_type_JavaLangString)) {
          break label157;
        }
        this.a.jdField_a_of_type_Ahts.a(paramMessageForTroopFile.uniseq, 0, 18, 1, parambfjs.jdField_c_of_type_JavaLangString, false);
        return;
        if (parambfjs.j != 0) {
          localObject1 = "";
        }
        try
        {
          Object localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("errorType", "thumb_download");
          ((JSONObject)localObject2).put("errorCode", parambfjs.j);
          localObject2 = ((JSONObject)localObject2).toString();
          localObject1 = localObject2;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
        this.a.jdField_a_of_type_Ahts.a(paramMessageForTroopFile.uniseq, 0, 18, 2, (String)localObject1, false);
      }
    } while (parambfjs.j == 0);
    Object localObject1 = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("errorType", "thumb_download");
      localJSONObject.put("errorCode", parambfjs.j);
      parambfjs = localJSONObject.toString();
      this.a.jdField_a_of_type_Ahts.a(paramMessageForTroopFile.uniseq, 0, 18, 2, parambfjs, false);
      return;
    }
    catch (JSONException parambfjs)
    {
      for (;;)
      {
        parambfjs.printStackTrace();
        parambfjs = (bfjs)localObject1;
      }
    }
  }
  
  private void b(bfjs parambfjs, MessageForTroopFile paramMessageForTroopFile)
  {
    if (AIOImageProviderService.a(this.a, paramMessageForTroopFile)) {
      if ((parambfjs.b == 8) && (parambfjs.jdField_c_of_type_Long > 0L))
      {
        int i = (int)((float)parambfjs.jdField_d_of_type_Long / (float)parambfjs.jdField_c_of_type_Long * 10000.0F);
        this.a.jdField_a_of_type_Ahts.a(paramMessageForTroopFile.uniseq, 0, 1, i, parambfjs.jdField_c_of_type_Long, true);
      }
    }
    label165:
    do
    {
      do
      {
        do
        {
          return;
          if (parambfjs.b == 11)
          {
            if (this.a.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramMessageForTroopFile.uniseq)))
            {
              Context localContext = BaseApplicationImpl.sApplication.getBaseContext();
              if (localContext == null) {
                break label165;
              }
              auea.a(localContext, parambfjs.a);
            }
            for (;;)
            {
              this.a.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramMessageForTroopFile.uniseq));
              this.a.jdField_a_of_type_Ahts.a(paramMessageForTroopFile.uniseq, 1, 269484034, 1, parambfjs.a, false);
              return;
              QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file save album].");
            }
          }
        } while ((parambfjs.b != 12) && (parambfjs.b != 10));
        this.a.jdField_a_of_type_Ahts.a(paramMessageForTroopFile.uniseq, 0, 269484034, 2, parambfjs.a, false);
        return;
        if (!paramMessageForTroopFile.isPause) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.i("TroopStatusDebug", 1, "troopFilemsg Pauseed, return! current Status:" + parambfjs.b);
      return;
      if ((parambfjs.b == 8) && (parambfjs.jdField_c_of_type_Long > 0L))
      {
        this.a.jdField_a_of_type_Ahts.a(paramMessageForTroopFile.uniseq, 0, 20, (int)(parambfjs.jdField_d_of_type_Long * 10000L / parambfjs.jdField_c_of_type_Long), paramMessageForTroopFile.fileSize, true);
        return;
      }
      if (parambfjs.b == 11)
      {
        this.a.jdField_a_of_type_Ahts.a(paramMessageForTroopFile.uniseq, 0, 20, 1, parambfjs.a, false);
        return;
      }
    } while ((parambfjs.b != 12) && (parambfjs.b != 10));
    this.a.jdField_a_of_type_Ahts.a(paramMessageForTroopFile.uniseq, 0, 20, 2, "TroopFileError", false);
  }
  
  protected void a(Object paramObject)
  {
    bfjs localbfjs = (bfjs)paramObject;
    paramObject = null;
    if (localbfjs != null) {
      paramObject = AIOImageProviderService.a(this.a, localbfjs.e);
    }
    if ((localbfjs == null) || (paramObject == null))
    {
      QLog.i("AIOImageProviderService", 2, "onTroopFileStatusUpdate: error, info[" + localbfjs + "] troopFileMsg[" + paramObject + "]");
      return;
    }
    if (!paramObject.url.equals(localbfjs.e))
    {
      QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, file info not match message. fileId[" + localbfjs.e + "]");
      return;
    }
    if (this.a.jdField_a_of_type_Ahts == null)
    {
      QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, callback is null.");
      return;
    }
    a(localbfjs, paramObject);
    b(localbfjs, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahtd
 * JD-Core Version:    0.7.0.1
 */