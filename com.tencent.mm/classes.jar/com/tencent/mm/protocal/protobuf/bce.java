package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bce
  extends com.tencent.mm.bv.a
{
  public bcf xrm;
  public bcd xrn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58913);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xrm == null)
      {
        paramVarArgs = new b("Not all required fields were included: RsaReqData");
        AppMethodBeat.o(58913);
        throw paramVarArgs;
      }
      if (this.xrn == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesReqData");
        AppMethodBeat.o(58913);
        throw paramVarArgs;
      }
      if (this.xrm != null)
      {
        paramVarArgs.iQ(1, this.xrm.computeSize());
        this.xrm.writeFields(paramVarArgs);
      }
      if (this.xrn != null)
      {
        paramVarArgs.iQ(2, this.xrn.computeSize());
        this.xrn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(58913);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xrm == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = e.a.a.a.iP(1, this.xrm.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xrn != null) {
        i = paramInt + e.a.a.a.iP(2, this.xrn.computeSize());
      }
      AppMethodBeat.o(58913);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xrm == null)
        {
          paramVarArgs = new b("Not all required fields were included: RsaReqData");
          AppMethodBeat.o(58913);
          throw paramVarArgs;
        }
        if (this.xrn == null)
        {
          paramVarArgs = new b("Not all required fields were included: AesReqData");
          AppMethodBeat.o(58913);
          throw paramVarArgs;
        }
        AppMethodBeat.o(58913);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bce localbce = (bce)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(58913);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcf();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bcf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbce.xrm = ((bcf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58913);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bcd();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bcd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbce.xrn = ((bcd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58913);
        return 0;
      }
      AppMethodBeat.o(58913);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bce
 * JD-Core Version:    0.7.0.1
 */