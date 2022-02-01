package com.tencent.mm.wallet_core.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

public abstract class r
  extends n
  implements k
{
  private static final String LVi = ak.getResources().getString(2131765901);
  protected int LVj = 0;
  protected String LVk;
  private WeakReference<MMActivity> aWN;
  protected f callback;
  protected int errCode = 0;
  protected String errMsg;
  protected int errType = 0;
  protected boolean pil = true;
  protected boolean pim = false;
  protected b rr;
  
  public final r a(a parama)
  {
    if ((!this.pil) && (!this.pim)) {
      parama.d(this.errCode, this.errType, this.errMsg, this);
    }
    return this;
  }
  
  public final r b(a parama)
  {
    if (this.pim) {
      parama.d(this.errCode, this.errType, this.errMsg, this);
    }
    return this;
  }
  
  protected abstract void b(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public final r c(a parama)
  {
    if (this.pil) {
      parama.d(this.errCode, this.errType, this.errMsg, this);
    }
    return this;
  }
  
  public boolean cbW()
  {
    return false;
  }
  
  public boolean dLX()
  {
    return true;
  }
  
  public boolean dLY()
  {
    return true;
  }
  
  public int doScene(e parame, f paramf)
  {
    this.callback = paramf;
    Assert.assertNotNull("rr can't be null!", this.rr);
    return dispatch(parame, this.rr, this);
  }
  
  protected abstract void e(q paramq);
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, final String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.pil = false;
    }
    if (!this.pil)
    {
      e(paramq);
      if (this.LVj != 0) {
        this.pim = true;
      }
    }
    this.errCode = paramInt3;
    this.errType = paramInt2;
    this.errMsg = paramString;
    ae.i("MicroMsg.NetSceneNewPayBase", "errType: %s, errCode: %s, errMsg: %s, retCode: %s, retMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.LVj), this.LVk });
    b(paramInt2, paramInt3, paramString, paramq);
    if (this.aWN != null)
    {
      paramString = (MMActivity)this.aWN.get();
      if (paramString != null)
      {
        if (!this.pil) {
          break label171;
        }
        ae.w("MicroMsg.NetSceneNewPayBase", "show net error alert");
      }
    }
    label171:
    do
    {
      h.a(paramString, LVi, null, false, new DialogInterface.OnClickListener()
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
      } while ((!this.pim) || (bu.isNullOrNil(this.LVk)));
      if (cbW())
      {
        ae.w("MicroMsg.NetSceneNewPayBase", "show resp error toast");
        Toast.makeText(paramString, this.LVk, 1).show();
        return;
      }
    } while (!dLY());
    ae.w("MicroMsg.NetSceneNewPayBase", "show resp error alert");
    h.a(paramString, this.LVk, null, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72793);
        if (r.this.dLX()) {
          paramString.finish();
        }
        AppMethodBeat.o(72793);
      }
    });
  }
  
  public final void t(MMActivity paramMMActivity)
  {
    this.aWN = new WeakReference(paramMMActivity);
  }
  
  public static abstract interface a<T extends n>
  {
    public abstract void d(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.r
 * JD-Core Version:    0.7.0.1
 */