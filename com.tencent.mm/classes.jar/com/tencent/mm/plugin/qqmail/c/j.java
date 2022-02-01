package com.tencent.mm.plugin.qqmail.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.d.al;
import com.tencent.mm.plugin.qqmail.d.ba;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class j
  implements f, com.tencent.mm.ipcinvoker.b<IPCVoid, Bundle>
{
  private d<Bundle> gyc;
  private ArrayList<Bundle> uVW;
  private long xbg;
  private ArrayList<Bundle> xbh;
  private ArrayList<Bundle> xbi;
  
  public j()
  {
    AppMethodBeat.i(215189);
    this.uVW = new ArrayList();
    this.xbh = new ArrayList();
    this.xbi = new ArrayList();
    AppMethodBeat.o(215189);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(215190);
    ad.i("MicroMsg.SyncMailAddrTask", "search mail, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (((e)paramn).xdD != this.xbg)
    {
      ad.w("MicroMsg.SyncMailAddrTask", "not my scene, ignore");
      AppMethodBeat.o(215190);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Object localObject = ((ba)((e)paramn).hWL.hNL.hNQ).xdv;
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
          localBundle.putString("item_addr", localal.xcQ);
          this.uVW.add(localBundle);
        }
      }
      localObject = ((ba)((e)paramn).hWL.hNL.hNQ).xdw;
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localal = (al)((Iterator)localObject).next();
          localBundle = new Bundle();
          localBundle.putString("item_name", localal.nickname);
          localBundle.putString("item_addr", localal.xcQ);
          this.xbh.add(localBundle);
        }
      }
      localObject = ((ba)((e)paramn).hWL.hNL.hNQ).xdx;
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localal = (al)((Iterator)localObject).next();
          localBundle = new Bundle();
          localBundle.putString("item_name", localal.nickname);
          localBundle.putString("item_addr", localal.xcQ);
          this.xbi.add(localBundle);
        }
      }
      if (((ba)((e)paramn).hWL.hNL.hNQ).xdz)
      {
        this.xbg = ((ba)((e)paramn).hWL.hNL.hNQ).xdy;
        paramString = new e(this.xbg);
        g.aiU().a(paramString, 0);
        AppMethodBeat.o(215190);
        return;
      }
    }
    paramn = new Bundle();
    paramn.putInt("err_type", paramInt1);
    paramn.putInt("err_code", paramInt2);
    paramn.putString("err_msg", paramString);
    paramn.putParcelableArrayList("sync_add_list", this.uVW);
    paramn.putParcelableArrayList("sync_update_list", this.xbh);
    paramn.putParcelableArrayList("sync_delete_list", this.xbi);
    paramn.putLong("last_sync_key", this.xbg);
    if (this.gyc != null) {
      this.gyc.be(paramn);
    }
    AppMethodBeat.o(215190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.c.j
 * JD-Core Version:    0.7.0.1
 */