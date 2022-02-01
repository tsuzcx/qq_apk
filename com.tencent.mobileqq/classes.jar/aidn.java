import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class aidn
  extends anua
{
  public aidn(AIOImageProviderService paramAIOImageProviderService) {}
  
  private void a(bftf parambftf, MessageForTroopFile paramMessageForTroopFile)
  {
    if (bhmi.b(parambftf.jdField_d_of_type_JavaLangString)) {
      this.a.jdField_a_of_type_Aiec.a(paramMessageForTroopFile.uniseq, 0, 16, 1, parambftf.jdField_d_of_type_JavaLangString, false);
    }
    label157:
    do
    {
      for (;;)
      {
        if (!bhmi.b(parambftf.jdField_c_of_type_JavaLangString)) {
          break label157;
        }
        this.a.jdField_a_of_type_Aiec.a(paramMessageForTroopFile.uniseq, 0, 18, 1, parambftf.jdField_c_of_type_JavaLangString, false);
        return;
        if (parambftf.j != 0) {
          localObject1 = "";
        }
        try
        {
          Object localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("errorType", "thumb_download");
          ((JSONObject)localObject2).put("errorCode", parambftf.j);
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
        this.a.jdField_a_of_type_Aiec.a(paramMessageForTroopFile.uniseq, 0, 18, 2, (String)localObject1, false);
      }
    } while (parambftf.j == 0);
    Object localObject1 = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("errorType", "thumb_download");
      localJSONObject.put("errorCode", parambftf.j);
      parambftf = localJSONObject.toString();
      this.a.jdField_a_of_type_Aiec.a(paramMessageForTroopFile.uniseq, 0, 18, 2, parambftf, false);
      return;
    }
    catch (JSONException parambftf)
    {
      for (;;)
      {
        parambftf.printStackTrace();
        parambftf = (bftf)localObject1;
      }
    }
  }
  
  private void b(bftf parambftf, MessageForTroopFile paramMessageForTroopFile)
  {
    if (AIOImageProviderService.a(this.a, paramMessageForTroopFile)) {
      if ((parambftf.b == 8) && (parambftf.jdField_c_of_type_Long > 0L))
      {
        int i = (int)((float)parambftf.jdField_d_of_type_Long / (float)parambftf.jdField_c_of_type_Long * 10000.0F);
        this.a.jdField_a_of_type_Aiec.a(paramMessageForTroopFile.uniseq, 0, 1, i, parambftf.jdField_c_of_type_Long, true);
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
          if (parambftf.b == 11)
          {
            if (this.a.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramMessageForTroopFile.uniseq)))
            {
              Context localContext = BaseApplicationImpl.sApplication.getBaseContext();
              if (localContext == null) {
                break label165;
              }
              aunj.a(localContext, parambftf.a);
            }
            for (;;)
            {
              this.a.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramMessageForTroopFile.uniseq));
              this.a.jdField_a_of_type_Aiec.a(paramMessageForTroopFile.uniseq, 1, 269484034, 1, parambftf.a, false);
              return;
              QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file save album].");
            }
          }
        } while ((parambftf.b != 12) && (parambftf.b != 10));
        this.a.jdField_a_of_type_Aiec.a(paramMessageForTroopFile.uniseq, 0, 269484034, 2, parambftf.a, false);
        return;
        if (!paramMessageForTroopFile.isPause) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.i("TroopStatusDebug", 1, "troopFilemsg Pauseed, return! current Status:" + parambftf.b);
      return;
      if ((parambftf.b == 8) && (parambftf.jdField_c_of_type_Long > 0L))
      {
        this.a.jdField_a_of_type_Aiec.a(paramMessageForTroopFile.uniseq, 0, 20, (int)(parambftf.jdField_d_of_type_Long * 10000L / parambftf.jdField_c_of_type_Long), paramMessageForTroopFile.fileSize, true);
        return;
      }
      if (parambftf.b == 11)
      {
        this.a.jdField_a_of_type_Aiec.a(paramMessageForTroopFile.uniseq, 0, 20, 1, parambftf.a, false);
        return;
      }
    } while ((parambftf.b != 12) && (parambftf.b != 10));
    this.a.jdField_a_of_type_Aiec.a(paramMessageForTroopFile.uniseq, 0, 20, 2, "TroopFileError", false);
  }
  
  protected void a(Object paramObject)
  {
    bftf localbftf = (bftf)paramObject;
    paramObject = null;
    if (localbftf != null) {
      paramObject = AIOImageProviderService.a(this.a, localbftf.e);
    }
    if ((localbftf == null) || (paramObject == null))
    {
      QLog.i("AIOImageProviderService", 2, "onTroopFileStatusUpdate: error, info[" + localbftf + "] troopFileMsg[" + paramObject + "]");
      return;
    }
    if (!paramObject.url.equals(localbftf.e))
    {
      QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, file info not match message. fileId[" + localbftf.e + "]");
      return;
    }
    if (this.a.jdField_a_of_type_Aiec == null)
    {
      QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, callback is null.");
      return;
    }
    a(localbftf, paramObject);
    b(localbftf, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidn
 * JD-Core Version:    0.7.0.1
 */