package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class czn
  extends dpc
{
  public exi LQB;
  public String LQv;
  public String LQw;
  public String MER;
  public int rBL;
  public String rBM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91572);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91572);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.LQw != null) {
        paramVarArgs.e(2, this.LQw);
      }
      paramVarArgs.aM(3, this.rBL);
      if (this.rBM != null) {
        paramVarArgs.e(4, this.rBM);
      }
      if (this.LQv != null) {
        paramVarArgs.e(5, this.LQv);
      }
      if (this.MER != null) {
        paramVarArgs.e(6, this.MER);
      }
      if (this.LQB != null)
      {
        paramVarArgs.ni(7, this.LQB.computeSize());
        this.LQB.writeFields(paramVarArgs);
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
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LQw != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.LQw);
      }
      i += g.a.a.b.b.a.bu(3, this.rBL);
      paramInt = i;
      if (this.rBM != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.rBM);
      }
      i = paramInt;
      if (this.LQv != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LQv);
      }
      paramInt = i;
      if (this.MER != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MER);
      }
      i = paramInt;
      if (this.LQB != null) {
        i = paramInt + g.a.a.a.nh(7, this.LQB.computeSize());
      }
      AppMethodBeat.o(91572);
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
          AppMethodBeat.o(91572);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91572);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        czn localczn = (czn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91572);
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
            localczn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91572);
          return 0;
        case 2: 
          localczn.LQw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91572);
          return 0;
        case 3: 
          localczn.rBL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91572);
          return 0;
        case 4: 
          localczn.rBM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91572);
          return 0;
        case 5: 
          localczn.LQv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91572);
          return 0;
        case 6: 
          localczn.MER = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91572);
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
          localczn.LQB = ((exi)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czn
 * JD-Core Version:    0.7.0.1
 */