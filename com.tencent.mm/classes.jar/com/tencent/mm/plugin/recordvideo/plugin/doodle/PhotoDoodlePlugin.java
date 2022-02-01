package com.tencent.mm.plugin.recordvideo.plugin.doodle;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.b.d;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.u;
import com.tencent.mm.plugin.recordvideo.plugin.u.a;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "colorList", "Landroid/widget/GridView;", "getColorList", "()Landroid/widget/GridView;", "setColorList", "(Landroid/widget/GridView;)V", "imageSizeDP", "", "getImageSizeDP", "()I", "mStatus", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "getMStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setMStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "resourceArray", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$ClickImageViewResource;", "Lkotlin/collections/ArrayList;", "getResourceArray", "()Ljava/util/ArrayList;", "selectType", "getSelectType", "setSelectType", "(I)V", "unDoImageView", "Landroid/widget/ImageView;", "getUnDoImageView", "()Landroid/widget/ImageView;", "setUnDoImageView", "(Landroid/widget/ImageView;)V", "getLayout", "hideMosaic", "", "hide", "", "initResourceArray", "msc", "Landroid/graphics/Bitmap;", "brush", "initView", "onBackPress", "postFuncType", "type", "resetClickBigImageView", "view", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/ClickBigImageView;", "selectClickBigImageView", "setStatus", "status", "setVisibility", "visibility", "ClickImageViewResource", "ClickImageViewResourceAdapter", "Companion", "plugin-recordvideo_release"})
public class PhotoDoodlePlugin
  extends RelativeLayout
  implements u
{
  public static final c HPT;
  private final int HPD;
  private final ArrayList<a> HPE;
  private d HPF;
  private ImageView HPG;
  public GridView HPH;
  private int selectType;
  
  static
  {
    AppMethodBeat.i(75733);
    HPT = new c((byte)0);
    AppMethodBeat.o(75733);
  }
  
  public PhotoDoodlePlugin(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75732);
    this.HPE = new ArrayList();
    this.selectType = 2;
    this.HPD = 22;
    LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup)this, true);
    this.HPG = ((ImageView)findViewById(b.e.recall));
    paramContext = this.HPG;
    if (paramContext != null) {
      paramContext.setImageDrawable(au.o(getContext(), b.g.icons_filled_previous, -1));
    }
    paramContext = this.HPG;
    if (paramContext != null) {
      paramContext.setOnClickListener((View.OnClickListener)new d(this));
    }
    this.HPH = ((GridView)findViewById(b.e.color_list));
    paramContext = getContext();
    p.j(paramContext, "context");
    paramContext = BitmapFactory.decodeResource(paramContext.getResources(), b.d.icons_filled_brush);
    paramAttributeSet = getContext();
    p.j(paramAttributeSet, "context");
    b(BitmapFactory.decodeResource(paramAttributeSet.getResources(), b.d.icons_filled_msc), paramContext);
    paramContext = this.HPH;
    if (paramContext != null) {
      paramContext.setAdapter((ListAdapter)new b(this.HPE));
    }
    paramContext = this.HPH;
    if (paramContext != null)
    {
      paramContext.setOnItemClickListener((AdapterView.OnItemClickListener)new e(this));
      AppMethodBeat.o(75732);
      return;
    }
    AppMethodBeat.o(75732);
  }
  
  protected final void acn(int paramInt)
  {
    AppMethodBeat.i(75731);
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = new Bundle();
      ((Bundle)localObject).putInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT", paramInt);
      d locald = this.HPF;
      if (locald != null)
      {
        locald.a(d.c.HSz, (Bundle)localObject);
        AppMethodBeat.o(75731);
        return;
      }
      break;
    case 99: 
      localObject = this.HPF;
      if (localObject != null)
      {
        d.b.a((d)localObject, d.c.HSx);
        AppMethodBeat.o(75731);
        return;
      }
      AppMethodBeat.o(75731);
      return;
    case 100: 
      localObject = this.HPF;
      if (localObject != null)
      {
        d.b.a((d)localObject, d.c.HSy);
        AppMethodBeat.o(75731);
        return;
      }
      AppMethodBeat.o(75731);
      return;
    }
    AppMethodBeat.o(75731);
  }
  
  public final void b(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    AppMethodBeat.i(163442);
    this.HPE.clear();
    Object localObject;
    if (paramBitmap1 != null)
    {
      localObject = this.HPE;
      a locala = new a();
      locala.bitmap = paramBitmap1;
      locala.type = 99;
      ((ArrayList)localObject).add(locala);
    }
    if (paramBitmap2 != null)
    {
      paramBitmap1 = this.HPE;
      localObject = new a();
      ((a)localObject).bitmap = paramBitmap2;
      ((a)localObject).type = 100;
      paramBitmap1.add(localObject);
    }
    paramBitmap1 = this.HPE;
    paramBitmap2 = new a();
    paramBitmap2.color = -1;
    paramBitmap2.type = 0;
    paramBitmap1.add(paramBitmap2);
    paramBitmap1 = this.HPE;
    paramBitmap2 = new a();
    paramBitmap2.color = -16777216;
    paramBitmap2.type = 1;
    paramBitmap1.add(paramBitmap2);
    paramBitmap1 = this.HPE;
    paramBitmap2 = new a();
    paramBitmap2.color = -707825;
    paramBitmap2.type = 2;
    paramBitmap1.add(paramBitmap2);
    paramBitmap1 = this.HPE;
    paramBitmap2 = new a();
    paramBitmap2.color = -17592;
    paramBitmap2.type = 3;
    paramBitmap1.add(paramBitmap2);
    paramBitmap1 = this.HPE;
    paramBitmap2 = new a();
    paramBitmap2.color = -16535286;
    paramBitmap2.type = 4;
    paramBitmap1.add(paramBitmap2);
    paramBitmap1 = this.HPE;
    paramBitmap2 = new a();
    paramBitmap2.color = -15172610;
    paramBitmap2.type = 5;
    paramBitmap1.add(paramBitmap2);
    paramBitmap1 = this.HPE;
    paramBitmap2 = new a();
    paramBitmap2.color = -7054596;
    paramBitmap2.type = 6;
    paramBitmap1.add(paramBitmap2);
    AppMethodBeat.o(163442);
  }
  
  public final void bbp() {}
  
  protected final GridView getColorList()
  {
    return this.HPH;
  }
  
  protected final int getImageSizeDP()
  {
    return this.HPD;
  }
  
  public final int getLayout()
  {
    return b.f.photo_doodle_layout;
  }
  
  public final d getMStatus()
  {
    return this.HPF;
  }
  
  protected final ArrayList<a> getResourceArray()
  {
    return this.HPE;
  }
  
  protected final int getSelectType()
  {
    return this.selectType;
  }
  
  protected final ImageView getUnDoImageView()
  {
    return this.HPG;
  }
  
  public final String name()
  {
    AppMethodBeat.i(228602);
    String str = getClass().getName();
    AppMethodBeat.o(228602);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(75730);
    if (getVisibility() == 0)
    {
      setVisibility(4);
      AppMethodBeat.o(75730);
      return true;
    }
    AppMethodBeat.o(75730);
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(228615);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(228615);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  protected final void setColorList(GridView paramGridView)
  {
    this.HPH = paramGridView;
  }
  
  public final void setMStatus(d paramd)
  {
    this.HPF = paramd;
  }
  
  protected final void setSelectType(int paramInt)
  {
    this.selectType = paramInt;
  }
  
  public final void setStatus(d paramd)
  {
    AppMethodBeat.i(75728);
    p.k(paramd, "status");
    this.HPF = paramd;
    AppMethodBeat.o(75728);
  }
  
  protected final void setUnDoImageView(ImageView paramImageView)
  {
    this.HPG = paramImageView;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75729);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      Iterator localIterator = ((Iterable)this.HPE).iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        localIterator.next();
        int j = i + 1;
        if (i < 0) {
          j.iBO();
        }
        localObject = this.HPH;
        if (localObject != null)
        {
          localObject = ((GridView)localObject).getChildAt(i);
          if (localObject == null) {
            break label281;
          }
          localObject = this.HPH;
          if (localObject == null) {
            break label135;
          }
        }
        label135:
        for (localObject = ((GridView)localObject).getChildAt(i);; localObject = null)
        {
          if (localObject != null) {
            break label141;
          }
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
          AppMethodBeat.o(75729);
          throw ((Throwable)localObject);
          localObject = null;
          break;
        }
        label141:
        if (((a)localObject).getType() != this.selectType)
        {
          localObject = this.HPH;
          if (localObject != null) {}
          for (localObject = ((GridView)localObject).getChildAt(i); localObject == null; localObject = null)
          {
            localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
            AppMethodBeat.o(75729);
            throw ((Throwable)localObject);
          }
          ((a)localObject).setHasSelected(false);
          i = j;
        }
        else
        {
          localObject = this.HPH;
          if (localObject != null) {}
          for (localObject = ((GridView)localObject).getChildAt(i); localObject == null; localObject = null)
          {
            localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
            AppMethodBeat.o(75729);
            throw ((Throwable)localObject);
          }
          ((a)localObject).setHasSelected(true);
          label281:
          i = j;
        }
      }
      acn(this.selectType);
    }
    Object localObject = this.HPH;
    if (localObject != null) {
      ((GridView)localObject).setVisibility(paramInt);
    }
    localObject = this.HPG;
    if (localObject != null)
    {
      ((ImageView)localObject).setVisibility(paramInt);
      AppMethodBeat.o(75729);
      return;
    }
    AppMethodBeat.o(75729);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$ClickImageViewResource;", "", "()V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "type", "getType", "setType", "plugin-recordvideo_release"})
  public static final class a
  {
    Bitmap bitmap;
    int color;
    int type;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$ClickImageViewResourceAdapter;", "Landroid/widget/BaseAdapter;", "resourceArray", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$ClickImageViewResource;", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin;Ljava/util/ArrayList;)V", "getResourceArray", "()Ljava/util/ArrayList;", "setResourceArray", "(Ljava/util/ArrayList;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-recordvideo_release"})
  final class b
    extends BaseAdapter
  {
    private ArrayList<PhotoDoodlePlugin.a> HPE;
    
    public b()
    {
      AppMethodBeat.i(75727);
      this.HPE = localObject;
      AppMethodBeat.o(75727);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(75726);
      int i = this.HPE.size();
      AppMethodBeat.o(75726);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(75725);
      Object localObject = this.HPE.get(paramInt);
      p.j(localObject, "resourceArray[position]");
      AppMethodBeat.o(75725);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(75724);
      if (paramViewGroup == null) {
        p.iCn();
      }
      paramView = paramViewGroup.getContext();
      p.j(paramView, "parent!!.context");
      paramViewGroup = new a(paramView);
      paramView = getItem(paramInt);
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin.ClickImageViewResource");
        AppMethodBeat.o(75724);
        throw paramView;
      }
      paramView = (PhotoDoodlePlugin.a)paramView;
      if (paramView.bitmap == null)
      {
        paramViewGroup.setDrawColor(paramView.color);
        paramViewGroup.setType(paramView.type);
        paramView = PhotoDoodlePlugin.this.getColorList();
        if (paramView == null) {
          break label186;
        }
        paramView = paramView.getContext();
        label104:
        paramInt = com.tencent.mm.ci.a.fromDPToPix(paramView, PhotoDoodlePlugin.this.getImageSizeDP());
        paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(paramInt, paramInt));
        if (paramViewGroup.getType() != PhotoDoodlePlugin.this.getSelectType()) {
          break label191;
        }
        paramViewGroup.setHasSelected(true);
      }
      for (;;)
      {
        paramView = (View)paramViewGroup;
        AppMethodBeat.o(75724);
        return paramView;
        Bitmap localBitmap = paramView.bitmap;
        if (localBitmap == null) {
          p.iCn();
        }
        paramViewGroup.setBitmap(localBitmap);
        break;
        label186:
        paramView = null;
        break label104;
        label191:
        paramViewGroup.setHasSelected(false);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$Companion;", "", "()V", "BRUSH", "", "COLOR_0", "COLOR_1", "COLOR_2", "COLOR_3", "COLOR_4", "COLOR_5", "COLOR_6", "MSC", "RECALL", "plugin-recordvideo_release"})
  public static final class c {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(PhotoDoodlePlugin paramPhotoDoodlePlugin) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(228082);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.HPU.getMStatus();
      if (paramView != null) {
        d.b.a(paramView, d.c.HSA);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(228082);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "a", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "b", "Landroid/view/View;", "position", "", "d", "", "onItemClick"})
  static final class e
    implements AdapterView.OnItemClickListener
  {
    e(PhotoDoodlePlugin paramPhotoDoodlePlugin) {}
    
    public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      AppMethodBeat.i(216297);
      b localb = new b();
      localb.bn(paramAdapterView);
      localb.bn(paramView);
      localb.sg(paramInt);
      localb.Fs(paramLong);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$initView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
      if (paramView == null)
      {
        paramAdapterView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
        AppMethodBeat.o(216297);
        throw paramAdapterView;
      }
      if (((a)paramView).getType() == this.HPU.getSelectType())
      {
        this.HPU.acn(((a)paramView).getType());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$initView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(216297);
        return;
      }
      this.HPU.setSelectType(((a)paramView).getType());
      this.HPU.acn(((a)paramView).getType());
      paramAdapterView = (Iterable)this.HPU.getResourceArray();
      int i = 0;
      paramView = paramAdapterView.iterator();
      for (;;)
      {
        int j;
        if (paramView.hasNext())
        {
          paramView.next();
          j = i + 1;
          if (i < 0) {
            j.iBO();
          }
          if (i == paramInt)
          {
            paramAdapterView = this.HPU.getColorList();
            if (paramAdapterView != null) {}
            for (paramAdapterView = paramAdapterView.getChildAt(i); paramAdapterView == null; paramAdapterView = null)
            {
              paramAdapterView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(216297);
              throw paramAdapterView;
            }
            if (!((a)paramAdapterView).EoU)
            {
              paramAdapterView = this.HPU.getColorList();
              if (paramAdapterView != null) {}
              for (paramAdapterView = paramAdapterView.getChildAt(i); paramAdapterView == null; paramAdapterView = null)
              {
                paramAdapterView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                AppMethodBeat.o(216297);
                throw paramAdapterView;
              }
              PhotoDoodlePlugin.c((a)paramAdapterView);
              i = j;
            }
          }
          else
          {
            paramAdapterView = this.HPU.getColorList();
            if (paramAdapterView != null) {}
            for (paramAdapterView = paramAdapterView.getChildAt(i); paramAdapterView == null; paramAdapterView = null)
            {
              paramAdapterView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(216297);
              throw paramAdapterView;
            }
            if (((a)paramAdapterView).EoU)
            {
              paramAdapterView = this.HPU.getColorList();
              if (paramAdapterView != null) {}
              for (paramAdapterView = paramAdapterView.getChildAt(i); paramAdapterView == null; paramAdapterView = null)
              {
                paramAdapterView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                AppMethodBeat.o(216297);
                throw paramAdapterView;
              }
              PhotoDoodlePlugin.d((a)paramAdapterView);
            }
            i = j;
          }
        }
        else
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$initView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(216297);
          return;
        }
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin
 * JD-Core Version:    0.7.0.1
 */