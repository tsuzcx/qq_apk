package com.tencent.mm.ui.chatting.component;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.f;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.byp.b.a.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.conv.FinderConvChooseTipsView;
import com.tencent.mm.plugin.finder.conv.o;
import com.tencent.mm.plugin.finder.extension.reddot.b;
import com.tencent.mm.plugin.finder.report.ba;
import com.tencent.mm.plugin.finder.report.f.a;
import com.tencent.mm.plugin.finder.report.f.d;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.plugin.finder.storage.g;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.ac;
import com.tencent.mm.plugin.findersdk.a.bp;
import com.tencent.mm.plugin.findersdk.a.ch;
import com.tencent.mm.plugin.findersdk.a.y;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.protocal.protobuf.bfm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.ad;
import com.tencent.mm.ui.chatting.component.api.x;
import com.tencent.mm.ui.widget.k;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.g.b.s;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=com.tencent.mm.ui.chatting.component.api.i.class)
class i
  extends a
  implements com.tencent.mm.ui.chatting.component.api.i
{
  private com.tencent.mm.ui.blur.f Rpm;
  private MStorage.IOnStorageChange aeqi;
  private final MStorage.IOnStorageChange aeqj;
  
  i()
  {
    AppMethodBeat.i(256182);
    this.aeqi = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(255962);
        if (paramAnonymousMStorageEventData.event.equals(i.this.hlc.Uxa.field_username)) {
          i.a(i.this);
        }
        AppMethodBeat.o(255962);
      }
    };
    this.aeqj = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(255955);
        Log.i("MicroMsg.ChattingBypComponent", "onNotifyChange ".concat(String.valueOf(paramAnonymousString)));
        if ((paramAnonymousMStorageEventData.event.equals("FinderContact")) || (paramAnonymousMStorageEventData.event.equals("FinderMsgContactStorage")))
        {
          bh.bCz();
          paramAnonymousString = c.bzA().JE(i.this.hlc.getTalkerUserName());
          if ((paramAnonymousString != null) && ((int)paramAnonymousString.maN != 0))
          {
            if (Util.isNullOrNil(paramAnonymousString.field_nickname)) {
              paramAnonymousString.setNickname(i.this.hlc.Uxa.field_nickname);
            }
            i.this.hlc.aI(paramAnonymousString);
            ((ad)i.this.hlc.cm(ad.class)).jrB();
            ((ad)i.this.hlc.cm(ad.class)).LZ(true);
            i.this.hlc.dcZ();
            i.this.jrB();
            i.a(i.this);
          }
        }
        AppMethodBeat.o(255955);
      }
    };
    this.Rpm = null;
    AppMethodBeat.o(256182);
  }
  
  private SpannableString c(ch paramch)
  {
    AppMethodBeat.i(256196);
    StringBuilder localStringBuilder1 = new StringBuilder();
    LinkedList localLinkedList = new LinkedList();
    StringBuilder localStringBuilder2 = new StringBuilder();
    Object localObject1;
    long l1;
    long l2;
    int j;
    for (;;)
    {
      try
      {
        if ((paramch instanceof m))
        {
          localObject1 = (m)paramch;
          if ((((m)localObject1).field_badgeInfoList != null) && (((m)localObject1).field_badgeInfoList.ToF != null) && (((m)localObject1).field_badgeInfoList.ToF.size() != 0))
          {
            if (com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adfd, false))
            {
              localObject2 = com.tencent.mm.plugin.finder.live.view.span.h.DWP;
              localLinkedList.addAll(com.tencent.mm.plugin.finder.live.view.span.h.a(((m)localObject1).field_badgeInfoList.ToF, new int[] { 2, 4 }, 1, 0, -1, null));
            }
          }
          else {
            localStringBuilder2.append("isLocalFinderContact=true;");
          }
        }
        else
        {
          l1 = paramch.dUx();
          if (l1 <= 0L) {
            break label404;
          }
          localObject1 = this.hlc.aezO.getContext().getResources().getString(R.l.gIa, new Object[] { Long.valueOf(l1) });
          localStringBuilder2.append("isFinderContact=true;have wecoin;");
          l2 = paramch.dUy();
          if ((l1 != 0L) || (l2 <= 0L)) {
            break label419;
          }
          paramch = this.hlc.aezO.getContext().getResources().getString(R.l.gHZ, new Object[] { Long.valueOf(l2) });
          localStringBuilder2.append("interactionCount=" + l2 + ";");
          j = localLinkedList.size();
          localStringBuilder2.append("spanSize=".concat(String.valueOf(j)));
          i = 0;
          if (i >= j) {
            break;
          }
          localStringBuilder1.append(" ");
          i += 1;
          continue;
        }
        localObject2 = com.tencent.mm.plugin.finder.live.view.span.h.DWP;
        localLinkedList.addAll(com.tencent.mm.plugin.finder.live.view.span.h.a(((m)localObject1).field_badgeInfoList.ToF, new int[] { 4 }, 1, 0, -1, null));
        continue;
        localStringBuilder2.append("isFinderContact=true;no wecoin;");
      }
      catch (Exception paramch)
      {
        Log.e("MicroMsg.ChattingBypComponent", "buildFinderCustomerInfo:" + paramch.getMessage());
        paramch = new SpannableString(localStringBuilder1);
        AppMethodBeat.o(256196);
        return paramch;
      }
      label404:
      localObject1 = "";
      continue;
      label419:
      localStringBuilder2.append("interactionCount=0;");
      paramch = "";
    }
    localStringBuilder1.append((String)localObject1);
    localStringBuilder1.append(paramch);
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty(paramch)) && (j > 0)) {
      localStringBuilder1.append(" ");
    }
    Object localObject2 = new SpannableString(localStringBuilder1);
    int i = 0;
    while (i < j)
    {
      ((SpannableString)localObject2).setSpan(localLinkedList.get(i), i, i + 1, 33);
      i += 1;
    }
    if (l1 > 0L)
    {
      i = localStringBuilder1.indexOf((String)localObject1);
      j = ((String)localObject1).length();
      ((SpannableString)localObject2).setSpan(new k(Color.parseColor("#FF6146"), Color.parseColor("#26FF6146"), com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 18), com.tencent.mm.cd.a.bs(this.hlc.aezO.getContext(), R.f.Edge_A)), i, j + i, 33);
    }
    if ((l1 == 0L) && (l2 > 0L))
    {
      i = localStringBuilder1.indexOf(paramch);
      j = paramch.length();
      ((SpannableString)localObject2).setSpan(new k(Color.parseColor("#FA9D3B"), Color.parseColor("#26FA9D3B"), com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 18), com.tencent.mm.cd.a.bs(this.hlc.aezO.getContext(), R.f.Edge_A)), i, j + i, 33);
    }
    Log.i("MicroMsg.ChattingBypComponent", "buildFinderCustomerInfo:".concat(String.valueOf(localStringBuilder2)));
    AppMethodBeat.o(256196);
    return localObject2;
  }
  
  private void jrC()
  {
    AppMethodBeat.i(256205);
    Object localObject1 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getSessionInfoStorage().aAG(this.hlc.Uxa.field_username);
    ChatFooter localChatFooter = ((x)this.hlc.cm(x.class)).jsd();
    if ((localChatFooter != null) && (au.aAy(this.hlc.Uxa.field_username)))
    {
      Object localObject2 = localChatFooter.getChatFooterPanel();
      if (localObject2 != null)
      {
        ((ChatFooterPanel)localObject2).setShowSearch(false);
        ((ChatFooterPanel)localObject2).bDL();
      }
      if (((o)localObject1).field_disableSendMsg != 1) {}
      Boolean localBoolean;
      for (boolean bool = true;; bool = false)
      {
        localChatFooter.setFooterStatus(bool);
        localObject1 = this.hlc.getSelfUserName();
        localObject2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxu((String)localObject1);
        localBoolean = Boolean.valueOf(au.bwV(this.hlc.getSelfUserName()));
        if (!localBoolean.booleanValue()) {
          break;
        }
        if (localObject2 == null) {
          break label343;
        }
        localChatFooter.a(this.hlc.getSelfUserName(), localBoolean, this.hlc.aezO.getContext().getString(R.l.gIb, new Object[] { ((au)localObject2).aSU() }));
        AppMethodBeat.o(256205);
        return;
      }
      if (((y)com.tencent.mm.kernel.h.ax(y.class)).aAl((String)localObject1) == null)
      {
        if (localObject2 != null) {
          localChatFooter.a(this.hlc.getSelfUserName(), localBoolean, this.hlc.aezO.getContext().getString(R.l.gIb, new Object[] { ((au)localObject2).aSU() }));
        }
        AppMethodBeat.o(256205);
        return;
      }
      bool = au.bwV((String)localObject1);
      if (localObject2 != null) {
        localChatFooter.a(this.hlc.getSelfUserName(), Boolean.valueOf(bool), this.hlc.aezO.getContext().getString(R.l.gIb, new Object[] { ((au)localObject2).aSU() }));
      }
    }
    label343:
    AppMethodBeat.o(256205);
  }
  
  public final boolean bAM(String paramString)
  {
    AppMethodBeat.i(256225);
    boolean bool = au.bwT(paramString);
    AppMethodBeat.o(256225);
    return bool;
  }
  
  public final boolean bwV(String paramString)
  {
    AppMethodBeat.i(256220);
    boolean bool = au.bwV(paramString);
    AppMethodBeat.o(256220);
    return bool;
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(256242);
    super.jjg();
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderGlobalPushNewXmlConsumer().pM(false);
    if (!jrA())
    {
      AppMethodBeat.o(256242);
      return;
    }
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getSessionInfoStorage().add(this.aeqi);
    ((y)com.tencent.mm.kernel.h.ax(y.class)).m(this.aeqj);
    jrB();
    AppMethodBeat.o(256242);
  }
  
  public final void jjh()
  {
    int m = 1;
    AppMethodBeat.i(256236);
    super.jjh();
    if (!jrA())
    {
      AppMethodBeat.o(256236);
      return;
    }
    boolean bool = this.hlc.aezO.getBooleanExtra("key_finder_need_choose_id", false).booleanValue();
    Object localObject1 = this.hlc.aezO.getStringExtra("Chat_User");
    com.tencent.mm.kernel.h.baF();
    int i;
    int j;
    label111:
    int k;
    label153:
    Object localObject2;
    long l;
    if (((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLW((String)localObject1) == 0)
    {
      i = 1;
      if ((com.tencent.mm.model.z.bAW().isEmpty()) && (com.tencent.mm.model.z.bAX().isEmpty())) {
        break label485;
      }
      j = 1;
      if (!bool) {
        break label490;
      }
      k = m;
      if (i == 0)
      {
        k = m;
        if (j == 0)
        {
          localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (!((Boolean)com.tencent.mm.plugin.finder.storage.d.eWx().bmg()).booleanValue()) {
            break label490;
          }
          k = m;
        }
      }
      if (k != 0) {
        this.hlc.ev(new FinderConvChooseTipsView(this.hlc.aezO.getContext()));
      }
      jrC();
      ((com.tencent.mm.plugin.findersdk.a.z)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.findersdk.a.z.class)).aAr(this.hlc.getTalkerUserName());
      if (!Util.isNullOrNil(this.hlc.getTalkerUserName())) {
        com.tencent.threadpool.h.ahAA.bn(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(255960);
            List localList = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().iV(Collections.singletonList("findermessage006"));
            Iterator localIterator = localList.iterator();
            while (localIterator.hasNext())
            {
              cc localcc = (cc)localIterator.next();
              a.a locala = com.tencent.mm.plugin.byp.b.a.waG;
              if (!com.tencent.mm.plugin.byp.b.a.diq().contains(Long.valueOf(localcc.field_msgId)))
              {
                localcc.setStatus(5);
                ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(localcc.field_msgId, localcc);
              }
            }
            Log.i("MicroMsg.ChattingBypComponent", "sending msg size=%s talker=%s username=%s", new Object[] { Integer.valueOf(localList.size()), i.this.hlc.jrh(), i.this.hlc.getTalkerUserName() });
            AppMethodBeat.o(255960);
          }
        });
      }
      localObject2 = ((bp)com.tencent.mm.kernel.h.ax(bp.class)).aAw(this.hlc.getTalkerUserName());
      if (au.bwV(this.hlc.getSelfUserName())) {
        ((ac)com.tencent.mm.kernel.h.ax(ac.class)).aAv(this.hlc.getTalkerUserName());
      }
      localObject1 = com.tencent.mm.plugin.finder.report.f.FnM;
      localObject1 = com.tencent.mm.plugin.finder.report.f.eMm();
      if (!au.bwV((String)localObject2)) {
        break label495;
      }
      l = 2L;
      label316:
      String str = this.hlc.getTalkerUserName();
      s.u(localObject2, "talkUserName");
      s.u(str, "chatName");
      ((f.d)localObject1).Foa = l;
      ((f.d)localObject1).Foc = ((String)localObject2);
      ((f.d)localObject1).Fog = str;
      ((f.d)localObject1).zVt = cn.bDw();
      ((f.d)localObject1).Foe = String.valueOf(((f.d)localObject1).zVt);
      localObject2 = com.tencent.mm.plugin.finder.report.f.FnM;
      if (!com.tencent.mm.plugin.finder.report.f.eMj().FuC) {
        break label501;
      }
      localObject2 = com.tencent.mm.plugin.finder.report.f.FnM;
      ((f.d)localObject1).Fod = com.tencent.mm.plugin.finder.report.f.eMj().FuD.FnU;
    }
    for (;;)
    {
      Log.i(((f.d)localObject1).TAG, "onEnterChat:talkUserNameL" + ((f.d)localObject1).Foc + ", chatNameL" + ((f.d)localObject1).Fog + "， accountTypeL" + ((f.d)localObject1).Foa);
      AppMethodBeat.o(256236);
      return;
      i = 0;
      break;
      label485:
      j = 0;
      break label111;
      label490:
      k = 0;
      break label153;
      label495:
      l = 1L;
      break label316;
      label501:
      localObject2 = com.tencent.mm.plugin.finder.report.f.FnM;
      if (com.tencent.mm.plugin.finder.report.f.eMi().FuC)
      {
        localObject2 = com.tencent.mm.plugin.finder.report.f.FnM;
        ((f.d)localObject1).Fod = com.tencent.mm.plugin.finder.report.f.eMi().FuD.FnU;
      }
    }
  }
  
  public final void jjl()
  {
    AppMethodBeat.i(256254);
    super.jjl();
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderGlobalPushNewXmlConsumer().pM(true);
    if (!jrA())
    {
      AppMethodBeat.o(256254);
      return;
    }
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getConversationStorage().aAB(this.hlc.getTalkerUserName());
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getSessionInfoStorage().remove(this.aeqi);
    ((y)com.tencent.mm.kernel.h.ax(y.class)).l(this.aeqj);
    String str1;
    String str2;
    if (au.bwV(((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getSessionInfoStorage().aAG(this.hlc.Uxa.field_username).field_talker))
    {
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().AQv.dZa();
      if (this.Rpm != null) {
        this.Rpm.destroy();
      }
      str1 = this.hlc.getTalkerUserName();
      str2 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
      if ((this.hlc == null) || (this.hlc.aezO.getContext() == null)) {
        break label303;
      }
    }
    label303:
    for (int i = this.hlc.aezO.getContext().getIntent().getIntExtra("key_from_comment_scene", 0);; i = 0)
    {
      Object localObject1 = as.GSQ;
      localObject1 = as.a.Vs(i + 100);
      Object localObject2 = com.tencent.mm.plugin.finder.report.f.FnM;
      localObject2 = com.tencent.mm.plugin.finder.report.f.eMm();
      if (str1 == null) {
        str1 = "";
      }
      for (;;)
      {
        ((f.d)localObject2).b(str1, i, str2, (String)localObject1);
        AppMethodBeat.o(256254);
        return;
        ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().AQv.dYZ();
        break;
      }
    }
  }
  
  public final boolean jrA()
  {
    AppMethodBeat.i(256215);
    boolean bool = au.aAy(this.hlc.getTalkerUserName());
    AppMethodBeat.o(256215);
    return bool;
  }
  
  public final void jrB()
  {
    AppMethodBeat.i(256245);
    String str = ((bp)com.tencent.mm.kernel.h.ax(bp.class)).aAw(this.hlc.getTalkerUserName());
    boolean bool = au.bwV(str);
    Object localObject1 = "";
    Object localObject3;
    Object localObject2;
    if (Boolean.valueOf(bool).booleanValue())
    {
      localObject3 = ((y)com.tencent.mm.kernel.h.ax(y.class)).aAl(str);
      if (localObject3 != null) {
        localObject1 = ((ch)localObject3).aSV();
      }
      localObject2 = localObject1;
      if (((m)localObject3).field_authInfo != null)
      {
        localObject2 = av.GiL;
        av.a(((ad)this.hlc.cm(ad.class)).jsU(), ((m)localObject3).field_authInfo, 1, null);
        localObject2 = localObject1;
      }
      if (localObject2 != null) {
        break label239;
      }
      ((ad)this.hlc.cm(ad.class)).setMMTitle("");
    }
    for (;;)
    {
      localObject1 = ((y)com.tencent.mm.kernel.h.ax(y.class)).aAo(str);
      ((ad)this.hlc.cm(ad.class)).b(c((ch)localObject1));
      AppMethodBeat.o(256245);
      return;
      localObject3 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxu(str);
      localObject2 = localObject1;
      if (localObject3 == null) {
        break;
      }
      localObject2 = ((au)localObject3).aSU();
      break;
      label239:
      ((ad)this.hlc.cm(ad.class)).setMMTitle((CharSequence)localObject2);
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(256258);
    if ((paramInt1 == 1010) && (paramIntent != null) && (paramIntent.getBooleanExtra("KEY_HAS_CHANGE_ROLE", false)))
    {
      this.hlc.aezO.getContext().finish();
      this.hlc.aezO.getContext().overridePendingTransition(R.a.anim_not_change, R.a.sight_slide_bottom_out);
    }
    AppMethodBeat.o(256258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.i
 * JD-Core Version:    0.7.0.1
 */