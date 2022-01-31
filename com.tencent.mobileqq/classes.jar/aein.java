import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class aein
  extends ajsy
{
  public aein(AIOImageProviderService paramAIOImageProviderService) {}
  
  protected void a(Object paramObject)
  {
    azqv localazqv = (azqv)paramObject;
    if (localazqv != null) {}
    for (paramObject = AIOImageProviderService.a(this.a, localazqv.e);; paramObject = null)
    {
      if ((localazqv == null) || (paramObject == null) || (!paramObject.url.equals(localazqv.e)) || (this.a.jdField_a_of_type_Aeje == null)) {}
      label296:
      do
      {
        do
        {
          do
          {
            return;
            if (bbdx.b(localazqv.jdField_d_of_type_JavaLangString))
            {
              this.a.jdField_a_of_type_Aeje.a(paramObject.uniseq, 0, 16, 1, localazqv.jdField_d_of_type_JavaLangString, false);
              if (!bbdx.b(localazqv.jdField_c_of_type_JavaLangString)) {
                break label296;
              }
              this.a.jdField_a_of_type_Aeje.a(paramObject.uniseq, 0, 18, 1, localazqv.jdField_c_of_type_JavaLangString, false);
            }
            for (;;)
            {
              if (!AIOImageProviderService.a(this.a, paramObject)) {
                break label517;
              }
              if ((localazqv.b != 8) || (localazqv.jdField_c_of_type_Long <= 0L)) {
                break label384;
              }
              int i = (int)((float)localazqv.jdField_d_of_type_Long / (float)localazqv.jdField_c_of_type_Long * 10000.0F);
              this.a.jdField_a_of_type_Aeje.a(paramObject.uniseq, 0, 1, i, localazqv.jdField_c_of_type_Long, true);
              return;
              if (localazqv.i == 0) {
                break;
              }
              Object localObject1 = "";
              try
              {
                Object localObject2 = new JSONObject();
                ((JSONObject)localObject2).put("errorType", "thumb_download");
                ((JSONObject)localObject2).put("errorCode", localazqv.i);
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
              this.a.jdField_a_of_type_Aeje.a(paramObject.uniseq, 0, 18, 2, (String)localObject1, false);
              break;
              if (localazqv.i != 0) {
                localObject1 = "";
              }
              try
              {
                Object localObject3 = new JSONObject();
                ((JSONObject)localObject3).put("errorType", "thumb_download");
                ((JSONObject)localObject3).put("errorCode", localazqv.i);
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
              this.a.jdField_a_of_type_Aeje.a(paramObject.uniseq, 0, 18, 2, (String)localObject1, false);
            }
            if (localazqv.b == 11)
            {
              if (this.a.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramObject.uniseq)))
              {
                apug.a(BaseActivity.sTopActivity, localazqv.a);
                this.a.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramObject.uniseq));
              }
              this.a.jdField_a_of_type_Aeje.a(paramObject.uniseq, 1, 269484034, 1, localazqv.a, false);
              return;
            }
          } while ((localazqv.b != 12) && (localazqv.b != 10));
          this.a.jdField_a_of_type_Aeje.a(paramObject.uniseq, 0, 269484034, 2, localazqv.a, false);
          return;
          if (!paramObject.isPause) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.i("TroopStatusDebug", 1, "troopFilemsg Pauseed, return! current Status:" + localazqv.b);
        return;
        if ((localazqv.b == 8) && (localazqv.jdField_c_of_type_Long > 0L))
        {
          this.a.jdField_a_of_type_Aeje.a(paramObject.uniseq, 0, 20, (int)(localazqv.jdField_d_of_type_Long * 10000L / localazqv.jdField_c_of_type_Long), paramObject.fileSize, true);
          return;
        }
        if (localazqv.b == 11)
        {
          this.a.jdField_a_of_type_Aeje.a(paramObject.uniseq, 0, 20, 1, localazqv.a, false);
          return;
        }
      } while ((localazqv.b != 12) && (localazqv.b != 10));
      label384:
      label517:
      this.a.jdField_a_of_type_Aeje.a(paramObject.uniseq, 0, 20, 2, "TroopFileError", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aein
 * JD-Core Version:    0.7.0.1
 */