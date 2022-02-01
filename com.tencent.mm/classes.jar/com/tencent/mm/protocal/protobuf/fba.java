package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fba
  extends esc
{
  public gol aawR;
  public gol aawS;
  public gol aawT;
  public int abAY;
  public gol abAZ;
  public gol abBa;
  public gol abBb;
  public gol abBc;
  public gol abBd;
  public int abBe;
  public String abBf;
  public int abuG;
  public int oOu;
  public float oOw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32445);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.abAZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongName");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.abBa == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongSinger");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.aawS == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongAlbum");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.aawT == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongAlbumUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.abBb == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongWifiUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.abBc == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongWapLinkUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.abBd == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongWebUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.aawR == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongLyric");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.oOu);
      paramVarArgs.bS(3, this.abAY);
      paramVarArgs.l(4, this.oOw);
      if (this.abAZ != null)
      {
        paramVarArgs.qD(5, this.abAZ.computeSize());
        this.abAZ.writeFields(paramVarArgs);
      }
      if (this.abBa != null)
      {
        paramVarArgs.qD(6, this.abBa.computeSize());
        this.abBa.writeFields(paramVarArgs);
      }
      if (this.aawS != null)
      {
        paramVarArgs.qD(7, this.aawS.computeSize());
        this.aawS.writeFields(paramVarArgs);
      }
      if (this.aawT != null)
      {
        paramVarArgs.qD(8, this.aawT.computeSize());
        this.aawT.writeFields(paramVarArgs);
      }
      if (this.abBb != null)
      {
        paramVarArgs.qD(9, this.abBb.computeSize());
        this.abBb.writeFields(paramVarArgs);
      }
      if (this.abBc != null)
      {
        paramVarArgs.qD(10, this.abBc.computeSize());
        this.abBc.writeFields(paramVarArgs);
      }
      if (this.abBd != null)
      {
        paramVarArgs.qD(11, this.abBd.computeSize());
        this.abBd.writeFields(paramVarArgs);
      }
      if (this.aawR != null)
      {
        paramVarArgs.qD(12, this.aawR.computeSize());
        this.aawR.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(13, this.abuG);
      paramVarArgs.bS(14, this.abBe);
      if (this.abBf != null) {
        paramVarArgs.g(15, this.abBf);
      }
      AppMethodBeat.o(32445);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2108;
      }
    }
    label2108:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.oOu) + i.a.a.b.b.a.cJ(3, this.abAY) + (i.a.a.b.b.a.ko(4) + 4);
      paramInt = i;
      if (this.abAZ != null) {
        paramInt = i + i.a.a.a.qC(5, this.abAZ.computeSize());
      }
      i = paramInt;
      if (this.abBa != null) {
        i = paramInt + i.a.a.a.qC(6, this.abBa.computeSize());
      }
      paramInt = i;
      if (this.aawS != null) {
        paramInt = i + i.a.a.a.qC(7, this.aawS.computeSize());
      }
      i = paramInt;
      if (this.aawT != null) {
        i = paramInt + i.a.a.a.qC(8, this.aawT.computeSize());
      }
      paramInt = i;
      if (this.abBb != null) {
        paramInt = i + i.a.a.a.qC(9, this.abBb.computeSize());
      }
      i = paramInt;
      if (this.abBc != null) {
        i = paramInt + i.a.a.a.qC(10, this.abBc.computeSize());
      }
      paramInt = i;
      if (this.abBd != null) {
        paramInt = i + i.a.a.a.qC(11, this.abBd.computeSize());
      }
      i = paramInt;
      if (this.aawR != null) {
        i = paramInt + i.a.a.a.qC(12, this.aawR.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(13, this.abuG) + i.a.a.b.b.a.cJ(14, this.abBe);
      paramInt = i;
      if (this.abBf != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.abBf);
      }
      AppMethodBeat.o(32445);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.abAZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongName");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.abBa == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongSinger");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.aawS == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongAlbum");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.aawT == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongAlbumUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.abBb == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongWifiUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.abBc == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongWapLinkUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.abBd == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongWebUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.aawR == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongLyric");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32445);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fba localfba = (fba)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32445);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localfba.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 2: 
          localfba.oOu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32445);
          return 0;
        case 3: 
          localfba.abAY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32445);
          return 0;
        case 4: 
          localfba.oOw = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(32445);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localfba.abAZ = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localfba.abBa = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localfba.aawS = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localfba.aawT = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localfba.abBb = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localfba.abBc = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localfba.abBd = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localfba.aawR = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 13: 
          localfba.abuG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32445);
          return 0;
        case 14: 
          localfba.abBe = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32445);
          return 0;
        }
        localfba.abBf = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(32445);
        return 0;
      }
      AppMethodBeat.o(32445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fba
 * JD-Core Version:    0.7.0.1
 */