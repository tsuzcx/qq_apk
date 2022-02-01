package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmi
  extends com.tencent.mm.bw.a
{
  public int Category;
  public int FzB;
  public int FzC;
  public LinkedList<String> FzD;
  public int FzE;
  
  public cmi()
  {
    AppMethodBeat.i(117893);
    this.FzD = new LinkedList();
    AppMethodBeat.o(117893);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117894);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FzB);
      paramVarArgs.aR(2, this.FzC);
      paramVarArgs.aR(3, this.Category);
      paramVarArgs.e(4, 1, this.FzD);
      paramVarArgs.aR(5, this.FzE);
      AppMethodBeat.o(117894);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.FzB);
      int i = f.a.a.b.b.a.bx(2, this.FzC);
      int j = f.a.a.b.b.a.bx(3, this.Category);
      int k = f.a.a.a.c(4, 1, this.FzD);
      int m = f.a.a.b.b.a.bx(5, this.FzE);
      AppMethodBeat.o(117894);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FzD.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(117894);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cmi localcmi = (cmi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117894);
        return -1;
      case 1: 
        localcmi.FzB = locala.LVo.xF();
        AppMethodBeat.o(117894);
        return 0;
      case 2: 
        localcmi.FzC = locala.LVo.xF();
        AppMethodBeat.o(117894);
        return 0;
      case 3: 
        localcmi.Category = locala.LVo.xF();
        AppMethodBeat.o(117894);
        return 0;
      case 4: 
        localcmi.FzD.add(locala.LVo.readString());
        AppMethodBeat.o(117894);
        return 0;
      }
      localcmi.FzE = locala.LVo.xF();
      AppMethodBeat.o(117894);
      return 0;
    }
    AppMethodBeat.o(117894);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmi
 * JD-Core Version:    0.7.0.1
 */