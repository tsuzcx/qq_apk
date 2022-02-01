package com.tencent.mm.plugin.webview.j;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.b;
import com.tencent.mm.plugin.appbrand.z.p.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.j;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.ad;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.Arrays;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "Lcom/tencent/mm/plugin/appbrand/util/UserAgentUtil$Info;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "version", "", "identity", "Companion", "webview-sdk_release"})
public final class e
  implements p.a
{
  public static final a Etl;
  private static final f nOP;
  private final Context mContext;
  private String version;
  
  static
  {
    AppMethodBeat.i(214377);
    Etl = new a((byte)0);
    nOP = g.O((a)b.Etm);
    AppMethodBeat.o(214377);
  }
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(214376);
    this.mContext = paramContext;
    this.version = "";
    AppMethodBeat.o(214376);
  }
  
  public final String DW()
  {
    return " MicroMessenger/";
  }
  
  public final String version()
  {
    AppMethodBeat.i(214375);
    Object localObject1;
    if (!TextUtils.isEmpty((CharSequence)this.version))
    {
      localObject1 = this.version;
      AppMethodBeat.o(214375);
      return localObject1;
    }
    try
    {
      localObject1 = b.getPackageInfo(this.mContext, aj.getPackageName());
      if (localObject1 != null)
      {
        Object localObject2 = this.version;
        this.version = ((String)localObject2 + j.aD(null, d.Fnj));
        localObject2 = this.version;
        this.version = ((String)localObject2 + "." + ((PackageInfo)localObject1).versionCode);
        localObject1 = this.version;
        localObject1 = new StringBuilder().append((String)localObject1).append("(");
        localObject2 = ad.MLZ;
        localObject2 = String.format("0x%08X", Arrays.copyOf(new Object[] { Integer.valueOf(d.Fnj) }, 1));
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
        if (j.fjZ())
        {
          localObject1 = this.version;
          this.version = ((String)localObject1 + " GPVersion/1");
        }
      }
      localObject1 = this.version;
      AppMethodBeat.o(214375);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo$Companion;", "", "()V", "APPEND_USER_AGENT", "", "DEFAULT_UA_PREFIX", "WEB_PRE_FETCHER_VERSION", "WEB_PRE_KEY_USER_AGENT", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "updateUserAgentPrefix", "", "prefix", "webPrefetchUserAgentPrefix", "webview-sdk_release"})
  public static final class a
  {
    public static ax bNe()
    {
      AppMethodBeat.i(214373);
      Object localObject = e.eVP();
      a locala = e.Etl;
      localObject = (ax)((f)localObject).getValue();
      AppMethodBeat.o(214373);
      return localObject;
    }
    
    public static String eVQ()
    {
      AppMethodBeat.i(214374);
      String str = bNe().getString("key_web_prefetch_ua", "Mozilla/5.0 (Linux; Android 9;) AppleWebKit/unknown (KHTML, like Gecko) Version/unknown Chrome/unknown Mobile Safari/unknown ");
      CharSequence localCharSequence = (CharSequence)str;
      if ((localCharSequence == null) || (n.aE(localCharSequence))) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(214374);
        return str;
      }
      AppMethodBeat.o(214374);
      return "Mozilla/5.0 (Linux; Android 9;) AppleWebKit/unknown (KHTML, like Gecko) Version/unknown Chrome/unknown Mobile Safari/unknown ";
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends d.g.b.q
    implements a<ax>
  {
    public static final b Etm;
    
    static
    {
      AppMethodBeat.i(214372);
      Etm = new b();
      AppMethodBeat.o(214372);
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