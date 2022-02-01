package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wp
  extends com.tencent.mm.bx.a
{
  public bhk CYJ;
  public dko CYK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110892);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CYJ != null)
      {
        paramVarArgs.kX(1, this.CYJ.computeSize());
        this.CYJ.writeFields(paramVarArgs);
      }
      if (this.CYK != null)
      {
        paramVarArgs.kX(2, this.CYK.computeSize());
        this.CYK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110892);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CYJ == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.a.kW(1, this.CYJ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CYK != null) {
        i = paramInt + f.a.a.a.kW(2, this.CYK.computeSize());
      }
      AppMethodBeat.o(110892);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(110892);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        wp localwp = (wp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110892);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bhk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bhk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localwp.CYJ = ((bhk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110892);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dko();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dko)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localwp.CYK = ((dko)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110892);
        return 0;
      }
      AppMethodBeat.o(110892);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wp
 * JD-Core Version:    0.7.0.1
 */