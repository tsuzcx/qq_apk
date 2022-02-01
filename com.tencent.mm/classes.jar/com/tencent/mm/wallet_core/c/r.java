package com.tencent.mm.wallet_core.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

public abstract class r
  extends q
  implements m
{
  private static final String YVx = MMApplicationContext.getResources().getString(a.i.wallet_unknown_err);
  protected int YVy = 0;
  protected String YVz;
  private WeakReference<MMActivity> aFX;
  protected i callback;
  protected int errCode = 0;
  protected String errMsg;
  protected int errType = 0;
  protected d rr;
  protected boolean tWx = true;
  protected boolean tWy = false;
  
  public final r a(a parama)
  {
    if ((!this.tWx) && (!this.tWy)) {
      parama.e(this.errCode, this.errType, this.errMsg, this);
    }
    return this;
  }
  
  public final r b(a parama)
  {
    if (this.tWy) {
      parama.e(this.errCode, this.errType, this.errMsg, this);
    }
    return this;
  }
  
  protected abstract void b(int paramInt1, int paramInt2, String paramString, s params);
  
  public final r c(a parama)
  {
    if (this.tWx) {
      parama.e(this.errCode, this.errType, this.errMsg, this);
    }
    return this;
  }
  
  public boolean cOq()
  {
    return false;
  }
  
  public int doScene(g paramg, i parami)
  {
    this.callback = parami;
    Assert.assertNotNull("rr can't be null!", this.rr);
    return dispatch(paramg, this.rr, this);
  }
  
  protected abstract void f(s params);
  
  public boolean fzN()
  {
    return true;
  }
  
  public boolean fzO()
  {
    return true;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, final String paramString, s params, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.tWx = false;
    }
    if (!this.tWx)
    {
      f(params);
      if (this.YVy != 0) {
        this.tWy = true;
      }
    }
    this.errCode = paramInt3;
    this.errType = paramInt2;
    this.errMsg = paramString;
    Log.i("MicroMsg.NetSceneNewPayBase", "errType: %s, errCode: %s, errMsg: %s, retCode: %s, retMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.YVy), this.YVz });
    b(paramInt2, paramInt3, paramString, params);
    if (this.aFX != null)
    {
      paramString = (MMActivity)this.aFX.get();
      if (paramString != null)
      {
        if (!this.tWx) {
          break label171;
        }
        Log.w("MicroMsg.NetSceneNewPayBase", "show net error alert");
      }
    }
    label171:
    do
    {
      h.a(paramString, YVx, null, false, new DialogInterface.OnClickListener()
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
      } while ((!this.tWy) || (Util.isNullOrNil(this.YVz)));
      if (cOq())
      {
        Log.w("MicroMsg.NetSceneNewPayBase", "show resp error toast");
        Toast.makeText(paramString, this.YVz, 1).show();
        return;
      }
    } while (!fzO());
    Log.w("MicroMsg.NetSceneNewPayBase", "show resp error alert");
    h.a(paramString, this.YVz, null, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72793);
        if (r.this.fzN()) {
          paramString.finish();
        }
        AppMethodBeat.o(72793);
      }
    });
  }
  
  public final void u(MMActivity paramMMActivity)
  {
    this.aFX = new WeakReference(paramMMActivity);
  }
  
  public static abstract interface a<T extends q>
  {
    public abstract void e(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.r
 * JD-Core Version:    0.7.0.1
 */