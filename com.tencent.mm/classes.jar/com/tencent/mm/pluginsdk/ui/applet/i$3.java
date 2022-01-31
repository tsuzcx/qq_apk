package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;

final class i$3
  implements k.a
{
  i$3(i parami) {}
  
  public final void LX(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(79733);
    if ((this.vTI.sqf != null) && (this.vTI.vTA != null))
    {
      j localj = this.vTI.vTA;
      if (localj.vTS) {
        if ((!localj.eht) && (paramInt == localj.vTQ + 2))
        {
          i = 1;
          if (i != 0) {
            break label405;
          }
          localj = this.vTI.vTA;
          if ((localj.eht) || (paramInt != localj.vTQ)) {
            break label167;
          }
        }
      }
      label167:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label172;
        }
        if (!this.vTI.vTA.vTT) {
          break label405;
        }
        this.vTI.sqf.iy(paramInt);
        AppMethodBeat.o(79733);
        return;
        i = 0;
        break;
        if ((!localj.eht) && (paramInt == localj.vTQ + 1))
        {
          i = 1;
          break;
        }
        i = 0;
        break;
      }
      label172:
      localj = this.vTI.vTA;
      if ((!localj.eht) && (paramInt == localj.vTQ + 1)) {
        i = j;
      }
      while (i != 0)
      {
        if (!this.vTI.vTA.vTS) {
          break label405;
        }
        if (t.lA(this.vTI.username))
        {
          this.vTI.sqf.iw(paramInt);
          AppMethodBeat.o(79733);
          return;
          i = 0;
        }
        else
        {
          this.vTI.vTA.LY(0);
          AppMethodBeat.o(79733);
          return;
        }
      }
      if ((this.vTI.vTA.eht) && (this.vTI.vTA.Ma(paramInt)))
      {
        this.vTI.sqf.iw(paramInt);
        AppMethodBeat.o(79733);
        return;
      }
      if ((this.vTI.vTA.eht) && (!this.vTI.vTA.Ma(paramInt)))
      {
        this.vTI.sqf.JR();
        AppMethodBeat.o(79733);
        return;
      }
      if ((!this.vTI.vTA.eht) && (this.vTI.vTA.Ma(paramInt))) {
        this.vTI.sqf.ix(paramInt);
      }
    }
    label405:
    AppMethodBeat.o(79733);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.i.3
 * JD-Core Version:    0.7.0.1
 */