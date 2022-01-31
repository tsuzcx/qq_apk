package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oo
  extends com.tencent.mm.bv.a
{
  public String wFb;
  public int wFc;
  public String wFd;
  public ou wFe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89027);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wFb != null) {
        paramVarArgs.e(1, this.wFb);
      }
      paramVarArgs.aO(2, this.wFc);
      if (this.wFd != null) {
        paramVarArgs.e(3, this.wFd);
      }
      if (this.wFe != null)
      {
        paramVarArgs.iQ(4, this.wFe.computeSize());
        this.wFe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(89027);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wFb == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = e.a.a.b.b.a.f(1, this.wFb) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wFc);
      paramInt = i;
      if (this.wFd != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wFd);
      }
      i = paramInt;
      if (this.wFe != null) {
        i = paramInt + e.a.a.a.iP(4, this.wFe.computeSize());
      }
      AppMethodBeat.o(89027);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89027);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        oo localoo = (oo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89027);
          return -1;
        case 1: 
          localoo.wFb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89027);
          return 0;
        case 2: 
          localoo.wFc = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89027);
          return 0;
        case 3: 
          localoo.wFd = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89027);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ou();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ou)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localoo.wFe = ((ou)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(89027);
        return 0;
      }
      AppMethodBeat.o(89027);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oo
 * JD-Core Version:    0.7.0.1
 */