package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgu
  extends cvw
{
  public String GVb;
  public String GVc;
  public String hCa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116454);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hCa != null) {
        paramVarArgs.d(2, this.hCa);
      }
      if (this.GVb != null) {
        paramVarArgs.d(3, this.GVb);
      }
      if (this.GVc != null) {
        paramVarArgs.d(4, this.GVc);
      }
      AppMethodBeat.o(116454);
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
      if (this.hCa != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hCa);
      }
      i = paramInt;
      if (this.GVb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GVb);
      }
      paramInt = i;
      if (this.GVc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GVc);
      }
      AppMethodBeat.o(116454);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(116454);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bgu localbgu = (bgu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116454);
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
            localbgu.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116454);
          return 0;
        case 2: 
          localbgu.hCa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116454);
          return 0;
        case 3: 
          localbgu.GVb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116454);
          return 0;
        }
        localbgu.GVc = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(116454);
        return 0;
      }
      AppMethodBeat.o(116454);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgu
 * JD-Core Version:    0.7.0.1
 */