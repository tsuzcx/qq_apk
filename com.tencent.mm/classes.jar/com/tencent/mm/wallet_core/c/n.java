package com.tencent.mm.wallet_core.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

public abstract class n
  extends m
  implements k
{
  private static final String wAw = ae.getResources().getString(a.i.wallet_unknown_err);
  private WeakReference<MMActivity> aoB;
  protected String aox;
  public b dmK;
  public f dmL;
  protected int errCode = 0;
  protected int errType = 0;
  public boolean iHX = true;
  public boolean iHY = false;
  public int wAx = 0;
  public String wAy;
  
  public int a(e parame, f paramf)
  {
    this.dmL = paramf;
    Assert.assertNotNull("rr can't be null!", this.dmK);
    return a(parame, this.dmK, this);
  }
  
  public final n a(n.a parama)
  {
    if ((!this.iHX) && (!this.iHY)) {
      parama.f(this.errCode, this.errType, this.aox, this);
    }
    return this;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, final String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.iHX = false;
    }
    if (!this.iHX)
    {
      f(paramq);
      if (this.wAx != 0) {
        this.iHY = true;
      }
    }
    this.errCode = paramInt3;
    this.errType = paramInt2;
    this.aox = paramString;
    y.i("MicroMsg.NetSceneNewPayBase", "errType: %s, errCode: %s, errMsg: %s, retCode: %s, retMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.wAx), this.wAy });
    b(paramInt2, paramInt3, paramString, paramq);
    if (this.aoB != null)
    {
      paramString = (MMActivity)this.aoB.get();
      if (paramString != null)
      {
        if (!this.iHX) {
          break label171;
        }
        y.w("MicroMsg.NetSceneNewPayBase", "show net error alert");
        h.a(paramString, wAw, null, false, new n.1(this, paramString));
      }
    }
    label171:
    while ((!this.iHY) || (bk.bl(this.wAy))) {
      return;
    }
    if (aEE())
    {
      y.w("MicroMsg.NetSceneNewPayBase", "show resp error toast");
      Toast.makeText(paramString, this.wAy, 1).show();
      return;
    }
    y.w("MicroMsg.NetSceneNewPayBase", "show resp error alert");
    h.a(paramString, this.wAy, null, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramString.finish();
      }
    });
  }
  
  public boolean aEE()
  {
    return false;
  }
  
  public final n b(n.a parama)
  {
    if (this.iHY) {
      parama.f(this.errCode, this.errType, this.aox, this);
    }
    return this;
  }
  
  public abstract void b(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public final n c(n.a parama)
  {
    if (this.iHX) {
      parama.f(this.errCode, this.errType, this.aox, this);
    }
    return this;
  }
  
  public abstract void f(q paramq);
  
  public final void m(MMActivity paramMMActivity)
  {
    this.aoB = new WeakReference(paramMMActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.n
 * JD-Core Version:    0.7.0.1
 */