package com.tencent.mm.plugin.webview.j;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y.b;
import com.tencent.mm.plugin.appbrand.y.p.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.k;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.ad;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.Arrays;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "Lcom/tencent/mm/plugin/appbrand/util/UserAgentUtil$Info;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "version", "", "identity", "Companion", "webview-sdk_release"})
public final class e
  implements p.a
{
  public static final a ELF;
  private static final f nUv;
  private final Context mContext;
  private String version;
  
  static
  {
    AppMethodBeat.i(214218);
    ELF = new a((byte)0);
    nUv = g.O((a)b.ELG);
    AppMethodBeat.o(214218);
  }
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(214217);
    this.mContext = paramContext;
    this.version = "";
    AppMethodBeat.o(214217);
  }
  
  public final String DZ()
  {
    return " MicroMessenger/";
  }
  
  public final String version()
  {
    AppMethodBeat.i(214216);
    Object localObject1;
    if (!TextUtils.isEmpty((CharSequence)this.version))
    {
      localObject1 = this.version;
      AppMethodBeat.o(214216);
      return localObject1;
    }
    try
    {
      localObject1 = b.getPackageInfo(this.mContext, ak.getPackageName());
      if (localObject1 != null)
      {
        Object localObject2 = this.version;
        this.version = ((String)localObject2 + k.aD(null, d.FFH));
        localObject2 = this.version;
        this.version = ((String)localObject2 + "." + ((PackageInfo)localObject1).versionCode);
        localObject1 = this.version;
        localObject1 = new StringBuilder().append((String)localObject1).append("(");
        localObject2 = ad.Njc;
        localObject2 = String.format("0x%08X", Arrays.copyOf(new Object[] { Integer.valueOf(d.FFH) }, 1));
        p.g(localObject2, "java.lang.String.format(format, *args)");
        this.version = ((String)localObject2 + "; MicroMessenger/Prefetcher 2.0)");
        localObject1 = this.version;
        this.version = ((String)localObject1 + " Process/mm");
        localObject1 = this.version;
        localObject2 = new StringBuilder().append((String)localObject1).append(" WeChat/");
        if (!com.tencent.mm.compatible.deviceinfo.q.is64BitRuntime()) {
          break label308;
        }
        localObject1 = "arm64";
        this.version = ((String)localObject1);
        if (k.fnT())
        {
          localObject1 = this.version;
          this.version = ((String)localObject1 + " GPVersion/1");
        }
      }
      localObject1 = this.version;
      AppMethodBeat.o(214216);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = null;
        continue;
        label308:
        str = "arm32";
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo$Companion;", "", "()V", "APPEND_USER_AGENT", "", "DEFAULT_UA_PREFIX", "WEB_PRE_FETCHER_VERSION", "WEB_PRE_KEY_USER_AGENT", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "updateUserAgentPrefix", "", "prefix", "webPrefetchUserAgentPrefix", "webview-sdk_release"})
  public static final class a
  {
    public static ay bOc()
    {
      AppMethodBeat.i(214214);
      Object localObject = e.eZB();
      a locala = e.ELF;
      localObject = (ay)((f)localObject).getValue();
      AppMethodBeat.o(214214);
      return localObject;
    }
    
    public static String eZC()
    {
      AppMethodBeat.i(214215);
      String str = bOc().getString("key_web_prefetch_ua", "Mozilla/5.0 (Linux; Android 9;) AppleWebKit/unknown (KHTML, like Gecko) Version/unknown Chrome/unknown Mobile Safari/unknown ");
      CharSequence localCharSequence = (CharSequence)str;
      if ((localCharSequence == null) || (n.aD(localCharSequence))) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(214215);
        return str;
      }
      AppMethodBeat.o(214215);
      return "Mozilla/5.0 (Linux; Android 9;) AppleWebKit/unknown (KHTML, like Gecko) Version/unknown Chrome/unknown Mobile Safari/unknown ";
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends d.g.b.q
    implements a<ay>
  {
    public static final b ELG;
    
    static
    {
      AppMethodBeat.i(214213);
      ELG = new b();
      AppMethodBeat.o(214213);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.e
 * JD-Core Version:    0.7.0.1
 */