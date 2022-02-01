package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fub
  extends erp
{
  public double abSc;
  public double abSd;
  public int abSe;
  public double altitude;
  public double latitude;
  public double longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123668);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.d(2, this.latitude);
      paramVarArgs.d(3, this.longitude);
      paramVarArgs.d(4, this.altitude);
      paramVarArgs.d(5, this.abSc);
      paramVarArgs.d(6, this.abSd);
      paramVarArgs.bS(7, this.abSe);
      AppMethodBeat.o(123668);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label575;
      }
    }
    label575:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.ko(3);
      int k = i.a.a.b.b.a.ko(4);
      int m = i.a.a.b.b.a.ko(5);
      int n = i.a.a.b.b.a.ko(6);
      int i1 = i.a.a.b.b.a.cJ(7, this.abSe);
      AppMethodBeat.o(123668);
      return paramInt + (i + 8) + (j + 8) + (k + 8) + (m + 8) + (n + 8) + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123668);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fub localfub = (fub)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123668);
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
            localfub.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(123668);
          return 0;
        case 2: 
          localfub.latitude = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
          AppMethodBeat.o(123668);
          return 0;
        case 3: 
          localfub.longitude = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
          AppMethodBeat.o(123668);
          return 0;
        case 4: 
          localfub.altitude = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
          AppMethodBeat.o(123668);
          return 0;
        case 5: 
          localfub.abSc = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
          AppMethodBeat.o(123668);
          return 0;
        case 6: 
          localfub.abSd = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
          AppMethodBeat.o(123668);
          return 0;
        }
        localfub.abSe = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(123668);
        return 0;
      }
      AppMethodBeat.o(123668);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fub
 * JD-Core Version:    0.7.0.1
 */