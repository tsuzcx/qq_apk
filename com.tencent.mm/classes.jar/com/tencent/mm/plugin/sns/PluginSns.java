package com.tencent.mm.plugin.sns;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.plugin.sns.b.q;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.vfs.ab;

public class PluginSns
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.sns.b.c
{
  com.tencent.mm.plugin.sns.ad.a JwA;
  com.tencent.mm.plugin.sns.ad.b JwB;
  l Jwx;
  a Jwy;
  o Jwz;
  
  public PluginSns()
  {
    AppMethodBeat.i(94896);
    this.Jwx = new l();
    this.Jwy = new a();
    this.Jwz = new o();
    this.JwA = new com.tencent.mm.plugin.sns.ad.a();
    this.JwB = new com.tencent.mm.plugin.sns.ad.b();
    AppMethodBeat.o(94896);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(94898);
    h.aHH();
    h.b(k.class, this.Jwx);
    h.aHH();
    h.b(com.tencent.mm.plugin.sns.b.d.class, this.JwA);
    h.aHH();
    h.b(com.tencent.mm.plugin.sns.b.e.class, this.JwB);
    com.tencent.mm.plugin.sns.ad.a locala = this.JwA;
    locala.a(new com.tencent.mm.plugin.sns.ad.e.e());
    locala.a(new com.tencent.mm.plugin.sns.ad.e.d());
    locala.a(new com.tencent.mm.plugin.sns.ad.e.b());
    locala.a(new com.tencent.mm.plugin.sns.ad.e.c());
    if (paramg.aIE())
    {
      Log.i("MicroMsg.PluginSns", "PluginSns configure");
      ab.ov("sns", "sns");
      ab.a("sns_ad_landingpages", "sns_ad_landingpages", 2592000000L, 101);
      pin(new y(aj.class));
      h.aHH();
      h.b(com.tencent.mm.plugin.sns.b.a.class, this.Jwy);
      h.aHH();
      h.b(com.tencent.mm.plugin.sns.b.o.class, this.Jwz);
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
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(94899);
    com.tencent.mm.by.b.bsj("sns");
    AppMethodBeat.o(94899);
  }
  
  public String getAccSnsPath()
  {
    AppMethodBeat.i(179063);
    String str = h.aHG().kcB + "sns/";
    AppMethodBeat.o(179063);
    return str;
  }
  
  public String getAccSnsTmpPath()
  {
    AppMethodBeat.i(179064);
    String str = h.aHG().kcB + "sns/temp/";
    AppMethodBeat.o(179064);
    return str;
  }
  
  public String getSnsAdPath()
  {
    AppMethodBeat.i(179065);
    String str = h.aHG().kcB + "sns/sns_ad//";
    AppMethodBeat.o(179065);
    return str;
  }
  
  public q getUIManager()
  {
    AppMethodBeat.i(94901);
    p localp = p.fJw();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.PluginSns
 * JD-Core Version:    0.7.0.1
 */