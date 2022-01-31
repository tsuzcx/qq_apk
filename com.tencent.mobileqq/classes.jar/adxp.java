import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.hiboom.HiBoomPanelView;
import com.tencent.mobileqq.hiboom.HiBoomPanelView.HiBoomAdapter;

public class adxp
  extends SVIPObserver
{
  public adxp(HiBoomPanelView paramHiBoomPanelView) {}
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      this.a.b();
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxp
 * JD-Core Version:    0.7.0.1
 */