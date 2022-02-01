package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eai
  extends dpc
{
  public int MZB;
  public LinkedList<Integer> MZD;
  public int MZE;
  public int MZF;
  public LinkedList<ebo> MZG;
  
  public eai()
  {
    AppMethodBeat.i(125800);
    this.MZD = new LinkedList();
    this.MZG = new LinkedList();
    AppMethodBeat.o(125800);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125801);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125801);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.MZB);
      paramVarArgs.f(3, 2, this.MZD);
      paramVarArgs.aM(4, this.MZE);
      paramVarArgs.aM(5, this.MZF);
      paramVarArgs.e(6, 8, this.MZG);
      AppMethodBeat.o(125801);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label713;
      }
    }
    label713:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.MZB);
      int j = g.a.a.a.d(3, 2, this.MZD);
      int k = g.a.a.b.b.a.bu(4, this.MZE);
      int m = g.a.a.b.b.a.bu(5, this.MZF);
      int n = g.a.a.a.c(6, 8, this.MZG);
      AppMethodBeat.o(125801);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MZD.clear();
        this.MZG.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125801);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125801);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eai localeai = (eai)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125801);
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
            localeai.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125801);
          return 0;
        case 2: 
          localeai.MZB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125801);
          return 0;
        case 3: 
          localeai.MZD = new g.a.a.a.a(((g.a.a.a.a)localObject1).UbS.hPo().zy, unknownTagHandler).UbS.hPm();
          AppMethodBeat.o(125801);
          return 0;
        case 4: 
          localeai.MZE = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125801);
          return 0;
        case 5: 
          localeai.MZF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125801);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ebo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ebo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeai.MZG.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125801);
        return 0;
      }
      AppMethodBeat.o(125801);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eai
 * JD-Core Version:    0.7.0.1
 */