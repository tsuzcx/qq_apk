package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wm
  extends erp
{
  public String iaI;
  public float latitude;
  public float longitude;
  public String wsy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113970);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wsy != null) {
        paramVarArgs.g(2, this.wsy);
      }
      paramVarArgs.l(3, this.longitude);
      paramVarArgs.l(4, this.latitude);
      if (this.iaI != null) {
        paramVarArgs.g(5, this.iaI);
      }
      AppMethodBeat.o(113970);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label494;
      }
    }
    label494:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wsy != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.wsy);
      }
      i = i + (i.a.a.b.b.a.ko(3) + 4) + (i.a.a.b.b.a.ko(4) + 4);
      paramInt = i;
      if (this.iaI != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.iaI);
      }
      AppMethodBeat.o(113970);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(113970);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        wm localwm = (wm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113970);
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
            localwm.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(113970);
          return 0;
        case 2: 
          localwm.wsy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113970);
          return 0;
        case 3: 
          localwm.longitude = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(113970);
          return 0;
        case 4: 
          localwm.latitude = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(113970);
          return 0;
        }
        localwm.iaI = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(113970);
        return 0;
      }
      AppMethodBeat.o(113970);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wm
 * JD-Core Version:    0.7.0.1
 */