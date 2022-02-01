package com.tencent.mm.plugin.recordvideo.plugin.doodle;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
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
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.u;
import com.tencent.mm.plugin.recordvideo.plugin.u.a;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "isLand", "", "mRootView", "Landroid/widget/RelativeLayout;", "(ZLandroid/widget/RelativeLayout;)V", "colorList", "Landroid/widget/GridView;", "getColorList", "()Landroid/widget/GridView;", "setColorList", "(Landroid/widget/GridView;)V", "imageSizeDP", "", "getImageSizeDP", "()I", "setImageSizeDP", "(I)V", "()Z", "setLand", "(Z)V", "mContentView", "mFinishLayout", "getMRootView", "()Landroid/widget/RelativeLayout;", "setMRootView", "(Landroid/widget/RelativeLayout;)V", "mStatus", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "getMStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setMStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "resourceArray", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$ClickImageViewResource;", "Lkotlin/collections/ArrayList;", "getResourceArray", "()Ljava/util/ArrayList;", "selectType", "getSelectType", "setSelectType", "unDoImageView", "Landroid/widget/ImageView;", "getUnDoImageView", "()Landroid/widget/ImageView;", "setUnDoImageView", "(Landroid/widget/ImageView;)V", "value", "visibility", "getVisibility", "()Ljava/lang/Integer;", "setVisibility", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getItemMargin", "context", "Landroid/content/Context;", "initResourceArray", "", "initView", "onBackPress", "postFuncType", "type", "refreshDoodleLayout", "rootView", "resetClickBigImageView", "view", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/ClickBigImageView;", "selectClickBigImageView", "setStatus", "status", "ClickImageViewResource", "ClickImageViewResourceAdapter", "Companion", "plugin-recordvideo_release"})
public final class b
  implements u
{
  private static final int HPJ = -855310;
  private static final int HPK = -16777216;
  private static final int HPL = -707825;
  private static final int HPM = -17592;
  private static final int HPN = -16535286;
  private static final int HPO = -15172610;
  private static final int HPP = -7054596;
  private static final int HPQ = -449092;
  public static final c HPR;
  private RelativeLayout FCc;
  private Integer FyW;
  int HPD;
  final ArrayList<a> HPE;
  public d HPF;
  private ImageView HPG;
  GridView HPH;
  private boolean HPI;
  private RelativeLayout qcr;
  int selectType;
  
  static
  {
    AppMethodBeat.i(216111);
    HPR = new c((byte)0);
    HPJ = -855310;
    HPK = -16777216;
    HPL = -707825;
    HPM = -17592;
    HPN = -16535286;
    HPO = -15172610;
    HPP = -7054596;
    HPQ = -449092;
    AppMethodBeat.o(216111);
  }
  
  public b(boolean paramBoolean, RelativeLayout paramRelativeLayout)
  {
    AppMethodBeat.i(216110);
    this.HPI = paramBoolean;
    this.qcr = paramRelativeLayout;
    this.HPD = 32;
    this.HPE = new ArrayList();
    this.selectType = 2;
    a(this.HPI, this.qcr);
    AppMethodBeat.o(216110);
  }
  
  private static int hR(Context paramContext)
  {
    AppMethodBeat.i(216093);
    p.k(paramContext, "context");
    int i = ax.au(paramContext).x;
    int j = ax.au(paramContext).y;
    if (i > j) {
      i = j;
    }
    for (;;)
    {
      i = (i - aw.fromDPToPix(paramContext, 314)) / 7;
      AppMethodBeat.o(216093);
      return i;
    }
  }
  
  private final void wD(boolean paramBoolean)
  {
    AppMethodBeat.i(216100);
    if (paramBoolean)
    {
      this.HPE.clear();
      localArrayList = this.HPE;
      locala = new a();
      locala.color = HPP;
      locala.type = 6;
      localArrayList.add(locala);
      localArrayList = this.HPE;
      locala = new a();
      locala.color = HPO;
      locala.type = 5;
      localArrayList.add(locala);
      localArrayList = this.HPE;
      locala = new a();
      locala.color = HPN;
      locala.type = 4;
      localArrayList.add(locala);
      localArrayList = this.HPE;
      locala = new a();
      locala.color = HPM;
      locala.type = 3;
      localArrayList.add(locala);
      localArrayList = this.HPE;
      locala = new a();
      locala.color = HPL;
      locala.type = 2;
      localArrayList.add(locala);
      localArrayList = this.HPE;
      locala = new a();
      locala.color = HPK;
      locala.type = 1;
      localArrayList.add(locala);
      localArrayList = this.HPE;
      locala = new a();
      locala.color = HPJ;
      locala.type = 0;
      localArrayList.add(locala);
      AppMethodBeat.o(216100);
      return;
    }
    this.HPE.clear();
    ArrayList localArrayList = this.HPE;
    a locala = new a();
    locala.color = HPJ;
    locala.type = 0;
    localArrayList.add(locala);
    localArrayList = this.HPE;
    locala = new a();
    locala.color = HPK;
    locala.type = 1;
    localArrayList.add(locala);
    localArrayList = this.HPE;
    locala = new a();
    locala.color = HPL;
    locala.type = 2;
    localArrayList.add(locala);
    localArrayList = this.HPE;
    locala = new a();
    locala.color = HPM;
    locala.type = 3;
    localArrayList.add(locala);
    localArrayList = this.HPE;
    locala = new a();
    locala.color = HPN;
    locala.type = 4;
    localArrayList.add(locala);
    localArrayList = this.HPE;
    locala = new a();
    locala.color = HPO;
    locala.type = 5;
    localArrayList.add(locala);
    localArrayList = this.HPE;
    locala = new a();
    locala.color = HPP;
    locala.type = 6;
    localArrayList.add(locala);
    AppMethodBeat.o(216100);
  }
  
  public final void a(boolean paramBoolean, RelativeLayout paramRelativeLayout)
  {
    AppMethodBeat.i(216095);
    p.k(paramRelativeLayout, "rootView");
    if (paramBoolean) {}
    for (int i = b.f.screen_doodle_layout_land;; i = b.f.screen_doodle_layout)
    {
      localObject = LayoutInflater.from(paramRelativeLayout.getContext()).inflate(i, (ViewGroup)paramRelativeLayout);
      if (localObject != null) {
        break;
      }
      paramRelativeLayout = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(216095);
      throw paramRelativeLayout;
    }
    this.FCc = ((RelativeLayout)localObject);
    Object localObject = this.FCc;
    if (localObject != null) {}
    for (localObject = (ImageView)((RelativeLayout)localObject).findViewById(com.tencent.mm.plugin.recordvideo.b.e.recall);; localObject = null)
    {
      this.HPG = ((ImageView)localObject);
      localObject = this.HPG;
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(au.o(paramRelativeLayout.getContext(), b.g.icons_filled_previous, -1));
      }
      localObject = this.HPG;
      if (localObject != null) {
        ((ImageView)localObject).setOnClickListener((View.OnClickListener)new d(this));
      }
      this.HPH = ((GridView)paramRelativeLayout.findViewById(com.tencent.mm.plugin.recordvideo.b.e.color_list));
      if (paramBoolean)
      {
        localObject = this.HPH;
        if (localObject != null)
        {
          paramRelativeLayout = paramRelativeLayout.getContext();
          p.j(paramRelativeLayout, "rootView.context");
          ((GridView)localObject).setVerticalSpacing(hR(paramRelativeLayout));
        }
      }
      wD(paramBoolean);
      paramRelativeLayout = this.HPH;
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setAdapter((ListAdapter)new b(this.HPE));
      }
      paramRelativeLayout = this.HPH;
      if (paramRelativeLayout == null) {
        break;
      }
      paramRelativeLayout.setOnItemClickListener((AdapterView.OnItemClickListener)new e(this));
      AppMethodBeat.o(216095);
      return;
    }
    AppMethodBeat.o(216095);
  }
  
  protected final void acn(int paramInt)
  {
    AppMethodBeat.i(216108);
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
        AppMethodBeat.o(216108);
        return;
      }
      break;
    case 99: 
      localObject = this.HPF;
      if (localObject != null)
      {
        d.b.a((d)localObject, d.c.HSx);
        AppMethodBeat.o(216108);
        return;
      }
      AppMethodBeat.o(216108);
      return;
    case 100: 
      localObject = this.HPF;
      if (localObject != null)
      {
        d.b.a((d)localObject, d.c.HSy);
        AppMethodBeat.o(216108);
        return;
      }
      AppMethodBeat.o(216108);
      return;
    }
    AppMethodBeat.o(216108);
  }
  
  public final void bbp() {}
  
  public final String name()
  {
    AppMethodBeat.i(216113);
    String str = getClass().getName();
    AppMethodBeat.o(216113);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(216105);
    Object localObject = this.FCc;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((RelativeLayout)localObject).getVisibility());
      if (localObject != null) {
        break label40;
      }
    }
    label40:
    while (((Integer)localObject).intValue() != 0)
    {
      AppMethodBeat.o(216105);
      return false;
      localObject = null;
      break;
    }
    t(Integer.valueOf(4));
    AppMethodBeat.o(216105);
    return true;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(216123);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(216123);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(216103);
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
            break label276;
          }
          localObject = this.HPH;
          if (localObject == null) {
            break label130;
          }
        }
        label130:
        for (localObject = ((GridView)localObject).getChildAt(i);; localObject = null)
        {
          if (localObject != null) {
            break label136;
          }
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
          AppMethodBeat.o(216103);
          throw ((Throwable)localObject);
          localObject = null;
          break;
        }
        label136:
        if (((a)localObject).getType() != this.selectType)
        {
          localObject = this.HPH;
          if (localObject != null) {}
          for (localObject = ((GridView)localObject).getChildAt(i); localObject == null; localObject = null)
          {
            localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
            AppMethodBeat.o(216103);
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
            AppMethodBeat.o(216103);
            throw ((Throwable)localObject);
          }
          ((a)localObject).setHasSelected(true);
          label276:
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
      AppMethodBeat.o(216103);
      return;
    }
    AppMethodBeat.o(216103);
  }
  
  public final void t(Integer paramInteger)
  {
    AppMethodBeat.i(216091);
    Object localObject;
    if (paramInteger != null)
    {
      localObject = this.FCc;
      if (localObject != null) {
        ((RelativeLayout)localObject).setVisibility(paramInteger.intValue());
      }
    }
    if (paramInteger == null) {}
    for (;;)
    {
      this.FyW = paramInteger;
      AppMethodBeat.o(216091);
      return;
      if (paramInteger.intValue() == 0)
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
              break label313;
            }
            localObject = this.HPH;
            if (localObject == null) {
              break label171;
            }
          }
          label171:
          for (localObject = ((GridView)localObject).getChildAt(i);; localObject = null)
          {
            if (localObject != null) {
              break label177;
            }
            paramInteger = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
            AppMethodBeat.o(216091);
            throw paramInteger;
            localObject = null;
            break;
          }
          label177:
          if (((a)localObject).getType() != this.selectType)
          {
            localObject = this.HPH;
            if (localObject != null) {}
            for (localObject = ((GridView)localObject).getChildAt(i); localObject == null; localObject = null)
            {
              paramInteger = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(216091);
              throw paramInteger;
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
              paramInteger = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(216091);
              throw paramInteger;
            }
            ((a)localObject).setHasSelected(true);
            label313:
            i = j;
          }
        }
        acn(this.selectType);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$ClickImageViewResource;", "", "()V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "type", "getType", "setType", "plugin-recordvideo_release"})
  public static final class a
  {
    Bitmap bitmap;
    int color;
    int type;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$ClickImageViewResourceAdapter;", "Landroid/widget/BaseAdapter;", "resourceArray", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$ClickImageViewResource;", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin;Ljava/util/ArrayList;)V", "getResourceArray", "()Ljava/util/ArrayList;", "setResourceArray", "(Ljava/util/ArrayList;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-recordvideo_release"})
  final class b
    extends BaseAdapter
  {
    private ArrayList<b.a> HPE;
    
    public b()
    {
      AppMethodBeat.i(217001);
      this.HPE = localObject;
      AppMethodBeat.o(217001);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(217000);
      int i = this.HPE.size();
      AppMethodBeat.o(217000);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(216999);
      Object localObject = this.HPE.get(paramInt);
      p.j(localObject, "resourceArray[position]");
      AppMethodBeat.o(216999);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(216996);
      if (paramViewGroup == null) {
        p.iCn();
      }
      paramView = paramViewGroup.getContext();
      p.j(paramView, "parent!!.context");
      paramViewGroup = new a(paramView, true);
      paramView = getItem(paramInt);
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.MultiTalkScreenDoodlePlugin.ClickImageViewResource");
        AppMethodBeat.o(216996);
        throw paramView;
      }
      paramView = (b.a)paramView;
      if (paramView.bitmap == null)
      {
        paramViewGroup.setDrawColor(paramView.color);
        paramViewGroup.setType(paramView.type);
        paramView = b.this.HPH;
        if (paramView == null) {
          break label187;
        }
        paramView = paramView.getContext();
        label105:
        paramInt = com.tencent.mm.ci.a.fromDPToPix(paramView, b.this.HPD);
        paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(paramInt, paramInt));
        if (paramViewGroup.getType() != b.this.selectType) {
          break label192;
        }
        paramViewGroup.setHasSelected(true);
      }
      for (;;)
      {
        paramView = (View)paramViewGroup;
        AppMethodBeat.o(216996);
        return paramView;
        Bitmap localBitmap = paramView.bitmap;
        if (localBitmap == null) {
          p.iCn();
        }
        paramViewGroup.setBitmap(localBitmap);
        break;
        label187:
        paramView = null;
        break label105;
        label192:
        paramViewGroup.setHasSelected(false);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$Companion;", "", "()V", "COLOR_0", "", "COLOR_1", "COLOR_2", "COLOR_3", "COLOR_4", "COLOR_5", "COLOR_6", "COLOR_7", "plugin-recordvideo_release"})
  public static final class c {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(217785);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$refreshDoodleLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.HPS.HPF;
      if (paramView != null) {
        d.b.a(paramView, d.c.HSA);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$refreshDoodleLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(217785);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "a", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "b", "Landroid/view/View;", "position", "", "d", "", "onItemClick"})
  static final class e
    implements AdapterView.OnItemClickListener
  {
    e(b paramb) {}
    
    public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      AppMethodBeat.i(221138);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramAdapterView);
      localb.bn(paramView);
      localb.sg(paramInt);
      localb.Fs(paramLong);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$refreshDoodleLayout$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
      if (paramView == null)
      {
        paramAdapterView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
        AppMethodBeat.o(221138);
        throw paramAdapterView;
      }
      if (((a)paramView).getType() == this.HPS.selectType)
      {
        this.HPS.acn(((a)paramView).getType());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$refreshDoodleLayout$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(221138);
        return;
      }
      this.HPS.selectType = ((a)paramView).getType();
      this.HPS.acn(((a)paramView).getType());
      paramAdapterView = (Iterable)this.HPS.HPE;
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
            paramAdapterView = this.HPS.HPH;
            if (paramAdapterView != null) {}
            for (paramAdapterView = paramAdapterView.getChildAt(i); paramAdapterView == null; paramAdapterView = null)
            {
              paramAdapterView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(221138);
              throw paramAdapterView;
            }
            if (!((a)paramAdapterView).EoU)
            {
              paramAdapterView = this.HPS.HPH;
              if (paramAdapterView != null) {}
              for (paramAdapterView = paramAdapterView.getChildAt(i); paramAdapterView == null; paramAdapterView = null)
              {
                paramAdapterView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                AppMethodBeat.o(221138);
                throw paramAdapterView;
              }
              b.a((a)paramAdapterView);
              i = j;
            }
          }
          else
          {
            paramAdapterView = this.HPS.HPH;
            if (paramAdapterView != null) {}
            for (paramAdapterView = paramAdapterView.getChildAt(i); paramAdapterView == null; paramAdapterView = null)
            {
              paramAdapterView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(221138);
              throw paramAdapterView;
            }
            if (((a)paramAdapterView).EoU)
            {
              paramAdapterView = this.HPS.HPH;
              if (paramAdapterView != null) {}
              for (paramAdapterView = paramAdapterView.getChildAt(i); paramAdapterView == null; paramAdapterView = null)
              {
                paramAdapterView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                AppMethodBeat.o(221138);
                throw paramAdapterView;
              }
              b.b((a)paramAdapterView);
            }
            i = j;
          }
        }
        else
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$refreshDoodleLayout$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(221138);
          return;
        }
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.doodle.b
 * JD-Core Version:    0.7.0.1
 */