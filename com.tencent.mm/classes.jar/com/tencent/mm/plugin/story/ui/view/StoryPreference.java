package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.a.i;
import com.tencent.mm.plugin.story.model.m;
import com.tencent.mm.plugin.story.ui.StoryBrowseUI;
import com.tencent.mm.protocal.protobuf.fij;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.protocal.protobuf.fjj;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.bb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/StoryPreference;", "Lcom/tencent/mm/plugin/story/api/AbsStoryPreference;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isAddedSceneListener", "", "mCallback", "Lcom/tencent/mm/plugin/story/api/ILoadFavStoryCallback;", "mCoverView", "Landroid/view/View;", "mStoryFavList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "mStoryIconView1", "Landroid/widget/ImageView;", "mStoryIconView2", "mStoryIconView3", "mStoryView1", "Lcom/tencent/mm/plugin/story/ui/view/StoryRoundImageView;", "mStoryView2", "mStoryView3", "mStoryViewGroup1", "Landroid/view/ViewGroup;", "mStoryViewGroup2", "mStoryViewGroup3", "mTitleView", "Landroid/widget/TextView;", "mUsername", "", "mView", "getDateList", "", "goFavGallery", "", "position", "handleEvent", "loadStory", "onBindView", "view", "onCreate", "username", "onCreateView", "parent", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setLoadCallback", "callback", "updateFavStory", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryPreference
  extends AbsStoryPreference
  implements com.tencent.mm.am.h
{
  private View KKQ;
  private StoryRoundImageView SzC;
  private StoryRoundImageView SzD;
  private StoryRoundImageView SzE;
  private ImageView SzF;
  private ImageView SzG;
  private ImageView SzH;
  private ViewGroup SzI;
  private ViewGroup SzJ;
  private ViewGroup SzK;
  private ArrayList<j> SzL;
  private com.tencent.mm.plugin.story.api.d SzM;
  private boolean SzN;
  private TextView fO;
  private View mView;
  private String sWX;
  
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
    paramContext = View.inflate(this.mContext, a.e.SgV, null);
    kotlin.g.b.s.s(paramContext, "inflate(context, R.layou…e_fav_panel_layout, null)");
    this.mView = paramContext;
    this.SzL = new ArrayList();
    this.sWX = "";
    paramContext = this.mView.findViewById(16908310);
    kotlin.g.b.s.s(paramContext, "mView.findViewById(android.R.id.title)");
    this.fO = ((TextView)paramContext);
    paramContext = this.mView.findViewById(a.d.Sdw);
    kotlin.g.b.s.s(paramContext, "mView.findViewById(R.id.…eference_story_image_iv1)");
    this.SzC = ((StoryRoundImageView)paramContext);
    paramContext = this.mView.findViewById(a.d.Sdy);
    kotlin.g.b.s.s(paramContext, "mView.findViewById(R.id.…eference_story_image_iv2)");
    this.SzD = ((StoryRoundImageView)paramContext);
    paramContext = this.mView.findViewById(a.d.SdA);
    kotlin.g.b.s.s(paramContext, "mView.findViewById(R.id.…eference_story_image_iv3)");
    this.SzE = ((StoryRoundImageView)paramContext);
    paramContext = this.mView.findViewById(a.d.Sdt);
    kotlin.g.b.s.s(paramContext, "mView.findViewById(R.id.…erence_story_image_icon1)");
    this.SzF = ((ImageView)paramContext);
    paramContext = this.mView.findViewById(a.d.Sdu);
    kotlin.g.b.s.s(paramContext, "mView.findViewById(R.id.…erence_story_image_icon2)");
    this.SzG = ((ImageView)paramContext);
    paramContext = this.mView.findViewById(a.d.Sdv);
    kotlin.g.b.s.s(paramContext, "mView.findViewById(R.id.…erence_story_image_icon3)");
    this.SzH = ((ImageView)paramContext);
    paramContext = this.mView.findViewById(a.d.Sdx);
    kotlin.g.b.s.s(paramContext, "mView.findViewById(R.id.…ce_story_image_iv1_group)");
    this.SzI = ((ViewGroup)paramContext);
    paramContext = this.mView.findViewById(a.d.Sdz);
    kotlin.g.b.s.s(paramContext, "mView.findViewById(R.id.…ce_story_image_iv2_group)");
    this.SzJ = ((ViewGroup)paramContext);
    paramContext = this.mView.findViewById(a.d.SdB);
    kotlin.g.b.s.s(paramContext, "mView.findViewById(R.id.…ce_story_image_iv3_group)");
    this.SzK = ((ViewGroup)paramContext);
    paramInt = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 8);
    this.SzC.setRound(paramInt);
    this.SzD.setRound(paramInt);
    this.SzE.setRound(paramInt);
    paramContext = bb.m(this.mContext, a.f.icons_filled_play2, -1);
    this.SzF.setImageDrawable(paramContext);
    this.SzG.setImageDrawable(paramContext);
    this.SzH.setImageDrawable(paramContext);
    this.SzC.setOnClickListener(new StoryPreference..ExternalSyntheticLambda0(this));
    this.SzD.setOnClickListener(new StoryPreference..ExternalSyntheticLambda1(this));
    this.SzE.setOnClickListener(new StoryPreference..ExternalSyntheticLambda2(this));
    AppMethodBeat.o(120299);
  }
  
  private static final void a(StoryPreference paramStoryPreference, View paramView)
  {
    AppMethodBeat.i(367460);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramStoryPreference);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/StoryPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramStoryPreference, "this$0");
    paramStoryPreference.anB(0);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/StoryPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367460);
  }
  
  private final void anB(int paramInt)
  {
    AppMethodBeat.i(120289);
    Object localObject1 = new ArrayList();
    Object localObject2 = ((Iterable)this.SzL).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (j)((Iterator)localObject2).next();
      localObject4 = com.tencent.mm.plugin.story.e.a.Sjk;
      ((ArrayList)localObject1).add(a.a.C(Integer.valueOf(((j)localObject3).field_createTime)));
    }
    localObject1 = (List)localObject1;
    localObject2 = com.tencent.mm.plugin.story.api.p.Siw;
    Object localObject3 = this.sWX;
    Object localObject4 = com.tencent.mm.plugin.story.f.d.SoN;
    long l = ((p.b)localObject2).a((List)localObject1, (String)localObject3, com.tencent.mm.plugin.story.f.d.hxp());
    localObject2 = new Intent(this.mContext, StoryBrowseUI.class);
    ((Intent)localObject2).putExtra("username", this.sWX);
    ((Intent)localObject2).putExtra("data_seed_key", l);
    ((Intent)localObject2).putExtra("v_position", paramInt);
    ((Intent)localObject2).putExtra("gallery_story_need_action", true);
    localObject1 = this.mContext;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/story/ui/view/StoryPreference", "goFavGallery", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/story/ui/view/StoryPreference", "goFavGallery", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localObject1 = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.hxW().jjn = 14L;
    AppMethodBeat.o(120289);
  }
  
  private static final void b(StoryPreference paramStoryPreference, View paramView)
  {
    AppMethodBeat.i(367464);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramStoryPreference);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/StoryPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramStoryPreference, "this$0");
    paramStoryPreference.anB(1);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/StoryPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367464);
  }
  
  private static final void c(StoryPreference paramStoryPreference, View paramView)
  {
    AppMethodBeat.i(367465);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramStoryPreference);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/StoryPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramStoryPreference, "this$0");
    paramStoryPreference.anB(2);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/StoryPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367465);
  }
  
  public final void a(com.tencent.mm.plugin.story.api.d paramd)
  {
    this.SzM = paramd;
  }
  
  public final void huJ()
  {
    AppMethodBeat.i(120291);
    Object localObject1 = m.Sks;
    localObject1 = this.sWX;
    kotlin.g.b.s.u(localObject1, "username");
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
    Object localObject2 = StoryCore.SjP;
    boolean bool = Util.isEqual((String)localObject1, StoryCore.b.hgg());
    localObject2 = com.tencent.mm.plugin.story.h.a.Sry;
    locals.a((com.tencent.mm.am.p)new i((String)localObject1, 0L, bool, "", com.tencent.mm.plugin.story.h.a.hyX()), 0);
    AppMethodBeat.o(120291);
  }
  
  public final void huK()
  {
    int j = 1;
    int k = 1;
    AppMethodBeat.i(120292);
    Object localObject1 = this.fO.getLayoutParams();
    if (localObject1 != null) {
      ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cd.a.br(this.mContext, a.b.FixedTitleWidth);
    }
    this.fO.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.SzL.clear();
    localObject1 = this.SzL;
    Object localObject2 = StoryCore.SjP;
    localObject2 = StoryCore.b.hvR();
    Object localObject3 = this.sWX;
    Object localObject4 = this.sWX;
    StoryCore.b localb = StoryCore.SjP;
    ((ArrayList)localObject1).addAll((Collection)((k)localObject2).a((String)localObject3, Util.isEqual((String)localObject4, StoryCore.b.hgg()), 0L, 20));
    this.SzI.setVisibility(8);
    this.SzJ.setVisibility(8);
    this.SzK.setVisibility(8);
    int i;
    if (!((Collection)this.SzL).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label426;
      }
      this.fO.setText((CharSequence)this.mContext.getResources().getString(a.g.contact_info_story_title));
      label186:
      if (this.SzL.size() != 1) {
        break label446;
      }
      this.fO.setVisibility(0);
      this.SzI.setVisibility(0);
      localObject2 = ((j)this.SzL.get(0)).hzt().abJZ;
      if (localObject2 != null)
      {
        localObject1 = ((fij)localObject2).Zpr;
        kotlin.g.b.s.s(localObject1, "obj.MediaObjList");
        if (((Collection)localObject1).isEmpty()) {
          break label441;
        }
        i = k;
        label267:
        if (i != 0)
        {
          localObject1 = StoryCore.SjP;
          localObject1 = StoryCore.b.hvZ();
          localObject2 = ((fij)localObject2).Zpr.get(0);
          kotlin.g.b.s.s(localObject2, "obj.MediaObjList[0]");
          localObject2 = (fis)localObject2;
          localObject3 = ((j)this.SzL.get(0)).field_userName;
          localObject4 = br.adkh;
          kotlin.g.b.s.s(localObject4, "storyalbum");
          localObject2 = new com.tencent.mm.plugin.story.model.c.d((fis)localObject2, (String)localObject3, (br)localObject4);
          localObject3 = this.SzC;
          kotlin.g.b.s.checkNotNull(localObject3);
          localObject3 = (ImageView)localObject3;
          localObject4 = StoryCore.SjP;
          ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, StoryCore.b.a(com.tencent.mm.plugin.story.model.c.a.SlS));
        }
      }
    }
    label426:
    label943:
    for (;;)
    {
      localObject1 = this.SzM;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.story.api.d)localObject1).jt((List)this.SzL);
      }
      AppMethodBeat.o(120292);
      return;
      i = 0;
      break;
      this.fO.setText((CharSequence)"");
      break label186;
      label441:
      i = 0;
      break label267;
      label446:
      if (this.SzL.size() == 2)
      {
        this.fO.setVisibility(0);
        this.SzI.setVisibility(0);
        this.SzJ.setVisibility(0);
        localObject2 = ((j)this.SzL.get(0)).hzt().abJZ;
        if (localObject2 != null)
        {
          localObject1 = ((fij)localObject2).Zpr;
          kotlin.g.b.s.s(localObject1, "obj1.MediaObjList");
          if (((Collection)localObject1).isEmpty()) {
            break label836;
          }
          i = 1;
          if (i != 0)
          {
            localObject1 = StoryCore.SjP;
            localObject1 = StoryCore.b.hvZ();
            localObject2 = ((fij)localObject2).Zpr.get(0);
            kotlin.g.b.s.s(localObject2, "obj1.MediaObjList[0]");
            localObject2 = (fis)localObject2;
            localObject3 = ((j)this.SzL.get(0)).field_userName;
            localObject4 = br.adkh;
            kotlin.g.b.s.s(localObject4, "storyalbum");
            localObject2 = new com.tencent.mm.plugin.story.model.c.d((fis)localObject2, (String)localObject3, (br)localObject4);
            localObject3 = this.SzC;
            kotlin.g.b.s.checkNotNull(localObject3);
            localObject3 = (ImageView)localObject3;
            localObject4 = StoryCore.SjP;
            ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, StoryCore.b.a(com.tencent.mm.plugin.story.model.c.a.SlS));
          }
        }
        localObject2 = ((j)this.SzL.get(1)).hzt().abJZ;
        if (localObject2 != null)
        {
          localObject1 = ((fij)localObject2).Zpr;
          kotlin.g.b.s.s(localObject1, "obj2.MediaObjList");
          if (!((Collection)localObject1).isEmpty()) {}
          for (i = j;; i = 0)
          {
            if (i == 0) {
              break label844;
            }
            localObject1 = StoryCore.SjP;
            localObject1 = StoryCore.b.hvZ();
            localObject2 = ((fij)localObject2).Zpr.get(0);
            kotlin.g.b.s.s(localObject2, "obj2.MediaObjList[0]");
            localObject2 = (fis)localObject2;
            localObject3 = ((j)this.SzL.get(0)).field_userName;
            localObject4 = br.adkh;
            kotlin.g.b.s.s(localObject4, "storyalbum");
            localObject2 = new com.tencent.mm.plugin.story.model.c.d((fis)localObject2, (String)localObject3, (br)localObject4);
            localObject3 = this.SzD;
            kotlin.g.b.s.checkNotNull(localObject3);
            localObject3 = (ImageView)localObject3;
            localObject4 = StoryCore.SjP;
            ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, StoryCore.b.a(com.tencent.mm.plugin.story.model.c.a.SlS));
            break;
            label836:
            i = 0;
            break label535;
          }
        }
      }
      else
      {
        label844:
        if (this.SzL.size() >= 3)
        {
          this.fO.setVisibility(0);
          this.SzI.setVisibility(0);
          this.SzJ.setVisibility(0);
          this.SzK.setVisibility(0);
          localObject2 = ((j)this.SzL.get(0)).hzt().abJZ;
          if (localObject2 != null)
          {
            localObject1 = ((fij)localObject2).Zpr;
            kotlin.g.b.s.s(localObject1, "obj1.MediaObjList");
            if (((Collection)localObject1).isEmpty()) {
              break label1420;
            }
            i = 1;
            if (i != 0)
            {
              localObject1 = StoryCore.SjP;
              localObject1 = StoryCore.b.hvZ();
              localObject2 = ((fij)localObject2).Zpr.get(0);
              kotlin.g.b.s.s(localObject2, "obj1.MediaObjList[0]");
              localObject2 = (fis)localObject2;
              localObject3 = ((j)this.SzL.get(0)).field_userName;
              localObject4 = br.adkh;
              kotlin.g.b.s.s(localObject4, "storyalbum");
              localObject2 = new com.tencent.mm.plugin.story.model.c.d((fis)localObject2, (String)localObject3, (br)localObject4);
              localObject3 = this.SzC;
              kotlin.g.b.s.checkNotNull(localObject3);
              localObject3 = (ImageView)localObject3;
              localObject4 = StoryCore.SjP;
              ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, StoryCore.b.a(com.tencent.mm.plugin.story.model.c.a.SlS));
            }
          }
          localObject2 = ((j)this.SzL.get(1)).hzt().abJZ;
          if (localObject2 != null)
          {
            localObject1 = ((fij)localObject2).Zpr;
            kotlin.g.b.s.s(localObject1, "obj2.MediaObjList");
            if (((Collection)localObject1).isEmpty()) {
              break label1425;
            }
            i = 1;
            label1119:
            if (i != 0)
            {
              localObject1 = StoryCore.SjP;
              localObject1 = StoryCore.b.hvZ();
              localObject2 = ((fij)localObject2).Zpr.get(0);
              kotlin.g.b.s.s(localObject2, "obj2.MediaObjList[0]");
              localObject2 = (fis)localObject2;
              localObject3 = ((j)this.SzL.get(0)).field_userName;
              localObject4 = br.adkh;
              kotlin.g.b.s.s(localObject4, "storyalbum");
              localObject2 = new com.tencent.mm.plugin.story.model.c.d((fis)localObject2, (String)localObject3, (br)localObject4);
              localObject3 = this.SzD;
              kotlin.g.b.s.checkNotNull(localObject3);
              localObject3 = (ImageView)localObject3;
              localObject4 = StoryCore.SjP;
              ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, StoryCore.b.a(com.tencent.mm.plugin.story.model.c.a.SlS));
            }
          }
          localObject2 = ((j)this.SzL.get(2)).hzt().abJZ;
          if (localObject2 != null)
          {
            localObject1 = ((fij)localObject2).Zpr;
            kotlin.g.b.s.s(localObject1, "obj3.MediaObjList");
            if (!((Collection)localObject1).isEmpty()) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label1433;
              }
              localObject1 = StoryCore.SjP;
              localObject1 = StoryCore.b.hvZ();
              localObject2 = ((fij)localObject2).Zpr.get(0);
              kotlin.g.b.s.s(localObject2, "obj3.MediaObjList[0]");
              localObject2 = (fis)localObject2;
              localObject3 = ((j)this.SzL.get(0)).field_userName;
              localObject4 = br.adkh;
              kotlin.g.b.s.s(localObject4, "storyalbum");
              localObject2 = new com.tencent.mm.plugin.story.model.c.d((fis)localObject2, (String)localObject3, (br)localObject4);
              localObject3 = this.SzE;
              kotlin.g.b.s.checkNotNull(localObject3);
              localObject3 = (ImageView)localObject3;
              localObject4 = StoryCore.SjP;
              ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, StoryCore.b.a(com.tencent.mm.plugin.story.model.c.a.SlS));
              break;
              i = 0;
              break label943;
              i = 0;
              break label1119;
            }
          }
        }
      }
    }
  }
  
  public final void huL()
  {
    AppMethodBeat.i(120293);
    if (!((Collection)this.SzL).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        anB(0);
      }
      AppMethodBeat.o(120293);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(120297);
    kotlin.g.b.s.u(paramView, "view");
    super.onBindView(paramView);
    huK();
    AppMethodBeat.o(120297);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(120290);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.sWX = str;
    if (!this.SzN)
    {
      com.tencent.mm.kernel.h.baD().mCm.a(273, (com.tencent.mm.am.h)this);
      this.SzN = true;
    }
    AppMethodBeat.o(120290);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120296);
    kotlin.g.b.s.u(paramViewGroup, "parent");
    if (this.KKQ == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.d.content);
      localViewGroup.removeAllViews();
      this.mView.setId(a.d.title_ll);
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
      localViewGroup.addView(this.mView, localLayoutParams);
      this.KKQ = paramViewGroup;
    }
    paramViewGroup = this.KKQ;
    kotlin.g.b.s.checkNotNull(paramViewGroup);
    AppMethodBeat.o(120296);
    return paramViewGroup;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(120294);
    this.SzM = null;
    com.tencent.mm.kernel.h.baD().mCm.b(273, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(120294);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(120295);
    if ((paramp instanceof i))
    {
      paramInt2 = ((i)paramp).source;
      paramString = com.tencent.mm.plugin.story.h.a.Sry;
      if ((paramInt2 == com.tencent.mm.plugin.story.h.a.hyX()) && (Util.isEqual(((i)paramp).userName, this.sWX)) && (paramInt1 == 0)) {
        huK();
      }
    }
    AppMethodBeat.o(120295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryPreference
 * JD-Core Version:    0.7.0.1
 */