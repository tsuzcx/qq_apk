package com.tencent.mm.ui.i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.ay.g.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.List;
import org.c.a.a.c.a;
import org.c.d.i;
import org.c.e.b;
import org.c.g.d;

@SuppressLint({"HandlerLeak"})
public final class a
  implements b.a
{
  Context context = null;
  ah oNg = new a.1(this);
  b wig = null;
  public i wih = null;
  i wii = null;
  private boolean wij = false;
  boolean wik = false;
  public a.b wil = null;
  public a.a wim = null;
  
  public a()
  {
    Object localObject = new org.c.a.a();
    ((org.c.a.a)localObject).xuq = org.c.a.a.an(c.a.class);
    d.hc("XMr2y8FEVEqZBcZ1TU3gLA", "Invalid Api key");
    ((org.c.a.a)localObject).xun = "XMr2y8FEVEqZBcZ1TU3gLA";
    d.hc("kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo", "Invalid Api secret");
    ((org.c.a.a)localObject).xuo = "kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo";
    d.l("wechatapp://sign-in-twitter.wechatapp.com/", "Callback can't be null");
    ((org.c.a.a)localObject).xup = "wechatapp://sign-in-twitter.wechatapp.com/";
    d.l(((org.c.a.a)localObject).xuq, "You must specify a valid api through the provider() method");
    d.hc(((org.c.a.a)localObject).xun, "You must provide an api key");
    d.hc(((org.c.a.a)localObject).xuo, "You must provide an api secret");
    this.wig = ((org.c.a.a)localObject).xuq.a(new org.c.d.a(((org.c.a.a)localObject).xun, ((org.c.a.a)localObject).xuo, ((org.c.a.a)localObject).xup, ((org.c.a.a)localObject).xur, ((org.c.a.a)localObject).scope, ((org.c.a.a)localObject).xus));
    String str;
    if (com.tencent.mm.kernel.g.DN().Dc())
    {
      localObject = (String)com.tencent.mm.kernel.g.DP().Dz().get(69377, null);
      str = (String)com.tencent.mm.kernel.g.DP().Dz().get(69378, null);
      if ((bk.bl((String)localObject)) || (bk.bl(str))) {
        localObject = null;
      }
    }
    for (;;)
    {
      this.wih = ((i)localObject);
      return;
      localObject = new i((String)localObject, str);
      continue;
      y.e("Twitter", "acchas not ready for restoreTwitterAccessToken");
      localObject = null;
    }
  }
  
  static void a(i parami)
  {
    ae.getContext().getSharedPreferences(ae.cqR(), 0);
    if (parami == null)
    {
      com.tencent.mm.kernel.g.DP().Dz().o(69377, "");
      com.tencent.mm.kernel.g.DP().Dz().o(69378, "");
      return;
    }
    com.tencent.mm.kernel.g.DP().Dz().o(69377, parami.token);
    com.tencent.mm.kernel.g.DP().Dz().o(69378, parami.tsv);
  }
  
  static void nN(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (String str = "1";; str = "2")
    {
      localArrayList.add(new g.a(10251, str));
      ((j)com.tencent.mm.kernel.g.r(j.class)).Fv().b(new com.tencent.mm.ay.g(localArrayList));
      return;
    }
  }
  
  public final void a(a.a parama)
  {
    if (this.wik) {
      return;
    }
    this.wim = parama;
    this.wik = true;
    com.tencent.mm.sdk.f.e.post(new a.3(this), "Twitter_validationAccessToken");
  }
  
  public final void a(a.b paramb, Context paramContext)
  {
    if (this.wij) {
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.a(583L, 0L, 1L, false);
    this.wil = paramb;
    this.context = paramContext;
    this.wij = true;
    com.tencent.mm.sdk.f.e.post(new a.2(this), "Twitter_doOAuth");
  }
  
  final void c(a.c paramc)
  {
    this.wij = false;
    this.wii = null;
    if (this.wil != null) {
      this.wil.a(paramc);
    }
  }
  
  public final boolean cJJ()
  {
    return this.wih != null;
  }
  
  public final void cJK()
  {
    nN(false);
    c(a.c.wir);
    com.tencent.mm.plugin.report.service.h.nFQ.a(583L, 2L, 1L, false);
  }
  
  public final void l(Bundle paramBundle)
  {
    com.tencent.mm.kernel.g.DS().O(new a.4(this, paramBundle));
  }
  
  public final void onCancel()
  {
    nN(false);
    c(a.c.wis);
    com.tencent.mm.plugin.report.service.h.nFQ.a(583L, 3L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.i.a
 * JD-Core Version:    0.7.0.1
 */