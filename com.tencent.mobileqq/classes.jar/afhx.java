import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.tencent.mobileqq.app.BaseActivity;

public class afhx
{
  private BaseActivity a;
  
  public afhx(BaseActivity paramBaseActivity)
  {
    this.a = paramBaseActivity;
  }
  
  public begr a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    begr localbegr = (begr)behe.a(this.a, null);
    GridView localGridView = (GridView)View.inflate(this.a, 2131496974, null);
    localGridView.setBackgroundDrawable(this.a.getResources().getDrawable(2130837557));
    localGridView.setAdapter(new afhz(this, null));
    localGridView.setOnItemClickListener(paramOnItemClickListener);
    localbegr.a(localGridView);
    localbegr.c(2131625035);
    return localbegr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afhx
 * JD-Core Version:    0.7.0.1
 */