package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.res.Resources;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.jd;
import com.tencent.mm.g.b.a.jg;
import com.tencent.mm.g.b.a.jo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.story.api.l;
import com.tencent.mm.plugin.story.api.l.a;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.h.i;
import com.tencent.mm.plugin.story.h.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.m;
import com.tencent.mm.ui.chatting.view.AvatarImageView;
import com.tencent.mm.ui.chatting.viewitems.bq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(gRF=ai.class)
public class bb
  extends a
  implements l.a, ai
{
  private boolean BdH;
  private boolean FpT;
  private List<String> Fue;
  private MenuItem.OnMenuItemClickListener ORI;
  private l Pul;
  private List<String> Pum;
  private boolean Pun;
  private long Puo;
  private boolean Pup;
  private SparseArray<WeakReference<AvatarImageView>> Puq;
  private long nJh;
  private String sessionId;
  private boolean tcb;
  private boolean thE;
  
  public bb()
  {
    AppMethodBeat.i(35625);
    this.Pum = Collections.synchronizedList(new ArrayList());
    this.Fue = Collections.synchronizedList(new ArrayList());
    this.Pun = false;
    this.tcb = true;
    this.BdH = false;
    this.FpT = false;
    this.Puo = 500L;
    this.nJh = 0L;
    this.sessionId = null;
    this.thE = false;
    this.Pup = false;
    this.Puq = new SparseArray();
    this.ORI = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        long l = 1L;
        AppMethodBeat.i(35622);
        if (System.currentTimeMillis() - bb.a(bb.this) <= bb.b(bb.this))
        {
          Log.i("MicroMsg.StoryStateComponent", "onclick pass $clickTime now: %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
          AppMethodBeat.o(35622);
          return true;
        }
        bb.a(bb.this, System.currentTimeMillis());
        Log.i("MicroMsg.StoryStateComponent", "menuItemClickListener clickTime %s storyUserList size %s", new Object[] { Long.valueOf(bb.a(bb.this)), Integer.valueOf(bb.c(bb.this).size()) });
        if (bb.c(bb.this).size() > 0)
        {
          paramAnonymousMenuItem = (String)bb.c(bb.this).get(0);
          Log.i("MicroMsg.StoryStateComponent", "menuItemClickListener click go %s", new Object[] { paramAnonymousMenuItem });
          ((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).checkReportFromChatting(1, paramAnonymousMenuItem);
          List localList = bb.d(bb.this);
          ((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).enterGallery(localList);
          ((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).preLoadVideoViewMgr(paramAnonymousMenuItem);
          paramAnonymousMenuItem = com.tencent.mm.plugin.story.h.h.FuH;
          com.tencent.mm.plugin.story.h.h.fqi().wU(bb.e(bb.this));
          if (bb.f(bb.this))
          {
            paramAnonymousMenuItem = com.tencent.mm.plugin.story.h.h.FuH;
            com.tencent.mm.plugin.story.h.h.fqi().eQv = 4L;
            o.a(bb.this.dom.Pwc.getContext(), bb.c(bb.this), bb.this.dom.getTalkerUserName(), bb.e(bb.this));
            paramAnonymousMenuItem = com.tencent.mm.plugin.story.h.h.FuH;
            paramAnonymousMenuItem = com.tencent.mm.plugin.story.h.h.fqi();
            if (!bb.g(bb.this)) {
              break label372;
            }
          }
          label372:
          for (l = 1L;; l = 0L)
          {
            paramAnonymousMenuItem.eQw = l;
            AppMethodBeat.o(35622);
            return true;
            paramAnonymousMenuItem = com.tencent.mm.plugin.story.h.h.FuH;
            com.tencent.mm.plugin.story.h.h.fqi().eQv = 5L;
            o.bB(bb.this.dom.Pwc.getContext(), (String)bb.c(bb.this).get(0));
            break;
          }
        }
        if ((bb.h(bb.this)) && (bb.f(bb.this)))
        {
          paramAnonymousMenuItem = com.tencent.mm.plugin.story.h.h.FuH;
          paramAnonymousMenuItem = com.tencent.mm.plugin.story.h.h.fqi();
          if (bb.g(bb.this)) {}
          for (;;)
          {
            paramAnonymousMenuItem.eQw = l;
            o.a(bb.this.dom.Pwc.getContext(), bb.c(bb.this), bb.this.dom.getTalkerUserName(), bb.e(bb.this));
            paramAnonymousMenuItem = com.tencent.mm.plugin.story.h.h.FuH;
            com.tencent.mm.plugin.story.h.h.fqi().eQv = 4L;
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
    if (this.dom.Pwc.findMenuInfo(3) == null)
    {
      this.dom.Pwc.addIconOptionMenu(3, paramInt1, paramOnMenuItemClickListener, paramInt2);
      AppMethodBeat.o(35635);
      return;
    }
    this.dom.Pwc.updateOptionMenu(3, paramInt1, paramOnMenuItemClickListener, paramInt2);
    AppMethodBeat.o(35635);
  }
  
  private void gRf()
  {
    AppMethodBeat.i(35632);
    if (this.Pul != null)
    {
      this.Pul.destroy();
      this.Pul.a(null);
      this.Pul = null;
    }
    this.BdH = false;
    this.FpT = false;
    this.Pum.clear();
    this.Puq.clear();
    AppMethodBeat.o(35632);
  }
  
  private void gRg()
  {
    AppMethodBeat.i(35640);
    Object localObject;
    if ((this.BdH) && (this.thE))
    {
      this.thE = false;
      localObject = com.tencent.mm.plugin.story.h.h.FuH;
      localObject = com.tencent.mm.plugin.story.h.h.fqo();
      if (!this.FpT) {
        break label59;
      }
    }
    label59:
    for (long l = 1L;; l = 0L)
    {
      ((jd)localObject).eQw = l;
      localObject = com.tencent.mm.plugin.story.h.h.FuH;
      com.tencent.mm.plugin.story.h.h.fqp();
      AppMethodBeat.o(35640);
      return;
    }
  }
  
  public final void a(List<String> paramList, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(35637);
    Log.i("MicroMsg.StoryStateComponent", "updateGalleryUserList: size is %s %s hashCode:%s", new Object[] { this.dom.GUe, Integer.valueOf(paramList.size()), Integer.valueOf(hashCode()) });
    this.Pum.clear();
    this.Pum.addAll(paramList);
    this.Fue.clear();
    this.Fue.addAll(paramArrayList);
    AppMethodBeat.o(35637);
  }
  
  public final void as(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(35638);
    m localm = (m)this.dom.bh(m.class);
    int i;
    if (paramBoolean2) {
      i = 1;
    }
    for (;;)
    {
      localm.amA(i);
      if ((this.BdH != paramBoolean1) || (this.FpT != paramBoolean2)) {
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
    Log.i("MicroMsg.StoryStateComponent", "updateChatRoomState: hasStory %s, hasUnread %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.BdH = paramBoolean1;
    this.FpT = paramBoolean2;
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35623);
        ((aa)bb.this.dom.bh(aa.class)).gQp();
        AppMethodBeat.o(35623);
      }
    });
    gRg();
    AppMethodBeat.o(35638);
  }
  
  public final void cFx()
  {
    long l2 = 2L;
    AppMethodBeat.i(35628);
    super.cFx();
    Log.i("MicroMsg.StoryStateComponent", "onChattingResume: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    this.thE = true;
    gRg();
    Object localObject;
    if (this.Pul != null)
    {
      this.Pul.resume();
      localObject = com.tencent.mm.plugin.story.h.h.FuH;
      localObject = com.tencent.mm.plugin.story.h.h.fqi();
      if (this.tcb)
      {
        l1 = 10L;
        ((jo)localObject).eQv = l1;
        localObject = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.fqi().wS(this.dom.getTalkerUserName());
        localObject = com.tencent.mm.plugin.story.h.h.FuH;
        localObject = com.tencent.mm.plugin.story.h.h.fqi();
        if (!this.tcb) {
          break label189;
        }
        l1 = 2L;
        label126:
        ((jo)localObject).eQZ = l1;
      }
    }
    else
    {
      localObject = com.tencent.mm.plugin.story.h.h.FuH;
      com.tencent.mm.plugin.story.h.h.fqq().wJ(this.dom.getTalkerUserName());
      localObject = com.tencent.mm.plugin.story.h.h.FuH;
      localObject = com.tencent.mm.plugin.story.h.h.fqq();
      if (!this.tcb) {
        break label209;
      }
    }
    for (long l1 = l2;; l1 = i.a.aSq(this.dom.getTalkerUserName()))
    {
      ((jg)localObject).eQZ = l1;
      AppMethodBeat.o(35628);
      return;
      l1 = 11L;
      break;
      label189:
      i.a locala = i.FuI;
      l1 = i.a.aSq(this.dom.getTalkerUserName());
      break label126;
      label209:
      locala = i.FuI;
    }
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(35629);
    super.cFy();
    this.thE = false;
    Log.i("MicroMsg.StoryStateComponent", "onChattingPause: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    if (this.Pul != null) {
      this.Pul.pause();
    }
    AppMethodBeat.o(35629);
  }
  
  public final void cs(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(35639);
    Log.i("MicroMsg.StoryStateComponent", "notifyAvatar: ");
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35624);
        int i = 0;
        while (i < bb.i(bb.this).size())
        {
          AvatarImageView localAvatarImageView = (AvatarImageView)((WeakReference)bb.i(bb.this).valueAt(i)).get();
          if (localAvatarImageView != null)
          {
            Object localObject = localAvatarImageView.getTag();
            if (((localObject instanceof bq)) && (paramString.equals(((bq)localObject).userName)))
            {
              localAvatarImageView.fL(((bq)localObject).userName, 5);
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
  
  public final void gIl()
  {
    boolean bool = false;
    AppMethodBeat.i(35626);
    super.gIl();
    Log.i("MicroMsg.StoryStateComponent", "onChattingEnterAnimStart: user %s hashCode:%s", new Object[] { this.dom.getTalkerUserName(), Integer.valueOf(hashCode()) });
    this.dom.Pwc.removeOptionMenu(3);
    this.BdH = false;
    this.FpT = false;
    this.Pum.clear();
    this.Fue.clear();
    this.sessionId = "";
    this.Pup = false;
    ((m)this.dom.bh(m.class)).amA(0);
    Object localObject = this.dom.getTalkerUserName();
    if (Util.isNullOrNil((String)localObject)) {}
    label275:
    label459:
    label464:
    label480:
    for (;;)
    {
      localObject = this;
      ((bb)localObject).Pun = bool;
      if (this.Pun)
      {
        this.Pul = ((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryStateFetcher(this.dom.getTalkerUserName());
        if (this.Pul != null)
        {
          this.Pul.a(this);
          this.Pul.start();
        }
      }
      localObject = com.tencent.mm.plugin.story.h.h.FuH;
      localObject = com.tencent.mm.plugin.story.h.h.fqo();
      ((jd)localObject).eoK = ((jd)localObject).x("UserName", this.dom.getTalkerUserName(), true);
      localObject = com.tencent.mm.plugin.story.h.h.FuH;
      localObject = com.tencent.mm.plugin.story.h.h.fqo();
      long l;
      if (this.tcb)
      {
        l = 4L;
        label250:
        ((jd)localObject).eQv = l;
        localObject = com.tencent.mm.plugin.story.h.h.FuH;
        localObject = com.tencent.mm.plugin.story.h.h.fqo();
        if (!this.FpT) {
          break label459;
        }
        l = 1L;
        ((jd)localObject).eQw = l;
        if (!this.tcb) {
          break label464;
        }
      }
      for (this.dom.kIg = com.tencent.mm.ui.e.avA("4");; this.dom.kIg = com.tencent.mm.ui.e.avA("5"))
      {
        this.sessionId = this.dom.bul();
        AppMethodBeat.o(35626);
        return;
        this.tcb = ab.Eq((String)localObject);
        if (ab.Ix((String)localObject))
        {
          bool = ab.Ix((String)localObject);
          localObject = this;
          break;
        }
        if ((ab.IG((String)localObject)) || (ab.IT((String)localObject)) || (ab.IJ((String)localObject)) || (ab.IP((String)localObject)) || (ab.IW((String)localObject)) || (ab.IX((String)localObject)) || (ab.Jx((String)localObject)) || (ab.JC((String)localObject)) || (ab.JE((String)localObject)) || (ab.Ji((String)localObject)) || (ab.Iy((String)localObject)) || (ab.Ix((String)localObject))) {
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
  
  public final void gIm()
  {
    AppMethodBeat.i(35627);
    super.gIm();
    Log.i("MicroMsg.StoryStateComponent", "onChattingEnterAnimEnd: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(35627);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35630);
    super.gIn();
    Log.i("MicroMsg.StoryStateComponent", "onChattingExitAnimStart: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    gRf();
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.FuH;
    com.tencent.mm.plugin.story.h.h.fqi().wS("");
    localh = com.tencent.mm.plugin.story.h.h.FuH;
    com.tencent.mm.plugin.story.h.h.fqi().eRK = 0L;
    localh = com.tencent.mm.plugin.story.h.h.FuH;
    com.tencent.mm.plugin.story.h.h.fqi().eQZ = 0L;
    localh = com.tencent.mm.plugin.story.h.h.FuH;
    com.tencent.mm.plugin.story.h.h.fqq().wJ("");
    localh = com.tencent.mm.plugin.story.h.h.FuH;
    com.tencent.mm.plugin.story.h.h.fqq().eQZ = 0L;
    AppMethodBeat.o(35630);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(35631);
    super.gOK();
    Log.i("MicroMsg.StoryStateComponent", "onComponentUnInstall: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    gRf();
    AppMethodBeat.o(35631);
  }
  
  public final void gQG()
  {
    AppMethodBeat.i(35634);
    int i = com.tencent.mm.n.h.aqJ().getInt("StoryShouldShowEntraceInChatRoom", 1);
    if ((!this.BdH) || (i == 0))
    {
      Log.i("MicroMsg.StoryStateComponent", "updateMenuItem enable %s", new Object[] { Integer.valueOf(i) });
      this.dom.Pwc.removeOptionMenu(3);
      AppMethodBeat.o(35634);
      return;
    }
    if ((this.Pun) && (o.isShowStoryCheck()))
    {
      Log.i("MicroMsg.StoryStateComponent", "updateMenuItem: hasUnread %s hashCode:%s", new Object[] { Boolean.valueOf(this.FpT), Integer.valueOf(hashCode()) });
      if (this.FpT)
      {
        this.dom.Pwc.removeOptionMenu(3);
        a(2131690858, this.ORI, this.dom.Pwc.getContext().getResources().getColor(2131099700));
        AppMethodBeat.o(35634);
        return;
      }
      a(2131690859, this.ORI, 0);
    }
    AppMethodBeat.o(35634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bb
 * JD-Core Version:    0.7.0.1
 */