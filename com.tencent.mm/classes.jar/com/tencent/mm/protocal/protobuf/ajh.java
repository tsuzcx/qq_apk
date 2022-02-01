package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ajh
  extends cvp
{
  public String FuL;
  public LinkedList<aji> FuN;
  public int fLb;
  public String xbo;
  
  public ajh()
  {
    AppMethodBeat.i(32208);
    this.FuN = new LinkedList();
    AppMethodBeat.o(32208);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32209);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32209);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xbo != null) {
        paramVarArgs.d(2, this.xbo);
      }
      paramVarArgs.aS(3, this.fLb);
      paramVarArgs.e(4, 8, this.FuN);
      if (this.FuL != null) {
        paramVarArgs.d(5, this.FuL);
      }
      AppMethodBeat.o(32209);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label673;
      }
    }
    label673:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xbo != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.xbo);
      }
      i = i + f.a.a.b.b.a.bz(3, this.fLb) + f.a.a.a.c(4, 8, this.FuN);
      paramInt = i;
      if (this.FuL != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FuL);
      }
      AppMethodBeat.o(32209);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FuN.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32209);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32209);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ajh localajh = (ajh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32209);
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
            localajh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32209);
          return 0;
        case 2: 
          localajh.xbo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32209);
          return 0;
        case 3: 
          localajh.fLb = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32209);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aji();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aji)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajh.FuN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32209);
          return 0;
        }
        localajh.FuL = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32209);
        return 0;
      }
      AppMethodBeat.o(32209);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajh
 * JD-Core Version:    0.7.0.1
 */