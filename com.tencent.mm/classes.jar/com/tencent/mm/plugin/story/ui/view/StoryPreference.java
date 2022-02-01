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
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.g.b.a.fy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.AbsStoryPreference;
import com.tencent.mm.plugin.story.api.p.b;
import com.tencent.mm.plugin.story.e.a.a;
import com.tencent.mm.plugin.story.f.a.i;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.plugin.story.ui.StoryBrowseUI;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.protocal.protobuf.dkc;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.ao;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/StoryPreference;", "Lcom/tencent/mm/plugin/story/api/AbsStoryPreference;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isAddedSceneListener", "", "mCallback", "Lcom/tencent/mm/plugin/story/api/ILoadFavStoryCallback;", "mCoverView", "Landroid/view/View;", "mStoryFavList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "mStoryIconView1", "Landroid/widget/ImageView;", "mStoryIconView2", "mStoryIconView3", "mStoryView1", "Lcom/tencent/mm/plugin/story/ui/view/StoryRoundImageView;", "mStoryView2", "mStoryView3", "mStoryViewGroup1", "Landroid/view/ViewGroup;", "mStoryViewGroup2", "mStoryViewGroup3", "mTitleView", "Landroid/widget/TextView;", "mUsername", "", "mView", "getDateList", "", "goFavGallery", "", "position", "handleEvent", "loadStory", "onBindView", "view", "onCreate", "username", "onCreateView", "parent", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setLoadCallback", "callback", "updateFavStory", "plugin-story_release"})
public final class StoryPreference
  extends AbsStoryPreference
  implements f
{
  private StoryRoundImageView BbK;
  private StoryRoundImageView BbL;
  private StoryRoundImageView BbM;
  private ImageView BbN;
  private ImageView BbO;
  private ImageView BbP;
  private ViewGroup BbQ;
  private ViewGroup BbR;
  private ViewGroup BbS;
  private ArrayList<com.tencent.mm.plugin.story.i.j> BbT;
  private com.tencent.mm.plugin.story.api.d BbU;
  private boolean BbV;
  private TextView Xl;
  private String lEN;
  private View mView;
  private View vET;
  
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
    d.g.b.p.g(paramContext, "View.inflate(context, R.…e_fav_panel_layout, null)");
    this.mView = paramContext;
    this.BbT = new ArrayList();
    this.lEN = "";
    paramContext = this.mView.findViewById(16908310);
    d.g.b.p.g(paramContext, "mView.findViewById(android.R.id.title)");
    this.Xl = ((TextView)paramContext);
    paramContext = this.mView.findViewById(2131302330);
    d.g.b.p.g(paramContext, "mView.findViewById(R.id.…eference_story_image_iv1)");
    this.BbK = ((StoryRoundImageView)paramContext);
    paramContext = this.mView.findViewById(2131302332);
    d.g.b.p.g(paramContext, "mView.findViewById(R.id.…eference_story_image_iv2)");
    this.BbL = ((StoryRoundImageView)paramContext);
    paramContext = this.mView.findViewById(2131302334);
    d.g.b.p.g(paramContext, "mView.findViewById(R.id.…eference_story_image_iv3)");
    this.BbM = ((StoryRoundImageView)paramContext);
    paramContext = this.mView.findViewById(2131302327);
    d.g.b.p.g(paramContext, "mView.findViewById(R.id.…erence_story_image_icon1)");
    this.BbN = ((ImageView)paramContext);
    paramContext = this.mView.findViewById(2131302328);
    d.g.b.p.g(paramContext, "mView.findViewById(R.id.…erence_story_image_icon2)");
    this.BbO = ((ImageView)paramContext);
    paramContext = this.mView.findViewById(2131302329);
    d.g.b.p.g(paramContext, "mView.findViewById(R.id.…erence_story_image_icon3)");
    this.BbP = ((ImageView)paramContext);
    paramContext = this.mView.findViewById(2131302331);
    d.g.b.p.g(paramContext, "mView.findViewById(R.id.…ce_story_image_iv1_group)");
    this.BbQ = ((ViewGroup)paramContext);
    paramContext = this.mView.findViewById(2131302333);
    d.g.b.p.g(paramContext, "mView.findViewById(R.id.…ce_story_image_iv2_group)");
    this.BbR = ((ViewGroup)paramContext);
    paramContext = this.mView.findViewById(2131302335);
    d.g.b.p.g(paramContext, "mView.findViewById(R.id.…ce_story_image_iv3_group)");
    this.BbS = ((ViewGroup)paramContext);
    paramInt = com.tencent.mm.cc.a.fromDPToPix(getContext(), 8);
    this.BbK.setRound(paramInt);
    this.BbL.setRound(paramInt);
    this.BbM.setRound(paramInt);
    paramContext = ao.k(getContext(), 2131690460, -1);
    this.BbN.setImageDrawable(paramContext);
    this.BbO.setImageDrawable(paramContext);
    this.BbP.setImageDrawable(paramContext);
    this.BbK.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120286);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        StoryPreference.a(this.BbW, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120286);
      }
    });
    this.BbL.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120287);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        StoryPreference.a(this.BbW, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120287);
      }
    });
    this.BbM.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120288);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryPreference$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        StoryPreference.a(this.BbW, 2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryPreference$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120288);
      }
    });
    AppMethodBeat.o(120299);
  }
  
  private final void SC(int paramInt)
  {
    AppMethodBeat.i(120289);
    Object localObject1 = new ArrayList();
    Object localObject2 = ((Iterable)this.BbT).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject2).next();
      localObject4 = com.tencent.mm.plugin.story.e.a.AIZ;
      ((ArrayList)localObject1).add(a.a.m(Integer.valueOf(((com.tencent.mm.plugin.story.i.j)localObject3).field_createTime)));
    }
    localObject1 = (List)localObject1;
    localObject2 = com.tencent.mm.plugin.story.api.p.AIi;
    Object localObject3 = this.lEN;
    Object localObject4 = com.tencent.mm.plugin.story.g.d.APo;
    long l = ((p.b)localObject2).b((List)localObject1, (String)localObject3, com.tencent.mm.plugin.story.g.d.ejs());
    localObject2 = new Intent(getContext(), StoryBrowseUI.class);
    ((Intent)localObject2).putExtra("username", this.lEN);
    ((Intent)localObject2).putExtra("data_seed_key", l);
    ((Intent)localObject2).putExtra("v_position", paramInt);
    ((Intent)localObject2).putExtra("gallery_story_need_action", true);
    localObject1 = getContext();
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/story/ui/view/StoryPreference", "goFavGallery", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/story/ui/view/StoryPreference", "goFavGallery", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localObject1 = h.ASt;
    h.ejZ().kY(14L);
    AppMethodBeat.o(120289);
  }
  
  public final void a(com.tencent.mm.plugin.story.api.d paramd)
  {
    this.BbU = paramd;
  }
  
  public final void egO()
  {
    AppMethodBeat.i(120291);
    Object localObject1 = com.tencent.mm.plugin.story.f.n.AKq;
    localObject1 = this.lEN;
    d.g.b.p.h(localObject1, "username");
    Object localObject2 = g.ajB();
    d.g.b.p.g(localObject2, "MMKernel.network()");
    localObject2 = ((com.tencent.mm.kernel.b)localObject2).aiU();
    Object localObject3 = com.tencent.mm.plugin.story.f.j.AKb;
    boolean bool = bt.lQ((String)localObject1, j.b.dTJ());
    localObject3 = com.tencent.mm.plugin.story.i.a.ATp;
    ((q)localObject2).b((com.tencent.mm.al.n)new i((String)localObject1, 0L, bool, "", com.tencent.mm.plugin.story.i.a.ela()));
    AppMethodBeat.o(120291);
  }
  
  public final void egP()
  {
    int j = 1;
    int k = 1;
    AppMethodBeat.i(120292);
    Object localObject1 = this.Xl.getLayoutParams();
    if (localObject1 != null) {
      ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cc.a.ax(getContext(), 2131165370);
    }
    this.Xl.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.BbT.clear();
    localObject1 = this.BbT;
    Object localObject2 = com.tencent.mm.plugin.story.f.j.AKb;
    localObject2 = j.b.ehT();
    Object localObject3 = this.lEN;
    Object localObject4 = this.lEN;
    j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
    ((ArrayList)localObject1).addAll((Collection)((k)localObject2).a((String)localObject3, bt.lQ((String)localObject4, j.b.dTJ()), 0L, 20));
    this.BbQ.setVisibility(8);
    this.BbR.setVisibility(8);
    this.BbS.setVisibility(8);
    int i;
    if (!((Collection)this.BbT).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label444;
      }
      localObject1 = this.Xl;
      localObject2 = getContext();
      d.g.b.p.g(localObject2, "context");
      ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(2131757878));
      label201:
      if (this.BbT.size() != 1) {
        break label464;
      }
      this.Xl.setVisibility(0);
      this.BbQ.setVisibility(0);
      localObject2 = ((com.tencent.mm.plugin.story.i.j)this.BbT.get(0)).elx().HyN;
      if (localObject2 != null)
      {
        localObject1 = ((djc)localObject2).GaQ;
        d.g.b.p.g(localObject1, "obj.MediaObjList");
        if (((Collection)localObject1).isEmpty()) {
          break label459;
        }
        i = k;
        label282:
        if (i != 0)
        {
          localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
          localObject1 = j.b.eib();
          localObject2 = ((djc)localObject2).GaQ.get(0);
          d.g.b.p.g(localObject2, "obj.MediaObjList[0]");
          localObject2 = (djl)localObject2;
          localObject3 = ((com.tencent.mm.plugin.story.i.j)this.BbT.get(0)).field_userName;
          localObject4 = bj.ILZ;
          d.g.b.p.g(localObject4, "FROM_SCENE.storyalbum");
          localObject2 = new com.tencent.mm.plugin.story.f.c.d((djl)localObject2, (String)localObject3, (bj)localObject4);
          localObject3 = this.BbK;
          if (localObject3 == null) {
            d.g.b.p.gfZ();
          }
          localObject3 = (ImageView)localObject3;
          localObject4 = com.tencent.mm.plugin.story.f.j.AKb;
          ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.AMe));
        }
      }
    }
    label444:
    label967:
    for (;;)
    {
      localObject1 = this.BbU;
      if (localObject1 == null) {
        break label1468;
      }
      ((com.tencent.mm.plugin.story.api.d)localObject1).eM((List)this.BbT);
      AppMethodBeat.o(120292);
      return;
      i = 0;
      break;
      this.Xl.setText((CharSequence)"");
      break label201;
      label459:
      i = 0;
      break label282;
      label464:
      if (this.BbT.size() == 2)
      {
        this.Xl.setVisibility(0);
        this.BbQ.setVisibility(0);
        this.BbR.setVisibility(0);
        localObject2 = ((com.tencent.mm.plugin.story.i.j)this.BbT.get(0)).elx().HyN;
        if (localObject2 != null)
        {
          localObject1 = ((djc)localObject2).GaQ;
          d.g.b.p.g(localObject1, "obj1.MediaObjList");
          if (((Collection)localObject1).isEmpty()) {
            break label860;
          }
          i = 1;
          if (i != 0)
          {
            localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
            localObject1 = j.b.eib();
            localObject2 = ((djc)localObject2).GaQ.get(0);
            d.g.b.p.g(localObject2, "obj1.MediaObjList[0]");
            localObject2 = (djl)localObject2;
            localObject3 = ((com.tencent.mm.plugin.story.i.j)this.BbT.get(0)).field_userName;
            localObject4 = bj.ILZ;
            d.g.b.p.g(localObject4, "FROM_SCENE.storyalbum");
            localObject2 = new com.tencent.mm.plugin.story.f.c.d((djl)localObject2, (String)localObject3, (bj)localObject4);
            localObject3 = this.BbK;
            if (localObject3 == null) {
              d.g.b.p.gfZ();
            }
            localObject3 = (ImageView)localObject3;
            localObject4 = com.tencent.mm.plugin.story.f.j.AKb;
            ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.AMe));
          }
        }
        localObject2 = ((com.tencent.mm.plugin.story.i.j)this.BbT.get(1)).elx().HyN;
        if (localObject2 != null)
        {
          localObject1 = ((djc)localObject2).GaQ;
          d.g.b.p.g(localObject1, "obj2.MediaObjList");
          if (!((Collection)localObject1).isEmpty()) {}
          for (i = j;; i = 0)
          {
            if (i == 0) {
              break label868;
            }
            localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
            localObject1 = j.b.eib();
            localObject2 = ((djc)localObject2).GaQ.get(0);
            d.g.b.p.g(localObject2, "obj2.MediaObjList[0]");
            localObject2 = (djl)localObject2;
            localObject3 = ((com.tencent.mm.plugin.story.i.j)this.BbT.get(0)).field_userName;
            localObject4 = bj.ILZ;
            d.g.b.p.g(localObject4, "FROM_SCENE.storyalbum");
            localObject2 = new com.tencent.mm.plugin.story.f.c.d((djl)localObject2, (String)localObject3, (bj)localObject4);
            localObject3 = this.BbL;
            if (localObject3 == null) {
              d.g.b.p.gfZ();
            }
            localObject3 = (ImageView)localObject3;
            localObject4 = com.tencent.mm.plugin.story.f.j.AKb;
            ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.AMe));
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
        if (this.BbT.size() >= 3)
        {
          this.Xl.setVisibility(0);
          this.BbQ.setVisibility(0);
          this.BbR.setVisibility(0);
          this.BbS.setVisibility(0);
          localObject2 = ((com.tencent.mm.plugin.story.i.j)this.BbT.get(0)).elx().HyN;
          if (localObject2 != null)
          {
            localObject1 = ((djc)localObject2).GaQ;
            d.g.b.p.g(localObject1, "obj1.MediaObjList");
            if (((Collection)localObject1).isEmpty()) {
              break label1453;
            }
            i = 1;
            if (i != 0)
            {
              localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
              localObject1 = j.b.eib();
              localObject2 = ((djc)localObject2).GaQ.get(0);
              d.g.b.p.g(localObject2, "obj1.MediaObjList[0]");
              localObject2 = (djl)localObject2;
              localObject3 = ((com.tencent.mm.plugin.story.i.j)this.BbT.get(0)).field_userName;
              localObject4 = bj.ILZ;
              d.g.b.p.g(localObject4, "FROM_SCENE.storyalbum");
              localObject2 = new com.tencent.mm.plugin.story.f.c.d((djl)localObject2, (String)localObject3, (bj)localObject4);
              localObject3 = this.BbK;
              if (localObject3 == null) {
                d.g.b.p.gfZ();
              }
              localObject3 = (ImageView)localObject3;
              localObject4 = com.tencent.mm.plugin.story.f.j.AKb;
              ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.AMe));
            }
          }
          localObject2 = ((com.tencent.mm.plugin.story.i.j)this.BbT.get(1)).elx().HyN;
          if (localObject2 != null)
          {
            localObject1 = ((djc)localObject2).GaQ;
            d.g.b.p.g(localObject1, "obj2.MediaObjList");
            if (((Collection)localObject1).isEmpty()) {
              break label1458;
            }
            i = 1;
            label1146:
            if (i != 0)
            {
              localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
              localObject1 = j.b.eib();
              localObject2 = ((djc)localObject2).GaQ.get(0);
              d.g.b.p.g(localObject2, "obj2.MediaObjList[0]");
              localObject2 = (djl)localObject2;
              localObject3 = ((com.tencent.mm.plugin.story.i.j)this.BbT.get(0)).field_userName;
              localObject4 = bj.ILZ;
              d.g.b.p.g(localObject4, "FROM_SCENE.storyalbum");
              localObject2 = new com.tencent.mm.plugin.story.f.c.d((djl)localObject2, (String)localObject3, (bj)localObject4);
              localObject3 = this.BbL;
              if (localObject3 == null) {
                d.g.b.p.gfZ();
              }
              localObject3 = (ImageView)localObject3;
              localObject4 = com.tencent.mm.plugin.story.f.j.AKb;
              ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.AMe));
            }
          }
          localObject2 = ((com.tencent.mm.plugin.story.i.j)this.BbT.get(2)).elx().HyN;
          if (localObject2 != null)
          {
            localObject1 = ((djc)localObject2).GaQ;
            d.g.b.p.g(localObject1, "obj3.MediaObjList");
            if (!((Collection)localObject1).isEmpty()) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label1466;
              }
              localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
              localObject1 = j.b.eib();
              localObject2 = ((djc)localObject2).GaQ.get(0);
              d.g.b.p.g(localObject2, "obj3.MediaObjList[0]");
              localObject2 = (djl)localObject2;
              localObject3 = ((com.tencent.mm.plugin.story.i.j)this.BbT.get(0)).field_userName;
              localObject4 = bj.ILZ;
              d.g.b.p.g(localObject4, "FROM_SCENE.storyalbum");
              localObject2 = new com.tencent.mm.plugin.story.f.c.d((djl)localObject2, (String)localObject3, (bj)localObject4);
              localObject3 = this.BbM;
              if (localObject3 == null) {
                d.g.b.p.gfZ();
              }
              localObject3 = (ImageView)localObject3;
              localObject4 = com.tencent.mm.plugin.story.f.j.AKb;
              ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.AMe));
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
  
  public final void egQ()
  {
    AppMethodBeat.i(120293);
    if (!((Collection)this.BbT).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        SC(0);
      }
      AppMethodBeat.o(120293);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(120297);
    d.g.b.p.h(paramView, "view");
    super.onBindView(paramView);
    egP();
    AppMethodBeat.o(120297);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(120290);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.lEN = str;
    if (!this.BbV)
    {
      paramString = g.ajB();
      d.g.b.p.g(paramString, "MMKernel.network()");
      paramString.aiU().a(273, (f)this);
      this.BbV = true;
    }
    AppMethodBeat.o(120290);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120296);
    d.g.b.p.h(paramViewGroup, "parent");
    if (this.vET == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
      localViewGroup.removeAllViews();
      this.mView.setId(2131305937);
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
      localViewGroup.addView(this.mView, localLayoutParams);
      this.vET = paramViewGroup;
    }
    paramViewGroup = this.vET;
    if (paramViewGroup == null) {
      d.g.b.p.gfZ();
    }
    AppMethodBeat.o(120296);
    return paramViewGroup;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(120294);
    this.BbU = null;
    com.tencent.mm.kernel.b localb = g.ajB();
    d.g.b.p.g(localb, "MMKernel.network()");
    localb.aiU().b(273, (f)this);
    AppMethodBeat.o(120294);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(120295);
    if ((paramn instanceof i))
    {
      paramInt2 = ((i)paramn).dnh;
      paramString = com.tencent.mm.plugin.story.i.a.ATp;
      if ((paramInt2 == com.tencent.mm.plugin.story.i.a.ela()) && (bt.lQ(((i)paramn).userName, this.lEN)) && (paramInt1 == 0)) {
        egP();
      }
    }
    AppMethodBeat.o(120295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryPreference
 * JD-Core Version:    0.7.0.1
 */