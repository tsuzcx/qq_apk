package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class brh
  extends dpc
{
  public int KHa;
  public int LYJ;
  public LinkedList<cva> LYK;
  public String LYL;
  public int LYM;
  
  public brh()
  {
    AppMethodBeat.i(32254);
    this.LYK = new LinkedList();
    AppMethodBeat.o(32254);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32255);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32255);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LYJ);
      paramVarArgs.e(3, 8, this.LYK);
      if (this.LYL != null) {
        paramVarArgs.e(4, this.LYL);
      }
      paramVarArgs.aM(5, this.KHa);
      paramVarArgs.aM(6, this.LYM);
      AppMethodBeat.o(32255);
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
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LYJ) + g.a.a.a.c(3, 8, this.LYK);
      paramInt = i;
      if (this.LYL != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LYL);
      }
      i = g.a.a.b.b.a.bu(5, this.KHa);
      int j = g.a.a.b.b.a.bu(6, this.LYM);
      AppMethodBeat.o(32255);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LYK.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32255);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32255);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        brh localbrh = (brh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32255);
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
            localbrh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32255);
          return 0;
        case 2: 
          localbrh.LYJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32255);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cva();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cva)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbrh.LYK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32255);
          return 0;
        case 4: 
          localbrh.LYL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32255);
          return 0;
        case 5: 
          localbrh.KHa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32255);
          return 0;
        }
        localbrh.LYM = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32255);
        return 0;
      }
      AppMethodBeat.o(32255);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brh
 * JD-Core Version:    0.7.0.1
 */