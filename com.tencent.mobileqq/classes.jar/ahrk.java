import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.tencent.mobileqq.app.BaseActivity;

public class ahrk
{
  private BaseActivity a;
  
  public ahrk(BaseActivity paramBaseActivity)
  {
    this.a = paramBaseActivity;
  }
  
  public bhpy a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    bhpy localbhpy = (bhpy)bhql.a(this.a, null);
    GridView localGridView = (GridView)View.inflate(this.a, 2131562775, null);
    localGridView.setBackgroundDrawable(this.a.getResources().getDrawable(2130837562));
    localGridView.setAdapter(new ahrm(this, null));
    localGridView.setOnItemClickListener(paramOnItemClickListener);
    localbhpy.a(localGridView);
    localbhpy.c(2131690648);
    return localbhpy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrk
 * JD-Core Version:    0.7.0.1
 */