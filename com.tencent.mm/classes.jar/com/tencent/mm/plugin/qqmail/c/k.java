package com.tencent.mm.plugin.qqmail.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;

public class k
  implements i, d<Bundle, Bundle>
{
  private String Hls;
  private com.tencent.mm.ipcinvoker.f<Bundle> jZn;
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(249760);
    Log.i("MicroMsg.UpdateMailStatusTask", "read mail, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!((com.tencent.mm.plugin.qqmail.e.f)paramq).Hls.equals(this.Hls))
    {
      Log.w("MicroMsg.UpdateMailStatusTask", "not my scene, ignore");
      AppMethodBeat.o(249760);
      return;
    }
    h.aGY().b(11480, this);
    if (this.jZn != null)
    {
      paramq = new Bundle();
      paramq.putInt("err_type", paramInt1);
      paramq.putInt("err_code", paramInt2);
      paramq.putString("err_msg", paramString);
      paramq.putString("mail_id", this.Hls);
      this.jZn.aH(paramq);
    }
    AppMethodBeat.o(249760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.c.k
 * JD-Core Version:    0.7.0.1
 */