import android.text.TextUtils;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.qphone.base.util.QLog;

public class ahuh
  extends aqnl
{
  public ahuh(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  protected void a(aqxx paramaqxx)
  {
    if ((TextUtils.isEmpty(paramaqxx.a)) || (TextUtils.isEmpty(paramaqxx.b))) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.history.C2CAllFragment", 2, "OnThumbDownLoad error : [fileId] = " + paramaqxx.a + " [path] = " + paramaqxx.b);
      }
    }
    while (this.a.a == null) {
      return;
    }
    this.a.a.notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void b()
  {
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void d()
  {
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahuh
 * JD-Core Version:    0.7.0.1
 */