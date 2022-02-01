import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.tencent.mobileqq.app.BaseActivity;

public class aisw
{
  private BaseActivity a;
  
  public aisw(BaseActivity paramBaseActivity)
  {
    this.a = paramBaseActivity;
  }
  
  public bjnw a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    bjnw localbjnw = (bjnw)bjon.a(this.a, null);
    GridView localGridView = (GridView)View.inflate(this.a, 2131562948, null);
    localGridView.setBackgroundDrawable(this.a.getResources().getDrawable(2130837574));
    localGridView.setAdapter(new aisy(this, null));
    localGridView.setOnItemClickListener(paramOnItemClickListener);
    localbjnw.a(localGridView);
    localbjnw.c(2131690620);
    return localbjnw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisw
 * JD-Core Version:    0.7.0.1
 */