package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjl
  extends com.tencent.mm.bw.a
{
  public acn MfU;
  public int MoL;
  public String MoM;
  public String MoN;
  public boolean MoO;
  public String MoP;
  public long MoQ;
  public String MoR;
  public String MoS;
  public String MoT;
  public aty MoU;
  public String MoV;
  public String MoW;
  public car MoX;
  public boolean MoY;
  public FinderMediaReportObject MoZ;
  public int bitrate;
  public ayg codec_info;
  public String coverUrl;
  public String cover_url_token;
  public String decodeKey;
  public int fileSize;
  public int full_bitrate;
  public int full_file_size;
  public float full_height;
  public String full_md5sum;
  public String full_url;
  public float full_width;
  public float height;
  public int hot_flag;
  public String md5sum;
  public String mediaId;
  public int mediaType;
  public LinkedList<ayh> spec;
  public String thumbUrl;
  public String thumb_url_token;
  public cjx uOR;
  public String url;
  public String url_token;
  public int videoDuration;
  public float width;
  
  public cjl()
  {
    AppMethodBeat.i(209729);
    this.spec = new LinkedList();
    AppMethodBeat.o(209729);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169080);
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
      paramVarArgs.aM(4, this.videoDuration);
      paramVarArgs.E(5, this.width);
      paramVarArgs.E(6, this.height);
      if (this.md5sum != null) {
        paramVarArgs.e(7, this.md5sum);
      }
      paramVarArgs.aM(8, this.fileSize);
      paramVarArgs.aM(9, this.bitrate);
      if (this.mediaId != null) {
        paramVarArgs.e(10, this.mediaId);
      }
      paramVarArgs.aM(11, this.MoL);
      if (this.MoM != null) {
        paramVarArgs.e(12, this.MoM);
      }
      if (this.MoN != null) {
        paramVarArgs.e(13, this.MoN);
      }
      paramVarArgs.cc(14, this.MoO);
      if (this.uOR != null)
      {
        paramVarArgs.ni(15, this.uOR.computeSize());
        this.uOR.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.spec);
      if (this.coverUrl != null) {
        paramVarArgs.e(17, this.coverUrl);
      }
      if (this.decodeKey != null) {
        paramVarArgs.e(20, this.decodeKey);
      }
      if (this.url_token != null) {
        paramVarArgs.e(21, this.url_token);
      }
      if (this.thumb_url_token != null) {
        paramVarArgs.e(22, this.thumb_url_token);
      }
      if (this.cover_url_token != null) {
        paramVarArgs.e(23, this.cover_url_token);
      }
      if (this.MfU != null)
      {
        paramVarArgs.ni(24, this.MfU.computeSize());
        this.MfU.writeFields(paramVarArgs);
      }
      if (this.codec_info != null)
      {
        paramVarArgs.ni(25, this.codec_info.computeSize());
        this.codec_info.writeFields(paramVarArgs);
      }
      if (this.MoP != null) {
        paramVarArgs.e(30, this.MoP);
      }
      paramVarArgs.bb(31, this.MoQ);
      if (this.MoR != null) {
        paramVarArgs.e(32, this.MoR);
      }
      if (this.MoS != null) {
        paramVarArgs.e(33, this.MoS);
      }
      if (this.MoT != null) {
        paramVarArgs.e(34, this.MoT);
      }
      if (this.full_url != null) {
        paramVarArgs.e(35, this.full_url);
      }
      paramVarArgs.E(36, this.full_width);
      paramVarArgs.E(37, this.full_height);
      if (this.full_md5sum != null) {
        paramVarArgs.e(38, this.full_md5sum);
      }
      paramVarArgs.aM(39, this.full_file_size);
      paramVarArgs.aM(40, this.full_bitrate);
      if (this.MoU != null)
      {
        paramVarArgs.ni(41, this.MoU.computeSize());
        this.MoU.writeFields(paramVarArgs);
      }
      if (this.MoV != null) {
        paramVarArgs.e(42, this.MoV);
      }
      if (this.MoW != null) {
        paramVarArgs.e(43, this.MoW);
      }
      if (this.MoX != null)
      {
        paramVarArgs.ni(44, this.MoX.computeSize());
        this.MoX.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(45, this.MoY);
      paramVarArgs.aM(46, this.hot_flag);
      if (this.MoZ != null)
      {
        paramVarArgs.ni(100, this.MoZ.computeSize());
        this.MoZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169080);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label3314;
      }
    }
    label3314:
    for (paramInt = g.a.a.b.b.a.f(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.thumbUrl);
      }
      i = i + g.a.a.b.b.a.bu(3, this.mediaType) + g.a.a.b.b.a.bu(4, this.videoDuration) + (g.a.a.b.b.a.fS(5) + 4) + (g.a.a.b.b.a.fS(6) + 4);
      paramInt = i;
      if (this.md5sum != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.md5sum);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.fileSize) + g.a.a.b.b.a.bu(9, this.bitrate);
      paramInt = i;
      if (this.mediaId != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.mediaId);
      }
      i = paramInt + g.a.a.b.b.a.bu(11, this.MoL);
      paramInt = i;
      if (this.MoM != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.MoM);
      }
      i = paramInt;
      if (this.MoN != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.MoN);
      }
      i += g.a.a.b.b.a.fS(14) + 1;
      paramInt = i;
      if (this.uOR != null) {
        paramInt = i + g.a.a.a.nh(15, this.uOR.computeSize());
      }
      i = paramInt + g.a.a.a.c(16, 8, this.spec);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.coverUrl);
      }
      i = paramInt;
      if (this.decodeKey != null) {
        i = paramInt + g.a.a.b.b.a.f(20, this.decodeKey);
      }
      paramInt = i;
      if (this.url_token != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.url_token);
      }
      i = paramInt;
      if (this.thumb_url_token != null) {
        i = paramInt + g.a.a.b.b.a.f(22, this.thumb_url_token);
      }
      paramInt = i;
      if (this.cover_url_token != null) {
        paramInt = i + g.a.a.b.b.a.f(23, this.cover_url_token);
      }
      i = paramInt;
      if (this.MfU != null) {
        i = paramInt + g.a.a.a.nh(24, this.MfU.computeSize());
      }
      paramInt = i;
      if (this.codec_info != null) {
        paramInt = i + g.a.a.a.nh(25, this.codec_info.computeSize());
      }
      i = paramInt;
      if (this.MoP != null) {
        i = paramInt + g.a.a.b.b.a.f(30, this.MoP);
      }
      i += g.a.a.b.b.a.r(31, this.MoQ);
      paramInt = i;
      if (this.MoR != null) {
        paramInt = i + g.a.a.b.b.a.f(32, this.MoR);
      }
      i = paramInt;
      if (this.MoS != null) {
        i = paramInt + g.a.a.b.b.a.f(33, this.MoS);
      }
      paramInt = i;
      if (this.MoT != null) {
        paramInt = i + g.a.a.b.b.a.f(34, this.MoT);
      }
      i = paramInt;
      if (this.full_url != null) {
        i = paramInt + g.a.a.b.b.a.f(35, this.full_url);
      }
      i = i + (g.a.a.b.b.a.fS(36) + 4) + (g.a.a.b.b.a.fS(37) + 4);
      paramInt = i;
      if (this.full_md5sum != null) {
        paramInt = i + g.a.a.b.b.a.f(38, this.full_md5sum);
      }
      i = paramInt + g.a.a.b.b.a.bu(39, this.full_file_size) + g.a.a.b.b.a.bu(40, this.full_bitrate);
      paramInt = i;
      if (this.MoU != null) {
        paramInt = i + g.a.a.a.nh(41, this.MoU.computeSize());
      }
      i = paramInt;
      if (this.MoV != null) {
        i = paramInt + g.a.a.b.b.a.f(42, this.MoV);
      }
      paramInt = i;
      if (this.MoW != null) {
        paramInt = i + g.a.a.b.b.a.f(43, this.MoW);
      }
      i = paramInt;
      if (this.MoX != null) {
        i = paramInt + g.a.a.a.nh(44, this.MoX.computeSize());
      }
      i = i + (g.a.a.b.b.a.fS(45) + 1) + g.a.a.b.b.a.bu(46, this.hot_flag);
      paramInt = i;
      if (this.MoZ != null) {
        paramInt = i + g.a.a.a.nh(100, this.MoZ.computeSize());
      }
      AppMethodBeat.o(169080);
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
        AppMethodBeat.o(169080);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cjl localcjl = (cjl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 18: 
        case 19: 
        case 26: 
        case 27: 
        case 28: 
        case 29: 
        case 47: 
        case 48: 
        case 49: 
        case 50: 
        case 51: 
        case 52: 
        case 53: 
        case 54: 
        case 55: 
        case 56: 
        case 57: 
        case 58: 
        case 59: 
        case 60: 
        case 61: 
        case 62: 
        case 63: 
        case 64: 
        case 65: 
        case 66: 
        case 67: 
        case 68: 
        case 69: 
        case 70: 
        case 71: 
        case 72: 
        case 73: 
        case 74: 
        case 75: 
        case 76: 
        case 77: 
        case 78: 
        case 79: 
        case 80: 
        case 81: 
        case 82: 
        case 83: 
        case 84: 
        case 85: 
        case 86: 
        case 87: 
        case 88: 
        case 89: 
        case 90: 
        case 91: 
        case 92: 
        case 93: 
        case 94: 
        case 95: 
        case 96: 
        case 97: 
        case 98: 
        case 99: 
        default: 
          AppMethodBeat.o(169080);
          return -1;
        case 1: 
          localcjl.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 2: 
          localcjl.thumbUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 3: 
          localcjl.mediaType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169080);
          return 0;
        case 4: 
          localcjl.videoDuration = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169080);
          return 0;
        case 5: 
          localcjl.width = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(169080);
          return 0;
        case 6: 
          localcjl.height = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(169080);
          return 0;
        case 7: 
          localcjl.md5sum = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 8: 
          localcjl.fileSize = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169080);
          return 0;
        case 9: 
          localcjl.bitrate = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169080);
          return 0;
        case 10: 
          localcjl.mediaId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 11: 
          localcjl.MoL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169080);
          return 0;
        case 12: 
          localcjl.MoM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 13: 
          localcjl.MoN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 14: 
          localcjl.MoO = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(169080);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjx();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcjl.uOR = ((cjx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ayh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ayh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcjl.spec.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 17: 
          localcjl.coverUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 20: 
          localcjl.decodeKey = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 21: 
          localcjl.url_token = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 22: 
          localcjl.thumb_url_token = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 23: 
          localcjl.cover_url_token = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 24: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcjl.MfU = ((acn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 25: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ayg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ayg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcjl.codec_info = ((ayg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 30: 
          localcjl.MoP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 31: 
          localcjl.MoQ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169080);
          return 0;
        case 32: 
          localcjl.MoR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 33: 
          localcjl.MoS = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 34: 
          localcjl.MoT = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 35: 
          localcjl.full_url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 36: 
          localcjl.full_width = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(169080);
          return 0;
        case 37: 
          localcjl.full_height = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(169080);
          return 0;
        case 38: 
          localcjl.full_md5sum = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 39: 
          localcjl.full_file_size = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169080);
          return 0;
        case 40: 
          localcjl.full_bitrate = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169080);
          return 0;
        case 41: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aty();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aty)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcjl.MoU = ((aty)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 42: 
          localcjl.MoV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 43: 
          localcjl.MoW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 44: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new car();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((car)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcjl.MoX = ((car)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 45: 
          localcjl.MoY = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(169080);
          return 0;
        case 46: 
          localcjl.hot_flag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169080);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderMediaReportObject();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderMediaReportObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcjl.MoZ = ((FinderMediaReportObject)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169080);
        return 0;
      }
      AppMethodBeat.o(169080);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjl
 * JD-Core Version:    0.7.0.1
 */