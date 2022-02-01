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
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.b.a.lx;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.story.a.b;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.f;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.story.api.AbsStoryPreference;
import com.tencent.mm.plugin.story.api.p.b;
import com.tencent.mm.plugin.story.e.a.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.plugin.story.ui.StoryBrowseUI;
import com.tencent.mm.protocal.protobuf.enl;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.protocal.protobuf.eol;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/StoryPreference;", "Lcom/tencent/mm/plugin/story/api/AbsStoryPreference;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isAddedSceneListener", "", "mCallback", "Lcom/tencent/mm/plugin/story/api/ILoadFavStoryCallback;", "mCoverView", "Landroid/view/View;", "mStoryFavList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "mStoryIconView1", "Landroid/widget/ImageView;", "mStoryIconView2", "mStoryIconView3", "mStoryView1", "Lcom/tencent/mm/plugin/story/ui/view/StoryRoundImageView;", "mStoryView2", "mStoryView3", "mStoryViewGroup1", "Landroid/view/ViewGroup;", "mStoryViewGroup2", "mStoryViewGroup3", "mTitleView", "Landroid/widget/TextView;", "mUsername", "", "mView", "getDateList", "", "goFavGallery", "", "position", "handleEvent", "loadStory", "onBindView", "view", "onCreate", "username", "onCreateView", "parent", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setLoadCallback", "callback", "updateFavStory", "plugin-story_release"})
public final class StoryPreference
  extends AbsStoryPreference
  implements com.tencent.mm.an.i
{
  private View EQs;
  private StoryRoundImageView LXX;
  private StoryRoundImageView LXY;
  private StoryRoundImageView LXZ;
  private ImageView LYa;
  private ImageView LYb;
  private ImageView LYc;
  private ViewGroup LYd;
  private ViewGroup LYe;
  private ViewGroup LYf;
  private ArrayList<com.tencent.mm.plugin.story.i.j> LYg;
  private com.tencent.mm.plugin.story.api.d LYh;
  private boolean LYi;
  private TextView eM;
  private View mView;
  private String pRV;
  
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
    paramContext = View.inflate(getContext(), a.e.LDk, null);
    kotlin.g.b.p.j(paramContext, "View.inflate(context, R.…e_fav_panel_layout, null)");
    this.mView = paramContext;
    this.LYg = new ArrayList();
    this.pRV = "";
    paramContext = this.mView.findViewById(16908310);
    kotlin.g.b.p.j(paramContext, "mView.findViewById(android.R.id.title)");
    this.eM = ((TextView)paramContext);
    paramContext = this.mView.findViewById(a.d.LzJ);
    kotlin.g.b.p.j(paramContext, "mView.findViewById(R.id.…eference_story_image_iv1)");
    this.LXX = ((StoryRoundImageView)paramContext);
    paramContext = this.mView.findViewById(a.d.LzL);
    kotlin.g.b.p.j(paramContext, "mView.findViewById(R.id.…eference_story_image_iv2)");
    this.LXY = ((StoryRoundImageView)paramContext);
    paramContext = this.mView.findViewById(a.d.LzN);
    kotlin.g.b.p.j(paramContext, "mView.findViewById(R.id.…eference_story_image_iv3)");
    this.LXZ = ((StoryRoundImageView)paramContext);
    paramContext = this.mView.findViewById(a.d.LzG);
    kotlin.g.b.p.j(paramContext, "mView.findViewById(R.id.…erence_story_image_icon1)");
    this.LYa = ((ImageView)paramContext);
    paramContext = this.mView.findViewById(a.d.LzH);
    kotlin.g.b.p.j(paramContext, "mView.findViewById(R.id.…erence_story_image_icon2)");
    this.LYb = ((ImageView)paramContext);
    paramContext = this.mView.findViewById(a.d.LzI);
    kotlin.g.b.p.j(paramContext, "mView.findViewById(R.id.…erence_story_image_icon3)");
    this.LYc = ((ImageView)paramContext);
    paramContext = this.mView.findViewById(a.d.LzK);
    kotlin.g.b.p.j(paramContext, "mView.findViewById(R.id.…ce_story_image_iv1_group)");
    this.LYd = ((ViewGroup)paramContext);
    paramContext = this.mView.findViewById(a.d.LzM);
    kotlin.g.b.p.j(paramContext, "mView.findViewById(R.id.…ce_story_image_iv2_group)");
    this.LYe = ((ViewGroup)paramContext);
    paramContext = this.mView.findViewById(a.d.LzO);
    kotlin.g.b.p.j(paramContext, "mView.findViewById(R.id.…ce_story_image_iv3_group)");
    this.LYf = ((ViewGroup)paramContext);
    paramInt = com.tencent.mm.ci.a.fromDPToPix(getContext(), 8);
    this.LXX.setRound(paramInt);
    this.LXY.setRound(paramInt);
    this.LXZ.setRound(paramInt);
    paramContext = au.o(getContext(), a.f.icons_filled_play2, -1);
    this.LYa.setImageDrawable(paramContext);
    this.LYb.setImageDrawable(paramContext);
    this.LYc.setImageDrawable(paramContext);
    this.LXX.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120286);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/StoryPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        StoryPreference.a(this.LYj, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120286);
      }
    });
    this.LXY.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120287);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/StoryPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        StoryPreference.a(this.LYj, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120287);
      }
    });
    this.LXZ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120288);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/StoryPreference$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        StoryPreference.a(this.LYj, 2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryPreference$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120288);
      }
    });
    AppMethodBeat.o(120299);
  }
  
  private final void aiA(int paramInt)
  {
    AppMethodBeat.i(120289);
    Object localObject1 = new ArrayList();
    Object localObject2 = ((Iterable)this.LYg).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject2).next();
      localObject4 = com.tencent.mm.plugin.story.e.a.LFy;
      ((ArrayList)localObject1).add(a.a.v(Integer.valueOf(((com.tencent.mm.plugin.story.i.j)localObject3).field_createTime)));
    }
    localObject1 = (List)localObject1;
    localObject2 = com.tencent.mm.plugin.story.api.p.LEL;
    Object localObject3 = this.pRV;
    Object localObject4 = com.tencent.mm.plugin.story.g.d.LLJ;
    long l = ((p.b)localObject2).a((List)localObject1, (String)localObject3, com.tencent.mm.plugin.story.g.d.gdV());
    localObject2 = new Intent(getContext(), StoryBrowseUI.class);
    ((Intent)localObject2).putExtra("username", this.pRV);
    ((Intent)localObject2).putExtra("data_seed_key", l);
    ((Intent)localObject2).putExtra("v_position", paramInt);
    ((Intent)localObject2).putExtra("gallery_story_need_action", true);
    localObject1 = getContext();
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/story/ui/view/StoryPreference", "goFavGallery", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/story/ui/view/StoryPreference", "goFavGallery", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localObject1 = com.tencent.mm.plugin.story.h.h.LOJ;
    com.tencent.mm.plugin.story.h.h.geE().wn(14L);
    AppMethodBeat.o(120289);
  }
  
  public final void a(com.tencent.mm.plugin.story.api.d paramd)
  {
    this.LYh = paramd;
  }
  
  public final void gbq()
  {
    AppMethodBeat.i(120291);
    Object localObject1 = n.LGO;
    localObject1 = this.pRV;
    kotlin.g.b.p.k(localObject1, "username");
    Object localObject2 = com.tencent.mm.kernel.h.aHF();
    kotlin.g.b.p.j(localObject2, "MMKernel.network()");
    localObject2 = ((c)localObject2).aGY();
    Object localObject3 = com.tencent.mm.plugin.story.f.j.LGA;
    boolean bool = Util.isEqual((String)localObject1, j.b.fOo());
    localObject3 = com.tencent.mm.plugin.story.i.a.LPG;
    ((t)localObject2).b((q)new com.tencent.mm.plugin.story.f.a.i((String)localObject1, 0L, bool, "", com.tencent.mm.plugin.story.i.a.gfF()));
    AppMethodBeat.o(120291);
  }
  
  public final void gbr()
  {
    int j = 1;
    int k = 1;
    AppMethodBeat.i(120292);
    Object localObject1 = this.eM.getLayoutParams();
    if (localObject1 != null) {
      ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.ci.a.aY(getContext(), a.b.FixedTitleWidth);
    }
    this.eM.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.LYg.clear();
    localObject1 = this.LYg;
    Object localObject2 = com.tencent.mm.plugin.story.f.j.LGA;
    localObject2 = j.b.gcw();
    Object localObject3 = this.pRV;
    Object localObject4 = this.pRV;
    j.b localb = com.tencent.mm.plugin.story.f.j.LGA;
    ((ArrayList)localObject1).addAll((Collection)((k)localObject2).a((String)localObject3, Util.isEqual((String)localObject4, j.b.fOo()), 0L, 20));
    this.LYd.setVisibility(8);
    this.LYe.setVisibility(8);
    this.LYf.setVisibility(8);
    int i;
    if (!((Collection)this.LYg).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label444;
      }
      localObject1 = this.eM;
      localObject2 = getContext();
      kotlin.g.b.p.j(localObject2, "context");
      ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(a.g.contact_info_story_title));
      label201:
      if (this.LYg.size() != 1) {
        break label464;
      }
      this.eM.setVisibility(0);
      this.LYd.setVisibility(0);
      localObject2 = ((com.tencent.mm.plugin.story.i.j)this.LYg.get(0)).ggc().Ura;
      if (localObject2 != null)
      {
        localObject1 = ((enl)localObject2).Sqr;
        kotlin.g.b.p.j(localObject1, "obj.MediaObjList");
        if (((Collection)localObject1).isEmpty()) {
          break label459;
        }
        i = k;
        label282:
        if (i != 0)
        {
          localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
          localObject1 = j.b.gcE();
          localObject2 = ((enl)localObject2).Sqr.get(0);
          kotlin.g.b.p.j(localObject2, "obj.MediaObjList[0]");
          localObject2 = (enu)localObject2;
          localObject3 = ((com.tencent.mm.plugin.story.i.j)this.LYg.get(0)).field_userName;
          localObject4 = bp.VGt;
          kotlin.g.b.p.j(localObject4, "FROM_SCENE.storyalbum");
          localObject2 = new com.tencent.mm.plugin.story.f.c.d((enu)localObject2, (String)localObject3, (bp)localObject4);
          localObject3 = this.LXX;
          if (localObject3 == null) {
            kotlin.g.b.p.iCn();
          }
          localObject3 = (ImageView)localObject3;
          localObject4 = com.tencent.mm.plugin.story.f.j.LGA;
          ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.LIz));
        }
      }
    }
    label444:
    label967:
    for (;;)
    {
      localObject1 = this.LYh;
      if (localObject1 == null) {
        break label1468;
      }
      ((com.tencent.mm.plugin.story.api.d)localObject1).gt((List)this.LYg);
      AppMethodBeat.o(120292);
      return;
      i = 0;
      break;
      this.eM.setText((CharSequence)"");
      break label201;
      label459:
      i = 0;
      break label282;
      label464:
      if (this.LYg.size() == 2)
      {
        this.eM.setVisibility(0);
        this.LYd.setVisibility(0);
        this.LYe.setVisibility(0);
        localObject2 = ((com.tencent.mm.plugin.story.i.j)this.LYg.get(0)).ggc().Ura;
        if (localObject2 != null)
        {
          localObject1 = ((enl)localObject2).Sqr;
          kotlin.g.b.p.j(localObject1, "obj1.MediaObjList");
          if (((Collection)localObject1).isEmpty()) {
            break label860;
          }
          i = 1;
          if (i != 0)
          {
            localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
            localObject1 = j.b.gcE();
            localObject2 = ((enl)localObject2).Sqr.get(0);
            kotlin.g.b.p.j(localObject2, "obj1.MediaObjList[0]");
            localObject2 = (enu)localObject2;
            localObject3 = ((com.tencent.mm.plugin.story.i.j)this.LYg.get(0)).field_userName;
            localObject4 = bp.VGt;
            kotlin.g.b.p.j(localObject4, "FROM_SCENE.storyalbum");
            localObject2 = new com.tencent.mm.plugin.story.f.c.d((enu)localObject2, (String)localObject3, (bp)localObject4);
            localObject3 = this.LXX;
            if (localObject3 == null) {
              kotlin.g.b.p.iCn();
            }
            localObject3 = (ImageView)localObject3;
            localObject4 = com.tencent.mm.plugin.story.f.j.LGA;
            ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.LIz));
          }
        }
        localObject2 = ((com.tencent.mm.plugin.story.i.j)this.LYg.get(1)).ggc().Ura;
        if (localObject2 != null)
        {
          localObject1 = ((enl)localObject2).Sqr;
          kotlin.g.b.p.j(localObject1, "obj2.MediaObjList");
          if (!((Collection)localObject1).isEmpty()) {}
          for (i = j;; i = 0)
          {
            if (i == 0) {
              break label868;
            }
            localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
            localObject1 = j.b.gcE();
            localObject2 = ((enl)localObject2).Sqr.get(0);
            kotlin.g.b.p.j(localObject2, "obj2.MediaObjList[0]");
            localObject2 = (enu)localObject2;
            localObject3 = ((com.tencent.mm.plugin.story.i.j)this.LYg.get(0)).field_userName;
            localObject4 = bp.VGt;
            kotlin.g.b.p.j(localObject4, "FROM_SCENE.storyalbum");
            localObject2 = new com.tencent.mm.plugin.story.f.c.d((enu)localObject2, (String)localObject3, (bp)localObject4);
            localObject3 = this.LXY;
            if (localObject3 == null) {
              kotlin.g.b.p.iCn();
            }
            localObject3 = (ImageView)localObject3;
            localObject4 = com.tencent.mm.plugin.story.f.j.LGA;
            ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.LIz));
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
        if (this.LYg.size() >= 3)
        {
          this.eM.setVisibility(0);
          this.LYd.setVisibility(0);
          this.LYe.setVisibility(0);
          this.LYf.setVisibility(0);
          localObject2 = ((com.tencent.mm.plugin.story.i.j)this.LYg.get(0)).ggc().Ura;
          if (localObject2 != null)
          {
            localObject1 = ((enl)localObject2).Sqr;
            kotlin.g.b.p.j(localObject1, "obj1.MediaObjList");
            if (((Collection)localObject1).isEmpty()) {
              break label1453;
            }
            i = 1;
            if (i != 0)
            {
              localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
              localObject1 = j.b.gcE();
              localObject2 = ((enl)localObject2).Sqr.get(0);
              kotlin.g.b.p.j(localObject2, "obj1.MediaObjList[0]");
              localObject2 = (enu)localObject2;
              localObject3 = ((com.tencent.mm.plugin.story.i.j)this.LYg.get(0)).field_userName;
              localObject4 = bp.VGt;
              kotlin.g.b.p.j(localObject4, "FROM_SCENE.storyalbum");
              localObject2 = new com.tencent.mm.plugin.story.f.c.d((enu)localObject2, (String)localObject3, (bp)localObject4);
              localObject3 = this.LXX;
              if (localObject3 == null) {
                kotlin.g.b.p.iCn();
              }
              localObject3 = (ImageView)localObject3;
              localObject4 = com.tencent.mm.plugin.story.f.j.LGA;
              ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.LIz));
            }
          }
          localObject2 = ((com.tencent.mm.plugin.story.i.j)this.LYg.get(1)).ggc().Ura;
          if (localObject2 != null)
          {
            localObject1 = ((enl)localObject2).Sqr;
            kotlin.g.b.p.j(localObject1, "obj2.MediaObjList");
            if (((Collection)localObject1).isEmpty()) {
              break label1458;
            }
            i = 1;
            label1146:
            if (i != 0)
            {
              localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
              localObject1 = j.b.gcE();
              localObject2 = ((enl)localObject2).Sqr.get(0);
              kotlin.g.b.p.j(localObject2, "obj2.MediaObjList[0]");
              localObject2 = (enu)localObject2;
              localObject3 = ((com.tencent.mm.plugin.story.i.j)this.LYg.get(0)).field_userName;
              localObject4 = bp.VGt;
              kotlin.g.b.p.j(localObject4, "FROM_SCENE.storyalbum");
              localObject2 = new com.tencent.mm.plugin.story.f.c.d((enu)localObject2, (String)localObject3, (bp)localObject4);
              localObject3 = this.LXY;
              if (localObject3 == null) {
                kotlin.g.b.p.iCn();
              }
              localObject3 = (ImageView)localObject3;
              localObject4 = com.tencent.mm.plugin.story.f.j.LGA;
              ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.LIz));
            }
          }
          localObject2 = ((com.tencent.mm.plugin.story.i.j)this.LYg.get(2)).ggc().Ura;
          if (localObject2 != null)
          {
            localObject1 = ((enl)localObject2).Sqr;
            kotlin.g.b.p.j(localObject1, "obj3.MediaObjList");
            if (!((Collection)localObject1).isEmpty()) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label1466;
              }
              localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
              localObject1 = j.b.gcE();
              localObject2 = ((enl)localObject2).Sqr.get(0);
              kotlin.g.b.p.j(localObject2, "obj3.MediaObjList[0]");
              localObject2 = (enu)localObject2;
              localObject3 = ((com.tencent.mm.plugin.story.i.j)this.LYg.get(0)).field_userName;
              localObject4 = bp.VGt;
              kotlin.g.b.p.j(localObject4, "FROM_SCENE.storyalbum");
              localObject2 = new com.tencent.mm.plugin.story.f.c.d((enu)localObject2, (String)localObject3, (bp)localObject4);
              localObject3 = this.LXZ;
              if (localObject3 == null) {
                kotlin.g.b.p.iCn();
              }
              localObject3 = (ImageView)localObject3;
              localObject4 = com.tencent.mm.plugin.story.f.j.LGA;
              ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.LIz));
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
  
  public final void gbs()
  {
    AppMethodBeat.i(120293);
    if (!((Collection)this.LYg).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        aiA(0);
      }
      AppMethodBeat.o(120293);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(120297);
    kotlin.g.b.p.k(paramView, "view");
    super.onBindView(paramView);
    gbr();
    AppMethodBeat.o(120297);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(120290);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.pRV = str;
    if (!this.LYi)
    {
      paramString = com.tencent.mm.kernel.h.aHF();
      kotlin.g.b.p.j(paramString, "MMKernel.network()");
      paramString.aGY().a(273, (com.tencent.mm.an.i)this);
      this.LYi = true;
    }
    AppMethodBeat.o(120290);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120296);
    kotlin.g.b.p.k(paramViewGroup, "parent");
    if (this.EQs == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.d.content);
      localViewGroup.removeAllViews();
      this.mView.setId(a.d.title_ll);
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
      localViewGroup.addView(this.mView, localLayoutParams);
      this.EQs = paramViewGroup;
    }
    paramViewGroup = this.EQs;
    if (paramViewGroup == null) {
      kotlin.g.b.p.iCn();
    }
    AppMethodBeat.o(120296);
    return paramViewGroup;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(120294);
    this.LYh = null;
    c localc = com.tencent.mm.kernel.h.aHF();
    kotlin.g.b.p.j(localc, "MMKernel.network()");
    localc.aGY().b(273, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(120294);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(120295);
    if ((paramq instanceof com.tencent.mm.plugin.story.f.a.i))
    {
      paramInt2 = ((com.tencent.mm.plugin.story.f.a.i)paramq).source;
      paramString = com.tencent.mm.plugin.story.i.a.LPG;
      if ((paramInt2 == com.tencent.mm.plugin.story.i.a.gfF()) && (Util.isEqual(((com.tencent.mm.plugin.story.f.a.i)paramq).userName, this.pRV)) && (paramInt1 == 0)) {
        gbr();
      }
    }
    AppMethodBeat.o(120295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryPreference
 * JD-Core Version:    0.7.0.1
 */