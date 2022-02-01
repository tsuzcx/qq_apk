package d.a.a.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  private Context applicationContext;
  private MethodChannel methodChannel;
  
  private String a(PackageManager paramPackageManager)
  {
    AppMethodBeat.i(186506);
    try
    {
      Object localObject;
      if (Build.VERSION.SDK_INT >= 28)
      {
        paramPackageManager = paramPackageManager.getPackageInfo(this.applicationContext.getPackageName(), 134217728);
        if (paramPackageManager != null)
        {
          localObject = paramPackageManager.signingInfo;
          if (localObject != null) {}
        }
        else
        {
          AppMethodBeat.o(186506);
          return null;
        }
        if (paramPackageManager.signingInfo.hasMultipleSigners())
        {
          paramPackageManager = dD(paramPackageManager.signingInfo.getApkContentsSigners()[0].toByteArray());
          AppMethodBeat.o(186506);
          return paramPackageManager;
        }
        paramPackageManager = dD(paramPackageManager.signingInfo.getSigningCertificateHistory()[0].toByteArray());
        AppMethodBeat.o(186506);
        return paramPackageManager;
      }
      paramPackageManager = paramPackageManager.getPackageInfo(this.applicationContext.getPackageName(), 64);
      if ((paramPackageManager != null) && (paramPackageManager.signatures != null) && (paramPackageManager.signatures.length != 0))
      {
        localObject = paramPackageManager.signatures[0];
        if (localObject != null) {}
      }
      else
      {
        AppMethodBeat.o(186506);
        return null;
      }
      paramPackageManager = dD(paramPackageManager.signatures[0].toByteArray());
      AppMethodBeat.o(186506);
      return paramPackageManager;
    }
    catch (NoSuchAlgorithmException paramPackageManager)
    {
      AppMethodBeat.o(186506);
      return null;
    }
    catch (PackageManager.NameNotFoundException paramPackageManager)
    {
      label175:
      break label175;
    }
  }
  
  private static String bytesToHex(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(186512);
    char[] arrayOfChar1 = new char[16];
    char[] tmp11_10 = arrayOfChar1;
    tmp11_10[0] = 48;
    char[] tmp16_11 = tmp11_10;
    tmp16_11[1] = 49;
    char[] tmp21_16 = tmp16_11;
    tmp21_16[2] = 50;
    char[] tmp26_21 = tmp21_16;
    tmp26_21[3] = 51;
    char[] tmp31_26 = tmp26_21;
    tmp31_26[4] = 52;
    char[] tmp36_31 = tmp31_26;
    tmp36_31[5] = 53;
    char[] tmp41_36 = tmp36_31;
    tmp41_36[6] = 54;
    char[] tmp47_41 = tmp41_36;
    tmp47_41[7] = 55;
    char[] tmp53_47 = tmp47_41;
    tmp53_47[8] = 56;
    char[] tmp59_53 = tmp53_47;
    tmp59_53[9] = 57;
    char[] tmp65_59 = tmp59_53;
    tmp65_59[10] = 65;
    char[] tmp71_65 = tmp65_59;
    tmp71_65[11] = 66;
    char[] tmp77_71 = tmp71_65;
    tmp77_71[12] = 67;
    char[] tmp83_77 = tmp77_71;
    tmp83_77[13] = 68;
    char[] tmp89_83 = tmp83_77;
    tmp89_83[14] = 69;
    char[] tmp95_89 = tmp89_83;
    tmp95_89[15] = 70;
    tmp95_89;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfChar2[(i * 2)] = arrayOfChar1[(j >>> 4)];
      arrayOfChar2[(i * 2 + 1)] = arrayOfChar1[(j & 0xF)];
      i += 1;
    }
    paramArrayOfByte = new String(arrayOfChar2);
    AppMethodBeat.o(186512);
    return paramArrayOfByte;
  }
  
  private static String dD(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(186514);
    MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
    localMessageDigest.update(paramArrayOfByte);
    paramArrayOfByte = bytesToHex(localMessageDigest.digest());
    AppMethodBeat.o(186514);
    return paramArrayOfByte;
  }
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(186517);
    this.applicationContext = paramFlutterPluginBinding.getApplicationContext();
    this.methodChannel = new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "dev.fluttercommunity.plus/package_info");
    this.methodChannel.setMethodCallHandler(this);
    AppMethodBeat.o(186517);
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(186518);
    this.applicationContext = null;
    this.methodChannel.setMethodCallHandler(null);
    this.methodChannel = null;
    AppMethodBeat.o(186518);
  }
  
  public final void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    AppMethodBeat.i(186519);
    try
    {
      if (paramMethodCall.method.equals("getAll"))
      {
        paramMethodCall = this.applicationContext.getPackageManager();
        PackageInfo localPackageInfo = paramMethodCall.getPackageInfo(this.applicationContext.getPackageName(), 0);
        String str = a(paramMethodCall);
        HashMap localHashMap = new HashMap();
        localHashMap.put("appName", localPackageInfo.applicationInfo.loadLabel(paramMethodCall).toString());
        localHashMap.put("packageName", this.applicationContext.getPackageName());
        localHashMap.put("version", localPackageInfo.versionName);
        if (Build.VERSION.SDK_INT >= 28) {}
        for (long l = localPackageInfo.getLongVersionCode();; l = localPackageInfo.versionCode)
        {
          localHashMap.put("buildNumber", String.valueOf(l));
          if (str != null) {
            localHashMap.put("buildSignature", str);
          }
          paramResult.success(localHashMap);
          AppMethodBeat.o(186519);
          return;
        }
      }
      paramResult.notImplemented();
      AppMethodBeat.o(186519);
      return;
    }
    catch (PackageManager.NameNotFoundException paramMethodCall)
    {
      paramResult.error("Name not found", paramMethodCall.getMessage(), null);
      AppMethodBeat.o(186519);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */