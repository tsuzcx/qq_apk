package com.tencent.mm.wallet_core.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.f;
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
  private static final String Lyt = aj.getResources().getString(2131765901);
  protected int Lyu = 0;
  protected String Lyv;
  private WeakReference<MMActivity> aWN;
  protected f callback;
  protected int errCode = 0;
  protected String errMsg;
  protected int errType = 0;
  protected boolean pbG = true;
  protected boolean pbH = false;
  protected b rr;
  
  public final r a(a parama)
  {
    if ((!this.pbG) && (!this.pbH)) {
      parama.d(this.errCode, this.errType, this.errMsg, this);
    }
    return this;
  }
  
  public final r b(a parama)
  {
    if (this.pbH) {
      parama.d(this.errCode, this.errType, this.errMsg, this);
    }
    return this;
  }
  
  protected abstract void b(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public final r c(a parama)
  {
    if (this.pbG) {
      parama.d(this.errCode, this.errType, this.errMsg, this);
    }
    return this;
  }
  
  public boolean caH()
  {
    return false;
  }
  
  public boolean dIG()
  {
    return true;
  }
  
  public boolean dIH()
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
      this.pbG = false;
    }
    if (!this.pbG)
    {
      e(paramq);
      if (this.Lyu != 0) {
        this.pbH = true;
      }
    }
    this.errCode = paramInt3;
    this.errType = paramInt2;
    this.errMsg = paramString;
    ad.i("MicroMsg.NetSceneNewPayBase", "errType: %s, errCode: %s, errMsg: %s, retCode: %s, retMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.Lyu), this.Lyv });
    b(paramInt2, paramInt3, paramString, paramq);
    if (this.aWN != null)
    {
      paramString = (MMActivity)this.aWN.get();
      if (paramString != null)
      {
        if (!this.pbG) {
          break label171;
        }
        ad.w("MicroMsg.NetSceneNewPayBase", "show net error alert");
      }
    }
    label171:
    do
    {
      h.a(paramString, Lyt, null, false, new DialogInterface.OnClickListener()
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
      } while ((!this.pbH) || (bt.isNullOrNil(this.Lyv)));
      if (caH())
      {
        ad.w("MicroMsg.NetSceneNewPayBase", "show resp error toast");
        Toast.makeText(paramString, this.Lyv, 1).show();
        return;
      }
    } while (!dIH());
    ad.w("MicroMsg.NetSceneNewPayBase", "show resp error alert");
    h.a(paramString, this.Lyv, null, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72793);
        if (r.this.dIG()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.r
 * JD-Core Version:    0.7.0.1
 */