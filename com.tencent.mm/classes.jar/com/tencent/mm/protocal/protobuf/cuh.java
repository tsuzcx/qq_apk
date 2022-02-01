package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cuh
  extends erp
{
  public int NkN;
  public int NkO;
  public int YJZ;
  public int aazF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74659);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aazF);
      paramVarArgs.bS(3, this.NkN);
      paramVarArgs.bS(4, this.NkO);
      paramVarArgs.bS(5, this.YJZ);
      AppMethodBeat.o(74659);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label468;
      }
    }
    label468:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.aazF);
      int j = i.a.a.b.b.a.cJ(3, this.NkN);
      int k = i.a.a.b.b.a.cJ(4, this.NkO);
      int m = i.a.a.b.b.a.cJ(5, this.YJZ);
      AppMethodBeat.o(74659);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(74659);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cuh localcuh = (cuh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74659);
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
            localcuh.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(74659);
          return 0;
        case 2: 
          localcuh.aazF = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(74659);
          return 0;
        case 3: 
          localcuh.NkN = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(74659);
          return 0;
        case 4: 
          localcuh.NkO = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(74659);
          return 0;
        }
        localcuh.YJZ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(74659);
        return 0;
      }
      AppMethodBeat.o(74659);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuh
 * JD-Core Version:    0.7.0.1
 */