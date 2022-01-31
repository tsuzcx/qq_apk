import android.os.Bundle;

class aedp
  extends atdl
{
  aedp(aedo paramaedo) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBoolean == true))
    {
      paramBundle.getInt("gif_ui_show_bid");
      long l = paramBundle.getLong("gif_ui_show_seq");
      this.a.e(65536);
      aedo.a(this.a, Long.valueOf(l).longValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aedp
 * JD-Core Version:    0.7.0.1
 */