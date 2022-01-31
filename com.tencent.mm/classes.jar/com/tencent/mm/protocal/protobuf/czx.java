package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czx
  extends com.tencent.mm.bv.a
{
  public String xMI;
  public String ygD;
  public ccg ygE;
  public boolean ygo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115004);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ygD != null) {
        paramVarArgs.e(1, this.ygD);
      }
      if (this.xMI != null) {
        paramVarArgs.e(2, this.xMI);
      }
      if (this.ygE != null)
      {
        paramVarArgs.iQ(3, this.ygE.computeSize());
        this.ygE.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.ygo);
      AppMethodBeat.o(115004);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ygD == null) {
        break label474;
      }
    }
    label474:
    for (int i = e.a.a.b.b.a.f(1, this.ygD) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xMI != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xMI);
      }
      i = paramInt;
      if (this.ygE != null) {
        i = paramInt + e.a.a.a.iP(3, this.ygE.computeSize());
      }
      paramInt = e.a.a.b.b.a.eW(4);
      AppMethodBeat.o(115004);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(115004);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        czx localczx = (czx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115004);
          return -1;
        case 1: 
          localczx.ygD = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(115004);
          return 0;
        case 2: 
          localczx.xMI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(115004);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ccg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localczx.ygE = ((ccg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115004);
          return 0;
        }
        localczx.ygo = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(115004);
        return 0;
      }
      AppMethodBeat.o(115004);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czx
 * JD-Core Version:    0.7.0.1
 */