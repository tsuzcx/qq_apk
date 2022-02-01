package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aya
  extends cvp
{
  public rx FED;
  public rx FEE;
  public rx FEF;
  public SKBuiltinBuffer_t FEG;
  public SKBuiltinBuffer_t FEH;
  public rx FEI;
  public int FEJ;
  public rw FEK;
  public rw FEL;
  public int GvL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152567);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152567);
        throw paramVarArgs;
      }
      if (this.FED == null)
      {
        paramVarArgs = new b("Not all required fields were included: DnsInfo");
        AppMethodBeat.o(152567);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FED != null)
      {
        paramVarArgs.lC(2, this.FED.computeSize());
        this.FED.writeFields(paramVarArgs);
      }
      if (this.FEE != null)
      {
        paramVarArgs.lC(3, this.FEE.computeSize());
        this.FEE.writeFields(paramVarArgs);
      }
      if (this.FEF != null)
      {
        paramVarArgs.lC(4, this.FEF.computeSize());
        this.FEF.writeFields(paramVarArgs);
      }
      if (this.FEG != null)
      {
        paramVarArgs.lC(5, this.FEG.computeSize());
        this.FEG.writeFields(paramVarArgs);
      }
      if (this.FEH != null)
      {
        paramVarArgs.lC(6, this.FEH.computeSize());
        this.FEH.writeFields(paramVarArgs);
      }
      if (this.FEI != null)
      {
        paramVarArgs.lC(7, this.FEI.computeSize());
        this.FEI.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.FEJ);
      if (this.FEK != null)
      {
        paramVarArgs.lC(9, this.FEK.computeSize());
        this.FEK.writeFields(paramVarArgs);
      }
      if (this.FEL != null)
      {
        paramVarArgs.lC(10, this.FEL.computeSize());
        this.FEL.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(11, this.GvL);
      AppMethodBeat.o(152567);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1738;
      }
    }
    label1738:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FED != null) {
        paramInt = i + f.a.a.a.lB(2, this.FED.computeSize());
      }
      i = paramInt;
      if (this.FEE != null) {
        i = paramInt + f.a.a.a.lB(3, this.FEE.computeSize());
      }
      paramInt = i;
      if (this.FEF != null) {
        paramInt = i + f.a.a.a.lB(4, this.FEF.computeSize());
      }
      i = paramInt;
      if (this.FEG != null) {
        i = paramInt + f.a.a.a.lB(5, this.FEG.computeSize());
      }
      paramInt = i;
      if (this.FEH != null) {
        paramInt = i + f.a.a.a.lB(6, this.FEH.computeSize());
      }
      i = paramInt;
      if (this.FEI != null) {
        i = paramInt + f.a.a.a.lB(7, this.FEI.computeSize());
      }
      i += f.a.a.b.b.a.bz(8, this.FEJ);
      paramInt = i;
      if (this.FEK != null) {
        paramInt = i + f.a.a.a.lB(9, this.FEK.computeSize());
      }
      i = paramInt;
      if (this.FEL != null) {
        i = paramInt + f.a.a.a.lB(10, this.FEL.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(11, this.GvL);
      AppMethodBeat.o(152567);
      return i + paramInt;
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
          AppMethodBeat.o(152567);
          throw paramVarArgs;
        }
        if (this.FED == null)
        {
          paramVarArgs = new b("Not all required fields were included: DnsInfo");
          AppMethodBeat.o(152567);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152567);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aya localaya = (aya)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152567);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaya.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaya.FED = ((rx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaya.FEE = ((rx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaya.FEF = ((rx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaya.FEG = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaya.FEH = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaya.FEI = ((rx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 8: 
          localaya.FEJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152567);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaya.FEK = ((rw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaya.FEL = ((rw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        }
        localaya.GvL = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152567);
        return 0;
      }
      AppMethodBeat.o(152567);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aya
 * JD-Core Version:    0.7.0.1
 */