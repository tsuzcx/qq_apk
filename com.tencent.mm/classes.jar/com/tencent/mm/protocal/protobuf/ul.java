package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ul
  extends com.tencent.mm.bw.a
{
  public String EoA;
  public int EoB;
  public int EoC;
  public String EoD;
  public int EoE;
  public String Eoy;
  public String Eoz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127444);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Eoy != null) {
        paramVarArgs.d(1, this.Eoy);
      }
      if (this.Eoz != null) {
        paramVarArgs.d(2, this.Eoz);
      }
      if (this.EoA != null) {
        paramVarArgs.d(3, this.EoA);
      }
      paramVarArgs.aR(4, this.EoB);
      paramVarArgs.aR(5, this.EoC);
      if (this.EoD != null) {
        paramVarArgs.d(6, this.EoD);
      }
      paramVarArgs.aR(7, this.EoE);
      AppMethodBeat.o(127444);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Eoy == null) {
        break label530;
      }
    }
    label530:
    for (int i = f.a.a.b.b.a.e(1, this.Eoy) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Eoz != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Eoz);
      }
      i = paramInt;
      if (this.EoA != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EoA);
      }
      i = i + f.a.a.b.b.a.bx(4, this.EoB) + f.a.a.b.b.a.bx(5, this.EoC);
      paramInt = i;
      if (this.EoD != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EoD);
      }
      i = f.a.a.b.b.a.bx(7, this.EoE);
      AppMethodBeat.o(127444);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(127444);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ul localul = (ul)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127444);
          return -1;
        case 1: 
          localul.Eoy = locala.LVo.readString();
          AppMethodBeat.o(127444);
          return 0;
        case 2: 
          localul.Eoz = locala.LVo.readString();
          AppMethodBeat.o(127444);
          return 0;
        case 3: 
          localul.EoA = locala.LVo.readString();
          AppMethodBeat.o(127444);
          return 0;
        case 4: 
          localul.EoB = locala.LVo.xF();
          AppMethodBeat.o(127444);
          return 0;
        case 5: 
          localul.EoC = locala.LVo.xF();
          AppMethodBeat.o(127444);
          return 0;
        case 6: 
          localul.EoD = locala.LVo.readString();
          AppMethodBeat.o(127444);
          return 0;
        }
        localul.EoE = locala.LVo.xF();
        AppMethodBeat.o(127444);
        return 0;
      }
      AppMethodBeat.o(127444);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ul
 * JD-Core Version:    0.7.0.1
 */