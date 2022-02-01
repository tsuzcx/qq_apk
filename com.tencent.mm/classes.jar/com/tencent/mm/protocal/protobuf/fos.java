package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fos
  extends com.tencent.mm.bx.a
{
  public long TDw;
  public long TDx;
  public int UaC;
  public int UaD;
  public float UaE;
  public int Uaj;
  public long UjZ;
  public ahj abOZ;
  public fqf abPa;
  public long endTimeMs;
  public String path;
  public long startTimeMs;
  public int type;
  public float volume;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257992);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.path == null)
      {
        paramVarArgs = new b("Not all required fields were included: path");
        AppMethodBeat.o(257992);
        throw paramVarArgs;
      }
      if (this.path != null) {
        paramVarArgs.g(1, this.path);
      }
      paramVarArgs.bS(2, this.type);
      paramVarArgs.bv(3, this.startTimeMs);
      paramVarArgs.bv(4, this.endTimeMs);
      paramVarArgs.bv(5, this.TDw);
      paramVarArgs.bv(6, this.TDx);
      paramVarArgs.bv(7, this.UjZ);
      paramVarArgs.bS(8, this.UaC);
      paramVarArgs.bS(9, this.UaD);
      paramVarArgs.l(10, this.UaE);
      paramVarArgs.l(11, this.volume);
      if (this.abOZ != null)
      {
        paramVarArgs.qD(12, this.abOZ.computeSize());
        this.abOZ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(13, this.Uaj);
      if (this.abPa != null)
      {
        paramVarArgs.qD(14, this.abPa.computeSize());
        this.abPa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257992);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label1012;
      }
    }
    label1012:
    for (paramInt = i.a.a.b.b.a.h(1, this.path) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.type) + i.a.a.b.b.a.q(3, this.startTimeMs) + i.a.a.b.b.a.q(4, this.endTimeMs) + i.a.a.b.b.a.q(5, this.TDw) + i.a.a.b.b.a.q(6, this.TDx) + i.a.a.b.b.a.q(7, this.UjZ) + i.a.a.b.b.a.cJ(8, this.UaC) + i.a.a.b.b.a.cJ(9, this.UaD) + (i.a.a.b.b.a.ko(10) + 4) + (i.a.a.b.b.a.ko(11) + 4);
      paramInt = i;
      if (this.abOZ != null) {
        paramInt = i + i.a.a.a.qC(12, this.abOZ.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.Uaj);
      paramInt = i;
      if (this.abPa != null) {
        paramInt = i + i.a.a.a.qC(14, this.abPa.computeSize());
      }
      AppMethodBeat.o(257992);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.path == null)
        {
          paramVarArgs = new b("Not all required fields were included: path");
          AppMethodBeat.o(257992);
          throw paramVarArgs;
        }
        AppMethodBeat.o(257992);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fos localfos = (fos)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257992);
          return -1;
        case 1: 
          localfos.path = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257992);
          return 0;
        case 2: 
          localfos.type = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257992);
          return 0;
        case 3: 
          localfos.startTimeMs = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257992);
          return 0;
        case 4: 
          localfos.endTimeMs = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257992);
          return 0;
        case 5: 
          localfos.TDw = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257992);
          return 0;
        case 6: 
          localfos.TDx = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257992);
          return 0;
        case 7: 
          localfos.UjZ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257992);
          return 0;
        case 8: 
          localfos.UaC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257992);
          return 0;
        case 9: 
          localfos.UaD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257992);
          return 0;
        case 10: 
          localfos.UaE = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(257992);
          return 0;
        case 11: 
          localfos.volume = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(257992);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ahj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ahj)localObject2).parseFrom((byte[])localObject1);
            }
            localfos.abOZ = ((ahj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257992);
          return 0;
        case 13: 
          localfos.Uaj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257992);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fqf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fqf)localObject2).parseFrom((byte[])localObject1);
          }
          localfos.abPa = ((fqf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257992);
        return 0;
      }
      AppMethodBeat.o(257992);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fos
 * JD-Core Version:    0.7.0.1
 */