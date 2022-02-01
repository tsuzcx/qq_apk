package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class vp
  extends dpc
{
  public String LgD;
  public LinkedList<alf> LgE;
  public int LgF;
  public int dDN;
  public String qwn;
  public String qwo;
  
  public vp()
  {
    AppMethodBeat.i(91401);
    this.LgE = new LinkedList();
    AppMethodBeat.o(91401);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91402);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91402);
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
      if (this.LgD != null) {
        paramVarArgs.e(4, this.LgD);
      }
      if (this.qwo != null) {
        paramVarArgs.e(5, this.qwo);
      }
      paramVarArgs.e(6, 8, this.LgE);
      paramVarArgs.aM(7, this.LgF);
      AppMethodBeat.o(91402);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label774;
      }
    }
    label774:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt;
      if (this.LgD != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.LgD);
      }
      paramInt = i;
      if (this.qwo != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.qwo);
      }
      i = g.a.a.a.c(6, 8, this.LgE);
      int j = g.a.a.b.b.a.bu(7, this.LgF);
      AppMethodBeat.o(91402);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LgE.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91402);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91402);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        vp localvp = (vp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91402);
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
            localvp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91402);
          return 0;
        case 2: 
          localvp.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91402);
          return 0;
        case 3: 
          localvp.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91402);
          return 0;
        case 4: 
          localvp.LgD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91402);
          return 0;
        case 5: 
          localvp.qwo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91402);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localvp.LgE.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91402);
          return 0;
        }
        localvp.LgF = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91402);
        return 0;
      }
      AppMethodBeat.o(91402);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vp
 * JD-Core Version:    0.7.0.1
 */