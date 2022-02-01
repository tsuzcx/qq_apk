package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpa
  extends com.tencent.mm.bw.a
{
  public float Eht;
  public float Ehu;
  public int EyK;
  public String EyL;
  public String EyM;
  public int EyN;
  public String FeC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117875);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.x(1, this.Eht);
      paramVarArgs.x(2, this.Ehu);
      paramVarArgs.aR(3, this.EyK);
      if (this.EyL != null) {
        paramVarArgs.d(4, this.EyL);
      }
      if (this.EyM != null) {
        paramVarArgs.d(5, this.EyM);
      }
      paramVarArgs.aR(6, this.EyN);
      if (this.FeC != null) {
        paramVarArgs.d(7, this.FeC);
      }
      AppMethodBeat.o(117875);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fK(1) + 4 + 0 + (f.a.a.b.b.a.fK(2) + 4) + f.a.a.b.b.a.bx(3, this.EyK);
      paramInt = i;
      if (this.EyL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EyL);
      }
      i = paramInt;
      if (this.EyM != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EyM);
      }
      i += f.a.a.b.b.a.bx(6, this.EyN);
      paramInt = i;
      if (this.FeC != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FeC);
      }
      AppMethodBeat.o(117875);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(117875);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bpa localbpa = (bpa)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117875);
        return -1;
      case 1: 
        localbpa.Eht = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(117875);
        return 0;
      case 2: 
        localbpa.Ehu = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(117875);
        return 0;
      case 3: 
        localbpa.EyK = locala.LVo.xF();
        AppMethodBeat.o(117875);
        return 0;
      case 4: 
        localbpa.EyL = locala.LVo.readString();
        AppMethodBeat.o(117875);
        return 0;
      case 5: 
        localbpa.EyM = locala.LVo.readString();
        AppMethodBeat.o(117875);
        return 0;
      case 6: 
        localbpa.EyN = locala.LVo.xF();
        AppMethodBeat.o(117875);
        return 0;
      }
      localbpa.FeC = locala.LVo.readString();
      AppMethodBeat.o(117875);
      return 0;
    }
    AppMethodBeat.o(117875);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpa
 * JD-Core Version:    0.7.0.1
 */