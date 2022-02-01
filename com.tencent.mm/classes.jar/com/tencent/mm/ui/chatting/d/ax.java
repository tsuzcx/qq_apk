package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.res.Resources;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fn;
import com.tencent.mm.g.b.a.fq;
import com.tencent.mm.g.b.a.fy;
import com.tencent.mm.model.w;
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
import com.tencent.mm.ui.chatting.d.b.m;
import com.tencent.mm.ui.chatting.d.b.y;
import com.tencent.mm.ui.chatting.view.AvatarImageView;
import com.tencent.mm.ui.chatting.viewitems.bk;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fFo=ag.class)
public class ax
  extends a
  implements l.a, ag
{
  private boolean ANB;
  private List<String> ARQ;
  private l JNt;
  private List<String> JNu;
  private boolean JNv;
  private long JNw;
  private boolean JNx;
  private SparseArray<WeakReference<AvatarImageView>> JNy;
  private MenuItem.OnMenuItemClickListener Jmf;
  private long mtj;
  private boolean ruk;
  private boolean rzM;
  private String sessionId;
  private boolean wQj;
  
  public ax()
  {
    AppMethodBeat.i(35625);
    this.JNu = Collections.synchronizedList(new ArrayList());
    this.ARQ = Collections.synchronizedList(new ArrayList());
    this.JNv = false;
    this.ruk = true;
    this.wQj = false;
    this.ANB = false;
    this.JNw = 500L;
    this.mtj = 0L;
    this.sessionId = null;
    this.rzM = false;
    this.JNx = false;
    this.JNy = new SparseArray();
    this.Jmf = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        long l = 1L;
        AppMethodBeat.i(35622);
        if (System.currentTimeMillis() - ax.a(ax.this) <= ax.b(ax.this))
        {
          ad.i("MicroMsg.StoryStateComponent", "onclick pass $clickTime now: %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
          AppMethodBeat.o(35622);
          return true;
        }
        ax.a(ax.this, System.currentTimeMillis());
        ad.i("MicroMsg.StoryStateComponent", "menuItemClickListener clickTime %s storyUserList size %s", new Object[] { Long.valueOf(ax.a(ax.this)), Integer.valueOf(ax.c(ax.this).size()) });
        if (ax.c(ax.this).size() > 0)
        {
          paramAnonymousMenuItem = (String)ax.c(ax.this).get(0);
          ad.i("MicroMsg.StoryStateComponent", "menuItemClickListener click go %s", new Object[] { paramAnonymousMenuItem });
          ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).checkReportFromChatting(1, paramAnonymousMenuItem);
          List localList = ax.d(ax.this);
          ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).enterGallery(localList);
          ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).preLoadVideoViewMgr(paramAnonymousMenuItem);
          paramAnonymousMenuItem = h.ASt;
          h.ejZ().oQ(ax.e(ax.this));
          if (ax.f(ax.this))
          {
            paramAnonymousMenuItem = h.ASt;
            h.ejZ().elh = 4L;
            o.a(ax.this.cWM.JOR.getContext(), ax.c(ax.this), ax.this.cWM.getTalkerUserName(), ax.e(ax.this));
            paramAnonymousMenuItem = h.ASt;
            paramAnonymousMenuItem = h.ejZ();
            if (!ax.g(ax.this)) {
              break label372;
            }
          }
          label372:
          for (l = 1L;; l = 0L)
          {
            paramAnonymousMenuItem.eli = l;
            AppMethodBeat.o(35622);
            return true;
            paramAnonymousMenuItem = h.ASt;
            h.ejZ().elh = 5L;
            o.bi(ax.this.cWM.JOR.getContext(), (String)ax.c(ax.this).get(0));
            break;
          }
        }
        if ((ax.h(ax.this)) && (ax.f(ax.this)))
        {
          paramAnonymousMenuItem = h.ASt;
          paramAnonymousMenuItem = h.ejZ();
          if (ax.g(ax.this)) {}
          for (;;)
          {
            paramAnonymousMenuItem.eli = l;
            o.a(ax.this.cWM.JOR.getContext(), ax.c(ax.this), ax.this.cWM.getTalkerUserName(), ax.e(ax.this));
            paramAnonymousMenuItem = h.ASt;
            h.ejZ().elh = 4L;
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
    if (this.cWM.JOR.findMenuInfo(3) == null)
    {
      this.cWM.JOR.addIconOptionMenu(3, paramInt1, paramOnMenuItemClickListener, paramInt2);
      AppMethodBeat.o(35635);
      return;
    }
    this.cWM.JOR.updateOptionMenu(3, paramInt1, paramOnMenuItemClickListener, paramInt2);
    AppMethodBeat.o(35635);
  }
  
  private void fES()
  {
    AppMethodBeat.i(35632);
    if (this.JNt != null)
    {
      this.JNt.destroy();
      this.JNt.a(null);
      this.JNt = null;
    }
    this.wQj = false;
    this.ANB = false;
    this.JNu.clear();
    this.JNy.clear();
    AppMethodBeat.o(35632);
  }
  
  private void fET()
  {
    AppMethodBeat.i(35640);
    Object localObject;
    if ((this.wQj) && (this.rzM))
    {
      this.rzM = false;
      localObject = h.ASt;
      localObject = h.ekf();
      if (!this.ANB) {
        break label59;
      }
    }
    label59:
    for (long l = 1L;; l = 0L)
    {
      ((fn)localObject).eli = l;
      localObject = h.ASt;
      h.ekg();
      AppMethodBeat.o(35640);
      return;
    }
  }
  
  public final void a(List<String> paramList, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(35637);
    ad.i("MicroMsg.StoryStateComponent", "updateGalleryUserList: size is %s %s hashCode:%s", new Object[] { this.cWM.BYG, Integer.valueOf(paramList.size()), Integer.valueOf(hashCode()) });
    this.JNu.clear();
    this.JNu.addAll(paramList);
    this.ARQ.clear();
    this.ARQ.addAll(paramArrayList);
    AppMethodBeat.o(35637);
  }
  
  public final void al(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(35638);
    m localm = (m)this.cWM.bh(m.class);
    int i;
    if (paramBoolean2) {
      i = 1;
    }
    for (;;)
    {
      localm.adi(i);
      if ((this.wQj != paramBoolean1) || (this.ANB != paramBoolean2)) {
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
    this.wQj = paramBoolean1;
    this.ANB = paramBoolean2;
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35623);
        ((y)ax.this.cWM.bh(y.class)).fEc();
        AppMethodBeat.o(35623);
      }
    });
    fET();
    AppMethodBeat.o(35638);
  }
  
  public final void bW(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(35639);
    ad.i("MicroMsg.StoryStateComponent", "notifyAvatar: ");
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35624);
        int i = 0;
        while (i < ax.i(ax.this).size())
        {
          AvatarImageView localAvatarImageView = (AvatarImageView)((WeakReference)ax.i(ax.this).valueAt(i)).get();
          if (localAvatarImageView != null)
          {
            Object localObject = localAvatarImageView.getTag();
            if (((localObject instanceof bk)) && (paramString.equals(((bk)localObject).userName)))
            {
              localAvatarImageView.fe(((bk)localObject).userName, 5);
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
  
  public final void fCC()
  {
    AppMethodBeat.i(35631);
    super.fCC();
    ad.i("MicroMsg.StoryStateComponent", "onComponentUnInstall: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    fES();
    AppMethodBeat.o(35631);
  }
  
  public final void fEr()
  {
    AppMethodBeat.i(35634);
    int i = com.tencent.mm.n.g.acA().getInt("StoryShouldShowEntraceInChatRoom", 1);
    if ((!this.wQj) || (i == 0))
    {
      ad.i("MicroMsg.StoryStateComponent", "updateMenuItem enable %s", new Object[] { Integer.valueOf(i) });
      this.cWM.JOR.removeOptionMenu(3);
      AppMethodBeat.o(35634);
      return;
    }
    if ((this.JNv) && (o.isShowStoryCheck()))
    {
      ad.i("MicroMsg.StoryStateComponent", "updateMenuItem: hasUnread %s hashCode:%s", new Object[] { Boolean.valueOf(this.ANB), Integer.valueOf(hashCode()) });
      if (this.ANB)
      {
        this.cWM.JOR.removeOptionMenu(3);
        a(2131690613, this.Jmf, this.cWM.JOR.getContext().getResources().getColor(2131099689));
        AppMethodBeat.o(35634);
        return;
      }
      a(2131690614, this.Jmf, 0);
    }
    AppMethodBeat.o(35634);
  }
  
  public final void fwt()
  {
    boolean bool = false;
    AppMethodBeat.i(35626);
    super.fwt();
    ad.i("MicroMsg.StoryStateComponent", "onChattingEnterAnimStart: user %s hashCode:%s", new Object[] { this.cWM.getTalkerUserName(), Integer.valueOf(hashCode()) });
    this.cWM.JOR.removeOptionMenu(3);
    this.wQj = false;
    this.ANB = false;
    this.JNu.clear();
    this.ARQ.clear();
    this.sessionId = "";
    this.JNx = false;
    ((m)this.cWM.bh(m.class)).adi(0);
    Object localObject = this.cWM.getTalkerUserName();
    if (bt.isNullOrNil((String)localObject)) {}
    label275:
    label459:
    label464:
    label480:
    for (;;)
    {
      localObject = this;
      ((ax)localObject).JNv = bool;
      if (this.JNv)
      {
        this.JNt = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryStateFetcher(this.cWM.getTalkerUserName());
        if (this.JNt != null)
        {
          this.JNt.a(this);
          this.JNt.start();
        }
      }
      localObject = h.ASt;
      localObject = h.ekf();
      ((fn)localObject).dTi = ((fn)localObject).t("UserName", this.cWM.getTalkerUserName(), true);
      localObject = h.ASt;
      localObject = h.ekf();
      long l;
      if (this.ruk)
      {
        l = 4L;
        label250:
        ((fn)localObject).elh = l;
        localObject = h.ASt;
        localObject = h.ekf();
        if (!this.ANB) {
          break label459;
        }
        l = 1L;
        ((fn)localObject).eli = l;
        if (!this.ruk) {
          break label464;
        }
      }
      for (this.cWM.jDl = com.tencent.mm.ui.e.aix("4");; this.cWM.jDl = com.tencent.mm.ui.e.aix("5"))
      {
        this.sessionId = this.cWM.aYA();
        AppMethodBeat.o(35626);
        return;
        this.ruk = w.vF((String)localObject);
        if (w.zk((String)localObject))
        {
          bool = w.zk((String)localObject);
          localObject = this;
          break;
        }
        if ((w.zs((String)localObject)) || (w.zE((String)localObject)) || (w.zv((String)localObject)) || (w.zA((String)localObject)) || (w.zH((String)localObject)) || (w.zI((String)localObject)) || (w.Ai((String)localObject)) || (w.An((String)localObject)) || (w.Ap((String)localObject)) || (w.zT((String)localObject)) || (w.zl((String)localObject)) || (w.zk((String)localObject))) {
          break label480;
        }
        bool = true;
        localObject = this;
        break;
        l = 5L;
        break label250;
        l = 0L;
        break label275;
      }
    }
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(35627);
    super.fwu();
    ad.i("MicroMsg.StoryStateComponent", "onChattingEnterAnimEnd: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(35627);
  }
  
  public final void fwv()
  {
    long l2 = 2L;
    AppMethodBeat.i(35628);
    super.fwv();
    ad.i("MicroMsg.StoryStateComponent", "onChattingResume: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    this.rzM = true;
    fET();
    Object localObject;
    if (this.JNt != null)
    {
      this.JNt.resume();
      localObject = h.ASt;
      localObject = h.ejZ();
      if (this.ruk)
      {
        l1 = 10L;
        ((fy)localObject).elh = l1;
        localObject = h.ASt;
        h.ejZ().oO(this.cWM.getTalkerUserName());
        localObject = h.ASt;
        localObject = h.ejZ();
        if (!this.ruk) {
          break label192;
        }
        l1 = 2L;
        label128:
        ((fy)localObject).elL = l1;
      }
    }
    else
    {
      localObject = h.ASt;
      h.ekh().oF(this.cWM.getTalkerUserName());
      localObject = h.ASt;
      localObject = h.ekh();
      if (!this.ruk) {
        break label212;
      }
    }
    for (long l1 = l2;; l1 = i.a.aCc(this.cWM.getTalkerUserName()))
    {
      ((fq)localObject).elL = l1;
      AppMethodBeat.o(35628);
      return;
      l1 = 11L;
      break;
      label192:
      i.a locala = i.ASu;
      l1 = i.a.aCc(this.cWM.getTalkerUserName());
      break label128;
      label212:
      locala = i.ASu;
    }
  }
  
  public final void fww()
  {
    AppMethodBeat.i(35629);
    super.fww();
    this.rzM = false;
    ad.i("MicroMsg.StoryStateComponent", "onChattingPause: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    if (this.JNt != null) {
      this.JNt.pause();
    }
    AppMethodBeat.o(35629);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(35630);
    super.fwx();
    ad.i("MicroMsg.StoryStateComponent", "onChattingExitAnimStart: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    fES();
    h localh = h.ASt;
    h.ejZ().oO("");
    localh = h.ASt;
    h.ejZ().emx = 0L;
    localh = h.ASt;
    h.ejZ().elL = 0L;
    localh = h.ASt;
    h.ekh().oF("");
    localh = h.ASt;
    h.ekh().elL = 0L;
    AppMethodBeat.o(35630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ax
 * JD-Core Version:    0.7.0.1
 */