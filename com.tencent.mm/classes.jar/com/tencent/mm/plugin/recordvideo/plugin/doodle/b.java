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
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "isLand", "", "mRootView", "Landroid/widget/RelativeLayout;", "(ZLandroid/widget/RelativeLayout;)V", "colorList", "Landroid/widget/GridView;", "getColorList", "()Landroid/widget/GridView;", "setColorList", "(Landroid/widget/GridView;)V", "imageSizeDP", "", "getImageSizeDP", "()I", "setImageSizeDP", "(I)V", "()Z", "setLand", "(Z)V", "mContentView", "mFinishLayout", "getMRootView", "()Landroid/widget/RelativeLayout;", "setMRootView", "(Landroid/widget/RelativeLayout;)V", "mStatus", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "getMStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setMStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "resourceArray", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$ClickImageViewResource;", "Lkotlin/collections/ArrayList;", "getResourceArray", "()Ljava/util/ArrayList;", "selectType", "getSelectType", "setSelectType", "unDoImageView", "Landroid/widget/ImageView;", "getUnDoImageView", "()Landroid/widget/ImageView;", "setUnDoImageView", "(Landroid/widget/ImageView;)V", "value", "visibility", "getVisibility", "()Ljava/lang/Integer;", "setVisibility", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getItemMargin", "context", "Landroid/content/Context;", "initResourceArray", "", "initView", "onBackPress", "postFuncType", "type", "refreshDoodleLayout", "rootView", "resetClickBigImageView", "view", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/ClickBigImageView;", "selectClickBigImageView", "setStatus", "status", "ClickImageViewResource", "ClickImageViewResourceAdapter", "Companion", "plugin-recordvideo_release"})
public final class b
  implements com.tencent.mm.plugin.recordvideo.plugin.t
{
  private static final int BSV = -855310;
  private static final int BSW = -16777216;
  private static final int BSX = -707825;
  private static final int BSY = -17592;
  private static final int BSZ = -16535286;
  private static final int BTa = -15172610;
  private static final int BTb = -7054596;
  private static final int BTc = -449092;
  public static final b.c BTd;
  int BSP;
  final ArrayList<a> BSQ;
  public d BSR;
  private ImageView BSS;
  GridView BST;
  private boolean BSU;
  int jVX;
  private RelativeLayout ncd;
  private Integer zTu;
  private RelativeLayout zWt;
  
  static
  {
    AppMethodBeat.i(237385);
    BTd = new b.c((byte)0);
    BSV = -855310;
    BSW = -16777216;
    BSX = -707825;
    BSY = -17592;
    BSZ = -16535286;
    BTa = -15172610;
    BTb = -7054596;
    BTc = -449092;
    AppMethodBeat.o(237385);
  }
  
  public b(boolean paramBoolean, RelativeLayout paramRelativeLayout)
  {
    AppMethodBeat.i(237384);
    this.BSU = paramBoolean;
    this.ncd = paramRelativeLayout;
    this.BSP = 32;
    this.BSQ = new ArrayList();
    this.jVX = 2;
    a(this.BSU, this.ncd);
    AppMethodBeat.o(237384);
  }
  
  private static int gP(Context paramContext)
  {
    AppMethodBeat.i(237378);
    p.h(paramContext, "context");
    int i = au.az(paramContext).x;
    int j = au.az(paramContext).y;
    if (i > j) {
      i = j;
    }
    for (;;)
    {
      i = (i - at.fromDPToPix(paramContext, 314)) / 7;
      AppMethodBeat.o(237378);
      return i;
    }
  }
  
  private final void th(boolean paramBoolean)
  {
    AppMethodBeat.i(237380);
    if (paramBoolean)
    {
      this.BSQ.clear();
      localArrayList = this.BSQ;
      locala = new a();
      locala.color = BTb;
      locala.type = 6;
      localArrayList.add(locala);
      localArrayList = this.BSQ;
      locala = new a();
      locala.color = BTa;
      locala.type = 5;
      localArrayList.add(locala);
      localArrayList = this.BSQ;
      locala = new a();
      locala.color = BSZ;
      locala.type = 4;
      localArrayList.add(locala);
      localArrayList = this.BSQ;
      locala = new a();
      locala.color = BSY;
      locala.type = 3;
      localArrayList.add(locala);
      localArrayList = this.BSQ;
      locala = new a();
      locala.color = BSX;
      locala.type = 2;
      localArrayList.add(locala);
      localArrayList = this.BSQ;
      locala = new a();
      locala.color = BSW;
      locala.type = 1;
      localArrayList.add(locala);
      localArrayList = this.BSQ;
      locala = new a();
      locala.color = BSV;
      locala.type = 0;
      localArrayList.add(locala);
      AppMethodBeat.o(237380);
      return;
    }
    this.BSQ.clear();
    ArrayList localArrayList = this.BSQ;
    a locala = new a();
    locala.color = BSV;
    locala.type = 0;
    localArrayList.add(locala);
    localArrayList = this.BSQ;
    locala = new a();
    locala.color = BSW;
    locala.type = 1;
    localArrayList.add(locala);
    localArrayList = this.BSQ;
    locala = new a();
    locala.color = BSX;
    locala.type = 2;
    localArrayList.add(locala);
    localArrayList = this.BSQ;
    locala = new a();
    locala.color = BSY;
    locala.type = 3;
    localArrayList.add(locala);
    localArrayList = this.BSQ;
    locala = new a();
    locala.color = BSZ;
    locala.type = 4;
    localArrayList.add(locala);
    localArrayList = this.BSQ;
    locala = new a();
    locala.color = BTa;
    locala.type = 5;
    localArrayList.add(locala);
    localArrayList = this.BSQ;
    locala = new a();
    locala.color = BTb;
    locala.type = 6;
    localArrayList.add(locala);
    AppMethodBeat.o(237380);
  }
  
  protected final void VE(int paramInt)
  {
    AppMethodBeat.i(237383);
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
        AppMethodBeat.o(237383);
        return;
      }
      break;
    case 99: 
      localObject = this.BSR;
      if (localObject != null)
      {
        d.b.a((d)localObject, d.c.BVJ);
        AppMethodBeat.o(237383);
        return;
      }
      AppMethodBeat.o(237383);
      return;
    case 100: 
      localObject = this.BSR;
      if (localObject != null)
      {
        d.b.a((d)localObject, d.c.BVK);
        AppMethodBeat.o(237383);
        return;
      }
      AppMethodBeat.o(237383);
      return;
    }
    AppMethodBeat.o(237383);
  }
  
  public final void a(boolean paramBoolean, RelativeLayout paramRelativeLayout)
  {
    AppMethodBeat.i(237379);
    p.h(paramRelativeLayout, "rootView");
    if (paramBoolean) {}
    for (int i = 2131496161;; i = 2131496160)
    {
      localObject = LayoutInflater.from(paramRelativeLayout.getContext()).inflate(i, (ViewGroup)paramRelativeLayout);
      if (localObject != null) {
        break;
      }
      paramRelativeLayout = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(237379);
      throw paramRelativeLayout;
    }
    this.zWt = ((RelativeLayout)localObject);
    Object localObject = this.zWt;
    if (localObject != null) {}
    for (localObject = (ImageView)((RelativeLayout)localObject).findViewById(2131306607);; localObject = null)
    {
      this.BSS = ((ImageView)localObject);
      localObject = this.BSS;
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(ar.m(paramRelativeLayout.getContext(), 2131690650, -1));
      }
      localObject = this.BSS;
      if (localObject != null) {
        ((ImageView)localObject).setOnClickListener((View.OnClickListener)new d(this));
      }
      this.BST = ((GridView)paramRelativeLayout.findViewById(2131298912));
      if (paramBoolean)
      {
        localObject = this.BST;
        if (localObject != null)
        {
          paramRelativeLayout = paramRelativeLayout.getContext();
          p.g(paramRelativeLayout, "rootView.context");
          ((GridView)localObject).setVerticalSpacing(gP(paramRelativeLayout));
        }
      }
      th(paramBoolean);
      paramRelativeLayout = this.BST;
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setAdapter((ListAdapter)new b(this.BSQ));
      }
      paramRelativeLayout = this.BST;
      if (paramRelativeLayout == null) {
        break;
      }
      paramRelativeLayout.setOnItemClickListener((AdapterView.OnItemClickListener)new e(this));
      AppMethodBeat.o(237379);
      return;
    }
    AppMethodBeat.o(237379);
  }
  
  public final void aSs() {}
  
  public final void l(Integer paramInteger)
  {
    AppMethodBeat.i(237377);
    Object localObject;
    if (paramInteger != null)
    {
      localObject = this.zWt;
      if (localObject != null) {
        ((RelativeLayout)localObject).setVisibility(paramInteger.intValue());
      }
    }
    if (paramInteger == null) {}
    for (;;)
    {
      this.zTu = paramInteger;
      AppMethodBeat.o(237377);
      return;
      if (paramInteger.intValue() == 0)
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
              break label313;
            }
            localObject = this.BST;
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
            paramInteger = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
            AppMethodBeat.o(237377);
            throw paramInteger;
            localObject = null;
            break;
          }
          label177:
          if (((a)localObject).getType() != this.jVX)
          {
            localObject = this.BST;
            if (localObject != null) {}
            for (localObject = ((GridView)localObject).getChildAt(i); localObject == null; localObject = null)
            {
              paramInteger = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(237377);
              throw paramInteger;
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
              paramInteger = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(237377);
              throw paramInteger;
            }
            ((a)localObject).setHasSelected(true);
            label313:
            i = j;
          }
        }
        VE(this.jVX);
      }
    }
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(237382);
    Object localObject = this.zWt;
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
      AppMethodBeat.o(237382);
      return false;
      localObject = null;
      break;
    }
    l(Integer.valueOf(4));
    AppMethodBeat.o(237382);
    return true;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(237386);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(237386);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(237381);
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
            break label276;
          }
          localObject = this.BST;
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
          localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
          AppMethodBeat.o(237381);
          throw ((Throwable)localObject);
          localObject = null;
          break;
        }
        label136:
        if (((a)localObject).getType() != this.jVX)
        {
          localObject = this.BST;
          if (localObject != null) {}
          for (localObject = ((GridView)localObject).getChildAt(i); localObject == null; localObject = null)
          {
            localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
            AppMethodBeat.o(237381);
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
            AppMethodBeat.o(237381);
            throw ((Throwable)localObject);
          }
          ((a)localObject).setHasSelected(true);
          label276:
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
      AppMethodBeat.o(237381);
      return;
    }
    AppMethodBeat.o(237381);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$ClickImageViewResource;", "", "()V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "type", "getType", "setType", "plugin-recordvideo_release"})
  public static final class a
  {
    Bitmap bitmap;
    int color;
    int type;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$ClickImageViewResourceAdapter;", "Landroid/widget/BaseAdapter;", "resourceArray", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$ClickImageViewResource;", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin;Ljava/util/ArrayList;)V", "getResourceArray", "()Ljava/util/ArrayList;", "setResourceArray", "(Ljava/util/ArrayList;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-recordvideo_release"})
  final class b
    extends BaseAdapter
  {
    private ArrayList<b.a> BSQ;
    
    public b()
    {
      AppMethodBeat.i(237374);
      this.BSQ = localObject;
      AppMethodBeat.o(237374);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(237373);
      int i = this.BSQ.size();
      AppMethodBeat.o(237373);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(237372);
      Object localObject = this.BSQ.get(paramInt);
      p.g(localObject, "resourceArray[position]");
      AppMethodBeat.o(237372);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(237371);
      if (paramViewGroup == null) {
        p.hyc();
      }
      paramView = paramViewGroup.getContext();
      p.g(paramView, "parent!!.context");
      paramViewGroup = new a(paramView, true);
      paramView = getItem(paramInt);
      if (paramView == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.MultiTalkScreenDoodlePlugin.ClickImageViewResource");
        AppMethodBeat.o(237371);
        throw paramView;
      }
      paramView = (b.a)paramView;
      if (paramView.bitmap == null)
      {
        paramViewGroup.setDrawColor(paramView.color);
        paramViewGroup.setType(paramView.type);
        paramView = b.this.BST;
        if (paramView == null) {
          break label187;
        }
        paramView = paramView.getContext();
        label105:
        paramInt = com.tencent.mm.cb.a.fromDPToPix(paramView, b.this.BSP);
        paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(paramInt, paramInt));
        if (paramViewGroup.getType() != b.this.jVX) {
          break label192;
        }
        paramViewGroup.setHasSelected(true);
      }
      for (;;)
      {
        paramView = (View)paramViewGroup;
        AppMethodBeat.o(237371);
        return paramView;
        Bitmap localBitmap = paramView.bitmap;
        if (localBitmap == null) {
          p.hyc();
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(237375);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$refreshDoodleLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.BTe.BSR;
      if (paramView != null) {
        d.b.a(paramView, d.c.BVM);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$refreshDoodleLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(237375);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "a", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "b", "Landroid/view/View;", "position", "", "d", "", "onItemClick"})
  static final class e
    implements AdapterView.OnItemClickListener
  {
    e(b paramb) {}
    
    public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      AppMethodBeat.i(237376);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramAdapterView);
      localb.bm(paramView);
      localb.pH(paramInt);
      localb.zo(paramLong);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$refreshDoodleLayout$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
      if (paramView == null)
      {
        paramAdapterView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
        AppMethodBeat.o(237376);
        throw paramAdapterView;
      }
      if (((a)paramView).getType() == this.BTe.jVX)
      {
        this.BTe.VE(((a)paramView).getType());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$refreshDoodleLayout$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(237376);
        return;
      }
      this.BTe.jVX = ((a)paramView).getType();
      this.BTe.VE(((a)paramView).getType());
      paramAdapterView = (Iterable)this.BTe.BSQ;
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
            paramAdapterView = this.BTe.BST;
            if (paramAdapterView != null) {}
            for (paramAdapterView = paramAdapterView.getChildAt(i); paramAdapterView == null; paramAdapterView = null)
            {
              paramAdapterView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(237376);
              throw paramAdapterView;
            }
            if (!((a)paramAdapterView).yLb)
            {
              paramAdapterView = this.BTe.BST;
              if (paramAdapterView != null) {}
              for (paramAdapterView = paramAdapterView.getChildAt(i); paramAdapterView == null; paramAdapterView = null)
              {
                paramAdapterView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                AppMethodBeat.o(237376);
                throw paramAdapterView;
              }
              b.a((a)paramAdapterView);
              i = j;
            }
          }
          else
          {
            paramAdapterView = this.BTe.BST;
            if (paramAdapterView != null) {}
            for (paramAdapterView = paramAdapterView.getChildAt(i); paramAdapterView == null; paramAdapterView = null)
            {
              paramAdapterView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(237376);
              throw paramAdapterView;
            }
            if (((a)paramAdapterView).yLb)
            {
              paramAdapterView = this.BTe.BST;
              if (paramAdapterView != null) {}
              for (paramAdapterView = paramAdapterView.getChildAt(i); paramAdapterView == null; paramAdapterView = null)
              {
                paramAdapterView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                AppMethodBeat.o(237376);
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
          AppMethodBeat.o(237376);
          return;
        }
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.doodle.b
 * JD-Core Version:    0.7.0.1
 */