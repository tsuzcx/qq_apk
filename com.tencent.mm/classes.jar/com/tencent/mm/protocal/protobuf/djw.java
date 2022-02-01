package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class djw
  extends com.tencent.mm.bx.a
{
  public String NYS;
  public amh NZv;
  public fxy Zbl;
  public float latitude;
  public float longitude;
  public String poiName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140927);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.NYS == null)
      {
        paramVarArgs = new b("Not all required fields were included: cityName");
        AppMethodBeat.o(140927);
        throw paramVarArgs;
      }
      if (this.poiName == null)
      {
        paramVarArgs = new b("Not all required fields were included: poiName");
        AppMethodBeat.o(140927);
        throw paramVarArgs;
      }
      if (this.Zbl == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(140927);
        throw paramVarArgs;
      }
      if (this.NYS != null) {
        paramVarArgs.g(1, this.NYS);
      }
      if (this.poiName != null) {
        paramVarArgs.g(2, this.poiName);
      }
      if (this.Zbl != null)
      {
        paramVarArgs.qD(4, this.Zbl.computeSize());
        this.Zbl.writeFields(paramVarArgs);
      }
      paramVarArgs.l(5, this.longitude);
      paramVarArgs.l(6, this.latitude);
      if (this.NZv != null)
      {
        paramVarArgs.qD(7, this.NZv.computeSize());
        this.NZv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(140927);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NYS == null) {
        break label776;
      }
    }
    label776:
    for (int i = i.a.a.b.b.a.h(1, this.NYS) + 0;; i = 0)
    {
      paramInt = i;
      if (this.poiName != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.poiName);
      }
      i = paramInt;
      if (this.Zbl != null) {
        i = paramInt + i.a.a.a.qC(4, this.Zbl.computeSize());
      }
      i = i + (i.a.a.b.b.a.ko(5) + 4) + (i.a.a.b.b.a.ko(6) + 4);
      paramInt = i;
      if (this.NZv != null) {
        paramInt = i + i.a.a.a.qC(7, this.NZv.computeSize());
      }
      AppMethodBeat.o(140927);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.NYS == null)
        {
          paramVarArgs = new b("Not all required fields were included: cityName");
          AppMethodBeat.o(140927);
          throw paramVarArgs;
        }
        if (this.poiName == null)
        {
          paramVarArgs = new b("Not all required fields were included: poiName");
          AppMethodBeat.o(140927);
          throw paramVarArgs;
        }
        if (this.Zbl == null)
        {
          paramVarArgs = new b("Not all required fields were included: matrix");
          AppMethodBeat.o(140927);
          throw paramVarArgs;
        }
        AppMethodBeat.o(140927);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        djw localdjw = (djw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(140927);
          return -1;
        case 1: 
          localdjw.NYS = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(140927);
          return 0;
        case 2: 
          localdjw.poiName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(140927);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fxy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fxy)localObject2).parseFrom((byte[])localObject1);
            }
            localdjw.Zbl = ((fxy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(140927);
          return 0;
        case 5: 
          localdjw.longitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(140927);
          return 0;
        case 6: 
          localdjw.latitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(140927);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new amh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((amh)localObject2).parseFrom((byte[])localObject1);
          }
          localdjw.NZv = ((amh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(140927);
        return 0;
      }
      AppMethodBeat.o(140927);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djw
 * JD-Core Version:    0.7.0.1
 */