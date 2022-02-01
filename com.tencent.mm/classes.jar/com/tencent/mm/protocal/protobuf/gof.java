package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gof
  extends erp
{
  public int IJG;
  public gol YGU;
  public int aary;
  public gol akkV;
  public int nUz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104799);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YGU == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqBuf");
        AppMethodBeat.o(104799);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YGU != null)
      {
        paramVarArgs.qD(2, this.YGU.computeSize());
        this.YGU.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.nUz);
      paramVarArgs.bS(4, this.IJG);
      paramVarArgs.bS(5, this.aary);
      if (this.akkV != null)
      {
        paramVarArgs.qD(6, this.akkV.computeSize());
        this.akkV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104799);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label728;
      }
    }
    label728:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YGU != null) {
        i = paramInt + i.a.a.a.qC(2, this.YGU.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(3, this.nUz) + i.a.a.b.b.a.cJ(4, this.IJG) + i.a.a.b.b.a.cJ(5, this.aary);
      paramInt = i;
      if (this.akkV != null) {
        paramInt = i + i.a.a.a.qC(6, this.akkV.computeSize());
      }
      AppMethodBeat.o(104799);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YGU == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqBuf");
          AppMethodBeat.o(104799);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104799);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gof localgof = (gof)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104799);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localgof.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104799);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localgof.YGU = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104799);
          return 0;
        case 3: 
          localgof.nUz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104799);
          return 0;
        case 4: 
          localgof.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104799);
          return 0;
        case 5: 
          localgof.aary = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104799);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localgof.akkV = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(104799);
        return 0;
      }
      AppMethodBeat.o(104799);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gof
 * JD-Core Version:    0.7.0.1
 */