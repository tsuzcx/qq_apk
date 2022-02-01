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
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "colorList", "Landroid/widget/GridView;", "getColorList", "()Landroid/widget/GridView;", "setColorList", "(Landroid/widget/GridView;)V", "imageSizeDP", "", "getImageSizeDP", "()I", "mStatus", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "getMStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setMStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "resourceArray", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$ClickImageViewResource;", "Lkotlin/collections/ArrayList;", "getResourceArray", "()Ljava/util/ArrayList;", "selectType", "getSelectType", "setSelectType", "(I)V", "unDoImageView", "Landroid/widget/ImageView;", "getUnDoImageView", "()Landroid/widget/ImageView;", "setUnDoImageView", "(Landroid/widget/ImageView;)V", "getLayout", "hideMosaic", "", "hide", "", "initResourceArray", "msc", "Landroid/graphics/Bitmap;", "brush", "initView", "onBackPress", "postFuncType", "type", "resetClickBigImageView", "view", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/ClickBigImageView;", "selectClickBigImageView", "setStatus", "status", "setVisibility", "visibility", "ClickImageViewResource", "ClickImageViewResourceAdapter", "Companion", "plugin-recordvideo_release"})
public class PhotoDoodlePlugin
  extends RelativeLayout
  implements com.tencent.mm.plugin.recordvideo.plugin.t
{
  public static final PhotoDoodlePlugin.c BTf;
  private final int BSP;
  private final ArrayList<a> BSQ;
  private d BSR;
  private ImageView BSS;
  public GridView BST;
  private int jVX;
  
  static
  {
    AppMethodBeat.i(75733);
    BTf = new PhotoDoodlePlugin.c((byte)0);
    AppMethodBeat.o(75733);
  }
  
  public PhotoDoodlePlugin(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75732);
    this.BSQ = new ArrayList();
    this.jVX = 2;
    this.BSP = 22;
    LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup)this, true);
    this.BSS = ((ImageView)findViewById(2131306607));
    paramContext = this.BSS;
    if (paramContext != null) {
      paramContext.setImageDrawable(ar.m(getContext(), 2131690650, -1));
    }
    paramContext = this.BSS;
    if (paramContext != null) {
      paramContext.setOnClickListener((View.OnClickListener)new d(this));
    }
    this.BST = ((GridView)findViewById(2131298912));
    paramContext = getContext();
    p.g(paramContext, "context");
    paramContext = BitmapFactory.decodeResource(paramContext.getResources(), 2131233127);
    paramAttributeSet = getContext();
    p.g(paramAttributeSet, "context");
    b(BitmapFactory.decodeResource(paramAttributeSet.getResources(), 2131233128), paramContext);
    paramContext = this.BST;
    if (paramContext != null) {
      paramContext.setAdapter((ListAdapter)new b(this.BSQ));
    }
    paramContext = this.BST;
    if (paramContext != null)
    {
      paramContext.setOnItemClickListener((AdapterView.OnItemClickListener)new e(this));
      AppMethodBeat.o(75732);
      return;
    }
    AppMethodBeat.o(75732);
  }
  
  protected final void VE(int paramInt)
  {
    AppMethodBeat.i(75731);
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = new Bundle();
      ((Bundle)localObject).putInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT", paramInt);
      d locald = this.BSR;
      if (locald != null)
      {
        locald.a(d.c.BVL, (Bundle)localObject);
        AppMethodBeat.o(75731);
        return;
      }
      break;
    case 99: 
      localObject = this.BSR;
      if (localObject != null)
      {
        d.b.a((d)localObject, d.c.BVJ);
        AppMethodBeat.o(75731);
        return;
      }
      AppMethodBeat.o(75731);
      return;
    case 100: 
      localObject = this.BSR;
      if (localObject != null)
      {
        d.b.a((d)localObject, d.c.BVK);
        AppMethodBeat.o(75731);
        return;
      }
      AppMethodBeat.o(75731);
      return;
    }
    AppMethodBeat.o(75731);
  }
  
  public final void aSs() {}
  
  public final void b(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    AppMethodBeat.i(163442);
    this.BSQ.clear();
    Object localObject;
    if (paramBitmap1 != null)
    {
      localObject = this.BSQ;
      a locala = new a();
      locala.bitmap = paramBitmap1;
      locala.type = 99;
      ((ArrayList)localObject).add(locala);
    }
    if (paramBitmap2 != null)
    {
      paramBitmap1 = this.BSQ;
      localObject = new a();
      ((a)localObject).bitmap = paramBitmap2;
      ((a)localObject).type = 100;
      paramBitmap1.add(localObject);
    }
    paramBitmap1 = this.BSQ;
    paramBitmap2 = new a();
    paramBitmap2.color = -1;
    paramBitmap2.type = 0;
    paramBitmap1.add(paramBitmap2);
    paramBitmap1 = this.BSQ;
    paramBitmap2 = new a();
    paramBitmap2.color = -16777216;
    paramBitmap2.type = 1;
    paramBitmap1.add(paramBitmap2);
    paramBitmap1 = this.BSQ;
    paramBitmap2 = new a();
    paramBitmap2.color = -707825;
    paramBitmap2.type = 2;
    paramBitmap1.add(paramBitmap2);
    paramBitmap1 = this.BSQ;
    paramBitmap2 = new a();
    paramBitmap2.color = -17592;
    paramBitmap2.type = 3;
    paramBitmap1.add(paramBitmap2);
    paramBitmap1 = this.BSQ;
    paramBitmap2 = new a();
    paramBitmap2.color = -16535286;
    paramBitmap2.type = 4;
    paramBitmap1.add(paramBitmap2);
    paramBitmap1 = this.BSQ;
    paramBitmap2 = new a();
    paramBitmap2.color = -15172610;
    paramBitmap2.type = 5;
    paramBitmap1.add(paramBitmap2);
    paramBitmap1 = this.BSQ;
    paramBitmap2 = new a();
    paramBitmap2.color = -7054596;
    paramBitmap2.type = 6;
    paramBitmap1.add(paramBitmap2);
    AppMethodBeat.o(163442);
  }
  
  protected final GridView getColorList()
  {
    return this.BST;
  }
  
  protected final int getImageSizeDP()
  {
    return this.BSP;
  }
  
  public final int getLayout()
  {
    return 2131495923;
  }
  
  public final d getMStatus()
  {
    return this.BSR;
  }
  
  protected final ArrayList<a> getResourceArray()
  {
    return this.BSQ;
  }
  
  protected final int getSelectType()
  {
    return this.jVX;
  }
  
  protected final ImageView getUnDoImageView()
  {
    return this.BSS;
  }
  
  public final String name()
  {
    return null;
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
    AppMethodBeat.i(237391);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(237391);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  protected final void setColorList(GridView paramGridView)
  {
    this.BST = paramGridView;
  }
  
  public final void setMStatus(d paramd)
  {
    this.BSR = paramd;
  }
  
  protected final void setSelectType(int paramInt)
  {
    this.jVX = paramInt;
  }
  
  public final void setStatus(d paramd)
  {
    AppMethodBeat.i(75728);
    p.h(paramd, "status");
    this.BSR = paramd;
    AppMethodBeat.o(75728);
  }
  
  protected final void setUnDoImageView(ImageView paramImageView)
  {
    this.BSS = paramImageView;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75729);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      Iterator localIterator = ((Iterable)this.BSQ).iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        localIterator.next();
        int j = i + 1;
        if (i < 0) {
          j.hxH();
        }
        localObject = this.BST;
        if (localObject != null)
        {
          localObject = ((GridView)localObject).getChildAt(i);
          if (localObject == null) {
            break label281;
          }
          localObject = this.BST;
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
          localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
          AppMethodBeat.o(75729);
          throw ((Throwable)localObject);
          localObject = null;
          break;
        }
        label141:
        if (((a)localObject).getType() != this.jVX)
        {
          localObject = this.BST;
          if (localObject != null) {}
          for (localObject = ((GridView)localObject).getChildAt(i); localObject == null; localObject = null)
          {
            localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
            AppMethodBeat.o(75729);
            throw ((Throwable)localObject);
          }
          ((a)localObject).setHasSelected(false);
          i = j;
        }
        else
        {
          localObject = this.BST;
          if (localObject != null) {}
          for (localObject = ((GridView)localObject).getChildAt(i); localObject == null; localObject = null)
          {
            localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
            AppMethodBeat.o(75729);
            throw ((Throwable)localObject);
          }
          ((a)localObject).setHasSelected(true);
          label281:
          i = j;
        }
      }
      VE(this.jVX);
    }
    Object localObject = this.BST;
    if (localObject != null) {
      ((GridView)localObject).setVisibility(paramInt);
    }
    localObject = this.BSS;
    if (localObject != null)
    {
      ((ImageView)localObject).setVisibility(paramInt);
      AppMethodBeat.o(75729);
      return;
    }
    AppMethodBeat.o(75729);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$ClickImageViewResource;", "", "()V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "type", "getType", "setType", "plugin-recordvideo_release"})
  public static final class a
  {
    Bitmap bitmap;
    int color;
    int type;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$ClickImageViewResourceAdapter;", "Landroid/widget/BaseAdapter;", "resourceArray", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$ClickImageViewResource;", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin;Ljava/util/ArrayList;)V", "getResourceArray", "()Ljava/util/ArrayList;", "setResourceArray", "(Ljava/util/ArrayList;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-recordvideo_release"})
  final class b
    extends BaseAdapter
  {
    private ArrayList<PhotoDoodlePlugin.a> BSQ;
    
    public b()
    {
      AppMethodBeat.i(75727);
      this.BSQ = localObject;
      AppMethodBeat.o(75727);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(75726);
      int i = this.BSQ.size();
      AppMethodBeat.o(75726);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(75725);
      Object localObject = this.BSQ.get(paramInt);
      p.g(localObject, "resourceArray[position]");
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
        p.hyc();
      }
      paramView = paramViewGroup.getContext();
      p.g(paramView, "parent!!.context");
      paramViewGroup = new a(paramView);
      paramView = getItem(paramInt);
      if (paramView == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin.ClickImageViewResource");
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
        paramInt = com.tencent.mm.cb.a.fromDPToPix(paramView, PhotoDoodlePlugin.this.getImageSizeDP());
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
          p.hyc();
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(PhotoDoodlePlugin paramPhotoDoodlePlugin) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(237389);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.BTg.getMStatus();
      if (paramView != null) {
        d.b.a(paramView, d.c.BVM);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(237389);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "a", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "b", "Landroid/view/View;", "position", "", "d", "", "onItemClick"})
  static final class e
    implements AdapterView.OnItemClickListener
  {
    e(PhotoDoodlePlugin paramPhotoDoodlePlugin) {}
    
    public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      AppMethodBeat.i(237390);
      b localb = new b();
      localb.bm(paramAdapterView);
      localb.bm(paramView);
      localb.pH(paramInt);
      localb.zo(paramLong);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$initView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
      if (paramView == null)
      {
        paramAdapterView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
        AppMethodBeat.o(237390);
        throw paramAdapterView;
      }
      if (((a)paramView).getType() == this.BTg.getSelectType())
      {
        this.BTg.VE(((a)paramView).getType());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$initView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(237390);
        return;
      }
      this.BTg.setSelectType(((a)paramView).getType());
      this.BTg.VE(((a)paramView).getType());
      paramAdapterView = (Iterable)this.BTg.getResourceArray();
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
            j.hxH();
          }
          if (i == paramInt)
          {
            paramAdapterView = this.BTg.getColorList();
            if (paramAdapterView != null) {}
            for (paramAdapterView = paramAdapterView.getChildAt(i); paramAdapterView == null; paramAdapterView = null)
            {
              paramAdapterView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(237390);
              throw paramAdapterView;
            }
            if (!((a)paramAdapterView).yLb)
            {
              paramAdapterView = this.BTg.getColorList();
              if (paramAdapterView != null) {}
              for (paramAdapterView = paramAdapterView.getChildAt(i); paramAdapterView == null; paramAdapterView = null)
              {
                paramAdapterView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                AppMethodBeat.o(237390);
                throw paramAdapterView;
              }
              PhotoDoodlePlugin.c((a)paramAdapterView);
              i = j;
            }
          }
          else
          {
            paramAdapterView = this.BTg.getColorList();
            if (paramAdapterView != null) {}
            for (paramAdapterView = paramAdapterView.getChildAt(i); paramAdapterView == null; paramAdapterView = null)
            {
              paramAdapterView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(237390);
              throw paramAdapterView;
            }
            if (((a)paramAdapterView).yLb)
            {
              paramAdapterView = this.BTg.getColorList();
              if (paramAdapterView != null) {}
              for (paramAdapterView = paramAdapterView.getChildAt(i); paramAdapterView == null; paramAdapterView = null)
              {
                paramAdapterView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                AppMethodBeat.o(237390);
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
          AppMethodBeat.o(237390);
          return;
        }
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin
 * JD-Core Version:    0.7.0.1
 */