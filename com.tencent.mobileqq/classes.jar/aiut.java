import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class aiut
  extends BroadcastReceiver
{
  private aiut(aiul paramaiul) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i;
    String str1;
    if ("grap_idiom_hb_result_action".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("grap_hb_state", 0);
      paramContext = paramIntent.getStringExtra("listid");
      str1 = paramIntent.getStringExtra("grap_hb_frienduin");
      if ((i != 1) && (i != 10)) {
        break label59;
      }
      aiul.a(this.a, paramContext, str1, 1, true);
    }
    label59:
    String str2;
    do
    {
      do
      {
        return;
      } while (i != 12);
      str2 = paramIntent.getStringExtra("grap_hb_idiom");
      i = paramIntent.getIntExtra("grap_hb_seq", 0);
      paramIntent = paramIntent.getStringExtra("grap_idiom_alpha");
    } while (this.a.a(paramContext) == null);
    aiul.a(this.a, paramContext, str1, 1, false);
    this.a.a(paramContext, str2, paramIntent, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiut
 * JD-Core Version:    0.7.0.1
 */