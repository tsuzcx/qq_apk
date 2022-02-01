package com.tencent.mm.plugin.qqmail.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.qqmail.d.e;
import com.tencent.mm.plugin.qqmail.model.ak;
import com.tencent.mm.plugin.qqmail.model.az;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class j
  implements com.tencent.mm.am.h, d<IPCVoid, Bundle>
{
  private ArrayList<Bundle> JTY;
  private long Njh;
  private ArrayList<Bundle> Nji;
  private ArrayList<Bundle> Njj;
  private f<Bundle> mzo;
  
  public j()
  {
    AppMethodBeat.i(266863);
    this.JTY = new ArrayList();
    this.Nji = new ArrayList();
    this.Njj = new ArrayList();
    AppMethodBeat.o(266863);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(266870);
    Log.i("MicroMsg.SyncMailAddrTask", "search mail, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (((e)paramp).NlE != this.Njh)
    {
      Log.w("MicroMsg.SyncMailAddrTask", "not my scene, ignore");
      AppMethodBeat.o(266870);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Object localObject = ((az)c.c.b(((e)paramp).oDw.otC)).Nlx;
      ak localak;
      Bundle localBundle;
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localak = (ak)((Iterator)localObject).next();
          localBundle = new Bundle();
          localBundle.putString("item_name", localak.nickname);
          localBundle.putString("item_addr", localak.NkS);
          this.JTY.add(localBundle);
        }
      }
      localObject = ((az)c.c.b(((e)paramp).oDw.otC)).Nly;
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localak = (ak)((Iterator)localObject).next();
          localBundle = new Bundle();
          localBundle.putString("item_name", localak.nickname);
          localBundle.putString("item_addr", localak.NkS);
          this.Nji.add(localBundle);
        }
      }
      localObject = ((az)c.c.b(((e)paramp).oDw.otC)).Nlz;
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localak = (ak)((Iterator)localObject).next();
          localBundle = new Bundle();
          localBundle.putString("item_name", localak.nickname);
          localBundle.putString("item_addr", localak.NkS);
          this.Njj.add(localBundle);
        }
      }
      if (((az)c.c.b(((e)paramp).oDw.otC)).NlB)
      {
        this.Njh = ((az)c.c.b(((e)paramp).oDw.otC)).NlA;
        paramString = new e(this.Njh);
        com.tencent.mm.kernel.h.aZW().a(paramString, 0);
        AppMethodBeat.o(266870);
        return;
      }
    }
    paramp = new Bundle();
    paramp.putInt("err_type", paramInt1);
    paramp.putInt("err_code", paramInt2);
    paramp.putString("err_msg", paramString);
    paramp.putParcelableArrayList("sync_add_list", this.JTY);
    paramp.putParcelableArrayList("sync_update_list", this.Nji);
    paramp.putParcelableArrayList("sync_delete_list", this.Njj);
    paramp.putLong("last_sync_key", this.Njh);
    if (this.mzo != null) {
      this.mzo.onCallback(paramp);
    }
    AppMethodBeat.o(266870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.c.j
 * JD-Core Version:    0.7.0.1
 */