import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.armap.test.ArmapJumpActivity;
import com.tencent.mobileqq.armap.wealthgod.ARMapLoadingActivity;
import com.tencent.mobileqq.widget.QQToast;

public class abou
  implements View.OnClickListener
{
  public abou(ArmapJumpActivity paramArmapJumpActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    try
    {
      paramView = new Intent(this.a, ARMapLoadingActivity.class);
      paramView.putExtra("disable_location", true);
      double d1 = Double.parseDouble(this.a.a.getText().toString());
      double d2 = Double.parseDouble(this.a.b.getText().toString());
      long l = Long.parseLong(this.a.c.getText().toString());
      Log.d("ArmapJumpActivity", "jump start lon = " + d1 + ",lat = " + d2);
      paramView.putExtra("default_lon", d1);
      paramView.putExtra("default_lat", d2);
      paramView.putExtra("adcode", l);
      paramView.putExtra("from_jump", true);
      this.a.startActivity(paramView);
      return;
    }
    catch (Exception paramView)
    {
      QQToast.a(this.a.getApplicationContext(), "参数转化有误", 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abou
 * JD-Core Version:    0.7.0.1
 */