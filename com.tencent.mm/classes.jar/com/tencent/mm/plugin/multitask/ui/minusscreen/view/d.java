package com.tencent.mm.plugin.multitask.ui.minusscreen.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.loader.b.e;
import com.tencent.mm.loader.b.e.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.multitask.h;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.e.b;
import com.tencent.mm.plugin.multitask.ui.e.c;
import com.tencent.mm.plugin.multitask.ui.minusscreen.a.a;
import com.tencent.mm.plugin.multitask.ui.uic.c;
import com.tencent.mm.plugin.multitask.ui.uic.c.a;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "layoutResId", "", "listener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "(ILcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;)V", "MAX_NAME_COUNT", "getMAX_NAME_COUNT", "()I", "TAG", "", "thumbLoaderOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getThumbLoaderOption", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getLayoutId", "getNickName", "context", "Landroid/content/Context;", "item", "getTimeShowString", "time", "loadImage", "", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "imgView", "Landroid/widget/ImageView;", "defaultImgView", "defaultBgContainer", "Landroid/view/View;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "makeTimeString", "d", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "useBottomGradient", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d
  extends f<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a>
{
  private final int AKn;
  private final int AKy;
  private com.tencent.mm.plugin.multitask.ui.minusscreen.d.a LGe;
  private final e LGf;
  private final String TAG;
  
  public d(int paramInt, com.tencent.mm.plugin.multitask.ui.minusscreen.d.a parama)
  {
    this.AKy = paramInt;
    this.LGe = parama;
    this.TAG = "MicroMsg.MultiTask.MinusScreenRoundCornerConvert";
    parama = new e.a();
    parama.nqd = true;
    parama.nqc = true;
    this.LGf = parama.blI();
    this.AKn = 5;
  }
  
  public static String Be(int paramInt)
  {
    return Bf(paramInt / 60) + ':' + Bf(paramInt % 60);
  }
  
  private static String Bf(int paramInt)
  {
    if (paramInt < 10) {
      return s.X("0", Integer.valueOf(paramInt));
    }
    return String.valueOf(paramInt);
  }
  
  private static final void a(d paramd, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama, j paramj, View paramView)
  {
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramd);
    localb.cH(parama);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    s.u(parama, "$item");
    s.u(paramj, "$holder");
    paramd = paramd.LGe;
    if (paramd != null) {
      paramd.a(parama, paramj);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private static final void a(final d paramd, final j paramj, String paramString1, final ImageView paramImageView1, MultiTaskInfo paramMultiTaskInfo, final ImageView paramImageView2, final View paramView1, String paramString2, View paramView2, final Bitmap paramBitmap, Object[] paramArrayOfObject)
  {
    s.u(paramd, "this$0");
    s.u(paramj, "$holder");
    s.u(paramString1, "$srcImgPath");
    s.u(paramImageView1, "$imgView");
    s.u(paramMultiTaskInfo, "$multiTaskInfo");
    s.u(paramImageView2, "$defaultImgView");
    s.u(paramView1, "$defaultBgContainer");
    label118:
    int i;
    if ((paramView2 instanceof ImageView))
    {
      paramString2 = (ImageView)paramView2;
      if ((paramString2 == null) || (paramBitmap == null)) {
        break label271;
      }
      Log.i(paramd.TAG, "loadImage callback " + paramString2.hashCode() + ' ' + paramBitmap);
      paramd = paramj.getRecyclerView();
      if (paramd != null) {
        break label249;
      }
      paramd = null;
      if (!(paramd instanceof GridLayoutManager)) {
        break label257;
      }
      paramd = (GridLayoutManager)paramd;
      label130:
      if (paramd != null) {
        break label262;
      }
      i = 1;
      label137:
      paramd = com.tencent.mm.plugin.multitask.ui.minusscreen.a.LFz;
      int j = a.a.gkL();
      float f = (aw.getDeviceWidth() - j * (i + 1)) / (i * paramBitmap.getWidth());
      paramd = new Matrix();
      paramd.setScale(f, f);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(paramString2, paramd, paramBitmap));
    }
    label257:
    label262:
    label271:
    for (paramd = ah.aiuX;; paramd = null)
    {
      if (paramd == null)
      {
        r.bKe().a(paramString1, paramImageView1);
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(paramMultiTaskInfo, paramImageView2, paramImageView1, paramView1, paramj));
      }
      return;
      paramString2 = null;
      break;
      label249:
      paramd = paramd.getLayoutManager();
      break label118;
      paramd = null;
      break label130;
      i = paramd.bWl;
      break label137;
    }
  }
  
  public String a(Context paramContext, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama)
  {
    s.u(paramContext, "context");
    s.u(parama, "item");
    return parama.LGa.gkh().nickname;
  }
  
  public void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
  }
  
  public void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramRecyclerView = paramRecyclerView.getAdapter();
    if (paramRecyclerView == null)
    {
      paramInt = 0;
      Log.i(this.TAG, "onCreateViewHolder itemCount:" + paramInt + ", layoutPosition:" + paramj.KI());
      if (paramInt != 2) {
        break label194;
      }
      paramRecyclerView = paramj.caK.findViewById(e.c.LDI);
      if (paramRecyclerView != null)
      {
        localObject = c.LHl;
        paramRecyclerView.setTranslationX(c.gly());
        localObject = c.LHl;
        paramRecyclerView.setTranslationY(c.glx());
        localObject = paramRecyclerView.getLayoutParams();
        locala = c.LHl;
        ((ViewGroup.LayoutParams)localObject).height = c.gls();
        localObject = paramRecyclerView.getLayoutParams();
        locala = c.LHl;
        ((ViewGroup.LayoutParams)localObject).width = c.glr();
        paramj = (RoundedCornerFrameLayout)paramj.caK.findViewById(e.c.multi_task_item_bg);
        if (paramj != null)
        {
          paramj = paramj.getLayoutParams();
          localObject = c.LHl;
          paramj.height = c.glw();
        }
        paramRecyclerView.requestLayout();
      }
    }
    label194:
    do
    {
      do
      {
        do
        {
          return;
          paramInt = paramRecyclerView.getItemCount();
          break;
          if (paramInt != 3) {
            break label305;
          }
          paramRecyclerView = paramj.caK.findViewById(e.c.LDI);
        } while (paramRecyclerView == null);
        localObject = c.LHl;
        paramRecyclerView.setTranslationY(c.glA());
        localObject = paramRecyclerView.getLayoutParams();
        locala = c.LHl;
        ((ViewGroup.LayoutParams)localObject).height = c.glq();
        localObject = paramRecyclerView.getLayoutParams();
        locala = c.LHl;
        ((ViewGroup.LayoutParams)localObject).width = c.glp();
        paramj = (RoundedCornerFrameLayout)paramj.caK.findViewById(e.c.multi_task_item_bg);
        if (paramj != null)
        {
          paramj = paramj.getLayoutParams();
          localObject = c.LHl;
          paramj.height = c.glu();
        }
        paramRecyclerView.requestLayout();
        return;
      } while (paramInt < 4);
      paramRecyclerView = paramj.caK.findViewById(e.c.LDI);
    } while (paramRecyclerView == null);
    label305:
    Object localObject = paramRecyclerView.getLayoutParams();
    c.a locala = c.LHl;
    ((ViewGroup.LayoutParams)localObject).height = c.glq();
    localObject = paramRecyclerView.getLayoutParams();
    locala = c.LHl;
    ((ViewGroup.LayoutParams)localObject).width = c.glp();
    paramj = (RoundedCornerFrameLayout)paramj.caK.findViewById(e.c.multi_task_item_bg);
    if (paramj != null)
    {
      paramj = paramj.getLayoutParams();
      localObject = c.LHl;
      paramj.height = c.glu();
    }
    paramRecyclerView.requestLayout();
  }
  
  public void a(j paramj, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    s.u(paramj, "holder");
    s.u(parama, "item");
    Log.d(this.TAG, s.X("onBindViewHolder, position:", Integer.valueOf(paramInt1)));
    Object localObject3 = paramj.caK.findViewById(e.c.LEa);
    Object localObject6 = (TextView)paramj.caK.findViewById(e.c.LDX);
    TextView localTextView = (TextView)paramj.caK.findViewById(e.c.LDZ);
    paramList = (MMImageView)paramj.caK.findViewById(e.c.LEb);
    Object localObject4 = (MinusScreenRoundFrameLayout)paramj.caK.findViewById(e.c.LDP);
    Object localObject5 = (TextView)paramj.caK.findViewById(e.c.LDY);
    Object localObject1 = (RoundedCornerFrameLayout)paramj.caK.findViewById(e.c.multi_task_item_bg);
    Object localObject2 = (WeImageView)paramj.caK.findViewById(e.c.LDU);
    Object localObject7 = (ImageView)paramj.UH(e.c.LDT);
    if (localObject7 != null) {
      ((ImageView)localObject7).setOnClickListener(new d..ExternalSyntheticLambda0(this, parama, paramj));
    }
    localObject7 = paramj.context;
    s.s(localObject7, "holder.context");
    ((TextView)localObject6).setText((CharSequence)a((Context)localObject7, parama));
    if (Util.isNullOrNil(parama.LGa.gkh().title))
    {
      localTextView.setVisibility(8);
      localObject6 = ((View)localObject3).getLayoutParams();
      if (localObject6 == null) {
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject6 = (ViewGroup.MarginLayoutParams)localObject6;
      ((ViewGroup.MarginLayoutParams)localObject6).topMargin = bd.fromDPToPix(paramj.context, 16);
      ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject6);
      if (Util.isNullOrNil(parama.LGa.gkh().tag)) {
        break label572;
      }
      ((TextView)localObject5).setText((CharSequence)parama.LGa.gkh().tag);
      ((TextView)localObject5).setVisibility(0);
      label326:
      ((MinusScreenRoundFrameLayout)localObject4).setUseBottomGradient(gkP());
      if (!parama.LGa.gkh().aaXR) {
        break label582;
      }
      ((WeImageView)localObject2).setVisibility(0);
      paramList.setVisibility(8);
      ((RoundedCornerFrameLayout)localObject1).setBackgroundColor(paramj.context.getResources().getColor(e.b.multi_task_item_bg));
      localObject1 = com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.LGc;
      ((WeImageView)localObject2).setImageResource(com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.acv(parama.LGa.field_type));
      localObject1 = h.LBd;
      localObject1 = h.g(parama.LGa);
      r.bKe().a((String)localObject1, (ImageView)paramList);
    }
    for (;;)
    {
      paramList = (ImageView)paramj.UH(e.c.LDT);
      if (paramList != null) {
        paramList.setTag(e.c.LEc, Integer.valueOf(parama.LGa.field_type));
      }
      paramj = paramj.UH(e.c.LDI);
      if (paramj != null) {
        paramj.setTag(e.c.LEd, Integer.valueOf(parama.LGa.field_type));
      }
      return;
      localTextView.setVisibility(0);
      localTextView.setText((CharSequence)parama.LGa.gkh().title);
      localObject6 = ((View)localObject3).getLayoutParams();
      if (localObject6 == null) {
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject6 = (ViewGroup.MarginLayoutParams)localObject6;
      ((ViewGroup.MarginLayoutParams)localObject6).topMargin = bd.fromDPToPix(paramj.context, 6);
      ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject6);
      break;
      label572:
      ((TextView)localObject5).setVisibility(8);
      break label326;
      label582:
      ((WeImageView)localObject2).setVisibility(8);
      paramList.setVisibility(0);
      ((RoundedCornerFrameLayout)localObject1).setBackgroundColor(0);
      localObject3 = parama.LGa;
      s.s(paramList, "imgView");
      paramList = (ImageView)paramList;
      s.s(localObject2, "defaultBgView");
      localObject2 = (ImageView)localObject2;
      s.s(localObject1, "defaultBgContainer");
      localObject1 = (View)localObject1;
      s.u(localObject3, "multiTaskInfo");
      s.u(paramList, "imgView");
      s.u(localObject2, "defaultImgView");
      s.u(localObject1, "defaultBgContainer");
      s.u(paramj, "holder");
      localObject4 = h.LBd;
      localObject4 = h.g((MultiTaskInfo)localObject3);
      localObject5 = r.bKe();
      localObject6 = h.LBd;
      ((com.tencent.mm.modelimage.loader.a)localObject5).a((String)localObject4, paramList, h.gju(), new d..ExternalSyntheticLambda1(this, paramj, (String)localObject4, paramList, (MultiTaskInfo)localObject3, (ImageView)localObject2, (View)localObject1));
    }
  }
  
  public final int getLayoutId()
  {
    return this.AKy;
  }
  
  protected final e getThumbLoaderOption()
  {
    return this.LGf;
  }
  
  public final int gkO()
  {
    return this.AKn;
  }
  
  public boolean gkP()
  {
    return false;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(ImageView paramImageView, Matrix paramMatrix, Bitmap paramBitmap)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(MultiTaskInfo paramMultiTaskInfo, ImageView paramImageView1, ImageView paramImageView2, View paramView, j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.view.d
 * JD-Core Version:    0.7.0.1
 */