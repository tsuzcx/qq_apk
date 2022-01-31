package com.tencent.xweb.xwalk.a;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.f;
import org.xwalk.core.XWalkLibraryLoader.DownloadInfo;
import org.xwalk.core.XWalkLibraryLoader.DownloadListener;

public final class h$c
  implements XWalkLibraryLoader.DownloadListener
{
  private c BKG;
  private d BKH;
  private h BKu;
  
  h$c(h paramh, c paramc, d paramd)
  {
    this.BKu = paramh;
    this.BKG = paramc;
    this.BKH = paramd;
  }
  
  public final void onDownloadCancelled()
  {
    AppMethodBeat.i(85429);
    this.BKu.fm(this.BKG.eak(), -3);
    if (this.BKG.eak().equals("FullScreenVideo"))
    {
      f.dZH();
      AppMethodBeat.o(85429);
      return;
    }
    if (this.BKG.eak().equals("XFilesPPTReader")) {
      f.dZO();
    }
    AppMethodBeat.o(85429);
  }
  
  public final void onDownloadCompleted(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
  {
    AppMethodBeat.i(85430);
    if (this.BKG.eak().equals("FullScreenVideo")) {
      f.dZG();
    }
    for (;;)
    {
      new AsyncTask() {}.execute(new Void[0]);
      AppMethodBeat.o(85430);
      return;
      if (this.BKG.eak().equals("XFilesPPTReader")) {
        f.dZN();
      }
    }
  }
  
  public final void onDownloadFailed(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
  {
    AppMethodBeat.i(85431);
    this.BKu.fm(this.BKG.eak(), -1);
    if (this.BKG.eak().equals("FullScreenVideo"))
    {
      f.dZH();
      AppMethodBeat.o(85431);
      return;
    }
    if (this.BKG.eak().equals("XFilesPPTReader")) {
      f.dZO();
    }
    AppMethodBeat.o(85431);
  }
  
  public final void onDownloadStarted(int paramInt)
  {
    AppMethodBeat.i(85427);
    if (this.BKG.eak().equals("FullScreenVideo"))
    {
      f.dZF();
      AppMethodBeat.o(85427);
      return;
    }
    if (this.BKG.eak().equals("XFilesPPTReader")) {
      f.dZM();
    }
    AppMethodBeat.o(85427);
  }
  
  public final void onDownloadUpdated(int paramInt)
  {
    AppMethodBeat.i(85428);
    h localh = this.BKu;
    String str = this.BKG.eak();
    if ((localh.BKw.BKF == 3) && (localh.eau()) && (localh.BKs.equals(str))) {
      localh.BKt.TB(paramInt);
    }
    AppMethodBeat.o(85428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.h.c
 * JD-Core Version:    0.7.0.1
 */