package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chf
  extends com.tencent.mm.bx.a
{
  public int Category;
  public int EcG;
  public int EcH;
  public LinkedList<String> EcI;
  public int EcJ;
  
  public chf()
  {
    AppMethodBeat.i(117893);
    this.EcI = new LinkedList();
    AppMethodBeat.o(117893);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117894);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EcG);
      paramVarArgs.aR(2, this.EcH);
      paramVarArgs.aR(3, this.Category);
      paramVarArgs.e(4, 1, this.EcI);
      paramVarArgs.aR(5, this.EcJ);
      AppMethodBeat.o(117894);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.EcG);
      int i = f.a.a.b.b.a.bA(2, this.EcH);
      int j = f.a.a.b.b.a.bA(3, this.Category);
      int k = f.a.a.a.c(4, 1, this.EcI);
      int m = f.a.a.b.b.a.bA(5, this.EcJ);
      AppMethodBeat.o(117894);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EcI.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(117894);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      chf localchf = (chf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117894);
        return -1;
      case 1: 
        localchf.EcG = locala.KhF.xS();
        AppMethodBeat.o(117894);
        return 0;
      case 2: 
        localchf.EcH = locala.KhF.xS();
        AppMethodBeat.o(117894);
        return 0;
      case 3: 
        localchf.Category = locala.KhF.xS();
        AppMethodBeat.o(117894);
        return 0;
      case 4: 
        localchf.EcI.add(locala.KhF.readString());
        AppMethodBeat.o(117894);
        return 0;
      }
      localchf.EcJ = locala.KhF.xS();
      AppMethodBeat.o(117894);
      return 0;
    }
    AppMethodBeat.o(117894);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chf
 * JD-Core Version:    0.7.0.1
 */