package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public final class n
  implements h
{
  private int mScene;
  private final g vhy;
  private final f vhz;
  private h.a viL;
  private d viM;
  private c viN;
  private String viO;
  private String viP;
  private final e viQ;
  private boolean viR;
  private boolean viS;
  private String viT;
  
  public n(g paramg)
  {
    AppMethodBeat.i(8255);
    this.mScene = 0;
    this.vhy = paramg;
    if (this.vhy.getIntent().getExtras() != null) {
      this.mScene = this.vhy.getIntent().getIntExtra("minimize_secene", this.mScene);
    }
    this.vhz = new n.1(this);
    this.viQ = new n.2(this);
    this.viR = this.vhy.getIntent().getBooleanExtra("from_bag", false);
    this.viT = this.vhy.getIntent().getStringExtra("from_bag_id");
    this.viP = this.vhy.getIntent().getStringExtra("from_bag_icon");
    if (dbs())
    {
      if (!this.viR)
      {
        ab.i("MicroMsg.WebViewUIBagHelper", "not from bag, can swipe to bag");
        this.viM = new d(this.vhy, this.vhz);
        AppMethodBeat.o(8255);
        return;
      }
      this.viN = new c(this.vhy, this.vhz);
      AppMethodBeat.o(8255);
      return;
    }
    ab.i("MicroMsg.WebViewUIBagHelper", "not support swipeback");
    AppMethodBeat.o(8255);
  }
  
  private void KF(int paramInt)
  {
    AppMethodBeat.i(8265);
    ab.v("MicroMsg.WebViewUIBagHelper", "kvReport op:%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.viL == null)
    {
      ab.w("MicroMsg.WebViewUIBagHelper", "kvReport mIPCDelegate null");
      AppMethodBeat.o(8265);
      return;
    }
    dfp();
    String str1 = this.viO;
    String str2 = this.viT;
    this.viL.z(new Object[] { str1, Integer.valueOf(paramInt), Integer.valueOf(0), str2 });
    AppMethodBeat.o(8265);
  }
  
  private Bundle KG(int paramInt)
  {
    AppMethodBeat.i(8262);
    Bundle localBundle = x(paramInt, new Bundle());
    AppMethodBeat.o(8262);
    return localBundle;
  }
  
  private boolean dbs()
  {
    AppMethodBeat.i(8266);
    boolean bool = this.vhy.dbs();
    AppMethodBeat.o(8266);
    return bool;
  }
  
  private void dfp()
  {
    AppMethodBeat.i(8264);
    if (bo.isNullOrNil(this.viO)) {
      this.viO = this.vhy.getUrl();
    }
    AppMethodBeat.o(8264);
  }
  
  private Bundle x(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(8263);
    if (9 != paramInt) {
      ab.i("MicroMsg.WebViewUIBagHelper", "Tools doBagLogic : %d, hashcode:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()) });
    }
    if (this.viL == null)
    {
      ab.w("MicroMsg.WebViewUIBagHelper", "doBagLogic mIPCDelegate null");
      AppMethodBeat.o(8263);
      return null;
    }
    paramBundle.putInt("key_action", paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramBundle = this.viL.ac(paramBundle);
      AppMethodBeat.o(8263);
      return paramBundle;
      this.viS = true;
      dfp();
      paramBundle.putString("key_url", this.viO);
      paramBundle.putString("key_bag_icon", this.viP);
      paramBundle.putInt("key_scene", this.mScene);
      paramBundle.putBundle("key_extras", k.aB(this.vhy.getIntent()));
      paramBundle.putBoolean("key_from_bag", this.viR);
      continue;
      paramBundle.putBoolean("key_in_webviewui_from_bag", true);
      continue;
      paramBundle.putBoolean("key_in_webviewui_from_bag", false);
      continue;
      paramBundle.putString("key_bag_id", this.viT);
      continue;
      this.viS = false;
    }
  }
  
  public final boolean KE(int paramInt)
  {
    AppMethodBeat.i(8258);
    boolean bool = dfg();
    ab.i("MicroMsg.WebViewUIBagHelper", "onWebViewClose hasBag:%b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      KF(paramInt);
      Point localPoint = (Point)KG(8).getParcelable("key_current_bag_pos");
      i.a(this.vhy, localPoint, this.viQ);
      AppMethodBeat.o(8258);
      return true;
    }
    AppMethodBeat.o(8258);
    return false;
  }
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(8256);
    ab.i("MicroMsg.WebViewUIBagHelper", "onIPCReady");
    this.viL = parama;
    if (!this.viR)
    {
      if ((dbs()) && (this.viM != null))
      {
        this.viM.start();
        AppMethodBeat.o(8256);
      }
    }
    else
    {
      KG(5);
      if ((dbs()) && (this.viN != null))
      {
        parama = this.viN;
        parama.vhy.a(new c.1(parama));
      }
    }
    AppMethodBeat.o(8256);
  }
  
  public final void aiE(String paramString)
  {
    this.viP = paramString;
  }
  
  public final void aiF(String paramString)
  {
    AppMethodBeat.i(8260);
    ab.i("MicroMsg.WebViewUIBagHelper", "updateUrl url:%s", new Object[] { paramString });
    this.viO = paramString;
    AppMethodBeat.o(8260);
  }
  
  public final void dff()
  {
    AppMethodBeat.i(8257);
    ab.i("MicroMsg.WebViewUIBagHelper", "onWebViewUIDestroy %b", new Object[] { Boolean.valueOf(this.viR) });
    KG(6);
    if (this.viM != null)
    {
      d locald = this.viM;
      al.d(new d.2(locald));
      locald.vhy.a(null);
      locald.vhy = null;
    }
    if (this.viR) {
      KG(3);
    }
    AppMethodBeat.o(8257);
  }
  
  public final boolean dfg()
  {
    AppMethodBeat.i(8261);
    ab.i("MicroMsg.WebViewUIBagHelper", "hasBagOfCurrentPage fromBag:%b，isTransformBag:%b, hashcode:%d", new Object[] { Boolean.valueOf(this.viR), Boolean.valueOf(this.viS), Integer.valueOf(hashCode()) });
    if (this.viS)
    {
      AppMethodBeat.o(8261);
      return true;
    }
    if (!this.viR)
    {
      AppMethodBeat.o(8261);
      return false;
    }
    Bundle localBundle = KG(7);
    if (localBundle == null)
    {
      AppMethodBeat.o(8261);
      return false;
    }
    boolean bool = localBundle.getBoolean("key_has_bag");
    ab.i("MicroMsg.WebViewUIBagHelper", "hasBagOfCurrentPage  hasBag:%b", new Object[] { Boolean.valueOf(bool) });
    if ((bool) && (this.viR))
    {
      AppMethodBeat.o(8261);
      return true;
    }
    AppMethodBeat.o(8261);
    return false;
  }
  
  public final void ow(boolean paramBoolean)
  {
    AppMethodBeat.i(8259);
    ab.i("MicroMsg.WebViewUIBagHelper", "onMenuMinimizeSelected cancelCurrentBag:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      KG(4);
      if (this.viN != null) {
        this.viN.vhy.a(null);
      }
      KF(18);
      com.tencent.mm.ui.widget.snackbar.b.l(this.vhy.getActivity(), this.vhy.getActivity().getString(2131302288));
      if (dbs())
      {
        this.viM = new d(this.vhy, this.vhz);
        this.viM.start();
      }
      AppMethodBeat.o(8259);
      return;
    }
    KF(16);
    Object localObject = KG(8);
    int i;
    if (localObject == null) {
      i = b.vhr;
    }
    for (localObject = new Point(i, i);; localObject = (Point)((Bundle)localObject).getParcelable("key_current_bag_pos"))
    {
      i.a(this.vhy, (Point)localObject, this.viQ);
      AppMethodBeat.o(8259);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.n
 * JD-Core Version:    0.7.0.1
 */