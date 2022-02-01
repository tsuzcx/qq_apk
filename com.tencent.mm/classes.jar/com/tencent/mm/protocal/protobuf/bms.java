package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bms
  extends dpc
{
  public int LVs;
  public String LVt;
  public int LVu;
  public LinkedList<ajf> oTA;
  public int oTz;
  
  public bms()
  {
    AppMethodBeat.i(104792);
    this.oTA = new LinkedList();
    AppMethodBeat.o(104792);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104793);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104793);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.oTz);
      paramVarArgs.e(3, 8, this.oTA);
      paramVarArgs.aM(4, this.LVs);
      if (this.LVt != null) {
        paramVarArgs.e(5, this.LVt);
      }
      paramVarArgs.aM(6, this.LVu);
      AppMethodBeat.o(104793);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.oTz) + g.a.a.a.c(3, 8, this.oTA) + g.a.a.b.b.a.bu(4, this.LVs);
      paramInt = i;
      if (this.LVt != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LVt);
      }
      i = g.a.a.b.b.a.bu(6, this.LVu);
      AppMethodBeat.o(104793);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.oTA.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104793);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104793);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bms localbms = (bms)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104793);
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
            localbms.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104793);
          return 0;
        case 2: 
          localbms.oTz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(104793);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ajf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ajf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbms.oTA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104793);
          return 0;
        case 4: 
          localbms.LVs = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(104793);
          return 0;
        case 5: 
          localbms.LVt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104793);
          return 0;
        }
        localbms.LVu = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(104793);
        return 0;
      }
      AppMethodBeat.o(104793);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bms
 * JD-Core Version:    0.7.0.1
 */