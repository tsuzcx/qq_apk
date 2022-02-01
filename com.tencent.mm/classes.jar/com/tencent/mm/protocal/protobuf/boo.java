package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class boo
  extends com.tencent.mm.bx.a
{
  public String Mcq;
  public boolean Mct;
  public String ZTA;
  public String ZWQ;
  public String ZWR;
  public String ZWS;
  public String ZWT;
  public long ZWU;
  public String ZWV;
  public bop ZWW;
  public String albumName;
  public int duration;
  public String extraInfo;
  public String identification;
  public String mLQ;
  public String musicDataUrl;
  public String oOZ;
  public String rDl;
  public String songName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258413);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.songName != null) {
        paramVarArgs.g(1, this.songName);
      }
      if (this.rDl != null) {
        paramVarArgs.g(2, this.rDl);
      }
      if (this.musicDataUrl != null) {
        paramVarArgs.g(3, this.musicDataUrl);
      }
      if (this.ZWQ != null) {
        paramVarArgs.g(4, this.ZWQ);
      }
      if (this.ZWR != null) {
        paramVarArgs.g(5, this.ZWR);
      }
      if (this.mLQ != null) {
        paramVarArgs.g(6, this.mLQ);
      }
      if (this.Mcq != null) {
        paramVarArgs.g(7, this.Mcq);
      }
      if (this.albumName != null) {
        paramVarArgs.g(8, this.albumName);
      }
      if (this.ZWS != null) {
        paramVarArgs.g(9, this.ZWS);
      }
      if (this.ZTA != null) {
        paramVarArgs.g(10, this.ZTA);
      }
      if (this.ZWT != null) {
        paramVarArgs.g(11, this.ZWT);
      }
      paramVarArgs.bv(12, this.ZWU);
      if (this.extraInfo != null) {
        paramVarArgs.g(13, this.extraInfo);
      }
      if (this.identification != null) {
        paramVarArgs.g(14, this.identification);
      }
      paramVarArgs.bS(15, this.duration);
      paramVarArgs.di(16, this.Mct);
      if (this.ZWV != null) {
        paramVarArgs.g(17, this.ZWV);
      }
      if (this.ZWW != null)
      {
        paramVarArgs.qD(18, this.ZWW.computeSize());
        this.ZWW.writeFields(paramVarArgs);
      }
      if (this.oOZ != null) {
        paramVarArgs.g(19, this.oOZ);
      }
      AppMethodBeat.o(258413);
      return 0;
    }
    if (paramInt == 1) {
      if (this.songName == null) {
        break label1340;
      }
    }
    label1340:
    for (int i = i.a.a.b.b.a.h(1, this.songName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rDl != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.rDl);
      }
      i = paramInt;
      if (this.musicDataUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.musicDataUrl);
      }
      paramInt = i;
      if (this.ZWQ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZWQ);
      }
      i = paramInt;
      if (this.ZWR != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZWR);
      }
      paramInt = i;
      if (this.mLQ != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.mLQ);
      }
      i = paramInt;
      if (this.Mcq != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.Mcq);
      }
      paramInt = i;
      if (this.albumName != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.albumName);
      }
      i = paramInt;
      if (this.ZWS != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.ZWS);
      }
      paramInt = i;
      if (this.ZTA != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.ZTA);
      }
      i = paramInt;
      if (this.ZWT != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.ZWT);
      }
      i += i.a.a.b.b.a.q(12, this.ZWU);
      paramInt = i;
      if (this.extraInfo != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.extraInfo);
      }
      i = paramInt;
      if (this.identification != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.identification);
      }
      i = i + i.a.a.b.b.a.cJ(15, this.duration) + (i.a.a.b.b.a.ko(16) + 1);
      paramInt = i;
      if (this.ZWV != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.ZWV);
      }
      i = paramInt;
      if (this.ZWW != null) {
        i = paramInt + i.a.a.a.qC(18, this.ZWW.computeSize());
      }
      paramInt = i;
      if (this.oOZ != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.oOZ);
      }
      AppMethodBeat.o(258413);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258413);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        boo localboo = (boo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258413);
          return -1;
        case 1: 
          localboo.songName = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258413);
          return 0;
        case 2: 
          localboo.rDl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258413);
          return 0;
        case 3: 
          localboo.musicDataUrl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258413);
          return 0;
        case 4: 
          localboo.ZWQ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258413);
          return 0;
        case 5: 
          localboo.ZWR = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258413);
          return 0;
        case 6: 
          localboo.mLQ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258413);
          return 0;
        case 7: 
          localboo.Mcq = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258413);
          return 0;
        case 8: 
          localboo.albumName = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258413);
          return 0;
        case 9: 
          localboo.ZWS = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258413);
          return 0;
        case 10: 
          localboo.ZTA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258413);
          return 0;
        case 11: 
          localboo.ZWT = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258413);
          return 0;
        case 12: 
          localboo.ZWU = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(258413);
          return 0;
        case 13: 
          localboo.extraInfo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258413);
          return 0;
        case 14: 
          localboo.identification = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258413);
          return 0;
        case 15: 
          localboo.duration = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258413);
          return 0;
        case 16: 
          localboo.Mct = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(258413);
          return 0;
        case 17: 
          localboo.ZWV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258413);
          return 0;
        case 18: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bop localbop = new bop();
            if ((localObject != null) && (localObject.length > 0)) {
              localbop.parseFrom((byte[])localObject);
            }
            localboo.ZWW = localbop;
            paramInt += 1;
          }
          AppMethodBeat.o(258413);
          return 0;
        }
        localboo.oOZ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258413);
        return 0;
      }
      AppMethodBeat.o(258413);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boo
 * JD-Core Version:    0.7.0.1
 */