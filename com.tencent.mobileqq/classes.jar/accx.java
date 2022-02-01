import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onReceiveValue"}, k=3, mv={1, 1, 16})
public final class accx<T>
  implements ValueCallback<String>
{
  public static final accx a = new accx();
  
  public final void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingFragment", 2, "handleMotiveBrowsingData EVENT_CALL_BACK_JS callback " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     accx
 * JD-Core Version:    0.7.0.1
 */