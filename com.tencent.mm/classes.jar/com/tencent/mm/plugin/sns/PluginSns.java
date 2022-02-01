package com.tencent.mm.plugin.sns;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.sns.ad.d.b;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMFragment;

public class PluginSns
  extends f
  implements com.tencent.mm.plugin.sns.b.c
{
  l zmb;
  a zmc;
  o zmd;
  com.tencent.mm.plugin.sns.ad.a zme;
  
  public PluginSns()
  {
    AppMethodBeat.i(94896);
    this.zmb = new l();
    this.zmc = new a();
    this.zmd = new o();
    this.zme = new com.tencent.mm.plugin.sns.ad.a();
    AppMethodBeat.o(94896);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(94898);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.b(j.class, this.zmb);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.sns.b.d.class, this.zme);
    com.tencent.mm.plugin.sns.ad.a locala = this.zme;
    locala.a(new com.tencent.mm.plugin.sns.ad.d.e());
    locala.a(new com.tencent.mm.plugin.sns.ad.d.d());
    locala.a(new b());
    locala.a(new com.tencent.mm.plugin.sns.ad.d.c());
    if (paramg.akL())
    {
      ae.i("MicroMsg.PluginSns", "PluginSns configure");
      com.tencent.mm.vfs.u.mJ("sns", "sns");
      com.tencent.mm.vfs.u.b("sns_ad_landingpages", "sns_ad_landingpages", 2592000000L, 103);
      pin(new com.tencent.mm.model.u(ah.class));
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.sns.b.a.class, this.zmc);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.b(n.class, this.zmd);
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
    com.tencent.mm.br.c.aPn("sns");
    AppMethodBeat.o(94899);
  }
  
  public String getAccSnsPath()
  {
    AppMethodBeat.i(179063);
    String str = com.tencent.mm.kernel.g.ajR().gDT + "sns/";
    AppMethodBeat.o(179063);
    return str;
  }
  
  public String getAccSnsTmpPath()
  {
    AppMethodBeat.i(179064);
    String str = com.tencent.mm.kernel.g.ajR().gDT + "sns/temp/";
    AppMethodBeat.o(179064);
    return str;
  }
  
  public String getSnsAdPath()
  {
    AppMethodBeat.i(179065);
    String str = com.tencent.mm.kernel.g.ajR().gDT + "sns/sns_ad//";
    AppMethodBeat.o(179065);
    return str;
  }
  
  public com.tencent.mm.plugin.sns.b.p getUIManager()
  {
    AppMethodBeat.i(94901);
    p localp = p.dUt();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.PluginSns
 * JD-Core Version:    0.7.0.1
 */