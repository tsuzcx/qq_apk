package com.tencent.mm.plugin.qqmail.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.qqmail.d.al;
import com.tencent.mm.plugin.qqmail.d.ba;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class j
  implements i, com.tencent.mm.ipcinvoker.d<IPCVoid, Bundle>
{
  private ArrayList<Bundle> Edd;
  private long Hlt;
  private ArrayList<Bundle> Hlu;
  private ArrayList<Bundle> Hlv;
  private f<Bundle> jZn;
  
  public j()
  {
    AppMethodBeat.i(250322);
    this.Edd = new ArrayList();
    this.Hlu = new ArrayList();
    this.Hlv = new ArrayList();
    AppMethodBeat.o(250322);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(250327);
    Log.i("MicroMsg.SyncMailAddrTask", "search mail, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (((e)paramq).HnR != this.Hlt)
    {
      Log.w("MicroMsg.SyncMailAddrTask", "not my scene, ignore");
      AppMethodBeat.o(250327);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Object localObject = ((ba)d.c.b(((e)paramq).lKU.lBS)).HnJ;
      al localal;
      Bundle localBundle;
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localal = (al)((Iterator)localObject).next();
          localBundle = new Bundle();
          localBundle.putString("item_name", localal.nickname);
          localBundle.putString("item_addr", localal.Hne);
          this.Edd.add(localBundle);
        }
      }
      localObject = ((ba)d.c.b(((e)paramq).lKU.lBS)).HnK;
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localal = (al)((Iterator)localObject).next();
          localBundle = new Bundle();
          localBundle.putString("item_name", localal.nickname);
          localBundle.putString("item_addr", localal.Hne);
          this.Hlu.add(localBundle);
        }
      }
      localObject = ((ba)d.c.b(((e)paramq).lKU.lBS)).HnL;
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localal = (al)((Iterator)localObject).next();
          localBundle = new Bundle();
          localBundle.putString("item_name", localal.nickname);
          localBundle.putString("item_addr", localal.Hne);
          this.Hlv.add(localBundle);
        }
      }
      if (((ba)d.c.b(((e)paramq).lKU.lBS)).HnN)
      {
        this.Hlt = ((ba)d.c.b(((e)paramq).lKU.lBS)).HnM;
        paramString = new e(this.Hlt);
        h.aGY().a(paramString, 0);
        AppMethodBeat.o(250327);
        return;
      }
    }
    paramq = new Bundle();
    paramq.putInt("err_type", paramInt1);
    paramq.putInt("err_code", paramInt2);
    paramq.putString("err_msg", paramString);
    paramq.putParcelableArrayList("sync_add_list", this.Edd);
    paramq.putParcelableArrayList("sync_update_list", this.Hlu);
    paramq.putParcelableArrayList("sync_delete_list", this.Hlv);
    paramq.putLong("last_sync_key", this.Hlt);
    if (this.jZn != null) {
      this.jZn.aH(paramq);
    }
    AppMethodBeat.o(250327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.c.j
 * JD-Core Version:    0.7.0.1
 */