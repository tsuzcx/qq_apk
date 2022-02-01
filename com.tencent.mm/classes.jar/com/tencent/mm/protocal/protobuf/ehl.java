package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ehl
  extends dpc
{
  public int KHa;
  public int KSO;
  public String KWF;
  public long KWz;
  public String xNU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(224542);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(224542);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.KWz);
      paramVarArgs.aM(3, this.KHa);
      paramVarArgs.aM(4, this.KSO);
      if (this.KWF != null) {
        paramVarArgs.e(5, this.KWF);
      }
      if (this.xNU != null) {
        paramVarArgs.e(6, this.xNU);
      }
      AppMethodBeat.o(224542);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label610;
      }
    }
    label610:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.KWz) + g.a.a.b.b.a.bu(3, this.KHa) + g.a.a.b.b.a.bu(4, this.KSO);
      paramInt = i;
      if (this.KWF != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KWF);
      }
      i = paramInt;
      if (this.xNU != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.xNU);
      }
      AppMethodBeat.o(224542);
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
          AppMethodBeat.o(224542);
          throw paramVarArgs;
        }
        AppMethodBeat.o(224542);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ehl localehl = (ehl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(224542);
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
            localehl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(224542);
          return 0;
        case 2: 
          localehl.KWz = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(224542);
          return 0;
        case 3: 
          localehl.KHa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(224542);
          return 0;
        case 4: 
          localehl.KSO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(224542);
          return 0;
        case 5: 
          localehl.KWF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(224542);
          return 0;
        }
        localehl.xNU = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(224542);
        return 0;
      }
      AppMethodBeat.o(224542);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehl
 * JD-Core Version:    0.7.0.1
 */