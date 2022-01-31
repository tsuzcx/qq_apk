import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.plato.PlatoAppManager;
import com.tencent.plato.PlatoLoadEvent;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public final class aljz
  implements AsyncBack
{
  public aljz(boolean paramBoolean, String paramString, long paramLong) {}
  
  public void a(int paramInt)
  {
    QLog.d(PlatoAppManager.a(), 2, "progress:" + paramInt);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(PlatoAppManager.a(), 2, "loadPlatoAppByBid loaded, code:" + paramInt + ", param :" + paramString);
    }
    if (paramInt == 0)
    {
      if (paramString == null)
      {
        if ((PlatoAppManager.b == 0) || (this.jdField_a_of_type_Boolean)) {
          PlatoAppManager.a(this.jdField_a_of_type_JavaLangString);
        }
        PlatoAppManager.a = 1;
        TroopTechReportUtils.a("plato_v1", "bundler_download", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), "1", "", "");
        return;
      }
      if (paramString.contains("url"))
      {
        TroopTechReportUtils.a("plato_v1", "bundler_download", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), "1-1", "", "");
        return;
      }
      if ((PlatoAppManager.b == 0) || (this.jdField_a_of_type_Boolean)) {
        PlatoAppManager.a(this.jdField_a_of_type_JavaLangString);
      }
      PlatoAppManager.a = 0;
      TroopTechReportUtils.a("plato_v1", "bundler_download", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), "0", "", "");
      return;
    }
    paramString = PlatoLoadEvent.a(1, this.jdField_a_of_type_JavaLangString, PlatoAppManager.a(this.jdField_a_of_type_JavaLangString, "bundler.js"));
    Dispatchers.get().dispatch(paramString);
    TroopTechReportUtils.a("plato_v1", "bundler_download", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), "-1", String.valueOf(paramInt), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aljz
 * JD-Core Version:    0.7.0.1
 */