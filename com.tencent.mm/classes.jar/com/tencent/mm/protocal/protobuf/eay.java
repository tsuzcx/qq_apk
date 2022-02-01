package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eay
  extends dpc
{
  public int DJa;
  public String Nas;
  public int OpCode;
  public LinkedList<eaw> oTA;
  public int oTz;
  
  public eay()
  {
    AppMethodBeat.i(125819);
    this.oTA = new LinkedList();
    AppMethodBeat.o(125819);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125820);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125820);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.OpCode);
      if (this.Nas != null) {
        paramVarArgs.e(3, this.Nas);
      }
      paramVarArgs.aM(4, this.oTz);
      paramVarArgs.e(5, 8, this.oTA);
      paramVarArgs.aM(6, this.DJa);
      AppMethodBeat.o(125820);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label698;
      }
    }
    label698:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.OpCode);
      paramInt = i;
      if (this.Nas != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.Nas);
      }
      i = g.a.a.b.b.a.bu(4, this.oTz);
      int j = g.a.a.a.c(5, 8, this.oTA);
      int k = g.a.a.b.b.a.bu(6, this.DJa);
      AppMethodBeat.o(125820);
      return paramInt + i + j + k;
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
          AppMethodBeat.o(125820);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125820);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eay localeay = (eay)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125820);
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
            localeay.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125820);
          return 0;
        case 2: 
          localeay.OpCode = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125820);
          return 0;
        case 3: 
          localeay.Nas = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125820);
          return 0;
        case 4: 
          localeay.oTz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125820);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eaw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eaw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeay.oTA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125820);
          return 0;
        }
        localeay.DJa = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125820);
        return 0;
      }
      AppMethodBeat.o(125820);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eay
 * JD-Core Version:    0.7.0.1
 */