package com.tencent.mm.plugin.multitask.ui.minusscreen.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.c.k;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.plugin.multitask.h;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.a.c;
import com.tencent.mm.plugin.multitask.ui.a.c.a;
import com.tencent.mm.plugin.multitask.ui.e.b;
import com.tencent.mm.plugin.multitask.ui.e.c;
import com.tencent.mm.plugin.multitask.ui.minusscreen.a.a;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "layoutResId", "", "listener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "(ILcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;)V", "MAX_NAME_COUNT", "getMAX_NAME_COUNT", "()I", "TAG", "", "thumbLoaderOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getThumbLoaderOption", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getLayoutId", "getNickName", "context", "Landroid/content/Context;", "item", "getTimeShowString", "time", "loadImage", "", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "imgView", "Landroid/widget/ImageView;", "defaultImgView", "defaultBgContainer", "Landroid/view/View;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "makeTimeString", "d", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "useBottomGradient", "ui-multitask_release"})
public abstract class d
  extends com.tencent.mm.view.recyclerview.e<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a>
{
  private final com.tencent.mm.loader.c.e FKT;
  com.tencent.mm.plugin.multitask.ui.minusscreen.d.a FKU;
  final String TAG;
  private final int xlY;
  private final int xmc;
  
  public d(int paramInt, com.tencent.mm.plugin.multitask.ui.minusscreen.d.a parama)
  {
    this.xmc = paramInt;
    this.FKU = parama;
    this.TAG = "MicroMsg.MultiTask.MinusScreenRoundCornerConvert";
    parama = new e.a();
    parama.kOp = true;
    parama.kOo = true;
    this.FKT = parama.aRT();
    this.xlY = 5;
  }
  
  public static String AP(int paramInt)
  {
    return AQ(paramInt / 60) + ":" + AQ(paramInt % 60);
  }
  
  private static String AQ(int paramInt)
  {
    if (paramInt < 10) {
      return "0".concat(String.valueOf(paramInt));
    }
    return String.valueOf(paramInt);
  }
  
  public String a(Context paramContext, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama)
  {
    p.k(paramContext, "context");
    p.k(parama, "item");
    return parama.FKP.fbc().nickname;
  }
  
  public void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    p.k(paramRecyclerView, "recyclerView");
    p.k(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
  }
  
  public void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    paramRecyclerView = paramRecyclerView.getAdapter();
    if (paramRecyclerView != null)
    {
      paramInt = paramRecyclerView.getItemCount();
      Log.i(this.TAG, "onCreateViewHolder itemCount:" + paramInt + ", layoutPosition:" + parami.mc());
      if (paramInt != 2) {
        break label190;
      }
      paramRecyclerView = parami.amk.findViewById(e.c.FIy);
      if (paramRecyclerView != null)
      {
        localObject = c.FNc;
        paramRecyclerView.setTranslationX(c.fcv());
        localObject = c.FNc;
        paramRecyclerView.setTranslationY(c.fcu());
        localObject = paramRecyclerView.getLayoutParams();
        locala = c.FNc;
        ((ViewGroup.LayoutParams)localObject).height = c.fcp();
        localObject = paramRecyclerView.getLayoutParams();
        locala = c.FNc;
        ((ViewGroup.LayoutParams)localObject).width = c.fco();
        parami = (RoundedCornerFrameLayout)parami.amk.findViewById(e.c.multi_task_item_bg);
        if (parami != null)
        {
          parami = parami.getLayoutParams();
          localObject = c.FNc;
          parami.height = c.fct();
        }
        paramRecyclerView.requestLayout();
      }
    }
    label190:
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
            break label301;
          }
          paramRecyclerView = parami.amk.findViewById(e.c.FIy);
        } while (paramRecyclerView == null);
        localObject = c.FNc;
        paramRecyclerView.setTranslationY(c.fcx());
        localObject = paramRecyclerView.getLayoutParams();
        locala = c.FNc;
        ((ViewGroup.LayoutParams)localObject).height = c.fcn();
        localObject = paramRecyclerView.getLayoutParams();
        locala = c.FNc;
        ((ViewGroup.LayoutParams)localObject).width = c.fcm();
        parami = (RoundedCornerFrameLayout)parami.amk.findViewById(e.c.multi_task_item_bg);
        if (parami != null)
        {
          parami = parami.getLayoutParams();
          localObject = c.FNc;
          parami.height = c.fcr();
        }
        paramRecyclerView.requestLayout();
        return;
      } while (paramInt < 4);
      paramRecyclerView = parami.amk.findViewById(e.c.FIy);
    } while (paramRecyclerView == null);
    label301:
    Object localObject = paramRecyclerView.getLayoutParams();
    c.a locala = c.FNc;
    ((ViewGroup.LayoutParams)localObject).height = c.fcn();
    localObject = paramRecyclerView.getLayoutParams();
    locala = c.FNc;
    ((ViewGroup.LayoutParams)localObject).width = c.fcm();
    parami = (RoundedCornerFrameLayout)parami.amk.findViewById(e.c.multi_task_item_bg);
    if (parami != null)
    {
      parami = parami.getLayoutParams();
      localObject = c.FNc;
      parami.height = c.fcr();
    }
    paramRecyclerView.requestLayout();
  }
  
  public void a(final i parami, final com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama, int paramInt1, int paramInt2, boolean paramBoolean, final List<Object> paramList)
  {
    p.k(parami, "holder");
    p.k(parama, "item");
    Log.d(this.TAG, "onBindViewHolder, position:".concat(String.valueOf(paramInt1)));
    Object localObject3 = parami.amk.findViewById(e.c.FIQ);
    Object localObject6 = (TextView)parami.amk.findViewById(e.c.FIN);
    TextView localTextView = (TextView)parami.amk.findViewById(e.c.FIP);
    paramList = (MMImageView)parami.amk.findViewById(e.c.FIR);
    Object localObject4 = (MinusScreenRoundFrameLayout)parami.amk.findViewById(e.c.FIF);
    Object localObject5 = (TextView)parami.amk.findViewById(e.c.FIO);
    Object localObject1 = (RoundedCornerFrameLayout)parami.amk.findViewById(e.c.multi_task_item_bg);
    Object localObject2 = (WeImageView)parami.amk.findViewById(e.c.FIK);
    Object localObject7 = (ImageView)parami.RD(e.c.FIJ);
    if (localObject7 != null) {
      ((ImageView)localObject7).setOnClickListener((View.OnClickListener)new d.b(this, parama, parami));
    }
    localObject7 = parami.getContext();
    p.j(localObject7, "holder.context");
    ((TextView)localObject6).setText((CharSequence)a((Context)localObject7, parama));
    if (Util.isNullOrNil(parama.FKP.fbc().title))
    {
      p.j(localTextView, "title");
      localTextView.setVisibility(8);
      p.j(localObject3, "tagContainerView");
      localObject6 = ((View)localObject3).getLayoutParams();
      if (localObject6 == null) {
        throw new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject6 = (ViewGroup.MarginLayoutParams)localObject6;
      ((ViewGroup.MarginLayoutParams)localObject6).topMargin = aw.fromDPToPix(parami.getContext(), 16);
      ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject6);
      if (Util.isNullOrNil(parama.FKP.fbc().tag)) {
        break label570;
      }
      ((TextView)localObject5).setText((CharSequence)parama.FKP.fbc().tag);
      p.j(localObject5, "tagView");
      ((TextView)localObject5).setVisibility(0);
    }
    for (;;)
    {
      ((MinusScreenRoundFrameLayout)localObject4).setUseBottomGradient(fbL());
      if (!parama.FKP.fbc().TIi) {
        break label588;
      }
      p.j(localObject2, "defaultBgView");
      ((WeImageView)localObject2).setVisibility(0);
      p.j(paramList, "imgView");
      paramList.setVisibility(8);
      parami = parami.getContext();
      p.j(parami, "holder.context");
      ((RoundedCornerFrameLayout)localObject1).setBackgroundColor(parami.getResources().getColor(e.b.multi_task_item_bg));
      parami = com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.FKR;
      ((WeImageView)localObject2).setImageResource(com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.Yj(parama.FKP.field_type));
      parami = h.FFb;
      parami = h.g(parama.FKP);
      com.tencent.mm.ay.q.bml().a(parami, (ImageView)paramList);
      return;
      p.j(localTextView, "title");
      localTextView.setVisibility(0);
      localTextView.setText((CharSequence)parama.FKP.fbc().title);
      p.j(localObject3, "tagContainerView");
      localObject6 = ((View)localObject3).getLayoutParams();
      if (localObject6 == null) {
        throw new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject6 = (ViewGroup.MarginLayoutParams)localObject6;
      ((ViewGroup.MarginLayoutParams)localObject6).topMargin = aw.fromDPToPix(parami.getContext(), 6);
      ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject6);
      break;
      label570:
      p.j(localObject5, "tagView");
      ((TextView)localObject5).setVisibility(8);
    }
    label588:
    p.j(localObject2, "defaultBgView");
    ((WeImageView)localObject2).setVisibility(8);
    p.j(paramList, "imgView");
    paramList.setVisibility(0);
    ((RoundedCornerFrameLayout)localObject1).setBackgroundColor(0);
    parama = parama.FKP;
    paramList = (ImageView)paramList;
    localObject2 = (ImageView)localObject2;
    p.j(localObject1, "defaultBgContainer");
    localObject1 = (View)localObject1;
    p.k(parama, "multiTaskInfo");
    p.k(paramList, "imgView");
    p.k(localObject2, "defaultImgView");
    p.k(localObject1, "defaultBgContainer");
    p.k(parami, "holder");
    localObject3 = h.FFb;
    localObject3 = h.g(parama);
    localObject4 = com.tencent.mm.ay.q.bml();
    localObject5 = h.FFb;
    ((com.tencent.mm.ay.a.a)localObject4).a((String)localObject3, paramList, h.fap(), (k)new a(this, parami, (String)localObject3, paramList, parama, (ImageView)localObject2, (View)localObject1));
  }
  
  public final int fbK()
  {
    return this.xlY;
  }
  
  public boolean fbL()
  {
    return false;
  }
  
  public final int getLayoutId()
  {
    return this.xmc;
  }
  
  protected final com.tencent.mm.loader.c.e getThumbLoaderOption()
  {
    return this.FKT;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "", "view", "Landroid/view/View;", "bitmap", "Landroid/graphics/Bitmap;", "extraObj", "", "", "onImageLoadComplete", "(Ljava/lang/String;Landroid/view/View;Landroid/graphics/Bitmap;[Ljava/lang/Object;)V"})
  static final class a
    implements k
  {
    a(d paramd, i parami, String paramString, ImageView paramImageView1, MultiTaskInfo paramMultiTaskInfo, ImageView paramImageView2, View paramView) {}
    
    public final void a(String paramString, View paramView, Bitmap paramBitmap, Object[] paramArrayOfObject)
    {
      Object localObject = null;
      paramArrayOfObject = null;
      AppMethodBeat.i(196352);
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
            Log.i(this.FKV.TAG, "loadImage callback " + paramView.hashCode() + ' ' + paramBitmap);
            paramString = parami.getRecyclerView();
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
          for (int i = paramString.ku();; i = 1)
          {
            paramString = com.tencent.mm.plugin.multitask.ui.minusscreen.a.FKk;
            int j = a.a.fbH();
            float f = (ar.getDeviceWidth() - j * (i + 1)) / (i * paramBitmap.getWidth());
            paramString = new Matrix();
            paramString.setScale(f, f);
            com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d.a.b(paramView, paramString, paramBitmap));
            paramString = x.aazN;
            if (paramString == null)
            {
              com.tencent.mm.ay.q.bml().a(this.FKW, paramList);
              com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this));
              paramString = x.aazN;
            }
            AppMethodBeat.o(196352);
            return;
            paramString = null;
            break;
          }
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert$loadImage$1$2$1"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(d.a parama)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.view.d
 * JD-Core Version:    0.7.0.1
 */