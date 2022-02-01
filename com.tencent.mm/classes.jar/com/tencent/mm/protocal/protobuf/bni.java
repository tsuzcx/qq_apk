package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bni
  extends cld
{
  public String AXo;
  public int AXp;
  public String ocH;
  public String ocI;
  public String sign;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82454);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82454);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.AXo != null) {
        paramVarArgs.d(2, this.AXo);
      }
      if (this.ocH != null) {
        paramVarArgs.d(3, this.ocH);
      }
      if (this.ocI != null) {
        paramVarArgs.d(4, this.ocI);
      }
      if (this.sign != null) {
        paramVarArgs.d(5, this.sign);
      }
      paramVarArgs.aR(6, this.AXp);
      AppMethodBeat.o(82454);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label646;
      }
    }
    label646:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.AXo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.AXo);
      }
      i = paramInt;
      if (this.ocH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ocH);
      }
      paramInt = i;
      if (this.ocI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ocI);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.sign);
      }
      paramInt = f.a.a.b.b.a.bA(6, this.AXp);
      AppMethodBeat.o(82454);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82454);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82454);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bni localbni = (bni)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82454);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbni.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82454);
          return 0;
        case 2: 
          localbni.AXo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82454);
          return 0;
        case 3: 
          localbni.ocH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82454);
          return 0;
        case 4: 
          localbni.ocI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82454);
          return 0;
        case 5: 
          localbni.sign = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82454);
          return 0;
        }
        localbni.AXp = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(82454);
        return 0;
      }
      AppMethodBeat.o(82454);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bni
 * JD-Core Version:    0.7.0.1
 */