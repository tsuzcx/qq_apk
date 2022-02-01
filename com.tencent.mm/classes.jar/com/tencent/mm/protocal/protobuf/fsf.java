package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fsf
  extends com.tencent.mm.bx.a
{
  public awq YGb;
  public boolean abOV;
  public boolean abOW;
  public float latitude;
  public float longitude;
  public String name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259625);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YGb != null)
      {
        paramVarArgs.qD(1, this.YGb.computeSize());
        this.YGb.writeFields(paramVarArgs);
      }
      if (this.name != null) {
        paramVarArgs.g(2, this.name);
      }
      paramVarArgs.l(3, this.longitude);
      paramVarArgs.l(4, this.latitude);
      paramVarArgs.di(5, this.abOW);
      paramVarArgs.di(6, this.abOV);
      AppMethodBeat.o(259625);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YGb == null) {
        break label526;
      }
    }
    label526:
    for (paramInt = i.a.a.a.qC(1, this.YGb.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.name != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.name);
      }
      paramInt = i.a.a.b.b.a.ko(3);
      int j = i.a.a.b.b.a.ko(4);
      int k = i.a.a.b.b.a.ko(5);
      int m = i.a.a.b.b.a.ko(6);
      AppMethodBeat.o(259625);
      return i + (paramInt + 4) + (j + 4) + (k + 1) + (m + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259625);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fsf localfsf = (fsf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259625);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            awq localawq = new awq();
            if ((localObject != null) && (localObject.length > 0)) {
              localawq.parseFrom((byte[])localObject);
            }
            localfsf.YGb = localawq;
            paramInt += 1;
          }
          AppMethodBeat.o(259625);
          return 0;
        case 2: 
          localfsf.name = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259625);
          return 0;
        case 3: 
          localfsf.longitude = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(259625);
          return 0;
        case 4: 
          localfsf.latitude = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(259625);
          return 0;
        case 5: 
          localfsf.abOW = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(259625);
          return 0;
        }
        localfsf.abOV = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(259625);
        return 0;
      }
      AppMethodBeat.o(259625);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fsf
 * JD-Core Version:    0.7.0.1
 */