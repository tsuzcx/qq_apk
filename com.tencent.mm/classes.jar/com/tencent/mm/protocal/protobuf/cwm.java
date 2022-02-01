package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cwm
  extends com.tencent.mm.cd.a
{
  public int SGa;
  public int SGb;
  public int SGc;
  public int SGd;
  public int TFm;
  public int TFn;
  public int TFo;
  public int TFp;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198470);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.scene);
      paramVarArgs.aY(2, this.SGa);
      paramVarArgs.aY(3, this.TFm);
      paramVarArgs.aY(4, this.TFn);
      paramVarArgs.aY(5, this.SGb);
      paramVarArgs.aY(6, this.SGc);
      paramVarArgs.aY(7, this.SGd);
      paramVarArgs.aY(8, this.TFo);
      paramVarArgs.aY(9, this.TFp);
      AppMethodBeat.o(198470);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.scene);
      int i = g.a.a.b.b.a.bM(2, this.SGa);
      int j = g.a.a.b.b.a.bM(3, this.TFm);
      int k = g.a.a.b.b.a.bM(4, this.TFn);
      int m = g.a.a.b.b.a.bM(5, this.SGb);
      int n = g.a.a.b.b.a.bM(6, this.SGc);
      int i1 = g.a.a.b.b.a.bM(7, this.SGd);
      int i2 = g.a.a.b.b.a.bM(8, this.TFo);
      int i3 = g.a.a.b.b.a.bM(9, this.TFp);
      AppMethodBeat.o(198470);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(198470);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cwm localcwm = (cwm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(198470);
        return -1;
      case 1: 
        localcwm.scene = locala.abFh.AK();
        AppMethodBeat.o(198470);
        return 0;
      case 2: 
        localcwm.SGa = locala.abFh.AK();
        AppMethodBeat.o(198470);
        return 0;
      case 3: 
        localcwm.TFm = locala.abFh.AK();
        AppMethodBeat.o(198470);
        return 0;
      case 4: 
        localcwm.TFn = locala.abFh.AK();
        AppMethodBeat.o(198470);
        return 0;
      case 5: 
        localcwm.SGb = locala.abFh.AK();
        AppMethodBeat.o(198470);
        return 0;
      case 6: 
        localcwm.SGc = locala.abFh.AK();
        AppMethodBeat.o(198470);
        return 0;
      case 7: 
        localcwm.SGd = locala.abFh.AK();
        AppMethodBeat.o(198470);
        return 0;
      case 8: 
        localcwm.TFo = locala.abFh.AK();
        AppMethodBeat.o(198470);
        return 0;
      }
      localcwm.TFp = locala.abFh.AK();
      AppMethodBeat.o(198470);
      return 0;
    }
    AppMethodBeat.o(198470);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwm
 * JD-Core Version:    0.7.0.1
 */