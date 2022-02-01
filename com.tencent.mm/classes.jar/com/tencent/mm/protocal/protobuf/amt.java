package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class amt
  extends com.tencent.mm.bx.a
{
  public int continueFlag;
  public String dxD;
  public b lastBuffer;
  public LinkedList<FinderObject> rtM;
  
  public amt()
  {
    AppMethodBeat.i(209288);
    this.rtM = new LinkedList();
    AppMethodBeat.o(209288);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209289);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.rtM);
      if (this.lastBuffer != null) {
        paramVarArgs.c(2, this.lastBuffer);
      }
      paramVarArgs.aS(3, this.continueFlag);
      if (this.dxD != null) {
        paramVarArgs.d(4, this.dxD);
      }
      AppMethodBeat.o(209289);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.rtM) + 0;
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.lastBuffer);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.continueFlag);
      paramInt = i;
      if (this.dxD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dxD);
      }
      AppMethodBeat.o(209289);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.rtM.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(209289);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      amt localamt = (amt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209289);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderObject();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localamt.rtM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209289);
        return 0;
      case 2: 
        localamt.lastBuffer = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(209289);
        return 0;
      case 3: 
        localamt.continueFlag = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(209289);
        return 0;
      }
      localamt.dxD = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(209289);
      return 0;
    }
    AppMethodBeat.o(209289);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amt
 * JD-Core Version:    0.7.0.1
 */