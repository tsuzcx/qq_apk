package com.tencent.mm.plugin.qqmail.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.e.f;
import com.tencent.mm.sdk.platformtools.Log;

public class k
  implements i, b<Bundle, Bundle>
{
  private String BqZ;
  private d<Bundle> hny;
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(198592);
    Log.i("MicroMsg.UpdateMailStatusTask", "read mail, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!((f)paramq).BqZ.equals(this.BqZ))
    {
      Log.w("MicroMsg.UpdateMailStatusTask", "not my scene, ignore");
      AppMethodBeat.o(198592);
      return;
    }
    g.azz().b(11480, this);
    if (this.hny != null)
    {
      paramq = new Bundle();
      paramq.putInt("err_type", paramInt1);
      paramq.putInt("err_code", paramInt2);
      paramq.putString("err_msg", paramString);
      paramq.putString("mail_id", this.BqZ);
      this.hny.bn(paramq);
    }
    AppMethodBeat.o(198592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.c.k
 * JD-Core Version:    0.7.0.1
 */