import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.tencent.mobileqq.app.BaseActivity;

public class ajxw
{
  private BaseActivity a;
  
  public ajxw(BaseActivity paramBaseActivity)
  {
    this.a = paramBaseActivity;
  }
  
  public blir a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    blir localblir = (blir)blji.a(this.a, null);
    GridView localGridView = (GridView)View.inflate(this.a, 2131563067, null);
    localGridView.setBackgroundDrawable(this.a.getResources().getDrawable(2130837574));
    localGridView.setAdapter(new ajxy(this, null));
    localGridView.setOnItemClickListener(paramOnItemClickListener);
    localblir.a(localGridView);
    localblir.c(2131690580);
    return localblir;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxw
 * JD-Core Version:    0.7.0.1
 */