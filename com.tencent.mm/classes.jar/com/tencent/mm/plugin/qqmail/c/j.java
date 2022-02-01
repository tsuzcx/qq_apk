package com.tencent.mm.plugin.qqmail.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.d.al;
import com.tencent.mm.plugin.qqmail.d.ba;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class j
  implements f, com.tencent.mm.ipcinvoker.b<IPCVoid, Bundle>
{
  private d<Bundle> gAJ;
  private ArrayList<Bundle> vhJ;
  private long xqX;
  private ArrayList<Bundle> xqY;
  private ArrayList<Bundle> xqZ;
  
  public j()
  {
    AppMethodBeat.i(217935);
    this.vhJ = new ArrayList();
    this.xqY = new ArrayList();
    this.xqZ = new ArrayList();
    AppMethodBeat.o(217935);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(217936);
    ae.i("MicroMsg.SyncMailAddrTask", "search mail, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (((e)paramn).xtu != this.xqX)
    {
      ae.w("MicroMsg.SyncMailAddrTask", "not my scene, ignore");
      AppMethodBeat.o(217936);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Object localObject = ((ba)((e)paramn).hZD.hQE.hQJ).xtm;
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
          localBundle.putString("item_addr", localal.xsH);
          this.vhJ.add(localBundle);
        }
      }
      localObject = ((ba)((e)paramn).hZD.hQE.hQJ).xtn;
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localal = (al)((Iterator)localObject).next();
          localBundle = new Bundle();
          localBundle.putString("item_name", localal.nickname);
          localBundle.putString("item_addr", localal.xsH);
          this.xqY.add(localBundle);
        }
      }
      localObject = ((ba)((e)paramn).hZD.hQE.hQJ).xto;
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localal = (al)((Iterator)localObject).next();
          localBundle = new Bundle();
          localBundle.putString("item_name", localal.nickname);
          localBundle.putString("item_addr", localal.xsH);
          this.xqZ.add(localBundle);
        }
      }
      if (((ba)((e)paramn).hZD.hQE.hQJ).xtq)
      {
        this.xqX = ((ba)((e)paramn).hZD.hQE.hQJ).xtp;
        paramString = new e(this.xqX);
        g.ajj().a(paramString, 0);
        AppMethodBeat.o(217936);
        return;
      }
    }
    paramn = new Bundle();
    paramn.putInt("err_type", paramInt1);
    paramn.putInt("err_code", paramInt2);
    paramn.putString("err_msg", paramString);
    paramn.putParcelableArrayList("sync_add_list", this.vhJ);
    paramn.putParcelableArrayList("sync_update_list", this.xqY);
    paramn.putParcelableArrayList("sync_delete_list", this.xqZ);
    paramn.putLong("last_sync_key", this.xqX);
    if (this.gAJ != null) {
      this.gAJ.be(paramn);
    }
    AppMethodBeat.o(217936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.c.j
 * JD-Core Version:    0.7.0.1
 */