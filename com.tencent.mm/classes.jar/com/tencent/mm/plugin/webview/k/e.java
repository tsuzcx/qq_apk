package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.b;
import com.tencent.mm.plugin.appbrand.ac.p.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import java.util.Arrays;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "Lcom/tencent/mm/plugin/appbrand/util/UserAgentUtil$Info;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "version", "", "identity", "Companion", "webview-sdk_release"})
public final class e
  implements p.a
{
  public static final a JBw;
  private static final kotlin.f iBW;
  private final Context mContext;
  private String version;
  
  static
  {
    AppMethodBeat.i(225172);
    JBw = new a((byte)0);
    iBW = g.ah((a)b.JBx);
    AppMethodBeat.o(225172);
  }
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(225171);
    this.mContext = paramContext;
    this.version = "";
    AppMethodBeat.o(225171);
  }
  
  public final String Nv()
  {
    return " MicroMessenger/";
  }
  
  public final String version()
  {
    AppMethodBeat.i(225170);
    Object localObject1;
    if (!TextUtils.isEmpty((CharSequence)this.version))
    {
      localObject1 = this.version;
      AppMethodBeat.o(225170);
      return localObject1;
    }
    try
    {
      localObject1 = b.getPackageInfo(this.mContext, MMApplicationContext.getPackageName());
      if (localObject1 != null)
      {
        Object localObject2 = this.version;
        this.version = ((String)localObject2 + ChannelUtil.formatVersion(null, d.KyO));
        localObject2 = this.version;
        this.version = ((String)localObject2 + "." + ((PackageInfo)localObject1).versionCode);
        localObject1 = this.version;
        localObject1 = new StringBuilder().append((String)localObject1).append("(");
        localObject2 = ae.SYK;
        localObject2 = String.format("0x%08X", Arrays.copyOf(new Object[] { Integer.valueOf(d.KyO) }, 1));
        p.g(localObject2, "java.lang.String.format(format, *args)");
        this.version = ((String)localObject2 + "; MicroMessenger/Prefetcher 2.0)");
        localObject1 = this.version;
        this.version = ((String)localObject1 + " Process/mm");
        localObject1 = this.version;
        localObject2 = new StringBuilder().append((String)localObject1).append(" WeChat/");
        if (!com.tencent.mm.compatible.deviceinfo.q.is64BitRuntime()) {
          break label374;
        }
        localObject1 = "arm64";
        this.version = ((String)localObject1);
        localObject1 = this.version;
        localObject1 = new StringBuilder().append((String)localObject1).append(" ");
        localObject2 = WeChatBrands.AppInfo.current();
        p.g(localObject2, "WeChatBrands.AppInfo.current()");
        this.version = ((WeChatBrands.AppInfo.WhichApp)localObject2).getUserAgent();
        if (ChannelUtil.isGPVersion())
        {
          localObject1 = this.version;
          this.version = ((String)localObject1 + " GPVersion/1");
        }
      }
      localObject1 = com.tencent.mm.plugin.appbrand.luggage.b.f.acq(this.version);
      p.g(localObject1, "WeChatXWebUAInfo.appendTabletTag(version)");
      this.version = ((String)localObject1);
      localObject1 = this.version;
      AppMethodBeat.o(225170);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = null;
        continue;
        label374:
        str = "arm32";
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo$Companion;", "", "()V", "APPEND_USER_AGENT", "", "DEFAULT_UA_PREFIX", "WEB_PRE_FETCHER_VERSION", "WEB_PRE_KEY_USER_AGENT", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "updateUserAgentPrefix", "", "prefix", "webPrefetchUserAgentPrefix", "webview-sdk_release"})
  public static final class a
  {
    public static MultiProcessMMKV aTI()
    {
      AppMethodBeat.i(225168);
      Object localObject = e.aTC();
      a locala = e.JBw;
      localObject = (MultiProcessMMKV)((kotlin.f)localObject).getValue();
      AppMethodBeat.o(225168);
      return localObject;
    }
    
    public static String giH()
    {
      AppMethodBeat.i(225169);
      String str = aTI().getString("key_web_prefetch_ua", "Mozilla/5.0 (Linux; Android 9;) AppleWebKit/unknown (KHTML, like Gecko) Version/unknown Chrome/unknown Mobile Safari/unknown ");
      CharSequence localCharSequence = (CharSequence)str;
      if ((localCharSequence == null) || (n.aL(localCharSequence))) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(225169);
        return str;
      }
      AppMethodBeat.o(225169);
      return "Mozilla/5.0 (Linux; Android 9;) AppleWebKit/unknown (KHTML, like Gecko) Version/unknown Chrome/unknown Mobile Safari/unknown ";
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements a<MultiProcessMMKV>
  {
    public static final b JBx;
    
    static
    {
      AppMethodBeat.i(225167);
      JBx = new b();
      AppMethodBeat.o(225167);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.e
 * JD-Core Version:    0.7.0.1
 */