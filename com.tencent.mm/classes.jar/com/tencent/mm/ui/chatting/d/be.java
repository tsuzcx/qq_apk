package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.res.Resources;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.k;
import com.tencent.mm.f.b.a.lm;
import com.tencent.mm.f.b.a.lp;
import com.tencent.mm.f.b.a.lx;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.story.api.e;
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
import com.tencent.mm.ui.chatting.viewitems.by;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(hRc=aj.class)
public class be
  extends a
  implements l.a, aj
{
  private boolean GXF;
  private boolean LJW;
  private List<String> LOf;
  private l WOE;
  private List<String> WOF;
  private boolean WOG;
  private long WOH;
  private boolean WOI;
  private SparseArray<WeakReference<AvatarImageView>> WOJ;
  private MenuItem.OnMenuItemClickListener WkV;
  private long qLu;
  private String sessionId;
  private boolean wIg;
  private boolean wNV;
  
  public be()
  {
    AppMethodBeat.i(35625);
    this.WOF = Collections.synchronizedList(new ArrayList());
    this.LOf = Collections.synchronizedList(new ArrayList());
    this.WOG = false;
    this.wIg = true;
    this.GXF = false;
    this.LJW = false;
    this.WOH = 500L;
    this.qLu = 0L;
    this.sessionId = null;
    this.wNV = false;
    this.WOI = false;
    this.WOJ = new SparseArray();
    this.WkV = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        long l = 1L;
        AppMethodBeat.i(35622);
        if (System.currentTimeMillis() - be.a(be.this) <= be.b(be.this))
        {
          Log.i("MicroMsg.StoryStateComponent", "onclick pass $clickTime now: %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
          AppMethodBeat.o(35622);
          return true;
        }
        be.a(be.this, System.currentTimeMillis());
        Log.i("MicroMsg.StoryStateComponent", "menuItemClickListener clickTime %s storyUserList size %s", new Object[] { Long.valueOf(be.a(be.this)), Integer.valueOf(be.c(be.this).size()) });
        if (be.c(be.this).size() > 0)
        {
          paramAnonymousMenuItem = (String)be.c(be.this).get(0);
          Log.i("MicroMsg.StoryStateComponent", "menuItemClickListener click go %s", new Object[] { paramAnonymousMenuItem });
          ((e)com.tencent.mm.kernel.h.ag(e.class)).checkReportFromChatting(1, paramAnonymousMenuItem);
          List localList = be.d(be.this);
          ((e)com.tencent.mm.kernel.h.ag(e.class)).enterGallery(localList);
          ((e)com.tencent.mm.kernel.h.ag(e.class)).preLoadVideoViewMgr(paramAnonymousMenuItem);
          paramAnonymousMenuItem = com.tencent.mm.plugin.story.h.h.LOJ;
          com.tencent.mm.plugin.story.h.h.geE().Cv(be.e(be.this));
          if (be.f(be.this))
          {
            paramAnonymousMenuItem = com.tencent.mm.plugin.story.h.h.LOJ;
            com.tencent.mm.plugin.story.h.h.geE().gQR = 4L;
            o.a(be.this.fgR.WQv.getContext(), be.c(be.this), be.this.fgR.getTalkerUserName(), be.e(be.this));
            paramAnonymousMenuItem = com.tencent.mm.plugin.story.h.h.LOJ;
            paramAnonymousMenuItem = com.tencent.mm.plugin.story.h.h.geE();
            if (!be.g(be.this)) {
              break label372;
            }
          }
          label372:
          for (l = 1L;; l = 0L)
          {
            paramAnonymousMenuItem.gQS = l;
            AppMethodBeat.o(35622);
            return true;
            paramAnonymousMenuItem = com.tencent.mm.plugin.story.h.h.LOJ;
            com.tencent.mm.plugin.story.h.h.geE().gQR = 5L;
            o.bP(be.this.fgR.WQv.getContext(), (String)be.c(be.this).get(0));
            break;
          }
        }
        if ((be.h(be.this)) && (be.f(be.this)))
        {
          paramAnonymousMenuItem = com.tencent.mm.plugin.story.h.h.LOJ;
          paramAnonymousMenuItem = com.tencent.mm.plugin.story.h.h.geE();
          if (be.g(be.this)) {}
          for (;;)
          {
            paramAnonymousMenuItem.gQS = l;
            o.a(be.this.fgR.WQv.getContext(), be.c(be.this), be.this.fgR.getTalkerUserName(), be.e(be.this));
            paramAnonymousMenuItem = com.tencent.mm.plugin.story.h.h.LOJ;
            com.tencent.mm.plugin.story.h.h.geE().gQR = 4L;
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
    if (this.fgR.WQv.findMenuInfo(3) == null)
    {
      this.fgR.WQv.addIconOptionMenu(3, paramInt1, paramOnMenuItemClickListener, paramInt2);
      AppMethodBeat.o(35635);
      return;
    }
    this.fgR.WQv.updateOptionMenu(3, paramInt1, paramOnMenuItemClickListener, paramInt2);
    AppMethodBeat.o(35635);
  }
  
  private void hQC()
  {
    AppMethodBeat.i(35632);
    if (this.WOE != null)
    {
      this.WOE.destroy();
      this.WOE.a(null);
      this.WOE = null;
    }
    this.GXF = false;
    this.LJW = false;
    this.WOF.clear();
    this.WOJ.clear();
    AppMethodBeat.o(35632);
  }
  
  private void hQD()
  {
    AppMethodBeat.i(35640);
    Object localObject;
    if ((this.GXF) && (this.wNV))
    {
      this.wNV = false;
      localObject = com.tencent.mm.plugin.story.h.h.LOJ;
      localObject = com.tencent.mm.plugin.story.h.h.geK();
      if (!this.LJW) {
        break label59;
      }
    }
    label59:
    for (long l = 1L;; l = 0L)
    {
      ((lm)localObject).gQS = l;
      localObject = com.tencent.mm.plugin.story.h.h.LOJ;
      com.tencent.mm.plugin.story.h.h.geL();
      AppMethodBeat.o(35640);
      return;
    }
  }
  
  public final void a(List<String> paramList, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(35637);
    Log.i("MicroMsg.StoryStateComponent", "updateGalleryUserList: size is %s %s hashCode:%s", new Object[] { this.fgR.NKq, Integer.valueOf(paramList.size()), Integer.valueOf(hashCode()) });
    this.WOF.clear();
    this.WOF.addAll(paramList);
    this.LOf.clear();
    this.LOf.addAll(paramArrayList);
    AppMethodBeat.o(35637);
  }
  
  public final void aE(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(35638);
    m localm = (m)this.fgR.bC(m.class);
    int i;
    if (paramBoolean2) {
      i = 1;
    }
    for (;;)
    {
      localm.avB(i);
      if ((this.GXF != paramBoolean1) || (this.LJW != paramBoolean2)) {
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
    this.GXF = paramBoolean1;
    this.LJW = paramBoolean2;
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35623);
        ((aa)be.this.fgR.bC(aa.class)).hPL();
        AppMethodBeat.o(35623);
      }
    });
    hQD();
    AppMethodBeat.o(35638);
  }
  
  public final void cG(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(35639);
    Log.i("MicroMsg.StoryStateComponent", "notifyAvatar: ");
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35624);
        int i = 0;
        while (i < be.i(be.this).size())
        {
          AvatarImageView localAvatarImageView = (AvatarImageView)((WeakReference)be.i(be.this).valueAt(i)).get();
          if (localAvatarImageView != null)
          {
            Object localObject = localAvatarImageView.getTag();
            if (((localObject instanceof by)) && (paramString.equals(((by)localObject).userName)))
            {
              localAvatarImageView.gp(((by)localObject).userName, 5);
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
  
  public final void hGV()
  {
    boolean bool = false;
    AppMethodBeat.i(35626);
    super.hGV();
    Log.i("MicroMsg.StoryStateComponent", "onChattingEnterAnimStart: user %s hashCode:%s", new Object[] { this.fgR.getTalkerUserName(), Integer.valueOf(hashCode()) });
    this.fgR.WQv.removeOptionMenu(3);
    this.GXF = false;
    this.LJW = false;
    this.WOF.clear();
    this.LOf.clear();
    this.sessionId = "";
    this.WOI = false;
    ((m)this.fgR.bC(m.class)).avB(0);
    Object localObject = this.fgR.getTalkerUserName();
    if (Util.isNullOrNil((String)localObject)) {}
    label274:
    label457:
    label462:
    label478:
    for (;;)
    {
      localObject = this;
      ((be)localObject).WOG = bool;
      if (this.WOG)
      {
        this.WOE = ((e)com.tencent.mm.kernel.h.ag(e.class)).getStoryStateFetcher(this.fgR.getTalkerUserName());
        if (this.WOE != null)
        {
          this.WOE.a(this);
          this.WOE.start();
        }
      }
      localObject = com.tencent.mm.plugin.story.h.h.LOJ;
      localObject = com.tencent.mm.plugin.story.h.h.geK();
      ((lm)localObject).gjX = ((lm)localObject).z("UserName", this.fgR.getTalkerUserName(), true);
      localObject = com.tencent.mm.plugin.story.h.h.LOJ;
      localObject = com.tencent.mm.plugin.story.h.h.geK();
      long l;
      if (this.wIg)
      {
        l = 4L;
        label249:
        ((lm)localObject).gQR = l;
        localObject = com.tencent.mm.plugin.story.h.h.LOJ;
        localObject = com.tencent.mm.plugin.story.h.h.geK();
        if (!this.LJW) {
          break label457;
        }
        l = 1L;
        ((lm)localObject).gQS = l;
        if (!this.wIg) {
          break label462;
        }
      }
      for (this.fgR.nBW = com.tencent.mm.ui.f.bjQ("4");; this.fgR.nBW = com.tencent.mm.ui.f.bjQ("5"))
      {
        this.sessionId = this.fgR.bFl();
        AppMethodBeat.o(35626);
        return;
        this.wIg = ab.Lj((String)localObject);
        if (ab.PP((String)localObject))
        {
          bool = ab.PP((String)localObject);
          localObject = this;
          break;
        }
        if ((ab.PY((String)localObject)) || (ab.Qm((String)localObject)) || (ab.Qb((String)localObject)) || (ab.Qi((String)localObject)) || (ab.Qp((String)localObject)) || (ab.Qq((String)localObject)) || (ab.QQ((String)localObject)) || (ab.QV((String)localObject)) || (ab.QX((String)localObject)) || (ab.QB((String)localObject)) || (ab.PQ((String)localObject)) || (ab.PP((String)localObject))) {
          break label478;
        }
        bool = true;
        localObject = this;
        break;
        l = 5L;
        break label249;
        l = 0L;
        break label274;
      }
    }
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(35627);
    super.hGW();
    Log.i("MicroMsg.StoryStateComponent", "onChattingEnterAnimEnd: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(35627);
  }
  
  public final void hGX()
  {
    long l2 = 2L;
    AppMethodBeat.i(35628);
    super.hGX();
    Log.i("MicroMsg.StoryStateComponent", "onChattingResume: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    this.wNV = true;
    hQD();
    Object localObject;
    if (this.WOE != null)
    {
      this.WOE.resume();
      localObject = com.tencent.mm.plugin.story.h.h.LOJ;
      localObject = com.tencent.mm.plugin.story.h.h.geE();
      if (this.wIg)
      {
        l1 = 10L;
        ((lx)localObject).gQR = l1;
        localObject = com.tencent.mm.plugin.story.h.h.LOJ;
        com.tencent.mm.plugin.story.h.h.geE().Ct(this.fgR.getTalkerUserName());
        localObject = com.tencent.mm.plugin.story.h.h.LOJ;
        localObject = com.tencent.mm.plugin.story.h.h.geE();
        if (!this.wIg) {
          break label192;
        }
        l1 = 2L;
        label128:
        ((lx)localObject).gRv = l1;
      }
    }
    else
    {
      localObject = com.tencent.mm.plugin.story.h.h.LOJ;
      com.tencent.mm.plugin.story.h.h.geM().Ck(this.fgR.getTalkerUserName());
      localObject = com.tencent.mm.plugin.story.h.h.LOJ;
      localObject = com.tencent.mm.plugin.story.h.h.geM();
      if (!this.wIg) {
        break label212;
      }
    }
    for (long l1 = l2;; l1 = i.a.bdu(this.fgR.getTalkerUserName()))
    {
      ((lp)localObject).gRv = l1;
      AppMethodBeat.o(35628);
      return;
      l1 = 11L;
      break;
      label192:
      i.a locala = i.LOK;
      l1 = i.a.bdu(this.fgR.getTalkerUserName());
      break label128;
      label212:
      locala = i.LOK;
    }
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(35629);
    super.hGY();
    this.wNV = false;
    Log.i("MicroMsg.StoryStateComponent", "onChattingPause: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    if (this.WOE != null) {
      this.WOE.pause();
    }
    AppMethodBeat.o(35629);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(35630);
    super.hGZ();
    Log.i("MicroMsg.StoryStateComponent", "onChattingExitAnimStart: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    hQC();
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.LOJ;
    com.tencent.mm.plugin.story.h.h.geE().Ct("");
    localh = com.tencent.mm.plugin.story.h.h.LOJ;
    com.tencent.mm.plugin.story.h.h.geE().gSg = 0L;
    localh = com.tencent.mm.plugin.story.h.h.LOJ;
    com.tencent.mm.plugin.story.h.h.geE().gRv = 0L;
    localh = com.tencent.mm.plugin.story.h.h.LOJ;
    com.tencent.mm.plugin.story.h.h.geM().Ck("");
    localh = com.tencent.mm.plugin.story.h.h.LOJ;
    com.tencent.mm.plugin.story.h.h.geM().gRv = 0L;
    AppMethodBeat.o(35630);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(35631);
    super.hNZ();
    Log.i("MicroMsg.StoryStateComponent", "onComponentUnInstall: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    hQC();
    AppMethodBeat.o(35631);
  }
  
  public final void hQd()
  {
    AppMethodBeat.i(35634);
    int i = com.tencent.mm.n.h.axc().getInt("StoryShouldShowEntraceInChatRoom", 1);
    if ((!this.GXF) || (i == 0))
    {
      Log.i("MicroMsg.StoryStateComponent", "updateMenuItem enable %s", new Object[] { Integer.valueOf(i) });
      this.fgR.WQv.removeOptionMenu(3);
      AppMethodBeat.o(35634);
      return;
    }
    if ((this.WOG) && (o.isShowStoryCheck()))
    {
      Log.i("MicroMsg.StoryStateComponent", "updateMenuItem: hasUnread %s hashCode:%s", new Object[] { Boolean.valueOf(this.LJW), Integer.valueOf(hashCode()) });
      if (this.LJW)
      {
        this.fgR.WQv.removeOptionMenu(3);
        a(R.k.icons_outlined_one_day_blue_video, this.WkV, this.fgR.WQv.getContext().getResources().getColor(R.e.Blue));
        AppMethodBeat.o(35634);
        return;
      }
      a(R.k.icons_outlined_one_day_video, this.WkV, 0);
    }
    AppMethodBeat.o(35634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.be
 * JD-Core Version:    0.7.0.1
 */