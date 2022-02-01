package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cod
  extends com.tencent.mm.bw.a
{
  public String Ghs;
  public int Mur;
  public long Mus;
  public String Mut;
  public aua Muu;
  public ayi Muv;
  public int bitrate;
  public String coverUrl;
  public String decodeKey;
  public int fileSize;
  public String full_thumb_url;
  public String full_thumb_url_token;
  public aty half_rect;
  public float height;
  public int hot_flag;
  public String md5sum;
  public int mediaType;
  public LinkedList<coe> spec;
  public String thumbUrl;
  public String url;
  public String viB;
  public float width;
  
  public cod()
  {
    AppMethodBeat.i(209761);
    this.spec = new LinkedList();
    AppMethodBeat.o(209761);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209762);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.e(1, this.url);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.e(2, this.thumbUrl);
      }
      paramVarArgs.aM(3, this.mediaType);
      paramVarArgs.aM(4, this.Mur);
      paramVarArgs.E(5, this.width);
      paramVarArgs.E(6, this.height);
      if (this.md5sum != null) {
        paramVarArgs.e(7, this.md5sum);
      }
      paramVarArgs.aM(8, this.fileSize);
      paramVarArgs.aM(9, this.bitrate);
      if (this.decodeKey != null) {
        paramVarArgs.e(10, this.decodeKey);
      }
      if (this.coverUrl != null) {
        paramVarArgs.e(11, this.coverUrl);
      }
      paramVarArgs.bb(12, this.Mus);
      if (this.viB != null) {
        paramVarArgs.e(13, this.viB);
      }
      if (this.Ghs != null) {
        paramVarArgs.e(14, this.Ghs);
      }
      if (this.Mut != null) {
        paramVarArgs.e(15, this.Mut);
      }
      paramVarArgs.e(16, 8, this.spec);
      if (this.Muu != null)
      {
        paramVarArgs.ni(17, this.Muu.computeSize());
        this.Muu.writeFields(paramVarArgs);
      }
      if (this.Muv != null)
      {
        paramVarArgs.ni(18, this.Muv.computeSize());
        this.Muv.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(19, this.hot_flag);
      if (this.half_rect != null)
      {
        paramVarArgs.ni(20, this.half_rect.computeSize());
        this.half_rect.writeFields(paramVarArgs);
      }
      if (this.full_thumb_url != null) {
        paramVarArgs.e(21, this.full_thumb_url);
      }
      if (this.full_thumb_url_token != null) {
        paramVarArgs.e(22, this.full_thumb_url_token);
      }
      AppMethodBeat.o(209762);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label1740;
      }
    }
    label1740:
    for (paramInt = g.a.a.b.b.a.f(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.thumbUrl);
      }
      i = i + g.a.a.b.b.a.bu(3, this.mediaType) + g.a.a.b.b.a.bu(4, this.Mur) + (g.a.a.b.b.a.fS(5) + 4) + (g.a.a.b.b.a.fS(6) + 4);
      paramInt = i;
      if (this.md5sum != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.md5sum);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.fileSize) + g.a.a.b.b.a.bu(9, this.bitrate);
      paramInt = i;
      if (this.decodeKey != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.decodeKey);
      }
      i = paramInt;
      if (this.coverUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.coverUrl);
      }
      i += g.a.a.b.b.a.r(12, this.Mus);
      paramInt = i;
      if (this.viB != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.viB);
      }
      i = paramInt;
      if (this.Ghs != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.Ghs);
      }
      paramInt = i;
      if (this.Mut != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.Mut);
      }
      i = paramInt + g.a.a.a.c(16, 8, this.spec);
      paramInt = i;
      if (this.Muu != null) {
        paramInt = i + g.a.a.a.nh(17, this.Muu.computeSize());
      }
      i = paramInt;
      if (this.Muv != null) {
        i = paramInt + g.a.a.a.nh(18, this.Muv.computeSize());
      }
      i += g.a.a.b.b.a.bu(19, this.hot_flag);
      paramInt = i;
      if (this.half_rect != null) {
        paramInt = i + g.a.a.a.nh(20, this.half_rect.computeSize());
      }
      i = paramInt;
      if (this.full_thumb_url != null) {
        i = paramInt + g.a.a.b.b.a.f(21, this.full_thumb_url);
      }
      paramInt = i;
      if (this.full_thumb_url_token != null) {
        paramInt = i + g.a.a.b.b.a.f(22, this.full_thumb_url_token);
      }
      AppMethodBeat.o(209762);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.spec.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209762);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cod localcod = (cod)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209762);
          return -1;
        case 1: 
          localcod.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209762);
          return 0;
        case 2: 
          localcod.thumbUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209762);
          return 0;
        case 3: 
          localcod.mediaType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209762);
          return 0;
        case 4: 
          localcod.Mur = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209762);
          return 0;
        case 5: 
          localcod.width = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(209762);
          return 0;
        case 6: 
          localcod.height = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(209762);
          return 0;
        case 7: 
          localcod.md5sum = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209762);
          return 0;
        case 8: 
          localcod.fileSize = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209762);
          return 0;
        case 9: 
          localcod.bitrate = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209762);
          return 0;
        case 10: 
          localcod.decodeKey = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209762);
          return 0;
        case 11: 
          localcod.coverUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209762);
          return 0;
        case 12: 
          localcod.Mus = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209762);
          return 0;
        case 13: 
          localcod.viB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209762);
          return 0;
        case 14: 
          localcod.Ghs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209762);
          return 0;
        case 15: 
          localcod.Mut = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209762);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new coe();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((coe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcod.spec.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209762);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aua();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aua)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcod.Muu = ((aua)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209762);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ayi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ayi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcod.Muv = ((ayi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209762);
          return 0;
        case 19: 
          localcod.hot_flag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209762);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aty();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aty)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcod.half_rect = ((aty)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209762);
          return 0;
        case 21: 
          localcod.full_thumb_url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209762);
          return 0;
        }
        localcod.full_thumb_url_token = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209762);
        return 0;
      }
      AppMethodBeat.o(209762);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cod
 * JD-Core Version:    0.7.0.1
 */