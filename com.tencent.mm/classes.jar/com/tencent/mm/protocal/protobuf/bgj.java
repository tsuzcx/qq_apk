package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bgj
  extends cvp
{
  public int FCq;
  public String FCr;
  public String GBH;
  public String GBI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91505);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91505);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GBH != null) {
        paramVarArgs.d(2, this.GBH);
      }
      paramVarArgs.aS(3, this.FCq);
      if (this.FCr != null) {
        paramVarArgs.d(4, this.FCr);
      }
      if (this.GBI != null) {
        paramVarArgs.d(5, this.GBI);
      }
      AppMethodBeat.o(91505);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GBH != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GBH);
      }
      i += f.a.a.b.b.a.bz(3, this.FCq);
      paramInt = i;
      if (this.FCr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FCr);
      }
      i = paramInt;
      if (this.GBI != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GBI);
      }
      AppMethodBeat.o(91505);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91505);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91505);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bgj localbgj = (bgj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91505);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91505);
          return 0;
        case 2: 
          localbgj.GBH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91505);
          return 0;
        case 3: 
          localbgj.FCq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91505);
          return 0;
        case 4: 
          localbgj.FCr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91505);
          return 0;
        }
        localbgj.GBI = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91505);
        return 0;
      }
      AppMethodBeat.o(91505);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgj
 * JD-Core Version:    0.7.0.1
 */