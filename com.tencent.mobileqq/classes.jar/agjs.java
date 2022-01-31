import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class agjs
  extends alpa
{
  public agjs(AIOImageProviderService paramAIOImageProviderService) {}
  
  protected void a(Object paramObject)
  {
    bbtn localbbtn = (bbtn)paramObject;
    if (localbbtn != null) {}
    for (paramObject = AIOImageProviderService.a(this.a, localbbtn.e);; paramObject = null)
    {
      if ((localbbtn == null) || (paramObject == null) || (!paramObject.url.equals(localbbtn.e)) || (this.a.jdField_a_of_type_Agkl == null)) {}
      label296:
      label479:
      do
      {
        do
        {
          do
          {
            return;
            if (bdhb.b(localbbtn.jdField_d_of_type_JavaLangString))
            {
              this.a.jdField_a_of_type_Agkl.a(paramObject.uniseq, 0, 16, 1, localbbtn.jdField_d_of_type_JavaLangString, false);
              if (!bdhb.b(localbbtn.jdField_c_of_type_JavaLangString)) {
                break label296;
              }
              this.a.jdField_a_of_type_Agkl.a(paramObject.uniseq, 0, 18, 1, localbbtn.jdField_c_of_type_JavaLangString, false);
            }
            Object localObject1;
            for (;;)
            {
              if (!AIOImageProviderService.a(this.a, paramObject)) {
                break label537;
              }
              if ((localbbtn.b != 8) || (localbbtn.jdField_c_of_type_Long <= 0L)) {
                break label384;
              }
              int i = (int)((float)localbbtn.jdField_d_of_type_Long / (float)localbbtn.jdField_c_of_type_Long * 10000.0F);
              this.a.jdField_a_of_type_Agkl.a(paramObject.uniseq, 0, 1, i, localbbtn.jdField_c_of_type_Long, true);
              return;
              if (localbbtn.i == 0) {
                break;
              }
              localObject1 = "";
              try
              {
                Object localObject2 = new JSONObject();
                ((JSONObject)localObject2).put("errorType", "thumb_download");
                ((JSONObject)localObject2).put("errorCode", localbbtn.i);
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
              this.a.jdField_a_of_type_Agkl.a(paramObject.uniseq, 0, 18, 2, (String)localObject1, false);
              break;
              if (localbbtn.i != 0) {
                localObject1 = "";
              }
              try
              {
                Object localObject3 = new JSONObject();
                ((JSONObject)localObject3).put("errorType", "thumb_download");
                ((JSONObject)localObject3).put("errorCode", localbbtn.i);
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
              this.a.jdField_a_of_type_Agkl.a(paramObject.uniseq, 0, 18, 2, (String)localObject1, false);
            }
            if (localbbtn.b == 11)
            {
              if (this.a.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramObject.uniseq)))
              {
                localObject1 = BaseApplicationImpl.sApplication.getBaseContext();
                if (localObject1 == null) {
                  break label479;
                }
                arrr.a((Context)localObject1, localbbtn.a);
              }
              for (;;)
              {
                this.a.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramObject.uniseq));
                this.a.jdField_a_of_type_Agkl.a(paramObject.uniseq, 1, 269484034, 1, localbbtn.a, false);
                return;
                QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file save album].");
              }
            }
          } while ((localbbtn.b != 12) && (localbbtn.b != 10));
          this.a.jdField_a_of_type_Agkl.a(paramObject.uniseq, 0, 269484034, 2, localbbtn.a, false);
          return;
          if (!paramObject.isPause) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.i("TroopStatusDebug", 1, "troopFilemsg Pauseed, return! current Status:" + localbbtn.b);
        return;
        if ((localbbtn.b == 8) && (localbbtn.jdField_c_of_type_Long > 0L))
        {
          this.a.jdField_a_of_type_Agkl.a(paramObject.uniseq, 0, 20, (int)(localbbtn.jdField_d_of_type_Long * 10000L / localbbtn.jdField_c_of_type_Long), paramObject.fileSize, true);
          return;
        }
        if (localbbtn.b == 11)
        {
          this.a.jdField_a_of_type_Agkl.a(paramObject.uniseq, 0, 20, 1, localbbtn.a, false);
          return;
        }
      } while ((localbbtn.b != 12) && (localbbtn.b != 10));
      label384:
      label537:
      this.a.jdField_a_of_type_Agkl.a(paramObject.uniseq, 0, 20, 2, "TroopFileError", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agjs
 * JD-Core Version:    0.7.0.1
 */