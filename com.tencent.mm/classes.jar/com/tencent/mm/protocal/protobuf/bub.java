package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bub
  extends cvw
{
  public int GWF;
  public ekh Hhp;
  public String ikm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123626);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ikm != null) {
        paramVarArgs.d(2, this.ikm);
      }
      paramVarArgs.aS(3, this.GWF);
      if (this.Hhp != null)
      {
        paramVarArgs.lJ(4, this.Hhp.computeSize());
        this.Hhp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123626);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ikm != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ikm);
      }
      i += f.a.a.b.b.a.bz(3, this.GWF);
      paramInt = i;
      if (this.Hhp != null) {
        paramInt = i + f.a.a.a.lI(4, this.Hhp.computeSize());
      }
      AppMethodBeat.o(123626);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123626);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bub localbub = (bub)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123626);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbub.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123626);
          return 0;
        case 2: 
          localbub.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123626);
          return 0;
        case 3: 
          localbub.GWF = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123626);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ekh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ekh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbub.Hhp = ((ekh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123626);
        return 0;
      }
      AppMethodBeat.o(123626);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bub
 * JD-Core Version:    0.7.0.1
 */