package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cxf
  extends erp
{
  public int aaCK;
  public int aaCL;
  public int aaCM;
  public int rXy;
  public int reason;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123598);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.reason);
      paramVarArgs.bS(3, this.rXy);
      paramVarArgs.bS(4, this.aaCK);
      paramVarArgs.bS(5, this.aaCL);
      paramVarArgs.bS(6, this.aaCM);
      AppMethodBeat.o(123598);
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
      int i = i.a.a.b.b.a.cJ(2, this.reason);
      int j = i.a.a.b.b.a.cJ(3, this.rXy);
      int k = i.a.a.b.b.a.cJ(4, this.aaCK);
      int m = i.a.a.b.b.a.cJ(5, this.aaCL);
      int n = i.a.a.b.b.a.cJ(6, this.aaCM);
      AppMethodBeat.o(123598);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123598);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cxf localcxf = (cxf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123598);
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
            localcxf.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(123598);
          return 0;
        case 2: 
          localcxf.reason = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(123598);
          return 0;
        case 3: 
          localcxf.rXy = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(123598);
          return 0;
        case 4: 
          localcxf.aaCK = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(123598);
          return 0;
        case 5: 
          localcxf.aaCL = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(123598);
          return 0;
        }
        localcxf.aaCM = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(123598);
        return 0;
      }
      AppMethodBeat.o(123598);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxf
 * JD-Core Version:    0.7.0.1
 */