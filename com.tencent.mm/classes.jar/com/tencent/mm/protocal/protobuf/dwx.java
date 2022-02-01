package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dwx
  extends dpc
{
  public String AZI;
  public LinkedList<dwv> MWT;
  public int MWU;
  public int Ret;
  public int oTz;
  
  public dwx()
  {
    AppMethodBeat.i(32442);
    this.MWT = new LinkedList();
    AppMethodBeat.o(32442);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32443);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32443);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.oTz);
      paramVarArgs.e(3, 8, this.MWT);
      if (this.AZI != null) {
        paramVarArgs.e(4, this.AZI);
      }
      paramVarArgs.aM(5, this.MWU);
      paramVarArgs.aM(6, this.Ret);
      AppMethodBeat.o(32443);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label706;
      }
    }
    label706:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.oTz) + g.a.a.a.c(3, 8, this.MWT);
      paramInt = i;
      if (this.AZI != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.AZI);
      }
      i = g.a.a.b.b.a.bu(5, this.MWU);
      int j = g.a.a.b.b.a.bu(6, this.Ret);
      AppMethodBeat.o(32443);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MWT.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32443);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32443);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dwx localdwx = (dwx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32443);
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
            localdwx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32443);
          return 0;
        case 2: 
          localdwx.oTz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32443);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdwx.MWT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32443);
          return 0;
        case 4: 
          localdwx.AZI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32443);
          return 0;
        case 5: 
          localdwx.MWU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32443);
          return 0;
        }
        localdwx.Ret = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32443);
        return 0;
      }
      AppMethodBeat.o(32443);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwx
 * JD-Core Version:    0.7.0.1
 */