package com.tencent.mm.plugin.taskbar.ui.section.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.ui.section.b.a;
import com.tencent.mm.plugin.taskbar.ui.section.e.b;
import com.tencent.mm.plugin.taskbar.ui.section.g;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.cso;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/section/music/TaskBarSectionMusicView;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionListView;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "canAddToMinimize", "", "onBindViewHolder", "", "viewHolder", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionListView$BaseViewHolder;", "pos", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "p1", "titleName", "", "Companion", "plugin-taskbar_release"})
@SuppressLint({"ViewConstructor"})
public final class a
  extends com.tencent.mm.plugin.taskbar.ui.section.e
{
  public static final a.a FVO;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(238544);
    FVO = new a.a((byte)0);
    AppMethodBeat.o(238544);
  }
  
  private a(Context paramContext, b.a parama, int paramInt)
  {
    super(paramContext, parama, paramInt, null, 0);
    AppMethodBeat.i(238543);
    AppMethodBeat.o(238543);
  }
  
  public a(Context paramContext, b.a parama, int paramInt, char paramChar)
  {
    this(paramContext, parama, paramInt, (byte)0);
  }
  
  public final e.b K(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(238541);
    p.h(paramViewGroup, "p0");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496656, paramViewGroup, false);
    p.g(paramViewGroup, "LayoutInflater.from(p0.c…st_music_item, p0, false)");
    paramViewGroup = new e.b(paramViewGroup);
    AppMethodBeat.o(238541);
    return paramViewGroup;
  }
  
  public final void a(e.b paramb, int paramInt)
  {
    AppMethodBeat.i(238542);
    p.h(paramb, "viewHolder");
    Object localObject3 = new cso();
    for (;;)
    {
      try
      {
        ((cso)localObject3).parseFrom(((MultiTaskInfo)getViewModel().FVI.get(paramInt)).field_data);
        localObject1 = paramb.FVD;
        p.g(localObject1, "viewHolder.defaultImage");
        ((WeImageView)localObject1).setVisibility(0);
        paramb.image.setImageDrawable(null);
        localObject1 = ((cso)localObject3).jfy;
        Object localObject2;
        if (localObject1 != null)
        {
          localObject2 = ((css)localObject1).jfz;
          if (localObject2 != null)
          {
            localObject1 = ((cso)localObject3).jfy;
            if (localObject1 == null) {
              break label476;
            }
            localObject1 = ((css)localObject1).Ktp;
            localObject1 = (CharSequence)localObject1;
            if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
              break label482;
            }
            i = 1;
            if ((i != 0) && (s.YS((String)localObject2)))
            {
              localObject1 = BitmapUtil.decodeFileWithSample((String)localObject2);
              if (localObject1 != null)
              {
                Log.i("TaskBarSectionMusicView", "use cover path: ".concat(String.valueOf(localObject2)));
                paramb.image.setImageBitmap((Bitmap)localObject1);
              }
            }
          }
        }
        localObject1 = paramb.image;
        p.g(localObject1, "viewHolder.image");
        if (((ImageView)localObject1).getDrawable() == null)
        {
          localObject1 = ((cso)localObject3).jfy;
          if (localObject1 != null)
          {
            localObject2 = ((css)localObject1).Ktp;
            localObject1 = localObject2;
            if (localObject2 != null) {}
          }
          else
          {
            localObject1 = ((cso)localObject3).MxD;
          }
          if (localObject1 != null)
          {
            Log.i("TaskBarSectionMusicView", "use url: ".concat(String.valueOf(localObject1)));
            localObject2 = com.tencent.mm.loader.e.hXU;
            localObject2 = com.tencent.mm.loader.e.aJs();
            localObject3 = paramb.image;
            p.g(localObject3, "viewHolder.image");
            ((com.tencent.mm.loader.a)localObject2).a((String)localObject1, (ImageView)localObject3, getThumbLoaderOption());
          }
        }
        localObject1 = paramb.hbb;
        p.g(localObject1, "viewHolder.title");
        ((TextView)localObject1).setText((CharSequence)((MultiTaskInfo)getViewModel().FVI.get(paramInt)).erh().title);
        localObject1 = paramb.orb;
        p.g(localObject1, "viewHolder.subTitle");
        ((TextView)localObject1).setText((CharSequence)"");
        localObject1 = ((MultiTaskInfo)getViewModel().FVI.get(paramInt)).erh().nickname;
        if (localObject1 == null) {
          break label594;
        }
        if (((CharSequence)localObject1).length() <= 0) {
          break label487;
        }
        i = 1;
        if (i != 1) {
          break label594;
        }
        localObject1 = paramb.orb;
        p.g(localObject1, "viewHolder.subTitle");
        localObject1 = ((TextView)localObject1).getParent();
        if (localObject1 != null) {
          break;
        }
        paramb = new t("null cannot be cast to non-null type android.widget.LinearLayout");
        AppMethodBeat.o(238542);
        throw paramb;
      }
      catch (Throwable paramb)
      {
        Log.e("TaskBarSectionMusicView", "MusicMultiTaskData parse failed");
        AppMethodBeat.o(238542);
        return;
      }
      label476:
      localObject1 = null;
      continue;
      label482:
      int i = 0;
      continue;
      label487:
      i = 0;
    }
    ((LinearLayout)localObject1).setGravity(0);
    Object localObject1 = paramb.orb;
    p.g(localObject1, "viewHolder.subTitle");
    ((TextView)localObject1).setVisibility(0);
    paramb = paramb.orb;
    p.g(paramb, "viewHolder.subTitle");
    paramb.setText((CharSequence)(((MultiTaskInfo)getViewModel().FVI.get(paramInt)).erh().nickname + getResources().getString(2131763368)));
    AppMethodBeat.o(238542);
    return;
    label594:
    localObject1 = paramb.orb;
    p.g(localObject1, "viewHolder.subTitle");
    ((TextView)localObject1).setVisibility(8);
    paramb = paramb.orb;
    p.g(paramb, "viewHolder.subTitle");
    paramb = paramb.getParent();
    if (paramb == null)
    {
      paramb = new t("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(238542);
      throw paramb;
    }
    ((LinearLayout)paramb).setGravity(16);
    AppMethodBeat.o(238542);
  }
  
  public final View ewN()
  {
    AppMethodBeat.i(238545);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(2131299174));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(2131299174);
      this._$_findViewCache.put(Integer.valueOf(2131299174), localView1);
    }
    AppMethodBeat.o(238545);
    return localView1;
  }
  
  public final String fvi()
  {
    AppMethodBeat.i(238540);
    String str = getContext().getString(2131755732);
    p.g(str, "context.getString(R.stri…nd_taskbar_section_music)");
    AppMethodBeat.o(238540);
    return str;
  }
  
  public final boolean fvj()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.c.a
 * JD-Core Version:    0.7.0.1
 */