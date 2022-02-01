package com.tencent.mm.plugin.sns;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dc;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.sns.c.l;
import com.tencent.mm.plugin.sns.c.p;
import com.tencent.mm.plugin.sns.c.r;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.vfs.af;

public class PluginSns
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.sns.c.c
{
  c PJV;
  a PJW;
  d PJX;
  com.tencent.mm.plugin.sns.ad.b PJY;
  com.tencent.mm.plugin.sns.ad.c PJZ;
  private IListener PKa;
  
  public PluginSns()
  {
    AppMethodBeat.i(94896);
    this.PJV = new c();
    this.PJW = new a();
    this.PJX = new d();
    this.PJY = new com.tencent.mm.plugin.sns.ad.b();
    this.PJZ = new com.tencent.mm.plugin.sns.ad.c();
    this.PKa = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(94896);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(94898);
    h.baF();
    h.b(l.class, this.PJV);
    h.baF();
    h.b(com.tencent.mm.plugin.sns.c.d.class, this.PJY);
    h.baF();
    h.b(com.tencent.mm.plugin.sns.c.e.class, this.PJZ);
    com.tencent.mm.plugin.sns.ad.b localb = this.PJY;
    localb.a(new com.tencent.mm.plugin.sns.ad.e.e());
    localb.a(new com.tencent.mm.plugin.sns.ad.e.d());
    localb.a(new com.tencent.mm.plugin.sns.ad.e.b());
    localb.a(new com.tencent.mm.plugin.sns.ad.e.c());
    if (paramg.bbA())
    {
      Log.i("MicroMsg.PluginSns", "PluginSns configure");
      af.qt("sns", "sns");
      af.a("sns_ad_landingpages", "sns_ad_landingpages", 2592000000L, 101);
      pin(new y(al.class));
      h.baF();
      h.b(com.tencent.mm.plugin.sns.c.a.class, this.PJW);
      h.baF();
      h.b(p.class, this.PJX);
    }
    AppMethodBeat.o(94898);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(94897);
    dependsOn(com.tencent.mm.plugin.emoji.c.d.class);
    dependsOn(com.tencent.mm.plugin.normsg.a.class);
    AppMethodBeat.o(94897);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(94899);
    com.tencent.mm.br.b.bsa("sns");
    this.PKa.alive();
    AppMethodBeat.o(94899);
  }
  
  public String getAccSnsPath()
  {
    AppMethodBeat.i(179063);
    String str = h.baE().mCJ + "sns/";
    AppMethodBeat.o(179063);
    return str;
  }
  
  public String getAccSnsTmpPath()
  {
    AppMethodBeat.i(179064);
    String str = h.baE().mCJ + "sns/temp/";
    AppMethodBeat.o(179064);
    return str;
  }
  
  public String getSnsAdPath()
  {
    AppMethodBeat.i(179065);
    String str = h.baE().mCJ + "sns/sns_ad//";
    AppMethodBeat.o(179065);
    return str;
  }
  
  public r getUIManager()
  {
    AppMethodBeat.i(94901);
    e locale = e.gZq();
    AppMethodBeat.o(94901);
    return locale;
  }
  
  public MMFragment instantiateAlbumFragment(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(94900);
    paramContext = (MMFragment)Fragment.instantiate(paramContext, SnsAlbumUI.class.getName(), paramBundle);
    AppMethodBeat.o(94900);
    return paramContext;
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(306302);
    super.uninstalled();
    this.PKa.dead();
    AppMethodBeat.o(306302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.PluginSns
 * JD-Core Version:    0.7.0.1
 */