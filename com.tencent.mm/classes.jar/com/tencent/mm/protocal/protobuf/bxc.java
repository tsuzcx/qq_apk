package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxc
  extends cvw
{
  public String Hki;
  public String dwb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82451);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dwb != null) {
        paramVarArgs.d(10, this.dwb);
      }
      if (this.Hki != null) {
        paramVarArgs.d(20, this.Hki);
      }
      AppMethodBeat.o(82451);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label442;
      }
    }
    label442:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dwb != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.dwb);
      }
      i = paramInt;
      if (this.Hki != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.Hki);
      }
      AppMethodBeat.o(82451);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(82451);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bxc localbxc = (bxc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82451);
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
            localbxc.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82451);
          return 0;
        case 10: 
          localbxc.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82451);
          return 0;
        }
        localbxc.Hki = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(82451);
        return 0;
      }
      AppMethodBeat.o(82451);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxc
 * JD-Core Version:    0.7.0.1
 */