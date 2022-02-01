package com.tencent.mm.plugin.recordvideo.ui.editor.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditorTextColorSelector;", "", "view", "Landroid/widget/GridView;", "(Landroid/widget/GridView;)V", "adapter", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditorTextColorSelector$ColorResourceAdapter;", "colorArray", "", "colorResourceList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditorTextColorSelector$ColorViewResource;", "Lkotlin/collections/ArrayList;", "colorSelectedCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "index", "", "getColorSelectedCallback", "()Lkotlin/jvm/functions/Function1;", "setColorSelectedCallback", "(Lkotlin/jvm/functions/Function1;)V", "radius", "getRadius", "()I", "selectedIndex", "sizeDP", "getSizeDP", "getView", "()Landroid/widget/GridView;", "setView", "initView", "resetColorImageView", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/ClickBigImageView;", "selectColorImageView", "setColorList", "setSelected", "select", "ColorResourceAdapter", "ColorViewResource", "Companion", "OnCLickImageCallback", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.c OaN;
  public GridView OaO;
  public int[] OaP;
  public final ArrayList<b> OaQ;
  public a OaR;
  final int OaS;
  public kotlin.g.a.b<? super Integer, ah> OaT;
  private int dbk;
  private final int radius;
  
  static
  {
    AppMethodBeat.i(280037);
    OaN = new c.c((byte)0);
    AppMethodBeat.o(280037);
  }
  
  public c(GridView paramGridView)
  {
    AppMethodBeat.i(279998);
    this.OaO = paramGridView;
    this.OaP = new int[0];
    this.dbk = -1;
    this.OaQ = new ArrayList();
    this.OaS = 24;
    this.radius = 23;
    AppMethodBeat.o(279998);
  }
  
  public final void setSelected(int paramInt)
  {
    AppMethodBeat.i(280042);
    this.dbk = paramInt;
    ((b)this.OaQ.get(paramInt)).type = 1;
    AppMethodBeat.o(280042);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditorTextColorSelector$ColorResourceAdapter;", "Landroid/widget/BaseAdapter;", "resourceList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditorTextColorSelector$ColorViewResource;", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditorTextColorSelector;Ljava/util/ArrayList;)V", "callback", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditorTextColorSelector$OnCLickImageCallback;", "getCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditorTextColorSelector$OnCLickImageCallback;", "setCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditorTextColorSelector$OnCLickImageCallback;)V", "getResourceList", "()Ljava/util/ArrayList;", "setResourceList", "(Ljava/util/ArrayList;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends BaseAdapter
  {
    private ArrayList<c.b> OaU;
    public c.d OaV;
    
    public a()
    {
      AppMethodBeat.i(280032);
      this.OaU = localObject;
      AppMethodBeat.o(280032);
    }
    
    private static final void a(a parama, View paramView)
    {
      AppMethodBeat.i(280035);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parama);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/editor/view/EditorTextColorSelector$ColorResourceAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parama, "this$0");
      if ((paramView instanceof com.tencent.mm.plugin.recordvideo.plugin.doodle.a))
      {
        paramView = paramView.getTag();
        if (paramView == null)
        {
          parama = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(280035);
          throw parama;
        }
        int i = ((Integer)paramView).intValue();
        parama = parama.OaV;
        if (parama != null) {
          parama.agZ(i);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/recordvideo/ui/editor/view/EditorTextColorSelector$ColorResourceAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(280035);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(280078);
      int i = this.OaU.size();
      AppMethodBeat.o(280078);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(280085);
      Object localObject = this.OaU.get(paramInt);
      s.s(localObject, "resourceList[position]");
      AppMethodBeat.o(280085);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(280069);
      s.checkNotNull(paramViewGroup);
      paramView = paramViewGroup.getContext();
      s.s(paramView, "parent!!.context");
      paramView = new com.tencent.mm.plugin.recordvideo.plugin.doodle.a(paramView);
      paramViewGroup = (c.b)getItem(paramInt);
      paramView.setDrawColor(paramViewGroup.color);
      com.tencent.mm.plugin.recordvideo.a.c localc = com.tencent.mm.plugin.recordvideo.a.c.NDf;
      com.tencent.mm.plugin.recordvideo.a.c.aO((View)paramView, paramViewGroup.color);
      int i = com.tencent.mm.cd.a.fromDPToPix(paramView.getContext(), c.this.OaS);
      paramView.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(i, i));
      paramView.setTag(Integer.valueOf(paramInt));
      paramView.setOnClickListener(new c.a..ExternalSyntheticLambda0(this));
      if (paramInt == c.b(c.this)) {
        paramView.setHasSelected(true);
      }
      for (;;)
      {
        paramView = (View)paramView;
        AppMethodBeat.o(280069);
        return paramView;
        paramView.setHasSelected(false);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditorTextColorSelector$ColorViewResource;", "", "()V", "color", "", "getColor", "()I", "setColor", "(I)V", "type", "getType", "setType", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public int color;
    public int type;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditorTextColorSelector$OnCLickImageCallback;", "", "onClickItem", "", "position", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract void agZ(int paramInt);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/ui/editor/view/EditorTextColorSelector$initView$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditorTextColorSelector$OnCLickImageCallback;", "onClickItem", "", "position", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements c.d
  {
    public e(c paramc) {}
    
    public final void agZ(int paramInt)
    {
      AppMethodBeat.i(280022);
      Object localObject2 = (Iterable)c.a(this.OaW);
      Object localObject1 = this.OaW;
      int i = 0;
      localObject2 = ((Iterable)localObject2).iterator();
      for (;;)
      {
        int j;
        if (((Iterator)localObject2).hasNext())
        {
          ((Iterator)localObject2).next();
          j = i + 1;
          if (i < 0) {
            p.kkW();
          }
          Object localObject3;
          if (i == paramInt)
          {
            localObject3 = ((c)localObject1).OaO.getChildAt(i);
            if (localObject3 == null)
            {
              localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(280022);
              throw ((Throwable)localObject1);
            }
            if (!((com.tencent.mm.plugin.recordvideo.plugin.doodle.a)localObject3).KhA)
            {
              c.a((c)localObject1, paramInt);
              localObject3 = ((c)localObject1).OaT;
              if (localObject3 != null) {
                ((kotlin.g.a.b)localObject3).invoke(Integer.valueOf(paramInt));
              }
              localObject3 = ((c)localObject1).OaO.getChildAt(i);
              if (localObject3 == null)
              {
                localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                AppMethodBeat.o(280022);
                throw ((Throwable)localObject1);
              }
              c.a((com.tencent.mm.plugin.recordvideo.plugin.doodle.a)localObject3);
              i = j;
            }
          }
          else
          {
            localObject3 = ((c)localObject1).OaO.getChildAt(i);
            if (localObject3 == null)
            {
              localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(280022);
              throw ((Throwable)localObject1);
            }
            if (((com.tencent.mm.plugin.recordvideo.plugin.doodle.a)localObject3).KhA)
            {
              localObject3 = ((c)localObject1).OaO.getChildAt(i);
              if (localObject3 == null)
              {
                localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                AppMethodBeat.o(280022);
                throw ((Throwable)localObject1);
              }
              c.b((com.tencent.mm.plugin.recordvideo.plugin.doodle.a)localObject3);
            }
            i = j;
          }
        }
        else
        {
          AppMethodBeat.o(280022);
          return;
        }
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.view.c
 * JD-Core Version:    0.7.0.1
 */