package com.tencent.mm.plugin.qqmail.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;

public class k
  implements com.tencent.mm.al.f, b<Bundle, Bundle>
{
  private d<Bundle> gyc;
  private String xbf;
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(215192);
    ad.i("MicroMsg.UpdateMailStatusTask", "read mail, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!((com.tencent.mm.plugin.qqmail.e.f)paramn).xbf.equals(this.xbf))
    {
      ad.w("MicroMsg.UpdateMailStatusTask", "not my scene, ignore");
      AppMethodBeat.o(215192);
      return;
    }
    g.aiU().b(11480, this);
    if (this.gyc != null)
    {
      paramn = new Bundle();
      paramn.putInt("err_type", paramInt1);
      paramn.putInt("err_code", paramInt2);
      paramn.putString("err_msg", paramString);
      paramn.putString("mail_id", this.xbf);
      this.gyc.be(paramn);
    }
    AppMethodBeat.o(215192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.c.k
 * JD-Core Version:    0.7.0.1
 */