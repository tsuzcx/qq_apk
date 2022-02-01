package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class csu
  extends com.tencent.mm.cd.a
{
  public ajc IcZ;
  public String Icv;
  public fbn Sdr;
  public float latitude;
  public float longitude;
  public String poiName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140927);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Icv == null)
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
      if (this.Sdr == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(140927);
        throw paramVarArgs;
      }
      if (this.Icv != null) {
        paramVarArgs.f(1, this.Icv);
      }
      if (this.poiName != null) {
        paramVarArgs.f(2, this.poiName);
      }
      if (this.Sdr != null)
      {
        paramVarArgs.oE(4, this.Sdr.computeSize());
        this.Sdr.writeFields(paramVarArgs);
      }
      paramVarArgs.i(5, this.longitude);
      paramVarArgs.i(6, this.latitude);
      if (this.IcZ != null)
      {
        paramVarArgs.oE(7, this.IcZ.computeSize());
        this.IcZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(140927);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Icv == null) {
        break label780;
      }
    }
    label780:
    for (int i = g.a.a.b.b.a.g(1, this.Icv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.poiName != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.poiName);
      }
      i = paramInt;
      if (this.Sdr != null) {
        i = paramInt + g.a.a.a.oD(4, this.Sdr.computeSize());
      }
      i = i + (g.a.a.b.b.a.gL(5) + 4) + (g.a.a.b.b.a.gL(6) + 4);
      paramInt = i;
      if (this.IcZ != null) {
        paramInt = i + g.a.a.a.oD(7, this.IcZ.computeSize());
      }
      AppMethodBeat.o(140927);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Icv == null)
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
        if (this.Sdr == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        csu localcsu = (csu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(140927);
          return -1;
        case 1: 
          localcsu.Icv = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(140927);
          return 0;
        case 2: 
          localcsu.poiName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(140927);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fbn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fbn)localObject2).parseFrom((byte[])localObject1);
            }
            localcsu.Sdr = ((fbn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(140927);
          return 0;
        case 5: 
          localcsu.longitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(140927);
          return 0;
        case 6: 
          localcsu.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(140927);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ajc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ajc)localObject2).parseFrom((byte[])localObject1);
          }
          localcsu.IcZ = ((ajc)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csu
 * JD-Core Version:    0.7.0.1
 */