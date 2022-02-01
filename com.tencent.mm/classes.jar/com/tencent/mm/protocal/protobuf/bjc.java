package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bjc
  extends dpc
{
  public LinkedList<String> HPE;
  public String LSQ;
  public int dDN;
  public String qwn;
  
  public bjc()
  {
    AppMethodBeat.i(91484);
    this.HPE = new LinkedList();
    AppMethodBeat.o(91484);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91485);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91485);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.HPE);
      paramVarArgs.aM(3, this.dDN);
      if (this.qwn != null) {
        paramVarArgs.e(4, this.qwn);
      }
      if (this.LSQ != null) {
        paramVarArgs.e(5, this.LSQ);
      }
      AppMethodBeat.o(91485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label578;
      }
    }
    label578:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 1, this.HPE) + g.a.a.b.b.a.bu(3, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.qwn);
      }
      i = paramInt;
      if (this.LSQ != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LSQ);
      }
      AppMethodBeat.o(91485);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HPE.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91485);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bjc localbjc = (bjc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91485);
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
            localbjc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91485);
          return 0;
        case 2: 
          localbjc.HPE.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(91485);
          return 0;
        case 3: 
          localbjc.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91485);
          return 0;
        case 4: 
          localbjc.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91485);
          return 0;
        }
        localbjc.LSQ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91485);
        return 0;
      }
      AppMethodBeat.o(91485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjc
 * JD-Core Version:    0.7.0.1
 */