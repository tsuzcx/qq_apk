package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bc
  extends com.tencent.mm.bx.a
{
  public dbp Cvo;
  public dbp Cvp;
  public cmc Cvq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91342);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Cvo != null)
      {
        paramVarArgs.kX(1, this.Cvo.computeSize());
        this.Cvo.writeFields(paramVarArgs);
      }
      if (this.Cvp != null)
      {
        paramVarArgs.kX(2, this.Cvp.computeSize());
        this.Cvp.writeFields(paramVarArgs);
      }
      if (this.Cvq != null)
      {
        paramVarArgs.kX(3, this.Cvq.computeSize());
        this.Cvq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91342);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Cvo == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.kW(1, this.Cvo.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Cvp != null) {
        paramInt = i + f.a.a.a.kW(2, this.Cvp.computeSize());
      }
      i = paramInt;
      if (this.Cvq != null) {
        i = paramInt + f.a.a.a.kW(3, this.Cvq.computeSize());
      }
      AppMethodBeat.o(91342);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91342);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bc localbc = (bc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91342);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbc.Cvo = ((dbp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91342);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbc.Cvp = ((dbp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91342);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbc.Cvq = ((cmc)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bc
 * JD-Core Version:    0.7.0.1
 */