package com.tencent.mm.ui.chatting.component;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.plugin.game.protobuf.ac;
import com.tencent.mm.plugin.game.protobuf.cy;
import com.tencent.mm.plugin.gamelife.a.b;
import com.tencent.mm.plugin.gamelife.a.d;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.websearch.PluginWebSearch;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.a.a.a;
import com.tencent.mm.pluginsdk.ui.chat.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.k;
import com.tencent.mm.ui.chatting.component.api.x;
import com.tencent.mm.ui.tools.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=k.class)
class l
  extends a
  implements k
{
  public final void jjh()
  {
    AppMethodBeat.i(256197);
    super.jjh();
    if (!jrF())
    {
      AppMethodBeat.o(256197);
      return;
    }
    Object localObject1 = ((b)com.tencent.mm.kernel.h.ax(b.class)).aHu(this.hlc.getSelfUserName());
    ChatFooter localChatFooter;
    if (localObject1 == null)
    {
      Log.e("GameLife.ChattingComponent", "self contact get failed!");
      localChatFooter = ((x)this.hlc.cm(x.class)).jsd();
      if (localChatFooter != null)
      {
        localObject1 = com.tencent.mm.plugin.game.commlib.a.fDX();
        if (localObject1 != null) {
          break label232;
        }
        localObject1 = null;
      }
    }
    for (;;)
    {
      localChatFooter.setAppPanelUnCertainEnterArrayList((ArrayList)localObject1);
      localChatFooter.iMM();
      ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.c.class)).aAr(this.hlc.getTalkerUserName());
      if (!Util.isNullOrNil(this.hlc.getTalkerUserName())) {
        com.tencent.threadpool.h.ahAA.bn(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(255976);
            List localList = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().iV(Collections.singletonList("gamelifemessage"));
            Iterator localIterator = localList.iterator();
            while (localIterator.hasNext())
            {
              cc localcc = (cc)localIterator.next();
              com.tencent.mm.plugin.byp.b.a.a locala = com.tencent.mm.plugin.byp.b.a.waG;
              if (!com.tencent.mm.plugin.byp.b.a.diq().contains(Long.valueOf(localcc.field_msgId)))
              {
                localcc.setStatus(5);
                ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(localcc.field_msgId, localcc);
              }
            }
            Log.i("GameLife.ChattingComponent", "sending msg size=%s talker=%s username=%s", new Object[] { Integer.valueOf(localList.size()), l.this.hlc.jrh(), l.this.hlc.getTalkerUserName() });
            AppMethodBeat.o(255976);
          }
        });
      }
      AppMethodBeat.o(256197);
      return;
      Object localObject2 = ((x)this.hlc.cm(x.class)).jsd();
      if (localObject2 == null) {
        break;
      }
      Object localObject3 = (com.tencent.mm.ui.widget.cedit.api.c)this.hlc.findViewById(R.h.fxx);
      ((com.tencent.mm.ui.widget.cedit.api.c)localObject3).refresh(((PluginWebSearch)com.tencent.mm.kernel.h.az(PluginWebSearch.class)).isUseSysEditText());
      ((com.tencent.mm.ui.widget.cedit.api.c)localObject3).addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(255985);
          paramAnonymousInt1 = this.aeqm.jEL();
          if (paramAnonymousInt1 < 0)
          {
            AppMethodBeat.o(255985);
            return;
          }
          paramAnonymousInt2 = com.tencent.mm.cd.a.fromDPToPix(l.this.hlc.aezO.getContext(), 52);
          Object localObject1 = null;
          paramAnonymousView = (View)localObject1;
          if (!TextUtils.isEmpty(this.aeqn.getTag()))
          {
            paramAnonymousView = (View)localObject1;
            if (this.aeqn.fIh() == 1) {
              paramAnonymousView = String.format(" (%s)", new Object[] { this.aeqn.getTag() });
            }
          }
          Object localObject2 = Util.nullAsNil(this.aeqn.bSb().field_nickname);
          localObject1 = localObject2;
          if (paramAnonymousView != null) {
            localObject1 = (String)localObject2 + paramAnonymousView;
          }
          float f = Layout.getDesiredWidth((String)localObject1 + " : ", this.aeqm.getPaint());
          localObject2 = new StringBuilder();
          localObject1 = this.aeqn.bSb().field_nickname;
          if ((localObject1 != null) && (f > paramAnonymousInt1 - paramAnonymousInt2)) {
            if (paramAnonymousView == null)
            {
              paramAnonymousInt1 = 20;
              String str = g.jd((String)localObject1, paramAnonymousInt1);
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
            this.aeqo.a(l.this.hlc.getSelfUserName(), Boolean.FALSE, p.b(l.this.hlc.aezO.getContext(), (CharSequence)localObject1));
            this.aeqm.removeOnLayoutChangeListener(this);
            AppMethodBeat.o(255985);
            return;
            paramAnonymousInt1 = 12;
            break;
            ((StringBuilder)localObject2).append((String)localObject1);
          }
        }
      });
      break;
      label232:
      String str = ((f)com.tencent.mm.kernel.h.ax(f.class)).aAw(this.hlc.getTalkerUserName());
      if (TextUtils.isEmpty(str))
      {
        localObject1 = null;
      }
      else
      {
        localObject2 = new ArrayList(((com.tencent.mm.plugin.game.protobuf.l)localObject1).IHx.size());
        Iterator localIterator = ((com.tencent.mm.plugin.game.protobuf.l)localObject1).IHx.iterator();
        while (localIterator.hasNext())
        {
          final com.tencent.mm.plugin.game.protobuf.h localh = (com.tencent.mm.plugin.game.protobuf.h)localIterator.next();
          if (localh.IHl != 0)
          {
            com.tencent.mm.pluginsdk.ui.chat.a.a locala = new com.tencent.mm.pluginsdk.ui.chat.a.a();
            locala.YeJ = localh.vYl;
            int i;
            label350:
            label367:
            Object localObject4;
            if (localh.IHk)
            {
              i = 1;
              locala.red_dot = i;
              if (localh.IHl != 1) {
                break label634;
              }
              i = 1;
              locala.jump_type = i;
              if ((localh.IHl != 1) || (localh.IHm == null)) {
                break label779;
              }
              locala.YeL = localh.IHm.oOI;
              localObject3 = localh.IHm.IcT;
              localObject4 = this.hlc.getSelfUserName();
              localObject1 = localObject3;
              if (localObject4 != null)
              {
                if (str != null) {
                  break label639;
                }
                localObject1 = localObject3;
              }
              label438:
              locala.YeN = ((String)localObject1);
              locala.YeO = String.valueOf(localh.IHm.IKZ);
              label460:
              localObject1 = localh.IHn.iterator();
            }
            for (;;)
            {
              if (!((Iterator)localObject1).hasNext()) {
                break label1015;
              }
              localObject4 = (ac)((Iterator)localObject1).next();
              if (((ac)localObject4).yts != null)
              {
                localObject3 = new a.b();
                ((a.b)localObject3).title = ((ac)localObject4).hAP;
                ((a.b)localObject3).desc = ((ac)localObject4).IGG;
                localObject4 = ((ac)localObject4).yts;
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
                    locala.YeP = ((a.b)localObject3);
                    break;
                    i = 0;
                    break label350;
                    label634:
                    i = 2;
                    break label367;
                    label639:
                    localObject1 = String.format("from_username=%s&to_username=%s", new Object[] { r.cg((String)localObject4), r.cg(str) });
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
                    if (localh.IHl != 2) {
                      break label460;
                    }
                    localObject3 = localh.IGI;
                    localObject4 = this.hlc.getSelfUserName();
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
                      locala.ttL = ((String)localObject1);
                      locala.YeW = localh.IHr;
                      if ((Util.isNullOrNil(locala.ttL)) || (locala.YeW == 0)) {
                        break;
                      }
                      com.tencent.mm.plugin.game.luggage.h.a(com.tencent.mm.plugin.game.luggage.i.class, locala.ttL, null);
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
                locala.YeR = ((a.b)localObject3);
                continue;
                locala.YeQ = ((a.b)localObject3);
                continue;
                locala.YeS = ((a.b)localObject3);
              }
            }
            label1015:
            locala.iconUrl = localh.IHo;
            locala.PNd = localh.IHp;
            locala.YeU = 56;
            locala.YeT = 56;
            locala.YeX = new a.a.a()
            {
              public final String iLV()
              {
                AppMethodBeat.i(255979);
                String str = ((d)com.tencent.mm.kernel.h.ax(d.class)).fy(l.this.hlc.getTalkerUserName(), localh.IHj);
                AppMethodBeat.o(255979);
                return str;
              }
            };
            Log.i("GameLife.ChattingComponent", "add AppPanel: enter_id[%s] red_dot[%d] appid[%s] url[%s] title[%s] type[%d]", new Object[] { locala.YeJ, Integer.valueOf(locala.red_dot), locala.YeL, locala.ttL, locala.YeP.title, Integer.valueOf(localh.IHj) });
            ((ArrayList)localObject2).add(locala);
          }
        }
        localObject1 = localObject2;
      }
    }
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(256203);
    super.jjk();
    if (!jrF())
    {
      AppMethodBeat.o(256203);
      return;
    }
    ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.c.class)).aAr(this.hlc.getTalkerUserName());
    com.tencent.mm.plugin.game.luggage.h.destroy();
    AppMethodBeat.o(256203);
  }
  
  public final void jrB()
  {
    AppMethodBeat.i(256177);
    this.hlc.aezO.setMMTitle(this.hlc.Uxa.aSV());
    Object localObject = ((f)com.tencent.mm.kernel.h.ax(f.class)).aAw(this.hlc.getTalkerUserName());
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      Log.e("GameLife.ChattingComponent", "talker username get failed!");
      AppMethodBeat.o(256177);
      return;
    }
    localObject = ((b)com.tencent.mm.kernel.h.ax(b.class)).aHu((String)localObject);
    if (localObject == null)
    {
      Log.e("GameLife.ChattingComponent", "talker contact get failed!");
      AppMethodBeat.o(256177);
      return;
    }
    if ((!TextUtils.isEmpty(((com.tencent.mm.plugin.gamelife.a.a)localObject).getTag())) && (((com.tencent.mm.plugin.gamelife.a.a)localObject).fIh() == 1)) {
      this.hlc.aezO.setMMSubTitle(((com.tencent.mm.plugin.gamelife.a.a)localObject).getTag());
    }
    AppMethodBeat.o(256177);
  }
  
  public final boolean jrF()
  {
    AppMethodBeat.i(256170);
    boolean bool = au.bwW(this.hlc.getTalkerUserName());
    AppMethodBeat.o(256170);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.l
 * JD-Core Version:    0.7.0.1
 */