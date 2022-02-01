package com.tencent.mm.ui.chatting.d;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.cu;
import com.tencent.mm.plugin.game.d.z;
import com.tencent.mm.plugin.gamelife.a.c;
import com.tencent.mm.plugin.gamelife.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.a.a.a;
import com.tencent.mm.pluginsdk.ui.chat.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.chatting.d.a.a(fJv=com.tencent.mm.ui.chatting.d.b.i.class)
class j
  extends a
  implements com.tencent.mm.ui.chatting.d.b.i
{
  public final void fAu()
  {
    AppMethodBeat.i(187309);
    super.fAu();
    if (!fHq())
    {
      AppMethodBeat.o(187309);
      return;
    }
    Object localObject1 = ((com.tencent.mm.plugin.gamelife.a.b)g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).any(this.cXJ.fJy());
    ChatFooter localChatFooter;
    if (localObject1 == null)
    {
      ae.e("GameLife.ChattingComponent", "self contact get failed!");
      localChatFooter = ((s)this.cXJ.bh(s.class)).fHF();
      if (localChatFooter != null)
      {
        localChatFooter.setSmileyPanelCallback(new com.tencent.mm.plugin.gamelife.h.b());
        localObject1 = com.tencent.mm.plugin.game.commlib.a.cZz();
        if (localObject1 != null) {
          break label223;
        }
        localObject1 = null;
      }
    }
    for (;;)
    {
      localChatFooter.setAppPanelUnCertainEnterArrayList((ArrayList)localObject1);
      localChatFooter.fhM();
      ((c)g.ab(c.class)).ajb(this.cXJ.getTalkerUserName());
      if (!bu.isNullOrNil(this.cXJ.getTalkerUserName())) {
        com.tencent.e.h.MqF.aP(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187306);
            List localList = ((l)g.ab(l.class)).doJ().eB(Collections.singletonList("gamelifemessage"));
            Iterator localIterator = localList.iterator();
            while (localIterator.hasNext())
            {
              bv localbv = (bv)localIterator.next();
              com.tencent.mm.plugin.byp.b.a.a locala = com.tencent.mm.plugin.byp.b.a.oBL;
              if (!com.tencent.mm.plugin.byp.b.a.bUi().contains(Long.valueOf(localbv.field_msgId)))
              {
                localbv.setStatus(5);
                ((l)g.ab(l.class)).doJ().a(localbv.field_msgId, localbv);
              }
            }
            ae.i("GameLife.ChattingComponent", "sending msg size=%s talker=%s username=%s", new Object[] { Integer.valueOf(localList.size()), j.this.cXJ.fGT(), j.this.cXJ.getTalkerUserName() });
            AppMethodBeat.o(187306);
          }
        });
      }
      AppMethodBeat.o(187309);
      return;
      Object localObject2 = ((s)this.cXJ.bh(s.class)).fHF();
      if (localObject2 == null) {
        break;
      }
      Object localObject3 = (MMEditText)this.cXJ.findViewById(2131298072);
      ((MMEditText)localObject3).addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(187304);
          paramAnonymousInt1 = this.uNZ.getWidth();
          if (paramAnonymousInt1 < 0)
          {
            AppMethodBeat.o(187304);
            return;
          }
          paramAnonymousInt2 = com.tencent.mm.cb.a.fromDPToPix(j.this.cXJ.Kkd.getContext(), 52);
          Object localObject1 = null;
          paramAnonymousView = (View)localObject1;
          if (!TextUtils.isEmpty(this.Kcw.getTag()))
          {
            paramAnonymousView = (View)localObject1;
            if (this.Kcw.ddo() == 1) {
              paramAnonymousView = String.format(" (%s)", new Object[] { this.Kcw.getTag() });
            }
          }
          Object localObject2 = bu.nullAsNil(this.Kcw.ddm().field_nickname);
          localObject1 = localObject2;
          if (paramAnonymousView != null) {
            localObject1 = (String)localObject2 + paramAnonymousView;
          }
          float f = Layout.getDesiredWidth((String)localObject1 + " : ", this.uNZ.getPaint());
          localObject2 = new StringBuilder();
          localObject1 = this.Kcw.ddm().field_nickname;
          if ((localObject1 != null) && (f > paramAnonymousInt1 - paramAnonymousInt2)) {
            if (paramAnonymousView == null)
            {
              paramAnonymousInt1 = 20;
              String str = com.tencent.mm.ui.tools.f.gT((String)localObject1, paramAnonymousInt1);
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
            this.Kcx.a(j.this.cXJ.fJy(), Boolean.FALSE, com.tencent.mm.pluginsdk.ui.span.k.c(j.this.cXJ.Kkd.getContext(), (CharSequence)localObject1));
            this.uNZ.removeOnLayoutChangeListener(this);
            AppMethodBeat.o(187304);
            return;
            paramAnonymousInt1 = 12;
            break;
            ((StringBuilder)localObject2).append((String)localObject1);
          }
        }
      });
      break;
      label223:
      String str = ((com.tencent.mm.plugin.gamelife.a.f)g.ab(com.tencent.mm.plugin.gamelife.a.f.class)).ajf(this.cXJ.getTalkerUserName());
      if (TextUtils.isEmpty(str))
      {
        localObject1 = null;
      }
      else
      {
        localObject2 = new ArrayList(((com.tencent.mm.plugin.game.d.k)localObject1).uqQ.size());
        Iterator localIterator = ((com.tencent.mm.plugin.game.d.k)localObject1).uqQ.iterator();
        while (localIterator.hasNext())
        {
          final com.tencent.mm.plugin.game.d.h localh = (com.tencent.mm.plugin.game.d.h)localIterator.next();
          if (localh.uqI != 0)
          {
            com.tencent.mm.pluginsdk.ui.chat.a.a locala = new com.tencent.mm.pluginsdk.ui.chat.a.a();
            locala.FqZ = localh.oxJ;
            int i;
            label341:
            label358:
            Object localObject4;
            if (localh.uqH)
            {
              i = 1;
              locala.Fra = i;
              if (localh.uqI != 1) {
                break label622;
              }
              i = 1;
              locala.uIW = i;
              if ((localh.uqI != 1) || (localh.uqJ == null)) {
                break label767;
              }
              locala.Frc = localh.uqJ.ikm;
              localObject3 = localh.uqJ.uuA;
              localObject4 = this.cXJ.fJy();
              localObject1 = localObject3;
              if (localObject4 != null)
              {
                if (str != null) {
                  break label627;
                }
                localObject1 = localObject3;
              }
              label429:
              locala.Fre = ((String)localObject1);
              locala.Frf = String.valueOf(localh.uqJ.uuB);
              label451:
              localObject1 = localh.uqK.iterator();
            }
            for (;;)
            {
              if (!((Iterator)localObject1).hasNext()) {
                break label962;
              }
              localObject4 = (z)((Iterator)localObject1).next();
              if (((z)localObject4).qkN != null)
              {
                localObject3 = new a.b();
                ((a.b)localObject3).title = ((z)localObject4).Title;
                ((a.b)localObject3).desc = ((z)localObject4).Desc;
                localObject4 = ((z)localObject4).qkN;
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
                    locala.Frg = ((a.b)localObject3);
                    break;
                    i = 0;
                    break label341;
                    label622:
                    i = 2;
                    break label358;
                    label627:
                    localObject1 = String.format("from_username=%s&to_username=%s", new Object[] { q.encode((String)localObject4), q.encode(str) });
                    if (TextUtils.isEmpty((CharSequence)localObject3))
                    {
                      localObject1 = "?".concat(String.valueOf(localObject1));
                      break label429;
                    }
                    if (((String)localObject3).contains("?"))
                    {
                      if (((String)localObject3).endsWith("?"))
                      {
                        localObject1 = (String)localObject3 + (String)localObject1;
                        break label429;
                      }
                      localObject1 = String.format("%s&%s", new Object[] { localObject3, localObject1 });
                      break label429;
                    }
                    localObject1 = String.format("%s?%s", new Object[] { localObject3, localObject1 });
                    break label429;
                    label767:
                    if (localh.uqI != 2) {
                      break label451;
                    }
                    localObject3 = localh.uqf;
                    localObject4 = this.cXJ.fJy();
                    localObject1 = localObject3;
                    if (!bu.isNullOrNil((String)localObject3))
                    {
                      localObject1 = localObject3;
                      if (localObject4 != null) {
                        if (str != null) {
                          break label828;
                        }
                      }
                    }
                    for (localObject1 = localObject3;; localObject1 = ((Uri.Builder)localObject1).build().toString())
                    {
                      locala.mdj = ((String)localObject1);
                      break;
                      label828:
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
                locala.Fri = ((a.b)localObject3);
                continue;
                locala.Frh = ((a.b)localObject3);
                continue;
                locala.Frj = ((a.b)localObject3);
              }
            }
            label962:
            locala.iconUrl = localh.IconUrl;
            locala.Frk = localh.uqL;
            locala.Frm = 56;
            locala.Frl = 56;
            locala.Fro = new a.a.a()
            {
              public final String fgY()
              {
                AppMethodBeat.i(187305);
                String str = ((d)g.ab(d.class)).dV(j.this.cXJ.getTalkerUserName(), localh.uqG);
                AppMethodBeat.o(187305);
                return str;
              }
            };
            ae.i("GameLife.ChattingComponent", "add AppPanel: enter_id[%s] red_dot[%d] appid[%s] url[%s] title[%s] type[%d]", new Object[] { locala.FqZ, Integer.valueOf(locala.Fra), locala.Frc, locala.mdj, locala.Frg.title, Integer.valueOf(localh.uqG) });
            ((ArrayList)localObject2).add(locala);
          }
        }
        localObject1 = localObject2;
      }
    }
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(187310);
    super.fAx();
    if (!fHq())
    {
      AppMethodBeat.o(187310);
      return;
    }
    ((c)g.ab(c.class)).ajb(this.cXJ.getTalkerUserName());
    AppMethodBeat.o(187310);
  }
  
  public final boolean fHq()
  {
    AppMethodBeat.i(187307);
    boolean bool = an.aUv(this.cXJ.getTalkerUserName());
    AppMethodBeat.o(187307);
    return bool;
  }
  
  public final void fHr()
  {
    AppMethodBeat.i(187308);
    this.cXJ.Kkd.setMMTitle(this.cXJ.Cqh.adG());
    Object localObject = ((com.tencent.mm.plugin.gamelife.a.f)g.ab(com.tencent.mm.plugin.gamelife.a.f.class)).ajf(this.cXJ.getTalkerUserName());
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      ae.e("GameLife.ChattingComponent", "talker username get failed!");
      AppMethodBeat.o(187308);
      return;
    }
    localObject = ((com.tencent.mm.plugin.gamelife.a.b)g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).any((String)localObject);
    if (localObject == null)
    {
      ae.e("GameLife.ChattingComponent", "talker contact get failed!");
      AppMethodBeat.o(187308);
      return;
    }
    if ((!TextUtils.isEmpty(((com.tencent.mm.plugin.gamelife.a.a)localObject).getTag())) && (((com.tencent.mm.plugin.gamelife.a.a)localObject).ddo() == 1)) {
      this.cXJ.Kkd.setMMSubTitle(((com.tencent.mm.plugin.gamelife.a.a)localObject).getTag());
    }
    AppMethodBeat.o(187308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.j
 * JD-Core Version:    0.7.0.1
 */