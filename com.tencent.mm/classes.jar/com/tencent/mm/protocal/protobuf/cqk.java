package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cqk
  extends esc
{
  public gol aauw;
  public String aawU;
  public String aawV;
  public String aawW;
  public int bcb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152593);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152593);
        throw paramVarArgs;
      }
      if (this.aauw == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCode");
        AppMethodBeat.o(152593);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aauw != null)
      {
        paramVarArgs.qD(2, this.aauw.computeSize());
        this.aauw.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.bcb);
      if (this.aawU != null) {
        paramVarArgs.g(6, this.aawU);
      }
      if (this.aawV != null) {
        paramVarArgs.g(7, this.aawV);
      }
      if (this.aawW != null) {
        paramVarArgs.g(8, this.aawW);
      }
      AppMethodBeat.o(152593);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label750;
      }
    }
    label750:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aauw != null) {
        i = paramInt + i.a.a.a.qC(2, this.aauw.computeSize());
      }
      i += i.a.a.b.b.a.cJ(5, this.bcb);
      paramInt = i;
      if (this.aawU != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aawU);
      }
      i = paramInt;
      if (this.aawV != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aawV);
      }
      paramInt = i;
      if (this.aawW != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aawW);
      }
      AppMethodBeat.o(152593);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152593);
          throw paramVarArgs;
        }
        if (this.aauw == null)
        {
          paramVarArgs = new b("Not all required fields were included: QRCode");
          AppMethodBeat.o(152593);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152593);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cqk localcqk = (cqk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 3: 
        case 4: 
        default: 
          AppMethodBeat.o(152593);
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
            localcqk.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152593);
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
            localcqk.aauw = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152593);
          return 0;
        case 5: 
          localcqk.bcb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152593);
          return 0;
        case 6: 
          localcqk.aawU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152593);
          return 0;
        case 7: 
          localcqk.aawV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152593);
          return 0;
        }
        localcqk.aawW = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(152593);
        return 0;
      }
      AppMethodBeat.o(152593);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqk
 * JD-Core Version:    0.7.0.1
 */