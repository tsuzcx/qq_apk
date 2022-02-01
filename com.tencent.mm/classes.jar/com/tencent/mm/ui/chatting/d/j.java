package com.tencent.mm.ui.chatting.d;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.protobuf.aa;
import com.tencent.mm.plugin.game.protobuf.cu;
import com.tencent.mm.plugin.game.protobuf.k;
import com.tencent.mm.plugin.gamelife.a.b;
import com.tencent.mm.plugin.gamelife.a.d;
import com.tencent.mm.plugin.websearch.PluginWebSearch;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.a.a.a;
import com.tencent.mm.pluginsdk.ui.chat.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.chatting.d.a.a(gRF=com.tencent.mm.ui.chatting.d.b.i.class)
class j
  extends a
  implements com.tencent.mm.ui.chatting.d.b.i
{
  public final void gIm()
  {
    AppMethodBeat.i(233069);
    super.gIm();
    if (!gPw())
    {
      AppMethodBeat.o(233069);
      return;
    }
    Object localObject1 = ((b)g.af(b.class)).aAR(this.dom.gRI());
    ChatFooter localChatFooter;
    if (localObject1 == null)
    {
      Log.e("GameLife.ChattingComponent", "self contact get failed!");
      localChatFooter = ((u)this.dom.bh(u.class)).gPO();
      if (localChatFooter != null)
      {
        localObject1 = com.tencent.mm.plugin.game.commlib.a.dSZ();
        if (localObject1 != null) {
          break label231;
        }
        localObject1 = null;
      }
    }
    for (;;)
    {
      localChatFooter.setAppPanelUnCertainEnterArrayList((ArrayList)localObject1);
      localChatFooter.gqW();
      ((com.tencent.mm.plugin.gamelife.a.c)g.af(com.tencent.mm.plugin.gamelife.a.c.class)).ave(this.dom.getTalkerUserName());
      if (!Util.isNullOrNil(this.dom.getTalkerUserName())) {
        com.tencent.f.h.RTc.aY(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(233066);
            List localList = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().fw(Collections.singletonList("gamelifemessage"));
            Iterator localIterator = localList.iterator();
            while (localIterator.hasNext())
            {
              ca localca = (ca)localIterator.next();
              com.tencent.mm.plugin.byp.b.a.a locala = com.tencent.mm.plugin.byp.b.a.pPx;
              if (!com.tencent.mm.plugin.byp.b.a.crV().contains(Long.valueOf(localca.field_msgId)))
              {
                localca.setStatus(5);
                ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(localca.field_msgId, localca);
              }
            }
            Log.i("GameLife.ChattingComponent", "sending msg size=%s talker=%s username=%s", new Object[] { Integer.valueOf(localList.size()), j.this.dom.gOZ(), j.this.dom.getTalkerUserName() });
            AppMethodBeat.o(233066);
          }
        });
      }
      AppMethodBeat.o(233069);
      return;
      Object localObject2 = ((u)this.dom.bh(u.class)).gPO();
      if (localObject2 == null) {
        break;
      }
      Object localObject3 = (com.tencent.mm.ui.widget.cedit.api.c)this.dom.findViewById(2131298415);
      ((com.tencent.mm.ui.widget.cedit.api.c)localObject3).refresh(((PluginWebSearch)g.ah(PluginWebSearch.class)).isUseSysEditText());
      ((com.tencent.mm.ui.widget.cedit.api.c)localObject3).addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(233064);
          paramAnonymousInt1 = this.PnT.gYL();
          if (paramAnonymousInt1 < 0)
          {
            AppMethodBeat.o(233064);
            return;
          }
          paramAnonymousInt2 = com.tencent.mm.cb.a.fromDPToPix(j.this.dom.Pwc.getContext(), 52);
          Object localObject1 = null;
          paramAnonymousView = (View)localObject1;
          if (!TextUtils.isEmpty(this.PnU.getTag()))
          {
            paramAnonymousView = (View)localObject1;
            if (this.PnU.dWY() == 1) {
              paramAnonymousView = String.format(" (%s)", new Object[] { this.PnU.getTag() });
            }
          }
          Object localObject2 = Util.nullAsNil(this.PnU.dWW().field_nickname);
          localObject1 = localObject2;
          if (paramAnonymousView != null) {
            localObject1 = (String)localObject2 + paramAnonymousView;
          }
          float f = Layout.getDesiredWidth((String)localObject1 + " : ", this.PnT.getPaint());
          localObject2 = new StringBuilder();
          localObject1 = this.PnU.dWW().field_nickname;
          if ((localObject1 != null) && (f > paramAnonymousInt1 - paramAnonymousInt2)) {
            if (paramAnonymousView == null)
            {
              paramAnonymousInt1 = 20;
              String str = com.tencent.mm.ui.tools.f.hm((String)localObject1, paramAnonymousInt1);
              localObject1 = str;
              if (Character.isHighSurrogate(str.charAt(str.length() - 1))) {
                localObject1 = str.substring(0, str.length() - 1);
              }
            }
          }
          for (localObject1 = ((StringBuilder)localObject2).append((String)localObject1).append("...");; localObject1 = localObject2)
          {
            if (paramAnonymousView != null) {
              ((StringBuilder)localObject1).append(paramAnonymousView);
            }
            if (((StringBuilder)localObject1).length() != 0) {
              ((StringBuilder)localObject1).append(" : ");
            }
            this.PnV.a(j.this.dom.gRI(), Boolean.FALSE, com.tencent.mm.pluginsdk.ui.span.l.c(j.this.dom.Pwc.getContext(), (CharSequence)localObject1));
            this.PnT.removeOnLayoutChangeListener(this);
            AppMethodBeat.o(233064);
            return;
            paramAnonymousInt1 = 12;
            break;
            ((StringBuilder)localObject2).append((String)localObject1);
          }
        }
      });
      break;
      label231:
      String str = ((com.tencent.mm.plugin.gamelife.a.f)g.af(com.tencent.mm.plugin.gamelife.a.f.class)).avi(this.dom.getTalkerUserName());
      if (TextUtils.isEmpty(str))
      {
        localObject1 = null;
      }
      else
      {
        localObject2 = new ArrayList(((k)localObject1).xJi.size());
        Iterator localIterator = ((k)localObject1).xJi.iterator();
        while (localIterator.hasNext())
        {
          final com.tencent.mm.plugin.game.protobuf.h localh = (com.tencent.mm.plugin.game.protobuf.h)localIterator.next();
          if (localh.xJa != 0)
          {
            com.tencent.mm.pluginsdk.ui.chat.a.a locala = new com.tencent.mm.pluginsdk.ui.chat.a.a();
            locala.KhQ = localh.pLn;
            int i;
            label349:
            label366:
            Object localObject4;
            if (localh.xIZ)
            {
              i = 1;
              locala.KhR = i;
              if (localh.xJa != 1) {
                break label630;
              }
              i = 1;
              locala.uSc = i;
              if ((localh.xJa != 1) || (localh.xJb == null)) {
                break label775;
              }
              locala.KhT = localh.xJb.jfi;
              localObject3 = localh.xJb.xut;
              localObject4 = this.dom.gRI();
              localObject1 = localObject3;
              if (localObject4 != null)
              {
                if (str != null) {
                  break label635;
                }
                localObject1 = localObject3;
              }
              label437:
              locala.KhV = ((String)localObject1);
              locala.KhW = String.valueOf(localh.xJb.xMC);
              label459:
              localObject1 = localh.xJc.iterator();
            }
            for (;;)
            {
              if (!((Iterator)localObject1).hasNext()) {
                break label1011;
              }
              localObject4 = (aa)((Iterator)localObject1).next();
              if (((aa)localObject4).rBI != null)
              {
                localObject3 = new a.b();
                ((a.b)localObject3).title = ((aa)localObject4).Title;
                ((a.b)localObject3).desc = ((aa)localObject4).Desc;
                localObject4 = ((aa)localObject4).rBI;
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
                    locala.KhX = ((a.b)localObject3);
                    break;
                    i = 0;
                    break label349;
                    label630:
                    i = 2;
                    break label366;
                    label635:
                    localObject1 = String.format("from_username=%s&to_username=%s", new Object[] { q.encode((String)localObject4), q.encode(str) });
                    if (TextUtils.isEmpty((CharSequence)localObject3))
                    {
                      localObject1 = "?".concat(String.valueOf(localObject1));
                      break label437;
                    }
                    if (((String)localObject3).contains("?"))
                    {
                      if (((String)localObject3).endsWith("?"))
                      {
                        localObject1 = (String)localObject3 + (String)localObject1;
                        break label437;
                      }
                      localObject1 = String.format("%s&%s", new Object[] { localObject3, localObject1 });
                      break label437;
                    }
                    localObject1 = String.format("%s?%s", new Object[] { localObject3, localObject1 });
                    break label437;
                    label775:
                    if (localh.xJa != 2) {
                      break label459;
                    }
                    localObject3 = localh.xIy;
                    localObject4 = this.dom.gRI();
                    localObject1 = localObject3;
                    if (!Util.isNullOrNil((String)localObject3))
                    {
                      localObject1 = localObject3;
                      if (localObject4 != null) {
                        if (str != null) {
                          break label877;
                        }
                      }
                    }
                    for (localObject1 = localObject3;; localObject1 = ((Uri.Builder)localObject1).build().toString())
                    {
                      locala.nnB = ((String)localObject1);
                      locala.Kif = localh.xJf;
                      if ((Util.isNullOrNil(locala.nnB)) || (locala.Kif == 0)) {
                        break;
                      }
                      com.tencent.mm.plugin.game.luggage.h.a(com.tencent.mm.plugin.game.luggage.i.class, locala.nnB, null);
                      break;
                      label877:
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
                locala.KhZ = ((a.b)localObject3);
                continue;
                locala.KhY = ((a.b)localObject3);
                continue;
                locala.Kia = ((a.b)localObject3);
              }
            }
            label1011:
            locala.iconUrl = localh.IconUrl;
            locala.Kib = localh.xJd;
            locala.Kid = 56;
            locala.Kic = 56;
            locala.Kig = new a.a.a()
            {
              public final String gqg()
              {
                AppMethodBeat.i(233065);
                String str = ((d)g.af(d.class)).ek(j.this.dom.getTalkerUserName(), localh.xIY);
                AppMethodBeat.o(233065);
                return str;
              }
            };
            Log.i("GameLife.ChattingComponent", "add AppPanel: enter_id[%s] red_dot[%d] appid[%s] url[%s] title[%s] type[%d]", new Object[] { locala.KhQ, Integer.valueOf(locala.KhR), locala.KhT, locala.nnB, locala.KhX.title, Integer.valueOf(localh.xIY) });
            ((ArrayList)localObject2).add(locala);
          }
        }
        localObject1 = localObject2;
      }
    }
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(233070);
    super.gIn();
    if (!gPw())
    {
      AppMethodBeat.o(233070);
      return;
    }
    ((com.tencent.mm.plugin.gamelife.a.c)g.af(com.tencent.mm.plugin.gamelife.a.c.class)).ave(this.dom.getTalkerUserName());
    com.tencent.mm.plugin.game.luggage.h.destroy();
    AppMethodBeat.o(233070);
  }
  
  public final boolean gPw()
  {
    AppMethodBeat.i(233067);
    boolean bool = as.bju(this.dom.getTalkerUserName());
    AppMethodBeat.o(233067);
    return bool;
  }
  
  public final void gPx()
  {
    AppMethodBeat.i(233068);
    this.dom.Pwc.setMMTitle(this.dom.GUe.arJ());
    Object localObject = ((com.tencent.mm.plugin.gamelife.a.f)g.af(com.tencent.mm.plugin.gamelife.a.f.class)).avi(this.dom.getTalkerUserName());
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      Log.e("GameLife.ChattingComponent", "talker username get failed!");
      AppMethodBeat.o(233068);
      return;
    }
    localObject = ((b)g.af(b.class)).aAR((String)localObject);
    if (localObject == null)
    {
      Log.e("GameLife.ChattingComponent", "talker contact get failed!");
      AppMethodBeat.o(233068);
      return;
    }
    if ((!TextUtils.isEmpty(((com.tencent.mm.plugin.gamelife.a.a)localObject).getTag())) && (((com.tencent.mm.plugin.gamelife.a.a)localObject).dWY() == 1)) {
      this.dom.Pwc.setMMSubTitle(((com.tencent.mm.plugin.gamelife.a.a)localObject).getTag());
    }
    AppMethodBeat.o(233068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.j
 * JD-Core Version:    0.7.0.1
 */