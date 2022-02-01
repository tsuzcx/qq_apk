package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aqv
  extends com.tencent.mm.bw.a
{
  public int continueFlag;
  public String dQx;
  public b lastBuffer;
  public LinkedList<FinderObject> tbD;
  
  public aqv()
  {
    AppMethodBeat.i(209383);
    this.tbD = new LinkedList();
    AppMethodBeat.o(209383);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209384);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.tbD);
      if (this.lastBuffer != null) {
        paramVarArgs.c(2, this.lastBuffer);
      }
      paramVarArgs.aM(3, this.continueFlag);
      if (this.dQx != null) {
        paramVarArgs.e(4, this.dQx);
      }
      AppMethodBeat.o(209384);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.tbD) + 0;
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.lastBuffer);
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.continueFlag);
      paramInt = i;
      if (this.dQx != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.dQx);
      }
      AppMethodBeat.o(209384);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tbD.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209384);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      aqv localaqv = (aqv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209384);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderObject();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaqv.tbD.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209384);
        return 0;
      case 2: 
        localaqv.lastBuffer = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(209384);
        return 0;
      case 3: 
        localaqv.continueFlag = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209384);
        return 0;
      }
      localaqv.dQx = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(209384);
      return 0;
    }
    AppMethodBeat.o(209384);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqv
 * JD-Core Version:    0.7.0.1
 */