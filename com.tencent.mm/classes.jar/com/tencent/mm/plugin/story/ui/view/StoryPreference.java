package com.tencent.mm.plugin.story.ui.view;

import a.l;
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
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.AbsStoryPreference;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.api.o.b;
import com.tencent.mm.plugin.story.e.b.a;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.n;
import com.tencent.mm.plugin.story.ui.StoryBrowseUI;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.aj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/StoryPreference;", "Lcom/tencent/mm/plugin/story/api/AbsStoryPreference;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isAddedSceneListener", "", "mCallback", "Lcom/tencent/mm/plugin/story/api/ILoadFavStoryCallback;", "mCoverView", "Landroid/view/View;", "mStoryFavList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "mStoryIconView1", "Landroid/widget/ImageView;", "mStoryIconView2", "mStoryIconView3", "mStoryView1", "Lcom/tencent/mm/plugin/story/ui/view/StoryRoundImageView;", "mStoryView2", "mStoryView3", "mStoryViewGroup1", "Landroid/view/ViewGroup;", "mStoryViewGroup2", "mStoryViewGroup3", "mTitleView", "Landroid/widget/TextView;", "mUsername", "", "mView", "getDateList", "", "goFavGallery", "", "position", "handleEvent", "loadStory", "onBindView", "view", "onCreate", "username", "onCreateView", "parent", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setLoadCallback", "callback", "updateFavStory", "plugin-story_release"})
public final class StoryPreference
  extends AbsStoryPreference
  implements f
{
  private TextView Nx;
  private String ikj;
  private View mView;
  private View ozm;
  private StoryRoundImageView sNk;
  private StoryRoundImageView sNl;
  private StoryRoundImageView sNm;
  private ImageView sNn;
  private ImageView sNo;
  private ImageView sNp;
  private ViewGroup sNq;
  private ViewGroup sNr;
  private ViewGroup sNs;
  private ArrayList<com.tencent.mm.plugin.story.h.j> sNt;
  private com.tencent.mm.plugin.story.api.d sNu;
  private boolean sNv;
  
  public StoryPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(110463);
    AppMethodBeat.o(110463);
  }
  
  public StoryPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110464);
    paramContext = View.inflate(getContext(), 2130970969, null);
    a.f.b.j.p(paramContext, "View.inflate(context, R.…e_fav_panel_layout, null)");
    this.mView = paramContext;
    this.sNt = new ArrayList();
    this.ikj = "";
    paramContext = this.mView.findViewById(16908310);
    a.f.b.j.p(paramContext, "mView.findViewById(android.R.id.title)");
    this.Nx = ((TextView)paramContext);
    paramContext = this.mView.findViewById(2131828441);
    a.f.b.j.p(paramContext, "mView.findViewById(R.id.…eference_story_image_iv1)");
    this.sNk = ((StoryRoundImageView)paramContext);
    paramContext = this.mView.findViewById(2131828444);
    a.f.b.j.p(paramContext, "mView.findViewById(R.id.…eference_story_image_iv2)");
    this.sNl = ((StoryRoundImageView)paramContext);
    paramContext = this.mView.findViewById(2131828447);
    a.f.b.j.p(paramContext, "mView.findViewById(R.id.…eference_story_image_iv3)");
    this.sNm = ((StoryRoundImageView)paramContext);
    paramContext = this.mView.findViewById(2131828442);
    a.f.b.j.p(paramContext, "mView.findViewById(R.id.…erence_story_image_icon1)");
    this.sNn = ((ImageView)paramContext);
    paramContext = this.mView.findViewById(2131828445);
    a.f.b.j.p(paramContext, "mView.findViewById(R.id.…erence_story_image_icon2)");
    this.sNo = ((ImageView)paramContext);
    paramContext = this.mView.findViewById(2131828448);
    a.f.b.j.p(paramContext, "mView.findViewById(R.id.…erence_story_image_icon3)");
    this.sNp = ((ImageView)paramContext);
    paramContext = this.mView.findViewById(2131828440);
    a.f.b.j.p(paramContext, "mView.findViewById(R.id.…ce_story_image_iv1_group)");
    this.sNq = ((ViewGroup)paramContext);
    paramContext = this.mView.findViewById(2131828443);
    a.f.b.j.p(paramContext, "mView.findViewById(R.id.…ce_story_image_iv2_group)");
    this.sNr = ((ViewGroup)paramContext);
    paramContext = this.mView.findViewById(2131828446);
    a.f.b.j.p(paramContext, "mView.findViewById(R.id.…ce_story_image_iv3_group)");
    this.sNs = ((ViewGroup)paramContext);
    paramInt = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
    this.sNk.setRound(paramInt);
    this.sNl.setRound(paramInt);
    this.sNm.setRound(paramInt);
    paramContext = aj.g(getContext(), 2131231468, -1);
    this.sNn.setImageDrawable(paramContext);
    this.sNo.setImageDrawable(paramContext);
    this.sNp.setImageDrawable(paramContext);
    this.sNk.setOnClickListener((View.OnClickListener)new StoryPreference.1(this));
    this.sNl.setOnClickListener((View.OnClickListener)new StoryPreference.2(this));
    this.sNm.setOnClickListener((View.OnClickListener)new StoryPreference.3(this));
    AppMethodBeat.o(110464);
  }
  
  private final void Gf(int paramInt)
  {
    AppMethodBeat.i(110454);
    Object localObject = new ArrayList();
    Iterator localIterator = ((Iterable)this.sNt).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.story.h.j localj = (com.tencent.mm.plugin.story.h.j)localIterator.next();
      b.a locala = com.tencent.mm.plugin.story.e.b.ssx;
      ((ArrayList)localObject).add(b.a.i(Integer.valueOf(localj.field_createTime)));
    }
    localObject = (List)localObject;
    long l = o.sra.j((List)localObject, this.ikj);
    localObject = new Intent(getContext(), StoryBrowseUI.class);
    ((Intent)localObject).putExtra("username", this.ikj);
    ((Intent)localObject).putExtra("data_seed_key", l);
    ((Intent)localObject).putExtra("v_position", paramInt);
    ((Intent)localObject).putExtra("gallery_story_need_action", true);
    getContext().startActivity((Intent)localObject);
    localObject = i.sFa;
    i.cDo().cE(14L);
    AppMethodBeat.o(110454);
  }
  
  public final void a(com.tencent.mm.plugin.story.api.d paramd)
  {
    this.sNu = paramd;
  }
  
  public final void czk()
  {
    AppMethodBeat.i(110456);
    Object localObject1 = n.svx;
    localObject1 = this.ikj;
    a.f.b.j.q(localObject1, "username");
    Object localObject2 = g.RK();
    a.f.b.j.p(localObject2, "MMKernel.network()");
    localObject2 = ((com.tencent.mm.kernel.b)localObject2).Rc();
    Object localObject3 = com.tencent.mm.plugin.story.model.j.svi;
    boolean bool = bo.isEqual((String)localObject1, j.b.coK());
    localObject3 = com.tencent.mm.plugin.story.h.a.sFV;
    ((p)localObject2).b((m)new com.tencent.mm.plugin.story.model.a.j((String)localObject1, 0L, bool, "", com.tencent.mm.plugin.story.h.a.cEv()));
    AppMethodBeat.o(110456);
  }
  
  public final void czl()
  {
    int j = 1;
    int k = 1;
    AppMethodBeat.i(110457);
    Object localObject1 = this.Nx.getLayoutParams();
    if (localObject1 != null) {
      ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cb.a.ao(getContext(), 2131427664);
    }
    this.Nx.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.sNt.clear();
    localObject1 = this.sNt;
    Object localObject2 = com.tencent.mm.plugin.story.model.j.svi;
    localObject2 = j.b.cAB();
    Object localObject3 = this.ikj;
    Object localObject4 = this.ikj;
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    ((ArrayList)localObject1).addAll((Collection)((k)localObject2).a((String)localObject3, bo.isEqual((String)localObject4, j.b.coK()), 0L, 20));
    this.sNq.setVisibility(8);
    this.sNr.setVisibility(8);
    this.sNs.setVisibility(8);
    int i;
    if (!((Collection)this.sNt).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label444;
      }
      localObject1 = this.Nx;
      localObject2 = getContext();
      a.f.b.j.p(localObject2, "context");
      ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(2131298814));
      label201:
      if (this.sNt.size() != 1) {
        break label464;
      }
      this.Nx.setVisibility(0);
      this.sNq.setVisibility(0);
      localObject2 = ((com.tencent.mm.plugin.story.h.j)this.sNt.get(0)).cEY().xSK;
      if (localObject2 != null)
      {
        localObject1 = ((chb)localObject2).wOa;
        a.f.b.j.p(localObject1, "obj.MediaObjList");
        if (((Collection)localObject1).isEmpty()) {
          break label459;
        }
        i = k;
        label282:
        if (i != 0)
        {
          localObject1 = com.tencent.mm.plugin.story.model.j.svi;
          localObject1 = j.b.cAK();
          localObject2 = ((chb)localObject2).wOa.get(0);
          a.f.b.j.p(localObject2, "obj.MediaObjList[0]");
          localObject2 = (chl)localObject2;
          localObject3 = ((com.tencent.mm.plugin.story.h.j)this.sNt.get(0)).field_userName;
          localObject4 = az.yNY;
          a.f.b.j.p(localObject4, "FROM_SCENE.storyalbum");
          localObject2 = new com.tencent.mm.plugin.story.model.c.d((chl)localObject2, (String)localObject3, (az)localObject4);
          localObject3 = this.sNk;
          if (localObject3 == null) {
            a.f.b.j.ebi();
          }
          localObject3 = (ImageView)localObject3;
          localObject4 = com.tencent.mm.plugin.story.model.j.svi;
          ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.model.c.a.sxZ));
        }
      }
    }
    label444:
    label967:
    for (;;)
    {
      localObject1 = this.sNu;
      if (localObject1 == null) {
        break label1468;
      }
      ((com.tencent.mm.plugin.story.api.d)localObject1).cy((List)this.sNt);
      AppMethodBeat.o(110457);
      return;
      i = 0;
      break;
      this.Nx.setText((CharSequence)"");
      break label201;
      label459:
      i = 0;
      break label282;
      label464:
      if (this.sNt.size() == 2)
      {
        this.Nx.setVisibility(0);
        this.sNq.setVisibility(0);
        this.sNr.setVisibility(0);
        localObject2 = ((com.tencent.mm.plugin.story.h.j)this.sNt.get(0)).cEY().xSK;
        if (localObject2 != null)
        {
          localObject1 = ((chb)localObject2).wOa;
          a.f.b.j.p(localObject1, "obj1.MediaObjList");
          if (((Collection)localObject1).isEmpty()) {
            break label860;
          }
          i = 1;
          if (i != 0)
          {
            localObject1 = com.tencent.mm.plugin.story.model.j.svi;
            localObject1 = j.b.cAK();
            localObject2 = ((chb)localObject2).wOa.get(0);
            a.f.b.j.p(localObject2, "obj1.MediaObjList[0]");
            localObject2 = (chl)localObject2;
            localObject3 = ((com.tencent.mm.plugin.story.h.j)this.sNt.get(0)).field_userName;
            localObject4 = az.yNY;
            a.f.b.j.p(localObject4, "FROM_SCENE.storyalbum");
            localObject2 = new com.tencent.mm.plugin.story.model.c.d((chl)localObject2, (String)localObject3, (az)localObject4);
            localObject3 = this.sNk;
            if (localObject3 == null) {
              a.f.b.j.ebi();
            }
            localObject3 = (ImageView)localObject3;
            localObject4 = com.tencent.mm.plugin.story.model.j.svi;
            ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.model.c.a.sxZ));
          }
        }
        localObject2 = ((com.tencent.mm.plugin.story.h.j)this.sNt.get(1)).cEY().xSK;
        if (localObject2 != null)
        {
          localObject1 = ((chb)localObject2).wOa;
          a.f.b.j.p(localObject1, "obj2.MediaObjList");
          if (!((Collection)localObject1).isEmpty()) {}
          for (i = j;; i = 0)
          {
            if (i == 0) {
              break label868;
            }
            localObject1 = com.tencent.mm.plugin.story.model.j.svi;
            localObject1 = j.b.cAK();
            localObject2 = ((chb)localObject2).wOa.get(0);
            a.f.b.j.p(localObject2, "obj2.MediaObjList[0]");
            localObject2 = (chl)localObject2;
            localObject3 = ((com.tencent.mm.plugin.story.h.j)this.sNt.get(0)).field_userName;
            localObject4 = az.yNY;
            a.f.b.j.p(localObject4, "FROM_SCENE.storyalbum");
            localObject2 = new com.tencent.mm.plugin.story.model.c.d((chl)localObject2, (String)localObject3, (az)localObject4);
            localObject3 = this.sNl;
            if (localObject3 == null) {
              a.f.b.j.ebi();
            }
            localObject3 = (ImageView)localObject3;
            localObject4 = com.tencent.mm.plugin.story.model.j.svi;
            ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.model.c.a.sxZ));
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
        if (this.sNt.size() >= 3)
        {
          this.Nx.setVisibility(0);
          this.sNq.setVisibility(0);
          this.sNr.setVisibility(0);
          this.sNs.setVisibility(0);
          localObject2 = ((com.tencent.mm.plugin.story.h.j)this.sNt.get(0)).cEY().xSK;
          if (localObject2 != null)
          {
            localObject1 = ((chb)localObject2).wOa;
            a.f.b.j.p(localObject1, "obj1.MediaObjList");
            if (((Collection)localObject1).isEmpty()) {
              break label1453;
            }
            i = 1;
            if (i != 0)
            {
              localObject1 = com.tencent.mm.plugin.story.model.j.svi;
              localObject1 = j.b.cAK();
              localObject2 = ((chb)localObject2).wOa.get(0);
              a.f.b.j.p(localObject2, "obj1.MediaObjList[0]");
              localObject2 = (chl)localObject2;
              localObject3 = ((com.tencent.mm.plugin.story.h.j)this.sNt.get(0)).field_userName;
              localObject4 = az.yNY;
              a.f.b.j.p(localObject4, "FROM_SCENE.storyalbum");
              localObject2 = new com.tencent.mm.plugin.story.model.c.d((chl)localObject2, (String)localObject3, (az)localObject4);
              localObject3 = this.sNk;
              if (localObject3 == null) {
                a.f.b.j.ebi();
              }
              localObject3 = (ImageView)localObject3;
              localObject4 = com.tencent.mm.plugin.story.model.j.svi;
              ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.model.c.a.sxZ));
            }
          }
          localObject2 = ((com.tencent.mm.plugin.story.h.j)this.sNt.get(1)).cEY().xSK;
          if (localObject2 != null)
          {
            localObject1 = ((chb)localObject2).wOa;
            a.f.b.j.p(localObject1, "obj2.MediaObjList");
            if (((Collection)localObject1).isEmpty()) {
              break label1458;
            }
            i = 1;
            label1146:
            if (i != 0)
            {
              localObject1 = com.tencent.mm.plugin.story.model.j.svi;
              localObject1 = j.b.cAK();
              localObject2 = ((chb)localObject2).wOa.get(0);
              a.f.b.j.p(localObject2, "obj2.MediaObjList[0]");
              localObject2 = (chl)localObject2;
              localObject3 = ((com.tencent.mm.plugin.story.h.j)this.sNt.get(0)).field_userName;
              localObject4 = az.yNY;
              a.f.b.j.p(localObject4, "FROM_SCENE.storyalbum");
              localObject2 = new com.tencent.mm.plugin.story.model.c.d((chl)localObject2, (String)localObject3, (az)localObject4);
              localObject3 = this.sNl;
              if (localObject3 == null) {
                a.f.b.j.ebi();
              }
              localObject3 = (ImageView)localObject3;
              localObject4 = com.tencent.mm.plugin.story.model.j.svi;
              ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.model.c.a.sxZ));
            }
          }
          localObject2 = ((com.tencent.mm.plugin.story.h.j)this.sNt.get(2)).cEY().xSK;
          if (localObject2 != null)
          {
            localObject1 = ((chb)localObject2).wOa;
            a.f.b.j.p(localObject1, "obj3.MediaObjList");
            if (!((Collection)localObject1).isEmpty()) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label1466;
              }
              localObject1 = com.tencent.mm.plugin.story.model.j.svi;
              localObject1 = j.b.cAK();
              localObject2 = ((chb)localObject2).wOa.get(0);
              a.f.b.j.p(localObject2, "obj3.MediaObjList[0]");
              localObject2 = (chl)localObject2;
              localObject3 = ((com.tencent.mm.plugin.story.h.j)this.sNt.get(0)).field_userName;
              localObject4 = az.yNY;
              a.f.b.j.p(localObject4, "FROM_SCENE.storyalbum");
              localObject2 = new com.tencent.mm.plugin.story.model.c.d((chl)localObject2, (String)localObject3, (az)localObject4);
              localObject3 = this.sNm;
              if (localObject3 == null) {
                a.f.b.j.ebi();
              }
              localObject3 = (ImageView)localObject3;
              localObject4 = com.tencent.mm.plugin.story.model.j.svi;
              ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, j.b.a(com.tencent.mm.plugin.story.model.c.a.sxZ));
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
    AppMethodBeat.o(110457);
  }
  
  public final void czm()
  {
    AppMethodBeat.i(110458);
    if (!((Collection)this.sNt).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        Gf(0);
      }
      AppMethodBeat.o(110458);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(110462);
    a.f.b.j.q(paramView, "view");
    super.onBindView(paramView);
    czl();
    AppMethodBeat.o(110462);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(110455);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.ikj = str;
    if (!this.sNv)
    {
      paramString = g.RK();
      a.f.b.j.p(paramString, "MMKernel.network()");
      paramString.Rc().a(273, (f)this);
      this.sNv = true;
    }
    AppMethodBeat.o(110455);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(110461);
    a.f.b.j.q(paramViewGroup, "parent");
    if (this.ozm == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
      localViewGroup.removeAllViews();
      this.mView.setId(2131820997);
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
      localViewGroup.addView(this.mView, localLayoutParams);
      this.ozm = paramViewGroup;
    }
    paramViewGroup = this.ozm;
    if (paramViewGroup == null) {
      a.f.b.j.ebi();
    }
    AppMethodBeat.o(110461);
    return paramViewGroup;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(110459);
    this.sNu = null;
    com.tencent.mm.kernel.b localb = g.RK();
    a.f.b.j.p(localb, "MMKernel.network()");
    localb.Rc().b(273, (f)this);
    AppMethodBeat.o(110459);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(110460);
    if ((paramm instanceof com.tencent.mm.plugin.story.model.a.j))
    {
      paramInt2 = ((com.tencent.mm.plugin.story.model.a.j)paramm).cpt;
      paramString = com.tencent.mm.plugin.story.h.a.sFV;
      if ((paramInt2 == com.tencent.mm.plugin.story.h.a.cEv()) && (bo.isEqual(((com.tencent.mm.plugin.story.model.a.j)paramm).userName, this.ikj)) && (paramInt1 == 0)) {
        czl();
      }
    }
    AppMethodBeat.o(110460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryPreference
 * JD-Core Version:    0.7.0.1
 */