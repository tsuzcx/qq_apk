package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class eks
  extends esc
{
  public String YIK;
  public LinkedList<fqc> abpD;
  public LinkedList<fqc> abpE;
  public int hAV;
  public String wYI;
  
  public eks()
  {
    AppMethodBeat.i(72572);
    this.abpD = new LinkedList();
    this.abpE = new LinkedList();
    AppMethodBeat.o(72572);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72573);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72573);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hAV);
      if (this.wYI != null) {
        paramVarArgs.g(3, this.wYI);
      }
      paramVarArgs.e(4, 8, this.abpD);
      paramVarArgs.e(5, 8, this.abpE);
      if (this.YIK != null) {
        paramVarArgs.g(6, this.YIK);
      }
      AppMethodBeat.o(72573);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label732;
      }
    }
    label732:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt + i.a.a.a.c(4, 8, this.abpD) + i.a.a.a.c(5, 8, this.abpE);
      paramInt = i;
      if (this.YIK != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YIK);
      }
      AppMethodBeat.o(72573);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abpD.clear();
        this.abpE.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72573);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72573);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eks localeks = (eks)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72573);
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
            localeks.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72573);
          return 0;
        case 2: 
          localeks.hAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72573);
          return 0;
        case 3: 
          localeks.wYI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72573);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fqc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fqc)localObject2).parseFrom((byte[])localObject1);
            }
            localeks.abpD.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72573);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fqc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fqc)localObject2).parseFrom((byte[])localObject1);
            }
            localeks.abpE.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72573);
          return 0;
        }
        localeks.YIK = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(72573);
        return 0;
      }
      AppMethodBeat.o(72573);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eks
 * JD-Core Version:    0.7.0.1
 */