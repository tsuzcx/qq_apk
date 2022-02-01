package com.tencent.mm.plugin.textstatus.e;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.textstatus.a.r;
import com.tencent.mm.plugin.textstatus.b.h;
import com.tencent.mm.plugin.textstatus.g.e.f.c;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.ui.TextStatusOtherTopicFriendsActivity;
import com.tencent.mm.plugin.textstatus.ui.TextStatusOtherTopicFriendsActivity.a;
import com.tencent.mm.plugin.textstatus.ui.TextStatusSameTopicsActivity;
import com.tencent.mm.plugin.textstatus.ui.TextStatusSameTopicsActivity.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/logic/BaseProfileLoadLogic;", "Lcom/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic;", "Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;", "showParam", "Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;", "(Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;)V", "descAnimTransMax", "", "getDescAnimTransMax", "()I", "setDescAnimTransMax", "(I)V", "layoutAuthor", "Landroid/view/View;", "getLayoutAuthor", "()Landroid/view/View;", "setLayoutAuthor", "(Landroid/view/View;)V", "layoutAuthorCustomView", "Landroid/widget/FrameLayout;", "getLayoutAuthorCustomView", "()Landroid/widget/FrameLayout;", "setLayoutAuthorCustomView", "(Landroid/widget/FrameLayout;)V", "layoutCenterMove", "getLayoutCenterMove", "setLayoutCenterMove", "layoutNotify", "getLayoutNotify", "setLayoutNotify", "layoutStatus", "getLayoutStatus", "setLayoutStatus", "layoutTopic", "getLayoutTopic", "setLayoutTopic", "pulldownState", "getPulldownState", "setPulldownState", "shouldShowAuthor", "", "getShouldShowAuthor", "()Z", "setShouldShowAuthor", "(Z)V", "showSameTopics", "getShowSameTopics", "setShowSameTopics", "startOpenTime", "", "getStartOpenTime", "()J", "setStartOpenTime", "(J)V", "tvAuthorName", "Landroid/widget/TextView;", "getTvAuthorName", "()Landroid/widget/TextView;", "setTvAuthorName", "(Landroid/widget/TextView;)V", "tvBrandDesc", "getTvBrandDesc", "setTvBrandDesc", "vTopLine", "getVTopLine", "setVTopLine", "brandClick", "", "getSameFriendTipsDefAlpha", "", "goToSameTopic", "handleAuthor", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "handleDescAnimInited", "iconStatusClick", "init", "contentView", "isCanPullDown", "isMusicStatus", "onCoordinationViewClosing", "offset", "onCoordinationViewOpening", "onListInnerScroll", "onMuteIn", "onMuteOut", "onPostClose", "onPostOpen", "isMute", "onPreClose", "onPreOpen", "onPullDownProgress", "persent", "curTranslation", "unfoldTranslation", "update", "username", "", "item", "extraParam", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusCardShowExtraParam;", "updateBrandStatusSplitLine", "markAndGone", "resumeVisibility", "Companion", "plugin-textstatus_release"})
public final class b
  extends c
  implements d
{
  public static final b.a MBK;
  private TextView MBA;
  private View MBB;
  private View MBC;
  View MBD;
  private View MBE;
  private int MBF;
  private boolean MBG;
  private boolean MBH;
  int MBI;
  private long MBJ;
  private View MBw;
  private TextView MBx;
  private FrameLayout MBy;
  private View MBz;
  
  static
  {
    AppMethodBeat.i(238875);
    MBK = new b.a((byte)0);
    AppMethodBeat.o(238875);
  }
  
  public b(r paramr)
  {
    super(paramr);
    AppMethodBeat.i(238873);
    this.MBF = 1;
    AppMethodBeat.o(238873);
  }
  
  private static void gZ(View paramView)
  {
    AppMethodBeat.i(238849);
    p.k(paramView, "$this$markAndGone");
    int i = paramView.getVisibility();
    paramView.setTag(com.tencent.mm.plugin.textstatus.b.e.MwI, Integer.valueOf(i));
    paramView.setVisibility(8);
    AppMethodBeat.o(238849);
  }
  
  private final void glF()
  {
    AppMethodBeat.i(238844);
    int i;
    Context localContext;
    if (p.h(com.tencent.mm.plugin.auth.a.a.crN(), getUsername()))
    {
      i = 1;
      localObject = TextStatusSameTopicsActivity.MNZ;
      localContext = getContext();
      localObject = this.MCs;
      if (localObject == null) {
        break label65;
      }
    }
    label65:
    for (Object localObject = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject).field_TopicId;; localObject = null)
    {
      TextStatusSameTopicsActivity.a.a(localContext, (String)localObject, true, i, getUsername());
      AppMethodBeat.o(238844);
      return;
      i = 3;
      break;
    }
  }
  
  private boolean glH()
  {
    AppMethodBeat.i(238862);
    Object localObject = this.MCs;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject).glY().sourceId;; localObject = null)
    {
      boolean bool = p.h(localObject, "music_player@inner");
      AppMethodBeat.o(238862);
      return bool;
    }
  }
  
  private static void ha(View paramView)
  {
    AppMethodBeat.i(238851);
    p.k(paramView, "$this$resumeVisibility");
    Object localObject = paramView.getTag(com.tencent.mm.plugin.textstatus.b.e.MwI);
    if ((localObject instanceof Integer)) {
      paramView.setVisibility(((Number)localObject).intValue());
    }
    AppMethodBeat.o(238851);
  }
  
  public final void abo(int paramInt) {}
  
  public final void abp(int paramInt) {}
  
  public final void abq(int paramInt) {}
  
  public final boolean b(final String paramString, final com.tencent.mm.plugin.textstatus.g.e.a parama, final com.tencent.mm.plugin.textstatus.proto.i parami)
  {
    AppMethodBeat.i(238839);
    p.k(paramString, "username");
    final boolean bool = super.b(paramString, parama, parami);
    parama = this.MCs;
    parami = new aa.d();
    parami.aaBA = 0;
    int i;
    float f;
    if (parama != null)
    {
      Object localObject = (CharSequence)parama.field_TopicId;
      if ((localObject != null) && (!kotlin.n.n.ba((CharSequence)localObject))) {
        break label602;
      }
      i = 1;
      if (i == 0)
      {
        localObject = com.tencent.mm.plugin.textstatus.b.f.MAm;
        parami.aaBA = com.tencent.mm.plugin.textstatus.b.f.gly().o(parama.field_TopicId, j.ag(new String[] { paramString })).size();
      }
      if ((!glU().ajh(4)) || (parami.aaBA <= 0)) {
        break label616;
      }
      Log.i("MicroMsg.TextStatus.BaseProfileLoadLogic", "sametsize " + parami.aaBA);
      localObject = glJ();
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)getContext().getResources().getString(b.h.MyT, new Object[] { Integer.valueOf(parami.aaBA), com.tencent.mm.plugin.textstatus.k.c.gnz().d(parama.glY()) }));
      }
      this.MBG = true;
      localObject = glJ();
      if (localObject != null)
      {
        if (!this.MBG) {
          break label608;
        }
        f = 1.0F;
        label238:
        ((TextView)localObject).setAlpha(f);
      }
      localObject = glJ();
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = glJ();
      if (localObject != null) {
        ((TextView)localObject).setOnClickListener((View.OnClickListener)new e(this, parama, paramString, parami, bool));
      }
      paramString = com.tencent.mm.plugin.secdata.ui.a.JbV;
      paramString = (com.tencent.mm.plugin.textstatus.proto.f)a.a.a(getContext(), 9, com.tencent.mm.plugin.textstatus.proto.f.class);
      if (paramString != null) {
        paramString.MEX = parami.aaBA;
      }
      label326:
      if (!this.MBG) {
        break label665;
      }
      paramString = this.MCg;
      if (paramString != null) {
        paramString.setAlpha(1.0F);
      }
      label347:
      if (bool)
      {
        parama.glY();
        paramString = glQ();
        parami = this.MBx;
        if (parami != null)
        {
          if (paramString == null) {
            break label697;
          }
          paramString = paramString.dDK();
          label380:
          parami.setText(paramString);
        }
        paramString = com.tencent.mm.plugin.secdata.ui.a.JbV;
        paramString = (com.tencent.mm.plugin.textstatus.proto.f)a.a.a(getContext(), 9, com.tencent.mm.plugin.textstatus.proto.f.class);
        if (paramString != null) {
          paramString.MFc = this.MBF;
        }
      }
    }
    if (bool)
    {
      paramString = this.MCq;
      if (paramString != null) {
        paramString.addOnLayoutChangeListener((View.OnLayoutChangeListener)new f(this));
      }
      if (parama == null) {
        break label702;
      }
      paramString = parama.glY().sourceId;
      label458:
      paramString = (CharSequence)paramString;
      if ((paramString != null) && (!kotlin.n.n.ba(paramString))) {
        break label707;
      }
      i = 1;
      label477:
      if (i != 0) {
        break label756;
      }
      parami = glQ();
      paramString = this.MBy;
      if (paramString != null) {
        paramString.removeAllViews();
      }
      if (this.MBy != null) {
        break label713;
      }
      paramString = Boolean.FALSE;
      label511:
      if (parami == null) {
        break label737;
      }
      parama = parami.dDJ();
      label520:
      if (!p.h(paramString, Boolean.TRUE)) {
        break label748;
      }
      if ((parama != null) && (!kotlin.n.n.ba(parama))) {
        break label742;
      }
      i = 1;
      label544:
      if (i != 0) {
        break label748;
      }
      this.MBH = true;
      paramString = this.MBA;
      if (paramString != null) {
        paramString.setText(parama);
      }
      paramString = this.MBz;
      if (paramString != null) {
        paramString.setOnClickListener((View.OnClickListener)new b(this, parami));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(238839);
      return bool;
      label602:
      i = 0;
      break;
      label608:
      f = 0.6F;
      break label238;
      label616:
      paramString = glJ();
      if (paramString != null) {
        paramString.setVisibility(8);
      }
      paramString = glJ();
      if (paramString != null) {
        paramString.setText((CharSequence)com.tencent.mm.plugin.textstatus.k.c.gnz().d(parama.glY()));
      }
      this.MBG = false;
      break label326;
      label665:
      paramString = this.MCg;
      if (paramString == null) {
        break label347;
      }
      parami = parama.field_IconID;
      p.j(parami, "info.field_IconID");
      paramString.setAlpha(ber(parami));
      break label347;
      label697:
      paramString = null;
      break label380;
      label702:
      paramString = null;
      break label458;
      label707:
      i = 0;
      break label477;
      label713:
      if (parami != null)
      {
        paramString = Boolean.valueOf(parami.f(this.MBy));
        break label511;
      }
      paramString = null;
      break label511;
      label737:
      parama = null;
      break label520;
      label742:
      i = 0;
      break label544;
      label748:
      this.MBH = false;
      continue;
      label756:
      this.MBH = false;
    }
  }
  
  public final void dDB()
  {
    AppMethodBeat.i(238865);
    Object localObject = this.MBw;
    if (localObject != null)
    {
      localObject = ((View)localObject).animate();
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
        if (localObject != null)
        {
          ((ViewPropertyAnimator)localObject).setDuration(200L);
          AppMethodBeat.o(238865);
          return;
        }
      }
    }
    AppMethodBeat.o(238865);
  }
  
  public final void dDC()
  {
    AppMethodBeat.i(238867);
    Object localObject = this.MBw;
    if (localObject != null)
    {
      localObject = ((View)localObject).animate();
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).alpha(0.15F);
        if (localObject != null)
        {
          ((ViewPropertyAnimator)localObject).setDuration(200L);
          AppMethodBeat.o(238867);
          return;
        }
      }
    }
    AppMethodBeat.o(238867);
  }
  
  public final void fqe() {}
  
  public final void fqf() {}
  
  public final void g(View paramView)
  {
    AppMethodBeat.i(238829);
    p.k(paramView, "contentView");
    super.g(paramView);
    this.MBw = paramView.findViewById(com.tencent.mm.plugin.textstatus.b.e.Mxz);
    this.MBx = ((TextView)paramView.findViewById(com.tencent.mm.plugin.textstatus.b.e.tv_brand_desc));
    this.MBy = ((FrameLayout)paramView.findViewById(com.tencent.mm.plugin.textstatus.b.e.MvG));
    this.MBz = paramView.findViewById(com.tencent.mm.plugin.textstatus.b.e.MvF);
    this.MBA = ((TextView)paramView.findViewById(com.tencent.mm.plugin.textstatus.b.e.MwO));
    this.MBB = paramView.findViewById(com.tencent.mm.plugin.textstatus.b.e.Mwf);
    this.MBC = paramView.findViewById(com.tencent.mm.plugin.textstatus.b.e.MvW);
    this.MBD = paramView.findViewById(com.tencent.mm.plugin.textstatus.b.e.MvO);
    this.MBE = paramView.findViewById(com.tencent.mm.plugin.textstatus.b.e.Mwj);
    paramView = com.tencent.mm.plugin.textstatus.k.n.MOY;
    com.tencent.mm.plugin.textstatus.k.n.B((View)this.MBy, com.tencent.mm.ci.a.fromDPToPix(getContext(), 10.0F));
    final int i = com.tencent.mm.ci.a.fromDPToPix(getContext(), 20);
    paramView = this.MBE;
    if (paramView != null)
    {
      paramView.setOnTouchListener((View.OnTouchListener)new d(this, i));
      AppMethodBeat.o(238829);
      return;
    }
    AppMethodBeat.o(238829);
  }
  
  public final boolean gkG()
  {
    AppMethodBeat.i(238825);
    boolean bool = com.tencent.mm.plugin.textstatus.ui.b.a(getUsername(), (com.tencent.mm.plugin.textstatus.a.i)glQ(), this.MCs);
    AppMethodBeat.o(238825);
    return bool;
  }
  
  public final void glD()
  {
    AppMethodBeat.i(238833);
    View localView = glP();
    if (localView != null)
    {
      Object localObject = glL();
      if ((localObject != null) && (((LinearLayout)localObject).getVisibility() == 0))
      {
        localObject = this.MCg;
        if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0))
        {
          localObject = this.MBB;
          if ((localObject == null) || (((View)localObject).getVisibility() != 0)) {}
        }
      }
      for (int i = 0;; i = 8)
      {
        localView.setVisibility(i);
        AppMethodBeat.o(238833);
        return;
      }
    }
    AppMethodBeat.o(238833);
  }
  
  public final boolean glE()
  {
    Object localObject2 = null;
    AppMethodBeat.i(238842);
    Object localObject1;
    Object localObject3;
    int i;
    Object localObject4;
    if (!super.glE()) {
      if (p.h(getUsername(), com.tencent.mm.plugin.auth.a.a.crN()))
      {
        localObject1 = com.tencent.mm.plugin.textstatus.b.f.MAm;
        localObject3 = com.tencent.mm.plugin.textstatus.b.f.bep(com.tencent.mm.plugin.auth.a.a.crN());
        localObject1 = com.tencent.mm.plugin.textstatus.b.f.MAm;
        int j = com.tencent.mm.plugin.textstatus.b.f.gly().gmg();
        if (localObject3 != null)
        {
          i = 1;
          localObject1 = com.tencent.mm.plugin.textstatus.b.f.MAm;
          localObject4 = com.tencent.mm.plugin.textstatus.b.f.gly();
          if (localObject3 == null) {
            break label197;
          }
          localObject1 = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject3).field_TopicId;
          label79:
          String str = com.tencent.mm.plugin.auth.a.a.crN();
          p.j(str, "Account.username()");
          if ((!((com.tencent.mm.plugin.textstatus.g.e.f)localObject4).o((String)localObject1, j.ag(new String[] { str })).isEmpty()) || (j - i <= 0)) {
            break label230;
          }
          localObject1 = com.tencent.mm.plugin.textstatus.b.f.MAm;
          localObject4 = com.tencent.mm.plugin.textstatus.b.f.gly();
          if (localObject3 == null) {
            break label202;
          }
          localObject1 = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject3).field_TopicId;
          label144:
          localObject1 = ((com.tencent.mm.plugin.textstatus.g.e.f)localObject4).lA((String)localObject1, com.tencent.mm.plugin.auth.a.a.crN()).iterator();
          i = 0;
          label161:
          if (!((Iterator)localObject1).hasNext()) {
            break label207;
          }
          if (!((f.c)((Iterator)localObject1).next()).isValid()) {
            break label339;
          }
          i += 1;
        }
      }
    }
    label197:
    label202:
    label207:
    label339:
    for (;;)
    {
      break label161;
      i = 0;
      break;
      localObject1 = null;
      break label79;
      localObject1 = null;
      break label144;
      if (i > 0)
      {
        localObject1 = TextStatusOtherTopicFriendsActivity.MNI;
        TextStatusOtherTopicFriendsActivity.a.iy(getContext());
        AppMethodBeat.o(238842);
        return true;
      }
      label230:
      glF();
      localObject1 = com.tencent.mm.plugin.textstatus.b.f.MAm;
      localObject3 = com.tencent.mm.plugin.textstatus.b.f.gly();
      localObject4 = this.MCs;
      localObject1 = localObject2;
      if (localObject4 != null) {
        localObject1 = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject4).field_TopicId;
      }
      localObject2 = com.tencent.mm.plugin.auth.a.a.crN();
      p.j(localObject2, "Account.username()");
      localObject1 = ((com.tencent.mm.plugin.textstatus.g.e.f)localObject3).o((String)localObject1, j.ag(new String[] { localObject2 }));
      localObject2 = com.tencent.mm.plugin.textstatus.h.a.MGJ;
      com.tencent.mm.plugin.textstatus.h.a.a(getContext(), 25L, String.valueOf(((List)localObject1).size()), this.MCs);
      AppMethodBeat.o(238842);
      return true;
      AppMethodBeat.o(238842);
      return false;
    }
  }
  
  public final void glG()
  {
    AppMethodBeat.i(238860);
    super.glG();
    if ((this.MBF == 2) && (glH()))
    {
      com.tencent.mm.plugin.textstatus.h.a locala = com.tencent.mm.plugin.textstatus.h.a.MGJ;
      com.tencent.mm.plugin.textstatus.h.a.a(getContext(), 63L, null, this.MCs, 4);
    }
    AppMethodBeat.o(238860);
  }
  
  public final void onPostClose()
  {
    AppMethodBeat.i(238859);
    long l1 = cm.bfE();
    long l2 = this.MBJ;
    this.MBF = 1;
    Object localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
    localObject = (com.tencent.mm.plugin.textstatus.proto.f)a.a.a(getContext(), 9, com.tencent.mm.plugin.textstatus.proto.f.class);
    if (localObject != null) {
      ((com.tencent.mm.plugin.textstatus.proto.f)localObject).MFc = this.MBF;
    }
    localObject = this.MBx;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    if (!this.MBG)
    {
      localObject = glJ();
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    localObject = this.MBz;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.MCs;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject).glY();
      if ((localObject != null) && (b((TextStatusTopicInfo)localObject) == true))
      {
        LinearLayout localLinearLayout = glL();
        if (localLinearLayout != null) {
          localLinearLayout.setVisibility(0);
        }
      }
      if (localObject == null) {
        break label436;
      }
      localObject = ((TextStatusTopicInfo)localObject).sourceId;
      label180:
      localObject = (CharSequence)localObject;
      if ((localObject != null) && (!kotlin.n.n.ba((CharSequence)localObject))) {
        break label442;
      }
    }
    label436:
    label442:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = glQ();
        if ((localObject != null) && (((com.tencent.mm.plugin.textstatus.a.c)localObject).dDH() == true))
        {
          localObject = glI();
          if (localObject != null) {
            ha((View)localObject);
          }
          localObject = this.MBB;
          if (localObject != null) {
            ha((View)localObject);
          }
          localObject = this.MBC;
          if (localObject != null) {
            ha((View)localObject);
          }
          localObject = glK();
          if (localObject != null) {
            ha((View)localObject);
          }
          if (p.h(getUsername(), com.tencent.mm.plugin.auth.a.a.crN()))
          {
            localObject = glM();
            if (localObject != null) {
              ha((View)localObject);
            }
            localObject = glO();
            if (localObject != null) {
              ha((View)localObject);
            }
            localObject = glN();
            if (localObject != null) {
              ha((View)localObject);
            }
          }
        }
      }
      glD();
      localObject = com.tencent.mm.plugin.textstatus.h.a.MGJ;
      com.tencent.mm.plugin.textstatus.h.a.a(getContext(), 65L, null, null, 12);
      if ((glH()) && (l1 - l2 > 5000L))
      {
        localObject = com.tencent.mm.plugin.textstatus.h.a.MGJ;
        com.tencent.mm.plugin.textstatus.h.a.a(getContext(), 64L, null, null, 12);
      }
      AppMethodBeat.o(238859);
      return;
      localObject = null;
      break;
      localObject = null;
      break label180;
    }
  }
  
  public final void onPostOpen(boolean paramBoolean)
  {
    AppMethodBeat.i(238855);
    this.MBJ = cm.bfE();
    this.MBF = 2;
    Object localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
    localObject = (com.tencent.mm.plugin.textstatus.proto.f)a.a.a(getContext(), 9, com.tencent.mm.plugin.textstatus.proto.f.class);
    if (localObject != null) {
      ((com.tencent.mm.plugin.textstatus.proto.f)localObject).MFc = this.MBF;
    }
    localObject = glJ();
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = glQ();
    if ((localObject == null) || (((com.tencent.mm.plugin.textstatus.a.c)localObject).ffP() != true))
    {
      localObject = glL();
      if (localObject != null) {
        ((LinearLayout)localObject).setVisibility(8);
      }
    }
    localObject = this.MCs;
    int i;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject).glY().sourceId;
      localObject = (CharSequence)localObject;
      if ((localObject != null) && (!kotlin.n.n.ba((CharSequence)localObject))) {
        break label355;
      }
      i = 1;
      label131:
      if (i == 0)
      {
        localObject = glQ();
        if ((localObject != null) && (((com.tencent.mm.plugin.textstatus.a.c)localObject).dDH() == true))
        {
          localObject = glQ();
          if (localObject == null) {
            break label360;
          }
        }
      }
    }
    label355:
    label360:
    for (paramBoolean = ((com.tencent.mm.plugin.textstatus.a.c)localObject).dOW();; paramBoolean = true)
    {
      if (paramBoolean)
      {
        if (this.MBH)
        {
          localObject = this.MBz;
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
        }
        localObject = this.MBx;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
      }
      localObject = glI();
      if (localObject != null) {
        gZ((View)localObject);
      }
      localObject = this.MBB;
      if (localObject != null) {
        gZ((View)localObject);
      }
      localObject = this.MBC;
      if (localObject != null) {
        gZ((View)localObject);
      }
      localObject = glK();
      if (localObject != null) {
        gZ((View)localObject);
      }
      if (p.h(getUsername(), com.tencent.mm.plugin.auth.a.a.crN()))
      {
        localObject = glM();
        if (localObject != null) {
          gZ((View)localObject);
        }
        localObject = glO();
        if (localObject != null) {
          gZ((View)localObject);
        }
        localObject = glN();
        if (localObject != null) {
          gZ((View)localObject);
        }
      }
      glD();
      localObject = com.tencent.mm.plugin.textstatus.h.a.MGJ;
      com.tencent.mm.plugin.textstatus.h.a.a(getContext(), 42L, null, null, 12);
      AppMethodBeat.o(238855);
      return;
      localObject = null;
      break;
      i = 0;
      break label131;
    }
  }
  
  public final void r(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(238846);
    paramFloat2 = this.MBI;
    View localView = this.MBD;
    if (localView != null)
    {
      localView.setTranslationY(paramFloat2 * paramFloat1);
      AppMethodBeat.o(238846);
      return;
    }
    AppMethodBeat.o(238846);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(b paramb, com.tencent.mm.plugin.textstatus.a.c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(232284);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/logic/BaseProfileLoadLogic$handleAuthor$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = parami;
      if (paramView != null) {
        paramView.fA(this.MBL.getContext());
      }
      paramView = com.tencent.mm.plugin.textstatus.h.a.MGJ;
      com.tencent.mm.plugin.textstatus.h.a.a(this.MBL.getContext(), 61L, null, null, 12);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/logic/BaseProfileLoadLogic$handleAuthor$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(232284);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(236916);
      Object localObject = this.MBL.MBD;
      int i;
      int j;
      if (localObject != null)
      {
        i = (int)((View)localObject).getY();
        localObject = this.MBL.MBD;
        if (localObject == null) {
          break label114;
        }
        j = ((View)localObject).getMeasuredHeight();
        label46:
        localObject = this.MBL.MCq;
        if (localObject == null) {
          break label119;
        }
      }
      label114:
      label119:
      for (int k = ((LinearLayout)localObject).getMeasuredHeight();; k = 0)
      {
        int m = this.MBL.getContext().getResources().getDimensionPixelSize(com.tencent.mm.plugin.textstatus.b.c.Muu);
        this.MBL.MBI = Math.max(k - (j + i) - m, 0);
        AppMethodBeat.o(236916);
        return;
        i = 0;
        break;
        j = 0;
        break label46;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/logic/BaseProfileLoadLogic$init$1", "Landroid/view/View$OnTouchListener;", "isCatchDown", "", "()Z", "setCatchDown", "(Z)V", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-textstatus_release"})
  public static final class d
    implements View.OnTouchListener
  {
    private boolean MBN;
    
    d(int paramInt) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      boolean bool1 = true;
      boolean bool2 = false;
      AppMethodBeat.i(238182);
      if (paramMotionEvent != null)
      {
        paramView = Integer.valueOf(paramMotionEvent.getAction());
        if (paramView != null) {
          break label43;
        }
        label27:
        if (paramView != null) {
          break label97;
        }
      }
      label43:
      label97:
      while (paramView.intValue() != 1)
      {
        AppMethodBeat.o(238182);
        return false;
        paramView = null;
        break;
        if (paramView.intValue() != 0) {
          break label27;
        }
        f = paramMotionEvent.getX();
        if ((f >= 0.0F) && (f < i)) {}
        for (;;)
        {
          this.MBN = bool1;
          bool1 = this.MBN;
          AppMethodBeat.o(238182);
          return bool1;
          bool1 = false;
        }
      }
      float f = paramMotionEvent.getX();
      bool1 = bool2;
      if (f >= 0.0F)
      {
        bool1 = bool2;
        if (f < i)
        {
          bool1 = bool2;
          if (this.MBN) {
            bool1 = true;
          }
        }
      }
      if (bool1)
      {
        paramView = this.MBL.MCg;
        if (paramView != null) {
          paramView.performClick();
        }
      }
      AppMethodBeat.o(238182);
      return bool1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/textstatus/logic/BaseProfileLoadLogic$update$1$1"})
  static final class e
    implements View.OnClickListener
  {
    e(b paramb, com.tencent.mm.plugin.textstatus.g.e.a parama, String paramString, aa.d paramd, boolean paramBoolean) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(234548);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/logic/BaseProfileLoadLogic$update$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      b.a(this.MBL);
      paramView = com.tencent.mm.plugin.textstatus.h.a.MGJ;
      com.tencent.mm.plugin.textstatus.h.a.a(this.MBL.getContext(), 21L, null, null, 12);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/logic/BaseProfileLoadLogic$update$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(234548);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"})
  static final class f
    implements View.OnLayoutChangeListener
  {
    f(b paramb) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(232228);
      p.j(paramView, "v");
      if (paramInt8 - paramInt6 != paramView.getHeight()) {
        b.b(this.MBL);
      }
      AppMethodBeat.o(232228);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.e.b
 * JD-Core Version:    0.7.0.1
 */