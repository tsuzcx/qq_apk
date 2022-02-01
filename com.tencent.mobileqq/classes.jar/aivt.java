import android.text.TextUtils;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.qphone.base.util.QLog;

public class aivt
  extends asbj
{
  public aivt(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  protected void onFileTransferEnd(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void onFileTransferProgress(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void onFileTransferStart(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void onRefreshList()
  {
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void onThumbDownLoadSuccess(aslv paramaslv)
  {
    if ((TextUtils.isEmpty(paramaslv.a)) || (TextUtils.isEmpty(paramaslv.b))) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.history.C2CAllFragment", 2, "OnThumbDownLoad error : [fileId] = " + paramaslv.a + " [path] = " + paramaslv.b);
      }
    }
    while (this.a.a == null) {
      return;
    }
    this.a.a.notifyDataSetChanged();
  }
  
  protected void onWeiYunSendToOfflineSuccess()
  {
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aivt
 * JD-Core Version:    0.7.0.1
 */