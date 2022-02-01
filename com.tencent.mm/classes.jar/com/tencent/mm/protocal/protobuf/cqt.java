package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cqt
  extends cvp
{
  public cqq Hje;
  public int Hjs;
  public int Hjt;
  public String Hju;
  public String qmb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32404);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hje == null)
      {
        paramVarArgs = new b("Not all required fields were included: rcptinfolist");
        AppMethodBeat.o(32404);
        throw paramVarArgs;
      }
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32404);
        throw paramVarArgs;
      }
      if (this.Hje != null)
      {
        paramVarArgs.lC(1, this.Hje.computeSize());
        this.Hje.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Hjs);
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(3, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.qmb != null) {
        paramVarArgs.d(4, this.qmb);
      }
      paramVarArgs.aS(5, this.Hjt);
      if (this.Hju != null) {
        paramVarArgs.d(6, this.Hju);
      }
      AppMethodBeat.o(32404);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hje == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = f.a.a.a.lB(1, this.Hje.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Hjs);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + f.a.a.a.lB(3, this.BaseResponse.computeSize());
      }
      i = paramInt;
      if (this.qmb != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.qmb);
      }
      i += f.a.a.b.b.a.bz(5, this.Hjt);
      paramInt = i;
      if (this.Hju != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Hju);
      }
      AppMethodBeat.o(32404);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Hje == null)
        {
          paramVarArgs = new b("Not all required fields were included: rcptinfolist");
          AppMethodBeat.o(32404);
          throw paramVarArgs;
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32404);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32404);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cqt localcqt = (cqt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32404);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cqq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcqt.Hje = ((cqq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32404);
          return 0;
        case 2: 
          localcqt.Hjs = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32404);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcqt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32404);
          return 0;
        case 4: 
          localcqt.qmb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32404);
          return 0;
        case 5: 
          localcqt.Hjt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32404);
          return 0;
        }
        localcqt.Hju = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32404);
        return 0;
      }
      AppMethodBeat.o(32404);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqt
 * JD-Core Version:    0.7.0.1
 */