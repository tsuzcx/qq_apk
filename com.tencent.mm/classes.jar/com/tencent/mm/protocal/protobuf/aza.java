package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aza
  extends com.tencent.mm.bx.a
{
  public int Fvp;
  public cwt Gwo;
  public int Gwp;
  public int Gwq;
  public int Gwr = 1;
  public int Gws;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101809);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gwo == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatroomId");
        AppMethodBeat.o(101809);
        throw paramVarArgs;
      }
      if (this.Gwo != null)
      {
        paramVarArgs.lC(1, this.Gwo.computeSize());
        this.Gwo.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Fvp);
      paramVarArgs.aS(3, this.Gwp);
      paramVarArgs.aS(4, this.Gwq);
      paramVarArgs.aS(5, this.Gwr);
      paramVarArgs.aS(6, this.Gws);
      AppMethodBeat.o(101809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gwo == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = f.a.a.a.lB(1, this.Gwo.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.Fvp);
      int j = f.a.a.b.b.a.bz(3, this.Gwp);
      int k = f.a.a.b.b.a.bz(4, this.Gwq);
      int m = f.a.a.b.b.a.bz(5, this.Gwr);
      int n = f.a.a.b.b.a.bz(6, this.Gws);
      AppMethodBeat.o(101809);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Gwo == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatroomId");
          AppMethodBeat.o(101809);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aza localaza = (aza)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101809);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaza.Gwo = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101809);
          return 0;
        case 2: 
          localaza.Fvp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101809);
          return 0;
        case 3: 
          localaza.Gwp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101809);
          return 0;
        case 4: 
          localaza.Gwq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101809);
          return 0;
        case 5: 
          localaza.Gwr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101809);
          return 0;
        }
        localaza.Gws = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(101809);
        return 0;
      }
      AppMethodBeat.o(101809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aza
 * JD-Core Version:    0.7.0.1
 */