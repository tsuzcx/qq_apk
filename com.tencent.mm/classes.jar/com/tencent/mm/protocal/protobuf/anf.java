package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class anf
  extends com.tencent.mm.bw.a
{
  public int continueFlag;
  public String dyI;
  public b lastBuffer;
  public LinkedList<FinderObject> rBY;
  
  public anf()
  {
    AppMethodBeat.i(189328);
    this.rBY = new LinkedList();
    AppMethodBeat.o(189328);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189329);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.rBY);
      if (this.lastBuffer != null) {
        paramVarArgs.c(2, this.lastBuffer);
      }
      paramVarArgs.aS(3, this.continueFlag);
      if (this.dyI != null) {
        paramVarArgs.d(4, this.dyI);
      }
      AppMethodBeat.o(189329);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.rBY) + 0;
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.lastBuffer);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.continueFlag);
      paramInt = i;
      if (this.dyI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dyI);
      }
      AppMethodBeat.o(189329);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.rBY.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(189329);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      anf localanf = (anf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(189329);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderObject();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localanf.rBY.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(189329);
        return 0;
      case 2: 
        localanf.lastBuffer = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(189329);
        return 0;
      case 3: 
        localanf.continueFlag = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(189329);
        return 0;
      }
      localanf.dyI = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(189329);
      return 0;
    }
    AppMethodBeat.o(189329);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anf
 * JD-Core Version:    0.7.0.1
 */