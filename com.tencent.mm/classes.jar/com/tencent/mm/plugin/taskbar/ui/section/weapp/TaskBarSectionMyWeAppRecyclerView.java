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
  
  protected final void a(RecyclerView.v paramv, View paramView, AppBrandDesktopView.a parama, int paramInt)
  {
    AppMethodBeat.i(264408);
    if (this.SUI != null) {
      this.SUI.a(paramv, paramView, parama, paramInt, true);
    }
    AppMethodBeat.o(264408);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(264417);
    if (this.SUI != null) {
      getDataList().get(paramb.KJ());
    }
    AppMethodBeat.o(264417);
  }
  
  protected final void aw(float paramFloat1, float paramFloat2) {}
  
  public final void b(int paramInt, AppBrandDesktopView.a parama)
  {
    AppMethodBeat.i(264379);
    int i = getDataList().size();
    Log.i("MicroMsg.AppBrandDesktopSectionWeAppRecyclerView", "notifyItemInserted showlist filled %s", new Object[] { d.lr(getShowList()) });
    Log.i("MicroMsg.AppBrandDesktopSectionWeAppRecyclerView", "notifyItemInserted %d %d %s %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), parama.uAl.nickname, d.lr(getDataList()) });
    paramInt = 0;
    if (paramInt < getShowList().size()) {
      if (!parama.a((AppBrandDesktopView.a)getShowList().get(paramInt))) {}
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        getShowList().remove(paramInt);
        getDataList().remove(paramInt);
        getDataList().add(parama);
        i = getShowList().size();
        getShowList().add((AppBrandDesktopView.a)getDataList().get(i));
        this.bUp.fX(paramInt);
        this.bUp.fW(i);
        Log.i("MicroMsg.AppBrandDesktopSectionWeAppRecyclerView", "notifyItemInserted showlist filled %s", new Object[] { d.lr(getShowList()) });
        Log.i("MicroMsg.AppBrandDesktopSectionWeAppRecyclerView", "notifyItemInserted filled %s", new Object[] { d.lr(getDataList()) });
        this.bUp.e(0, this.bUp.getItemCount(), Boolean.TRUE);
        AppMethodBeat.o(264379);
        return;
        paramInt += 1;
        break;
      }
      paramInt = getShowList().size();
      if (paramInt < 8)
      {
        getShowList().add(paramInt, parama);
        this.bUp.fW(paramInt);
      }
      paramInt = 0;
      for (;;)
      {
        if (paramInt < getDataList().size())
        {
          if (parama.a((AppBrandDesktopView.a)getDataList().get(paramInt))) {
            getDataList().remove(paramInt);
          }
        }
        else
        {
          getDataList().add(parama);
          if (getShowList().size() <= 8) {
            break;
          }
          getShowList().remove(8);
          this.bUp.fX(7);
          break;
        }
        paramInt += 1;
      }
      paramInt = -1;
    }
  }
  
  protected final void c(int paramInt, AppBrandDesktopView.a parama)
  {
    AppMethodBeat.i(264426);
    this.SUI.b(parama, paramInt);
    AppMethodBeat.o(264426);
  }
  
  protected final void d(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected final void eeP()
  {
    AppMethodBeat.i(264397);
    if (this.SUI != null) {
      this.SUI.hDK();
    }
    AppMethodBeat.o(264397);
  }
  
  protected final boolean kLQ()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionMyWeAppRecyclerView
 * JD-Core Version:    0.7.0.1
 */