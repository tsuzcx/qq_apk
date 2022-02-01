package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dz
  extends com.tencent.mm.bx.a
{
  public awq YGb;
  public String YGc;
  public String YGd;
  public boolean YGe;
  public boolean YGf;
  public float latitude;
  public float longitude;
  public String name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258807);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YGb != null)
      {
        paramVarArgs.qD(1, this.YGb.computeSize());
        this.YGb.writeFields(paramVarArgs);
      }
      if (this.YGc != null) {
        paramVarArgs.g(2, this.YGc);
      }
      if (this.YGd != null) {
        paramVarArgs.g(3, this.YGd);
      }
      paramVarArgs.l(4, this.longitude);
      paramVarArgs.l(5, this.latitude);
      paramVarArgs.di(6, this.YGe);
      if (this.name != null) {
        paramVarArgs.g(7, this.name);
      }
      paramVarArgs.di(8, this.YGf);
      AppMethodBeat.o(258807);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YGb == null) {
        break label642;
      }
    }
    label642:
    for (int i = i.a.a.a.qC(1, this.YGb.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YGc != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YGc);
      }
      i = paramInt;
      if (this.YGd != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YGd);
      }
      i = i + (i.a.a.b.b.a.ko(4) + 4) + (i.a.a.b.b.a.ko(5) + 4) + (i.a.a.b.b.a.ko(6) + 1);
      paramInt = i;
      if (this.name != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.name);
      }
      i = i.a.a.b.b.a.ko(8);
      AppMethodBeat.o(258807);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258807);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dz localdz = (dz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258807);
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
            localdz.YGb = localawq;
            paramInt += 1;
          }
          AppMethodBeat.o(258807);
          return 0;
        case 2: 
          localdz.YGc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258807);
          return 0;
        case 3: 
          localdz.YGd = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258807);
          return 0;
        case 4: 
          localdz.longitude = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(258807);
          return 0;
        case 5: 
          localdz.latitude = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(258807);
          return 0;
        case 6: 
          localdz.YGe = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(258807);
          return 0;
        case 7: 
          localdz.name = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258807);
          return 0;
        }
        localdz.YGf = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(258807);
        return 0;
      }
      AppMethodBeat.o(258807);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dz
 * JD-Core Version:    0.7.0.1
 */