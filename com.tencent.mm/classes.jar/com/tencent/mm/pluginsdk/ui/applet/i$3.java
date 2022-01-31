package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.mm.model.s;

final class i$3
  implements k.a
{
  i$3(i parami) {}
  
  public final void Ea(int paramInt)
  {
    int j = 1;
    j localj;
    int i;
    if ((this.scC.ptQ != null) && (this.scC.scu != null))
    {
      localj = this.scC.scu;
      if (!localj.scO) {
        break label128;
      }
      if ((localj.dpW) || (paramInt != localj.scM + 2)) {
        break label123;
      }
      i = 1;
      if (i == 0)
      {
        localj = this.scC.scu;
        if ((localj.dpW) || (paramInt != localj.scM)) {
          break label157;
        }
        i = 1;
        label92:
        if (i == 0) {
          break label162;
        }
        if (this.scC.scu.scP) {
          this.scC.ptQ.gj(paramInt);
        }
      }
    }
    label123:
    do
    {
      return;
      i = 0;
      break;
      if ((!localj.dpW) && (paramInt == localj.scM + 1))
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      i = 0;
      break label92;
      localj = this.scC.scu;
      if ((!localj.dpW) && (paramInt == localj.scM + 1)) {
        i = j;
      }
      for (;;)
      {
        if (i != 0)
        {
          if (!this.scC.scu.scO) {
            break;
          }
          if (s.fn(this.scC.username))
          {
            this.scC.ptQ.gh(paramInt);
            return;
            i = 0;
          }
          else
          {
            this.scC.scu.Eb(0);
            return;
          }
        }
      }
      if ((this.scC.scu.dpW) && (this.scC.scu.Ec(paramInt)))
      {
        this.scC.ptQ.gh(paramInt);
        return;
      }
      if ((this.scC.scu.dpW) && (!this.scC.scu.Ec(paramInt)))
      {
        this.scC.ptQ.xy();
        return;
      }
    } while ((this.scC.scu.dpW) || (!this.scC.scu.Ec(paramInt)));
    label128:
    label157:
    label162:
    this.scC.ptQ.gi(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.i.3
 * JD-Core Version:    0.7.0.1
 */