import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.tencent.mobileqq.app.BaseActivity;

public class ajol
{
  private BaseActivity a;
  
  public ajol(BaseActivity paramBaseActivity)
  {
    this.a = paramBaseActivity;
  }
  
  public bkzi a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    bkzi localbkzi = (bkzi)bkzz.a(this.a, null);
    GridView localGridView = (GridView)View.inflate(this.a, 2131563022, null);
    localGridView.setBackgroundDrawable(this.a.getResources().getDrawable(2130837574));
    localGridView.setAdapter(new ajon(this, null));
    localGridView.setOnItemClickListener(paramOnItemClickListener);
    localbkzi.a(localGridView);
    localbkzi.c(2131690697);
    return localbkzi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajol
 * JD-Core Version:    0.7.0.1
 */