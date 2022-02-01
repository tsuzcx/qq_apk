package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnq
  extends erp
{
  public int Zdz;
  public double latitude;
  public double longitude;
  public int offset;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114032);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.offset);
      paramVarArgs.bS(3, this.Zdz);
      paramVarArgs.d(4, this.latitude);
      paramVarArgs.d(5, this.longitude);
      AppMethodBeat.o(114032);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.offset);
      int j = i.a.a.b.b.a.cJ(3, this.Zdz);
      int k = i.a.a.b.b.a.ko(4);
      int m = i.a.a.b.b.a.ko(5);
      AppMethodBeat.o(114032);
      return paramInt + i + j + (k + 8) + (m + 8);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(114032);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cnq localcnq = (cnq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114032);
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
            localcnq.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(114032);
          return 0;
        case 2: 
          localcnq.offset = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(114032);
          return 0;
        case 3: 
          localcnq.Zdz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(114032);
          return 0;
        case 4: 
          localcnq.latitude = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
          AppMethodBeat.o(114032);
          return 0;
        }
        localcnq.longitude = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
        AppMethodBeat.o(114032);
        return 0;
      }
      AppMethodBeat.o(114032);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnq
 * JD-Core Version:    0.7.0.1
 */