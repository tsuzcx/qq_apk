package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccd
  extends com.tencent.mm.bx.a
{
  public bor FEc;
  public pv FEd;
  public ccc FEe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133180);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FEc != null)
      {
        paramVarArgs.lC(1, this.FEc.computeSize());
        this.FEc.writeFields(paramVarArgs);
      }
      if (this.FEe != null)
      {
        paramVarArgs.lC(2, this.FEe.computeSize());
        this.FEe.writeFields(paramVarArgs);
      }
      if (this.FEd != null)
      {
        paramVarArgs.lC(3, this.FEd.computeSize());
        this.FEd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133180);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FEc == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.lB(1, this.FEc.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FEe != null) {
        paramInt = i + f.a.a.a.lB(2, this.FEe.computeSize());
      }
      i = paramInt;
      if (this.FEd != null) {
        i = paramInt + f.a.a.a.lB(3, this.FEd.computeSize());
      }
      AppMethodBeat.o(133180);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(133180);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ccd localccd = (ccd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133180);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bor();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bor)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccd.FEc = ((bor)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133180);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccd.FEe = ((ccc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133180);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((pv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localccd.FEd = ((pv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133180);
        return 0;
      }
      AppMethodBeat.o(133180);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccd
 * JD-Core Version:    0.7.0.1
 */