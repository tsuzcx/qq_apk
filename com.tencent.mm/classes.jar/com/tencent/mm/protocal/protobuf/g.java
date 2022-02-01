package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class g
  extends dpc
{
  public ab KBD;
  public a KBE;
  public String KBs;
  public String KBu;
  public int dDN = 268513600;
  public String qwn = "请求不成功，请稍候再试";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91317);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91317);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.dDN);
      if (this.qwn != null) {
        paramVarArgs.e(3, this.qwn);
      }
      if (this.KBs != null) {
        paramVarArgs.e(4, this.KBs);
      }
      if (this.KBu != null) {
        paramVarArgs.e(5, this.KBu);
      }
      if (this.KBD != null)
      {
        paramVarArgs.ni(6, this.KBD.computeSize());
        this.KBD.writeFields(paramVarArgs);
      }
      if (this.KBE != null)
      {
        paramVarArgs.ni(7, this.KBE.computeSize());
        this.KBE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91317);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt;
      if (this.KBs != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.KBs);
      }
      paramInt = i;
      if (this.KBu != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KBu);
      }
      i = paramInt;
      if (this.KBD != null) {
        i = paramInt + g.a.a.a.nh(6, this.KBD.computeSize());
      }
      paramInt = i;
      if (this.KBE != null) {
        paramInt = i + g.a.a.a.nh(7, this.KBE.computeSize());
      }
      AppMethodBeat.o(91317);
      return paramInt;
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
          AppMethodBeat.o(91317);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91317);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91317);
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
            localg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91317);
          return 0;
        case 2: 
          localg.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91317);
          return 0;
        case 3: 
          localg.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91317);
          return 0;
        case 4: 
          localg.KBs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91317);
          return 0;
        case 5: 
          localg.KBu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91317);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ab();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ab)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localg.KBD = ((ab)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91317);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localg.KBE = ((a)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91317);
        return 0;
      }
      AppMethodBeat.o(91317);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.g
 * JD-Core Version:    0.7.0.1
 */