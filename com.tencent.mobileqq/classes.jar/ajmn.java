import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.tencent.mobileqq.app.BaseActivity;

public class ajmn
{
  private BaseActivity a;
  
  public ajmn(BaseActivity paramBaseActivity)
  {
    this.a = paramBaseActivity;
  }
  
  public bkho a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    bkho localbkho = (bkho)bkif.a(this.a, null);
    GridView localGridView = (GridView)View.inflate(this.a, 2131563032, null);
    localGridView.setBackgroundDrawable(this.a.getResources().getDrawable(2130837574));
    localGridView.setAdapter(new ajmp(this, null));
    localGridView.setOnItemClickListener(paramOnItemClickListener);
    localbkho.a(localGridView);
    localbkho.c(2131690582);
    return localbkho;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajmn
 * JD-Core Version:    0.7.0.1
 */