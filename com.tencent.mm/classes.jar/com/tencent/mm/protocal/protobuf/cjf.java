package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cjf
  extends cwj
{
  public String GMp;
  public String GMq;
  public eda GMv;
  public String HvS;
  public int qkQ;
  public String qkR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91572);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91572);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GMq != null) {
        paramVarArgs.d(2, this.GMq);
      }
      paramVarArgs.aS(3, this.qkQ);
      if (this.qkR != null) {
        paramVarArgs.d(4, this.qkR);
      }
      if (this.GMp != null) {
        paramVarArgs.d(5, this.GMp);
      }
      if (this.HvS != null) {
        paramVarArgs.d(6, this.HvS);
      }
      if (this.GMv != null)
      {
        paramVarArgs.lJ(7, this.GMv.computeSize());
        this.GMv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91572);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GMq != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GMq);
      }
      i += f.a.a.b.b.a.bz(3, this.qkQ);
      paramInt = i;
      if (this.qkR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.qkR);
      }
      i = paramInt;
      if (this.GMp != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GMp);
      }
      paramInt = i;
      if (this.HvS != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HvS);
      }
      i = paramInt;
      if (this.GMv != null) {
        i = paramInt + f.a.a.a.lI(7, this.GMv.computeSize());
      }
      AppMethodBeat.o(91572);
      return i;
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
          AppMethodBeat.o(91572);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91572);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjf localcjf = (cjf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91572);
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
            localcjf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91572);
          return 0;
        case 2: 
          localcjf.GMq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91572);
          return 0;
        case 3: 
          localcjf.qkQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91572);
          return 0;
        case 4: 
          localcjf.qkR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91572);
          return 0;
        case 5: 
          localcjf.GMp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91572);
          return 0;
        case 6: 
          localcjf.HvS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91572);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eda();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eda)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcjf.GMv = ((eda)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91572);
        return 0;
      }
      AppMethodBeat.o(91572);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjf
 * JD-Core Version:    0.7.0.1
 */