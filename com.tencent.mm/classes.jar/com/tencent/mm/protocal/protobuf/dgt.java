package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgt
  extends com.tencent.mm.bx.a
{
  public long Hvd;
  public int nDi;
  public LinkedList<cwt> nDj;
  public String uiP;
  
  public dgt()
  {
    AppMethodBeat.i(125816);
    this.nDj = new LinkedList();
    AppMethodBeat.o(125816);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125817);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Hvd);
      if (this.uiP != null) {
        paramVarArgs.d(2, this.uiP);
      }
      paramVarArgs.aS(3, this.nDi);
      paramVarArgs.e(4, 8, this.nDj);
      AppMethodBeat.o(125817);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.Hvd) + 0;
      paramInt = i;
      if (this.uiP != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uiP);
      }
      i = f.a.a.b.b.a.bz(3, this.nDi);
      int j = f.a.a.a.c(4, 8, this.nDj);
      AppMethodBeat.o(125817);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.nDj.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(125817);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dgt localdgt = (dgt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125817);
        return -1;
      case 1: 
        localdgt.Hvd = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(125817);
        return 0;
      case 2: 
        localdgt.uiP = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125817);
        return 0;
      case 3: 
        localdgt.nDi = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125817);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cwt();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdgt.nDj.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(125817);
      return 0;
    }
    AppMethodBeat.o(125817);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgt
 * JD-Core Version:    0.7.0.1
 */