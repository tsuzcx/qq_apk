package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxf
  extends com.tencent.mm.bw.a
{
  public String ERk;
  public int FlZ;
  public String Fma;
  public int Fmb;
  public String Fmc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115847);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ERk != null) {
        paramVarArgs.d(1, this.ERk);
      }
      paramVarArgs.aR(2, this.FlZ);
      if (this.Fma != null) {
        paramVarArgs.d(3, this.Fma);
      }
      paramVarArgs.aR(4, this.Fmb);
      if (this.Fmc != null) {
        paramVarArgs.d(5, this.Fmc);
      }
      AppMethodBeat.o(115847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ERk == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.ERk) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.FlZ);
      paramInt = i;
      if (this.Fma != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Fma);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.Fmb);
      paramInt = i;
      if (this.Fmc != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Fmc);
      }
      AppMethodBeat.o(115847);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(115847);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bxf localbxf = (bxf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115847);
          return -1;
        case 1: 
          localbxf.ERk = locala.LVo.readString();
          AppMethodBeat.o(115847);
          return 0;
        case 2: 
          localbxf.FlZ = locala.LVo.xF();
          AppMethodBeat.o(115847);
          return 0;
        case 3: 
          localbxf.Fma = locala.LVo.readString();
          AppMethodBeat.o(115847);
          return 0;
        case 4: 
          localbxf.Fmb = locala.LVo.xF();
          AppMethodBeat.o(115847);
          return 0;
        }
        localbxf.Fmc = locala.LVo.readString();
        AppMethodBeat.o(115847);
        return 0;
      }
      AppMethodBeat.o(115847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxf
 * JD-Core Version:    0.7.0.1
 */