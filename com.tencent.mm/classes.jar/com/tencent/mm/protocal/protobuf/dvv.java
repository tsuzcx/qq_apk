package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dvv
  extends dpc
{
  public int KKl;
  public int MWF;
  public String hik;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32435);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32435);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.hik != null) {
        paramVarArgs.e(2, this.hik);
      }
      paramVarArgs.aM(3, this.KKl);
      paramVarArgs.aM(4, this.MWF);
      AppMethodBeat.o(32435);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label520;
      }
    }
    label520:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hik != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.hik);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.KKl);
      int j = g.a.a.b.b.a.bu(4, this.MWF);
      AppMethodBeat.o(32435);
      return i + paramInt + j;
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
          AppMethodBeat.o(32435);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32435);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dvv localdvv = (dvv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32435);
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
            localdvv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32435);
          return 0;
        case 2: 
          localdvv.hik = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32435);
          return 0;
        case 3: 
          localdvv.KKl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32435);
          return 0;
        }
        localdvv.MWF = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32435);
        return 0;
      }
      AppMethodBeat.o(32435);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvv
 * JD-Core Version:    0.7.0.1
 */