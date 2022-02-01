package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class drl
  extends cwj
{
  public abp Gpl;
  public int oGt;
  public String oGu;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91721);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91721);
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
      paramVarArgs.aZ(4, this.timestamp);
      if (this.Gpl != null)
      {
        paramVarArgs.lJ(5, this.Gpl.computeSize());
        this.Gpl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91721);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label662;
      }
    }
    label662:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt + f.a.a.b.b.a.p(4, this.timestamp);
      paramInt = i;
      if (this.Gpl != null) {
        paramInt = i + f.a.a.a.lI(5, this.Gpl.computeSize());
      }
      AppMethodBeat.o(91721);
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
          AppMethodBeat.o(91721);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91721);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        drl localdrl = (drl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91721);
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
            localdrl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91721);
          return 0;
        case 2: 
          localdrl.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91721);
          return 0;
        case 3: 
          localdrl.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91721);
          return 0;
        case 4: 
          localdrl.timestamp = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91721);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdrl.Gpl = ((abp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91721);
        return 0;
      }
      AppMethodBeat.o(91721);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drl
 * JD-Core Version:    0.7.0.1
 */