import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akid
  implements View.OnClickListener
{
  akid(akho paramakho) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("string_from", false);
      localBundle.putBoolean("string_uin", true);
      localBundle.putLong("device_din", 0L);
      localBundle.putInt("sTitleID", 0);
      bkoi.a(akho.a(this.a), localBundle, "com.qqdataline.activity.LiteWifiphotoActivity");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akid
 * JD-Core Version:    0.7.0.1
 */