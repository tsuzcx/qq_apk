package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbc
  extends com.tencent.mm.bx.a
{
  public int DXr;
  public LinkedList<czz> DXs;
  public int fVE;
  
  public cbc()
  {
    AppMethodBeat.i(152661);
    this.DXs = new LinkedList();
    AppMethodBeat.o(152661);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152662);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.fVE);
      paramVarArgs.aR(2, this.DXr);
      paramVarArgs.e(3, 8, this.DXs);
      AppMethodBeat.o(152662);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.fVE);
      i = f.a.a.b.b.a.bA(2, this.DXr);
      int j = f.a.a.a.c(3, 8, this.DXs);
      AppMethodBeat.o(152662);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DXs.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(152662);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cbc localcbc = (cbc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152662);
        return -1;
      case 1: 
        localcbc.fVE = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152662);
        return 0;
      case 2: 
        localcbc.DXr = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152662);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new czz();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((czz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcbc.DXs.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(152662);
      return 0;
    }
    AppMethodBeat.o(152662);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbc
 * JD-Core Version:    0.7.0.1
 */