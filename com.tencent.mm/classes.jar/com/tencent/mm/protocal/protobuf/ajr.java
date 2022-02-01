package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ajr
  extends cwj
{
  public String FNj;
  public LinkedList<ajs> FNl;
  public int fNf;
  public String xrf;
  
  public ajr()
  {
    AppMethodBeat.i(32208);
    this.FNl = new LinkedList();
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
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xrf != null) {
        paramVarArgs.d(2, this.xrf);
      }
      paramVarArgs.aS(3, this.fNf);
      paramVarArgs.e(4, 8, this.FNl);
      if (this.FNj != null) {
        paramVarArgs.d(5, this.FNj);
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
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xrf != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.xrf);
      }
      i = i + f.a.a.b.b.a.bz(3, this.fNf) + f.a.a.a.c(4, 8, this.FNl);
      paramInt = i;
      if (this.FNj != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FNj);
      }
      AppMethodBeat.o(32209);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FNl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
        ajr localajr = (ajr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32209);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32209);
          return 0;
        case 2: 
          localajr.xrf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32209);
          return 0;
        case 3: 
          localajr.fNf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32209);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ajs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ajs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajr.FNl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32209);
          return 0;
        }
        localajr.FNj = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32209);
        return 0;
      }
      AppMethodBeat.o(32209);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajr
 * JD-Core Version:    0.7.0.1
 */