package com.tencent.mm.view.refreshLayout.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/refreshLayout/status/RefreshState;", "", "role", "", "dragging", "", "opening", "finishing", "releaseToOpening", "(Ljava/lang/String;IIZZZZ)V", "isDragging", "()Z", "isFinishing", "isFooter", "isHeader", "isOpening", "isReleaseToOpening", "toFooter", "toHeader", "LoadFinish", "LoadReleased", "Loading", "None", "PullDownCanceled", "PullDownToRefresh", "PullUpCanceled", "PullUpToLoad", "RefreshFinish", "RefreshReleased", "Refreshing", "ReleaseToLoad", "ReleaseToRefresh", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum b
{
  public final boolean LWA;
  public final boolean agQI;
  public final boolean agQJ;
  public final boolean agQK;
  public final boolean isFinishing;
  public final boolean mlX;
  
  static
  {
    AppMethodBeat.i(235166);
    agQL = new b("LoadFinish", 0, 2, false, false, true, false);
    agQM = new b("LoadReleased", 1, 2, false, false, false, false);
    agQN = new b("Loading", 2, 2, false, true, false, false);
    agQO = new b("None", 3, 0, false, false, false, false);
    agQP = new b("PullDownCanceled", 4, 1, false, false, false, false);
    agQQ = new b("PullDownToRefresh", 5, 1, true, false, false, false);
    agQR = new b("PullUpCanceled", 6, 2, false, false, false, false);
    agQS = new b("PullUpToLoad", 7, 2, true, false, false, false);
    agQT = new b("RefreshFinish", 8, 1, false, false, true, false);
    agQU = new b("RefreshReleased", 9, 1, false, false, false, false);
    agQV = new b("Refreshing", 10, 1, false, true, false, false);
    agQW = new b("ReleaseToLoad", 11, 2, true, false, false, true);
    agQX = new b("ReleaseToRefresh", 12, 1, true, false, false, true);
    agQY = new b[] { agQL, agQM, agQN, agQO, agQP, agQQ, agQR, agQS, agQT, agQU, agQV, agQW, agQX };
    AppMethodBeat.o(235166);
  }
  
  private b(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(235150);
    if (paramInt == 1)
    {
      bool1 = true;
      this.agQI = bool1;
      if (paramInt != 2) {
        break label79;
      }
    }
    label79:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.agQJ = bool1;
      this.mlX = paramBoolean1;
      this.LWA = paramBoolean2;
      this.isFinishing = paramBoolean3;
      this.agQK = paramBoolean4;
      AppMethodBeat.o(235150);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.view.refreshLayout.e.b
 * JD-Core Version:    0.7.0.1
 */