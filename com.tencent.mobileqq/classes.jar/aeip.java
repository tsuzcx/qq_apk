import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class aeip
  extends ajta
{
  public aeip(AIOImageProviderService paramAIOImageProviderService) {}
  
  protected void a(Object paramObject)
  {
    azqt localazqt = (azqt)paramObject;
    if (localazqt != null) {}
    for (paramObject = AIOImageProviderService.a(this.a, localazqt.e);; paramObject = null)
    {
      if ((localazqt == null) || (paramObject == null) || (!paramObject.url.equals(localazqt.e)) || (this.a.jdField_a_of_type_Aejg == null)) {}
      label296:
      do
      {
        do
        {
          do
          {
            return;
            if (bbdj.b(localazqt.jdField_d_of_type_JavaLangString))
            {
              this.a.jdField_a_of_type_Aejg.a(paramObject.uniseq, 0, 16, 1, localazqt.jdField_d_of_type_JavaLangString, false);
              if (!bbdj.b(localazqt.jdField_c_of_type_JavaLangString)) {
                break label296;
              }
              this.a.jdField_a_of_type_Aejg.a(paramObject.uniseq, 0, 18, 1, localazqt.jdField_c_of_type_JavaLangString, false);
            }
            for (;;)
            {
              if (!AIOImageProviderService.a(this.a, paramObject)) {
                break label517;
              }
              if ((localazqt.b != 8) || (localazqt.jdField_c_of_type_Long <= 0L)) {
                break label384;
              }
              int i = (int)((float)localazqt.jdField_d_of_type_Long / (float)localazqt.jdField_c_of_type_Long * 10000.0F);
              this.a.jdField_a_of_type_Aejg.a(paramObject.uniseq, 0, 1, i, localazqt.jdField_c_of_type_Long, true);
              return;
              if (localazqt.i == 0) {
                break;
              }
              Object localObject1 = "";
              try
              {
                Object localObject2 = new JSONObject();
                ((JSONObject)localObject2).put("errorType", "thumb_download");
                ((JSONObject)localObject2).put("errorCode", localazqt.i);
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
              this.a.jdField_a_of_type_Aejg.a(paramObject.uniseq, 0, 18, 2, (String)localObject1, false);
              break;
              if (localazqt.i != 0) {
                localObject1 = "";
              }
              try
              {
                Object localObject3 = new JSONObject();
                ((JSONObject)localObject3).put("errorType", "thumb_download");
                ((JSONObject)localObject3).put("errorCode", localazqt.i);
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
              this.a.jdField_a_of_type_Aejg.a(paramObject.uniseq, 0, 18, 2, (String)localObject1, false);
            }
            if (localazqt.b == 11)
            {
              if (this.a.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramObject.uniseq)))
              {
                apue.a(BaseActivity.sTopActivity, localazqt.a);
                this.a.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramObject.uniseq));
              }
              this.a.jdField_a_of_type_Aejg.a(paramObject.uniseq, 1, 269484034, 1, localazqt.a, false);
              return;
            }
          } while ((localazqt.b != 12) && (localazqt.b != 10));
          this.a.jdField_a_of_type_Aejg.a(paramObject.uniseq, 0, 269484034, 2, localazqt.a, false);
          return;
          if (!paramObject.isPause) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.i("TroopStatusDebug", 1, "troopFilemsg Pauseed, return! current Status:" + localazqt.b);
        return;
        if ((localazqt.b == 8) && (localazqt.jdField_c_of_type_Long > 0L))
        {
          this.a.jdField_a_of_type_Aejg.a(paramObject.uniseq, 0, 20, (int)(localazqt.jdField_d_of_type_Long * 10000L / localazqt.jdField_c_of_type_Long), paramObject.fileSize, true);
          return;
        }
        if (localazqt.b == 11)
        {
          this.a.jdField_a_of_type_Aejg.a(paramObject.uniseq, 0, 20, 1, localazqt.a, false);
          return;
        }
      } while ((localazqt.b != 12) && (localazqt.b != 10));
      label384:
      label517:
      this.a.jdField_a_of_type_Aejg.a(paramObject.uniseq, 0, 20, 2, "TroopFileError", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeip
 * JD-Core Version:    0.7.0.1
 */