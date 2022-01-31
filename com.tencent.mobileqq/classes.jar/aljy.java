import android.content.Context;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.plato.PlatoAppManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public final class aljy
  implements AsyncBack
{
  public aljy(Context paramContext, AppRuntime paramAppRuntime, long paramLong, long[] paramArrayOfLong) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(PlatoAppManager.a(), 2, "preInitV8So loaded,code=" + paramInt + ", param :" + paramString);
    }
    if (paramInt == 0)
    {
      if (paramString != null) {
        break label85;
      }
      PlatoAppManager.c(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_MqqAppAppRuntime);
      TroopTechReportUtils.a("plato_v1", "v8_so_unzip", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), "", "", "");
    }
    label85:
    do
    {
      return;
      if (paramString.contains("url"))
      {
        PlatoAppManager.a.set(false);
        this.jdField_a_of_type_ArrayOfLong[0] = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
        TroopTechReportUtils.a("plato_v1", "v8_so_download", String.valueOf(this.jdField_a_of_type_ArrayOfLong[0]), "", "", "");
        return;
      }
    } while (PlatoAppManager.a.get());
    PlatoAppManager.c(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_MqqAppAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aljy
 * JD-Core Version:    0.7.0.1
 */