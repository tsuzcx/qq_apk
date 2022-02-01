package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class feq
  extends esc
{
  public int abDW;
  public LinkedList<Integer> abDY;
  public int abDZ;
  public int abEa;
  public LinkedList<fgh> abEb;
  
  public feq()
  {
    AppMethodBeat.i(125800);
    this.abDY = new LinkedList();
    this.abEb = new LinkedList();
    AppMethodBeat.o(125800);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125801);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125801);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abDW);
      paramVarArgs.f(3, 2, this.abDY);
      paramVarArgs.bS(4, this.abDZ);
      paramVarArgs.bS(5, this.abEa);
      paramVarArgs.e(6, 8, this.abEb);
      AppMethodBeat.o(125801);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label665;
      }
    }
    label665:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.abDW);
      int j = i.a.a.a.d(3, 2, this.abDY);
      int k = i.a.a.b.b.a.cJ(4, this.abDZ);
      int m = i.a.a.b.b.a.cJ(5, this.abEa);
      int n = i.a.a.a.c(6, 8, this.abEb);
      AppMethodBeat.o(125801);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abDY.clear();
        this.abEb.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125801);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125801);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        feq localfeq = (feq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125801);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localfeq.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125801);
          return 0;
        case 2: 
          localfeq.abDW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125801);
          return 0;
        case 3: 
          localfeq.abDY = new i.a.a.a.a(((i.a.a.a.a)localObject1).ajGk.kFX().Op, unknownTagHandler).ajGk.kFV();
          AppMethodBeat.o(125801);
          return 0;
        case 4: 
          localfeq.abDZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125801);
          return 0;
        case 5: 
          localfeq.abEa = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125801);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fgh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fgh)localObject2).parseFrom((byte[])localObject1);
          }
          localfeq.abEb.add(localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.feq
 * JD-Core Version:    0.7.0.1
 */