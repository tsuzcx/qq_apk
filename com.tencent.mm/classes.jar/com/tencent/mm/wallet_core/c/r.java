package com.tencent.mm.wallet_core.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

public abstract class r
  extends n
  implements k
{
  private static final String IdN = aj.getResources().getString(2131765901);
  protected int IdO = 0;
  protected String IdP;
  private WeakReference<MMActivity> aLG;
  protected g callback;
  protected int errCode = 0;
  protected String errMsg;
  protected int errType = 0;
  protected boolean nUQ = true;
  protected boolean nUR = false;
  protected b rr;
  
  public final r a(a parama)
  {
    if ((!this.nUQ) && (!this.nUR)) {
      parama.d(this.errCode, this.errType, this.errMsg, this);
    }
    return this;
  }
  
  public final r b(a parama)
  {
    if (this.nUR) {
      parama.d(this.errCode, this.errType, this.errMsg, this);
    }
    return this;
  }
  
  protected abstract void b(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public boolean bOO()
  {
    return false;
  }
  
  public final r c(a parama)
  {
    if (this.nUQ) {
      parama.d(this.errCode, this.errType, this.errMsg, this);
    }
    return this;
  }
  
  public boolean djn()
  {
    return true;
  }
  
  public boolean djo()
  {
    return true;
  }
  
  public int doScene(e parame, g paramg)
  {
    this.callback = paramg;
    Assert.assertNotNull("rr can't be null!", this.rr);
    return dispatch(parame, this.rr, this);
  }
  
  protected abstract void e(q paramq);
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, final String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.nUQ = false;
    }
    if (!this.nUQ)
    {
      e(paramq);
      if (this.IdO != 0) {
        this.nUR = true;
      }
    }
    this.errCode = paramInt3;
    this.errType = paramInt2;
    this.errMsg = paramString;
    ad.i("MicroMsg.NetSceneNewPayBase", "errType: %s, errCode: %s, errMsg: %s, retCode: %s, retMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.IdO), this.IdP });
    b(paramInt2, paramInt3, paramString, paramq);
    if (this.aLG != null)
    {
      paramString = (MMActivity)this.aLG.get();
      if (paramString != null)
      {
        if (!this.nUQ) {
          break label171;
        }
        ad.w("MicroMsg.NetSceneNewPayBase", "show net error alert");
      }
    }
    label171:
    do
    {
      h.a(paramString, IdN, null, false, new DialogInterface.OnClickListener()
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
      } while ((!this.nUR) || (bt.isNullOrNil(this.IdP)));
      if (bOO())
      {
        ad.w("MicroMsg.NetSceneNewPayBase", "show resp error toast");
        Toast.makeText(paramString, this.IdP, 1).show();
        return;
      }
    } while (!djo());
    ad.w("MicroMsg.NetSceneNewPayBase", "show resp error alert");
    h.a(paramString, this.IdP, null, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72793);
        if (r.this.djn()) {
          paramString.finish();
        }
        AppMethodBeat.o(72793);
      }
    });
  }
  
  public final void q(MMActivity paramMMActivity)
  {
    this.aLG = new WeakReference(paramMMActivity);
  }
  
  public static abstract interface a<T extends n>
  {
    public abstract void d(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.r
 * JD-Core Version:    0.7.0.1
 */