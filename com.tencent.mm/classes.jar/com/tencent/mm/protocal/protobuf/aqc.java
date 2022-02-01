package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqc
  extends erp
{
  public String Zxt;
  public double latitude;
  public double longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91450);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Zxt != null) {
        paramVarArgs.g(2, this.Zxt);
      }
      paramVarArgs.d(3, this.latitude);
      paramVarArgs.d(4, this.longitude);
      AppMethodBeat.o(91450);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Zxt != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Zxt);
      }
      paramInt = i.a.a.b.b.a.ko(3);
      int j = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(91450);
      return i + (paramInt + 8) + (j + 8);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91450);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        aqc localaqc = (aqc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91450);
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
            localaqc.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91450);
          return 0;
        case 2: 
          localaqc.Zxt = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91450);
          return 0;
        case 3: 
          localaqc.latitude = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
          AppMethodBeat.o(91450);
          return 0;
        }
        localaqc.longitude = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
        AppMethodBeat.o(91450);
        return 0;
      }
      AppMethodBeat.o(91450);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqc
 * JD-Core Version:    0.7.0.1
 */