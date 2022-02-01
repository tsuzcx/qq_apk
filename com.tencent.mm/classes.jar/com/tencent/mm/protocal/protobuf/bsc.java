package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bsc
  extends cvw
{
  public int HeR;
  public eio HeS;
  public String ikm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123620);
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
      paramVarArgs.aS(3, this.HeR);
      if (this.HeS != null)
      {
        paramVarArgs.lJ(4, this.HeS.computeSize());
        this.HeS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123620);
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
      i += f.a.a.b.b.a.bz(3, this.HeR);
      paramInt = i;
      if (this.HeS != null) {
        paramInt = i + f.a.a.a.lI(4, this.HeS.computeSize());
      }
      AppMethodBeat.o(123620);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123620);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bsc localbsc = (bsc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123620);
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
            localbsc.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123620);
          return 0;
        case 2: 
          localbsc.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123620);
          return 0;
        case 3: 
          localbsc.HeR = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123620);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eio();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eio)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbsc.HeS = ((eio)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123620);
        return 0;
      }
      AppMethodBeat.o(123620);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsc
 * JD-Core Version:    0.7.0.1
 */