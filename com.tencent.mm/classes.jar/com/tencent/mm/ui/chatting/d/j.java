package com.tencent.mm.ui.chatting.d;

import android.os.Looper;
import android.widget.AbsListView;
import com.tencent.c.a.a.a.b;
import com.tencent.c.a.a.a.d.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class j
  extends a
  implements i.a, ag
{
  private String TAG = "ChattingFinderLiveNotifyComponent";
  
  private boolean hON()
  {
    AppMethodBeat.i(232296);
    boolean bool = "notifymessage".equals(this.fgR.NKq.field_username);
    AppMethodBeat.o(232296);
    return bool;
  }
  
  private void hOO()
  {
    AppMethodBeat.i(232309);
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(275521);
        int i = j.this.fgR.getFirstVisiblePosition();
        int j = j.this.fgR.getLastVisiblePosition();
        Object localObject1 = j.this.fgR.WQv;
        if (!(localObject1 instanceof ChattingUIFragment))
        {
          AppMethodBeat.o(275521);
          return;
        }
        localObject1 = ((ChattingUIFragment)localObject1).WCR;
        LinkedList localLinkedList = new LinkedList();
        if (i < j)
        {
          Object localObject2 = ((com.tencent.mm.ui.chatting.a.a)localObject1).avt(i);
          Object localObject3;
          int k;
          boolean bool;
          if ((localObject2 != null) && (((ca)localObject2).getType() == 1075839025))
          {
            localObject3 = XmlParser.parseXml(((et)localObject2).field_content, "msg", null);
            k = Util.safeParseInt((String)((Map)localObject3).get(".msg.appmsg.extinfo.notifymsg.live_widget.status"));
            localObject3 = Util.nullAsNil((String)((Map)localObject3).get(".msg.appmsg.extinfo.notifymsg.tipsinfo.tips_id"));
            aj localaj = aj.AGc;
            bool = aj.T(((et)localObject2).field_msgId, 4);
            if ((k != 1) || (bool)) {
              break label187;
            }
            localLinkedList.add(localObject2);
          }
          for (;;)
          {
            i += 1;
            break;
            label187:
            Log.i(j.a(j.this), "can not add to refresh, tipsId = " + (String)localObject3 + " ,status = " + k + "notRefresh = " + bool);
            localObject2 = com.tencent.mm.plugin.finder.live.h.xVt;
            com.tencent.mm.plugin.finder.live.h.dwo().remove(localObject3);
          }
        }
        com.tencent.mm.plugin.finder.live.h.xVt.ai(localLinkedList);
        AppMethodBeat.o(275521);
      }
    });
    AppMethodBeat.o(232309);
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(232300);
    bh.beI();
    c.bbO().a(this, Looper.getMainLooper());
    AppMethodBeat.o(232300);
  }
  
  public final void hGX()
  {
    AppMethodBeat.i(232307);
    if (hON())
    {
      com.tencent.mm.plugin.finder.live.h localh = com.tencent.mm.plugin.finder.live.h.xVt;
      com.tencent.mm.plugin.finder.live.h.dwp();
      hOO();
    }
    AppMethodBeat.o(232307);
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(232306);
    if (hON())
    {
      com.tencent.mm.plugin.finder.live.h localh = com.tencent.mm.plugin.finder.live.h.xVt;
      com.tencent.mm.plugin.finder.live.h.dwq();
    }
    AppMethodBeat.o(232306);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(232303);
    if (bh.aHB())
    {
      bh.beI();
      c.bbO().a(this);
    }
    AppMethodBeat.o(232303);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(232305);
    super.hNZ();
    if (bh.aHB())
    {
      bh.beI();
      c.bbO().a(this);
    }
    AppMethodBeat.o(232305);
  }
  
  public void onNotifyChange(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc)
  {
    AppMethodBeat.i(232312);
    Log.i(this.TAG, "[onNotifyChange]");
    if ((paramc.EVM.equals("delete")) && (!paramc.kvM.isEmpty()))
    {
      parami = paramc.kvM.iterator();
      while (parami.hasNext())
      {
        paramc = (ca)parami.next();
        ((b)com.tencent.mm.kernel.h.ag(b.class)).getFinderLiveNotifyExposureInfoStorage().Lu(paramc.field_msgId);
      }
    }
    AppMethodBeat.o(232312);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(232298);
    if ((hON()) && (paramInt == 0)) {
      hOO();
    }
    AppMethodBeat.o(232298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.j
 * JD-Core Version:    0.7.0.1
 */