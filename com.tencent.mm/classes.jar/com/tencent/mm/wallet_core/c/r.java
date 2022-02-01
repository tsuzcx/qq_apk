package com.tencent.mm.wallet_core.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

public abstract class r
  extends n
  implements k
{
  private static final String JFp = ai.getResources().getString(2131765901);
  protected int JFq = 0;
  protected String JFr;
  private WeakReference<MMActivity> aMw;
  protected g callback;
  protected int errCode = 0;
  protected String errMsg;
  protected int errType = 0;
  protected boolean oyl = true;
  protected boolean oym = false;
  protected b rr;
  
  public final r a(a parama)
  {
    if ((!this.oyl) && (!this.oym)) {
      parama.d(this.errCode, this.errType, this.errMsg, this);
    }
    return this;
  }
  
  public final r b(a parama)
  {
    if (this.oym) {
      parama.d(this.errCode, this.errType, this.errMsg, this);
    }
    return this;
  }
  
  protected abstract void b(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public boolean bWe()
  {
    return false;
  }
  
  public final r c(a parama)
  {
    if (this.oyl) {
      parama.d(this.errCode, this.errType, this.errMsg, this);
    }
    return this;
  }
  
  public int doScene(e parame, g paramg)
  {
    this.callback = paramg;
    Assert.assertNotNull("rr can't be null!", this.rr);
    return dispatch(parame, this.rr, this);
  }
  
  public boolean dxo()
  {
    return true;
  }
  
  public boolean dxp()
  {
    return true;
  }
  
  protected abstract void e(q paramq);
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, final String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.oyl = false;
    }
    if (!this.oyl)
    {
      e(paramq);
      if (this.JFq != 0) {
        this.oym = true;
      }
    }
    this.errCode = paramInt3;
    this.errType = paramInt2;
    this.errMsg = paramString;
    ac.i("MicroMsg.NetSceneNewPayBase", "errType: %s, errCode: %s, errMsg: %s, retCode: %s, retMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.JFq), this.JFr });
    b(paramInt2, paramInt3, paramString, paramq);
    if (this.aMw != null)
    {
      paramString = (MMActivity)this.aMw.get();
      if (paramString != null)
      {
        if (!this.oyl) {
          break label171;
        }
        ac.w("MicroMsg.NetSceneNewPayBase", "show net error alert");
      }
    }
    label171:
    do
    {
      h.a(paramString, JFp, null, false, new DialogInterface.OnClickListener()
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
      } while ((!this.oym) || (bs.isNullOrNil(this.JFr)));
      if (bWe())
      {
        ac.w("MicroMsg.NetSceneNewPayBase", "show resp error toast");
        Toast.makeText(paramString, this.JFr, 1).show();
        return;
      }
    } while (!dxp());
    ac.w("MicroMsg.NetSceneNewPayBase", "show resp error alert");
    h.a(paramString, this.JFr, null, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72793);
        if (r.this.dxo()) {
          paramString.finish();
        }
        AppMethodBeat.o(72793);
      }
    });
  }
  
  public final void r(MMActivity paramMMActivity)
  {
    this.aMw = new WeakReference(paramMMActivity);
  }
  
  public static abstract interface a<T extends n>
  {
    public abstract void d(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.r
 * JD-Core Version:    0.7.0.1
 */