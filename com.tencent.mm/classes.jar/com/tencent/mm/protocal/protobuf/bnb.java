package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bnb
  extends dpc
{
  public int KHa;
  public String LVF;
  public int LVG;
  public int LVH;
  public LinkedList<Integer> LVI;
  public LinkedList<akh> LVJ;
  public int LVK;
  
  public bnb()
  {
    AppMethodBeat.i(220704);
    this.LVI = new LinkedList();
    this.LVJ = new LinkedList();
    AppMethodBeat.o(220704);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220705);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(220705);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LVG);
      paramVarArgs.aM(3, this.LVH);
      paramVarArgs.aM(4, this.KHa);
      paramVarArgs.e(5, 2, this.LVI);
      paramVarArgs.e(6, 8, this.LVJ);
      paramVarArgs.aM(7, this.LVK);
      if (this.LVF != null) {
        paramVarArgs.e(8, this.LVF);
      }
      AppMethodBeat.o(220705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label793;
      }
    }
    label793:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LVG) + g.a.a.b.b.a.bu(3, this.LVH) + g.a.a.b.b.a.bu(4, this.KHa) + g.a.a.a.c(5, 2, this.LVI) + g.a.a.a.c(6, 8, this.LVJ) + g.a.a.b.b.a.bu(7, this.LVK);
      paramInt = i;
      if (this.LVF != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.LVF);
      }
      AppMethodBeat.o(220705);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LVI.clear();
        this.LVJ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(220705);
          throw paramVarArgs;
        }
        AppMethodBeat.o(220705);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bnb localbnb = (bnb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(220705);
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
            localbnb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(220705);
          return 0;
        case 2: 
          localbnb.LVG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220705);
          return 0;
        case 3: 
          localbnb.LVH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220705);
          return 0;
        case 4: 
          localbnb.KHa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220705);
          return 0;
        case 5: 
          localbnb.LVI.add(Integer.valueOf(((g.a.a.a.a)localObject1).UbS.zi()));
          AppMethodBeat.o(220705);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbnb.LVJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(220705);
          return 0;
        case 7: 
          localbnb.LVK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220705);
          return 0;
        }
        localbnb.LVF = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(220705);
        return 0;
      }
      AppMethodBeat.o(220705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnb
 * JD-Core Version:    0.7.0.1
 */