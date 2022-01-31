package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bro
  extends com.tencent.mm.bv.a
{
  public int count;
  public int timestamp;
  public LinkedList<brp> xFi;
  
  public bro()
  {
    AppMethodBeat.i(28603);
    this.xFi = new LinkedList();
    AppMethodBeat.o(28603);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28604);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.count);
      paramVarArgs.e(2, 8, this.xFi);
      paramVarArgs.aO(3, this.timestamp);
      AppMethodBeat.o(28604);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.count);
      i = e.a.a.a.c(2, 8, this.xFi);
      int j = e.a.a.b.b.a.bl(3, this.timestamp);
      AppMethodBeat.o(28604);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xFi.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(28604);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bro localbro = (bro)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(28604);
        return -1;
      case 1: 
        localbro.count = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28604);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new brp();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((brp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbro.xFi.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28604);
        return 0;
      }
      localbro.timestamp = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(28604);
      return 0;
    }
    AppMethodBeat.o(28604);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bro
 * JD-Core Version:    0.7.0.1
 */