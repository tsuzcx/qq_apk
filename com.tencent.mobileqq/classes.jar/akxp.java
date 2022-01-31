import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.worldcup.ARWorldCupGameLogicManager;
import com.tencent.mobileqq.worldcup.ARWorldCupGameLogicManager.RenderProxy;

public class akxp
  implements View.OnClickListener
{
  public akxp(ARWorldCupGameLogicManager paramARWorldCupGameLogicManager) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    this.a.g();
    if (ARWorldCupGameLogicManager.a(this.a) != null)
    {
      ARWorldCupGameLogicManager.a(this.a).i();
      ARWorldCupGameLogicManager.a(this.a).j();
      this.a.a = null;
    }
    this.a.a(0, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akxp
 * JD-Core Version:    0.7.0.1
 */