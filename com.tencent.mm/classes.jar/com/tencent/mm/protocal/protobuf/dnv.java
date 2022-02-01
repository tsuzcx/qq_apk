package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dnv
  extends com.tencent.mm.bx.a
{
  public String HaI;
  public int aaUX;
  public long aaUY;
  public String aaUZ;
  public bbq aaVa;
  public bpa aaVb;
  public int bitrate;
  public String coverUrl;
  public String decodeKey;
  public int fileSize;
  public String full_thumb_url;
  public String full_thumb_url_token;
  public bbn half_rect;
  public bbo hdr_spec;
  public float height;
  public int hot_flag;
  public String md5sum;
  public int mediaType;
  public String msf;
  public String msh;
  public LinkedList<dnw> spec;
  public String thumbUrl;
  public String url;
  public float width;
  
  public dnv()
  {
    AppMethodBeat.i(258476);
    this.spec = new LinkedList();
    AppMethodBeat.o(258476);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258483);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.g(1, this.url);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.g(2, this.thumbUrl);
      }
      paramVarArgs.bS(3, this.mediaType);
      paramVarArgs.bS(4, this.aaUX);
      paramVarArgs.l(5, this.width);
      paramVarArgs.l(6, this.height);
      if (this.md5sum != null) {
        paramVarArgs.g(7, this.md5sum);
      }
      paramVarArgs.bS(8, this.fileSize);
      paramVarArgs.bS(9, this.bitrate);
      if (this.decodeKey != null) {
        paramVarArgs.g(10, this.decodeKey);
      }
      if (this.coverUrl != null) {
        paramVarArgs.g(11, this.coverUrl);
      }
      paramVarArgs.bv(12, this.aaUY);
      if (this.msf != null) {
        paramVarArgs.g(13, this.msf);
      }
      if (this.msh != null) {
        paramVarArgs.g(14, this.msh);
      }
      if (this.aaUZ != null) {
        paramVarArgs.g(15, this.aaUZ);
      }
      paramVarArgs.e(16, 8, this.spec);
      if (this.aaVa != null)
      {
        paramVarArgs.qD(17, this.aaVa.computeSize());
        this.aaVa.writeFields(paramVarArgs);
      }
      if (this.aaVb != null)
      {
        paramVarArgs.qD(18, this.aaVb.computeSize());
        this.aaVb.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(19, this.hot_flag);
      if (this.half_rect != null)
      {
        paramVarArgs.qD(20, this.half_rect.computeSize());
        this.half_rect.writeFields(paramVarArgs);
      }
      if (this.full_thumb_url != null) {
        paramVarArgs.g(21, this.full_thumb_url);
      }
      if (this.full_thumb_url_token != null) {
        paramVarArgs.g(22, this.full_thumb_url_token);
      }
      if (this.HaI != null) {
        paramVarArgs.g(23, this.HaI);
      }
      if (this.hdr_spec != null)
      {
        paramVarArgs.qD(24, this.hdr_spec.computeSize());
        this.hdr_spec.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258483);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label1846;
      }
    }
    label1846:
    for (paramInt = i.a.a.b.b.a.h(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.thumbUrl);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.mediaType) + i.a.a.b.b.a.cJ(4, this.aaUX) + (i.a.a.b.b.a.ko(5) + 4) + (i.a.a.b.b.a.ko(6) + 4);
      paramInt = i;
      if (this.md5sum != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.md5sum);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.fileSize) + i.a.a.b.b.a.cJ(9, this.bitrate);
      paramInt = i;
      if (this.decodeKey != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.decodeKey);
      }
      i = paramInt;
      if (this.coverUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.coverUrl);
      }
      i += i.a.a.b.b.a.q(12, this.aaUY);
      paramInt = i;
      if (this.msf != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.msf);
      }
      i = paramInt;
      if (this.msh != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.msh);
      }
      paramInt = i;
      if (this.aaUZ != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.aaUZ);
      }
      i = paramInt + i.a.a.a.c(16, 8, this.spec);
      paramInt = i;
      if (this.aaVa != null) {
        paramInt = i + i.a.a.a.qC(17, this.aaVa.computeSize());
      }
      i = paramInt;
      if (this.aaVb != null) {
        i = paramInt + i.a.a.a.qC(18, this.aaVb.computeSize());
      }
      i += i.a.a.b.b.a.cJ(19, this.hot_flag);
      paramInt = i;
      if (this.half_rect != null) {
        paramInt = i + i.a.a.a.qC(20, this.half_rect.computeSize());
      }
      i = paramInt;
      if (this.full_thumb_url != null) {
        i = paramInt + i.a.a.b.b.a.h(21, this.full_thumb_url);
      }
      paramInt = i;
      if (this.full_thumb_url_token != null) {
        paramInt = i + i.a.a.b.b.a.h(22, this.full_thumb_url_token);
      }
      i = paramInt;
      if (this.HaI != null) {
        i = paramInt + i.a.a.b.b.a.h(23, this.HaI);
      }
      paramInt = i;
      if (this.hdr_spec != null) {
        paramInt = i + i.a.a.a.qC(24, this.hdr_spec.computeSize());
      }
      AppMethodBeat.o(258483);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.spec.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258483);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dnv localdnv = (dnv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258483);
          return -1;
        case 1: 
          localdnv.url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258483);
          return 0;
        case 2: 
          localdnv.thumbUrl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258483);
          return 0;
        case 3: 
          localdnv.mediaType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258483);
          return 0;
        case 4: 
          localdnv.aaUX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258483);
          return 0;
        case 5: 
          localdnv.width = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(258483);
          return 0;
        case 6: 
          localdnv.height = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(258483);
          return 0;
        case 7: 
          localdnv.md5sum = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258483);
          return 0;
        case 8: 
          localdnv.fileSize = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258483);
          return 0;
        case 9: 
          localdnv.bitrate = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258483);
          return 0;
        case 10: 
          localdnv.decodeKey = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258483);
          return 0;
        case 11: 
          localdnv.coverUrl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258483);
          return 0;
        case 12: 
          localdnv.aaUY = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258483);
          return 0;
        case 13: 
          localdnv.msf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258483);
          return 0;
        case 14: 
          localdnv.msh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258483);
          return 0;
        case 15: 
          localdnv.aaUZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258483);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dnw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dnw)localObject2).parseFrom((byte[])localObject1);
            }
            localdnv.spec.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258483);
          return 0;
        case 17: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bbq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bbq)localObject2).parseFrom((byte[])localObject1);
            }
            localdnv.aaVa = ((bbq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258483);
          return 0;
        case 18: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bpa();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bpa)localObject2).parseFrom((byte[])localObject1);
            }
            localdnv.aaVb = ((bpa)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258483);
          return 0;
        case 19: 
          localdnv.hot_flag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258483);
          return 0;
        case 20: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bbn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bbn)localObject2).parseFrom((byte[])localObject1);
            }
            localdnv.half_rect = ((bbn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258483);
          return 0;
        case 21: 
          localdnv.full_thumb_url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258483);
          return 0;
        case 22: 
          localdnv.full_thumb_url_token = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258483);
          return 0;
        case 23: 
          localdnv.HaI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258483);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bbo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bbo)localObject2).parseFrom((byte[])localObject1);
          }
          localdnv.hdr_spec = ((bbo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258483);
        return 0;
      }
      AppMethodBeat.o(258483);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnv
 * JD-Core Version:    0.7.0.1
 */