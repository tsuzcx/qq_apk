package com.tencent.mm.ui.chatting.component;

import android.os.Looper;
import android.widget.AbsListView;
import com.tencent.d.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.finder.live.e;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class j
  extends a
  implements i.a, aj
{
  private String TAG = "ChattingFinderLiveNotifyComponent";
  
  private boolean jrD()
  {
    AppMethodBeat.i(256192);
    boolean bool = "notifymessage".equals(this.hlc.Uxa.field_username);
    AppMethodBeat.o(256192);
    return bool;
  }
  
  private void jrE()
  {
    AppMethodBeat.i(256198);
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(256295);
        int i = j.this.hlc.getFirstVisiblePosition();
        int j = j.this.hlc.getLastVisiblePosition();
        Object localObject1 = j.this.hlc.aezO;
        if (!(localObject1 instanceof ChattingUIFragment))
        {
          AppMethodBeat.o(256295);
          return;
        }
        localObject1 = ((ChattingUIFragment)localObject1).aekk;
        LinkedList localLinkedList = new LinkedList();
        if (i < j)
        {
          Object localObject2 = ((com.tencent.mm.ui.chatting.a.a)localObject1).aBV(i);
          Object localObject3;
          int k;
          boolean bool;
          if ((localObject2 != null) && (((cc)localObject2).getType() == 1075839025))
          {
            localObject3 = XmlParser.parseXml(((fi)localObject2).field_content, "msg", null);
            k = Util.safeParseInt((String)((Map)localObject3).get(".msg.appmsg.extinfo.notifymsg.live_widget.status"));
            localObject3 = Util.nullAsNil((String)((Map)localObject3).get(".msg.appmsg.extinfo.notifymsg.tipsinfo.tips_id"));
            av localav = av.GiL;
            bool = av.ag(((fi)localObject2).field_msgId, 4);
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
            localObject2 = e.BvY;
            e.egL().remove(localObject3);
          }
        }
        e.BvY.ao(localLinkedList);
        AppMethodBeat.o(256295);
      }
    });
    AppMethodBeat.o(256198);
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(256210);
    bh.bCz();
    c.bzD().a(this, Looper.getMainLooper());
    AppMethodBeat.o(256210);
  }
  
  public final void jji()
  {
    AppMethodBeat.i(256231);
    if (jrD())
    {
      e locale = e.BvY;
      e.egM();
      jrE();
    }
    AppMethodBeat.o(256231);
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(256226);
    if (jrD())
    {
      e locale = e.BvY;
      e.egN();
    }
    AppMethodBeat.o(256226);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(256217);
    if (bh.baz())
    {
      bh.bCz();
      c.bzD().a(this);
    }
    AppMethodBeat.o(256217);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(256221);
    super.jqF();
    if (bh.baz())
    {
      bh.bCz();
      c.bzD().a(this);
    }
    AppMethodBeat.o(256221);
  }
  
  public void onNotifyChange(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc)
  {
    AppMethodBeat.i(256237);
    Log.i(this.TAG, "[onNotifyChange]");
    if ((paramc.KRm.equals("delete")) && (!paramc.mZo.isEmpty()))
    {
      parami = paramc.mZo.iterator();
      while (parami.hasNext())
      {
        paramc = (cc)parami.next();
        ((b)com.tencent.mm.kernel.h.az(b.class)).getFinderLiveNotifyExposureInfoStorage().oB(paramc.field_msgId);
      }
    }
    AppMethodBeat.o(256237);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(256206);
    if ((jrD()) && (paramInt == 0)) {
      jrE();
    }
    AppMethodBeat.o(256206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.j
 * JD-Core Version:    0.7.0.1
 */