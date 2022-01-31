import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

class ajbx
  implements View.OnClickListener
{
  ajbx(ajbm paramajbm) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = new Bundle();
    paramView.putBoolean("string_from", false);
    paramView.putBoolean("string_uin", true);
    paramView.putLong("device_din", 0L);
    paramView.putInt("sTitleID", 0);
    biqg.a(ajbm.a(this.a), paramView, "com.qqdataline.activity.LiteWifiphotoActivity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajbx
 * JD-Core Version:    0.7.0.1
 */