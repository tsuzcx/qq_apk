package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccj
  extends com.tencent.mm.bv.a
{
  public LinkedList<String> xML;
  public LinkedList<String> xMM;
  public LinkedList<Integer> xMN;
  public LinkedList<Integer> xMO;
  
  public ccj()
  {
    AppMethodBeat.i(89146);
    this.xML = new LinkedList();
    this.xMM = new LinkedList();
    this.xMN = new LinkedList();
    this.xMO = new LinkedList();
    AppMethodBeat.o(89146);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89147);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.xML);
      paramVarArgs.e(2, 1, this.xMM);
      paramVarArgs.e(3, 2, this.xMN);
      paramVarArgs.e(4, 2, this.xMO);
      AppMethodBeat.o(89147);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.a.c(1, 1, this.xML);
      int i = e.a.a.a.c(2, 1, this.xMM);
      int j = e.a.a.a.c(3, 2, this.xMN);
      int k = e.a.a.a.c(4, 2, this.xMO);
      AppMethodBeat.o(89147);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xML.clear();
      this.xMM.clear();
      this.xMN.clear();
      this.xMO.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(89147);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ccj localccj = (ccj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(89147);
        return -1;
      case 1: 
        localccj.xML.add(locala.CLY.readString());
        AppMethodBeat.o(89147);
        return 0;
      case 2: 
        localccj.xMM.add(locala.CLY.readString());
        AppMethodBeat.o(89147);
        return 0;
      case 3: 
        localccj.xMN.add(Integer.valueOf(locala.CLY.sl()));
        AppMethodBeat.o(89147);
        return 0;
      }
      localccj.xMO.add(Integer.valueOf(locala.CLY.sl()));
      AppMethodBeat.o(89147);
      return 0;
    }
    AppMethodBeat.o(89147);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccj
 * JD-Core Version:    0.7.0.1
 */