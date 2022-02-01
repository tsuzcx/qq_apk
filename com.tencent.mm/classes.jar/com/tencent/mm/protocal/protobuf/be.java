package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class be
  extends com.tencent.mm.bx.a
{
  public dmo FsP;
  public dmo FsQ;
  public cwq FsR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91342);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FsP != null)
      {
        paramVarArgs.lC(1, this.FsP.computeSize());
        this.FsP.writeFields(paramVarArgs);
      }
      if (this.FsQ != null)
      {
        paramVarArgs.lC(2, this.FsQ.computeSize());
        this.FsQ.writeFields(paramVarArgs);
      }
      if (this.FsR != null)
      {
        paramVarArgs.lC(3, this.FsR.computeSize());
        this.FsR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91342);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FsP == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.lB(1, this.FsP.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FsQ != null) {
        paramInt = i + f.a.a.a.lB(2, this.FsQ.computeSize());
      }
      i = paramInt;
      if (this.FsR != null) {
        i = paramInt + f.a.a.a.lB(3, this.FsR.computeSize());
      }
      AppMethodBeat.o(91342);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91342);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        be localbe = (be)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91342);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbe.FsP = ((dmo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91342);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbe.FsQ = ((dmo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91342);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbe.FsR = ((cwq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91342);
        return 0;
      }
      AppMethodBeat.o(91342);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.be
 * JD-Core Version:    0.7.0.1
 */