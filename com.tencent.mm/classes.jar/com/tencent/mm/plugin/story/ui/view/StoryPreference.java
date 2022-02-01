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
import com.tencent.mm.al.q;
import com.tencent.mm.g.b.a.dl;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.story.api.AbsStoryPreference;
import com.tencent.mm.plugin.story.api.p;
import com.tencent.mm.plugin.story.api.p.b;
import com.tencent.mm.plugin.story.e.a.a;
import com.tencent.mm.plugin.story.f.a.i;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.ui.StoryBrowseUI;
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.am;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/StoryPreference;", "Lcom/tencent/mm/plugin/story/api/AbsStoryPreference;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isAddedSceneListener", "", "mCallback", "Lcom/tencent/mm/plugin/story/api/ILoadFavStoryCallback;", "mCoverView", "Landroid/view/View;", "mStoryFavList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "mStoryIconView1", "Landroid/widget/ImageView;", "mStoryIconView2", "mStoryIconView3", "mStoryView1", "Lcom/tencent/mm/plugin/story/ui/view/StoryRoundImageView;", "mStoryView2", "mStoryView3", "mStoryViewGroup1", "Landroid/view/ViewGroup;", "mStoryViewGroup2", "mStoryViewGroup3", "mTitleView", "Landroid/widget/TextView;", "mUsername", "", "mView", "getDateList", "", "goFavGallery", "", "position", "handleEvent", "loadStory", "onBindView", "view", "onCreate", "username", "onCreateView", "parent", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setLoadCallback", "callback", "updateFavStory", "plugin-story_release"})
public final class StoryPreference
  extends AbsStoryPreference
  implements com.tencent.mm.al.g
{
  private TextView UA;
  private String kGt;
  private View mView;
  private View ttN;
  private StoryRoundImageView ywT;
  private StoryRoundImageView ywU;
  private StoryRoundImageView ywV;
  private ImageView ywW;
  private ImageView ywX;
  private ImageView ywY;
  private ViewGroup ywZ;
  private ViewGroup yxa;
  private ViewGroup yxb;
  private ArrayList<com.tencent.mm.plugin.story.i.j> yxc;
  private com.tencent.mm.plugin.story.api.d yxd;
  private boolean yxe;
  
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
    this.yxc = new ArrayList();
    this.kGt = "";
    paramContext = this.mView.findViewById(16908310);
    d.g.b.k.g(paramContext, "mView.findViewById(android.R.id.title)");
    this.UA = ((TextView)paramContext);
    paramContext = this.mView.findViewById(2131302330);
    d.g.b.k.g(paramContext, "mView.findViewById(R.id.…eference_story_image_iv1)");
    this.ywT = ((StoryRoundImageView)paramContext);
    paramContext = this.mView.findViewById(2131302332);
    d.g.b.k.g(paramContext, "mView.findViewById(R.id.…eference_story_image_iv2)");
    this.ywU = ((StoryRoundImageView)paramContext);
    paramContext = this.mView.findViewById(2131302334);
    d.g.b.k.g(paramContext, "mView.findViewById(R.id.…eference_story_image_iv3)");
    this.ywV = ((StoryRoundImageView)paramContext);
    paramContext = this.mView.findViewById(2131302327);
    d.g.b.k.g(paramContext, "mView.findViewById(R.id.…erence_story_image_icon1)");
    this.ywW = ((ImageView)paramContext);
    paramContext = this.mView.findViewById(2131302328);
    d.g.b.k.g(paramContext, "mView.findViewById(R.id.…erence_story_image_icon2)");
    this.ywX = ((ImageView)paramContext);
    paramContext = this.mView.findViewById(2131302329);
    d.g.b.k.g(paramContext, "mView.findViewById(R.id.…erence_story_image_icon3)");
    this.ywY = ((ImageView)paramContext);
    paramContext = this.mView.findViewById(2131302331);
    d.g.b.k.g(paramContext, "mView.findViewById(R.id.…ce_story_image_iv1_group)");
    this.ywZ = ((ViewGroup)paramContext);
    paramContext = this.mView.findViewById(2131302333);
    d.g.b.k.g(paramContext, "mView.findViewById(R.id.…ce_story_image_iv2_group)");
    this.yxa = ((ViewGroup)paramContext);
    paramContext = this.mView.findViewById(2131302335);
    d.g.b.k.g(paramContext, "mView.findViewById(R.id.…ce_story_image_iv3_group)");
    this.yxb = ((ViewGroup)paramContext);
    paramInt = com.tencent.mm.cd.a.fromDPToPix(getContext(), 8);
    this.ywT.setRound(paramInt);
    this.ywU.setRound(paramInt);
    this.ywV.setRound(paramInt);
    paramContext = am.i(getContext(), 2131690460, -1);
    this.ywW.setImageDrawable(paramContext);
    this.ywX.setImageDrawable(paramContext);
    this.ywY.setImageDrawable(paramContext);
    this.ywT.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120286);
        StoryPreference.a(this.yxf, 0);
        AppMethodBeat.o(120286);
      }
    });
    this.ywU.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120287);
        StoryPreference.a(this.yxf, 1);
        AppMethodBeat.o(120287);
      }
    });
    this.ywV.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120288);
        StoryPreference.a(this.yxf, 2);
        AppMethodBeat.o(120288);
      }
    });
    AppMethodBeat.o(120299);
  }
  
  private final void ON(int paramInt)
  {
    AppMethodBeat.i(120289);
    Object localObject1 = new ArrayList();
    Object localObject2 = ((Iterable)this.yxc).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject2).next();
      localObject4 = com.tencent.mm.plugin.story.e.a.yef;
      ((ArrayList)localObject1).add(a.a.k(Integer.valueOf(((com.tencent.mm.plugin.story.i.j)localObject3).field_createTime)));
    }
    localObject1 = (List)localObject1;
    localObject2 = p.ydo;
    Object localObject3 = this.kGt;
    Object localObject4 = com.tencent.mm.plugin.story.g.d.ykt;
    long l = ((p.b)localObject2).b((List)localObject1, (String)localObject3, com.tencent.mm.plugin.story.g.d.dIC());
    localObject2 = new Intent(getContext(), StoryBrowseUI.class);
    ((Intent)localObject2).putExtra("username", this.kGt);
    ((Intent)localObject2).putExtra("data_seed_key", l);
    ((Intent)localObject2).putExtra("v_position", paramInt);
    ((Intent)localObject2).putExtra("gallery_story_need_action", true);
    localObject1 = getContext();
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/story/ui/view/StoryPreference", "goFavGallery", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/story/ui/view/StoryPreference", "goFavGallery", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localObject1 = h.ynv;
    h.dJj().fZ(14L);
    AppMethodBeat.o(120289);
  }
  
  public final void a(com.tencent.mm.plugin.story.api.d paramd)
  {
    this.yxd = paramd;
  }
  
  public final void dFZ()
  {
    AppMethodBeat.i(120291);
    Object localObject1 = com.tencent.mm.plugin.story.f.n.yfw;
    localObject1 = this.kGt;
    d.g.b.k.h(localObject1, "username");
    Object localObject2 = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(localObject2, "MMKernel.network()");
    localObject2 = ((b)localObject2).aeS();
    Object localObject3 = com.tencent.mm.plugin.story.f.j.yfh;
    boolean bool = bt.kU((String)localObject1, j.b.dta());
    localObject3 = com.tencent.mm.plugin.story.i.a.yor;
    ((q)localObject2).b((com.tencent.mm.al.n)new i((String)localObject1, 0L, bool, "", com.tencent.mm.plugin.story.i.a.dKk()));
    AppMethodBeat.o(120291);
  }
  
  public final void dGa()
  {
    int j = 1;
    int k = 1;
    AppMethodBeat.i(120292);
    Object localObject1 = this.UA.getLayoutParams();
    if (localObject1 != null) {
      ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cd.a.ao(getContext(), 2131165370);
    }
    this.UA.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.yxc.clear();
    localObject1 = this.yxc;
    Object localObject2 = com.tencent.mm.plugin.story.f.j.yfh;
    localObject2 = j.b.dHd();
    Object localObject3 = this.kGt;
    Object localObject4 = this.kGt;
    j.b localb = com.tencent.mm.plugin.story.f.j.yfh;
    ((ArrayList)localObject1).addAll((Collection)((com.tencent.mm.plugin.story.i.k)localObject2).a((String)localObject3, bt.kU((String)localObject4, j.b.dta()), 0L, 20));
    this.ywZ.setVisibility(8);
    this.yxa.setVisibility(8);
    this.yxb.setVisibility(8);
    int i;
    if (!((Collection)this.yxc).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label444;
      }
      localObject1 = this.UA;
      localObject2 = getContext();
      d.g.b.k.g(localObject2, "context");
      ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(2131757878));
      label201:
      if (this.yxc.size() != 1) {
        break label464;
      }
      this.UA.setVisibility(0);
      this.ywZ.setVisibility(0);
      localObject2 = ((com.tencent.mm.plugin.story.i.j)this.yxc.get(0)).dKH().Era;
      if (localObject2 != null)
      {
        localObject1 = ((cyd)localObject2).DaC;
        d.g.b.k.g(localObject1, "obj.MediaObjList");
        if (((Collection)localObject1).isEmpty()) {
          break label459;
        }
        i = k;
        label282:
        if (i != 0)
        {
          localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
          localObject1 = j.b.dHl();
          localObject2 = ((cyd)localObject2).DaC.get(0);
          d.g.b.k.g(localObject2, "obj.MediaObjList[0]");
          localObject2 = (cym)localObject2;
          localObject3 = ((com.tencent.mm.plugin.story.i.j)this.yxc.get(0)).field_userName;
          localObject4 = bc.FzJ;
          d.g.b.k.g(localObject4, "FROM_SCENE.storyalbum");
          localObject2 = new com.tencent.mm.plugin.story.f.c.d((cym)localObject2, (String)localObject3, (bc)localObject4);
          localObject3 = this.ywT;
          if (localObject3 == null) {
            d.g.b.k.fvU();
          }
          localObject3 = (ImageView)localObject3;
          localObject4 = com.tencent.mm.plugin.story.f.j.yfh;
          ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.yhj));
        }
      }
    }
    label444:
    label967:
    for (;;)
    {
      localObject1 = this.yxd;
      if (localObject1 == null) {
        break label1468;
      }
      ((com.tencent.mm.plugin.story.api.d)localObject1).ev((List)this.yxc);
      AppMethodBeat.o(120292);
      return;
      i = 0;
      break;
      this.UA.setText((CharSequence)"");
      break label201;
      label459:
      i = 0;
      break label282;
      label464:
      if (this.yxc.size() == 2)
      {
        this.UA.setVisibility(0);
        this.ywZ.setVisibility(0);
        this.yxa.setVisibility(0);
        localObject2 = ((com.tencent.mm.plugin.story.i.j)this.yxc.get(0)).dKH().Era;
        if (localObject2 != null)
        {
          localObject1 = ((cyd)localObject2).DaC;
          d.g.b.k.g(localObject1, "obj1.MediaObjList");
          if (((Collection)localObject1).isEmpty()) {
            break label860;
          }
          i = 1;
          if (i != 0)
          {
            localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
            localObject1 = j.b.dHl();
            localObject2 = ((cyd)localObject2).DaC.get(0);
            d.g.b.k.g(localObject2, "obj1.MediaObjList[0]");
            localObject2 = (cym)localObject2;
            localObject3 = ((com.tencent.mm.plugin.story.i.j)this.yxc.get(0)).field_userName;
            localObject4 = bc.FzJ;
            d.g.b.k.g(localObject4, "FROM_SCENE.storyalbum");
            localObject2 = new com.tencent.mm.plugin.story.f.c.d((cym)localObject2, (String)localObject3, (bc)localObject4);
            localObject3 = this.ywT;
            if (localObject3 == null) {
              d.g.b.k.fvU();
            }
            localObject3 = (ImageView)localObject3;
            localObject4 = com.tencent.mm.plugin.story.f.j.yfh;
            ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.yhj));
          }
        }
        localObject2 = ((com.tencent.mm.plugin.story.i.j)this.yxc.get(1)).dKH().Era;
        if (localObject2 != null)
        {
          localObject1 = ((cyd)localObject2).DaC;
          d.g.b.k.g(localObject1, "obj2.MediaObjList");
          if (!((Collection)localObject1).isEmpty()) {}
          for (i = j;; i = 0)
          {
            if (i == 0) {
              break label868;
            }
            localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
            localObject1 = j.b.dHl();
            localObject2 = ((cyd)localObject2).DaC.get(0);
            d.g.b.k.g(localObject2, "obj2.MediaObjList[0]");
            localObject2 = (cym)localObject2;
            localObject3 = ((com.tencent.mm.plugin.story.i.j)this.yxc.get(0)).field_userName;
            localObject4 = bc.FzJ;
            d.g.b.k.g(localObject4, "FROM_SCENE.storyalbum");
            localObject2 = new com.tencent.mm.plugin.story.f.c.d((cym)localObject2, (String)localObject3, (bc)localObject4);
            localObject3 = this.ywU;
            if (localObject3 == null) {
              d.g.b.k.fvU();
            }
            localObject3 = (ImageView)localObject3;
            localObject4 = com.tencent.mm.plugin.story.f.j.yfh;
            ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.yhj));
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
        if (this.yxc.size() >= 3)
        {
          this.UA.setVisibility(0);
          this.ywZ.setVisibility(0);
          this.yxa.setVisibility(0);
          this.yxb.setVisibility(0);
          localObject2 = ((com.tencent.mm.plugin.story.i.j)this.yxc.get(0)).dKH().Era;
          if (localObject2 != null)
          {
            localObject1 = ((cyd)localObject2).DaC;
            d.g.b.k.g(localObject1, "obj1.MediaObjList");
            if (((Collection)localObject1).isEmpty()) {
              break label1453;
            }
            i = 1;
            if (i != 0)
            {
              localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
              localObject1 = j.b.dHl();
              localObject2 = ((cyd)localObject2).DaC.get(0);
              d.g.b.k.g(localObject2, "obj1.MediaObjList[0]");
              localObject2 = (cym)localObject2;
              localObject3 = ((com.tencent.mm.plugin.story.i.j)this.yxc.get(0)).field_userName;
              localObject4 = bc.FzJ;
              d.g.b.k.g(localObject4, "FROM_SCENE.storyalbum");
              localObject2 = new com.tencent.mm.plugin.story.f.c.d((cym)localObject2, (String)localObject3, (bc)localObject4);
              localObject3 = this.ywT;
              if (localObject3 == null) {
                d.g.b.k.fvU();
              }
              localObject3 = (ImageView)localObject3;
              localObject4 = com.tencent.mm.plugin.story.f.j.yfh;
              ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.yhj));
            }
          }
          localObject2 = ((com.tencent.mm.plugin.story.i.j)this.yxc.get(1)).dKH().Era;
          if (localObject2 != null)
          {
            localObject1 = ((cyd)localObject2).DaC;
            d.g.b.k.g(localObject1, "obj2.MediaObjList");
            if (((Collection)localObject1).isEmpty()) {
              break label1458;
            }
            i = 1;
            label1146:
            if (i != 0)
            {
              localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
              localObject1 = j.b.dHl();
              localObject2 = ((cyd)localObject2).DaC.get(0);
              d.g.b.k.g(localObject2, "obj2.MediaObjList[0]");
              localObject2 = (cym)localObject2;
              localObject3 = ((com.tencent.mm.plugin.story.i.j)this.yxc.get(0)).field_userName;
              localObject4 = bc.FzJ;
              d.g.b.k.g(localObject4, "FROM_SCENE.storyalbum");
              localObject2 = new com.tencent.mm.plugin.story.f.c.d((cym)localObject2, (String)localObject3, (bc)localObject4);
              localObject3 = this.ywU;
              if (localObject3 == null) {
                d.g.b.k.fvU();
              }
              localObject3 = (ImageView)localObject3;
              localObject4 = com.tencent.mm.plugin.story.f.j.yfh;
              ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.yhj));
            }
          }
          localObject2 = ((com.tencent.mm.plugin.story.i.j)this.yxc.get(2)).dKH().Era;
          if (localObject2 != null)
          {
            localObject1 = ((cyd)localObject2).DaC;
            d.g.b.k.g(localObject1, "obj3.MediaObjList");
            if (!((Collection)localObject1).isEmpty()) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label1466;
              }
              localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
              localObject1 = j.b.dHl();
              localObject2 = ((cyd)localObject2).DaC.get(0);
              d.g.b.k.g(localObject2, "obj3.MediaObjList[0]");
              localObject2 = (cym)localObject2;
              localObject3 = ((com.tencent.mm.plugin.story.i.j)this.yxc.get(0)).field_userName;
              localObject4 = bc.FzJ;
              d.g.b.k.g(localObject4, "FROM_SCENE.storyalbum");
              localObject2 = new com.tencent.mm.plugin.story.f.c.d((cym)localObject2, (String)localObject3, (bc)localObject4);
              localObject3 = this.ywV;
              if (localObject3 == null) {
                d.g.b.k.fvU();
              }
              localObject3 = (ImageView)localObject3;
              localObject4 = com.tencent.mm.plugin.story.f.j.yfh;
              ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.f.c.a.yhj));
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
  
  public final void dGb()
  {
    AppMethodBeat.i(120293);
    if (!((Collection)this.yxc).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ON(0);
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
    dGa();
    AppMethodBeat.o(120297);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(120290);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.kGt = str;
    if (!this.yxe)
    {
      paramString = com.tencent.mm.kernel.g.afA();
      d.g.b.k.g(paramString, "MMKernel.network()");
      paramString.aeS().a(273, (com.tencent.mm.al.g)this);
      this.yxe = true;
    }
    AppMethodBeat.o(120290);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120296);
    d.g.b.k.h(paramViewGroup, "parent");
    if (this.ttN == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
      localViewGroup.removeAllViews();
      this.mView.setId(2131305937);
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
      localViewGroup.addView(this.mView, localLayoutParams);
      this.ttN = paramViewGroup;
    }
    paramViewGroup = this.ttN;
    if (paramViewGroup == null) {
      d.g.b.k.fvU();
    }
    AppMethodBeat.o(120296);
    return paramViewGroup;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(120294);
    this.yxd = null;
    b localb = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.aeS().b(273, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(120294);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(120295);
    if ((paramn instanceof i))
    {
      paramInt2 = ((i)paramn).dep;
      paramString = com.tencent.mm.plugin.story.i.a.yor;
      if ((paramInt2 == com.tencent.mm.plugin.story.i.a.dKk()) && (bt.kU(((i)paramn).userName, this.kGt)) && (paramInt1 == 0)) {
        dGa();
      }
    }
    AppMethodBeat.o(120295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryPreference
 * JD-Core Version:    0.7.0.1
 */