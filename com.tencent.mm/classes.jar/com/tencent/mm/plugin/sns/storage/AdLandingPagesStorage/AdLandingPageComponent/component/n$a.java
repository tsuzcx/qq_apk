package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Looper;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d;
import java.io.Serializable;

final class n$a
  extends d
  implements Serializable
{
  c oGg = new n.a.c(this);
  c oGh = new n.a.g(this);
  c oGi = new n.a.e(this);
  c oGj = new n.a.h(this);
  c oGk = new n.a.i(this);
  c oGl = new n.a.f(this);
  c oGm = new n.a.b(this);
  c oGn = new n.a.a(this);
  c oGo = new n.a.d(this);
  
  protected n$a(n paramn, String paramString)
  {
    super(paramString, Looper.getMainLooper());
    a(this.oGh);
    a(this.oGg);
    a(this.oGi);
    a(this.oGj);
    a(this.oGk);
    a(this.oGl);
    a(this.oGm);
    a(this.oGn);
    a(this.oGo);
    b(this.oGo);
    AdLandingPagesProxy.getInstance().addReportInfo(n.b(paramn).bOL, n.b(paramn).oAl, n.b(paramn).oAk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a
 * JD-Core Version:    0.7.0.1
 */