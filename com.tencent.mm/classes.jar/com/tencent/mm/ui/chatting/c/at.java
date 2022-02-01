package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.res.Resources;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.eo;
import com.tencent.mm.g.b.a.er;
import com.tencent.mm.g.b.a.ez;
import com.tencent.mm.plugin.story.api.l;
import com.tencent.mm.plugin.story.api.l.a;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.h.i;
import com.tencent.mm.plugin.story.h.i.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.k;
import com.tencent.mm.ui.chatting.view.AvatarImageView;
import com.tencent.mm.ui.chatting.viewitems.bj;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(foJ=ae.class)
public class at
  extends a
  implements l.a, ae
{
  private l HYn;
  private List<String> HYo;
  private boolean HYp;
  private long HYq;
  private boolean HYr;
  private SparseArray<WeakReference<AvatarImageView>> HYs;
  private MenuItem.OnMenuItemClickListener Hyo;
  private long lTu;
  private boolean qKi;
  private boolean qPN;
  private String sessionId;
  private boolean vJc;
  private List<String> zAr;
  private boolean zvF;
  
  public at()
  {
    AppMethodBeat.i(35625);
    this.HYo = Collections.synchronizedList(new ArrayList());
    this.zAr = Collections.synchronizedList(new ArrayList());
    this.HYp = false;
    this.qKi = true;
    this.vJc = false;
    this.zvF = false;
    this.HYq = 500L;
    this.lTu = 0L;
    this.sessionId = null;
    this.qPN = false;
    this.HYr = false;
    this.HYs = new SparseArray();
    this.Hyo = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        long l = 1L;
        AppMethodBeat.i(35622);
        if (System.currentTimeMillis() - at.a(at.this) <= at.b(at.this))
        {
          ac.i("MicroMsg.StoryStateComponent", "onclick pass $clickTime now: %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
          AppMethodBeat.o(35622);
          return true;
        }
        at.a(at.this, System.currentTimeMillis());
        ac.i("MicroMsg.StoryStateComponent", "menuItemClickListener clickTime %s storyUserList size %s", new Object[] { Long.valueOf(at.a(at.this)), Integer.valueOf(at.c(at.this).size()) });
        if (at.c(at.this).size() > 0)
        {
          paramAnonymousMenuItem = (String)at.c(at.this).get(0);
          ac.i("MicroMsg.StoryStateComponent", "menuItemClickListener click go %s", new Object[] { paramAnonymousMenuItem });
          ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).checkReportFromChatting(1, paramAnonymousMenuItem);
          List localList = at.d(at.this);
          ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).enterGallery(localList);
          ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).preLoadVideoViewMgr(paramAnonymousMenuItem);
          paramAnonymousMenuItem = h.zAU;
          h.dXK().mD(at.e(at.this));
          if (at.f(at.this))
          {
            paramAnonymousMenuItem = h.zAU;
            h.dXK().dUP = 4L;
            o.a(at.this.cLy.HZF.getContext(), at.c(at.this), at.this.cLy.getTalkerUserName(), at.e(at.this));
            paramAnonymousMenuItem = h.zAU;
            paramAnonymousMenuItem = h.dXK();
            if (!at.g(at.this)) {
              break label372;
            }
          }
          label372:
          for (l = 1L;; l = 0L)
          {
            paramAnonymousMenuItem.dUQ = l;
            AppMethodBeat.o(35622);
            return true;
            paramAnonymousMenuItem = h.zAU;
            h.dXK().dUP = 5L;
            o.bf(at.this.cLy.HZF.getContext(), (String)at.c(at.this).get(0));
            break;
          }
        }
        if ((at.h(at.this)) && (at.f(at.this)))
        {
          paramAnonymousMenuItem = h.zAU;
          paramAnonymousMenuItem = h.dXK();
          if (at.g(at.this)) {}
          for (;;)
          {
            paramAnonymousMenuItem.dUQ = l;
            o.a(at.this.cLy.HZF.getContext(), at.c(at.this), at.this.cLy.getTalkerUserName(), at.e(at.this));
            paramAnonymousMenuItem = h.zAU;
            h.dXK().dUP = 4L;
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
    if (this.cLy.HZF.findMenuInfo(3) == null)
    {
      this.cLy.HZF.addIconOptionMenu(3, paramInt1, paramOnMenuItemClickListener, paramInt2);
      AppMethodBeat.o(35635);
      return;
    }
    this.cLy.HZF.updateOptionMenu(3, paramInt1, paramOnMenuItemClickListener, paramInt2);
    AppMethodBeat.o(35635);
  }
  
  private void foo()
  {
    AppMethodBeat.i(35632);
    if (this.HYn != null)
    {
      this.HYn.destroy();
      this.HYn.a(null);
      this.HYn = null;
    }
    this.vJc = false;
    this.zvF = false;
    this.HYo.clear();
    this.HYs.clear();
    AppMethodBeat.o(35632);
  }
  
  private void fop()
  {
    AppMethodBeat.i(35640);
    Object localObject;
    if ((this.vJc) && (this.qPN))
    {
      this.qPN = false;
      localObject = h.zAU;
      localObject = h.dXQ();
      if (!this.zvF) {
        break label59;
      }
    }
    label59:
    for (long l = 1L;; l = 0L)
    {
      ((eo)localObject).dUQ = l;
      localObject = h.zAU;
      h.dXR();
      AppMethodBeat.o(35640);
      return;
    }
  }
  
  public final void a(AvatarImageView paramAvatarImageView)
  {
    AppMethodBeat.i(35633);
    Object localObject = paramAvatarImageView.getTag();
    if ((localObject instanceof bj))
    {
      paramAvatarImageView.eM(((bj)localObject).userName, 5);
      localObject = ((bj)localObject).userName;
      if ((o.isShowStoryCheck()) && (this.HYn != null)) {
        break label82;
      }
    }
    label82:
    for (boolean bool = false;; bool = this.HYn.awm((String)localObject))
    {
      paramAvatarImageView.setShowStoryHint(bool);
      this.HYs.put(paramAvatarImageView.hashCode(), new WeakReference(paramAvatarImageView));
      AppMethodBeat.o(35633);
      return;
    }
  }
  
  public final void a(List<String> paramList, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(35637);
    ac.i("MicroMsg.StoryStateComponent", "updateGalleryUserList: size is %s %s hashCode:%s", new Object[] { this.cLy.AzG, Integer.valueOf(paramList.size()), Integer.valueOf(hashCode()) });
    this.HYo.clear();
    this.HYo.addAll(paramList);
    this.zAr.clear();
    this.zAr.addAll(paramArrayList);
    AppMethodBeat.o(35637);
  }
  
  public final void ah(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(35638);
    k localk = (k)this.cLy.bf(k.class);
    int i;
    if (paramBoolean2) {
      i = 1;
    }
    for (;;)
    {
      localk.aaW(i);
      if ((this.vJc != paramBoolean1) || (this.zvF != paramBoolean2)) {
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
    ac.i("MicroMsg.StoryStateComponent", "updateChatRoomState: hasStory %s, hasUnread %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.vJc = paramBoolean1;
    this.zvF = paramBoolean2;
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35623);
        ((com.tencent.mm.ui.chatting.c.b.w)at.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.w.class)).fnF();
        AppMethodBeat.o(35623);
      }
    });
    fop();
    AppMethodBeat.o(35638);
  }
  
  public final void bP(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(35639);
    ac.i("MicroMsg.StoryStateComponent", "notifyAvatar: ");
    ap.f(new Runnable()
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
            if (((localObject instanceof bj)) && (paramString.equals(((bj)localObject).userName)))
            {
              localAvatarImageView.eM(((bj)localObject).userName, 5);
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
  
  public final void fgh()
  {
    boolean bool = false;
    AppMethodBeat.i(35626);
    super.fgh();
    ac.i("MicroMsg.StoryStateComponent", "onChattingEnterAnimStart: user %s hashCode:%s", new Object[] { this.cLy.getTalkerUserName(), Integer.valueOf(hashCode()) });
    this.cLy.HZF.removeOptionMenu(3);
    this.vJc = false;
    this.zvF = false;
    this.HYo.clear();
    this.zAr.clear();
    this.sessionId = "";
    this.HYr = false;
    ((k)this.cLy.bf(k.class)).aaW(0);
    Object localObject = this.cLy.getTalkerUserName();
    if (bs.isNullOrNil((String)localObject)) {}
    label276:
    label460:
    label465:
    label481:
    for (;;)
    {
      localObject = this;
      ((at)localObject).HYp = bool;
      if (this.HYp)
      {
        this.HYn = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryStateFetcher(this.cLy.getTalkerUserName());
        if (this.HYn != null)
        {
          this.HYn.a(this);
          this.HYn.start();
        }
      }
      localObject = h.zAU;
      localObject = h.dXQ();
      ((eo)localObject).dGd = ((eo)localObject).t("UserName", this.cLy.getTalkerUserName(), true);
      localObject = h.zAU;
      localObject = h.dXQ();
      long l;
      if (this.qKi)
      {
        l = 4L;
        label251:
        ((eo)localObject).dUP = l;
        localObject = h.zAU;
        localObject = h.dXQ();
        if (!this.zvF) {
          break label460;
        }
        l = 1L;
        ((eo)localObject).dUQ = l;
        if (!this.qKi) {
          break label465;
        }
      }
      for (this.cLy.jjx = com.tencent.mm.ui.e.aPv("4");; this.cLy.jjx = com.tencent.mm.ui.e.aPv("5"))
      {
        this.sessionId = this.cLy.aVg();
        AppMethodBeat.o(35626);
        return;
        this.qKi = com.tencent.mm.model.w.sQ((String)localObject);
        if (com.tencent.mm.model.w.wp((String)localObject))
        {
          bool = com.tencent.mm.model.w.wp((String)localObject);
          localObject = this;
          break;
        }
        if ((com.tencent.mm.model.w.ww((String)localObject)) || (com.tencent.mm.model.w.wH((String)localObject)) || (com.tencent.mm.model.w.wz((String)localObject)) || (com.tencent.mm.model.w.wD((String)localObject)) || (com.tencent.mm.model.w.wK((String)localObject)) || (com.tencent.mm.model.w.wL((String)localObject)) || (com.tencent.mm.model.w.xl((String)localObject)) || (com.tencent.mm.model.w.xq((String)localObject)) || (com.tencent.mm.model.w.xr((String)localObject)) || (com.tencent.mm.model.w.wW((String)localObject)) || (com.tencent.mm.model.w.wq((String)localObject)) || (com.tencent.mm.model.w.wp((String)localObject))) {
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
  
  public final void fgi()
  {
    AppMethodBeat.i(35627);
    super.fgi();
    ac.i("MicroMsg.StoryStateComponent", "onChattingEnterAnimEnd: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(35627);
  }
  
  public final void fgj()
  {
    long l2 = 2L;
    AppMethodBeat.i(35628);
    super.fgj();
    ac.i("MicroMsg.StoryStateComponent", "onChattingResume: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    this.qPN = true;
    fop();
    Object localObject;
    if (this.HYn != null)
    {
      this.HYn.resume();
      localObject = h.zAU;
      localObject = h.dXK();
      if (this.qKi)
      {
        l1 = 10L;
        ((ez)localObject).dUP = l1;
        localObject = h.zAU;
        h.dXK().mB(this.cLy.getTalkerUserName());
        localObject = h.zAU;
        localObject = h.dXK();
        if (!this.qKi) {
          break label192;
        }
        l1 = 2L;
        label128:
        ((ez)localObject).dVt = l1;
      }
    }
    else
    {
      localObject = h.zAU;
      h.dXS().ms(this.cLy.getTalkerUserName());
      localObject = h.zAU;
      localObject = h.dXS();
      if (!this.qKi) {
        break label212;
      }
    }
    for (long l1 = l2;; l1 = i.a.awY(this.cLy.getTalkerUserName()))
    {
      ((er)localObject).dVt = l1;
      AppMethodBeat.o(35628);
      return;
      l1 = 11L;
      break;
      label192:
      i.a locala = i.zAV;
      l1 = i.a.awY(this.cLy.getTalkerUserName());
      break label128;
      label212:
      locala = i.zAV;
    }
  }
  
  public final void fgk()
  {
    AppMethodBeat.i(35629);
    super.fgk();
    this.qPN = false;
    ac.i("MicroMsg.StoryStateComponent", "onChattingPause: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    if (this.HYn != null) {
      this.HYn.pause();
    }
    AppMethodBeat.o(35629);
  }
  
  public final void fgl()
  {
    AppMethodBeat.i(35630);
    super.fgl();
    ac.i("MicroMsg.StoryStateComponent", "onChattingExitAnimStart: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    foo();
    h localh = h.zAU;
    h.dXK().mB("");
    localh = h.zAU;
    h.dXK().dWh = 0L;
    localh = h.zAU;
    h.dXK().dVt = 0L;
    localh = h.zAU;
    h.dXS().ms("");
    localh = h.zAU;
    h.dXS().dVt = 0L;
    AppMethodBeat.o(35630);
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(35631);
    super.fmj();
    ac.i("MicroMsg.StoryStateComponent", "onComponentUnInstall: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    foo();
    AppMethodBeat.o(35631);
  }
  
  public final void fnU()
  {
    AppMethodBeat.i(35634);
    int i = com.tencent.mm.m.g.ZY().getInt("StoryShouldShowEntraceInChatRoom", 1);
    if ((!this.vJc) || (i == 0))
    {
      ac.i("MicroMsg.StoryStateComponent", "updateMenuItem enable %s", new Object[] { Integer.valueOf(i) });
      this.cLy.HZF.removeOptionMenu(3);
      AppMethodBeat.o(35634);
      return;
    }
    if ((this.HYp) && (o.isShowStoryCheck()))
    {
      ac.i("MicroMsg.StoryStateComponent", "updateMenuItem: hasUnread %s hashCode:%s", new Object[] { Boolean.valueOf(this.zvF), Integer.valueOf(hashCode()) });
      if (this.zvF)
      {
        this.cLy.HZF.removeOptionMenu(3);
        a(2131690613, this.Hyo, this.cLy.HZF.getContext().getResources().getColor(2131099689));
        AppMethodBeat.o(35634);
        return;
      }
      a(2131690614, this.Hyo, 0);
    }
    AppMethodBeat.o(35634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.at
 * JD-Core Version:    0.7.0.1
 */