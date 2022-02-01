package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mx
  extends com.tencent.mm.bx.a
{
  public String FEO;
  public LinkedList<mw> FGN;
  public int FGO;
  
  public mx()
  {
    AppMethodBeat.i(124413);
    this.FGN = new LinkedList();
    AppMethodBeat.o(124413);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124414);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.FGN);
      paramVarArgs.aS(2, this.FGO);
      if (this.FEO != null) {
        paramVarArgs.d(3, this.FEO);
      }
      AppMethodBeat.o(124414);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.FGN) + 0 + f.a.a.b.b.a.bz(2, this.FGO);
      paramInt = i;
      if (this.FEO != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FEO);
      }
      AppMethodBeat.o(124414);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FGN.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(124414);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      mx localmx = (mx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124414);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new mw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((mw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localmx.FGN.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124414);
        return 0;
      case 2: 
        localmx.FGO = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(124414);
        return 0;
      }
      localmx.FEO = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(124414);
      return 0;
    }
    AppMethodBeat.o(124414);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mx
 * JD-Core Version:    0.7.0.1
 */