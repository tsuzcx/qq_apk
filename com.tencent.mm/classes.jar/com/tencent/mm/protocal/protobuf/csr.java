package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class csr
  extends com.tencent.mm.bw.a
{
  public cxn HDR;
  public int HDS;
  public LinkedList<czm> HDT;
  
  public csr()
  {
    AppMethodBeat.i(6420);
    this.HDT = new LinkedList();
    AppMethodBeat.o(6420);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6421);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HDR == null)
      {
        paramVarArgs = new b("Not all required fields were included: GroupName");
        AppMethodBeat.o(6421);
        throw paramVarArgs;
      }
      if (this.HDR != null)
      {
        paramVarArgs.lJ(1, this.HDR.computeSize());
        this.HDR.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HDS);
      paramVarArgs.e(3, 8, this.HDT);
      AppMethodBeat.o(6421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HDR == null) {
        break label555;
      }
    }
    label555:
    for (paramInt = f.a.a.a.lI(1, this.HDR.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.HDS);
      int j = f.a.a.a.c(3, 8, this.HDT);
      AppMethodBeat.o(6421);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HDT.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HDR == null)
        {
          paramVarArgs = new b("Not all required fields were included: GroupName");
          AppMethodBeat.o(6421);
          throw paramVarArgs;
        }
        AppMethodBeat.o(6421);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        csr localcsr = (csr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6421);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsr.HDR = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6421);
          return 0;
        case 2: 
          localcsr.HDS = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(6421);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new czm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((czm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcsr.HDT.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(6421);
        return 0;
      }
      AppMethodBeat.o(6421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csr
 * JD-Core Version:    0.7.0.1
 */