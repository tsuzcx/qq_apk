package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class yg
  extends cvp
{
  public doh FXQ;
  public cjj FXm;
  public String Fmb;
  public int qel;
  public String qem;
  public String token;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91419);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91419);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.qel);
      if (this.qem != null) {
        paramVarArgs.d(3, this.qem);
      }
      if (this.token != null) {
        paramVarArgs.d(4, this.token);
      }
      if (this.FXm != null)
      {
        paramVarArgs.lC(5, this.FXm.computeSize());
        this.FXm.writeFields(paramVarArgs);
      }
      if (this.Fmb != null) {
        paramVarArgs.d(6, this.Fmb);
      }
      if (this.FXQ != null)
      {
        paramVarArgs.lC(7, this.FXQ.computeSize());
        this.FXQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91419);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.qel);
      paramInt = i;
      if (this.qem != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.qem);
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.token);
      }
      paramInt = i;
      if (this.FXm != null) {
        paramInt = i + f.a.a.a.lB(5, this.FXm.computeSize());
      }
      i = paramInt;
      if (this.Fmb != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Fmb);
      }
      paramInt = i;
      if (this.FXQ != null) {
        paramInt = i + f.a.a.a.lB(7, this.FXQ.computeSize());
      }
      AppMethodBeat.o(91419);
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
          AppMethodBeat.o(91419);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91419);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        yg localyg = (yg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91419);
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
            localyg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91419);
          return 0;
        case 2: 
          localyg.qel = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91419);
          return 0;
        case 3: 
          localyg.qem = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91419);
          return 0;
        case 4: 
          localyg.token = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91419);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyg.FXm = ((cjj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91419);
          return 0;
        case 6: 
          localyg.Fmb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91419);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new doh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((doh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyg.FXQ = ((doh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91419);
        return 0;
      }
      AppMethodBeat.o(91419);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yg
 * JD-Core Version:    0.7.0.1
 */