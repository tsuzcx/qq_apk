package d.a.a.a;

import android.content.ContentResolver;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

final class b
  implements MethodChannel.MethodCallHandler
{
  private static final String[] aitj = new String[0];
  private final PackageManager aiti;
  private final ContentResolver contentResolver;
  
  b(ContentResolver paramContentResolver, PackageManager paramPackageManager)
  {
    this.contentResolver = paramContentResolver;
    this.aiti = paramPackageManager;
  }
  
  private String[] kkD()
  {
    AppMethodBeat.i(186879);
    Object localObject = this.aiti.getSystemAvailableFeatures();
    if (localObject == null)
    {
      localObject = aitj;
      AppMethodBeat.o(186879);
      return localObject;
    }
    String[] arrayOfString = new String[localObject.length];
    int i = 0;
    while (i < localObject.length)
    {
      arrayOfString[i] = localObject[i].name;
      i += 1;
    }
    AppMethodBeat.o(186879);
    return arrayOfString;
  }
  
  public final void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    boolean bool = true;
    AppMethodBeat.i(186944);
    if (paramMethodCall.method.equals("getAndroidDeviceInfo"))
    {
      paramMethodCall = new HashMap();
      paramMethodCall.put("board", Build.BOARD);
      paramMethodCall.put("bootloader", Build.BOOTLOADER);
      paramMethodCall.put("brand", Build.BRAND);
      paramMethodCall.put("device", Build.DEVICE);
      paramMethodCall.put("display", Build.DISPLAY);
      paramMethodCall.put("fingerprint", Build.FINGERPRINT);
      paramMethodCall.put("hardware", Build.HARDWARE);
      paramMethodCall.put("host", Build.HOST);
      paramMethodCall.put("id", Build.ID);
      paramMethodCall.put("manufacturer", Build.MANUFACTURER);
      paramMethodCall.put("model", Build.MODEL);
      paramMethodCall.put("product", Build.PRODUCT);
      int i;
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramMethodCall.put("supported32BitAbis", Arrays.asList(Build.SUPPORTED_32_BIT_ABIS));
        paramMethodCall.put("supported64BitAbis", Arrays.asList(Build.SUPPORTED_64_BIT_ABIS));
        paramMethodCall.put("supportedAbis", Arrays.asList(Build.SUPPORTED_ABIS));
        paramMethodCall.put("tags", Build.TAGS);
        paramMethodCall.put("type", Build.TYPE);
        if (((!Build.BRAND.startsWith("generic")) || (!Build.DEVICE.startsWith("generic"))) && (!Build.FINGERPRINT.startsWith("generic")) && (!Build.FINGERPRINT.startsWith("unknown")) && (!Build.HARDWARE.contains("goldfish")) && (!Build.HARDWARE.contains("ranchu")) && (!Build.MODEL.contains("google_sdk")) && (!Build.MODEL.contains("Emulator")) && (!Build.MODEL.contains("Android SDK built for x86")) && (!Build.MANUFACTURER.contains("Genymotion")) && (!Build.PRODUCT.contains("sdk_google")) && (!Build.PRODUCT.contains("google_sdk")) && (!Build.PRODUCT.contains("sdk")) && (!Build.PRODUCT.contains("sdk_x86")) && (!Build.PRODUCT.contains("vbox86p")) && (!Build.PRODUCT.contains("emulator")) && (!Build.PRODUCT.contains("simulator"))) {
          break label730;
        }
        i = 1;
        label438:
        if (i != 0) {
          break label735;
        }
      }
      for (;;)
      {
        paramMethodCall.put("isPhysicalDevice", Boolean.valueOf(bool));
        Object localObject = this.contentResolver;
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG("android_id").cG(localObject);
        paramMethodCall.put("androidId", (String)com.tencent.mm.hellhoundlib.a.a.a(new Object(), ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "dev/fluttercommunity/plus/device_info/MethodCallHandlerImpl", "getAndroidId", "()Ljava/lang/String;", "android/provider/Settings$Secure", "getString", "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;"));
        paramMethodCall.put("systemFeatures", Arrays.asList(kkD()));
        localObject = new HashMap();
        if (Build.VERSION.SDK_INT >= 23)
        {
          ((Map)localObject).put("baseOS", Build.VERSION.BASE_OS);
          ((Map)localObject).put("previewSdkInt", Integer.valueOf(Build.VERSION.PREVIEW_SDK_INT));
          ((Map)localObject).put("securityPatch", Build.VERSION.SECURITY_PATCH);
        }
        ((Map)localObject).put("codename", Build.VERSION.CODENAME);
        ((Map)localObject).put("incremental", Build.VERSION.INCREMENTAL);
        ((Map)localObject).put("release", Build.VERSION.RELEASE);
        ((Map)localObject).put("sdkInt", Integer.valueOf(Build.VERSION.SDK_INT));
        paramMethodCall.put("version", localObject);
        paramResult.success(paramMethodCall);
        AppMethodBeat.o(186944);
        return;
        paramMethodCall.put("supported32BitAbis", Arrays.asList(aitj));
        paramMethodCall.put("supported64BitAbis", Arrays.asList(aitj));
        paramMethodCall.put("supportedAbis", Arrays.asList(aitj));
        break;
        label730:
        i = 0;
        break label438;
        label735:
        bool = false;
      }
    }
    paramResult.notImplemented();
    AppMethodBeat.o(186944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */