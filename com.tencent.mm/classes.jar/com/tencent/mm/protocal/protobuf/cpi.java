package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cpi
  extends esc
{
  public int ZtW;
  public String aawb;
  public int aawc;
  public int aawd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91496);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91496);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aawb != null) {
        paramVarArgs.g(2, this.aawb);
      }
      paramVarArgs.bS(3, this.aawc);
      paramVarArgs.bS(4, this.ZtW);
      paramVarArgs.bS(5, this.aawd);
      AppMethodBeat.o(91496);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label528;
      }
    }
    label528:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aawb != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.aawb);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.aawc);
      int j = i.a.a.b.b.a.cJ(4, this.ZtW);
      int k = i.a.a.b.b.a.cJ(5, this.aawd);
      AppMethodBeat.o(91496);
      return i + paramInt + j + k;
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
          AppMethodBeat.o(91496);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91496);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cpi localcpi = (cpi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91496);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localcpi.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(91496);
          return 0;
        case 2: 
          localcpi.aawb = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91496);
          return 0;
        case 3: 
          localcpi.aawc = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91496);
          return 0;
        case 4: 
          localcpi.ZtW = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91496);
          return 0;
        }
        localcpi.aawd = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91496);
        return 0;
      }
      AppMethodBeat.o(91496);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpi
 * JD-Core Version:    0.7.0.1
 */