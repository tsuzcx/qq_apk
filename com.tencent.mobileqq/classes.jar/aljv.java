import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.plato.IPlatoManager.IRenderListener;
import com.tencent.plato.PlatoAppFragment;
import com.tencent.plato.PlatoAppManager;

public class aljv
  implements IPlatoManager.IRenderListener
{
  public aljv(PlatoAppFragment paramPlatoAppFragment) {}
  
  public void onCreateDomFinish() {}
  
  public void onRenderFinished(String paramString)
  {
    PlatoAppFragment.a(this.a);
    long l1;
    long l2;
    if (PlatoAppFragment.b(this.a) <= 2)
    {
      if (PlatoAppFragment.b(this.a) != 1) {
        break label84;
      }
      paramString = "start_all_cost";
      l1 = System.currentTimeMillis();
      l2 = PlatoAppFragment.a(this.a);
      if (!PlatoAppFragment.a(this.a)) {
        break label90;
      }
    }
    label84:
    label90:
    for (String str = "1";; str = "0")
    {
      TroopTechReportUtils.a("plato_v1", paramString, String.valueOf(l1 - l2), str, String.valueOf(PlatoAppManager.a), "");
      return;
      paramString = "start_databack_cost";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aljv
 * JD-Core Version:    0.7.0.1
 */