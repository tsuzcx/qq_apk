package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pn
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b CNV;
  public com.tencent.mm.bx.b CNW;
  public LinkedList<cqe> CNX;
  
  public pn()
  {
    AppMethodBeat.i(117851);
    this.CNX = new LinkedList();
    AppMethodBeat.o(117851);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117852);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CNV == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Title");
        AppMethodBeat.o(117852);
        throw paramVarArgs;
      }
      if (this.CNW == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: ServiceUrl");
        AppMethodBeat.o(117852);
        throw paramVarArgs;
      }
      if (this.CNV != null) {
        paramVarArgs.c(1, this.CNV);
      }
      if (this.CNW != null) {
        paramVarArgs.c(2, this.CNW);
      }
      paramVarArgs.e(3, 8, this.CNX);
      AppMethodBeat.o(117852);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CNV == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = f.a.a.b.b.a.b(1, this.CNV) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CNW != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.CNW);
      }
      paramInt = f.a.a.a.c(3, 8, this.CNX);
      AppMethodBeat.o(117852);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CNX.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CNV == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Title");
          AppMethodBeat.o(117852);
          throw paramVarArgs;
        }
        if (this.CNW == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: ServiceUrl");
          AppMethodBeat.o(117852);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117852);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        pn localpn = (pn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117852);
          return -1;
        case 1: 
          localpn.CNV = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(117852);
          return 0;
        case 2: 
          localpn.CNW = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(117852);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cqe();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cqe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpn.CNX.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117852);
        return 0;
      }
      AppMethodBeat.o(117852);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pn
 * JD-Core Version:    0.7.0.1
 */