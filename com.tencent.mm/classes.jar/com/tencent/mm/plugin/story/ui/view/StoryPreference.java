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
import com.tencent.mm.ak.t;
import com.tencent.mm.g.b.a.jo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.AbsStoryPreference;
import com.tencent.mm.plugin.story.api.p.b;
import com.tencent.mm.plugin.story.e.a.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.plugin.story.ui.StoryBrowseUI;
import com.tencent.mm.protocal.protobuf.edk;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/StoryPreference;", "Lcom/tencent/mm/plugin/story/api/AbsStoryPreference;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isAddedSceneListener", "", "mCallback", "Lcom/tencent/mm/plugin/story/api/ILoadFavStoryCallback;", "mCoverView", "Landroid/view/View;", "mStoryFavList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "mStoryIconView1", "Landroid/widget/ImageView;", "mStoryIconView2", "mStoryIconView3", "mStoryView1", "Lcom/tencent/mm/plugin/story/ui/view/StoryRoundImageView;", "mStoryView2", "mStoryView3", "mStoryViewGroup1", "Landroid/view/ViewGroup;", "mStoryViewGroup2", "mStoryViewGroup3", "mTitleView", "Landroid/widget/TextView;", "mUsername", "", "mView", "getDateList", "", "goFavGallery", "", "position", "handleEvent", "loadStory", "onBindView", "view", "onCreate", "username", "onCreateView", "parent", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setLoadCallback", "callback", "updateFavStory", "plugin-story_release"})
public final class StoryPreference
  extends AbsStoryPreference
  implements com.tencent.mm.ak.i
{
  private StoryRoundImageView FDV;
  private StoryRoundImageView FDW;
  private StoryRoundImageView FDX;
  private ImageView FDY;
  private ImageView FDZ;
  private ImageView FEa;
  private ViewGroup FEb;
  private ViewGroup FEc;
  private ViewGroup FEd;
  private ArrayList<com.tencent.mm.plugin.story.i.j> FEe;
  private com.tencent.mm.plugin.story.api.d FEf;
  private boolean FEg;
  private TextView Xy;
  private String mRa;
  private View mView;
  private View zlc;
  
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
    paramContext = View.inflate(getContext(), 2131496619, null);
    kotlin.g.b.p.g(paramContext, "View.inflate(context, R.…e_fav_panel_layout, null)");
    this.mView = paramContext;
    this.FEe = new ArrayList();
    this.mRa = "";
    paramContext = this.mView.findViewById(16908310);
    kotlin.g.b.p.g(paramContext, "mView.findViewById(android.R.id.title)");
    this.Xy = ((TextView)paramContext);
    paramContext = this.mView.findViewById(2131304725);
    kotlin.g.b.p.g(paramContext, "mView.findViewById(R.id.…eference_story_image_iv1)");
    this.FDV = ((StoryRoundImageView)paramContext);
    paramContext = this.mView.findViewById(2131304727);
    kotlin.g.b.p.g(paramContext, "mView.findViewById(R.id.…eference_story_image_iv2)");
    this.FDW = ((StoryRoundImageView)paramContext);
    paramContext = this.mView.findViewById(2131304729);
    kotlin.g.b.p.g(paramContext, "mView.findViewById(R.id.…eference_story_image_iv3)");
    this.FDX = ((StoryRoundImageView)paramContext);
    paramContext = this.mView.findViewById(2131304722);
    kotlin.g.b.p.g(paramContext, "mView.findViewById(R.id.…erence_story_image_icon1)");
    this.FDY = ((ImageView)paramContext);
    paramContext = this.mView.findViewById(2131304723);
    kotlin.g.b.p.g(paramContext, "mView.findViewById(R.id.…erence_story_image_icon2)");
    this.FDZ = ((ImageView)paramContext);
    paramContext = this.mView.findViewById(2131304724);
    kotlin.g.b.p.g(paramContext, "mView.findViewById(R.id.…erence_story_image_icon3)");
    this.FEa = ((ImageView)paramContext);
    paramContext = this.mView.findViewById(2131304726);
    kotlin.g.b.p.g(paramContext, "mView.findViewById(R.id.…ce_story_image_iv1_group)");
    this.FEb = ((ViewGroup)paramContext);
    paramContext = this.mView.findViewById(2131304728);
    kotlin.g.b.p.g(paramContext, "mView.findViewById(R.id.…ce_story_image_iv2_group)");
    this.FEc = ((ViewGroup)paramContext);
    paramContext = this.mView.findViewById(2131304730);
    kotlin.g.b.p.g(paramContext, "mView.findViewById(R.id.…ce_story_image_iv3_group)");
    this.FEd = ((ViewGroup)paramContext);
    paramInt = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
    this.FDV.setRound(paramInt);
    this.FDW.setRound(paramInt);
    this.FDX.setRound(paramInt);
    paramContext = ar.m(getContext(), 2131690648, -1);
    this.FDY.setImageDrawable(paramContext);
    this.FDZ.setImageDrawable(paramContext);
    this.FEa.setImageDrawable(paramContext);
    this.FDV.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120286);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        StoryPreference.a(this.FEh, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120286);
      }
    });
    this.FDW.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120287);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        StoryPreference.a(this.FEh, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120287);
      }
    });
    this.FDX.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120288);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryPreference$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        StoryPreference.a(this.FEh, 2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryPreference$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120288);
      }
    });
    AppMethodBeat.o(120299);
  }
  
  private final void abf(int paramInt)
  {
    AppMethodBeat.i(120289);
    Object localObject1 = new ArrayList();
    Object localObject2 = ((Iterable)this.FEe).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject2).next();
      localObject4 = com.tencent.mm.plugin.story.e.a.Flw;
      ((ArrayList)localObject1).add(a.a.n(Integer.valueOf(((com.tencent.mm.plugin.story.i.j)localObject3).field_createTime)));
    }
    localObject1 = (List)localObject1;
    localObject2 = com.tencent.mm.plugin.story.api.p.FkJ;
    Object localObject3 = this.mRa;
    Object localObject4 = com.tencent.mm.plugin.story.g.d.FrG;
    long l = ((p.b)localObject2).a((List)localObject1, (String)localObject3, com.tencent.mm.plugin.story.g.d.fpB());
    localObject2 = new Intent(getContext(), StoryBrowseUI.class);
    ((Intent)localObject2).putExtra("username", this.mRa);
    ((Intent)localObject2).putExtra("data_seed_key", l);
    ((Intent)localObject2).putExtra("v_position", paramInt);
    ((Intent)localObject2).putExtra("gallery_story_need_action", true);
    localObject1 = getContext();
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/story/ui/view/StoryPreference", "goFavGallery", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/story/ui/view/StoryPreference", "goFavGallery", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localObject1 = h.FuH;
    h.fqi().sl(14L);
    AppMethodBeat.o(120289);
  }
  
  public final void a(com.tencent.mm.plugin.story.api.d paramd)
  {
    this.FEf = paramd;
  }
  
  public final void fmX()
  {
    AppMethodBeat.i(120291);
    Object localObject1 = n.FmM;
    localObject1 = this.mRa;
    kotlin.g.b.p.h(localObject1, "username");
    Object localObject2 = g.aAg();
    kotlin.g.b.p.g(localObject2, "MMKernel.network()");
    localObject2 = ((com.tencent.mm.kernel.b)localObject2).azz();
    Object localObject3 = com.tencent.mm.plugin.story.f.j.Fmy;
    boolean bool = Util.isEqual((String)localObject1, j.b.fau());
    localObject3 = com.tencent.mm.plugin.story.i.a.FvD;
    ((t)localObject2).b((q)new com.tencent.mm.plugin.story.f.a.i((String)localObject1, 0L, bool, "", com.tencent.mm.plugin.story.i.a.frj()));
    AppMethodBeat.o(120291);
  }
  
  public final void fmY()
  {
    int j = 1;
    int k = 1;
    AppMethodBeat.i(120292);
    Object localObject1 = this.Xy.getLayoutParams();
    if (localObject1 != null) {
      ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cb.a.aG(getContext(), 2131165381);
    }
    this.Xy.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.FEe.clear();
    localObject1 = this.FEe;
    Object localObject2 = com.tencent.mm.plugin.story.f.j.Fmy;
    localObject2 = j.b.foc();
    Object localObject3 = this.mRa;
    Object localObject4 = this.mRa;
    j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
    ((ArrayList)localObject1).addAll((Collection)((k)localObject2).a((String)localObject3, Util.isEqual((String)localObject4, j.b.fau()), 0L, 20));
    this.FEb.setVisibility(8);
    this.FEc.setVisibility(8);
    this.FEd.setVisibility(8);
    int i;
    if (!((Collection)this.FEe).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label444;
      }
      localObject1 = this.Xy;
      localObject2 = getContext();
      kotlin.g.b.p.g(localObject2, "context");
      ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(2131758118));
      label201:
      if (this.FEe.size() != 1) {
        break label464;
      }
      this.Xy.setVisibility(0);
      this.FEb.setVisibility(0);
      localObject2 = ((com.tencent.mm.plugin.story.i.j)this.FEe.get(0)).frG().NeB;
      if (localObject2 != null)
      {
        localObject1 = ((edk)localObject2).LoV;
        kotlin.g.b.p.g(localObject1, "obj.MediaObjList");
        if (((Collection)localObject1).isEmpty()) {
          break label459;
        }
        i = k;
        label282:
        if (i != 0)
        {
          localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
          localObject1 = j.b.fok();
          localObject2 = ((edk)localObject2).LoV.get(0);
          kotlin.g.b.p.g(localObject2, "obj.MediaObjList[0]");
          localObject2 = (edt)localObject2;
          localObject3 = ((com.tencent.mm.plugin.story.i.j)this.FEe.get(0)).field_userName;
          localObject4 = bp.Oqx;
          kotlin.g.b.p.g(localObject4, "FROM_SCENE.storyalbum");
          localObject2 = new com.tencent.mm.plugin.story.f.c.d((edt)localObject2, (String)localObject3, (bp)localObject4);
          localObject3 = this.FDV;
          if (localObject3 == null) {
            kotlin.g.b.p.hyc();
          }
          localObject3 = (ImageView)localObject3;
          localObject4 = com.tencent.mm.plugin.story.f.j.Fmy;
          ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.Fox));
        }
      }
    }
    label444:
    label967:
    for (;;)
    {
      localObject1 = this.FEf;
      if (localObject1 == null) {
        break label1468;
      }
      ((com.tencent.mm.plugin.story.api.d)localObject1).fP((List)this.FEe);
      AppMethodBeat.o(120292);
      return;
      i = 0;
      break;
      this.Xy.setText((CharSequence)"");
      break label201;
      label459:
      i = 0;
      break label282;
      label464:
      if (this.FEe.size() == 2)
      {
        this.Xy.setVisibility(0);
        this.FEb.setVisibility(0);
        this.FEc.setVisibility(0);
        localObject2 = ((com.tencent.mm.plugin.story.i.j)this.FEe.get(0)).frG().NeB;
        if (localObject2 != null)
        {
          localObject1 = ((edk)localObject2).LoV;
          kotlin.g.b.p.g(localObject1, "obj1.MediaObjList");
          if (((Collection)localObject1).isEmpty()) {
            break label860;
          }
          i = 1;
          if (i != 0)
          {
            localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
            localObject1 = j.b.fok();
            localObject2 = ((edk)localObject2).LoV.get(0);
            kotlin.g.b.p.g(localObject2, "obj1.MediaObjList[0]");
            localObject2 = (edt)localObject2;
            localObject3 = ((com.tencent.mm.plugin.story.i.j)this.FEe.get(0)).field_userName;
            localObject4 = bp.Oqx;
            kotlin.g.b.p.g(localObject4, "FROM_SCENE.storyalbum");
            localObject2 = new com.tencent.mm.plugin.story.f.c.d((edt)localObject2, (String)localObject3, (bp)localObject4);
            localObject3 = this.FDV;
            if (localObject3 == null) {
              kotlin.g.b.p.hyc();
            }
            localObject3 = (ImageView)localObject3;
            localObject4 = com.tencent.mm.plugin.story.f.j.Fmy;
            ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.Fox));
          }
        }
        localObject2 = ((com.tencent.mm.plugin.story.i.j)this.FEe.get(1)).frG().NeB;
        if (localObject2 != null)
        {
          localObject1 = ((edk)localObject2).LoV;
          kotlin.g.b.p.g(localObject1, "obj2.MediaObjList");
          if (!((Collection)localObject1).isEmpty()) {}
          for (i = j;; i = 0)
          {
            if (i == 0) {
              break label868;
            }
            localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
            localObject1 = j.b.fok();
            localObject2 = ((edk)localObject2).LoV.get(0);
            kotlin.g.b.p.g(localObject2, "obj2.MediaObjList[0]");
            localObject2 = (edt)localObject2;
            localObject3 = ((com.tencent.mm.plugin.story.i.j)this.FEe.get(0)).field_userName;
            localObject4 = bp.Oqx;
            kotlin.g.b.p.g(localObject4, "FROM_SCENE.storyalbum");
            localObject2 = new com.tencent.mm.plugin.story.f.c.d((edt)localObject2, (String)localObject3, (bp)localObject4);
            localObject3 = this.FDW;
            if (localObject3 == null) {
              kotlin.g.b.p.hyc();
            }
            localObject3 = (ImageView)localObject3;
            localObject4 = com.tencent.mm.plugin.story.f.j.Fmy;
            ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.Fox));
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
        if (this.FEe.size() >= 3)
        {
          this.Xy.setVisibility(0);
          this.FEb.setVisibility(0);
          this.FEc.setVisibility(0);
          this.FEd.setVisibility(0);
          localObject2 = ((com.tencent.mm.plugin.story.i.j)this.FEe.get(0)).frG().NeB;
          if (localObject2 != null)
          {
            localObject1 = ((edk)localObject2).LoV;
            kotlin.g.b.p.g(localObject1, "obj1.MediaObjList");
            if (((Collection)localObject1).isEmpty()) {
              break label1453;
            }
            i = 1;
            if (i != 0)
            {
              localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
              localObject1 = j.b.fok();
              localObject2 = ((edk)localObject2).LoV.get(0);
              kotlin.g.b.p.g(localObject2, "obj1.MediaObjList[0]");
              localObject2 = (edt)localObject2;
              localObject3 = ((com.tencent.mm.plugin.story.i.j)this.FEe.get(0)).field_userName;
              localObject4 = bp.Oqx;
              kotlin.g.b.p.g(localObject4, "FROM_SCENE.storyalbum");
              localObject2 = new com.tencent.mm.plugin.story.f.c.d((edt)localObject2, (String)localObject3, (bp)localObject4);
              localObject3 = this.FDV;
              if (localObject3 == null) {
                kotlin.g.b.p.hyc();
              }
              localObject3 = (ImageView)localObject3;
              localObject4 = com.tencent.mm.plugin.story.f.j.Fmy;
              ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.Fox));
            }
          }
          localObject2 = ((com.tencent.mm.plugin.story.i.j)this.FEe.get(1)).frG().NeB;
          if (localObject2 != null)
          {
            localObject1 = ((edk)localObject2).LoV;
            kotlin.g.b.p.g(localObject1, "obj2.MediaObjList");
            if (((Collection)localObject1).isEmpty()) {
              break label1458;
            }
            i = 1;
            label1146:
            if (i != 0)
            {
              localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
              localObject1 = j.b.fok();
              localObject2 = ((edk)localObject2).LoV.get(0);
              kotlin.g.b.p.g(localObject2, "obj2.MediaObjList[0]");
              localObject2 = (edt)localObject2;
              localObject3 = ((com.tencent.mm.plugin.story.i.j)this.FEe.get(0)).field_userName;
              localObject4 = bp.Oqx;
              kotlin.g.b.p.g(localObject4, "FROM_SCENE.storyalbum");
              localObject2 = new com.tencent.mm.plugin.story.f.c.d((edt)localObject2, (String)localObject3, (bp)localObject4);
              localObject3 = this.FDW;
              if (localObject3 == null) {
                kotlin.g.b.p.hyc();
              }
              localObject3 = (ImageView)localObject3;
              localObject4 = com.tencent.mm.plugin.story.f.j.Fmy;
              ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.Fox));
            }
          }
          localObject2 = ((com.tencent.mm.plugin.story.i.j)this.FEe.get(2)).frG().NeB;
          if (localObject2 != null)
          {
            localObject1 = ((edk)localObject2).LoV;
            kotlin.g.b.p.g(localObject1, "obj3.MediaObjList");
            if (!((Collection)localObject1).isEmpty()) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label1466;
              }
              localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
              localObject1 = j.b.fok();
              localObject2 = ((edk)localObject2).LoV.get(0);
              kotlin.g.b.p.g(localObject2, "obj3.MediaObjList[0]");
              localObject2 = (edt)localObject2;
              localObject3 = ((com.tencent.mm.plugin.story.i.j)this.FEe.get(0)).field_userName;
              localObject4 = bp.Oqx;
              kotlin.g.b.p.g(localObject4, "FROM_SCENE.storyalbum");
              localObject2 = new com.tencent.mm.plugin.story.f.c.d((edt)localObject2, (String)localObject3, (bp)localObject4);
              localObject3 = this.FDX;
              if (localObject3 == null) {
                kotlin.g.b.p.hyc();
              }
              localObject3 = (ImageView)localObject3;
              localObject4 = com.tencent.mm.plugin.story.f.j.Fmy;
              ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.Fox));
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
  
  public final void fmZ()
  {
    AppMethodBeat.i(120293);
    if (!((Collection)this.FEe).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        abf(0);
      }
      AppMethodBeat.o(120293);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(120297);
    kotlin.g.b.p.h(paramView, "view");
    super.onBindView(paramView);
    fmY();
    AppMethodBeat.o(120297);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(120290);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.mRa = str;
    if (!this.FEg)
    {
      paramString = g.aAg();
      kotlin.g.b.p.g(paramString, "MMKernel.network()");
      paramString.azz().a(273, (com.tencent.mm.ak.i)this);
      this.FEg = true;
    }
    AppMethodBeat.o(120290);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120296);
    kotlin.g.b.p.h(paramViewGroup, "parent");
    if (this.zlc == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
      localViewGroup.removeAllViews();
      this.mView.setId(2131309235);
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
      localViewGroup.addView(this.mView, localLayoutParams);
      this.zlc = paramViewGroup;
    }
    paramViewGroup = this.zlc;
    if (paramViewGroup == null) {
      kotlin.g.b.p.hyc();
    }
    AppMethodBeat.o(120296);
    return paramViewGroup;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(120294);
    this.FEf = null;
    com.tencent.mm.kernel.b localb = g.aAg();
    kotlin.g.b.p.g(localb, "MMKernel.network()");
    localb.azz().b(273, (com.tencent.mm.ak.i)this);
    AppMethodBeat.o(120294);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(120295);
    if ((paramq instanceof com.tencent.mm.plugin.story.f.a.i))
    {
      paramInt2 = ((com.tencent.mm.plugin.story.f.a.i)paramq).source;
      paramString = com.tencent.mm.plugin.story.i.a.FvD;
      if ((paramInt2 == com.tencent.mm.plugin.story.i.a.frj()) && (Util.isEqual(((com.tencent.mm.plugin.story.f.a.i)paramq).userName, this.mRa)) && (paramInt1 == 0)) {
        fmY();
      }
    }
    AppMethodBeat.o(120295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryPreference
 * JD-Core Version:    0.7.0.1
 */