package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class djm
  extends dpc
{
  public int MNG;
  public int MNH;
  public String MNI;
  public djj MNs;
  public String rJH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32404);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MNs == null)
      {
        paramVarArgs = new b("Not all required fields were included: rcptinfolist");
        AppMethodBeat.o(32404);
        throw paramVarArgs;
      }
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32404);
        throw paramVarArgs;
      }
      if (this.MNs != null)
      {
        paramVarArgs.ni(1, this.MNs.computeSize());
        this.MNs.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.MNG);
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(3, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.rJH != null) {
        paramVarArgs.e(4, this.rJH);
      }
      paramVarArgs.aM(5, this.MNH);
      if (this.MNI != null) {
        paramVarArgs.e(6, this.MNI);
      }
      AppMethodBeat.o(32404);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MNs == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = g.a.a.a.nh(1, this.MNs.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MNG);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + g.a.a.a.nh(3, this.BaseResponse.computeSize());
      }
      i = paramInt;
      if (this.rJH != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.rJH);
      }
      i += g.a.a.b.b.a.bu(5, this.MNH);
      paramInt = i;
      if (this.MNI != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MNI);
      }
      AppMethodBeat.o(32404);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MNs == null)
        {
          paramVarArgs = new b("Not all required fields were included: rcptinfolist");
          AppMethodBeat.o(32404);
          throw paramVarArgs;
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32404);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32404);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        djm localdjm = (djm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32404);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new djj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((djj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdjm.MNs = ((djj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32404);
          return 0;
        case 2: 
          localdjm.MNG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32404);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdjm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32404);
          return 0;
        case 4: 
          localdjm.rJH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32404);
          return 0;
        case 5: 
          localdjm.MNH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32404);
          return 0;
        }
        localdjm.MNI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32404);
        return 0;
      }
      AppMethodBeat.o(32404);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djm
 * JD-Core Version:    0.7.0.1
 */