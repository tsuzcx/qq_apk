package com.tencent.mm.plugin.recordvideo.plugin.doodle;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
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
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.plugin.v.a;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "isLand", "", "mRootView", "Landroid/widget/RelativeLayout;", "(ZLandroid/widget/RelativeLayout;)V", "colorList", "Landroid/widget/GridView;", "getColorList", "()Landroid/widget/GridView;", "setColorList", "(Landroid/widget/GridView;)V", "imageSizeDP", "", "getImageSizeDP", "()I", "setImageSizeDP", "(I)V", "()Z", "setLand", "(Z)V", "mContentView", "mFinishLayout", "getMRootView", "()Landroid/widget/RelativeLayout;", "setMRootView", "(Landroid/widget/RelativeLayout;)V", "mStatus", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "getMStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setMStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "resourceArray", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$ClickImageViewResource;", "Lkotlin/collections/ArrayList;", "getResourceArray", "()Ljava/util/ArrayList;", "selectType", "getSelectType", "setSelectType", "unDoImageView", "Landroid/widget/ImageView;", "getUnDoImageView", "()Landroid/widget/ImageView;", "setUnDoImageView", "(Landroid/widget/ImageView;)V", "value", "visibility", "getVisibility", "()Ljava/lang/Integer;", "setVisibility", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getItemMargin", "context", "Landroid/content/Context;", "initResourceArray", "", "initView", "onBackPress", "postFuncType", "type", "refreshDoodleLayout", "rootView", "resetClickBigImageView", "view", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/ClickBigImageView;", "selectClickBigImageView", "setStatus", "status", "ClickImageViewResource", "ClickImageViewResourceAdapter", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements v
{
  public static final b.c NMj;
  private static final int NMp;
  private static final int NMq;
  private static final int NMr;
  private static final int NMs;
  private static final int NMt;
  private static final int NMu;
  private static final int NMv;
  private static final int NMw;
  private boolean EpG;
  private Integer Lve;
  private RelativeLayout Lyc;
  int NMk;
  private final ArrayList<a> NMl;
  public com.tencent.mm.plugin.recordvideo.plugin.parent.a NMm;
  private ImageView NMn;
  GridView NMo;
  int selectType;
  private RelativeLayout thl;
  
  static
  {
    AppMethodBeat.i(280669);
    NMj = new b.c((byte)0);
    NMp = -855310;
    NMq = -16777216;
    NMr = -707825;
    NMs = -17592;
    NMt = -16535286;
    NMu = -15172610;
    NMv = -7054596;
    NMw = -449092;
    AppMethodBeat.o(280669);
  }
  
  public b(boolean paramBoolean, RelativeLayout paramRelativeLayout)
  {
    AppMethodBeat.i(280600);
    this.EpG = paramBoolean;
    this.thl = paramRelativeLayout;
    this.NMk = 32;
    this.NMl = new ArrayList();
    this.selectType = 2;
    a(this.EpG, this.thl);
    AppMethodBeat.o(280600);
  }
  
  private final void Bd(boolean paramBoolean)
  {
    AppMethodBeat.i(280619);
    if (paramBoolean)
    {
      this.NMl.clear();
      localArrayList = this.NMl;
      locala = new a();
      locala.color = NMv;
      locala.type = 6;
      localah = ah.aiuX;
      localArrayList.add(locala);
      localArrayList = this.NMl;
      locala = new a();
      locala.color = NMu;
      locala.type = 5;
      localah = ah.aiuX;
      localArrayList.add(locala);
      localArrayList = this.NMl;
      locala = new a();
      locala.color = NMt;
      locala.type = 4;
      localah = ah.aiuX;
      localArrayList.add(locala);
      localArrayList = this.NMl;
      locala = new a();
      locala.color = NMs;
      locala.type = 3;
      localah = ah.aiuX;
      localArrayList.add(locala);
      localArrayList = this.NMl;
      locala = new a();
      locala.color = NMr;
      locala.type = 2;
      localah = ah.aiuX;
      localArrayList.add(locala);
      localArrayList = this.NMl;
      locala = new a();
      locala.color = NMq;
      locala.type = 1;
      localah = ah.aiuX;
      localArrayList.add(locala);
      localArrayList = this.NMl;
      locala = new a();
      locala.color = NMp;
      locala.type = 0;
      localah = ah.aiuX;
      localArrayList.add(locala);
      AppMethodBeat.o(280619);
      return;
    }
    this.NMl.clear();
    ArrayList localArrayList = this.NMl;
    a locala = new a();
    locala.color = NMp;
    locala.type = 0;
    ah localah = ah.aiuX;
    localArrayList.add(locala);
    localArrayList = this.NMl;
    locala = new a();
    locala.color = NMq;
    locala.type = 1;
    localah = ah.aiuX;
    localArrayList.add(locala);
    localArrayList = this.NMl;
    locala = new a();
    locala.color = NMr;
    locala.type = 2;
    localah = ah.aiuX;
    localArrayList.add(locala);
    localArrayList = this.NMl;
    locala = new a();
    locala.color = NMs;
    locala.type = 3;
    localah = ah.aiuX;
    localArrayList.add(locala);
    localArrayList = this.NMl;
    locala = new a();
    locala.color = NMt;
    locala.type = 4;
    localah = ah.aiuX;
    localArrayList.add(locala);
    localArrayList = this.NMl;
    locala = new a();
    locala.color = NMu;
    locala.type = 5;
    localah = ah.aiuX;
    localArrayList.add(locala);
    localArrayList = this.NMl;
    locala = new a();
    locala.color = NMv;
    locala.type = 6;
    localah = ah.aiuX;
    localArrayList.add(locala);
    AppMethodBeat.o(280619);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(280639);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb = paramb.NMm;
    if (paramb != null) {
      a.b.a(paramb, a.c.NPg);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(280639);
  }
  
  private static final void a(b paramb, AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(280660);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    if (paramView == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
      AppMethodBeat.o(280660);
      throw paramb;
    }
    if (((a)paramView).getType() == paramb.selectType)
    {
      paramb.agD(((a)paramView).getType());
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(280660);
      return;
    }
    paramb.selectType = ((a)paramView).getType();
    paramb.agD(((a)paramView).getType());
    paramView = ((Iterable)paramb.NMl).iterator();
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
          paramAdapterView = paramb.NMo;
          if (paramAdapterView == null) {}
          for (paramAdapterView = null; paramAdapterView == null; paramAdapterView = paramAdapterView.getChildAt(i))
          {
            paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
            AppMethodBeat.o(280660);
            throw paramb;
          }
          if (!((a)paramAdapterView).KhA)
          {
            paramAdapterView = paramb.NMo;
            if (paramAdapterView == null) {}
            for (paramAdapterView = null; paramAdapterView == null; paramAdapterView = paramAdapterView.getChildAt(i))
            {
              paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(280660);
              throw paramb;
            }
            ((a)paramAdapterView).setHasSelected(true);
            i = j;
          }
        }
        else
        {
          paramAdapterView = paramb.NMo;
          if (paramAdapterView == null) {}
          for (paramAdapterView = null; paramAdapterView == null; paramAdapterView = paramAdapterView.getChildAt(i))
          {
            paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
            AppMethodBeat.o(280660);
            throw paramb;
          }
          if (((a)paramAdapterView).KhA)
          {
            paramAdapterView = paramb.NMo;
            if (paramAdapterView == null) {}
            for (paramAdapterView = null; paramAdapterView == null; paramAdapterView = paramAdapterView.getChildAt(i))
            {
              paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(280660);
              throw paramb;
            }
            ((a)paramAdapterView).setHasSelected(false);
          }
          i = j;
        }
      }
      else
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(280660);
        return;
      }
      i = j;
    }
  }
  
  private void agD(int paramInt)
  {
    AppMethodBeat.i(280630);
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
        AppMethodBeat.o(280630);
        return;
        localObject = this.NMm;
      } while (localObject == null);
      a.b.a((com.tencent.mm.plugin.recordvideo.plugin.parent.a)localObject, a.c.NPd);
      AppMethodBeat.o(280630);
      return;
      localObject = this.NMm;
    } while (localObject == null);
    a.b.a((com.tencent.mm.plugin.recordvideo.plugin.parent.a)localObject, a.c.NPe);
    AppMethodBeat.o(280630);
  }
  
  private static int jq(Context paramContext)
  {
    AppMethodBeat.i(280606);
    s.u(paramContext, "context");
    int i = bf.bf(paramContext).x;
    int j = bf.bf(paramContext).y;
    if (i > j) {
      i = j;
    }
    for (;;)
    {
      i = (i - bd.fromDPToPix(paramContext, 314)) / 7;
      AppMethodBeat.o(280606);
      return i;
    }
  }
  
  public final void A(Integer paramInteger)
  {
    AppMethodBeat.i(280698);
    Object localObject;
    if (paramInteger != null)
    {
      localObject = this.Lyc;
      if (localObject != null) {
        ((RelativeLayout)localObject).setVisibility(paramInteger.intValue());
      }
    }
    if (paramInteger == null) {}
    for (;;)
    {
      this.Lve = paramInteger;
      AppMethodBeat.o(280698);
      return;
      if (paramInteger.intValue() == 0)
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
          localObject = this.NMo;
          if (localObject == null)
          {
            localObject = null;
            if (localObject == null) {
              break label313;
            }
            localObject = this.NMo;
            if (localObject != null) {
              break label166;
            }
          }
          label166:
          for (localObject = null;; localObject = ((GridView)localObject).getChildAt(i))
          {
            if (localObject != null) {
              break label177;
            }
            paramInteger = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
            AppMethodBeat.o(280698);
            throw paramInteger;
            localObject = ((GridView)localObject).getChildAt(i);
            break;
          }
          label177:
          if (((a)localObject).getType() != this.selectType)
          {
            localObject = this.NMo;
            if (localObject == null) {}
            for (localObject = null; localObject == null; localObject = ((GridView)localObject).getChildAt(i))
            {
              paramInteger = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(280698);
              throw paramInteger;
            }
            ((a)localObject).setHasSelected(false);
            i = j;
          }
          else
          {
            localObject = this.NMo;
            if (localObject == null) {}
            for (localObject = null; localObject == null; localObject = ((GridView)localObject).getChildAt(i))
            {
              paramInteger = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(280698);
              throw paramInteger;
            }
            ((a)localObject).setHasSelected(true);
            label313:
            i = j;
          }
        }
        agD(this.selectType);
      }
    }
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280721);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(280721);
  }
  
  public final void a(boolean paramBoolean, RelativeLayout paramRelativeLayout)
  {
    AppMethodBeat.i(280705);
    s.u(paramRelativeLayout, "rootView");
    if (paramBoolean) {}
    for (int i = b.f.screen_doodle_layout_land;; i = b.f.screen_doodle_layout)
    {
      localObject = LayoutInflater.from(paramRelativeLayout.getContext()).inflate(i, (ViewGroup)paramRelativeLayout);
      if (localObject != null) {
        break;
      }
      paramRelativeLayout = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(280705);
      throw paramRelativeLayout;
    }
    this.Lyc = ((RelativeLayout)localObject);
    Object localObject = this.Lyc;
    if (localObject == null) {}
    for (localObject = null;; localObject = (ImageView)((RelativeLayout)localObject).findViewById(b.e.recall))
    {
      this.NMn = ((ImageView)localObject);
      localObject = this.NMn;
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(bb.m(paramRelativeLayout.getContext(), b.g.icons_filled_previous, -1));
      }
      localObject = this.NMn;
      if (localObject != null) {
        ((ImageView)localObject).setOnClickListener(new b..ExternalSyntheticLambda0(this));
      }
      this.NMo = ((GridView)paramRelativeLayout.findViewById(b.e.color_list));
      if (paramBoolean)
      {
        localObject = this.NMo;
        if (localObject != null)
        {
          paramRelativeLayout = paramRelativeLayout.getContext();
          s.s(paramRelativeLayout, "rootView.context");
          ((GridView)localObject).setVerticalSpacing(jq(paramRelativeLayout));
        }
      }
      Bd(paramBoolean);
      paramRelativeLayout = this.NMo;
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setAdapter((ListAdapter)new b(this.NMl));
      }
      paramRelativeLayout = this.NMo;
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setOnItemClickListener(new b..ExternalSyntheticLambda1(this));
      }
      AppMethodBeat.o(280705);
      return;
    }
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(280747);
    s.u(this, "this");
    AppMethodBeat.o(280747);
  }
  
  public final String name()
  {
    AppMethodBeat.i(280730);
    String str = v.a.b(this);
    AppMethodBeat.o(280730);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(280738);
    s.u(this, "this");
    AppMethodBeat.o(280738);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(280714);
    Object localObject = this.Lyc;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label40;
      }
    }
    label40:
    while (((Integer)localObject).intValue() != 0)
    {
      AppMethodBeat.o(280714);
      return false;
      localObject = Integer.valueOf(((RelativeLayout)localObject).getVisibility());
      break;
    }
    A(Integer.valueOf(4));
    AppMethodBeat.o(280714);
    return true;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(280755);
    s.u(this, "this");
    AppMethodBeat.o(280755);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(280763);
    s.u(this, "this");
    AppMethodBeat.o(280763);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280774);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(280774);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(280784);
    s.u(this, "this");
    AppMethodBeat.o(280784);
  }
  
  public final void release()
  {
    AppMethodBeat.i(280794);
    s.u(this, "this");
    AppMethodBeat.o(280794);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(280801);
    s.u(this, "this");
    AppMethodBeat.o(280801);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(280709);
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
        localObject = this.NMo;
        if (localObject == null)
        {
          localObject = null;
          if (localObject == null) {
            break label276;
          }
          localObject = this.NMo;
          if (localObject != null) {
            break label125;
          }
        }
        label125:
        for (localObject = null;; localObject = ((GridView)localObject).getChildAt(i))
        {
          if (localObject != null) {
            break label136;
          }
          localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
          AppMethodBeat.o(280709);
          throw ((Throwable)localObject);
          localObject = ((GridView)localObject).getChildAt(i);
          break;
        }
        label136:
        if (((a)localObject).getType() != this.selectType)
        {
          localObject = this.NMo;
          if (localObject == null) {}
          for (localObject = null; localObject == null; localObject = ((GridView)localObject).getChildAt(i))
          {
            localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
            AppMethodBeat.o(280709);
            throw ((Throwable)localObject);
          }
          ((a)localObject).setHasSelected(false);
          i = j;
        }
        else
        {
          localObject = this.NMo;
          if (localObject == null) {}
          for (localObject = null; localObject == null; localObject = ((GridView)localObject).getChildAt(i))
          {
            localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
            AppMethodBeat.o(280709);
            throw ((Throwable)localObject);
          }
          ((a)localObject).setHasSelected(true);
          label276:
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
    AppMethodBeat.o(280709);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$ClickImageViewResource;", "", "()V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "type", "getType", "setType", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    Bitmap bitmap;
    int color;
    int type;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$ClickImageViewResourceAdapter;", "Landroid/widget/BaseAdapter;", "resourceArray", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$ClickImageViewResource;", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin;Ljava/util/ArrayList;)V", "getResourceArray", "()Ljava/util/ArrayList;", "setResourceArray", "(Ljava/util/ArrayList;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class b
    extends BaseAdapter
  {
    private ArrayList<b.a> NMl;
    
    public b()
    {
      AppMethodBeat.i(280655);
      this.NMl = localObject;
      AppMethodBeat.o(280655);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(280694);
      int i = this.NMl.size();
      AppMethodBeat.o(280694);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(280682);
      Object localObject = this.NMl.get(paramInt);
      s.s(localObject, "resourceArray[position]");
      AppMethodBeat.o(280682);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(280671);
      s.checkNotNull(paramViewGroup);
      paramView = paramViewGroup.getContext();
      s.s(paramView, "parent!!.context");
      paramViewGroup = new a(paramView, true);
      paramView = (b.a)getItem(paramInt);
      if (paramView.bitmap == null)
      {
        paramViewGroup.setDrawColor(paramView.color);
        paramViewGroup.setType(paramView.type);
        paramView = b.this.NMo;
        if (paramView != null) {
          break label155;
        }
        paramView = null;
        label76:
        paramInt = com.tencent.mm.cd.a.fromDPToPix(paramView, b.this.NMk);
        paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(paramInt, paramInt));
        if (paramViewGroup.getType() != b.this.selectType) {
          break label163;
        }
        paramViewGroup.setHasSelected(true);
      }
      for (;;)
      {
        paramView = (View)paramViewGroup;
        AppMethodBeat.o(280671);
        return paramView;
        Bitmap localBitmap = paramView.bitmap;
        s.checkNotNull(localBitmap);
        paramViewGroup.setBitmap(localBitmap);
        break;
        label155:
        paramView = paramView.getContext();
        break label76;
        label163:
        paramViewGroup.setHasSelected(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.doodle.b
 * JD-Core Version:    0.7.0.1
 */