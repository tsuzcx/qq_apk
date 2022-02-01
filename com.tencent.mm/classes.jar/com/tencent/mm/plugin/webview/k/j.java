package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.af.b;
import com.tencent.mm.plugin.appbrand.af.r.a;
import com.tencent.mm.plugin.appbrand.luggage.b.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "Lcom/tencent/mm/plugin/appbrand/util/UserAgentUtil$Info;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "version", "", "identity", "Companion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  implements r.a
{
  public static final a Xta;
  private static final kotlin.j<MultiProcessMMKV> exj;
  private final Context mContext;
  private String version;
  
  static
  {
    AppMethodBeat.i(295691);
    Xta = new a((byte)0);
    exj = k.cm((a)b.Xtb);
    AppMethodBeat.o(295691);
  }
  
  public j(Context paramContext)
  {
    AppMethodBeat.i(295686);
    this.mContext = paramContext;
    this.version = "";
    AppMethodBeat.o(295686);
  }
  
  public final String aqA()
  {
    return " MicroMessenger/";
  }
  
  public final String version()
  {
    AppMethodBeat.i(295704);
    Object localObject1;
    if (!TextUtils.isEmpty((CharSequence)this.version))
    {
      localObject1 = this.version;
      AppMethodBeat.o(295704);
      return localObject1;
    }
    try
    {
      localObject1 = b.getPackageInfo(this.mContext, MMApplicationContext.getPackageName());
      if (localObject1 != null)
      {
        this.version = s.X(this.version, ChannelUtil.formatVersion(null, d.Yxh));
        this.version = (this.version + '.' + ((PackageInfo)localObject1).versionCode);
        localObject1 = new StringBuilder().append(this.version).append('(');
        Object localObject2 = am.aixg;
        localObject2 = String.format("0x%08X", Arrays.copyOf(new Object[] { Integer.valueOf(d.Yxh) }, 1));
        s.s(localObject2, "java.lang.String.format(format, *args)");
        this.version = ((String)localObject2 + "; MicroMessenger/Prefetcher 2.0)");
        this.version = s.X(this.version, " Process/mm");
        localObject2 = new StringBuilder().append(this.version).append(" WeChat/");
        if (!q.awm()) {
          break label311;
        }
        localObject1 = "arm64";
        this.version = ((String)localObject1);
        this.version = (this.version + ' ' + WeChatBrands.AppInfo.current().getUserAgent());
        if (ChannelUtil.isGPVersion()) {
          this.version = s.X(this.version, " GPVersion/1");
        }
      }
      localObject1 = e.adq(this.version);
      s.s(localObject1, "appendTabletTag(version)");
      this.version = ((String)localObject1);
      localObject1 = this.version;
      AppMethodBeat.o(295704);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = null;
        continue;
        label311:
        str = "arm32";
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo$Companion;", "", "()V", "APPEND_USER_AGENT", "", "DEFAULT_UA_PREFIX", "WEB_PRE_FETCHER_VERSION", "WEB_PRE_KEY_USER_AGENT", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "updateUserAgentPrefix", "", "prefix", "webPrefetchUserAgentPrefix", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static MultiProcessMMKV atj()
    {
      AppMethodBeat.i(295750);
      MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)j.bAs().getValue();
      AppMethodBeat.o(295750);
      return localMultiProcessMMKV;
    }
    
    public static String iCS()
    {
      AppMethodBeat.i(295756);
      String str = atj().getString("key_web_prefetch_ua", "Mozilla/5.0 (Linux; Android 9;) AppleWebKit/unknown (KHTML, like Gecko) Version/unknown Chrome/unknown Mobile Safari/unknown ");
      CharSequence localCharSequence = (CharSequence)str;
      if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(295756);
        return str;
      }
      AppMethodBeat.o(295756);
      return "Mozilla/5.0 (Linux; Android 9;) AppleWebKit/unknown (KHTML, like Gecko) Version/unknown Chrome/unknown Mobile Safari/unknown ";
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<MultiProcessMMKV>
  {
    public static final b Xtb;
    
    static
    {
      AppMethodBeat.i(295746);
      Xtb = new b();
      AppMethodBeat.o(295746);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.j
 * JD-Core Version:    0.7.0.1
 */