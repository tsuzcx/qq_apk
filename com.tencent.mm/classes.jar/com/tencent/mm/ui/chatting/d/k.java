package com.tencent.mm.ui.chatting.d;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.game.protobuf.ab;
import com.tencent.mm.plugin.game.protobuf.cv;
import com.tencent.mm.plugin.gamelife.a.b;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.plugin.websearch.PluginWebSearch;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.a.a;
import com.tencent.mm.pluginsdk.ui.chat.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.b.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.chatting.d.a.a(hRc=com.tencent.mm.ui.chatting.d.b.i.class)
class k
  extends a
  implements com.tencent.mm.ui.chatting.d.b.i
{
  public final void hGW()
  {
    AppMethodBeat.i(284819);
    super.hGW();
    if (!hOP())
    {
      AppMethodBeat.o(284819);
      return;
    }
    Object localObject1 = ((b)com.tencent.mm.kernel.h.ae(b.class)).aKE(this.fgR.getSelfUserName());
    ChatFooter localChatFooter;
    if (localObject1 == null)
    {
      Log.e("GameLife.ChattingComponent", "self contact get failed!");
      localChatFooter = ((u)this.fgR.bC(u.class)).hPj();
      if (localChatFooter != null)
      {
        localObject1 = com.tencent.mm.plugin.game.commlib.a.ewh();
        if (localObject1 != null) {
          break label232;
        }
        localObject1 = null;
      }
    }
    for (;;)
    {
      localChatFooter.setAppPanelUnCertainEnterArrayList((ArrayList)localObject1);
      localChatFooter.hlV();
      ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.c.class)).aEy(this.fgR.getTalkerUserName());
      if (!Util.isNullOrNil(this.fgR.getTalkerUserName())) {
        com.tencent.e.h.ZvG.bf(new k.3(this));
      }
      AppMethodBeat.o(284819);
      return;
      Object localObject2 = ((u)this.fgR.bC(u.class)).hPj();
      if (localObject2 == null) {
        break;
      }
      Object localObject3 = (com.tencent.mm.ui.widget.cedit.api.c)this.fgR.findViewById(R.h.dxd);
      ((com.tencent.mm.ui.widget.cedit.api.c)localObject3).refresh(((PluginWebSearch)com.tencent.mm.kernel.h.ag(PluginWebSearch.class)).isUseSysEditText());
      ((com.tencent.mm.ui.widget.cedit.api.c)localObject3).addOnLayoutChangeListener(new k.1(this, (com.tencent.mm.ui.widget.cedit.api.c)localObject3, (com.tencent.mm.plugin.gamelife.a.a)localObject1, (ChatFooter)localObject2));
      break;
      label232:
      String str = ((f)com.tencent.mm.kernel.h.ae(f.class)).aED(this.fgR.getTalkerUserName());
      if (TextUtils.isEmpty(str))
      {
        localObject1 = null;
      }
      else
      {
        localObject2 = new ArrayList(((com.tencent.mm.plugin.game.protobuf.k)localObject1).CNp.size());
        Iterator localIterator = ((com.tencent.mm.plugin.game.protobuf.k)localObject1).CNp.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.game.protobuf.h localh = (com.tencent.mm.plugin.game.protobuf.h)localIterator.next();
          if (localh.CNg != 0)
          {
            a.a locala = new a.a();
            locala.RiB = localh.sSV;
            int i;
            label350:
            label367:
            Object localObject4;
            if (localh.CNf)
            {
              i = 1;
              locala.red_dot = i;
              if (localh.CNg != 1) {
                break label634;
              }
              i = 1;
              locala.jump_type = i;
              if ((localh.CNg != 1) || (localh.CNh == null)) {
                break label779;
              }
              locala.RiD = localh.CNh.lVG;
              localObject3 = localh.CNh.CqK;
              localObject4 = this.fgR.getSelfUserName();
              localObject1 = localObject3;
              if (localObject4 != null)
              {
                if (str != null) {
                  break label639;
                }
                localObject1 = localObject3;
              }
              label438:
              locala.RiF = ((String)localObject1);
              locala.RiG = String.valueOf(localh.CNh.CQL);
              label460:
              localObject1 = localh.CNi.iterator();
            }
            for (;;)
            {
              if (!((Iterator)localObject1).hasNext()) {
                break label1015;
              }
              localObject4 = (ab)((Iterator)localObject1).next();
              if (((ab)localObject4).vhq != null)
              {
                localObject3 = new a.b();
                ((a.b)localObject3).title = ((ab)localObject4).fwr;
                ((a.b)localObject3).desc = ((ab)localObject4).CMB;
                localObject4 = ((ab)localObject4).vhq;
                i = -1;
                switch (((String)localObject4).hashCode())
                {
                }
                for (;;)
                {
                  switch (i)
                  {
                  default: 
                    break;
                  case 0: 
                    locala.RiH = ((a.b)localObject3);
                    break;
                    i = 0;
                    break label350;
                    label634:
                    i = 2;
                    break label367;
                    label639:
                    localObject1 = String.format("from_username=%s&to_username=%s", new Object[] { q.aT((String)localObject4), q.aT(str) });
                    if (TextUtils.isEmpty((CharSequence)localObject3))
                    {
                      localObject1 = "?".concat(String.valueOf(localObject1));
                      break label438;
                    }
                    if (((String)localObject3).contains("?"))
                    {
                      if (((String)localObject3).endsWith("?"))
                      {
                        localObject1 = (String)localObject3 + (String)localObject1;
                        break label438;
                      }
                      localObject1 = String.format("%s&%s", new Object[] { localObject3, localObject1 });
                      break label438;
                    }
                    localObject1 = String.format("%s?%s", new Object[] { localObject3, localObject1 });
                    break label438;
                    label779:
                    if (localh.CNg != 2) {
                      break label460;
                    }
                    localObject3 = localh.CMD;
                    localObject4 = this.fgR.getSelfUserName();
                    localObject1 = localObject3;
                    if (!Util.isNullOrNil((String)localObject3))
                    {
                      localObject1 = localObject3;
                      if (localObject4 != null) {
                        if (str != null) {
                          break label881;
                        }
                      }
                    }
                    for (localObject1 = localObject3;; localObject1 = ((Uri.Builder)localObject1).build().toString())
                    {
                      locala.qpi = ((String)localObject1);
                      locala.RiP = localh.CNm;
                      if ((Util.isNullOrNil(locala.qpi)) || (locala.RiP == 0)) {
                        break;
                      }
                      com.tencent.mm.plugin.game.luggage.h.a(com.tencent.mm.plugin.game.luggage.i.class, locala.qpi, null);
                      break;
                      label881:
                      localObject1 = Uri.parse((String)localObject3).buildUpon();
                      ((Uri.Builder)localObject1).appendQueryParameter("from_username", (String)localObject4);
                      ((Uri.Builder)localObject1).appendQueryParameter("to_username", str);
                    }
                    if (((String)localObject4).equals("zh_CN"))
                    {
                      i = 0;
                      continue;
                      if (((String)localObject4).equals("zh_TW"))
                      {
                        i = 1;
                        continue;
                        if (((String)localObject4).equals("zh_HK"))
                        {
                          i = 2;
                          continue;
                          if (((String)localObject4).equals("en")) {
                            i = 3;
                          }
                        }
                      }
                    }
                    break;
                  }
                }
                locala.RiJ = ((a.b)localObject3);
                continue;
                locala.RiI = ((a.b)localObject3);
                continue;
                locala.RiK = ((a.b)localObject3);
              }
            }
            label1015:
            locala.iconUrl = localh.CNj;
            locala.RiL = localh.CNk;
            locala.RiN = 56;
            locala.RiM = 56;
            locala.RiQ = new k.2(this, localh);
            Log.i("GameLife.ChattingComponent", "add AppPanel: enter_id[%s] red_dot[%d] appid[%s] url[%s] title[%s] type[%d]", new Object[] { locala.RiB, Integer.valueOf(locala.red_dot), locala.RiD, locala.qpi, locala.RiH.title, Integer.valueOf(localh.CNe) });
            ((ArrayList)localObject2).add(locala);
          }
        }
        localObject1 = localObject2;
      }
    }
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(284821);
    super.hGZ();
    if (!hOP())
    {
      AppMethodBeat.o(284821);
      return;
    }
    ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.c.class)).aEy(this.fgR.getTalkerUserName());
    com.tencent.mm.plugin.game.luggage.h.destroy();
    AppMethodBeat.o(284821);
  }
  
  public final void hOL()
  {
    AppMethodBeat.i(284815);
    this.fgR.WQv.setMMTitle(this.fgR.NKq.ays());
    Object localObject = ((f)com.tencent.mm.kernel.h.ae(f.class)).aED(this.fgR.getTalkerUserName());
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      Log.e("GameLife.ChattingComponent", "talker username get failed!");
      AppMethodBeat.o(284815);
      return;
    }
    localObject = ((b)com.tencent.mm.kernel.h.ae(b.class)).aKE((String)localObject);
    if (localObject == null)
    {
      Log.e("GameLife.ChattingComponent", "talker contact get failed!");
      AppMethodBeat.o(284815);
      return;
    }
    if ((!TextUtils.isEmpty(((com.tencent.mm.plugin.gamelife.a.a)localObject).getTag())) && (((com.tencent.mm.plugin.gamelife.a.a)localObject).eAh() == 1)) {
      this.fgR.WQv.setMMSubTitle(((com.tencent.mm.plugin.gamelife.a.a)localObject).getTag());
    }
    AppMethodBeat.o(284815);
  }
  
  public final boolean hOP()
  {
    AppMethodBeat.i(284814);
    boolean bool = as.bvQ(this.fgR.getTalkerUserName());
    AppMethodBeat.o(284814);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.k
 * JD-Core Version:    0.7.0.1
 */