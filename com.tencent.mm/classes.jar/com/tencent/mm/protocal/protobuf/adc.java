package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adc
  extends erp
{
  public int PWK;
  public int ZlD;
  public int ZlE;
  public int ZlF;
  public int ZlG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257810);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ZlD);
      paramVarArgs.bS(3, this.ZlE);
      paramVarArgs.bS(4, this.PWK);
      paramVarArgs.bS(5, this.ZlF);
      paramVarArgs.bS(6, this.ZlG);
      AppMethodBeat.o(257810);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label516;
      }
    }
    label516:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.ZlD);
      int j = i.a.a.b.b.a.cJ(3, this.ZlE);
      int k = i.a.a.b.b.a.cJ(4, this.PWK);
      int m = i.a.a.b.b.a.cJ(5, this.ZlF);
      int n = i.a.a.b.b.a.cJ(6, this.ZlG);
      AppMethodBeat.o(257810);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257810);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        adc localadc = (adc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257810);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localadc.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(257810);
          return 0;
        case 2: 
          localadc.ZlD = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257810);
          return 0;
        case 3: 
          localadc.ZlE = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257810);
          return 0;
        case 4: 
          localadc.PWK = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257810);
          return 0;
        case 5: 
          localadc.ZlF = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257810);
          return 0;
        }
        localadc.ZlG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257810);
        return 0;
      }
      AppMethodBeat.o(257810);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adc
 * JD-Core Version:    0.7.0.1
 */