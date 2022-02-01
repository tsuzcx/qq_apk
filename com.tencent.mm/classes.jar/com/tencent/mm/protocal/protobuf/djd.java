package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class djd
  extends dpc
{
  public String Bri;
  public LinkedList<djb> KGQ;
  public int OpCode;
  public int gsq;
  
  public djd()
  {
    AppMethodBeat.i(127297);
    this.KGQ = new LinkedList();
    AppMethodBeat.o(127297);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127298);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(127298);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Bri != null) {
        paramVarArgs.e(2, this.Bri);
      }
      paramVarArgs.aM(3, this.OpCode);
      paramVarArgs.aM(4, this.gsq);
      paramVarArgs.e(5, 8, this.KGQ);
      AppMethodBeat.o(127298);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Bri != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Bri);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.OpCode);
      int j = g.a.a.b.b.a.bu(4, this.gsq);
      int k = g.a.a.a.c(5, 8, this.KGQ);
      AppMethodBeat.o(127298);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KGQ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(127298);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127298);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        djd localdjd = (djd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127298);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdjd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127298);
          return 0;
        case 2: 
          localdjd.Bri = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127298);
          return 0;
        case 3: 
          localdjd.OpCode = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127298);
          return 0;
        case 4: 
          localdjd.gsq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127298);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new djb();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((djb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdjd.KGQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127298);
        return 0;
      }
      AppMethodBeat.o(127298);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djd
 * JD-Core Version:    0.7.0.1
 */