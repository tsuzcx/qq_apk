package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.sns.k.l;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.ffm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aw
  implements com.tencent.mm.am.h
{
  public List<Long> Qxu;
  public l Qxv;
  public int Qxw;
  private final String TAG;
  private boolean readyForDisplay;
  
  public aw()
  {
    AppMethodBeat.i(309440);
    this.TAG = "MicroMsg.SnsUnreadPreloader";
    this.Qxu = new ArrayList();
    this.Qxv = null;
    this.readyForDisplay = false;
    this.Qxw = 50;
    AppMethodBeat.o(309440);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(309445);
    if ((al.hgN().Qxy) && ((paramp instanceof z)))
    {
      paramString = (ffm)c.c.b(((z)paramp).rr.otC);
      boolean bool = ((z)paramp).hfQ();
      Log.i("MicroMsg.SnsUnreadPreloader", "errType:%s, errCode:%s, isForUnreadPreload:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((bool) && (paramString != null) && (!Util.isNullOrNil(paramString.YMT)) && (!Util.isNullOrNil(this.Qxu)))
      {
        paramp = (SnsObject)paramString.YMT.peekLast();
        if (paramp != null)
        {
          ArrayList localArrayList = new ArrayList();
          paramString = paramString.YMT.iterator();
          while (paramString.hasNext()) {
            localArrayList.add(Long.valueOf(((SnsObject)paramString.next()).Id));
          }
          this.Qxu.removeAll(localArrayList);
          if ((this.Qxu.isEmpty()) || (paramp.Id < ((Long)this.Qxu.get(this.Qxu.size() - 1)).longValue()))
          {
            Log.i("MicroMsg.SnsUnreadPreloader", "finish preload unread fault");
            this.Qxv.state = 1;
            this.Qxu.clear();
            AppMethodBeat.o(309445);
            return;
          }
          if (this.Qxv.QCR > this.Qxw)
          {
            Log.i("MicroMsg.SnsUnreadPreloader", "drop preload unread fault, too many times!!");
            this.Qxv.state = 3;
            this.Qxu.clear();
            AppMethodBeat.o(309445);
            return;
          }
          paramString = this.Qxv;
          paramString.QCR += 1;
          Log.i("MicroMsg.SnsUnreadPreloader", "continue preload unread fault, maxId:%s, preloadCount:%s, unreadItem:%s", new Object[] { this.Qxu.get(0), Integer.valueOf(this.Qxv.QCR), this.Qxv });
          com.tencent.mm.kernel.h.baD().mCm.a(new z(((Long)this.Qxu.get(0)).longValue() + 1L, 0L, 2), 0);
        }
      }
    }
    AppMethodBeat.o(309445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aw
 * JD-Core Version:    0.7.0.1
 */