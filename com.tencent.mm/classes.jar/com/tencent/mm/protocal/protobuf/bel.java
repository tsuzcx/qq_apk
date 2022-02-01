package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bel
  extends com.tencent.mm.bx.a
{
  public String GAC;
  public dws GAD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115839);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GAC != null) {
        paramVarArgs.d(1, this.GAC);
      }
      if (this.GAD != null)
      {
        paramVarArgs.lC(2, this.GAD.computeSize());
        this.GAD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115839);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GAC == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.b.b.a.e(1, this.GAC) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GAD != null) {
        i = paramInt + f.a.a.a.lB(2, this.GAD.computeSize());
      }
      AppMethodBeat.o(115839);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(115839);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bel localbel = (bel)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115839);
          return -1;
        case 1: 
          localbel.GAC = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(115839);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dws();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dws)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbel.GAD = ((dws)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115839);
        return 0;
      }
      AppMethodBeat.o(115839);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bel
 * JD-Core Version:    0.7.0.1
 */