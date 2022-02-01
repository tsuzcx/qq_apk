package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctw
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b Ewb;
  public int FFA;
  public int FFB;
  public int FFC;
  public int FFD;
  public int FFx;
  public int FFy;
  public int FFz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32425);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ewb == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: data");
        AppMethodBeat.o(32425);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.FFx);
      paramVarArgs.aR(2, this.FFy);
      paramVarArgs.aR(3, this.FFz);
      paramVarArgs.aR(4, this.FFA);
      paramVarArgs.aR(5, this.FFB);
      paramVarArgs.aR(6, this.FFC);
      paramVarArgs.aR(7, this.FFD);
      if (this.Ewb != null) {
        paramVarArgs.c(8, this.Ewb);
      }
      AppMethodBeat.o(32425);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.FFx) + 0 + f.a.a.b.b.a.bx(2, this.FFy) + f.a.a.b.b.a.bx(3, this.FFz) + f.a.a.b.b.a.bx(4, this.FFA) + f.a.a.b.b.a.bx(5, this.FFB) + f.a.a.b.b.a.bx(6, this.FFC) + f.a.a.b.b.a.bx(7, this.FFD);
      paramInt = i;
      if (this.Ewb != null) {
        paramInt = i + f.a.a.b.b.a.b(8, this.Ewb);
      }
      AppMethodBeat.o(32425);
      return paramInt;
    }
    f.a.a.a.a locala;
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      locala = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(locala); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(locala)) {
        if (!super.populateBuilderWithField(locala, this, paramInt)) {
          locala.gfg();
        }
      }
      if (paramVarArgs == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: data");
        AppMethodBeat.o(32425);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32425);
      return 0;
    }
    if (paramInt == 3)
    {
      locala = (f.a.a.a.a)paramVarArgs[0];
      ctw localctw = (ctw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32425);
        return -1;
      case 1: 
        localctw.FFx = locala.LVo.xF();
        AppMethodBeat.o(32425);
        return 0;
      case 2: 
        localctw.FFy = locala.LVo.xF();
        AppMethodBeat.o(32425);
        return 0;
      case 3: 
        localctw.FFz = locala.LVo.xF();
        AppMethodBeat.o(32425);
        return 0;
      case 4: 
        localctw.FFA = locala.LVo.xF();
        AppMethodBeat.o(32425);
        return 0;
      case 5: 
        localctw.FFB = locala.LVo.xF();
        AppMethodBeat.o(32425);
        return 0;
      case 6: 
        localctw.FFC = locala.LVo.xF();
        AppMethodBeat.o(32425);
        return 0;
      case 7: 
        localctw.FFD = locala.LVo.xF();
        AppMethodBeat.o(32425);
        return 0;
      }
      localctw.Ewb = locala.LVo.gfk();
      AppMethodBeat.o(32425);
      return 0;
    }
    AppMethodBeat.o(32425);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctw
 * JD-Core Version:    0.7.0.1
 */