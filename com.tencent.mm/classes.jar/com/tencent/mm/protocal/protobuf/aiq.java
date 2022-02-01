package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aiq
  extends cvp
{
  public int GfW;
  public int dlw;
  public String paA;
  public String qeQ;
  public String vkl;
  public String vlG;
  public String vlH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91455);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91455);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dlw);
      if (this.paA != null) {
        paramVarArgs.d(3, this.paA);
      }
      if (this.vkl != null) {
        paramVarArgs.d(4, this.vkl);
      }
      if (this.qeQ != null) {
        paramVarArgs.d(5, this.qeQ);
      }
      paramVarArgs.aS(6, this.GfW);
      if (this.vlH != null) {
        paramVarArgs.d(7, this.vlH);
      }
      if (this.vlG != null) {
        paramVarArgs.d(8, this.vlG);
      }
      AppMethodBeat.o(91455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dlw);
      paramInt = i;
      if (this.paA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.paA);
      }
      i = paramInt;
      if (this.vkl != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.vkl);
      }
      paramInt = i;
      if (this.qeQ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.qeQ);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.GfW);
      paramInt = i;
      if (this.vlH != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.vlH);
      }
      i = paramInt;
      if (this.vlG != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.vlG);
      }
      AppMethodBeat.o(91455);
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
          AppMethodBeat.o(91455);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91455);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aiq localaiq = (aiq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91455);
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
            localaiq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91455);
          return 0;
        case 2: 
          localaiq.dlw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91455);
          return 0;
        case 3: 
          localaiq.paA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91455);
          return 0;
        case 4: 
          localaiq.vkl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91455);
          return 0;
        case 5: 
          localaiq.qeQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91455);
          return 0;
        case 6: 
          localaiq.GfW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91455);
          return 0;
        case 7: 
          localaiq.vlH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91455);
          return 0;
        }
        localaiq.vlG = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91455);
        return 0;
      }
      AppMethodBeat.o(91455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aiq
 * JD-Core Version:    0.7.0.1
 */