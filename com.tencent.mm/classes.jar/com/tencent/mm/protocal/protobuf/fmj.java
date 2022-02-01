package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fmj
  extends erp
{
  public int aaFP;
  public int aaFQ;
  public gol aaFR;
  public String abMG;
  public gol abio;
  public String sign;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91711);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaFR == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqText");
        AppMethodBeat.o(91711);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aaFP);
      paramVarArgs.bS(3, this.aaFQ);
      if (this.aaFR != null)
      {
        paramVarArgs.qD(4, this.aaFR.computeSize());
        this.aaFR.writeFields(paramVarArgs);
      }
      if (this.abio != null)
      {
        paramVarArgs.qD(5, this.abio.computeSize());
        this.abio.writeFields(paramVarArgs);
      }
      if (this.sign != null) {
        paramVarArgs.g(6, this.sign);
      }
      if (this.abMG != null) {
        paramVarArgs.g(7, this.abMG);
      }
      AppMethodBeat.o(91711);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label808;
      }
    }
    label808:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aaFP) + i.a.a.b.b.a.cJ(3, this.aaFQ);
      paramInt = i;
      if (this.aaFR != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaFR.computeSize());
      }
      i = paramInt;
      if (this.abio != null) {
        i = paramInt + i.a.a.a.qC(5, this.abio.computeSize());
      }
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.sign);
      }
      i = paramInt;
      if (this.abMG != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.abMG);
      }
      AppMethodBeat.o(91711);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.aaFR == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqText");
          AppMethodBeat.o(91711);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91711);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fmj localfmj = (fmj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91711);
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
            localfmj.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91711);
          return 0;
        case 2: 
          localfmj.aaFP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91711);
          return 0;
        case 3: 
          localfmj.aaFQ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91711);
          return 0;
        case 4: 
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
            localfmj.aaFR = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91711);
          return 0;
        case 5: 
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
            localfmj.abio = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91711);
          return 0;
        case 6: 
          localfmj.sign = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91711);
          return 0;
        }
        localfmj.abMG = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91711);
        return 0;
      }
      AppMethodBeat.o(91711);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmj
 * JD-Core Version:    0.7.0.1
 */