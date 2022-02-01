package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bld
  extends dpc
{
  public int LUb;
  public int LUc;
  public int LUd;
  public int LUe;
  public String LUf;
  public int LUg;
  public int oTW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101813);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101813);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.oTW);
      paramVarArgs.aM(3, this.LUb);
      paramVarArgs.aM(4, this.LUc);
      paramVarArgs.aM(5, this.LUd);
      paramVarArgs.aM(6, this.LUe);
      if (this.LUf != null) {
        paramVarArgs.e(7, this.LUf);
      }
      paramVarArgs.aM(8, this.LUg);
      AppMethodBeat.o(101813);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label682;
      }
    }
    label682:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.oTW) + g.a.a.b.b.a.bu(3, this.LUb) + g.a.a.b.b.a.bu(4, this.LUc) + g.a.a.b.b.a.bu(5, this.LUd) + g.a.a.b.b.a.bu(6, this.LUe);
      paramInt = i;
      if (this.LUf != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LUf);
      }
      i = g.a.a.b.b.a.bu(8, this.LUg);
      AppMethodBeat.o(101813);
      return paramInt + i;
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
          AppMethodBeat.o(101813);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101813);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bld localbld = (bld)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101813);
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
            localbld.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101813);
          return 0;
        case 2: 
          localbld.oTW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101813);
          return 0;
        case 3: 
          localbld.LUb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101813);
          return 0;
        case 4: 
          localbld.LUc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101813);
          return 0;
        case 5: 
          localbld.LUd = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101813);
          return 0;
        case 6: 
          localbld.LUe = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101813);
          return 0;
        case 7: 
          localbld.LUf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101813);
          return 0;
        }
        localbld.LUg = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(101813);
        return 0;
      }
      AppMethodBeat.o(101813);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bld
 * JD-Core Version:    0.7.0.1
 */