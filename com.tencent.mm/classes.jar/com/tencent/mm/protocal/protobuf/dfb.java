package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dfb
  extends com.tencent.mm.bx.a
{
  public cwt Htr;
  public cwt Htt;
  public int Htu;
  public int tRT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125764);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Htr != null)
      {
        paramVarArgs.lC(1, this.Htr.computeSize());
        this.Htr.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.tRT);
      if (this.Htt != null)
      {
        paramVarArgs.lC(3, this.Htt.computeSize());
        this.Htt.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.Htu);
      AppMethodBeat.o(125764);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Htr == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = f.a.a.a.lB(1, this.Htr.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.tRT);
      paramInt = i;
      if (this.Htt != null) {
        paramInt = i + f.a.a.a.lB(3, this.Htt.computeSize());
      }
      i = f.a.a.b.b.a.bz(4, this.Htu);
      AppMethodBeat.o(125764);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125764);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dfb localdfb = (dfb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125764);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfb.Htr = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125764);
          return 0;
        case 2: 
          localdfb.tRT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125764);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfb.Htt = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125764);
          return 0;
        }
        localdfb.Htu = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125764);
        return 0;
      }
      AppMethodBeat.o(125764);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfb
 * JD-Core Version:    0.7.0.1
 */