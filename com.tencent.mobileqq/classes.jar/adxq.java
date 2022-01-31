import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class adxq
  extends ajey
{
  public adxq(AIOImageProviderService paramAIOImageProviderService) {}
  
  protected void a(Object paramObject)
  {
    ayqd localayqd = (ayqd)paramObject;
    if (localayqd != null) {}
    for (paramObject = AIOImageProviderService.a(this.a, localayqd.e);; paramObject = null)
    {
      if ((localayqd == null) || (paramObject == null) || (!paramObject.url.equals(localayqd.e)) || (this.a.jdField_a_of_type_Adyh == null)) {}
      do
      {
        do
        {
          do
          {
            return;
            if (bace.b(localayqd.jdField_d_of_type_JavaLangString)) {
              this.a.jdField_a_of_type_Adyh.a(paramObject.uniseq, 0, 18, 1, localayqd.jdField_d_of_type_JavaLangString, false);
            }
            if (bace.b(localayqd.jdField_c_of_type_JavaLangString)) {
              this.a.jdField_a_of_type_Adyh.a(paramObject.uniseq, 0, 18, 1, localayqd.jdField_c_of_type_JavaLangString, false);
            }
            if (!AIOImageProviderService.a(this.a, paramObject)) {
              break;
            }
            if ((localayqd.b == 8) && (localayqd.jdField_c_of_type_Long > 0L))
            {
              int i = (int)((float)localayqd.jdField_d_of_type_Long / (float)localayqd.jdField_c_of_type_Long * 10000.0F);
              this.a.jdField_a_of_type_Adyh.a(paramObject.uniseq, 0, 1, i, localayqd.jdField_c_of_type_Long, true);
              return;
            }
            if (localayqd.b == 11)
            {
              if (this.a.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramObject.uniseq)))
              {
                apck.a(BaseActivity.sTopActivity, localayqd.a);
                this.a.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramObject.uniseq));
              }
              this.a.jdField_a_of_type_Adyh.a(paramObject.uniseq, 1, 269484034, 1, localayqd.a, false);
              return;
            }
          } while ((localayqd.b != 12) && (localayqd.b != 10));
          this.a.jdField_a_of_type_Adyh.a(paramObject.uniseq, 0, 269484034, 2, localayqd.a, false);
          return;
          if (!paramObject.isPause) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.i("TroopStatusDebug", 1, "troopFilemsg Pauseed, return! current Status:" + localayqd.b);
        return;
        if ((localayqd.b == 8) && (localayqd.jdField_c_of_type_Long > 0L))
        {
          this.a.jdField_a_of_type_Adyh.a(paramObject.uniseq, 0, 20, (int)(localayqd.jdField_d_of_type_Long * 10000L / localayqd.jdField_c_of_type_Long), paramObject.fileSize, true);
          return;
        }
        if (localayqd.b == 11)
        {
          this.a.jdField_a_of_type_Adyh.a(paramObject.uniseq, 0, 20, 1, localayqd.a, false);
          return;
        }
      } while ((localayqd.b != 12) && (localayqd.b != 10));
      this.a.jdField_a_of_type_Adyh.a(paramObject.uniseq, 0, 20, 2, "TroopFileError", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adxq
 * JD-Core Version:    0.7.0.1
 */