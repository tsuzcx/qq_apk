package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aem
  extends com.tencent.mm.bw.a
{
  public String hiu;
  public int wEF;
  public String wEG;
  public String wEH;
  public int wEI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72474);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.wEF);
      if (this.wEG != null) {
        paramVarArgs.d(2, this.wEG);
      }
      if (this.wEH != null) {
        paramVarArgs.d(3, this.wEH);
      }
      paramVarArgs.aR(4, this.wEI);
      if (this.hiu != null) {
        paramVarArgs.d(5, this.hiu);
      }
      AppMethodBeat.o(72474);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.wEF) + 0;
      paramInt = i;
      if (this.wEG != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.wEG);
      }
      i = paramInt;
      if (this.wEH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.wEH);
      }
      i += f.a.a.b.b.a.bx(4, this.wEI);
      paramInt = i;
      if (this.hiu != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hiu);
      }
      AppMethodBeat.o(72474);
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
      AppMethodBeat.o(72474);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aem localaem = (aem)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(72474);
        return -1;
      case 1: 
        localaem.wEF = locala.LVo.xF();
        AppMethodBeat.o(72474);
        return 0;
      case 2: 
        localaem.wEG = locala.LVo.readString();
        AppMethodBeat.o(72474);
        return 0;
      case 3: 
        localaem.wEH = locala.LVo.readString();
        AppMethodBeat.o(72474);
        return 0;
      case 4: 
        localaem.wEI = locala.LVo.xF();
        AppMethodBeat.o(72474);
        return 0;
      }
      localaem.hiu = locala.LVo.readString();
      AppMethodBeat.o(72474);
      return 0;
    }
    AppMethodBeat.o(72474);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aem
 * JD-Core Version:    0.7.0.1
 */