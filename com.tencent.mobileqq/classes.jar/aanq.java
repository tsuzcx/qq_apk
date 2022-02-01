import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/tribe/TribeWebViewPlugin;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "()V", "processMap", "", "", "Lcom/tencent/biz/tribe/webplugins/ShowShareMenuProcessor;", "handleJsRequest", "", "listener", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "url", "pkgName", "method", "args", "", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "BaseTribePluginProcessor", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class aanq
  extends WebViewPlugin
{
  public static final aans a;
  private final Map<String, aant> a;
  
  static
  {
    jdField_a_of_type_Aans = new aans(null);
  }
  
  public aanq()
  {
    this.jdField_a_of_type_JavaUtilMap = MapsKt.mapOf(TuplesKt.to("showShareMenu", new aant(this)));
  }
  
  public boolean handleJsRequest(@Nullable JsBridgeListener paramJsBridgeListener, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    Object localObject = (CharSequence)paramString3;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label129;
      }
      localObject = (aant)this.jdField_a_of_type_JavaUtilMap.get(paramString3);
      if (localObject == null) {
        break label129;
      }
      if (paramVarArgs.length != 0) {
        break label106;
      }
      i = 1;
      label67:
      if (i != 0) {
        break label112;
      }
      i = 1;
      label75:
      if (i == 0) {
        break label118;
      }
    }
    label106:
    label112:
    label118:
    for (paramJsBridgeListener = new JSONObject(paramVarArgs[0]);; paramJsBridgeListener = new JSONObject())
    {
      ((aant)localObject).a(paramJsBridgeListener);
      return true;
      i = 0;
      break;
      i = 0;
      break label67;
      i = 0;
      break label75;
    }
    label129:
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aanq
 * JD-Core Version:    0.7.0.1
 */