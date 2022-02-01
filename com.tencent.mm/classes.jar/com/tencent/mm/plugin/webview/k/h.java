package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.b;
import com.tencent.mm.plugin.appbrand.ac.p.a;
import com.tencent.mm.plugin.appbrand.luggage.b.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import java.util.Arrays;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "Lcom/tencent/mm/plugin/appbrand/util/UserAgentUtil$Info;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "version", "", "identity", "Companion", "webview-sdk_release"})
public final class h
  implements p.a
{
  public static final a QAa;
  private static final f lrB;
  private final Context mContext;
  private String version;
  
  static
  {
    AppMethodBeat.i(206794);
    QAa = new a((byte)0);
    lrB = g.ar((a)b.QAb);
    AppMethodBeat.o(206794);
  }
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(206793);
    this.mContext = paramContext;
    this.version = "";
    AppMethodBeat.o(206793);
  }
  
  public final String Qq()
  {
    return " MicroMessenger/";
  }
  
  public final String version()
  {
    AppMethodBeat.i(206792);
    Object localObject1;
    if (!TextUtils.isEmpty((CharSequence)this.version))
    {
      localObject1 = this.version;
      AppMethodBeat.o(206792);
      return localObject1;
    }
    try
    {
      localObject1 = b.getPackageInfo(this.mContext, MMApplicationContext.getPackageName());
      if (localObject1 != null)
      {
        Object localObject2 = this.version;
        this.version = ((String)localObject2 + ChannelUtil.formatVersion(null, d.RAD));
        localObject2 = this.version;
        this.version = ((String)localObject2 + "." + ((PackageInfo)localObject1).versionCode);
        localObject1 = this.version;
        localObject1 = new StringBuilder().append((String)localObject1).append("(");
        localObject2 = af.aaBG;
        localObject2 = String.format("0x%08X", Arrays.copyOf(new Object[] { Integer.valueOf(d.RAD) }, 1));
        p.j(localObject2, "java.lang.String.format(format, *args)");
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
        p.j(localObject2, "WeChatBrands.AppInfo.current()");
        this.version = ((WeChatBrands.AppInfo.WhichApp)localObject2).getUserAgent();
        if (ChannelUtil.isGPVersion())
        {
          localObject1 = this.version;
          this.version = ((String)localObject1 + " GPVersion/1");
        }
      }
      localObject1 = e.akk(this.version);
      p.j(localObject1, "WeChatXWebUAInfo.appendTabletTag(version)");
      this.version = ((String)localObject1);
      localObject1 = this.version;
      AppMethodBeat.o(206792);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo$Companion;", "", "()V", "APPEND_USER_AGENT", "", "DEFAULT_UA_PREFIX", "WEB_PRE_FETCHER_VERSION", "WEB_PRE_KEY_USER_AGENT", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "updateUserAgentPrefix", "", "prefix", "webPrefetchUserAgentPrefix", "webview-sdk_release"})
  public static final class a
  {
    public static MultiProcessMMKV bcJ()
    {
      AppMethodBeat.i(208951);
      Object localObject = h.bcB();
      a locala = h.QAa;
      localObject = (MultiProcessMMKV)((f)localObject).getValue();
      AppMethodBeat.o(208951);
      return localObject;
    }
    
    public static String hcr()
    {
      AppMethodBeat.i(208954);
      String str = bcJ().getString("key_web_prefetch_ua", "Mozilla/5.0 (Linux; Android 9;) AppleWebKit/unknown (KHTML, like Gecko) Version/unknown Chrome/unknown Mobile Safari/unknown ");
      CharSequence localCharSequence = (CharSequence)str;
      if ((localCharSequence == null) || (n.ba(localCharSequence))) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(208954);
        return str;
      }
      AppMethodBeat.o(208954);
      return "Mozilla/5.0 (Linux; Android 9;) AppleWebKit/unknown (KHTML, like Gecko) Version/unknown Chrome/unknown Mobile Safari/unknown ";
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements a<MultiProcessMMKV>
  {
    public static final b QAb;
    
    static
    {
      AppMethodBeat.i(213900);
      QAb = new b();
      AppMethodBeat.o(213900);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.h
 * JD-Core Version:    0.7.0.1
 */