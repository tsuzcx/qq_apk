package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class pa
  extends dpc
{
  public int KND;
  public String KRB;
  public long KRi;
  public boolean KVU;
  public String dNQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212248);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(212248);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.KRB != null) {
        paramVarArgs.e(2, this.KRB);
      }
      if (this.dNQ != null) {
        paramVarArgs.e(3, this.dNQ);
      }
      paramVarArgs.cc(4, this.KVU);
      paramVarArgs.bb(11, this.KRi);
      paramVarArgs.aM(15, this.KND);
      AppMethodBeat.o(212248);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label638;
      }
    }
    label638:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KRB != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KRB);
      }
      i = paramInt;
      if (this.dNQ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.dNQ);
      }
      paramInt = g.a.a.b.b.a.fS(4);
      int j = g.a.a.b.b.a.r(11, this.KRi);
      int k = g.a.a.b.b.a.bu(15, this.KND);
      AppMethodBeat.o(212248);
      return i + (paramInt + 1) + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(212248);
          throw paramVarArgs;
        }
        AppMethodBeat.o(212248);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        pa localpa = (pa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(212248);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localpa.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212248);
          return 0;
        case 2: 
          localpa.KRB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212248);
          return 0;
        case 3: 
          localpa.dNQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212248);
          return 0;
        case 4: 
          localpa.KVU = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(212248);
          return 0;
        case 11: 
          localpa.KRi = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(212248);
          return 0;
        }
        localpa.KND = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(212248);
        return 0;
      }
      AppMethodBeat.o(212248);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pa
 * JD-Core Version:    0.7.0.1
 */