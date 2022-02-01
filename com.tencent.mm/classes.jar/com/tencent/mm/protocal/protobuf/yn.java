package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class yn
  extends cld
{
  public String CIQ;
  public cfw CIW;
  public int DaM;
  public amv DaN;
  public mk DaO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124480);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124480);
        throw paramVarArgs;
      }
      if (this.CIW == null)
      {
        paramVarArgs = new b("Not all required fields were included: qy_base_resp");
        AppMethodBeat.o(124480);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.CIW != null)
      {
        paramVarArgs.kX(2, this.CIW.computeSize());
        this.CIW.writeFields(paramVarArgs);
      }
      if (this.CIQ != null) {
        paramVarArgs.d(3, this.CIQ);
      }
      paramVarArgs.aR(4, this.DaM);
      if (this.DaN != null)
      {
        paramVarArgs.kX(5, this.DaN.computeSize());
        this.DaN.writeFields(paramVarArgs);
      }
      if (this.DaO != null)
      {
        paramVarArgs.kX(6, this.DaO.computeSize());
        this.DaO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124480);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label974;
      }
    }
    label974:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CIW != null) {
        paramInt = i + f.a.a.a.kW(2, this.CIW.computeSize());
      }
      i = paramInt;
      if (this.CIQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CIQ);
      }
      i += f.a.a.b.b.a.bA(4, this.DaM);
      paramInt = i;
      if (this.DaN != null) {
        paramInt = i + f.a.a.a.kW(5, this.DaN.computeSize());
      }
      i = paramInt;
      if (this.DaO != null) {
        i = paramInt + f.a.a.a.kW(6, this.DaO.computeSize());
      }
      AppMethodBeat.o(124480);
      return i;
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
          AppMethodBeat.o(124480);
          throw paramVarArgs;
        }
        if (this.CIW == null)
        {
          paramVarArgs = new b("Not all required fields were included: qy_base_resp");
          AppMethodBeat.o(124480);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124480);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        yn localyn = (yn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124480);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124480);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyn.CIW = ((cfw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124480);
          return 0;
        case 3: 
          localyn.CIQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124480);
          return 0;
        case 4: 
          localyn.DaM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124480);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new amv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((amv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyn.DaN = ((amv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124480);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new mk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((mk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyn.DaO = ((mk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124480);
        return 0;
      }
      AppMethodBeat.o(124480);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yn
 * JD-Core Version:    0.7.0.1
 */