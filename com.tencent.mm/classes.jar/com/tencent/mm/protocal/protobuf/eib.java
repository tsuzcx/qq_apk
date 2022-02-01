package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class eib
  extends cvw
{
  public b FZb;
  public String Hhh;
  public String IlG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123696);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Hhh != null) {
        paramVarArgs.d(2, this.Hhh);
      }
      if (this.FZb != null) {
        paramVarArgs.c(3, this.FZb);
      }
      if (this.IlG != null) {
        paramVarArgs.d(4, this.IlG);
      }
      AppMethodBeat.o(123696);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label490;
      }
    }
    label490:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hhh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hhh);
      }
      i = paramInt;
      if (this.FZb != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.FZb);
      }
      paramInt = i;
      if (this.IlG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.IlG);
      }
      AppMethodBeat.o(123696);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123696);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eib localeib = (eib)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123696);
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
            localeib.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123696);
          return 0;
        case 2: 
          localeib.Hhh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123696);
          return 0;
        case 3: 
          localeib.FZb = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(123696);
          return 0;
        }
        localeib.IlG = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(123696);
        return 0;
      }
      AppMethodBeat.o(123696);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eib
 * JD-Core Version:    0.7.0.1
 */