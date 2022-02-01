package com.tencent.mm.wallet_core.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

public abstract class r
  extends p
  implements m
{
  private static final String agTr = MMApplicationContext.getResources().getString(a.i.wallet_unknown_err);
  protected int agTs = 0;
  protected String agTt;
  protected h callback;
  private WeakReference<MMActivity> contextRef;
  protected int errCode = 0;
  protected String errMsg;
  protected int errType = 0;
  protected boolean oaK = true;
  protected c rr;
  protected boolean wZR = false;
  
  public final r a(a parama)
  {
    if ((!this.oaK) && (!this.wZR)) {
      parama.c(this.errCode, this.errType, this.errMsg, this);
    }
    return this;
  }
  
  public final r b(a parama)
  {
    if (this.wZR) {
      parama.c(this.errCode, this.errType, this.errMsg, this);
    }
    return this;
  }
  
  protected abstract void b(int paramInt1, int paramInt2, String paramString, s params);
  
  public final r c(a parama)
  {
    if (this.oaK) {
      parama.c(this.errCode, this.errType, this.errMsg, this);
    }
    return this;
  }
  
  public int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    this.callback = paramh;
    Assert.assertNotNull("rr can't be null!", this.rr);
    com.tencent.mm.wallet_core.ui.g.aGt(this.rr.getType());
    return dispatch(paramg, this.rr, this);
  }
  
  public boolean drV()
  {
    return false;
  }
  
  protected abstract void f(s params);
  
  public boolean gLA()
  {
    return true;
  }
  
  public boolean gLz()
  {
    return true;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, final String paramString, s params, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.oaK = false;
    }
    if (!this.oaK)
    {
      f(params);
      if (this.agTs != 0) {
        this.wZR = true;
      }
    }
    this.errCode = paramInt3;
    this.errType = paramInt2;
    this.errMsg = paramString;
    Log.i("MicroMsg.NetSceneNewPayBase", "errType: %s, errCode: %s, errMsg: %s, retCode: %s, retMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.agTs), this.agTt });
    b(paramInt2, paramInt3, paramString, params);
    com.tencent.mm.wallet_core.ui.g.aGu(params.getType());
    if (this.contextRef != null)
    {
      paramString = (MMActivity)this.contextRef.get();
      if (paramString != null)
      {
        if (!this.oaK) {
          break label181;
        }
        Log.w("MicroMsg.NetSceneNewPayBase", "show net error alert");
      }
    }
    label181:
    do
    {
      k.a(paramString, agTr, null, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72792);
          paramString.finish();
          AppMethodBeat.o(72792);
        }
      });
      do
      {
        return;
      } while ((!this.wZR) || (Util.isNullOrNil(this.agTt)));
      if (drV())
      {
        Log.w("MicroMsg.NetSceneNewPayBase", "show resp error toast");
        Toast.makeText(paramString, this.agTt, 1).show();
        return;
      }
    } while (!gLA());
    Log.w("MicroMsg.NetSceneNewPayBase", "show resp error alert");
    k.a(paramString, this.agTt, null, paramString.getResources().getString(a.i.wallet_offline_know_button), false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72793);
        if (r.this.gLz()) {
          paramString.finish();
        }
        AppMethodBeat.o(72793);
      }
    });
  }
  
  public final void r(MMActivity paramMMActivity)
  {
    this.contextRef = new WeakReference(paramMMActivity);
  }
  
  public static abstract interface a<T extends p>
  {
    public abstract void c(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.model.r
 * JD-Core Version:    0.7.0.1
 */