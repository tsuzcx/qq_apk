package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yn
  extends com.tencent.mm.bw.a
{
  public cnb Esh;
  public LinkedList<it> Esi;
  public boolean Esj;
  
  public yn()
  {
    AppMethodBeat.i(206854);
    this.Esi = new LinkedList();
    AppMethodBeat.o(206854);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206855);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Esh != null)
      {
        paramVarArgs.ln(1, this.Esh.computeSize());
        this.Esh.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Esi);
      paramVarArgs.bl(3, this.Esj);
      AppMethodBeat.o(206855);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Esh == null) {
        break label494;
      }
    }
    label494:
    for (paramInt = f.a.a.a.lm(1, this.Esh.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.Esi);
      int j = f.a.a.b.b.a.fK(3);
      AppMethodBeat.o(206855);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Esi.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(206855);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        yn localyn = (yn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(206855);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyn.Esh = ((cnb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(206855);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new it();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((it)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyn.Esi.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(206855);
          return 0;
        }
        localyn.Esj = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(206855);
        return 0;
      }
      AppMethodBeat.o(206855);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yn
 * JD-Core Version:    0.7.0.1
 */