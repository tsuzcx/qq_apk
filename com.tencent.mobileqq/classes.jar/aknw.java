import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import java.lang.ref.WeakReference;

class aknw
  extends ajxl
{
  aknw(aknv paramaknv) {}
  
  protected void onReqLastChatTime(boolean paramBoolean, String paramString1, String paramString2, Long paramLong)
  {
    int j = 1;
    ajxn localajxn;
    int i;
    Object localObject;
    if (paramBoolean)
    {
      localajxn = (ajxn)this.a.a.getManager(51);
      ExtensionInfo localExtensionInfo = localajxn.a(paramString2, true);
      i = 0;
      localObject = localExtensionInfo;
      if (localExtensionInfo == null)
      {
        localObject = new ExtensionInfo();
        ((ExtensionInfo)localObject).uin = paramString2;
        i = 1;
      }
      if (((ExtensionInfo)localObject).lastIceBreakChatTs >= paramLong.longValue()) {
        break label152;
      }
      ((ExtensionInfo)localObject).lastIceBreakChatTs = paramLong.longValue();
      i = j;
    }
    label152:
    for (;;)
    {
      if (i != 0) {
        localajxn.a((ExtensionInfo)localObject);
      }
      if (aknv.a(this.a) == null) {}
      for (localObject = null;; localObject = (aknz)aknv.a(this.a).get())
      {
        if (localObject != null) {
          ((aknz)localObject).a(paramBoolean, paramString1, paramString2, paramLong);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aknw
 * JD-Core Version:    0.7.0.1
 */