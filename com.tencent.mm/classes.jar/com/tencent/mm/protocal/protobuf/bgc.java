package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgc
  extends cvw
{
  public int GeT;
  public String URL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32258);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.URL != null) {
        paramVarArgs.d(2, this.URL);
      }
      paramVarArgs.aS(3, this.GeT);
      AppMethodBeat.o(32258);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label423;
      }
    }
    label423:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.URL != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.URL);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.GeT);
      AppMethodBeat.o(32258);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32258);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bgc localbgc = (bgc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32258);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgc.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32258);
          return 0;
        case 2: 
          localbgc.URL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32258);
          return 0;
        }
        localbgc.GeT = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32258);
        return 0;
      }
      AppMethodBeat.o(32258);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgc
 * JD-Core Version:    0.7.0.1
 */