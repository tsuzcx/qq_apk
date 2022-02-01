package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class crj
  extends com.tencent.mm.bx.a
{
  public int Category;
  public int HjJ;
  public int HjK;
  public LinkedList<String> HjL;
  public int HjM;
  
  public crj()
  {
    AppMethodBeat.i(117893);
    this.HjL = new LinkedList();
    AppMethodBeat.o(117893);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117894);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HjJ);
      paramVarArgs.aS(2, this.HjK);
      paramVarArgs.aS(3, this.Category);
      paramVarArgs.e(4, 1, this.HjL);
      paramVarArgs.aS(5, this.HjM);
      AppMethodBeat.o(117894);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.HjJ);
      int i = f.a.a.b.b.a.bz(2, this.HjK);
      int j = f.a.a.b.b.a.bz(3, this.Category);
      int k = f.a.a.a.c(4, 1, this.HjL);
      int m = f.a.a.b.b.a.bz(5, this.HjM);
      AppMethodBeat.o(117894);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HjL.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(117894);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      crj localcrj = (crj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117894);
        return -1;
      case 1: 
        localcrj.HjJ = locala.NPN.zc();
        AppMethodBeat.o(117894);
        return 0;
      case 2: 
        localcrj.HjK = locala.NPN.zc();
        AppMethodBeat.o(117894);
        return 0;
      case 3: 
        localcrj.Category = locala.NPN.zc();
        AppMethodBeat.o(117894);
        return 0;
      case 4: 
        localcrj.HjL.add(locala.NPN.readString());
        AppMethodBeat.o(117894);
        return 0;
      }
      localcrj.HjM = locala.NPN.zc();
      AppMethodBeat.o(117894);
      return 0;
    }
    AppMethodBeat.o(117894);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crj
 * JD-Core Version:    0.7.0.1
 */