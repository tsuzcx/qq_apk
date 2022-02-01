package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.ez;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.story.api.AbsStoryPreference;
import com.tencent.mm.plugin.story.api.p;
import com.tencent.mm.plugin.story.api.p.b;
import com.tencent.mm.plugin.story.e.a.a;
import com.tencent.mm.plugin.story.f.a.i;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.ui.StoryBrowseUI;
import com.tencent.mm.protocal.protobuf.ddp;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bf;
import com.tencent.mm.ui.am;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/StoryPreference;", "Lcom/tencent/mm/plugin/story/api/AbsStoryPreference;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isAddedSceneListener", "", "mCallback", "Lcom/tencent/mm/plugin/story/api/ILoadFavStoryCallback;", "mCoverView", "Landroid/view/View;", "mStoryFavList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "mStoryIconView1", "Landroid/widget/ImageView;", "mStoryIconView2", "mStoryIconView3", "mStoryView1", "Lcom/tencent/mm/plugin/story/ui/view/StoryRoundImageView;", "mStoryView2", "mStoryView3", "mStoryViewGroup1", "Landroid/view/ViewGroup;", "mStoryViewGroup2", "mStoryViewGroup3", "mTitleView", "Landroid/widget/TextView;", "mUsername", "", "mView", "getDateList", "", "goFavGallery", "", "position", "handleEvent", "loadStory", "onBindView", "view", "onCreate", "username", "onCreateView", "parent", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setLoadCallback", "callback", "updateFavStory", "plugin-story_release"})
public final class StoryPreference
  extends AbsStoryPreference
  implements com.tencent.mm.ak.g
{
  private TextView Vw;
  private String lhM;
  private View mView;
  private View uCg;
  private StoryRoundImageView zKj;
  private StoryRoundImageView zKk;
  private StoryRoundImageView zKl;
  private ImageView zKm;
  private ImageView zKn;
  private ImageView zKo;
  private ViewGroup zKp;
  private ViewGroup zKq;
  private ViewGroup zKr;
  private ArrayList<com.tencent.mm.plugin.story.i.j> zKs;
  private com.tencent.mm.plugin.story.api.d zKt;
  private boolean zKu;
  
  public StoryPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(120298);
    AppMethodBeat.o(120298);
  }
  
  public StoryPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120299);
    paramContext = View.inflate(getContext(), 2131495714, null);
    d.g.b.k.g(paramContext, "View.inflate(context, R.…e_fav_panel_layout, null)");
    this.mView = paramContext;
    this.zKs = new ArrayList();
    this.lhM = "";
    paramContext = this.mView.findViewById(16908310);
    d.g.b.k.g(paramContext, "mView.findViewById(android.R.id.title)");
    this.Vw = ((TextView)paramContext);
    paramContext = this.mView.findViewById(2131302330);
    d.g.b.k.g(paramContext, "mView.findViewById(R.id.…eference_story_image_iv1)");
    this.zKj = ((StoryRoundImageView)paramContext);
    paramContext = this.mView.findViewById(2131302332);
    d.g.b.k.g(paramContext, "mView.findViewById(R.id.…eference_story_image_iv2)");
    this.zKk = ((StoryRoundImageView)paramContext);
    paramContext = this.mView.findViewById(2131302334);
    d.g.b.k.g(paramContext, "mView.findViewById(R.id.…eference_story_image_iv3)");
    this.zKl = ((StoryRoundImageView)paramContext);
    paramContext = this.mView.findViewById(2131302327);
    d.g.b.k.g(paramContext, "mView.findViewById(R.id.…erence_story_image_icon1)");
    this.zKm = ((ImageView)paramContext);
    paramContext = this.mView.findViewById(2131302328);
    d.g.b.k.g(paramContext, "mView.findViewById(R.id.…erence_story_image_icon2)");
    this.zKn = ((ImageView)paramContext);
    paramContext = this.mView.findViewById(2131302329);
    d.g.b.k.g(paramContext, "mView.findViewById(R.id.…erence_story_image_icon3)");
    this.zKo = ((ImageView)paramContext);
    paramContext = this.mView.findViewById(2131302331);
    d.g.b.k.g(paramContext, "mView.findViewById(R.id.…ce_story_image_iv1_group)");
    this.zKp = ((ViewGroup)paramContext);
    paramContext = this.mView.findViewById(2131302333);
    d.g.b.k.g(paramContext, "mView.findViewById(R.id.…ce_story_image_iv2_group)");
    this.zKq = ((ViewGroup)paramContext);
    paramContext = this.mView.findViewById(2131302335);
    d.g.b.k.g(paramContext, "mView.findViewById(R.id.…ce_story_image_iv3_group)");
    this.zKr = ((ViewGroup)paramContext);
    paramInt = com.tencent.mm.cc.a.fromDPToPix(getContext(), 8);
    this.zKj.setRound(paramInt);
    this.zKk.setRound(paramInt);
    this.zKl.setRound(paramInt);
    paramContext = am.k(getContext(), 2131690460, -1);
    this.zKm.setImageDrawable(paramContext);
    this.zKn.setImageDrawable(paramContext);
    this.zKo.setImageDrawable(paramContext);
    this.zKj.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120286);
        StoryPreference.a(this.zKv, 0);
        AppMethodBeat.o(120286);
      }
    });
    this.zKk.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120287);
        StoryPreference.a(this.zKv, 1);
        AppMethodBeat.o(120287);
      }
    });
    this.zKl.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120288);
        StoryPreference.a(this.zKv, 2);
        AppMethodBeat.o(120288);
      }
    });
    AppMethodBeat.o(120299);
  }
  
  private final void QT(int paramInt)
  {
    AppMethodBeat.i(120289);
    Object localObject1 = new ArrayList();
    Object localObject2 = ((Iterable)this.zKs).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject2).next();
      localObject4 = com.tencent.mm.plugin.story.e.a.zrf;
      ((ArrayList)localObject1).add(a.a.l(Integer.valueOf(((com.tencent.mm.plugin.story.i.j)localObject3).field_createTime)));
    }
    localObject1 = (List)localObject1;
    localObject2 = p.zqo;
    Object localObject3 = this.lhM;
    Object localObject4 = com.tencent.mm.plugin.story.g.d.zxs;
    long l = ((p.b)localObject2).b((List)localObject1, (String)localObject3, com.tencent.mm.plugin.story.g.d.dXd());
    localObject2 = new Intent(getContext(), StoryBrowseUI.class);
    ((Intent)localObject2).putExtra("username", this.lhM);
    ((Intent)localObject2).putExtra("data_seed_key", l);
    ((Intent)localObject2).putExtra("v_position", paramInt);
    ((Intent)localObject2).putExtra("gallery_story_need_action", true);
    localObject1 = getContext();
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/story/ui/view/StoryPreference", "goFavGallery", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/story/ui/view/StoryPreference", "goFavGallery", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localObject1 = h.zAU;
    h.dXK().jm(14L);
    AppMethodBeat.o(120289);
  }
  
  public final void a(com.tencent.mm.plugin.story.api.d paramd)
  {
    this.zKt = paramd;
  }
  
  public final void dUA()
  {
    AppMethodBeat.i(120291);
    Object localObject1 = com.tencent.mm.plugin.story.f.n.zsw;
    localObject1 = this.lhM;
    d.g.b.k.h(localObject1, "username");
    Object localObject2 = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localObject2, "MMKernel.network()");
    localObject2 = ((b)localObject2).agi();
    Object localObject3 = com.tencent.mm.plugin.story.f.j.zsh;
    boolean bool = bs.lr((String)localObject1, j.b.dHx());
    localObject3 = com.tencent.mm.plugin.story.i.a.zBQ;
    ((q)localObject2).b((com.tencent.mm.ak.n)new i((String)localObject1, 0L, bool, "", com.tencent.mm.plugin.story.i.a.dYL()));
    AppMethodBeat.o(120291);
  }
  
  public final void dUB()
  {
    int j = 1;
    int k = 1;
    AppMethodBeat.i(120292);
    Object localObject1 = this.Vw.getLayoutParams();
    if (localObject1 != null) {
      ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cc.a.au(getContext(), 2131165370);
    }
    this.Vw.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.zKs.clear();
    localObject1 = this.zKs;
    Object localObject2 = com.tencent.mm.plugin.story.f.j.zsh;
    localObject2 = j.b.dVE();
    Object localObject3 = this.lhM;
    Object localObject4 = this.lhM;
    j.b localb = com.tencent.mm.plugin.story.f.j.zsh;
    ((ArrayList)localObject1).addAll((Collection)((com.tencent.mm.plugin.story.i.k)localObject2).a((String)localObject3, bs.lr((String)localObject4, j.b.dHx()), 0L, 20));
    this.zKp.setVisibility(8);
    this.zKq.setVisibility(8);
    this.zKr.setVisibility(8);
    int i;
    if (!((Collection)this.zKs).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label444;
      }
      localObject1 = this.Vw;
      localObject2 = getContext();
      d.g.b.k.g(localObject2, "context");
      ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(2131757878));
      label201:
      if (this.zKs.size() != 1) {
        break label464;
      }
      this.Vw.setVisibility(0);
      this.zKp.setVisibility(0);
      localObject2 = ((com.tencent.mm.plugin.story.i.j)this.zKs.get(0)).dZi().FOc;
      if (localObject2 != null)
      {
        localObject1 = ((ddp)localObject2).Etz;
        d.g.b.k.g(localObject1, "obj.MediaObjList");
        if (((Collection)localObject1).isEmpty()) {
          break label459;
        }
        i = k;
        label282:
        if (i != 0)
        {
          localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
          localObject1 = j.b.dVM();
          localObject2 = ((ddp)localObject2).Etz.get(0);
          d.g.b.k.g(localObject2, "obj.MediaObjList[0]");
          localObject2 = (ddy)localObject2;
          localObject3 = ((com.tencent.mm.plugin.story.i.j)this.zKs.get(0)).field_userName;
          localObject4 = bf.GYL;
          d.g.b.k.g(localObject4, "FROM_SCENE.storyalbum");
          localObject2 = new com.tencent.mm.plugin.story.f.c.d((ddy)localObject2, (String)localObject3, (bf)localObject4);
          localObject3 = this.zKj;
          if (localObject3 == null) {
            d.g.b.k.fOy();
          }
          localObject3 = (ImageView)localObject3;
          localObject4 = com.tencent.mm.plugin.story.f.j.zsh;
          ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.zuj));
        }
      }
    }
    label444:
    label967:
    for (;;)
    {
      localObject1 = this.zKt;
      if (localObject1 == null) {
        break label1468;
      }
      ((com.tencent.mm.plugin.story.api.d)localObject1).ez((List)this.zKs);
      AppMethodBeat.o(120292);
      return;
      i = 0;
      break;
      this.Vw.setText((CharSequence)"");
      break label201;
      label459:
      i = 0;
      break label282;
      label464:
      if (this.zKs.size() == 2)
      {
        this.Vw.setVisibility(0);
        this.zKp.setVisibility(0);
        this.zKq.setVisibility(0);
        localObject2 = ((com.tencent.mm.plugin.story.i.j)this.zKs.get(0)).dZi().FOc;
        if (localObject2 != null)
        {
          localObject1 = ((ddp)localObject2).Etz;
          d.g.b.k.g(localObject1, "obj1.MediaObjList");
          if (((Collection)localObject1).isEmpty()) {
            break label860;
          }
          i = 1;
          if (i != 0)
          {
            localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
            localObject1 = j.b.dVM();
            localObject2 = ((ddp)localObject2).Etz.get(0);
            d.g.b.k.g(localObject2, "obj1.MediaObjList[0]");
            localObject2 = (ddy)localObject2;
            localObject3 = ((com.tencent.mm.plugin.story.i.j)this.zKs.get(0)).field_userName;
            localObject4 = bf.GYL;
            d.g.b.k.g(localObject4, "FROM_SCENE.storyalbum");
            localObject2 = new com.tencent.mm.plugin.story.f.c.d((ddy)localObject2, (String)localObject3, (bf)localObject4);
            localObject3 = this.zKj;
            if (localObject3 == null) {
              d.g.b.k.fOy();
            }
            localObject3 = (ImageView)localObject3;
            localObject4 = com.tencent.mm.plugin.story.f.j.zsh;
            ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.zuj));
          }
        }
        localObject2 = ((com.tencent.mm.plugin.story.i.j)this.zKs.get(1)).dZi().FOc;
        if (localObject2 != null)
        {
          localObject1 = ((ddp)localObject2).Etz;
          d.g.b.k.g(localObject1, "obj2.MediaObjList");
          if (!((Collection)localObject1).isEmpty()) {}
          for (i = j;; i = 0)
          {
            if (i == 0) {
              break label868;
            }
            localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
            localObject1 = j.b.dVM();
            localObject2 = ((ddp)localObject2).Etz.get(0);
            d.g.b.k.g(localObject2, "obj2.MediaObjList[0]");
            localObject2 = (ddy)localObject2;
            localObject3 = ((com.tencent.mm.plugin.story.i.j)this.zKs.get(0)).field_userName;
            localObject4 = bf.GYL;
            d.g.b.k.g(localObject4, "FROM_SCENE.storyalbum");
            localObject2 = new com.tencent.mm.plugin.story.f.c.d((ddy)localObject2, (String)localObject3, (bf)localObject4);
            localObject3 = this.zKk;
            if (localObject3 == null) {
              d.g.b.k.fOy();
            }
            localObject3 = (ImageView)localObject3;
            localObject4 = com.tencent.mm.plugin.story.f.j.zsh;
            ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.zuj));
            break;
            label860:
            i = 0;
            break label553;
          }
        }
      }
      else
      {
        label868:
        if (this.zKs.size() >= 3)
        {
          this.Vw.setVisibility(0);
          this.zKp.setVisibility(0);
          this.zKq.setVisibility(0);
          this.zKr.setVisibility(0);
          localObject2 = ((com.tencent.mm.plugin.story.i.j)this.zKs.get(0)).dZi().FOc;
          if (localObject2 != null)
          {
            localObject1 = ((ddp)localObject2).Etz;
            d.g.b.k.g(localObject1, "obj1.MediaObjList");
            if (((Collection)localObject1).isEmpty()) {
              break label1453;
            }
            i = 1;
            if (i != 0)
            {
              localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
              localObject1 = j.b.dVM();
              localObject2 = ((ddp)localObject2).Etz.get(0);
              d.g.b.k.g(localObject2, "obj1.MediaObjList[0]");
              localObject2 = (ddy)localObject2;
              localObject3 = ((com.tencent.mm.plugin.story.i.j)this.zKs.get(0)).field_userName;
              localObject4 = bf.GYL;
              d.g.b.k.g(localObject4, "FROM_SCENE.storyalbum");
              localObject2 = new com.tencent.mm.plugin.story.f.c.d((ddy)localObject2, (String)localObject3, (bf)localObject4);
              localObject3 = this.zKj;
              if (localObject3 == null) {
                d.g.b.k.fOy();
              }
              localObject3 = (ImageView)localObject3;
              localObject4 = com.tencent.mm.plugin.story.f.j.zsh;
              ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.zuj));
            }
          }
          localObject2 = ((com.tencent.mm.plugin.story.i.j)this.zKs.get(1)).dZi().FOc;
          if (localObject2 != null)
          {
            localObject1 = ((ddp)localObject2).Etz;
            d.g.b.k.g(localObject1, "obj2.MediaObjList");
            if (((Collection)localObject1).isEmpty()) {
              break label1458;
            }
            i = 1;
            label1146:
            if (i != 0)
            {
              localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
              localObject1 = j.b.dVM();
              localObject2 = ((ddp)localObject2).Etz.get(0);
              d.g.b.k.g(localObject2, "obj2.MediaObjList[0]");
              localObject2 = (ddy)localObject2;
              localObject3 = ((com.tencent.mm.plugin.story.i.j)this.zKs.get(0)).field_userName;
              localObject4 = bf.GYL;
              d.g.b.k.g(localObject4, "FROM_SCENE.storyalbum");
              localObject2 = new com.tencent.mm.plugin.story.f.c.d((ddy)localObject2, (String)localObject3, (bf)localObject4);
              localObject3 = this.zKk;
              if (localObject3 == null) {
                d.g.b.k.fOy();
              }
              localObject3 = (ImageView)localObject3;
              localObject4 = com.tencent.mm.plugin.story.f.j.zsh;
              ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.zuj));
            }
          }
          localObject2 = ((com.tencent.mm.plugin.story.i.j)this.zKs.get(2)).dZi().FOc;
          if (localObject2 != null)
          {
            localObject1 = ((ddp)localObject2).Etz;
            d.g.b.k.g(localObject1, "obj3.MediaObjList");
            if (!((Collection)localObject1).isEmpty()) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label1466;
              }
              localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
              localObject1 = j.b.dVM();
              localObject2 = ((ddp)localObject2).Etz.get(0);
              d.g.b.k.g(localObject2, "obj3.MediaObjList[0]");
              localObject2 = (ddy)localObject2;
              localObject3 = ((com.tencent.mm.plugin.story.i.j)this.zKs.get(0)).field_userName;
              localObject4 = bf.GYL;
              d.g.b.k.g(localObject4, "FROM_SCENE.storyalbum");
              localObject2 = new com.tencent.mm.plugin.story.f.c.d((ddy)localObject2, (String)localObject3, (bf)localObject4);
              localObject3 = this.zKl;
              if (localObject3 == null) {
                d.g.b.k.fOy();
              }
              localObject3 = (ImageView)localObject3;
              localObject4 = com.tencent.mm.plugin.story.f.j.zsh;
              ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.zuj));
              break;
              i = 0;
              break label967;
              i = 0;
              break label1146;
            }
          }
        }
      }
    }
    label553:
    label1453:
    label1458:
    label1466:
    label1468:
    AppMethodBeat.o(120292);
  }
  
  public final void dUC()
  {
    AppMethodBeat.i(120293);
    if (!((Collection)this.zKs).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        QT(0);
      }
      AppMethodBeat.o(120293);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(120297);
    d.g.b.k.h(paramView, "view");
    super.onBindView(paramView);
    dUB();
    AppMethodBeat.o(120297);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(120290);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.lhM = str;
    if (!this.zKu)
    {
      paramString = com.tencent.mm.kernel.g.agQ();
      d.g.b.k.g(paramString, "MMKernel.network()");
      paramString.agi().a(273, (com.tencent.mm.ak.g)this);
      this.zKu = true;
    }
    AppMethodBeat.o(120290);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120296);
    d.g.b.k.h(paramViewGroup, "parent");
    if (this.uCg == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
      localViewGroup.removeAllViews();
      this.mView.setId(2131305937);
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
      localViewGroup.addView(this.mView, localLayoutParams);
      this.uCg = paramViewGroup;
    }
    paramViewGroup = this.uCg;
    if (paramViewGroup == null) {
      d.g.b.k.fOy();
    }
    AppMethodBeat.o(120296);
    return paramViewGroup;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(120294);
    this.zKt = null;
    b localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.agi().b(273, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(120294);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(120295);
    if ((paramn instanceof i))
    {
      paramInt2 = ((i)paramn).dbL;
      paramString = com.tencent.mm.plugin.story.i.a.zBQ;
      if ((paramInt2 == com.tencent.mm.plugin.story.i.a.dYL()) && (bs.lr(((i)paramn).userName, this.lhM)) && (paramInt1 == 0)) {
        dUB();
      }
    }
    AppMethodBeat.o(120295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryPreference
 * JD-Core Version:    0.7.0.1
 */