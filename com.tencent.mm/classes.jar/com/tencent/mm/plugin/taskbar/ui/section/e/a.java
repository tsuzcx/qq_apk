package com.tencent.mm.plugin.taskbar.ui.section.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.ui.section.b.a;
import com.tencent.mm.plugin.taskbar.ui.section.e.b;
import com.tencent.mm.plugin.taskbar.ui.section.g;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.fah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/section/webview/TaskBarSectionWebViewView;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionListView;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "onBindViewHolder", "", "viewHolder", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionListView$BaseViewHolder;", "pos", "titleName", "", "Companion", "plugin-taskbar_release"})
@SuppressLint({"ViewConstructor"})
public final class a
  extends com.tencent.mm.plugin.taskbar.ui.section.e
{
  public static final a.a FWg;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(238569);
    FWg = new a.a((byte)0);
    AppMethodBeat.o(238569);
  }
  
  private a(Context paramContext, b.a parama, int paramInt)
  {
    super(paramContext, parama, paramInt, null, 0);
    AppMethodBeat.i(238568);
    AppMethodBeat.o(238568);
  }
  
  public a(Context paramContext, b.a parama, int paramInt, char paramChar)
  {
    this(paramContext, parama, paramInt, (byte)0);
  }
  
  public final void a(e.b paramb, int paramInt)
  {
    AppMethodBeat.i(238567);
    p.h(paramb, "viewHolder");
    Object localObject1 = new fah();
    try
    {
      ((fah)localObject1).parseFrom(((MultiTaskInfo)getViewModel().FVI.get(paramInt)).field_data);
      Object localObject2 = ((fah)localObject1).coverUrl;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ((MultiTaskInfo)getViewModel().FVI.get(paramInt)).erh().MwR;
      }
      localObject2 = paramb.FVD;
      p.g(localObject2, "viewHolder.defaultImage");
      ((WeImageView)localObject2).setVisibility(0);
      paramb.image.setImageDrawable(null);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.loader.e.hXU;
        localObject2 = com.tencent.mm.loader.e.aJs();
        ImageView localImageView = paramb.image;
        p.g(localImageView, "viewHolder.image");
        ((com.tencent.mm.loader.a)localObject2).a((String)localObject1, localImageView, getThumbLoaderOption());
      }
      localObject1 = paramb.hbb;
      p.g(localObject1, "viewHolder.title");
      ((TextView)localObject1).setText((CharSequence)((MultiTaskInfo)getViewModel().FVI.get(paramInt)).erh().title);
      localObject1 = paramb.orb;
      p.g(localObject1, "viewHolder.subTitle");
      ((TextView)localObject1).setText((CharSequence)"");
      localObject1 = ((MultiTaskInfo)getViewModel().FVI.get(paramInt)).erh().nickname;
      if (localObject1 != null) {
        if (((CharSequence)localObject1).length() > 0)
        {
          i = 1;
          if (i == 1)
          {
            paramb = paramb.orb;
            p.g(paramb, "viewHolder.subTitle");
            paramb.setText((CharSequence)((MultiTaskInfo)getViewModel().FVI.get(paramInt)).erh().nickname);
          }
          AppMethodBeat.o(238567);
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("AppBrandDesktopSectionWebViewView", "WebMultiTaskData parse failed");
        continue;
        int i = 0;
      }
      AppMethodBeat.o(238567);
    }
  }
  
  public final View ewN()
  {
    AppMethodBeat.i(238570);
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
    AppMethodBeat.o(238570);
    return localView1;
  }
  
  public final String fvi()
  {
    AppMethodBeat.i(238566);
    String str = getContext().getString(2131755735);
    p.g(str, "context.getString(R.stri…_taskbar_section_webview)");
    AppMethodBeat.o(238566);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.e.a
 * JD-Core Version:    0.7.0.1
 */