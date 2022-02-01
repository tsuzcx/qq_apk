import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ahtz
  extends anif
{
  public ahtz(AIOImageProviderService paramAIOImageProviderService) {}
  
  private void a(bety parambety, MessageForTroopFile paramMessageForTroopFile)
  {
    if (bgmg.b(parambety.jdField_d_of_type_JavaLangString)) {
      this.a.jdField_a_of_type_Ahuo.a(paramMessageForTroopFile.uniseq, 0, 16, 1, parambety.jdField_d_of_type_JavaLangString, false);
    }
    label157:
    do
    {
      for (;;)
      {
        if (!bgmg.b(parambety.jdField_c_of_type_JavaLangString)) {
          break label157;
        }
        this.a.jdField_a_of_type_Ahuo.a(paramMessageForTroopFile.uniseq, 0, 18, 1, parambety.jdField_c_of_type_JavaLangString, false);
        return;
        if (parambety.j != 0) {
          localObject1 = "";
        }
        try
        {
          Object localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("errorType", "thumb_download");
          ((JSONObject)localObject2).put("errorCode", parambety.j);
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
        this.a.jdField_a_of_type_Ahuo.a(paramMessageForTroopFile.uniseq, 0, 18, 2, (String)localObject1, false);
      }
    } while (parambety.j == 0);
    Object localObject1 = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("errorType", "thumb_download");
      localJSONObject.put("errorCode", parambety.j);
      parambety = localJSONObject.toString();
      this.a.jdField_a_of_type_Ahuo.a(paramMessageForTroopFile.uniseq, 0, 18, 2, parambety, false);
      return;
    }
    catch (JSONException parambety)
    {
      for (;;)
      {
        parambety.printStackTrace();
        parambety = (bety)localObject1;
      }
    }
  }
  
  private void b(bety parambety, MessageForTroopFile paramMessageForTroopFile)
  {
    if (AIOImageProviderService.a(this.a, paramMessageForTroopFile)) {
      if ((parambety.b == 8) && (parambety.jdField_c_of_type_Long > 0L))
      {
        int i = (int)((float)parambety.jdField_d_of_type_Long / (float)parambety.jdField_c_of_type_Long * 10000.0F);
        this.a.jdField_a_of_type_Ahuo.a(paramMessageForTroopFile.uniseq, 0, 1, i, parambety.jdField_c_of_type_Long, true);
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
          if (parambety.b == 11)
          {
            if (this.a.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramMessageForTroopFile.uniseq)))
            {
              Context localContext = BaseApplicationImpl.sApplication.getBaseContext();
              if (localContext == null) {
                break label165;
              }
              atvo.a(localContext, parambety.a);
            }
            for (;;)
            {
              this.a.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramMessageForTroopFile.uniseq));
              this.a.jdField_a_of_type_Ahuo.a(paramMessageForTroopFile.uniseq, 1, 269484034, 1, parambety.a, false);
              return;
              QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file save album].");
            }
          }
        } while ((parambety.b != 12) && (parambety.b != 10));
        this.a.jdField_a_of_type_Ahuo.a(paramMessageForTroopFile.uniseq, 0, 269484034, 2, parambety.a, false);
        return;
        if (!paramMessageForTroopFile.isPause) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.i("TroopStatusDebug", 1, "troopFilemsg Pauseed, return! current Status:" + parambety.b);
      return;
      if ((parambety.b == 8) && (parambety.jdField_c_of_type_Long > 0L))
      {
        this.a.jdField_a_of_type_Ahuo.a(paramMessageForTroopFile.uniseq, 0, 20, (int)(parambety.jdField_d_of_type_Long * 10000L / parambety.jdField_c_of_type_Long), paramMessageForTroopFile.fileSize, true);
        return;
      }
      if (parambety.b == 11)
      {
        this.a.jdField_a_of_type_Ahuo.a(paramMessageForTroopFile.uniseq, 0, 20, 1, parambety.a, false);
        return;
      }
    } while ((parambety.b != 12) && (parambety.b != 10));
    this.a.jdField_a_of_type_Ahuo.a(paramMessageForTroopFile.uniseq, 0, 20, 2, "TroopFileError", false);
  }
  
  protected void a(Object paramObject)
  {
    bety localbety = (bety)paramObject;
    paramObject = null;
    if (localbety != null) {
      paramObject = AIOImageProviderService.a(this.a, localbety.e);
    }
    if ((localbety == null) || (paramObject == null))
    {
      QLog.i("AIOImageProviderService", 2, "onTroopFileStatusUpdate: error, info[" + localbety + "] troopFileMsg[" + paramObject + "]");
      return;
    }
    if (!paramObject.url.equals(localbety.e))
    {
      QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, file info not match message. fileId[" + localbety.e + "]");
      return;
    }
    if (this.a.jdField_a_of_type_Ahuo == null)
    {
      QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, callback is null.");
      return;
    }
    a(localbety, paramObject);
    b(localbety, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahtz
 * JD-Core Version:    0.7.0.1
 */