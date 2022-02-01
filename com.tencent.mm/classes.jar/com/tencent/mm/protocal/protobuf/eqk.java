package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eqk
  extends erp
{
  public int abuj;
  public String iaI;
  public double latitude;
  public double longitude;
  public String wsy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114062);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.d(2, this.longitude);
      paramVarArgs.d(3, this.latitude);
      paramVarArgs.bS(4, this.abuj);
      if (this.wsy != null) {
        paramVarArgs.g(5, this.wsy);
      }
      if (this.iaI != null) {
        paramVarArgs.g(6, this.iaI);
      }
      AppMethodBeat.o(114062);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label538;
      }
    }
    label538:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 8) + (i.a.a.b.b.a.ko(3) + 8) + i.a.a.b.b.a.cJ(4, this.abuj);
      paramInt = i;
      if (this.wsy != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.wsy);
      }
      i = paramInt;
      if (this.iaI != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.iaI);
      }
      AppMethodBeat.o(114062);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(114062);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eqk localeqk = (eqk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114062);
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
            localeqk.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(114062);
          return 0;
        case 2: 
          localeqk.longitude = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
          AppMethodBeat.o(114062);
          return 0;
        case 3: 
          localeqk.latitude = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
          AppMethodBeat.o(114062);
          return 0;
        case 4: 
          localeqk.abuj = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(114062);
          return 0;
        case 5: 
          localeqk.wsy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114062);
          return 0;
        }
        localeqk.iaI = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(114062);
        return 0;
      }
      AppMethodBeat.o(114062);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqk
 * JD-Core Version:    0.7.0.1
 */