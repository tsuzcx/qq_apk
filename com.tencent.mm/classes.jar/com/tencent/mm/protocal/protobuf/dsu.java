package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsu
  extends com.tencent.mm.bx.a
{
  public long EHs;
  public of EHt;
  public int EHu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117950);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.EHs);
      if (this.EHt != null)
      {
        paramVarArgs.kX(2, this.EHt.computeSize());
        this.EHt.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.EHu);
      AppMethodBeat.o(117950);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.q(1, this.EHs) + 0;
      paramInt = i;
      if (this.EHt != null) {
        paramInt = i + f.a.a.a.kW(2, this.EHt.computeSize());
      }
      i = f.a.a.b.b.a.bA(3, this.EHu);
      AppMethodBeat.o(117950);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(117950);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dsu localdsu = (dsu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117950);
        return -1;
      case 1: 
        localdsu.EHs = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(117950);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new of();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((of)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdsu.EHt = ((of)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117950);
        return 0;
      }
      localdsu.EHu = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(117950);
      return 0;
    }
    AppMethodBeat.o(117950);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsu
 * JD-Core Version:    0.7.0.1
 */