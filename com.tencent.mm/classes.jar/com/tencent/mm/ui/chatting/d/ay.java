package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.res.Resources;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fp;
import com.tencent.mm.g.b.a.fs;
import com.tencent.mm.g.b.a.ga;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.story.api.l;
import com.tencent.mm.plugin.story.api.l.a;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.h.i;
import com.tencent.mm.plugin.story.h.i.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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

@com.tencent.mm.ui.chatting.d.a.a(fJv=ag.class)
public class ay
  extends a
  implements l.a, ag
{
  private boolean Bfc;
  private List<String> Bjo;
  private MenuItem.OnMenuItemClickListener JGT;
  private l Kiq;
  private List<String> Kir;
  private boolean Kis;
  private long Kit;
  private boolean Kiu;
  private SparseArray<WeakReference<AvatarImageView>> Kiv;
  private long myg;
  private boolean rCw;
  private boolean rHX;
  private String sessionId;
  private boolean xga;
  
  public ay()
  {
    AppMethodBeat.i(35625);
    this.Kir = Collections.synchronizedList(new ArrayList());
    this.Bjo = Collections.synchronizedList(new ArrayList());
    this.Kis = false;
    this.rCw = true;
    this.xga = false;
    this.Bfc = false;
    this.Kit = 500L;
    this.myg = 0L;
    this.sessionId = null;
    this.rHX = false;
    this.Kiu = false;
    this.Kiv = new SparseArray();
    this.JGT = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        long l = 1L;
        AppMethodBeat.i(35622);
        if (System.currentTimeMillis() - ay.a(ay.this) <= ay.b(ay.this))
        {
          ae.i("MicroMsg.StoryStateComponent", "onclick pass $clickTime now: %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
          AppMethodBeat.o(35622);
          return true;
        }
        ay.a(ay.this, System.currentTimeMillis());
        ae.i("MicroMsg.StoryStateComponent", "menuItemClickListener clickTime %s storyUserList size %s", new Object[] { Long.valueOf(ay.a(ay.this)), Integer.valueOf(ay.c(ay.this).size()) });
        if (ay.c(ay.this).size() > 0)
        {
          paramAnonymousMenuItem = (String)ay.c(ay.this).get(0);
          ae.i("MicroMsg.StoryStateComponent", "menuItemClickListener click go %s", new Object[] { paramAnonymousMenuItem });
          ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).checkReportFromChatting(1, paramAnonymousMenuItem);
          List localList = ay.d(ay.this);
          ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).enterGallery(localList);
          ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).preLoadVideoViewMgr(paramAnonymousMenuItem);
          paramAnonymousMenuItem = h.BjR;
          h.enI().pl(ay.e(ay.this));
          if (ay.f(ay.this))
          {
            paramAnonymousMenuItem = h.BjR;
            h.enI().emO = 4L;
            o.a(ay.this.cXJ.Kkd.getContext(), ay.c(ay.this), ay.this.cXJ.getTalkerUserName(), ay.e(ay.this));
            paramAnonymousMenuItem = h.BjR;
            paramAnonymousMenuItem = h.enI();
            if (!ay.g(ay.this)) {
              break label372;
            }
          }
          label372:
          for (l = 1L;; l = 0L)
          {
            paramAnonymousMenuItem.emP = l;
            AppMethodBeat.o(35622);
            return true;
            paramAnonymousMenuItem = h.BjR;
            h.enI().emO = 5L;
            o.bk(ay.this.cXJ.Kkd.getContext(), (String)ay.c(ay.this).get(0));
            break;
          }
        }
        if ((ay.h(ay.this)) && (ay.f(ay.this)))
        {
          paramAnonymousMenuItem = h.BjR;
          paramAnonymousMenuItem = h.enI();
          if (ay.g(ay.this)) {}
          for (;;)
          {
            paramAnonymousMenuItem.emP = l;
            o.a(ay.this.cXJ.Kkd.getContext(), ay.c(ay.this), ay.this.cXJ.getTalkerUserName(), ay.e(ay.this));
            paramAnonymousMenuItem = h.BjR;
            h.enI().emO = 4L;
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
    if (this.cXJ.Kkd.findMenuInfo(3) == null)
    {
      this.cXJ.Kkd.addIconOptionMenu(3, paramInt1, paramOnMenuItemClickListener, paramInt2);
      AppMethodBeat.o(35635);
      return;
    }
    this.cXJ.Kkd.updateOptionMenu(3, paramInt1, paramOnMenuItemClickListener, paramInt2);
    AppMethodBeat.o(35635);
  }
  
  private void fIV()
  {
    AppMethodBeat.i(35632);
    if (this.Kiq != null)
    {
      this.Kiq.destroy();
      this.Kiq.a(null);
      this.Kiq = null;
    }
    this.xga = false;
    this.Bfc = false;
    this.Kir.clear();
    this.Kiv.clear();
    AppMethodBeat.o(35632);
  }
  
  private void fIW()
  {
    AppMethodBeat.i(35640);
    Object localObject;
    if ((this.xga) && (this.rHX))
    {
      this.rHX = false;
      localObject = h.BjR;
      localObject = h.enO();
      if (!this.Bfc) {
        break label59;
      }
    }
    label59:
    for (long l = 1L;; l = 0L)
    {
      ((fp)localObject).emP = l;
      localObject = h.BjR;
      h.enP();
      AppMethodBeat.o(35640);
      return;
    }
  }
  
  public final void a(List<String> paramList, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(35637);
    ae.i("MicroMsg.StoryStateComponent", "updateGalleryUserList: size is %s %s hashCode:%s", new Object[] { this.cXJ.Cqh, Integer.valueOf(paramList.size()), Integer.valueOf(hashCode()) });
    this.Kir.clear();
    this.Kir.addAll(paramList);
    this.Bjo.clear();
    this.Bjo.addAll(paramArrayList);
    AppMethodBeat.o(35637);
  }
  
  public final void ak(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(35638);
    m localm = (m)this.cXJ.bh(m.class);
    int i;
    if (paramBoolean2) {
      i = 1;
    }
    for (;;)
    {
      localm.adP(i);
      if ((this.xga != paramBoolean1) || (this.Bfc != paramBoolean2)) {
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
    ae.i("MicroMsg.StoryStateComponent", "updateChatRoomState: hasStory %s, hasUnread %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.xga = paramBoolean1;
    this.Bfc = paramBoolean2;
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35623);
        ((y)ay.this.cXJ.bh(y.class)).fIf();
        AppMethodBeat.o(35623);
      }
    });
    fIW();
    AppMethodBeat.o(35638);
  }
  
  public final void ca(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(35639);
    ae.i("MicroMsg.StoryStateComponent", "notifyAvatar: ");
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35624);
        int i = 0;
        while (i < ay.i(ay.this).size())
        {
          AvatarImageView localAvatarImageView = (AvatarImageView)((WeakReference)ay.i(ay.this).valueAt(i)).get();
          if (localAvatarImageView != null)
          {
            Object localObject = localAvatarImageView.getTag();
            if (((localObject instanceof bk)) && (paramString.equals(((bk)localObject).userName)))
            {
              localAvatarImageView.fn(((bk)localObject).userName, 5);
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
  
  public final void fAt()
  {
    boolean bool = false;
    AppMethodBeat.i(35626);
    super.fAt();
    ae.i("MicroMsg.StoryStateComponent", "onChattingEnterAnimStart: user %s hashCode:%s", new Object[] { this.cXJ.getTalkerUserName(), Integer.valueOf(hashCode()) });
    this.cXJ.Kkd.removeOptionMenu(3);
    this.xga = false;
    this.Bfc = false;
    this.Kir.clear();
    this.Bjo.clear();
    this.sessionId = "";
    this.Kiu = false;
    ((m)this.cXJ.bh(m.class)).adP(0);
    Object localObject = this.cXJ.getTalkerUserName();
    if (bu.isNullOrNil((String)localObject)) {}
    label273:
    label456:
    label461:
    label477:
    for (;;)
    {
      localObject = this;
      ((ay)localObject).Kis = bool;
      if (this.Kis)
      {
        this.Kiq = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryStateFetcher(this.cXJ.getTalkerUserName());
        if (this.Kiq != null)
        {
          this.Kiq.a(this);
          this.Kiq.start();
        }
      }
      localObject = h.BjR;
      localObject = h.enO();
      ((fp)localObject).dUy = ((fp)localObject).t("UserName", this.cXJ.getTalkerUserName(), true);
      localObject = h.BjR;
      localObject = h.enO();
      long l;
      if (this.rCw)
      {
        l = 4L;
        label248:
        ((fp)localObject).emO = l;
        localObject = h.BjR;
        localObject = h.enO();
        if (!this.Bfc) {
          break label456;
        }
        l = 1L;
        ((fp)localObject).emP = l;
        if (!this.rCw) {
          break label461;
        }
      }
      for (this.cXJ.jGj = com.tencent.mm.ui.e.aju("4");; this.cXJ.jGj = com.tencent.mm.ui.e.aju("5"))
      {
        this.sessionId = this.cXJ.aYW();
        AppMethodBeat.o(35626);
        return;
        this.rCw = x.wb((String)localObject);
        if (x.zU((String)localObject))
        {
          bool = x.zU((String)localObject);
          localObject = this;
          break;
        }
        if ((x.Ac((String)localObject)) || (x.Ao((String)localObject)) || (x.Af((String)localObject)) || (x.Ak((String)localObject)) || (x.Ar((String)localObject)) || (x.As((String)localObject)) || (x.AS((String)localObject)) || (x.AX((String)localObject)) || (x.AZ((String)localObject)) || (x.AD((String)localObject)) || (x.zV((String)localObject)) || (x.zU((String)localObject))) {
          break label477;
        }
        bool = true;
        localObject = this;
        break;
        l = 5L;
        break label248;
        l = 0L;
        break label273;
      }
    }
  }
  
  public final void fAu()
  {
    AppMethodBeat.i(35627);
    super.fAu();
    ae.i("MicroMsg.StoryStateComponent", "onChattingEnterAnimEnd: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(35627);
  }
  
  public final void fAv()
  {
    long l2 = 2L;
    AppMethodBeat.i(35628);
    super.fAv();
    ae.i("MicroMsg.StoryStateComponent", "onChattingResume: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    this.rHX = true;
    fIW();
    Object localObject;
    if (this.Kiq != null)
    {
      this.Kiq.resume();
      localObject = h.BjR;
      localObject = h.enI();
      if (this.rCw)
      {
        l1 = 10L;
        ((ga)localObject).emO = l1;
        localObject = h.BjR;
        h.enI().pj(this.cXJ.getTalkerUserName());
        localObject = h.BjR;
        localObject = h.enI();
        if (!this.rCw) {
          break label192;
        }
        l1 = 2L;
        label128:
        ((ga)localObject).ent = l1;
      }
    }
    else
    {
      localObject = h.BjR;
      h.enQ().pa(this.cXJ.getTalkerUserName());
      localObject = h.BjR;
      localObject = h.enQ();
      if (!this.rCw) {
        break label212;
      }
    }
    for (long l1 = l2;; l1 = i.a.aDv(this.cXJ.getTalkerUserName()))
    {
      ((fs)localObject).ent = l1;
      AppMethodBeat.o(35628);
      return;
      l1 = 11L;
      break;
      label192:
      i.a locala = i.BjS;
      l1 = i.a.aDv(this.cXJ.getTalkerUserName());
      break label128;
      label212:
      locala = i.BjS;
    }
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(35629);
    super.fAw();
    this.rHX = false;
    ae.i("MicroMsg.StoryStateComponent", "onChattingPause: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    if (this.Kiq != null) {
      this.Kiq.pause();
    }
    AppMethodBeat.o(35629);
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(35630);
    super.fAx();
    ae.i("MicroMsg.StoryStateComponent", "onChattingExitAnimStart: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    fIV();
    h localh = h.BjR;
    h.enI().pj("");
    localh = h.BjR;
    h.enI().eog = 0L;
    localh = h.BjR;
    h.enI().ent = 0L;
    localh = h.BjR;
    h.enQ().pa("");
    localh = h.BjR;
    h.enQ().ent = 0L;
    AppMethodBeat.o(35630);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(35631);
    super.fGE();
    ae.i("MicroMsg.StoryStateComponent", "onComponentUnInstall: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    fIV();
    AppMethodBeat.o(35631);
  }
  
  public final void fIv()
  {
    AppMethodBeat.i(35634);
    int i = com.tencent.mm.n.g.acL().getInt("StoryShouldShowEntraceInChatRoom", 1);
    if ((!this.xga) || (i == 0))
    {
      ae.i("MicroMsg.StoryStateComponent", "updateMenuItem enable %s", new Object[] { Integer.valueOf(i) });
      this.cXJ.Kkd.removeOptionMenu(3);
      AppMethodBeat.o(35634);
      return;
    }
    if ((this.Kis) && (o.isShowStoryCheck()))
    {
      ae.i("MicroMsg.StoryStateComponent", "updateMenuItem: hasUnread %s hashCode:%s", new Object[] { Boolean.valueOf(this.Bfc), Integer.valueOf(hashCode()) });
      if (this.Bfc)
      {
        this.cXJ.Kkd.removeOptionMenu(3);
        a(2131690613, this.JGT, this.cXJ.Kkd.getContext().getResources().getColor(2131099689));
        AppMethodBeat.o(35634);
        return;
      }
      a(2131690614, this.JGT, 0);
    }
    AppMethodBeat.o(35634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ay
 * JD-Core Version:    0.7.0.1
 */