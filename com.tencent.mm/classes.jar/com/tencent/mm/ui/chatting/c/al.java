package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.res.Resources;
import android.util.SparseArray;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.aq;
import com.tencent.mm.g.b.a.at;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.story.api.k;
import com.tencent.mm.plugin.story.api.k.a;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.plugin.story.g.j.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.view.AvatarImageView;
import com.tencent.mm.ui.chatting.viewitems.az;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(dJy=x.class)
public class al
  extends a
  implements k.a, x
{
  private String cpW;
  private long iHv;
  private boolean muU;
  private boolean mzI;
  private boolean pyz;
  private List<String> sEk;
  private long sPW;
  private boolean szu;
  private k zIo;
  private List<String> zIp;
  private boolean zIq;
  private boolean zIr;
  private SparseArray<WeakReference<AvatarImageView>> zIs;
  private MenuItem.OnMenuItemClickListener zla;
  
  public al()
  {
    AppMethodBeat.i(31723);
    this.zIp = Collections.synchronizedList(new ArrayList());
    this.sEk = Collections.synchronizedList(new ArrayList());
    this.zIq = false;
    this.muU = true;
    this.pyz = false;
    this.szu = false;
    this.sPW = 500L;
    this.iHv = 0L;
    this.cpW = null;
    this.mzI = false;
    this.zIr = false;
    this.zIs = new SparseArray();
    this.zla = new al.1(this);
    AppMethodBeat.o(31723);
  }
  
  private void a(int paramInt1, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt2)
  {
    AppMethodBeat.i(31733);
    if (this.caz.zJz.findMenuInfo(3) == null)
    {
      this.caz.zJz.addIconOptionMenu(3, paramInt1, paramOnMenuItemClickListener, paramInt2);
      AppMethodBeat.o(31733);
      return;
    }
    this.caz.zJz.updateOptionMenu(3, paramInt1, paramOnMenuItemClickListener, paramInt2);
    AppMethodBeat.o(31733);
  }
  
  private void dJh()
  {
    AppMethodBeat.i(31730);
    if (this.zIo != null)
    {
      this.zIo.destroy();
      this.zIo.a(null);
      this.zIo = null;
    }
    this.pyz = false;
    this.szu = false;
    this.zIp.clear();
    this.zIs.clear();
    AppMethodBeat.o(31730);
  }
  
  private void dJi()
  {
    AppMethodBeat.i(31738);
    Object localObject;
    if ((this.pyz) && (this.mzI))
    {
      this.mzI = false;
      localObject = i.sFa;
      localObject = i.cDu();
      if (!this.szu) {
        break label61;
      }
    }
    label61:
    for (long l = 1L;; l = 0L)
    {
      ((aq)localObject).cVb = l;
      localObject = i.sFa;
      i.cDv();
      AppMethodBeat.o(31738);
      return;
    }
  }
  
  public final void L(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31736);
    com.tencent.mm.ui.chatting.c.b.j localj = (com.tencent.mm.ui.chatting.c.b.j)this.caz.ay(com.tencent.mm.ui.chatting.c.b.j.class);
    int i;
    if (paramBoolean2) {
      i = 1;
    }
    for (;;)
    {
      localj.PE(i);
      if ((this.pyz != paramBoolean1) || (this.szu != paramBoolean2)) {
        break;
      }
      AppMethodBeat.o(31736);
      return;
      if (paramBoolean1) {
        i = 2;
      } else {
        i = 0;
      }
    }
    ab.i("MicroMsg.StoryStateComponent", "updateChatRoomState: hasStory %s, hasUnread %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.pyz = paramBoolean1;
    this.szu = paramBoolean2;
    com.tencent.mm.sdk.platformtools.al.d(new al.2(this));
    dJi();
    AppMethodBeat.o(31736);
  }
  
  public final void a(AvatarImageView paramAvatarImageView)
  {
    AppMethodBeat.i(31731);
    Object localObject = paramAvatarImageView.getTag();
    if ((localObject instanceof az))
    {
      paramAvatarImageView.dw(((az)localObject).userName, 5);
      localObject = ((az)localObject).userName;
      if ((n.isShowStoryCheck()) && (this.zIo != null)) {
        break label84;
      }
    }
    label84:
    for (boolean bool = false;; bool = this.zIo.acA((String)localObject))
    {
      paramAvatarImageView.setShowStoryHint(bool);
      this.zIs.put(paramAvatarImageView.hashCode(), new WeakReference(paramAvatarImageView));
      AppMethodBeat.o(31731);
      return;
    }
  }
  
  public final void a(List<String> paramList, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(31735);
    ab.i("MicroMsg.StoryStateComponent", "updateGalleryUserList: size is %s %s hashCode:%s", new Object[] { this.caz.txj, Integer.valueOf(paramList.size()), Integer.valueOf(hashCode()) });
    this.zIp.clear();
    this.zIp.addAll(paramList);
    this.sEk.clear();
    this.sEk.addAll(paramArrayList);
    AppMethodBeat.o(31735);
  }
  
  public final boolean atV(String paramString)
  {
    AppMethodBeat.i(31734);
    if (System.currentTimeMillis() - this.iHv <= this.sPW)
    {
      ab.i("MicroMsg.StoryStateComponent", "onclick pass $clickTime now: %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(31734);
      return true;
    }
    this.iHv = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList(this.zIp);
    boolean bool = localArrayList.remove(paramString);
    if (bool)
    {
      ab.i("MicroMsg.StoryStateComponent", "goToStoryGalleryWithUser click go %s", new Object[] { paramString });
      n.bj(2, paramString);
      n.enterGallery(this.sEk);
      n.acB(paramString);
      if (!this.muU) {
        break label162;
      }
      localArrayList.add(0, paramString);
      n.a(this.caz.zJz.getContext(), localArrayList, this.caz.getTalkerUserName(), this.cpW);
    }
    for (;;)
    {
      AppMethodBeat.o(31734);
      return bool;
      label162:
      n.aS(this.caz.zJz.getContext(), paramString);
    }
  }
  
  public final void by(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(31737);
    ab.i("MicroMsg.StoryStateComponent", "notifyAvatar: ");
    com.tencent.mm.sdk.platformtools.al.d(new al.3(this, paramString, paramBoolean));
    AppMethodBeat.o(31737);
  }
  
  public final void dBZ()
  {
    boolean bool = true;
    AppMethodBeat.i(31724);
    super.dBZ();
    ab.i("MicroMsg.StoryStateComponent", "onChattingEnterAnimStart: user %s hashCode:%s", new Object[] { this.caz.getTalkerUserName(), Integer.valueOf(hashCode()) });
    this.caz.zJz.removeOptionMenu(3);
    this.pyz = false;
    this.szu = false;
    this.zIp.clear();
    this.sEk.clear();
    this.cpW = "";
    this.zIr = false;
    ((com.tencent.mm.ui.chatting.c.b.j)this.caz.ay(com.tencent.mm.ui.chatting.c.b.j.class)).PE(0);
    Object localObject = this.caz.getTalkerUserName();
    if (bo.isNullOrNil((String)localObject)) {}
    label265:
    label439:
    label444:
    label460:
    for (;;)
    {
      bool = false;
      localObject = this;
      ((al)localObject).zIq = bool;
      if (this.zIq)
      {
        this.zIo = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getStoryStateFetcher(this.caz.getTalkerUserName());
        if (this.zIo != null)
        {
          this.zIo.a(this);
          this.zIo.start();
        }
      }
      localObject = i.sFa;
      i.cDu().fX(this.caz.getTalkerUserName());
      localObject = i.sFa;
      localObject = i.cDu();
      long l;
      if (this.muU)
      {
        l = 4L;
        label240:
        ((aq)localObject).cVa = l;
        localObject = i.sFa;
        localObject = i.cDu();
        if (!this.szu) {
          break label439;
        }
        l = 1L;
        ((aq)localObject).cVb = l;
        if (!this.muU) {
          break label444;
        }
      }
      for (this.caz.zJD = com.tencent.mm.ui.e.atl("4");; this.caz.zJD = com.tencent.mm.ui.e.atl("5"))
      {
        this.cpW = this.caz.dJC();
        AppMethodBeat.o(31724);
        return;
        this.muU = t.lA((String)localObject);
        if (t.nJ((String)localObject))
        {
          bool = t.nJ((String)localObject);
          localObject = this;
          break;
        }
        if ((t.nM((String)localObject)) || (t.nU((String)localObject)) || (t.nP((String)localObject)) || (t.nQ((String)localObject)) || (t.nX((String)localObject)) || (t.nY((String)localObject)) || (t.oy((String)localObject)) || (t.oD((String)localObject)) || (t.oj((String)localObject)) || (t.nK((String)localObject)) || (t.nJ((String)localObject))) {
          break label460;
        }
        localObject = this;
        break;
        l = 5L;
        break label240;
        l = 0L;
        break label265;
      }
    }
  }
  
  public final void dCa()
  {
    AppMethodBeat.i(31725);
    super.dCa();
    ab.i("MicroMsg.StoryStateComponent", "onChattingEnterAnimEnd: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(31725);
  }
  
  public final void dCb()
  {
    long l2 = 2L;
    AppMethodBeat.i(31726);
    super.dCb();
    ab.i("MicroMsg.StoryStateComponent", "onChattingResume: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    this.mzI = true;
    dJi();
    Object localObject;
    if (this.zIo != null)
    {
      this.zIo.resume();
      localObject = i.sFa;
      localObject = i.cDo();
      if (this.muU)
      {
        l1 = 10L;
        ((ba)localObject).cVa = l1;
        localObject = i.sFa;
        i.cDo().gn(this.caz.getTalkerUserName());
        localObject = i.sFa;
        localObject = i.cDo();
        if (!this.muU) {
          break label192;
        }
        l1 = 2L;
        label128:
        ((ba)localObject).cVG = l1;
      }
    }
    else
    {
      localObject = i.sFa;
      i.cDw().gf(this.caz.getTalkerUserName());
      localObject = i.sFa;
      localObject = i.cDw();
      if (!this.muU) {
        break label212;
      }
    }
    for (long l1 = l2;; l1 = j.a.adw(this.caz.getTalkerUserName()))
    {
      ((at)localObject).cVG = l1;
      AppMethodBeat.o(31726);
      return;
      l1 = 11L;
      break;
      label192:
      j.a locala = com.tencent.mm.plugin.story.g.j.sFb;
      l1 = j.a.adw(this.caz.getTalkerUserName());
      break label128;
      label212:
      locala = com.tencent.mm.plugin.story.g.j.sFb;
    }
  }
  
  public final void dCc()
  {
    AppMethodBeat.i(31727);
    super.dCc();
    this.mzI = false;
    ab.i("MicroMsg.StoryStateComponent", "onChattingPause: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    if (this.zIo != null) {
      this.zIo.pause();
    }
    AppMethodBeat.o(31727);
  }
  
  public final void dCd()
  {
    AppMethodBeat.i(31728);
    super.dCd();
    ab.i("MicroMsg.StoryStateComponent", "onChattingExitAnimStart: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    dJh();
    i locali = i.sFa;
    i.cDo().gn("");
    locali = i.sFa;
    i.cDo().cWp = 0L;
    locali = i.sFa;
    i.cDo().cVG = 0L;
    locali = i.sFa;
    i.cDw().gf("");
    locali = i.sFa;
    i.cDw().cVG = 0L;
    AppMethodBeat.o(31728);
  }
  
  public final void dHq()
  {
    AppMethodBeat.i(31729);
    super.dHq();
    ab.i("MicroMsg.StoryStateComponent", "onComponentUnInstall: hashCode:%s", new Object[] { Integer.valueOf(hashCode()) });
    dJh();
    AppMethodBeat.o(31729);
  }
  
  public final void dIN()
  {
    AppMethodBeat.i(31732);
    int i = com.tencent.mm.m.g.Nq().getInt("StoryShouldShowEntraceInChatRoom", 1);
    if ((!this.pyz) || (i == 0))
    {
      ab.i("MicroMsg.StoryStateComponent", "updateMenuItem enable %s", new Object[] { Integer.valueOf(i) });
      this.caz.zJz.removeOptionMenu(3);
      AppMethodBeat.o(31732);
      return;
    }
    if ((this.zIq) && (n.isShowStoryCheck()))
    {
      ab.i("MicroMsg.StoryStateComponent", "updateMenuItem: hasUnread %s hashCode:%s", new Object[] { Boolean.valueOf(this.szu), Integer.valueOf(hashCode()) });
      if (this.szu)
      {
        this.caz.zJz.removeOptionMenu(3);
        a(2131231524, this.zla, this.caz.zJz.getContext().getResources().getColor(2131689507));
        AppMethodBeat.o(31732);
        return;
      }
      a(2131231525, this.zla, 0);
    }
    AppMethodBeat.o(31732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.al
 * JD-Core Version:    0.7.0.1
 */