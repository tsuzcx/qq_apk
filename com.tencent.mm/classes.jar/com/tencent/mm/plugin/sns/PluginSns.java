package com.tencent.mm.plugin.sns;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.sns.ad.b.b;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMFragment;

public class PluginSns
  extends f
  implements com.tencent.mm.plugin.sns.b.c
{
  l xHh;
  a xHi;
  o xHj;
  com.tencent.mm.plugin.sns.ad.a xHk;
  
  public PluginSns()
  {
    AppMethodBeat.i(94896);
    this.xHh = new l();
    this.xHi = new a();
    this.xHj = new o();
    this.xHk = new com.tencent.mm.plugin.sns.ad.a();
    AppMethodBeat.o(94896);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(94898);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.b(j.class, this.xHh);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.sns.b.d.class, this.xHk);
    com.tencent.mm.plugin.sns.ad.a locala = this.xHk;
    locala.a(new com.tencent.mm.plugin.sns.ad.b.e());
    locala.a(new com.tencent.mm.plugin.sns.ad.b.d());
    locala.a(new b());
    locala.a(new com.tencent.mm.plugin.sns.ad.b.c());
    if (paramg.ahL())
    {
      ac.i("MicroMsg.PluginSns", "PluginSns configure");
      com.tencent.mm.vfs.o.md("sns", "sns");
      com.tencent.mm.vfs.o.b("sns_ad_landingpages", "sns_ad_landingpages", 2592000000L, 103);
      pin(new t(af.class));
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.sns.b.a.class, this.xHi);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.b(n.class, this.xHj);
    }
    AppMethodBeat.o(94898);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(94897);
    dependsOn(com.tencent.mm.plugin.emoji.b.d.class);
    dependsOn(com.tencent.mm.plugin.normsg.a.class);
    AppMethodBeat.o(94897);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(94899);
    com.tencent.mm.br.c.aIn("sns");
    AppMethodBeat.o(94899);
  }
  
  public String getAccSnsPath()
  {
    AppMethodBeat.i(179063);
    String str = com.tencent.mm.kernel.g.agR().ghC + "sns/";
    AppMethodBeat.o(179063);
    return str;
  }
  
  public String getAccSnsTmpPath()
  {
    AppMethodBeat.i(179064);
    String str = com.tencent.mm.kernel.g.agR().ghC + "sns/temp/";
    AppMethodBeat.o(179064);
    return str;
  }
  
  public String getSnsAdPath()
  {
    AppMethodBeat.i(179065);
    String str = com.tencent.mm.kernel.g.agR().ghC + "sns/sns_ad//";
    AppMethodBeat.o(179065);
    return str;
  }
  
  public com.tencent.mm.plugin.sns.b.p getUIManager()
  {
    AppMethodBeat.i(94901);
    p localp = p.dFu();
    AppMethodBeat.o(94901);
    return localp;
  }
  
  public MMFragment instantiateAlbumFragment(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(94900);
    paramContext = (MMFragment)Fragment.instantiate(paramContext, SnsAlbumUI.class.getName(), paramBundle);
    AppMethodBeat.o(94900);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.PluginSns
 * JD-Core Version:    0.7.0.1
 */