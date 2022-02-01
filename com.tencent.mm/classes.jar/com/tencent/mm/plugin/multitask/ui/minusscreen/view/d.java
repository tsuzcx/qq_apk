package com.tencent.mm.plugin.multitask.ui.minusscreen.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.k;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.minusscreen.a.a;
import com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC;
import com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC.a;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "layoutResId", "", "listener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "(ILcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;)V", "MAX_NAME_COUNT", "getMAX_NAME_COUNT", "()I", "TAG", "", "thumbLoaderOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getThumbLoaderOption", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getLayoutId", "getNickName", "context", "Landroid/content/Context;", "item", "getTimeShowString", "time", "loadImage", "", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "imgView", "Landroid/widget/ImageView;", "defaultImgView", "defaultBgContainer", "Landroid/view/View;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "makeTimeString", "d", "onAttachedToRecyclerView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "useBottomGradient", "ui-multitask_release"})
public abstract class d
  extends com.tencent.mm.view.recyclerview.e<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a>
{
  final com.tencent.mm.loader.c.e Aer;
  com.tencent.mm.plugin.multitask.ui.minusscreen.d.a Aes;
  final String TAG;
  private final int tDB = 2131495492;
  final int tDx;
  
  public d(com.tencent.mm.plugin.multitask.ui.minusscreen.d.a parama)
  {
    this.Aes = parama;
    this.TAG = "MicroMsg.MultiTask.MinusScreenRoundCornerConvert";
    parama = new e.a();
    parama.hZJ = true;
    parama.hZI = true;
    this.Aer = parama.aJT();
    this.tDx = 5;
  }
  
  static String xt(int paramInt)
  {
    if (paramInt < 10) {
      return "0".concat(String.valueOf(paramInt));
    }
    return String.valueOf(paramInt);
  }
  
  public String a(Context paramContext, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama)
  {
    p.h(paramContext, "context");
    p.h(parama, "item");
    return parama.Aen.erh().nickname;
  }
  
  public void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
  }
  
  public void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.h paramh, int paramInt)
  {
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    paramRecyclerView = paramRecyclerView.getAdapter();
    if (paramRecyclerView != null)
    {
      paramInt = paramRecyclerView.getItemCount();
      Log.i(this.TAG, "onCreateViewHolder itemCount:" + paramInt + ", layoutPosition:" + paramh.lQ());
      if (paramInt != 2) {
        break label188;
      }
      paramRecyclerView = paramh.aus.findViewById(2131302800);
      if (paramRecyclerView != null)
      {
        localObject = MultiTaskUIC.Ago;
        paramRecyclerView.setTranslationX(MultiTaskUIC.esn());
        localObject = MultiTaskUIC.Ago;
        paramRecyclerView.setTranslationY(MultiTaskUIC.esm());
        localObject = paramRecyclerView.getLayoutParams();
        locala = MultiTaskUIC.Ago;
        ((ViewGroup.LayoutParams)localObject).height = MultiTaskUIC.esh();
        localObject = paramRecyclerView.getLayoutParams();
        locala = MultiTaskUIC.Ago;
        ((ViewGroup.LayoutParams)localObject).width = MultiTaskUIC.esg();
        paramh = (RoundedCornerFrameLayout)paramh.aus.findViewById(2131305006);
        if (paramh != null)
        {
          paramh = paramh.getLayoutParams();
          localObject = MultiTaskUIC.Ago;
          paramh.height = MultiTaskUIC.esl();
        }
        paramRecyclerView.requestLayout();
      }
    }
    label188:
    do
    {
      do
      {
        do
        {
          return;
          paramInt = 0;
          break;
          if (paramInt != 3) {
            break label297;
          }
          paramRecyclerView = paramh.aus.findViewById(2131302800);
        } while (paramRecyclerView == null);
        localObject = MultiTaskUIC.Ago;
        paramRecyclerView.setTranslationY(MultiTaskUIC.esp());
        localObject = paramRecyclerView.getLayoutParams();
        locala = MultiTaskUIC.Ago;
        ((ViewGroup.LayoutParams)localObject).height = MultiTaskUIC.esf();
        localObject = paramRecyclerView.getLayoutParams();
        locala = MultiTaskUIC.Ago;
        ((ViewGroup.LayoutParams)localObject).width = MultiTaskUIC.ese();
        paramh = (RoundedCornerFrameLayout)paramh.aus.findViewById(2131305006);
        if (paramh != null)
        {
          paramh = paramh.getLayoutParams();
          localObject = MultiTaskUIC.Ago;
          paramh.height = MultiTaskUIC.esj();
        }
        paramRecyclerView.requestLayout();
        return;
      } while (paramInt < 4);
      paramRecyclerView = paramh.aus.findViewById(2131302800);
    } while (paramRecyclerView == null);
    label297:
    Object localObject = paramRecyclerView.getLayoutParams();
    MultiTaskUIC.a locala = MultiTaskUIC.Ago;
    ((ViewGroup.LayoutParams)localObject).height = MultiTaskUIC.esf();
    localObject = paramRecyclerView.getLayoutParams();
    locala = MultiTaskUIC.Ago;
    ((ViewGroup.LayoutParams)localObject).width = MultiTaskUIC.ese();
    paramh = (RoundedCornerFrameLayout)paramh.aus.findViewById(2131305006);
    if (paramh != null)
    {
      paramh = paramh.getLayoutParams();
      localObject = MultiTaskUIC.Ago;
      paramh.height = MultiTaskUIC.esj();
    }
    paramRecyclerView.requestLayout();
  }
  
  public void a(final com.tencent.mm.view.recyclerview.h paramh, final com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama, int paramInt1, int paramInt2, boolean paramBoolean, final List<Object> paramList)
  {
    p.h(paramh, "holder");
    p.h(parama, "item");
    Log.d(this.TAG, "onBindViewHolder, position:".concat(String.valueOf(paramInt1)));
    Object localObject3 = paramh.aus.findViewById(2131305015);
    Object localObject6 = (TextView)paramh.aus.findViewById(2131305012);
    TextView localTextView = (TextView)paramh.aus.findViewById(2131305014);
    paramList = (MMImageView)paramh.aus.findViewById(2131305017);
    Object localObject4 = (MinusScreenRoundFrameLayout)paramh.aus.findViewById(2131305003);
    Object localObject5 = (TextView)paramh.aus.findViewById(2131305013);
    Object localObject1 = (RoundedCornerFrameLayout)paramh.aus.findViewById(2131305006);
    Object localObject2 = (WeImageView)paramh.aus.findViewById(2131305009);
    Object localObject7 = (ImageView)paramh.Mn(2131305008);
    if (localObject7 != null) {
      ((ImageView)localObject7).setOnClickListener((View.OnClickListener)new b(this, parama, paramh));
    }
    localObject7 = paramh.getContext();
    p.g(localObject7, "holder.context");
    ((TextView)localObject6).setText((CharSequence)a((Context)localObject7, parama));
    if (Util.isNullOrNil(parama.Aen.erh().title))
    {
      p.g(localTextView, "title");
      localTextView.setVisibility(8);
      p.g(localObject3, "tagContainerView");
      localObject6 = ((View)localObject3).getLayoutParams();
      if (localObject6 == null) {
        throw new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject6 = (ViewGroup.MarginLayoutParams)localObject6;
      ((ViewGroup.MarginLayoutParams)localObject6).topMargin = at.fromDPToPix(paramh.getContext(), 16);
      ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject6);
      if (Util.isNullOrNil(parama.Aen.erh().tag)) {
        break label569;
      }
      ((TextView)localObject5).setText((CharSequence)parama.Aen.erh().tag);
      p.g(localObject5, "tagView");
      ((TextView)localObject5).setVisibility(0);
    }
    for (;;)
    {
      ((MinusScreenRoundFrameLayout)localObject4).setUseBottomGradient(erF());
      if (!parama.Aen.erh().MwT) {
        break label587;
      }
      p.g(localObject2, "defaultBgView");
      ((WeImageView)localObject2).setVisibility(0);
      p.g(paramList, "imgView");
      paramList.setVisibility(8);
      paramh = paramh.getContext();
      p.g(paramh, "holder.context");
      ((RoundedCornerFrameLayout)localObject1).setBackgroundColor(paramh.getResources().getColor(2131100853));
      paramh = com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.Aep;
      ((WeImageView)localObject2).setImageResource(com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.RR(parama.Aen.field_type));
      paramh = com.tencent.mm.plugin.multitask.h.zZn;
      paramh = com.tencent.mm.plugin.multitask.h.g(parama.Aen);
      com.tencent.mm.av.q.bcV().a(paramh, (ImageView)paramList);
      return;
      p.g(localTextView, "title");
      localTextView.setVisibility(0);
      localTextView.setText((CharSequence)parama.Aen.erh().title);
      p.g(localObject3, "tagContainerView");
      localObject6 = ((View)localObject3).getLayoutParams();
      if (localObject6 == null) {
        throw new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject6 = (ViewGroup.MarginLayoutParams)localObject6;
      ((ViewGroup.MarginLayoutParams)localObject6).topMargin = at.fromDPToPix(paramh.getContext(), 6);
      ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject6);
      break;
      label569:
      p.g(localObject5, "tagView");
      ((TextView)localObject5).setVisibility(8);
    }
    label587:
    p.g(localObject2, "defaultBgView");
    ((WeImageView)localObject2).setVisibility(8);
    p.g(paramList, "imgView");
    paramList.setVisibility(0);
    ((RoundedCornerFrameLayout)localObject1).setBackgroundColor(0);
    parama = parama.Aen;
    paramList = (ImageView)paramList;
    localObject2 = (ImageView)localObject2;
    p.g(localObject1, "defaultBgContainer");
    localObject1 = (View)localObject1;
    p.h(parama, "multiTaskInfo");
    p.h(paramList, "imgView");
    p.h(localObject2, "defaultImgView");
    p.h(localObject1, "defaultBgContainer");
    p.h(paramh, "holder");
    localObject3 = com.tencent.mm.plugin.multitask.h.zZn;
    localObject3 = com.tencent.mm.plugin.multitask.h.g(parama);
    localObject4 = com.tencent.mm.av.q.bcV();
    localObject5 = com.tencent.mm.plugin.multitask.h.zZn;
    ((com.tencent.mm.av.a.a)localObject4).a((String)localObject3, paramList, com.tencent.mm.plugin.multitask.h.eqz(), (k)new a(this, paramh, (String)localObject3, paramList, parama, (ImageView)localObject2, (View)localObject1));
  }
  
  public boolean erF()
  {
    return false;
  }
  
  public final int getLayoutId()
  {
    return this.tDB;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "url", "", "view", "Landroid/view/View;", "bitmap", "Landroid/graphics/Bitmap;", "extraObj", "", "", "onImageLoadComplete", "(Ljava/lang/String;Landroid/view/View;Landroid/graphics/Bitmap;[Ljava/lang/Object;)V"})
  static final class a
    implements k
  {
    a(d paramd, com.tencent.mm.view.recyclerview.h paramh, String paramString, ImageView paramImageView1, MultiTaskInfo paramMultiTaskInfo, ImageView paramImageView2, View paramView) {}
    
    public final void a(final String paramString, View paramView, final Bitmap paramBitmap, Object[] paramArrayOfObject)
    {
      Object localObject = null;
      paramArrayOfObject = null;
      AppMethodBeat.i(236526);
      if (!(paramView instanceof ImageView)) {}
      for (paramString = null;; paramString = paramView)
      {
        paramView = (ImageView)paramString;
        paramString = localObject;
        if (paramView != null)
        {
          paramString = localObject;
          if (paramBitmap != null)
          {
            Log.i(this.Aet.TAG, "loadImage callback " + paramView.hashCode() + ' ' + paramBitmap);
            paramString = paramh.getRecyclerView();
            if (paramString == null) {
              break label230;
            }
            paramString = paramString.getLayoutManager();
            if ((paramString instanceof GridLayoutManager)) {
              break label241;
            }
            paramString = paramArrayOfObject;
          }
        }
        label230:
        label241:
        for (;;)
        {
          paramString = (GridLayoutManager)paramString;
          if (paramString != null) {}
          for (int i = paramString.ki();; i = 1)
          {
            paramString = com.tencent.mm.plugin.multitask.ui.minusscreen.a.AdH;
            int j = a.a.erB();
            float f = (ao.getDeviceWidth() - j * (i + 1)) / (i * paramBitmap.getWidth());
            paramString = new Matrix();
            paramString.setScale(f, f);
            com.tencent.mm.ac.d.h((kotlin.g.a.a)new b(paramView, paramString, paramBitmap));
            paramString = x.SXb;
            if (paramString == null)
            {
              com.tencent.mm.av.q.bcV().a(this.Aeu, paramList);
              com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this));
              paramString = x.SXb;
            }
            AppMethodBeat.o(236526);
            return;
            paramString = null;
            break;
          }
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert$loadImage$1$2$1"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(d.a parama)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      b(ImageView paramImageView, Matrix paramMatrix, Bitmap paramBitmap)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(d paramd, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(236527);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.Aet.Aes;
      if (paramView != null) {
        paramView.a(parama, paramh);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(236527);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.view.d
 * JD-Core Version:    0.7.0.1
 */