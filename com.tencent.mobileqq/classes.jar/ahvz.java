import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.tencent.mobileqq.app.BaseActivity;

public class ahvz
{
  private BaseActivity a;
  
  public ahvz(BaseActivity paramBaseActivity)
  {
    this.a = paramBaseActivity;
  }
  
  public bhuf a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    bhuf localbhuf = (bhuf)bhus.a(this.a, null);
    GridView localGridView = (GridView)View.inflate(this.a, 2131562793, null);
    localGridView.setBackgroundDrawable(this.a.getResources().getDrawable(2130837562));
    localGridView.setAdapter(new ahwb(this, null));
    localGridView.setOnItemClickListener(paramOnItemClickListener);
    localbhuf.a(localGridView);
    localbhuf.c(2131690648);
    return localbhuf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahvz
 * JD-Core Version:    0.7.0.1
 */