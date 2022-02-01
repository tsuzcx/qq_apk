package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class hm
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> CCA;
  public int CCB;
  public int CCC;
  
  public hm()
  {
    AppMethodBeat.i(104747);
    this.CCA = new LinkedList();
    AppMethodBeat.o(104747);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104748);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.CCA);
      paramVarArgs.aR(2, this.CCB);
      paramVarArgs.aR(3, this.CCC);
      AppMethodBeat.o(104748);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 1, this.CCA);
      int i = f.a.a.b.b.a.bA(2, this.CCB);
      int j = f.a.a.b.b.a.bA(3, this.CCC);
      AppMethodBeat.o(104748);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CCA.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(104748);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      hm localhm = (hm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104748);
        return -1;
      case 1: 
        localhm.CCA.add(locala.KhF.readString());
        AppMethodBeat.o(104748);
        return 0;
      case 2: 
        localhm.CCB = locala.KhF.xS();
        AppMethodBeat.o(104748);
        return 0;
      }
      localhm.CCC = locala.KhF.xS();
      AppMethodBeat.o(104748);
      return 0;
    }
    AppMethodBeat.o(104748);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hm
 * JD-Core Version:    0.7.0.1
 */