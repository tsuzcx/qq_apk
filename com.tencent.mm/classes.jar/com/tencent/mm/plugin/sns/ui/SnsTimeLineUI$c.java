package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class SnsTimeLineUI$c
{
  public boolean active = true;
  public String rZi = "";
  public long rZj;
  public int rZk;
  public int rZl;
  public long rZm;
  public long rZn;
  public int rZo;
  public long rZp;
  public int rZq;
  public long rZr;
  public int scene;
  
  private SnsTimeLineUI$c(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void EZ(int paramInt)
  {
    AppMethodBeat.i(39550);
    if (!this.active)
    {
      AppMethodBeat.o(39550);
      return;
    }
    this.rZl = paramInt;
    this.rZm = bo.aoy();
    AppMethodBeat.o(39550);
  }
  
  public final void Fa(int paramInt)
  {
    AppMethodBeat.i(39551);
    if (!this.active)
    {
      AppMethodBeat.o(39551);
      return;
    }
    reset();
    this.scene = 2;
    this.rZn = bo.aoy();
    this.rZo = paramInt;
    AppMethodBeat.o(39551);
  }
  
  public final void Fb(int paramInt)
  {
    AppMethodBeat.i(39552);
    if (!this.active)
    {
      AppMethodBeat.o(39552);
      return;
    }
    reset();
    this.scene = 3;
    this.rZp = bo.aoy();
    this.rZr = 0L;
    this.rZq = paramInt;
    AppMethodBeat.o(39552);
  }
  
  final void reset()
  {
    this.scene = 0;
    this.rZj = 0L;
    this.rZk = -1;
    this.rZl = 0;
    this.rZm = 0L;
    this.rZn = 0L;
    this.rZo = 0;
    this.rZp = 0L;
    this.rZq = 0;
    this.rZr = 0L;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(39553);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.rZi).append(",").append(this.scene).append(",").append(this.rZj).append(",").append(this.rZk).append(",").append(this.rZl).append(",").append(this.rZm).append(",").append(this.rZn).append(",").append(this.rZo).append(",").append(this.rZp).append(",").append(this.rZq).append(",").append(this.rZr);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(39553);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.c
 * JD-Core Version:    0.7.0.1
 */