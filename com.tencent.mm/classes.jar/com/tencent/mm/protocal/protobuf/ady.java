package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ady
  extends dpc
{
  public String HQv;
  public LinkedList<tx> Lps;
  public int Lpt;
  public int Lpu;
  public int version;
  
  public ady()
  {
    AppMethodBeat.i(32177);
    this.Lps = new LinkedList();
    AppMethodBeat.o(32177);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32178);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32178);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Lps);
      paramVarArgs.aM(3, this.version);
      paramVarArgs.aM(4, this.Lpt);
      paramVarArgs.aM(5, this.Lpu);
      if (this.HQv != null) {
        paramVarArgs.e(6, this.HQv);
      }
      AppMethodBeat.o(32178);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label702;
      }
    }
    label702:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.Lps) + g.a.a.b.b.a.bu(3, this.version) + g.a.a.b.b.a.bu(4, this.Lpt) + g.a.a.b.b.a.bu(5, this.Lpu);
      paramInt = i;
      if (this.HQv != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.HQv);
      }
      AppMethodBeat.o(32178);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Lps.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32178);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32178);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ady localady = (ady)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32178);
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
            localady.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32178);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tx();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localady.Lps.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32178);
          return 0;
        case 3: 
          localady.version = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32178);
          return 0;
        case 4: 
          localady.Lpt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32178);
          return 0;
        case 5: 
          localady.Lpu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32178);
          return 0;
        }
        localady.HQv = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32178);
        return 0;
      }
      AppMethodBeat.o(32178);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ady
 * JD-Core Version:    0.7.0.1
 */