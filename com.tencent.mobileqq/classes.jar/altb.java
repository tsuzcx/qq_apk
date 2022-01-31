import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.colornote.data.ColorNote;
import cooperation.qqreader.QRBridgeActivity;

public class altb
  implements alsv
{
  public void a(Context paramContext, ColorNote paramColorNote)
  {
    Intent localIntent1 = new Intent(paramContext, QRBridgeActivity.class);
    localIntent1.putExtra("readtype", "16");
    localIntent1.putExtra("stay", "1");
    localIntent1.putExtra("recent_note", alsr.b(paramColorNote));
    Intent localIntent2 = new Intent();
    paramColorNote = paramColorNote.getSubType().split("_");
    if (paramColorNote.length > 1) {
      localIntent2.putExtra("nbid", paramColorNote[0]);
    }
    localIntent1.putExtras(localIntent2);
    localIntent1.addFlags(268435456);
    paramContext.startActivity(localIntent1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     altb
 * JD-Core Version:    0.7.0.1
 */