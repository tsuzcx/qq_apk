import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.tencent.mobileqq.app.BaseActivity;

public class afts
{
  private BaseActivity a;
  
  public afts(BaseActivity paramBaseActivity)
  {
    this.a = paramBaseActivity;
  }
  
  public bfpc a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    bfpc localbfpc = (bfpc)bfpp.a(this.a, null);
    GridView localGridView = (GridView)View.inflate(this.a, 2131562573, null);
    localGridView.setBackgroundDrawable(this.a.getResources().getDrawable(2130837562));
    localGridView.setAdapter(new aftu(this, null));
    localGridView.setOnItemClickListener(paramOnItemClickListener);
    localbfpc.a(localGridView);
    localbfpc.c(2131690596);
    return localbfpc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afts
 * JD-Core Version:    0.7.0.1
 */