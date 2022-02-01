package com.tencent.mm.wallet_core.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
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
  private static final String RtY = MMApplicationContext.getResources().getString(2131768354);
  protected int RtZ = 0;
  protected String Rua;
  private WeakReference<MMActivity> aWF;
  protected i callback;
  protected int errCode = 0;
  protected String errMsg;
  protected int errType = 0;
  protected boolean qxx = true;
  protected boolean qxy = false;
  protected d rr;
  
  public final r a(a parama)
  {
    if ((!this.qxx) && (!this.qxy)) {
      parama.d(this.errCode, this.errType, this.errMsg, this);
    }
    return this;
  }
  
  public final r b(a parama)
  {
    if (this.qxy) {
      parama.d(this.errCode, this.errType, this.errMsg, this);
    }
    return this;
  }
  
  protected abstract void b(int paramInt1, int paramInt2, String paramString, s params);
  
  public final r c(a parama)
  {
    if (this.qxx) {
      parama.d(this.errCode, this.errType, this.errMsg, this);
    }
    return this;
  }
  
  public boolean czQ()
  {
    return false;
  }
  
  public int doScene(g paramg, i parami)
  {
    this.callback = parami;
    Assert.assertNotNull("rr can't be null!", this.rr);
    return dispatch(paramg, this.rr, this);
  }
  
  protected abstract void e(s params);
  
  public boolean eMY()
  {
    return true;
  }
  
  public boolean eMZ()
  {
    return true;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, final String paramString, s params, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.qxx = false;
    }
    if (!this.qxx)
    {
      e(params);
      if (this.RtZ != 0) {
        this.qxy = true;
      }
    }
    this.errCode = paramInt3;
    this.errType = paramInt2;
    this.errMsg = paramString;
    Log.i("MicroMsg.NetSceneNewPayBase", "errType: %s, errCode: %s, errMsg: %s, retCode: %s, retMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.RtZ), this.Rua });
    b(paramInt2, paramInt3, paramString, params);
    if (this.aWF != null)
    {
      paramString = (MMActivity)this.aWF.get();
      if (paramString != null)
      {
        if (!this.qxx) {
          break label171;
        }
        Log.w("MicroMsg.NetSceneNewPayBase", "show net error alert");
      }
    }
    label171:
    do
    {
      h.a(paramString, RtY, null, false, new DialogInterface.OnClickListener()
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
      } while ((!this.qxy) || (Util.isNullOrNil(this.Rua)));
      if (czQ())
      {
        Log.w("MicroMsg.NetSceneNewPayBase", "show resp error toast");
        Toast.makeText(paramString, this.Rua, 1).show();
        return;
      }
    } while (!eMZ());
    Log.w("MicroMsg.NetSceneNewPayBase", "show resp error alert");
    h.a(paramString, this.Rua, null, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72793);
        if (r.this.eMY()) {
          paramString.finish();
        }
        AppMethodBeat.o(72793);
      }
    });
  }
  
  public final void t(MMActivity paramMMActivity)
  {
    this.aWF = new WeakReference(paramMMActivity);
  }
  
  public static abstract interface a<T extends q>
  {
    public abstract void d(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.r
 * JD-Core Version:    0.7.0.1
 */