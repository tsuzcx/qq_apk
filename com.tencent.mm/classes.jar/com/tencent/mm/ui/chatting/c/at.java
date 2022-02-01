package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.res.Resources;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.da;
import com.tencent.mm.g.b.a.dd;
import com.tencent.mm.g.b.a.dl;
import com.tencent.mm.plugin.story.api.l;
import com.tencent.mm.plugin.story.api.l.a;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.h.i;
import com.tencent.mm.plugin.story.h.i.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.k;
import com.tencent.mm.ui.chatting.view.AvatarImageView;
import com.tencent.mm.ui.chatting.viewitems.bi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(eYT=ae.class)
public class at
  extends a
  implements l.a, ae
{
  private MenuItem.OnMenuItemClickListener FYz;
  private boolean GyA;
  private SparseArray<WeakReference<AvatarImageView>> GyB;
  private l Gyw;
  private List<String> Gyx;
  private boolean Gyy;
  private long Gyz;
  private long lrz;
  private boolean qbC;
  private boolean qhl;
  private String sessionId;
  private boolean uAj;
  private boolean yiG;
  private List<String> ymS;
  
  public at()
  {
    AppMethodBeat.i(35625);
    this.Gyx = Collections.synchronizedList(new ArrayList());
    this.ymS = Collections.synchronizedList(new ArrayList());
    this.Gyy = false;
    this.qbC = true;
    this.uAj = false;
    this.yiG = false;
    this.Gyz = 500L;
    this.lrz = 0L;
    this.sessionId = null;
    this.qhl = false;
    this.GyA = false;
    this.GyB = new SparseArray();
    this.FYz = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        long l = 1L;
        AppMethodBeat.i(35622);
        if (System.currentTimeMillis() - at.a(at.this) <= at.b(at.this))
        {
          ad.i("MicroMsg.StoryStateComponent", "onclick pass $clickTime now: %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
          AppMethodBeat.o(35622);
          return true;
        }
        at.a(at.this, System.currentTimeMillis());
        ad.i("MicroMsg.StoryStateComponent", "menuItemClickListener clickTime %s storyUserList size %s", new Object[] { Long.valueOf(at.a(at.this)), Integer.valueOf(at.c(at.this).size()) });
        if (at.c(at.this).size() > 0)
        {
          paramAnonymousMenuItem = (String)at.c(at.this).get(0);
          ad.i("MicroMsg.StoryStateComponent", "menuItemClickListener click go %s", new Object[] { paramAnonymousMenuItem });
          ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).checkReportFromChatting(1, paramAnonymousMenuItem);
          List localList = at.d(at.this);
          ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).enterGallery(localList);
          ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).preLoadVideoViewMgr(paramAnonymousMenuItem);
          paramAnonymousMenuItem = h.ynv;
          h.dJj().jN(at.e(at.this));
          if (at.f(at.this))
          {
            paramAnonymousMenuItem = h.ynv;
            h.dJj().dTd = 4L;
            o.a(at.this.cOd.GzJ.getContext(), at.c(at.this), at.this.cOd.getTalkerUserName(), at.e(at.this));
            paramAnonymousMenuItem = h.ynv;
            paramAnonymousMenuItem = h.dJj();
            if (!at.g(at.this)) {
              break label372;
            }
          }
          label372:
          for (l = 1L;; l = 0L)
          {
            paramAnonymousMenuItem.dTe = l;
            AppMethodBeat.o(35622);
            return true;
            paramAnonymousMenuItem = h.ynv;
            h.dJj().dTd = 5L;
            o.be(at.this.cOd.GzJ.getContext(), (String)at.c(at.this).get(0));
            break;
          }
        }
        if ((at.h(at.this)) && (at.f(at.this)))
        {
          paramAnonymousMenuItem = h.ynv;
          paramAnonymousMenuItem = h.dJj();
          if (at.g(at.this)) {}
          for (;;)
          {
            paramAnonymousMenuItem.dTe = l;
            o.a(at.this.cOd.GzJ.getContext(), at.c(at.this), at.this.cOd.getTalkerUserName(), at.e(at.this));
            paramAnonymousMenuItem = h.ynv;
            h.dJj().dTd = 4L;
            AppMethodBeat.o(35622);
            return true;
            l = 0L;
          }
        }
        AppMethodBeat.o(35622);
        return false;
      }
    };
    AppMethodBeat.o(35625);
  }
  
  private void a(int paramInt1, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt2)
  {
    AppMethodBeat.i(35635);
    if (this.cOd.GzJ.findMenuInfo(3) == null)
    {
      this.cOd.GzJ.addIconOptionMenu(3, paramInt1, paramOnMenuItemClickListener, paramInt2);
      AppMethodBeat.o(35635);
      return;
    }
    this.cOd.GzJ.updateOptionMenu(3, paramInt1, paramOnMenuItemClickListener, paramInt2);
    AppMethodBeat.o(35635);
  }
  
  private void eYC()
  {
    AppMethodBeat.i(35632);
    if (this.Gyw != null)
    {
      this.Gyw.destroy();
      this.Gyw.a(null);
      this.Gyw = null;
    }
    this.uAj = false;
    this.yiG = false;
    this.Gyx.clear();
    this.GyB.clear();
    AppMethodBeat.o(35632);
  }
  
  private void eYD()
  {
    AppMethodBeat.i(35640);
    Object localObject;
    if ((this.uAj) && (this.qhl))
    {
      this.qhl = false;
      localObject = h.ynv;
      localObject = h.dJp();
      if (!this.yiG) {
        break label59;
      }
    }
    label59:
    for (long l = 1L;; l = 0L)
    {
      ((da)localObject).dTe = l;
      localObject = h.ynv;
      h.dJq();
      AppMethodBeat.o(35640);
      return;
    }
  }
  
  public final void a(AvatarImageView paramAvatarImageView)
  {
    AppMethodBeat.i(35633);
    Object localObject = paramAvatarImageView.getTag();
    if ((localObject instanceof bi))
    {
      paramAvatarImageView.eE(((bi)localObject).userName, 5);
      localObject = ((bi)localObject).userName;
      if ((o.isShowStoryCheck()) && (this.Gyw != null)) {
        break label82;
      }
    }
    label82:
    for (boolean bool = false;; bool = this.Gyw.ard((String)localObject))
    {
      paramAvatarImageView.setShowStoryHint(bool);
      this.GyB.put(paramAvatarImageView.hashCode(), new WeakReference(paramAvatarImageView));
      AppMethodBeat.o(35633);
      return;
    }
  }
  
  public final void a(List<String> paramList, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(35637);
    ad.i("MicroMsg.StoryStateComponent", "updateGalleryUserList: size is %s %s hashCode:%s", new Object[] { this.cOd.zgX, Integer.valueOf(paramList.size()), Integer.valueOf(hashCode()) });
    this.Gyx.clear();
    this.Gyx.addAll(paramList);
    this.ymS.clear();
    this.ymS.addAll(paramArrayList);
    AppMethodBeat.o(35637);
  }
  
  public final void ae(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(35638);
    k localk = (k)this.cOd.be(k.class);
    int i;
    if (paramBoolean2) {
      i = 1;
    }
    for (;;)
    {
      localk.YL(i);
      if ((this.uAj != paramBoolean1) || (this.yiG != paramBoolean2)) {
        break;
      }
      AppMethodBeat.o(35638);
      return;
      if (paramBoolean1) {
        i = 2;
      } else {
        i = 0;
      }
    }
    ad.i("MicroMsg.StoryStateComponent", "updateChatRoomState: hasStory %s, hasUnread %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.uAj = paramBoolean1;
    this.yiG = paramBoolean2;
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35623);
        ((com.tencent.mm.ui.chatting.c.b.w)at.this.cOd.be(com.tencent.mm.ui.chatting.c.b.w.class)).eXT();
        AppMethodBeat.o(35623);
      }
    });
    eYD();
    AppMethodBeat.o(35638);
  }
  
  public final void bI(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(35639);
    ad.i("MicroMsg.StoryStateComponent", "notifyAvatar: ");
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35624);
        int i = 0;
        while (i < at.i(at.this).size())
        {
          AvatarImageView localAvatarImageView = (AvatarImageView)((WeakReference)at.i(at.this).valueAt(i)).get();
          if (localAvatarImageView != null)
          {
            Object localObject = localAvatarImageView.getTag();
            if (((localObject instanceof bi)) && (paramString.equals(((bi)localObject).userName)))
            {
              localAvatarImageView.eE(((bi)localObject).userName, 5);
              localAvatarImageView.setShowStoryHint(paramBoolean);
            }
          }
          i += 1;
        }
        AppMethodBeat.o(35624);
      }
    });
    AppMethodBeat.o(35639);
  }
  
  public final void eQB()
  {
    boolean bool = false;
    AppMethodBeat.i(35626);
    super.eQB();
    ad.i("MicroMsg.StoryStateComponent", "onChattingEnterAnimStart: user %s hashCode:%s", new Object[] { this.cOd.getTalkerUserName(), Integer.valueOf(hashCode()) });
    this.cOd.GzJ.removeOptionMenu(3);
    this.uAj = false;
    this.yiG = false;
    this.Gyx.clear();
    this.ymS.clear();
    this.sessionId = "";
    this.GyA = false;
    ((k)this.cOd.be(k.class)).YL(0);
    Object localObject = this.cOd.getTalkerUserName();
    if (bt.isNullOrNil((String)localObject)) {}
    label276:
    label460:
    label465:
    label481:
    for (;;)
    {
      localObject = this;
      ((at)localObject).Gyy = bool;
      if (this.Gyy)
      {
        this.Gyw = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryStateFetcher(this.cOd.getTalkerUserName());
        if (this.Gyw != null)
        {
          this.Gyw.a(this);
          this.Gyw.start();
        }
      }
      localObject = h.ynv;
      localObject = h.dJp();
      ((da)localObject).dTc = ((da)localObject).t("UserName", this.cOd.getTalkerUserName(), true);
      localObject = h.ynv;
      localObject = h.dJp();
      long l;
      if (this.qbC)
      {
        l = 4L;
        label251:
        ((da)localObject).dTd = l;
        localObject = h.ynv;
        localObject = h.dJp();
        if (!this.yiG) {
          break label460;
        }
        l = 1L;
        ((da)localObject).dTe = l;
        if (!this.qbC) {
          break label465;
        }
      }
      for (this.cOd.GzN = com.tencent.mm.ui.e.aJX("4");; this.cOd.GzN = com.tencent.mm.ui.e.aJX("5"))
      {
        this.sessionId = this.cOd.eYW();
        AppMethodBeat.o(35626);
        return;
        this.qbC = com.tencent.mm.model.w.pF((String)localObject);
        if (com.tencent.mm.model.w.sm((String)localObject))
        {
          bool = com.tencent.mm.model.w.sm((String)localObject);
          localObject = this;
          break;
        }
        if ((com.tencent.mm.model.w.st((String)localObject)) || (com.tencent.mm.model.w.sE((String)localObject)) || (com.tencent.mm.model.w.sw((String)localObject)) || (com.tencent.mm.model.w.sA((String)localObject)) || (com.tencent.mm.model.w.sH((String)localObject)) || (com.tencent.mm.model.w.sI((String)localObject)) || (com.tencent.mm.model.w.ti((String)localObject)) || (com.tencent.mm.model.w.tn((String)localObject)) || (com.tencent.mm.model.w.to((String)localObject)) || (com.tencent.mm.model.w.sT((String)localObject)) || (com.tencent.mm.model.w.sn((String)localObject)) || (com.tencent.mm.model.w.sm((String)localObject))) {
          break label481;
        }
        bool = true;
        localObject = this;
        break;
        l = 5L;
        break label251;
        l = 0L;
        break label276;
      }
    }
  }
  
  public final void eQC()
  {
    AppMethodBeat.i(35627);
    super.eQC();
    ad.i("MicroMsg.StoryStateComponent", "onChattingEnterAnimEnd: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(35627);
  }
  
  public final void eQD()
  {
    long l2 = 2L;
    AppMethodBeat.i(35628);
    super.eQD();
    ad.i("MicroMsg.StoryStateComponent", "onChattingResume: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    this.qhl = true;
    eYD();
    Object localObject;
    if (this.Gyw != null)
    {
      this.Gyw.resume();
      localObject = h.ynv;
      localObject = h.dJj();
      if (this.qbC)
      {
        l1 = 10L;
        ((dl)localObject).dTd = l1;
        localObject = h.ynv;
        h.dJj().jL(this.cOd.getTalkerUserName());
        localObject = h.ynv;
        localObject = h.dJj();
        if (!this.qbC) {
          break label192;
        }
        l1 = 2L;
        label128:
        ((dl)localObject).dTH = l1;
      }
    }
    else
    {
      localObject = h.ynv;
      h.dJr().jC(this.cOd.getTalkerUserName());
      localObject = h.ynv;
      localObject = h.dJr();
      if (!this.qbC) {
        break label212;
      }
    }
    for (long l1 = l2;; l1 = i.a.arP(this.cOd.getTalkerUserName()))
    {
      ((dd)localObject).dTH = l1;
      AppMethodBeat.o(35628);
      return;
      l1 = 11L;
      break;
      label192:
      i.a locala = i.ynw;
      l1 = i.a.arP(this.cOd.getTalkerUserName());
      break label128;
      label212:
      locala = i.ynw;
    }
  }
  
  public final void eQE()
  {
    AppMethodBeat.i(35629);
    super.eQE();
    this.qhl = false;
    ad.i("MicroMsg.StoryStateComponent", "onChattingPause: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    if (this.Gyw != null) {
      this.Gyw.pause();
    }
    AppMethodBeat.o(35629);
  }
  
  public final void eQF()
  {
    AppMethodBeat.i(35630);
    super.eQF();
    ad.i("MicroMsg.StoryStateComponent", "onChattingExitAnimStart: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    eYC();
    h localh = h.ynv;
    h.dJj().jL("");
    localh = h.ynv;
    h.dJj().dUv = 0L;
    localh = h.ynv;
    h.dJj().dTH = 0L;
    localh = h.ynv;
    h.dJr().jC("");
    localh = h.ynv;
    h.dJr().dTH = 0L;
    AppMethodBeat.o(35630);
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(35631);
    super.eWx();
    ad.i("MicroMsg.StoryStateComponent", "onComponentUnInstall: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    eYC();
    AppMethodBeat.o(35631);
  }
  
  public final void eYi()
  {
    AppMethodBeat.i(35634);
    int i = com.tencent.mm.m.g.Zd().getInt("StoryShouldShowEntraceInChatRoom", 1);
    if ((!this.uAj) || (i == 0))
    {
      ad.i("MicroMsg.StoryStateComponent", "updateMenuItem enable %s", new Object[] { Integer.valueOf(i) });
      this.cOd.GzJ.removeOptionMenu(3);
      AppMethodBeat.o(35634);
      return;
    }
    if ((this.Gyy) && (o.isShowStoryCheck()))
    {
      ad.i("MicroMsg.StoryStateComponent", "updateMenuItem: hasUnread %s hashCode:%s", new Object[] { Boolean.valueOf(this.yiG), Integer.valueOf(hashCode()) });
      if (this.yiG)
      {
        this.cOd.GzJ.removeOptionMenu(3);
        a(2131690613, this.FYz, this.cOd.GzJ.getContext().getResources().getColor(2131099689));
        AppMethodBeat.o(35634);
        return;
      }
      a(2131690614, this.FYz, 0);
    }
    AppMethodBeat.o(35634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.at
 * JD-Core Version:    0.7.0.1
 */