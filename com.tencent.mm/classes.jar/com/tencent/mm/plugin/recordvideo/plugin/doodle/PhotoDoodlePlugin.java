package com.tencent.mm.plugin.recordvideo.plugin.doodle;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.a.c;
import com.tencent.mm.plugin.recordvideo.b.d;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.plugin.v.a;
import com.tencent.mm.ui.bb;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "colorList", "Landroid/widget/GridView;", "getColorList", "()Landroid/widget/GridView;", "setColorList", "(Landroid/widget/GridView;)V", "imageSizeDP", "", "getImageSizeDP", "()I", "mStatus", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "getMStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setMStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "paddingDp", "getPaddingDp", "resourceArray", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$ClickImageViewResource;", "Lkotlin/collections/ArrayList;", "getResourceArray", "()Ljava/util/ArrayList;", "selectType", "getSelectType", "setSelectType", "(I)V", "unDoImageView", "Landroid/widget/ImageView;", "getUnDoImageView", "()Landroid/widget/ImageView;", "setUnDoImageView", "(Landroid/widget/ImageView;)V", "getLayout", "hideMosaic", "", "hide", "", "initResourceArray", "msc", "Landroid/graphics/Bitmap;", "brush", "initView", "onBackPress", "postFuncType", "type", "resetClickBigImageView", "view", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/ClickBigImageView;", "selectClickBigImageView", "setStatus", "status", "setVisibility", "visibility", "ClickImageViewResource", "ClickImageViewResourceAdapter", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public class PhotoDoodlePlugin
  extends RelativeLayout
  implements v
{
  public static final PhotoDoodlePlugin.c NMy;
  private final int NMk;
  private final ArrayList<a> NMl;
  private com.tencent.mm.plugin.recordvideo.plugin.parent.a NMm;
  private ImageView NMn;
  public GridView NMo;
  private final int NMz;
  private int selectType;
  
  static
  {
    AppMethodBeat.i(75733);
    NMy = new PhotoDoodlePlugin.c((byte)0);
    AppMethodBeat.o(75733);
  }
  
  public PhotoDoodlePlugin(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75732);
    this.NMl = new ArrayList();
    this.selectType = 2;
    this.NMk = 34;
    this.NMz = 6;
    LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup)this, true);
    this.NMn = ((ImageView)findViewById(b.e.recall));
    paramContext = this.NMn;
    if (paramContext != null) {
      paramContext.setImageDrawable(bb.m(getContext(), b.g.icons_filled_previous, -1));
    }
    paramContext = this.NMn;
    if (paramContext != null) {
      paramContext.setOnClickListener(new PhotoDoodlePlugin..ExternalSyntheticLambda0(this));
    }
    this.NMo = ((GridView)findViewById(b.e.color_list));
    paramContext = BitmapFactory.decodeResource(getContext().getResources(), b.d.icons_filled_brush);
    c(BitmapFactory.decodeResource(getContext().getResources(), b.d.icons_filled_msc), paramContext);
    paramContext = this.NMo;
    if (paramContext != null) {
      paramContext.setAdapter((ListAdapter)new b(this.NMl));
    }
    paramContext = this.NMo;
    if (paramContext != null) {
      paramContext.setOnItemClickListener(new PhotoDoodlePlugin..ExternalSyntheticLambda1(this));
    }
    AppMethodBeat.o(75732);
  }
  
  private static final void a(PhotoDoodlePlugin paramPhotoDoodlePlugin, View paramView)
  {
    AppMethodBeat.i(280626);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramPhotoDoodlePlugin);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramPhotoDoodlePlugin, "this$0");
    paramPhotoDoodlePlugin = paramPhotoDoodlePlugin.getMStatus();
    if (paramPhotoDoodlePlugin != null) {
      a.b.a(paramPhotoDoodlePlugin, a.c.NPg);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(280626);
  }
  
  private static final void a(PhotoDoodlePlugin paramPhotoDoodlePlugin, AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(280647);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramPhotoDoodlePlugin);
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", localObject, localb.aYj());
    s.u(paramPhotoDoodlePlugin, "this$0");
    if (paramView == null)
    {
      paramPhotoDoodlePlugin = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
      AppMethodBeat.o(280647);
      throw paramPhotoDoodlePlugin;
    }
    if (((a)paramView).getType() == paramPhotoDoodlePlugin.getSelectType())
    {
      paramPhotoDoodlePlugin.agD(((a)paramView).getType());
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(280647);
      return;
    }
    paramView.announceForAccessibility((CharSequence)com.tencent.mm.cd.a.bt(((a)paramView).getContext(), b.h.aging_color_pencil_click_use));
    paramPhotoDoodlePlugin.setSelectType(((a)paramView).getType());
    paramPhotoDoodlePlugin.agD(((a)paramView).getType());
    paramView = ((Iterable)paramPhotoDoodlePlugin.getResourceArray()).iterator();
    int i = 0;
    for (;;)
    {
      int j;
      if (paramView.hasNext())
      {
        paramView.next();
        j = i + 1;
        if (i < 0) {
          p.kkW();
        }
        if (i == paramInt)
        {
          paramAdapterView = paramPhotoDoodlePlugin.getColorList();
          if (paramAdapterView == null) {}
          for (paramAdapterView = null; paramAdapterView == null; paramAdapterView = paramAdapterView.getChildAt(i))
          {
            paramPhotoDoodlePlugin = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
            AppMethodBeat.o(280647);
            throw paramPhotoDoodlePlugin;
          }
          if (!((a)paramAdapterView).KhA)
          {
            paramAdapterView = paramPhotoDoodlePlugin.getColorList();
            if (paramAdapterView == null) {}
            for (paramAdapterView = null; paramAdapterView == null; paramAdapterView = paramAdapterView.getChildAt(i))
            {
              paramPhotoDoodlePlugin = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(280647);
              throw paramPhotoDoodlePlugin;
            }
            ((a)paramAdapterView).setHasSelected(true);
            i = j;
          }
        }
        else
        {
          paramAdapterView = paramPhotoDoodlePlugin.getColorList();
          if (paramAdapterView == null) {}
          for (paramAdapterView = null; paramAdapterView == null; paramAdapterView = paramAdapterView.getChildAt(i))
          {
            paramPhotoDoodlePlugin = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
            AppMethodBeat.o(280647);
            throw paramPhotoDoodlePlugin;
          }
          if (((a)paramAdapterView).KhA)
          {
            paramAdapterView = paramPhotoDoodlePlugin.getColorList();
            if (paramAdapterView == null) {}
            for (paramAdapterView = null; paramAdapterView == null; paramAdapterView = paramAdapterView.getChildAt(i))
            {
              paramPhotoDoodlePlugin = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(280647);
              throw paramPhotoDoodlePlugin;
            }
            ((a)paramAdapterView).setHasSelected(false);
          }
          i = j;
        }
      }
      else
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(280647);
        return;
      }
      i = j;
    }
  }
  
  private void agD(int paramInt)
  {
    AppMethodBeat.i(75731);
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = new Bundle();
      ((Bundle)localObject).putInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT", paramInt);
      com.tencent.mm.plugin.recordvideo.plugin.parent.a locala = this.NMm;
      if (locala != null) {
        locala.a(a.c.NPf, (Bundle)localObject);
      }
      break;
    }
    do
    {
      do
      {
        AppMethodBeat.o(75731);
        return;
        localObject = this.NMm;
      } while (localObject == null);
      a.b.a((com.tencent.mm.plugin.recordvideo.plugin.parent.a)localObject, a.c.NPd);
      AppMethodBeat.o(75731);
      return;
      localObject = this.NMm;
    } while (localObject == null);
    a.b.a((com.tencent.mm.plugin.recordvideo.plugin.parent.a)localObject, a.c.NPe);
    AppMethodBeat.o(75731);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280812);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(280812);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(280834);
    s.u(this, "this");
    AppMethodBeat.o(280834);
  }
  
  public final void c(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    AppMethodBeat.i(163442);
    this.NMl.clear();
    if (paramBitmap1 != null)
    {
      localObject = this.NMl;
      a locala = new a();
      locala.bitmap = paramBitmap1;
      locala.type = 99;
      paramBitmap1 = ah.aiuX;
      ((ArrayList)localObject).add(locala);
    }
    if (paramBitmap2 != null)
    {
      paramBitmap1 = this.NMl;
      localObject = new a();
      ((a)localObject).bitmap = paramBitmap2;
      ((a)localObject).type = 100;
      paramBitmap2 = ah.aiuX;
      paramBitmap1.add(localObject);
    }
    paramBitmap1 = this.NMl;
    paramBitmap2 = new a();
    paramBitmap2.color = -1;
    paramBitmap2.type = 0;
    Object localObject = ah.aiuX;
    paramBitmap1.add(paramBitmap2);
    paramBitmap1 = this.NMl;
    paramBitmap2 = new a();
    paramBitmap2.color = -16777216;
    paramBitmap2.type = 1;
    localObject = ah.aiuX;
    paramBitmap1.add(paramBitmap2);
    paramBitmap1 = this.NMl;
    paramBitmap2 = new a();
    paramBitmap2.color = -707825;
    paramBitmap2.type = 2;
    localObject = ah.aiuX;
    paramBitmap1.add(paramBitmap2);
    paramBitmap1 = this.NMl;
    paramBitmap2 = new a();
    paramBitmap2.color = -17592;
    paramBitmap2.type = 3;
    localObject = ah.aiuX;
    paramBitmap1.add(paramBitmap2);
    paramBitmap1 = this.NMl;
    paramBitmap2 = new a();
    paramBitmap2.color = -16535286;
    paramBitmap2.type = 4;
    localObject = ah.aiuX;
    paramBitmap1.add(paramBitmap2);
    paramBitmap1 = this.NMl;
    paramBitmap2 = new a();
    paramBitmap2.color = -15172610;
    paramBitmap2.type = 5;
    localObject = ah.aiuX;
    paramBitmap1.add(paramBitmap2);
    paramBitmap1 = this.NMl;
    paramBitmap2 = new a();
    paramBitmap2.color = -7054596;
    paramBitmap2.type = 6;
    localObject = ah.aiuX;
    paramBitmap1.add(paramBitmap2);
    AppMethodBeat.o(163442);
  }
  
  protected final GridView getColorList()
  {
    return this.NMo;
  }
  
  protected final int getImageSizeDP()
  {
    return this.NMk;
  }
  
  public final int getLayout()
  {
    return b.f.photo_doodle_layout;
  }
  
  public final com.tencent.mm.plugin.recordvideo.plugin.parent.a getMStatus()
  {
    return this.NMm;
  }
  
  protected final int getPaddingDp()
  {
    return this.NMz;
  }
  
  protected final ArrayList<a> getResourceArray()
  {
    return this.NMl;
  }
  
  protected final int getSelectType()
  {
    return this.selectType;
  }
  
  protected final ImageView getUnDoImageView()
  {
    return this.NMn;
  }
  
  public final String name()
  {
    AppMethodBeat.i(280819);
    String str = v.a.b(this);
    AppMethodBeat.o(280819);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(280829);
    s.u(this, "this");
    AppMethodBeat.o(280829);
  }
  
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
  
  public final void onDetach()
  {
    AppMethodBeat.i(280842);
    s.u(this, "this");
    AppMethodBeat.o(280842);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(280849);
    s.u(this, "this");
    AppMethodBeat.o(280849);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280855);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(280855);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(280860);
    s.u(this, "this");
    AppMethodBeat.o(280860);
  }
  
  public final void release()
  {
    AppMethodBeat.i(280863);
    s.u(this, "this");
    AppMethodBeat.o(280863);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(280866);
    s.u(this, "this");
    AppMethodBeat.o(280866);
  }
  
  protected final void setColorList(GridView paramGridView)
  {
    this.NMo = paramGridView;
  }
  
  public final void setMStatus(com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    this.NMm = parama;
  }
  
  protected final void setSelectType(int paramInt)
  {
    this.selectType = paramInt;
  }
  
  public final void setStatus(com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(75728);
    s.u(parama, "status");
    this.NMm = parama;
    AppMethodBeat.o(75728);
  }
  
  protected final void setUnDoImageView(ImageView paramImageView)
  {
    this.NMn = paramImageView;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75729);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      Iterator localIterator = ((Iterable)this.NMl).iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        localIterator.next();
        int j = i + 1;
        if (i < 0) {
          p.kkW();
        }
        localObject = getColorList();
        if (localObject == null)
        {
          localObject = null;
          if (localObject == null) {
            break label281;
          }
          localObject = getColorList();
          if (localObject != null) {
            break label130;
          }
        }
        label130:
        for (localObject = null;; localObject = ((GridView)localObject).getChildAt(i))
        {
          if (localObject != null) {
            break label141;
          }
          localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
          AppMethodBeat.o(75729);
          throw ((Throwable)localObject);
          localObject = ((GridView)localObject).getChildAt(i);
          break;
        }
        label141:
        if (((a)localObject).getType() != getSelectType())
        {
          localObject = getColorList();
          if (localObject == null) {}
          for (localObject = null; localObject == null; localObject = ((GridView)localObject).getChildAt(i))
          {
            localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
            AppMethodBeat.o(75729);
            throw ((Throwable)localObject);
          }
          ((a)localObject).setHasSelected(false);
          i = j;
        }
        else
        {
          localObject = getColorList();
          if (localObject == null) {}
          for (localObject = null; localObject == null; localObject = ((GridView)localObject).getChildAt(i))
          {
            localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
            AppMethodBeat.o(75729);
            throw ((Throwable)localObject);
          }
          ((a)localObject).setHasSelected(true);
          label281:
          i = j;
        }
      }
      agD(this.selectType);
    }
    Object localObject = this.NMo;
    if (localObject != null) {
      ((GridView)localObject).setVisibility(paramInt);
    }
    localObject = this.NMn;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(paramInt);
    }
    AppMethodBeat.o(75729);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$ClickImageViewResource;", "", "()V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "type", "getType", "setType", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    Bitmap bitmap;
    int color;
    int type;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$ClickImageViewResourceAdapter;", "Landroid/widget/BaseAdapter;", "resourceArray", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$ClickImageViewResource;", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin;Ljava/util/ArrayList;)V", "getResourceArray", "()Ljava/util/ArrayList;", "setResourceArray", "(Ljava/util/ArrayList;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class b
    extends BaseAdapter
  {
    private ArrayList<PhotoDoodlePlugin.a> NMl;
    
    public b()
    {
      AppMethodBeat.i(75727);
      this.NMl = localObject;
      AppMethodBeat.o(75727);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(75726);
      int i = this.NMl.size();
      AppMethodBeat.o(75726);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(75725);
      Object localObject = this.NMl.get(paramInt);
      s.s(localObject, "resourceArray[position]");
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
      s.checkNotNull(paramViewGroup);
      paramView = paramViewGroup.getContext();
      s.s(paramView, "parent!!.context");
      paramViewGroup = new a(paramView);
      paramView = (PhotoDoodlePlugin.a)getItem(paramInt);
      Object localObject;
      if (paramView.bitmap == null)
      {
        paramViewGroup.setDrawColor(paramView.color);
        localObject = c.NDf;
        c.aO((View)paramViewGroup, paramView.color);
        paramViewGroup.setType(paramView.type);
        paramViewGroup.setBgPadding(PhotoDoodlePlugin.this.getPaddingDp());
        paramView = PhotoDoodlePlugin.this.getColorList();
        if (paramView != null) {
          break label197;
        }
        paramView = null;
        label102:
        paramInt = com.tencent.mm.cd.a.fromDPToPix(paramView, PhotoDoodlePlugin.this.getImageSizeDP());
        paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(paramInt, paramInt));
        if (paramViewGroup.getType() != PhotoDoodlePlugin.this.getSelectType()) {
          break label205;
        }
        paramViewGroup.setHasSelected(true);
      }
      for (;;)
      {
        paramView = (View)paramViewGroup;
        AppMethodBeat.o(75724);
        return paramView;
        localObject = paramView.bitmap;
        s.checkNotNull(localObject);
        paramViewGroup.setBitmap((Bitmap)localObject);
        localObject = c.NDf;
        c.aO((View)paramViewGroup, paramView.type);
        break;
        label197:
        paramView = paramView.getContext();
        break label102;
        label205:
        paramViewGroup.setHasSelected(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin
 * JD-Core Version:    0.7.0.1
 */