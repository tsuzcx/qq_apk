import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.ark.open.delegate.IArkDelegateNet;
import java.lang.ref.WeakReference;

public class afxf
  extends afxh
{
  public afxf(String paramString)
  {
    super(null, paramString);
  }
  
  protected boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    WeakReference localWeakReference = new WeakReference(this);
    IArkDelegateNet localIArkDelegateNet = ArkDelegateManager.getInstance().getNetDelegate();
    if (localIArkDelegateNet == null) {
      return false;
    }
    localIArkDelegateNet.sendAppMsg(paramString1, paramString2, this.a, paramInt2, new afxg(this, localWeakReference));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afxf
 * JD-Core Version:    0.7.0.1
 */