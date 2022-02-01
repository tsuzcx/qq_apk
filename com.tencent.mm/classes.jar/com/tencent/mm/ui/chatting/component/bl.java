package com.tencent.mm.ui.chatting.component;

import android.app.Activity;
import android.content.res.Resources;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.k;
import com.tencent.mm.autogen.mmdata.rpt.om;
import com.tencent.mm.autogen.mmdata.rpt.op;
import com.tencent.mm.autogen.mmdata.rpt.ox;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.l;
import com.tencent.mm.plugin.story.api.l.a;
import com.tencent.mm.plugin.story.g.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.ad;
import com.tencent.mm.ui.chatting.view.AvatarImageView;
import com.tencent.mm.ui.chatting.viewitems.bz;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=am.class)
public class bl
  extends a
  implements l.a, am
{
  private boolean Aeu;
  private boolean Akx;
  private MenuItem.OnMenuItemClickListener JVE;
  private boolean MVC;
  private boolean Snr;
  private List<String> SqU;
  private l aexj;
  private List<String> aexk;
  private boolean aexl;
  private long aexm;
  private boolean aexn;
  private SparseArray<WeakReference<AvatarImageView>> aexo;
  private String sessionId;
  private long tQb;
  
  public bl()
  {
    AppMethodBeat.i(35625);
    this.aexk = Collections.synchronizedList(new ArrayList());
    this.SqU = Collections.synchronizedList(new ArrayList());
    this.aexl = false;
    this.Aeu = true;
    this.MVC = false;
    this.Snr = false;
    this.aexm = 500L;
    this.tQb = 0L;
    this.sessionId = null;
    this.Akx = false;
    this.aexn = false;
    this.aexo = new SparseArray();
    this.JVE = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        long l = 1L;
        AppMethodBeat.i(35622);
        if (System.currentTimeMillis() - bl.a(bl.this) <= bl.b(bl.this))
        {
          Log.i("MicroMsg.StoryStateComponent", "onclick pass $clickTime now: %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
          AppMethodBeat.o(35622);
          return true;
        }
        bl.a(bl.this, System.currentTimeMillis());
        Log.i("MicroMsg.StoryStateComponent", "menuItemClickListener clickTime %s storyUserList size %s", new Object[] { Long.valueOf(bl.a(bl.this)), Integer.valueOf(bl.c(bl.this).size()) });
        if (bl.c(bl.this).size() > 0)
        {
          paramAnonymousMenuItem = (String)bl.c(bl.this).get(0);
          Log.i("MicroMsg.StoryStateComponent", "menuItemClickListener click go %s", new Object[] { paramAnonymousMenuItem });
          ((e)com.tencent.mm.kernel.h.az(e.class)).checkReportFromChatting(1, paramAnonymousMenuItem);
          List localList = bl.d(bl.this);
          ((e)com.tencent.mm.kernel.h.az(e.class)).enterGallery(localList);
          ((e)com.tencent.mm.kernel.h.az(e.class)).preLoadVideoViewMgr(paramAnonymousMenuItem);
          paramAnonymousMenuItem = com.tencent.mm.plugin.story.g.h.SqZ;
          com.tencent.mm.plugin.story.g.h.hxW().wA(bl.e(bl.this));
          if (bl.f(bl.this))
          {
            paramAnonymousMenuItem = com.tencent.mm.plugin.story.g.h.SqZ;
            com.tencent.mm.plugin.story.g.h.hxW().jjn = 4L;
            com.tencent.mm.plugin.story.api.o.a(bl.this.hlc.aezO.getContext(), bl.c(bl.this), bl.this.hlc.getTalkerUserName(), bl.e(bl.this));
            paramAnonymousMenuItem = com.tencent.mm.plugin.story.g.h.SqZ;
            paramAnonymousMenuItem = com.tencent.mm.plugin.story.g.h.hxW();
            if (!bl.g(bl.this)) {
              break label372;
            }
          }
          label372:
          for (l = 1L;; l = 0L)
          {
            paramAnonymousMenuItem.jjo = l;
            AppMethodBeat.o(35622);
            return true;
            paramAnonymousMenuItem = com.tencent.mm.plugin.story.g.h.SqZ;
            com.tencent.mm.plugin.story.g.h.hxW().jjn = 5L;
            com.tencent.mm.plugin.story.api.o.bT(bl.this.hlc.aezO.getContext(), (String)bl.c(bl.this).get(0));
            break;
          }
        }
        if ((bl.h(bl.this)) && (bl.f(bl.this)))
        {
          paramAnonymousMenuItem = com.tencent.mm.plugin.story.g.h.SqZ;
          paramAnonymousMenuItem = com.tencent.mm.plugin.story.g.h.hxW();
          if (bl.g(bl.this)) {}
          for (;;)
          {
            paramAnonymousMenuItem.jjo = l;
            com.tencent.mm.plugin.story.api.o.a(bl.this.hlc.aezO.getContext(), bl.c(bl.this), bl.this.hlc.getTalkerUserName(), bl.e(bl.this));
            paramAnonymousMenuItem = com.tencent.mm.plugin.story.g.h.SqZ;
            com.tencent.mm.plugin.story.g.h.hxW().jjn = 4L;
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
    if (this.hlc.aezO.findMenuInfo(3) == null)
    {
      this.hlc.aezO.addIconOptionMenu(3, paramInt1, paramOnMenuItemClickListener, paramInt2);
      AppMethodBeat.o(35635);
      return;
    }
    this.hlc.aezO.updateOptionMenu(3, paramInt1, paramOnMenuItemClickListener, paramInt2);
    AppMethodBeat.o(35635);
  }
  
  private void jtF()
  {
    AppMethodBeat.i(35632);
    if (this.aexj != null)
    {
      this.aexj.destroy();
      this.aexj.a(null);
      this.aexj = null;
    }
    this.MVC = false;
    this.Snr = false;
    this.aexk.clear();
    this.aexo.clear();
    AppMethodBeat.o(35632);
  }
  
  private void jtG()
  {
    AppMethodBeat.i(35640);
    Object localObject;
    if ((this.MVC) && (this.Akx))
    {
      this.Akx = false;
      localObject = com.tencent.mm.plugin.story.g.h.SqZ;
      localObject = com.tencent.mm.plugin.story.g.h.hyc();
      if (!this.Snr) {
        break label59;
      }
    }
    label59:
    for (long l = 1L;; l = 0L)
    {
      ((om)localObject).jjo = l;
      localObject = com.tencent.mm.plugin.story.g.h.SqZ;
      com.tencent.mm.plugin.story.g.h.hyd();
      AppMethodBeat.o(35640);
      return;
    }
  }
  
  public final void a(List<String> paramList, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(35637);
    Log.i("MicroMsg.StoryStateComponent", "updateGalleryUserList: size is %s %s hashCode:%s", new Object[] { this.hlc.Uxa, Integer.valueOf(paramList.size()), Integer.valueOf(hashCode()) });
    this.aexk.clear();
    this.aexk.addAll(paramList);
    this.SqU.clear();
    this.SqU.addAll(paramArrayList);
    AppMethodBeat.o(35637);
  }
  
  public final void bb(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(35638);
    com.tencent.mm.ui.chatting.component.api.o localo = (com.tencent.mm.ui.chatting.component.api.o)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.o.class);
    int i;
    if (paramBoolean2) {
      i = 1;
    }
    for (;;)
    {
      localo.aCd(i);
      if ((this.MVC != paramBoolean1) || (this.Snr != paramBoolean2)) {
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
    this.MVC = paramBoolean1;
    this.Snr = paramBoolean2;
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35623);
        ((ad)bl.this.hlc.cm(ad.class)).jsI();
        AppMethodBeat.o(35623);
      }
    });
    jtG();
    AppMethodBeat.o(35638);
  }
  
  public final void dm(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(35639);
    Log.i("MicroMsg.StoryStateComponent", "notifyAvatar: ");
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35624);
        int i = 0;
        while (i < bl.i(bl.this).size())
        {
          AvatarImageView localAvatarImageView = (AvatarImageView)((WeakReference)bl.i(bl.this).valueAt(i)).get();
          if (localAvatarImageView != null)
          {
            Object localObject = localAvatarImageView.getTag();
            if (((localObject instanceof bz)) && (paramString.equals(((bz)localObject).userName)))
            {
              localAvatarImageView.hj(((bz)localObject).userName, 5);
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
  
  public final void jjg()
  {
    boolean bool = false;
    AppMethodBeat.i(35626);
    super.jjg();
    Log.i("MicroMsg.StoryStateComponent", "onChattingEnterAnimStart: user %s hashCode:%s", new Object[] { this.hlc.getTalkerUserName(), Integer.valueOf(hashCode()) });
    this.hlc.aezO.removeOptionMenu(3);
    this.MVC = false;
    this.Snr = false;
    this.aexk.clear();
    this.SqU.clear();
    this.sessionId = "";
    this.aexn = false;
    ((com.tencent.mm.ui.chatting.component.api.o)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.o.class)).aCd(0);
    Object localObject = this.hlc.getTalkerUserName();
    if (Util.isNullOrNil((String)localObject)) {}
    label274:
    label449:
    label454:
    label470:
    for (;;)
    {
      localObject = this;
      ((bl)localObject).aexl = bool;
      if (this.aexl)
      {
        this.aexj = ((e)com.tencent.mm.kernel.h.az(e.class)).getStoryStateFetcher(this.hlc.getTalkerUserName());
        if (this.aexj != null)
        {
          this.aexj.a(this);
          this.aexj.start();
        }
      }
      localObject = com.tencent.mm.plugin.story.g.h.SqZ;
      localObject = com.tencent.mm.plugin.story.g.h.hyc();
      ((om)localObject).irj = ((om)localObject).F("UserName", this.hlc.getTalkerUserName(), true);
      localObject = com.tencent.mm.plugin.story.g.h.SqZ;
      localObject = com.tencent.mm.plugin.story.g.h.hyc();
      long l;
      if (this.Aeu)
      {
        l = 4L;
        label249:
        ((om)localObject).jjn = l;
        localObject = com.tencent.mm.plugin.story.g.h.SqZ;
        localObject = com.tencent.mm.plugin.story.g.h.hyc();
        if (!this.Snr) {
          break label449;
        }
        l = 1L;
        ((om)localObject).jjo = l;
        if (!this.Aeu) {
          break label454;
        }
      }
      for (this.hlc.qBl = com.tencent.mm.ui.f.bjC("4");; this.hlc.qBl = com.tencent.mm.ui.f.bjC("5"))
      {
        this.sessionId = this.hlc.cez();
        AppMethodBeat.o(35626);
        return;
        this.Aeu = au.bwE((String)localObject);
        if (au.bwG((String)localObject))
        {
          bool = au.bwG((String)localObject);
          localObject = this;
          break;
        }
        if ((au.bwS((String)localObject)) || (ab.IS((String)localObject)) || (au.bxe((String)localObject)) || (ab.IP((String)localObject)) || (au.bvS((String)localObject)) || (au.bvT((String)localObject)) || (au.bwu((String)localObject)) || (au.bwA((String)localObject)) || (ab.IV((String)localObject)) || (au.bwf((String)localObject)) || (au.bwG((String)localObject))) {
          break label470;
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
  
  public final void jjh()
  {
    AppMethodBeat.i(35627);
    super.jjh();
    Log.i("MicroMsg.StoryStateComponent", "onChattingEnterAnimEnd: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(35627);
  }
  
  public final void jji()
  {
    long l2 = 2L;
    AppMethodBeat.i(35628);
    super.jji();
    Log.i("MicroMsg.StoryStateComponent", "onChattingResume: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    this.Akx = true;
    jtG();
    Object localObject;
    if (this.aexj != null)
    {
      this.aexj.resume();
      localObject = com.tencent.mm.plugin.story.g.h.SqZ;
      localObject = com.tencent.mm.plugin.story.g.h.hxW();
      if (this.Aeu)
      {
        l1 = 10L;
        ((ox)localObject).jjn = l1;
        localObject = com.tencent.mm.plugin.story.g.h.SqZ;
        com.tencent.mm.plugin.story.g.h.hxW().wz(this.hlc.getTalkerUserName());
        localObject = com.tencent.mm.plugin.story.g.h.SqZ;
        localObject = com.tencent.mm.plugin.story.g.h.hxW();
        if (!this.Aeu) {
          break label192;
        }
        l1 = 2L;
        label128:
        ((ox)localObject).jjR = l1;
      }
    }
    else
    {
      localObject = com.tencent.mm.plugin.story.g.h.SqZ;
      com.tencent.mm.plugin.story.g.h.hye().ws(this.hlc.getTalkerUserName());
      localObject = com.tencent.mm.plugin.story.g.h.SqZ;
      localObject = com.tencent.mm.plugin.story.g.h.hye();
      if (!this.Aeu) {
        break label212;
      }
    }
    for (long l1 = l2;; l1 = i.a.bch(this.hlc.getTalkerUserName()))
    {
      ((op)localObject).jjR = l1;
      AppMethodBeat.o(35628);
      return;
      l1 = 11L;
      break;
      label192:
      i.a locala = com.tencent.mm.plugin.story.g.i.Srx;
      l1 = i.a.bch(this.hlc.getTalkerUserName());
      break label128;
      label212:
      locala = com.tencent.mm.plugin.story.g.i.Srx;
    }
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(35629);
    super.jjj();
    this.Akx = false;
    Log.i("MicroMsg.StoryStateComponent", "onChattingPause: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    if (this.aexj != null) {
      this.aexj.pause();
    }
    AppMethodBeat.o(35629);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(35630);
    super.jjk();
    Log.i("MicroMsg.StoryStateComponent", "onChattingExitAnimStart: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    jtF();
    com.tencent.mm.plugin.story.g.h localh = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.hxW().wz("");
    localh = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.hxW().jkC = 0L;
    localh = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.hxW().jjR = 0L;
    localh = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.hye().ws("");
    localh = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.hye().jjR = 0L;
    AppMethodBeat.o(35630);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(35631);
    super.jqF();
    Log.i("MicroMsg.StoryStateComponent", "onComponentUnInstall: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    jtF();
    AppMethodBeat.o(35631);
  }
  
  public final void jtb()
  {
    AppMethodBeat.i(35634);
    int i = com.tencent.mm.k.i.aRC().getInt("StoryShouldShowEntraceInChatRoom", 1);
    if ((!this.MVC) || (i == 0))
    {
      Log.i("MicroMsg.StoryStateComponent", "updateMenuItem enable %s", new Object[] { Integer.valueOf(i) });
      this.hlc.aezO.removeOptionMenu(3);
      AppMethodBeat.o(35634);
      return;
    }
    if ((this.aexl) && (com.tencent.mm.plugin.story.api.o.isShowStoryCheck()))
    {
      Log.i("MicroMsg.StoryStateComponent", "updateMenuItem: hasUnread %s hashCode:%s", new Object[] { Boolean.valueOf(this.Snr), Integer.valueOf(hashCode()) });
      if (this.Snr)
      {
        this.hlc.aezO.removeOptionMenu(3);
        a(R.k.icons_outlined_one_day_blue_video, this.JVE, this.hlc.aezO.getContext().getResources().getColor(R.e.Blue));
        AppMethodBeat.o(35634);
        return;
      }
      a(R.k.icons_outlined_one_day_video, this.JVE, 0);
    }
    AppMethodBeat.o(35634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.bl
 * JD-Core Version:    0.7.0.1
 */