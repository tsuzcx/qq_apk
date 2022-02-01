package com.tencent.mm.plugin.taskbar.ui.section.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.ui.section.b.a;
import com.tencent.mm.plugin.taskbar.ui.section.e;
import com.tencent.mm.plugin.taskbar.ui.section.e.b;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/section/file/TaskBarSectionFileView;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionListView;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "onBindViewHolder", "", "viewHolder", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionListView$BaseViewHolder;", "pos", "titleName", "", "tryCloseOnPause", "", "Companion", "plugin-taskbar_release"})
@SuppressLint({"ViewConstructor"})
public final class a
  extends e
{
  public static final a.a FVM;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(238529);
    FVM = new a.a((byte)0);
    AppMethodBeat.o(238529);
  }
  
  private a(Context paramContext, b.a parama, int paramInt)
  {
    super(paramContext, parama, paramInt, null, 0);
    AppMethodBeat.i(238528);
    AppMethodBeat.o(238528);
  }
  
  public a(Context paramContext, b.a parama, int paramInt, char paramChar)
  {
    this(paramContext, parama, paramInt, (byte)0);
  }
  
  public final void a(e.b paramb, int paramInt)
  {
    AppMethodBeat.i(238526);
    p.h(paramb, "viewHolder");
    int i;
    if (((MultiTaskInfo)getViewModel().FVI.get(paramInt)).field_type == 4) {
      i = 1;
    }
    for (;;)
    {
      aoe localaoe = new aoe();
      if (i != 0) {}
      try
      {
        localaoe.parseFrom(((MultiTaskInfo)getViewModel().FVI.get(paramInt)).field_data);
        Object localObject = paramb.image;
        if (i == 0)
        {
          i = 2131690308;
          ((ImageView)localObject).setImageResource(i);
          localObject = paramb.hbb;
          p.g(localObject, "viewHolder.title");
          com.tencent.mm.ce.g localg = com.tencent.mm.ce.g.gxZ();
          Context localContext = getContext();
          CharSequence localCharSequence = (CharSequence)((MultiTaskInfo)getViewModel().FVI.get(paramInt)).erh().title;
          TextView localTextView = paramb.hbb;
          p.g(localTextView, "viewHolder.title");
          ((TextView)localObject).setText((CharSequence)localg.a(localContext, localCharSequence, localTextView.getTextSize()));
          if (localaoe.LzM <= 0L) {
            break label295;
          }
          localObject = paramb.orb;
          p.g(localObject, "viewHolder.subTitle");
          ((TextView)localObject).setVisibility(0);
          paramb = paramb.orb;
          p.g(paramb, "viewHolder.subTitle");
          paramb.setText((CharSequence)Util.getSizeKB(localaoe.LzM));
          AppMethodBeat.o(238526);
          return;
          i = 0;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e("AppBrandDesktopSectionWebViewView", "FileMultiTaskData parse fail", new Object[] { localThrowable });
          continue;
          i = r.bdt(((MultiTaskInfo)getViewModel().FVI.get(paramInt)).erh().gCr);
        }
        label295:
        paramb = paramb.orb;
        p.g(paramb, "viewHolder.subTitle");
        paramb.setVisibility(4);
        AppMethodBeat.o(238526);
      }
    }
  }
  
  public final boolean abI(int paramInt)
  {
    AppMethodBeat.i(238527);
    if (((MultiTaskInfo)getViewModel().FVI.get(paramInt)).field_type == 4)
    {
      AppMethodBeat.o(238527);
      return true;
    }
    AppMethodBeat.o(238527);
    return false;
  }
  
  public final View ewN()
  {
    AppMethodBeat.i(238530);
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
    AppMethodBeat.o(238530);
    return localView1;
  }
  
  public final String fvi()
  {
    AppMethodBeat.i(238525);
    String str = getContext().getString(2131755730);
    p.g(str, "context.getString(R.stri…and_taskbar_section_file)");
    AppMethodBeat.o(238525);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.a.a
 * JD-Core Version:    0.7.0.1
 */