package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class om
  extends com.tencent.mm.bx.a
{
  public LinkedList<nv> FHP;
  public int FHR;
  public String FHS;
  public long FJW;
  
  public om()
  {
    AppMethodBeat.i(207242);
    this.FHP = new LinkedList();
    AppMethodBeat.o(207242);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207243);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.FJW);
      paramVarArgs.e(2, 8, this.FHP);
      paramVarArgs.aS(3, this.FHR);
      if (this.FHS != null) {
        paramVarArgs.d(4, this.FHS);
      }
      AppMethodBeat.o(207243);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.FJW) + 0 + f.a.a.a.c(2, 8, this.FHP) + f.a.a.b.b.a.bz(3, this.FHR);
      paramInt = i;
      if (this.FHS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FHS);
      }
      AppMethodBeat.o(207243);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FHP.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(207243);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      om localom = (om)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(207243);
        return -1;
      case 1: 
        localom.FJW = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(207243);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new nv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((nv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localom.FHP.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(207243);
        return 0;
      case 3: 
        localom.FHR = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(207243);
        return 0;
      }
      localom.FHS = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(207243);
      return 0;
    }
    AppMethodBeat.o(207243);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.om
 * JD-Core Version:    0.7.0.1
 */