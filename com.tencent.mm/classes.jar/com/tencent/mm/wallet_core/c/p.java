package com.tencent.mm.wallet_core.c;

import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

public abstract class p
  extends m
  implements k
{
  private static final String AXa = ah.getResources().getString(2131305682);
  protected int AXb = 0;
  protected String AXc;
  private WeakReference<MMActivity> aqU;
  protected f callback;
  protected int errCode = 0;
  protected String errMsg;
  protected int errType = 0;
  protected boolean kOC = true;
  protected boolean kOD = false;
  protected b rr;
  
  public final p a(p.a parama)
  {
    if ((!this.kOC) && (!this.kOD)) {
      parama.d(this.errCode, this.errType, this.errMsg, this);
    }
    return this;
  }
  
  public final p b(p.a parama)
  {
    if (this.kOD) {
      parama.d(this.errCode, this.errType, this.errMsg, this);
    }
    return this;
  }
  
  protected abstract void b(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public boolean bhS()
  {
    return false;
  }
  
  public final p c(p.a parama)
  {
    if (this.kOC) {
      parama.d(this.errCode, this.errType, this.errMsg, this);
    }
    return this;
  }
  
  public int doScene(e parame, f paramf)
  {
    this.callback = paramf;
    Assert.assertNotNull("rr can't be null!", this.rr);
    return dispatch(parame, this.rr, this);
  }
  
  protected abstract void e(q paramq);
  
  public final void o(MMActivity paramMMActivity)
  {
    this.aqU = new WeakReference(paramMMActivity);
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.kOC = false;
    }
    if (!this.kOC)
    {
      e(paramq);
      if (this.AXb != 0) {
        this.kOD = true;
      }
    }
    this.errCode = paramInt3;
    this.errType = paramInt2;
    this.errMsg = paramString;
    ab.i("MicroMsg.NetSceneNewPayBase", "errType: %s, errCode: %s, errMsg: %s, retCode: %s, retMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.AXb), this.AXc });
    b(paramInt2, paramInt3, paramString, paramq);
    if (this.aqU != null)
    {
      paramString = (MMActivity)this.aqU.get();
      if (paramString != null)
      {
        if (!this.kOC) {
          break label171;
        }
        ab.w("MicroMsg.NetSceneNewPayBase", "show net error alert");
        h.a(paramString, AXa, null, false, new p.1(this, paramString));
      }
    }
    label171:
    while ((!this.kOD) || (bo.isNullOrNil(this.AXc))) {
      return;
    }
    if (bhS())
    {
      ab.w("MicroMsg.NetSceneNewPayBase", "show resp error toast");
      Toast.makeText(paramString, this.AXc, 1).show();
      return;
    }
    ab.w("MicroMsg.NetSceneNewPayBase", "show resp error alert");
    h.a(paramString, this.AXc, null, false, new p.2(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.p
 * JD-Core Version:    0.7.0.1
 */