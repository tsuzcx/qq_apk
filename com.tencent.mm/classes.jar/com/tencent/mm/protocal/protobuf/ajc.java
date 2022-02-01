package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ajc
  extends cwj
{
  public bqo GyE;
  public int dmy;
  public String phe;
  public String tsf;
  public String vCI;
  public String vwq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91457);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91457);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dmy);
      if (this.phe != null) {
        paramVarArgs.d(3, this.phe);
      }
      if (this.vwq != null) {
        paramVarArgs.d(4, this.vwq);
      }
      if (this.tsf != null) {
        paramVarArgs.d(5, this.tsf);
      }
      if (this.vCI != null) {
        paramVarArgs.d(6, this.vCI);
      }
      if (this.GyE != null)
      {
        paramVarArgs.lJ(7, this.GyE.computeSize());
        this.GyE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91457);
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
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dmy);
      paramInt = i;
      if (this.phe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.phe);
      }
      i = paramInt;
      if (this.vwq != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.vwq);
      }
      paramInt = i;
      if (this.tsf != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.tsf);
      }
      i = paramInt;
      if (this.vCI != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.vCI);
      }
      paramInt = i;
      if (this.GyE != null) {
        paramInt = i + f.a.a.a.lI(7, this.GyE.computeSize());
      }
      AppMethodBeat.o(91457);
      return paramInt;
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
          AppMethodBeat.o(91457);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91457);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ajc localajc = (ajc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91457);
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
            localajc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91457);
          return 0;
        case 2: 
          localajc.dmy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91457);
          return 0;
        case 3: 
          localajc.phe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91457);
          return 0;
        case 4: 
          localajc.vwq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91457);
          return 0;
        case 5: 
          localajc.tsf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91457);
          return 0;
        case 6: 
          localajc.vCI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91457);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bqo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bqo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localajc.GyE = ((bqo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91457);
        return 0;
      }
      AppMethodBeat.o(91457);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajc
 * JD-Core Version:    0.7.0.1
 */