package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqa
  extends cvw
{
  public String FIo;
  public String dwb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91648);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FIo != null) {
        paramVarArgs.d(2, this.FIo);
      }
      if (this.dwb != null) {
        paramVarArgs.d(3, this.dwb);
      }
      AppMethodBeat.o(91648);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label430;
      }
    }
    label430:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FIo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FIo);
      }
      i = paramInt;
      if (this.dwb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dwb);
      }
      AppMethodBeat.o(91648);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91648);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cqa localcqa = (cqa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91648);
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
            localcqa.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91648);
          return 0;
        case 2: 
          localcqa.FIo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91648);
          return 0;
        }
        localcqa.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91648);
        return 0;
      }
      AppMethodBeat.o(91648);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqa
 * JD-Core Version:    0.7.0.1
 */