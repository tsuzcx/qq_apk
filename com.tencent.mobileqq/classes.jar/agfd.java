import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class agfd
  extends alkl
{
  public agfd(AIOImageProviderService paramAIOImageProviderService) {}
  
  protected void a(Object paramObject)
  {
    bbpe localbbpe = (bbpe)paramObject;
    if (localbbpe != null) {}
    for (paramObject = AIOImageProviderService.a(this.a, localbbpe.e);; paramObject = null)
    {
      if ((localbbpe == null) || (paramObject == null) || (!paramObject.url.equals(localbbpe.e)) || (this.a.jdField_a_of_type_Agfw == null)) {}
      label296:
      label479:
      do
      {
        do
        {
          do
          {
            return;
            if (bdcs.b(localbbpe.jdField_d_of_type_JavaLangString))
            {
              this.a.jdField_a_of_type_Agfw.a(paramObject.uniseq, 0, 16, 1, localbbpe.jdField_d_of_type_JavaLangString, false);
              if (!bdcs.b(localbbpe.jdField_c_of_type_JavaLangString)) {
                break label296;
              }
              this.a.jdField_a_of_type_Agfw.a(paramObject.uniseq, 0, 18, 1, localbbpe.jdField_c_of_type_JavaLangString, false);
            }
            Object localObject1;
            for (;;)
            {
              if (!AIOImageProviderService.a(this.a, paramObject)) {
                break label537;
              }
              if ((localbbpe.b != 8) || (localbbpe.jdField_c_of_type_Long <= 0L)) {
                break label384;
              }
              int i = (int)((float)localbbpe.jdField_d_of_type_Long / (float)localbbpe.jdField_c_of_type_Long * 10000.0F);
              this.a.jdField_a_of_type_Agfw.a(paramObject.uniseq, 0, 1, i, localbbpe.jdField_c_of_type_Long, true);
              return;
              if (localbbpe.i == 0) {
                break;
              }
              localObject1 = "";
              try
              {
                Object localObject2 = new JSONObject();
                ((JSONObject)localObject2).put("errorType", "thumb_download");
                ((JSONObject)localObject2).put("errorCode", localbbpe.i);
                localObject2 = ((JSONObject)localObject2).toString();
                localObject1 = localObject2;
              }
              catch (JSONException localJSONException1)
              {
                for (;;)
                {
                  localJSONException1.printStackTrace();
                }
              }
              this.a.jdField_a_of_type_Agfw.a(paramObject.uniseq, 0, 18, 2, (String)localObject1, false);
              break;
              if (localbbpe.i != 0) {
                localObject1 = "";
              }
              try
              {
                Object localObject3 = new JSONObject();
                ((JSONObject)localObject3).put("errorType", "thumb_download");
                ((JSONObject)localObject3).put("errorCode", localbbpe.i);
                localObject3 = ((JSONObject)localObject3).toString();
                localObject1 = localObject3;
              }
              catch (JSONException localJSONException2)
              {
                for (;;)
                {
                  localJSONException2.printStackTrace();
                }
              }
              this.a.jdField_a_of_type_Agfw.a(paramObject.uniseq, 0, 18, 2, (String)localObject1, false);
            }
            if (localbbpe.b == 11)
            {
              if (this.a.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramObject.uniseq)))
              {
                localObject1 = BaseApplicationImpl.sApplication.getBaseContext();
                if (localObject1 == null) {
                  break label479;
                }
                arni.a((Context)localObject1, localbbpe.a);
              }
              for (;;)
              {
                this.a.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramObject.uniseq));
                this.a.jdField_a_of_type_Agfw.a(paramObject.uniseq, 1, 269484034, 1, localbbpe.a, false);
                return;
                QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file save album].");
              }
            }
          } while ((localbbpe.b != 12) && (localbbpe.b != 10));
          this.a.jdField_a_of_type_Agfw.a(paramObject.uniseq, 0, 269484034, 2, localbbpe.a, false);
          return;
          if (!paramObject.isPause) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.i("TroopStatusDebug", 1, "troopFilemsg Pauseed, return! current Status:" + localbbpe.b);
        return;
        if ((localbbpe.b == 8) && (localbbpe.jdField_c_of_type_Long > 0L))
        {
          this.a.jdField_a_of_type_Agfw.a(paramObject.uniseq, 0, 20, (int)(localbbpe.jdField_d_of_type_Long * 10000L / localbbpe.jdField_c_of_type_Long), paramObject.fileSize, true);
          return;
        }
        if (localbbpe.b == 11)
        {
          this.a.jdField_a_of_type_Agfw.a(paramObject.uniseq, 0, 20, 1, localbbpe.a, false);
          return;
        }
      } while ((localbbpe.b != 12) && (localbbpe.b != 10));
      label384:
      label537:
      this.a.jdField_a_of_type_Agfw.a(paramObject.uniseq, 0, 20, 2, "TroopFileError", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agfd
 * JD-Core Version:    0.7.0.1
 */