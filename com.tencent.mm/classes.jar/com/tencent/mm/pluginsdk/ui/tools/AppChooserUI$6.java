package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

final class AppChooserUI$6
  implements m
{
  AppChooserUI$6(AppChooserUI paramAppChooserUI) {}
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(125862);
    ab.d("MicroMsg.AppChooserUI", "onTaskFailed downloadId:%s", new Object[] { Long.valueOf(paramLong) });
    g.RL().Ru().set(AppChooserUI.a(this.wdL, 274560), Long.valueOf(0L));
    if (AppChooserUI.a(this.wdL) != null)
    {
      AppChooserUI.a(this.wdL).wdM = AppChooserUI.f.wdX;
      AppChooserUI.a(this.wdL).notifyDataSetChanged();
    }
    AppMethodBeat.o(125862);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(125861);
    ab.d("MicroMsg.AppChooserUI", "onTaskFinished downloadId: %d, savedPath: %s", new Object[] { Long.valueOf(paramLong), paramString });
    if ((!bo.isNullOrNil(paramString)) && (com.tencent.mm.a.e.cN(paramString)))
    {
      g.RL().Ru().set(AppChooserUI.a(this.wdL, 274560), Long.valueOf(AppChooserUI.j(this.wdL)));
      if ((AppChooserUI.a(this.wdL) != null) && (AppChooserUI.j(this.wdL) == paramLong))
      {
        AppChooserUI.a(this.wdL).wdM = AppChooserUI.f.wdZ;
        AppChooserUI.a(this.wdL).notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(125861);
  }
  
  public final void hx(long paramLong) {}
  
  public final void hy(long paramLong) {}
  
  public final void i(long paramLong, String paramString) {}
  
  public final void onTaskPaused(long paramLong)
  {
    AppMethodBeat.i(125863);
    ab.d("MicroMsg.AppChooserUI", "onTaskPaused downloadId:%s", new Object[] { Long.valueOf(paramLong) });
    g.RL().Ru().set(AppChooserUI.a(this.wdL, 274560), Long.valueOf(0L));
    if (AppChooserUI.a(this.wdL) != null)
    {
      AppChooserUI.a(this.wdL).wdM = AppChooserUI.f.wdX;
      AppChooserUI.a(this.wdL).notifyDataSetChanged();
    }
    AppMethodBeat.o(125863);
  }
  
  public final void onTaskRemoved(long paramLong)
  {
    AppMethodBeat.i(125860);
    ab.d("MicroMsg.AppChooserUI", "onTaskRemove downloadId:%s", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(125860);
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    AppMethodBeat.i(125859);
    AppChooserUI.a(this.wdL, paramLong);
    g.RL().Ru().set(AppChooserUI.a(this.wdL, 274560), Long.valueOf(AppChooserUI.j(this.wdL)));
    ab.d("MicroMsg.AppChooserUI", "onTaskStarted downloadId:%s savedFilePath:%s", new Object[] { String.valueOf(paramLong), paramString });
    AppMethodBeat.o(125859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.6
 * JD-Core Version:    0.7.0.1
 */