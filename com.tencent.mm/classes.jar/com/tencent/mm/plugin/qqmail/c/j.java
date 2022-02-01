package com.tencent.mm.plugin.qqmail.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.d.al;
import com.tencent.mm.plugin.qqmail.d.ba;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class j
  implements i, b<IPCVoid, Bundle>
{
  private long Bra;
  private ArrayList<Bundle> Brb;
  private ArrayList<Bundle> Brc;
  private com.tencent.mm.ipcinvoker.d<Bundle> hny;
  private ArrayList<Bundle> yBN;
  
  public j()
  {
    AppMethodBeat.i(198589);
    this.yBN = new ArrayList();
    this.Brb = new ArrayList();
    this.Brc = new ArrayList();
    AppMethodBeat.o(198589);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(198590);
    Log.i("MicroMsg.SyncMailAddrTask", "search mail, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (((e)paramq).Btx != this.Bra)
    {
      Log.w("MicroMsg.SyncMailAddrTask", "not my scene, ignore");
      AppMethodBeat.o(198590);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Object localObject = ((ba)((e)paramq).iUB.iLL.iLR).Btp;
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
          localBundle.putString("item_addr", localal.BsK);
          this.yBN.add(localBundle);
        }
      }
      localObject = ((ba)((e)paramq).iUB.iLL.iLR).Btq;
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localal = (al)((Iterator)localObject).next();
          localBundle = new Bundle();
          localBundle.putString("item_name", localal.nickname);
          localBundle.putString("item_addr", localal.BsK);
          this.Brb.add(localBundle);
        }
      }
      localObject = ((ba)((e)paramq).iUB.iLL.iLR).Btr;
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localal = (al)((Iterator)localObject).next();
          localBundle = new Bundle();
          localBundle.putString("item_name", localal.nickname);
          localBundle.putString("item_addr", localal.BsK);
          this.Brc.add(localBundle);
        }
      }
      if (((ba)((e)paramq).iUB.iLL.iLR).Btt)
      {
        this.Bra = ((ba)((e)paramq).iUB.iLL.iLR).Bts;
        paramString = new e(this.Bra);
        g.azz().a(paramString, 0);
        AppMethodBeat.o(198590);
        return;
      }
    }
    paramq = new Bundle();
    paramq.putInt("err_type", paramInt1);
    paramq.putInt("err_code", paramInt2);
    paramq.putString("err_msg", paramString);
    paramq.putParcelableArrayList("sync_add_list", this.yBN);
    paramq.putParcelableArrayList("sync_update_list", this.Brb);
    paramq.putParcelableArrayList("sync_delete_list", this.Brc);
    paramq.putLong("last_sync_key", this.Bra);
    if (this.hny != null) {
      this.hny.bn(paramq);
    }
    AppMethodBeat.o(198590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.c.j
 * JD-Core Version:    0.7.0.1
 */