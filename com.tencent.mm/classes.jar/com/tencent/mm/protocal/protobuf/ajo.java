package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ajo
  extends dpc
{
  public LinkedList<egs> KGQ;
  public int KMC;
  public LinkedList<egr> KMD;
  public int LsZ;
  public long Lta;
  public int Ltb;
  public int Ltc;
  public int Ltd;
  
  public ajo()
  {
    AppMethodBeat.i(32191);
    this.KGQ = new LinkedList();
    this.KMD = new LinkedList();
    AppMethodBeat.o(32191);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32192);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32192);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LsZ);
      paramVarArgs.bb(3, this.Lta);
      paramVarArgs.aM(4, this.Ltb);
      paramVarArgs.aM(5, this.Ltc);
      paramVarArgs.e(6, 8, this.KGQ);
      paramVarArgs.aM(7, this.Ltd);
      paramVarArgs.aM(8, this.KMC);
      paramVarArgs.e(9, 8, this.KMD);
      AppMethodBeat.o(32192);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label941;
      }
    }
    label941:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.LsZ);
      int j = g.a.a.b.b.a.r(3, this.Lta);
      int k = g.a.a.b.b.a.bu(4, this.Ltb);
      int m = g.a.a.b.b.a.bu(5, this.Ltc);
      int n = g.a.a.a.c(6, 8, this.KGQ);
      int i1 = g.a.a.b.b.a.bu(7, this.Ltd);
      int i2 = g.a.a.b.b.a.bu(8, this.KMC);
      int i3 = g.a.a.a.c(9, 8, this.KMD);
      AppMethodBeat.o(32192);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KGQ.clear();
        this.KMD.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32192);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32192);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ajo localajo = (ajo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32192);
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
            localajo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32192);
          return 0;
        case 2: 
          localajo.LsZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32192);
          return 0;
        case 3: 
          localajo.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(32192);
          return 0;
        case 4: 
          localajo.Ltb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32192);
          return 0;
        case 5: 
          localajo.Ltc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32192);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new egs();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((egs)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localajo.KGQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32192);
          return 0;
        case 7: 
          localajo.Ltd = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32192);
          return 0;
        case 8: 
          localajo.KMC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32192);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new egr();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((egr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localajo.KMD.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32192);
        return 0;
      }
      AppMethodBeat.o(32192);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajo
 * JD-Core Version:    0.7.0.1
 */