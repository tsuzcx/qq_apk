package com.tencent.mm.plugin.taskbar.ui.section.weapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.a;
import com.tencent.mm.plugin.taskbar.ui.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public class TaskBarSectionMyWeAppRecyclerView
  extends TaskBarSectionWeAppRecyclerView
{
  public TaskBarSectionMyWeAppRecyclerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TaskBarSectionMyWeAppRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TaskBarSectionMyWeAppRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final void Q(float paramFloat1, float paramFloat2) {}
  
  protected final void a(RecyclerView.v paramv, View paramView, AppBrandDesktopView.a parama, int paramInt)
  {
    AppMethodBeat.i(215660);
    if (this.MrL != null) {
      this.MrL.a(paramv, paramView, parama, paramInt, true);
    }
    AppMethodBeat.o(215660);
  }
  
  public final void a(AppBrandDesktopView.a parama)
  {
    AppMethodBeat.i(215658);
    Log.i("MicroMsg.AppBrandDesktopSectionWeAppRecyclerView", "notifyItemInserted %d %d %s %s", new Object[] { Integer.valueOf(0), Integer.valueOf(getDataList().size()), parama.rqa.nickname, d.il(getDataList()) });
    int i = 0;
    int j;
    if (i < getShowList().size())
    {
      Object localObject = (AppBrandDesktopView.a)getShowList().get(i);
      if ((parama.rqa != null) && (((AppBrandDesktopView.a)localObject).rqa != null) && (!Util.isNullOrNil(parama.rqa.username)) && (!Util.isNullOrNil(((AppBrandDesktopView.a)localObject).rqa.username)))
      {
        localObject = ((AppBrandDesktopView.a)localObject).rqa;
        LocalUsageInfo localLocalUsageInfo = parama.rqa;
        if ((localLocalUsageInfo != null) && (!Util.isNullOrNil(localLocalUsageInfo.username)) && (localLocalUsageInfo.username.equals(((LocalUsageInfo)localObject).username)) && (localLocalUsageInfo.cBU == ((LocalUsageInfo)localObject).cBU))
        {
          j = 1;
          label190:
          if (j == 0) {
            break label308;
          }
          j = 1;
          label196:
          if (j == 0) {
            break label313;
          }
        }
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        getShowList().remove(i);
        getShowList().add(0, parama);
        getDataList().remove(i);
        getDataList().add(0, parama);
        this.afJ.aF(i, 0);
      }
      for (;;)
      {
        Log.i("MicroMsg.AppBrandDesktopSectionWeAppRecyclerView", "notifyItemInserted filled %s", new Object[] { d.il(getDataList()) });
        this.afJ.e(0, this.afJ.getItemCount(), Boolean.TRUE);
        AppMethodBeat.o(215658);
        return;
        j = 0;
        break label190;
        label308:
        j = 0;
        break label196;
        label313:
        i += 1;
        break;
        getShowList().add(0, parama);
        getDataList().add(0, parama);
        if (getShowList().size() > 8)
        {
          getShowList().remove(8);
          this.afJ.cN(7);
        }
        this.afJ.cM(0);
      }
      i = -1;
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(215661);
    if (this.MrL != null) {
      this.MrL.a((AppBrandDesktopView.a)getDataList().get(paramb.md()), true);
    }
    AppMethodBeat.o(215661);
  }
  
  protected final void b(int paramInt, AppBrandDesktopView.a parama)
  {
    AppMethodBeat.i(215662);
    this.MrL.b(parama, paramInt);
    AppMethodBeat.o(215662);
  }
  
  protected final void d(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected final void gkk()
  {
    AppMethodBeat.i(215659);
    if (this.MrL != null) {
      this.MrL.gjK();
    }
    AppMethodBeat.o(215659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionMyWeAppRecyclerView
 * JD-Core Version:    0.7.0.1
 */