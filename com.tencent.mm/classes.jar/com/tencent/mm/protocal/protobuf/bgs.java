package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bgs
  extends dpc
{
  public exi LQB;
  public String LQv;
  public String LQw;
  public int rBL;
  public String rBM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91474);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91474);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.LQv != null) {
        paramVarArgs.e(2, this.LQv);
      }
      if (this.LQw != null) {
        paramVarArgs.e(3, this.LQw);
      }
      paramVarArgs.aM(4, this.rBL);
      if (this.rBM != null) {
        paramVarArgs.e(5, this.rBM);
      }
      if (this.LQB != null)
      {
        paramVarArgs.ni(6, this.LQB.computeSize());
        this.LQB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91474);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label738;
      }
    }
    label738:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LQv != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LQv);
      }
      i = paramInt;
      if (this.LQw != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LQw);
      }
      i += g.a.a.b.b.a.bu(4, this.rBL);
      paramInt = i;
      if (this.rBM != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.rBM);
      }
      i = paramInt;
      if (this.LQB != null) {
        i = paramInt + g.a.a.a.nh(6, this.LQB.computeSize());
      }
      AppMethodBeat.o(91474);
      return i;
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
          AppMethodBeat.o(91474);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91474);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bgs localbgs = (bgs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91474);
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
            localbgs.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91474);
          return 0;
        case 2: 
          localbgs.LQv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91474);
          return 0;
        case 3: 
          localbgs.LQw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91474);
          return 0;
        case 4: 
          localbgs.rBL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91474);
          return 0;
        case 5: 
          localbgs.rBM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91474);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new exi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((exi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbgs.LQB = ((exi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91474);
        return 0;
      }
      AppMethodBeat.o(91474);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgs
 * JD-Core Version:    0.7.0.1
 */