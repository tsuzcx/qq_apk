package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ayu
  extends cvp
{
  public String GvZ;
  public tv Gwa;
  public int Gwb;
  public cze Gwc;
  public String ozQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114023);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114023);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ozQ != null) {
        paramVarArgs.d(2, this.ozQ);
      }
      if (this.GvZ != null) {
        paramVarArgs.d(3, this.GvZ);
      }
      if (this.Gwa != null)
      {
        paramVarArgs.lC(4, this.Gwa.computeSize());
        this.Gwa.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.Gwb);
      if (this.Gwc != null)
      {
        paramVarArgs.lC(6, this.Gwc.computeSize());
        this.Gwc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114023);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label834;
      }
    }
    label834:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ozQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ozQ);
      }
      i = paramInt;
      if (this.GvZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GvZ);
      }
      paramInt = i;
      if (this.Gwa != null) {
        paramInt = i + f.a.a.a.lB(4, this.Gwa.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Gwb);
      paramInt = i;
      if (this.Gwc != null) {
        paramInt = i + f.a.a.a.lB(6, this.Gwc.computeSize());
      }
      AppMethodBeat.o(114023);
      return paramInt;
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
          AppMethodBeat.o(114023);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114023);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayu localayu = (ayu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114023);
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
            localayu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114023);
          return 0;
        case 2: 
          localayu.ozQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114023);
          return 0;
        case 3: 
          localayu.GvZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114023);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayu.Gwa = ((tv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114023);
          return 0;
        case 5: 
          localayu.Gwb = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114023);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cze();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cze)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localayu.Gwc = ((cze)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114023);
        return 0;
      }
      AppMethodBeat.o(114023);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayu
 * JD-Core Version:    0.7.0.1
 */