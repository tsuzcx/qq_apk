import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.tencent.mobileqq.app.BaseActivity;

public class aftu
{
  private BaseActivity a;
  
  public aftu(BaseActivity paramBaseActivity)
  {
    this.a = paramBaseActivity;
  }
  
  public bfol a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    bfol localbfol = (bfol)bfoy.a(this.a, null);
    GridView localGridView = (GridView)View.inflate(this.a, 2131562574, null);
    localGridView.setBackgroundDrawable(this.a.getResources().getDrawable(2130837562));
    localGridView.setAdapter(new aftw(this, null));
    localGridView.setOnItemClickListener(paramOnItemClickListener);
    localbfol.a(localGridView);
    localbfol.c(2131690596);
    return localbfol;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aftu
 * JD-Core Version:    0.7.0.1
 */