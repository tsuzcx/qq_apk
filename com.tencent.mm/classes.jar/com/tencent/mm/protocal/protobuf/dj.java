package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dj
  extends com.tencent.mm.bx.a
{
  public dfc FvD;
  public cwt FvE;
  public int FvF;
  public cte FvG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125705);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FvD == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsADObject");
        AppMethodBeat.o(125705);
        throw paramVarArgs;
      }
      if (this.FvD != null)
      {
        paramVarArgs.lC(1, this.FvD.computeSize());
        this.FvD.writeFields(paramVarArgs);
      }
      if (this.FvE != null)
      {
        paramVarArgs.lC(2, this.FvE.computeSize());
        this.FvE.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.FvF);
      if (this.FvG != null)
      {
        paramVarArgs.lC(4, this.FvG.computeSize());
        this.FvG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FvD == null) {
        break label710;
      }
    }
    label710:
    for (paramInt = f.a.a.a.lB(1, this.FvD.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FvE != null) {
        i = paramInt + f.a.a.a.lB(2, this.FvE.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.FvF);
      paramInt = i;
      if (this.FvG != null) {
        paramInt = i + f.a.a.a.lB(4, this.FvG.computeSize());
      }
      AppMethodBeat.o(125705);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FvD == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsADObject");
          AppMethodBeat.o(125705);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125705);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dj localdj = (dj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125705);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdj.FvD = ((dfc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125705);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdj.FvE = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125705);
          return 0;
        case 3: 
          localdj.FvF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125705);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cte();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cte)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdj.FvG = ((cte)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125705);
        return 0;
      }
      AppMethodBeat.o(125705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dj
 * JD-Core Version:    0.7.0.1
 */