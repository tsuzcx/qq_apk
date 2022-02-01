package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ayw
  extends cwj
{
  public boolean GPn;
  public int GPo;
  public int GPp;
  public ti GPq;
  public boolean GPr;
  public int oGt;
  public String oGu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114007);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114007);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.oGt);
      if (this.oGu != null) {
        paramVarArgs.d(3, this.oGu);
      }
      paramVarArgs.bC(4, this.GPn);
      paramVarArgs.aS(5, this.GPo);
      paramVarArgs.aS(6, this.GPp);
      if (this.GPq != null)
      {
        paramVarArgs.lJ(7, this.GPq.computeSize());
        this.GPq.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(8, this.GPr);
      AppMethodBeat.o(114007);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt + f.a.a.b.b.a.amF(4) + f.a.a.b.b.a.bz(5, this.GPo) + f.a.a.b.b.a.bz(6, this.GPp);
      paramInt = i;
      if (this.GPq != null) {
        paramInt = i + f.a.a.a.lI(7, this.GPq.computeSize());
      }
      i = f.a.a.b.b.a.amF(8);
      AppMethodBeat.o(114007);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(114007);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114007);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayw localayw = (ayw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114007);
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
            localayw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114007);
          return 0;
        case 2: 
          localayw.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114007);
          return 0;
        case 3: 
          localayw.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114007);
          return 0;
        case 4: 
          localayw.GPn = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(114007);
          return 0;
        case 5: 
          localayw.GPo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114007);
          return 0;
        case 6: 
          localayw.GPp = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114007);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ti();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ti)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayw.GPq = ((ti)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114007);
          return 0;
        }
        localayw.GPr = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(114007);
        return 0;
      }
      AppMethodBeat.o(114007);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayw
 * JD-Core Version:    0.7.0.1
 */