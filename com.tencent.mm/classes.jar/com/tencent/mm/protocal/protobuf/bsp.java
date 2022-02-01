package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsp
  extends com.tencent.mm.bw.a
{
  public int FhA;
  public int Fhx;
  public int Fhy;
  public int Fhz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169923);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Fhx);
      paramVarArgs.aR(2, this.Fhy);
      paramVarArgs.aR(3, this.Fhz);
      paramVarArgs.aR(4, this.FhA);
      AppMethodBeat.o(169923);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.Fhx);
      int i = f.a.a.b.b.a.bx(2, this.Fhy);
      int j = f.a.a.b.b.a.bx(3, this.Fhz);
      int k = f.a.a.b.b.a.bx(4, this.FhA);
      AppMethodBeat.o(169923);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(169923);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bsp localbsp = (bsp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169923);
        return -1;
      case 1: 
        localbsp.Fhx = locala.LVo.xF();
        AppMethodBeat.o(169923);
        return 0;
      case 2: 
        localbsp.Fhy = locala.LVo.xF();
        AppMethodBeat.o(169923);
        return 0;
      case 3: 
        localbsp.Fhz = locala.LVo.xF();
        AppMethodBeat.o(169923);
        return 0;
      }
      localbsp.FhA = locala.LVo.xF();
      AppMethodBeat.o(169923);
      return 0;
    }
    AppMethodBeat.o(169923);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsp
 * JD-Core Version:    0.7.0.1
 */