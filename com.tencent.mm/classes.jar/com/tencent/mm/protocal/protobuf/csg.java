package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class csg
  extends com.tencent.mm.cd.a
{
  public awc TAa;
  public String TAb;
  public String TAc;
  public cis TAd;
  public boolean TAe;
  public FinderMediaReportObject TAf;
  public acu TpG;
  public int TzR;
  public String TzS;
  public String TzT;
  public boolean TzU;
  public String TzV;
  public long TzW;
  public String TzX;
  public String TzY;
  public String TzZ;
  public int bitrate;
  public bea codec_info;
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
  public LinkedList<beb> spec;
  public String thumbUrl;
  public String thumb_url_token;
  public String url;
  public String url_token;
  public int videoDuration;
  public float width;
  public css zBo;
  
  public csg()
  {
    AppMethodBeat.i(197559);
    this.spec = new LinkedList();
    AppMethodBeat.o(197559);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169080);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.f(1, this.url);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.f(2, this.thumbUrl);
      }
      paramVarArgs.aY(3, this.mediaType);
      paramVarArgs.aY(4, this.videoDuration);
      paramVarArgs.i(5, this.width);
      paramVarArgs.i(6, this.height);
      if (this.md5sum != null) {
        paramVarArgs.f(7, this.md5sum);
      }
      paramVarArgs.aY(8, this.fileSize);
      paramVarArgs.aY(9, this.bitrate);
      if (this.mediaId != null) {
        paramVarArgs.f(10, this.mediaId);
      }
      paramVarArgs.aY(11, this.TzR);
      if (this.TzS != null) {
        paramVarArgs.f(12, this.TzS);
      }
      if (this.TzT != null) {
        paramVarArgs.f(13, this.TzT);
      }
      paramVarArgs.co(14, this.TzU);
      if (this.zBo != null)
      {
        paramVarArgs.oE(15, this.zBo.computeSize());
        this.zBo.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.spec);
      if (this.coverUrl != null) {
        paramVarArgs.f(17, this.coverUrl);
      }
      if (this.decodeKey != null) {
        paramVarArgs.f(20, this.decodeKey);
      }
      if (this.url_token != null) {
        paramVarArgs.f(21, this.url_token);
      }
      if (this.thumb_url_token != null) {
        paramVarArgs.f(22, this.thumb_url_token);
      }
      if (this.cover_url_token != null) {
        paramVarArgs.f(23, this.cover_url_token);
      }
      if (this.TpG != null)
      {
        paramVarArgs.oE(24, this.TpG.computeSize());
        this.TpG.writeFields(paramVarArgs);
      }
      if (this.codec_info != null)
      {
        paramVarArgs.oE(25, this.codec_info.computeSize());
        this.codec_info.writeFields(paramVarArgs);
      }
      if (this.TzV != null) {
        paramVarArgs.f(30, this.TzV);
      }
      paramVarArgs.bm(31, this.TzW);
      if (this.TzX != null) {
        paramVarArgs.f(32, this.TzX);
      }
      if (this.TzY != null) {
        paramVarArgs.f(33, this.TzY);
      }
      if (this.TzZ != null) {
        paramVarArgs.f(34, this.TzZ);
      }
      if (this.full_url != null) {
        paramVarArgs.f(35, this.full_url);
      }
      paramVarArgs.i(36, this.full_width);
      paramVarArgs.i(37, this.full_height);
      if (this.full_md5sum != null) {
        paramVarArgs.f(38, this.full_md5sum);
      }
      paramVarArgs.aY(39, this.full_file_size);
      paramVarArgs.aY(40, this.full_bitrate);
      if (this.TAa != null)
      {
        paramVarArgs.oE(41, this.TAa.computeSize());
        this.TAa.writeFields(paramVarArgs);
      }
      if (this.TAb != null) {
        paramVarArgs.f(42, this.TAb);
      }
      if (this.TAc != null) {
        paramVarArgs.f(43, this.TAc);
      }
      if (this.TAd != null)
      {
        paramVarArgs.oE(44, this.TAd.computeSize());
        this.TAd.writeFields(paramVarArgs);
      }
      paramVarArgs.co(45, this.TAe);
      paramVarArgs.aY(46, this.hot_flag);
      if (this.TAf != null)
      {
        paramVarArgs.oE(100, this.TAf.computeSize());
        this.TAf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169080);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label3160;
      }
    }
    label3160:
    for (paramInt = g.a.a.b.b.a.g(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.thumbUrl);
      }
      i = i + g.a.a.b.b.a.bM(3, this.mediaType) + g.a.a.b.b.a.bM(4, this.videoDuration) + (g.a.a.b.b.a.gL(5) + 4) + (g.a.a.b.b.a.gL(6) + 4);
      paramInt = i;
      if (this.md5sum != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.md5sum);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.fileSize) + g.a.a.b.b.a.bM(9, this.bitrate);
      paramInt = i;
      if (this.mediaId != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.mediaId);
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.TzR);
      paramInt = i;
      if (this.TzS != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.TzS);
      }
      i = paramInt;
      if (this.TzT != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.TzT);
      }
      i += g.a.a.b.b.a.gL(14) + 1;
      paramInt = i;
      if (this.zBo != null) {
        paramInt = i + g.a.a.a.oD(15, this.zBo.computeSize());
      }
      i = paramInt + g.a.a.a.c(16, 8, this.spec);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.coverUrl);
      }
      i = paramInt;
      if (this.decodeKey != null) {
        i = paramInt + g.a.a.b.b.a.g(20, this.decodeKey);
      }
      paramInt = i;
      if (this.url_token != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.url_token);
      }
      i = paramInt;
      if (this.thumb_url_token != null) {
        i = paramInt + g.a.a.b.b.a.g(22, this.thumb_url_token);
      }
      paramInt = i;
      if (this.cover_url_token != null) {
        paramInt = i + g.a.a.b.b.a.g(23, this.cover_url_token);
      }
      i = paramInt;
      if (this.TpG != null) {
        i = paramInt + g.a.a.a.oD(24, this.TpG.computeSize());
      }
      paramInt = i;
      if (this.codec_info != null) {
        paramInt = i + g.a.a.a.oD(25, this.codec_info.computeSize());
      }
      i = paramInt;
      if (this.TzV != null) {
        i = paramInt + g.a.a.b.b.a.g(30, this.TzV);
      }
      i += g.a.a.b.b.a.p(31, this.TzW);
      paramInt = i;
      if (this.TzX != null) {
        paramInt = i + g.a.a.b.b.a.g(32, this.TzX);
      }
      i = paramInt;
      if (this.TzY != null) {
        i = paramInt + g.a.a.b.b.a.g(33, this.TzY);
      }
      paramInt = i;
      if (this.TzZ != null) {
        paramInt = i + g.a.a.b.b.a.g(34, this.TzZ);
      }
      i = paramInt;
      if (this.full_url != null) {
        i = paramInt + g.a.a.b.b.a.g(35, this.full_url);
      }
      i = i + (g.a.a.b.b.a.gL(36) + 4) + (g.a.a.b.b.a.gL(37) + 4);
      paramInt = i;
      if (this.full_md5sum != null) {
        paramInt = i + g.a.a.b.b.a.g(38, this.full_md5sum);
      }
      i = paramInt + g.a.a.b.b.a.bM(39, this.full_file_size) + g.a.a.b.b.a.bM(40, this.full_bitrate);
      paramInt = i;
      if (this.TAa != null) {
        paramInt = i + g.a.a.a.oD(41, this.TAa.computeSize());
      }
      i = paramInt;
      if (this.TAb != null) {
        i = paramInt + g.a.a.b.b.a.g(42, this.TAb);
      }
      paramInt = i;
      if (this.TAc != null) {
        paramInt = i + g.a.a.b.b.a.g(43, this.TAc);
      }
      i = paramInt;
      if (this.TAd != null) {
        i = paramInt + g.a.a.a.oD(44, this.TAd.computeSize());
      }
      i = i + (g.a.a.b.b.a.gL(45) + 1) + g.a.a.b.b.a.bM(46, this.hot_flag);
      paramInt = i;
      if (this.TAf != null) {
        paramInt = i + g.a.a.a.oD(100, this.TAf.computeSize());
      }
      AppMethodBeat.o(169080);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.spec.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169080);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        csg localcsg = (csg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
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
          localcsg.url = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 2: 
          localcsg.thumbUrl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 3: 
          localcsg.mediaType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169080);
          return 0;
        case 4: 
          localcsg.videoDuration = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169080);
          return 0;
        case 5: 
          localcsg.width = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(169080);
          return 0;
        case 6: 
          localcsg.height = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(169080);
          return 0;
        case 7: 
          localcsg.md5sum = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 8: 
          localcsg.fileSize = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169080);
          return 0;
        case 9: 
          localcsg.bitrate = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169080);
          return 0;
        case 10: 
          localcsg.mediaId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 11: 
          localcsg.TzR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169080);
          return 0;
        case 12: 
          localcsg.TzS = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 13: 
          localcsg.TzT = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 14: 
          localcsg.TzU = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(169080);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new css();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((css)localObject2).parseFrom((byte[])localObject1);
            }
            localcsg.zBo = ((css)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new beb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((beb)localObject2).parseFrom((byte[])localObject1);
            }
            localcsg.spec.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 17: 
          localcsg.coverUrl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 20: 
          localcsg.decodeKey = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 21: 
          localcsg.url_token = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 22: 
          localcsg.thumb_url_token = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 23: 
          localcsg.cover_url_token = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 24: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new acu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((acu)localObject2).parseFrom((byte[])localObject1);
            }
            localcsg.TpG = ((acu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 25: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bea();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bea)localObject2).parseFrom((byte[])localObject1);
            }
            localcsg.codec_info = ((bea)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 30: 
          localcsg.TzV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 31: 
          localcsg.TzW = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(169080);
          return 0;
        case 32: 
          localcsg.TzX = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 33: 
          localcsg.TzY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 34: 
          localcsg.TzZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 35: 
          localcsg.full_url = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 36: 
          localcsg.full_width = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(169080);
          return 0;
        case 37: 
          localcsg.full_height = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(169080);
          return 0;
        case 38: 
          localcsg.full_md5sum = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 39: 
          localcsg.full_file_size = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169080);
          return 0;
        case 40: 
          localcsg.full_bitrate = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169080);
          return 0;
        case 41: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new awc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((awc)localObject2).parseFrom((byte[])localObject1);
            }
            localcsg.TAa = ((awc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 42: 
          localcsg.TAb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 43: 
          localcsg.TAc = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 44: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cis();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cis)localObject2).parseFrom((byte[])localObject1);
            }
            localcsg.TAd = ((cis)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 45: 
          localcsg.TAe = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(169080);
          return 0;
        case 46: 
          localcsg.hot_flag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169080);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderMediaReportObject();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderMediaReportObject)localObject2).parseFrom((byte[])localObject1);
          }
          localcsg.TAf = ((FinderMediaReportObject)localObject2);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csg
 * JD-Core Version:    0.7.0.1
 */