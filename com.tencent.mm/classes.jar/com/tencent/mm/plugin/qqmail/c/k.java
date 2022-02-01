package com.tencent.mm.plugin.qqmail.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;

public class k
  implements com.tencent.mm.ak.f, b<Bundle, Bundle>
{
  private d<Bundle> gAJ;
  private String xqW;
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(217938);
    ae.i("MicroMsg.UpdateMailStatusTask", "read mail, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!((com.tencent.mm.plugin.qqmail.e.f)paramn).xqW.equals(this.xqW))
    {
      ae.w("MicroMsg.UpdateMailStatusTask", "not my scene, ignore");
      AppMethodBeat.o(217938);
      return;
    }
    g.ajj().b(11480, this);
    if (this.gAJ != null)
    {
      paramn = new Bundle();
      paramn.putInt("err_type", paramInt1);
      paramn.putInt("err_code", paramInt2);
      paramn.putString("err_msg", paramString);
      paramn.putString("mail_id", this.xqW);
      this.gAJ.be(paramn);
    }
    AppMethodBeat.o(217938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.c.k
 * JD-Core Version:    0.7.0.1
 */