package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class dji
  extends com.tencent.mm.bx.a
{
  public dju EDC;
  public String HaI;
  public afb aaDI;
  public int aaPc;
  public String aaPd;
  public String aaPe;
  public boolean aaPf;
  public String aaPg;
  public long aaPh;
  public String aaPi;
  public String aaPj;
  public String aaPk;
  public bbn aaPl;
  public String aaPm;
  public String aaPn;
  public cyv aaPo;
  public boolean aaPp;
  public String aaPq;
  public LinkedList<bbp> aaPr;
  public LinkedList<boz> aaPs;
  public FinderMediaReportObject aaPt;
  public int bitrate;
  public boy codec_info;
  public String coverUrl;
  public String cover_url_token;
  public String decodeKey;
  public int fileSize;
  public int full_bitrate;
  public String full_cover_url_token;
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
  public LinkedList<boz> spec;
  public String thumbUrl;
  public String thumb_url_token;
  public String url;
  public String url_token;
  public int videoDuration;
  public float width;
  
  public dji()
  {
    AppMethodBeat.i(259891);
    this.spec = new LinkedList();
    this.aaPr = new LinkedList();
    this.aaPs = new LinkedList();
    AppMethodBeat.o(259891);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169080);
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
      paramVarArgs.bS(4, this.videoDuration);
      paramVarArgs.l(5, this.width);
      paramVarArgs.l(6, this.height);
      if (this.md5sum != null) {
        paramVarArgs.g(7, this.md5sum);
      }
      paramVarArgs.bS(8, this.fileSize);
      paramVarArgs.bS(9, this.bitrate);
      if (this.mediaId != null) {
        paramVarArgs.g(10, this.mediaId);
      }
      paramVarArgs.bS(11, this.aaPc);
      if (this.aaPd != null) {
        paramVarArgs.g(12, this.aaPd);
      }
      if (this.aaPe != null) {
        paramVarArgs.g(13, this.aaPe);
      }
      paramVarArgs.di(14, this.aaPf);
      if (this.EDC != null)
      {
        paramVarArgs.qD(15, this.EDC.computeSize());
        this.EDC.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.spec);
      if (this.coverUrl != null) {
        paramVarArgs.g(17, this.coverUrl);
      }
      if (this.decodeKey != null) {
        paramVarArgs.g(20, this.decodeKey);
      }
      if (this.url_token != null) {
        paramVarArgs.g(21, this.url_token);
      }
      if (this.thumb_url_token != null) {
        paramVarArgs.g(22, this.thumb_url_token);
      }
      if (this.cover_url_token != null) {
        paramVarArgs.g(23, this.cover_url_token);
      }
      if (this.aaDI != null)
      {
        paramVarArgs.qD(24, this.aaDI.computeSize());
        this.aaDI.writeFields(paramVarArgs);
      }
      if (this.codec_info != null)
      {
        paramVarArgs.qD(25, this.codec_info.computeSize());
        this.codec_info.writeFields(paramVarArgs);
      }
      if (this.aaPg != null) {
        paramVarArgs.g(30, this.aaPg);
      }
      paramVarArgs.bv(31, this.aaPh);
      if (this.aaPi != null) {
        paramVarArgs.g(32, this.aaPi);
      }
      if (this.aaPj != null) {
        paramVarArgs.g(33, this.aaPj);
      }
      if (this.aaPk != null) {
        paramVarArgs.g(34, this.aaPk);
      }
      if (this.full_url != null) {
        paramVarArgs.g(35, this.full_url);
      }
      paramVarArgs.l(36, this.full_width);
      paramVarArgs.l(37, this.full_height);
      if (this.full_md5sum != null) {
        paramVarArgs.g(38, this.full_md5sum);
      }
      paramVarArgs.bS(39, this.full_file_size);
      paramVarArgs.bS(40, this.full_bitrate);
      if (this.aaPl != null)
      {
        paramVarArgs.qD(41, this.aaPl.computeSize());
        this.aaPl.writeFields(paramVarArgs);
      }
      if (this.aaPm != null) {
        paramVarArgs.g(42, this.aaPm);
      }
      if (this.aaPn != null) {
        paramVarArgs.g(43, this.aaPn);
      }
      if (this.aaPo != null)
      {
        paramVarArgs.qD(44, this.aaPo.computeSize());
        this.aaPo.writeFields(paramVarArgs);
      }
      paramVarArgs.di(45, this.aaPp);
      paramVarArgs.bS(46, this.hot_flag);
      if (this.aaPq != null) {
        paramVarArgs.g(47, this.aaPq);
      }
      if (this.HaI != null) {
        paramVarArgs.g(48, this.HaI);
      }
      if (this.full_cover_url_token != null) {
        paramVarArgs.g(49, this.full_cover_url_token);
      }
      paramVarArgs.e(50, 8, this.aaPr);
      paramVarArgs.e(51, 8, this.aaPs);
      if (this.aaPt != null)
      {
        paramVarArgs.qD(100, this.aaPt.computeSize());
        this.aaPt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169080);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label3560;
      }
    }
    label3560:
    for (paramInt = i.a.a.b.b.a.h(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.thumbUrl);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.mediaType) + i.a.a.b.b.a.cJ(4, this.videoDuration) + (i.a.a.b.b.a.ko(5) + 4) + (i.a.a.b.b.a.ko(6) + 4);
      paramInt = i;
      if (this.md5sum != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.md5sum);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.fileSize) + i.a.a.b.b.a.cJ(9, this.bitrate);
      paramInt = i;
      if (this.mediaId != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.mediaId);
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.aaPc);
      paramInt = i;
      if (this.aaPd != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.aaPd);
      }
      i = paramInt;
      if (this.aaPe != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.aaPe);
      }
      i += i.a.a.b.b.a.ko(14) + 1;
      paramInt = i;
      if (this.EDC != null) {
        paramInt = i + i.a.a.a.qC(15, this.EDC.computeSize());
      }
      i = paramInt + i.a.a.a.c(16, 8, this.spec);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.coverUrl);
      }
      i = paramInt;
      if (this.decodeKey != null) {
        i = paramInt + i.a.a.b.b.a.h(20, this.decodeKey);
      }
      paramInt = i;
      if (this.url_token != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.url_token);
      }
      i = paramInt;
      if (this.thumb_url_token != null) {
        i = paramInt + i.a.a.b.b.a.h(22, this.thumb_url_token);
      }
      paramInt = i;
      if (this.cover_url_token != null) {
        paramInt = i + i.a.a.b.b.a.h(23, this.cover_url_token);
      }
      i = paramInt;
      if (this.aaDI != null) {
        i = paramInt + i.a.a.a.qC(24, this.aaDI.computeSize());
      }
      paramInt = i;
      if (this.codec_info != null) {
        paramInt = i + i.a.a.a.qC(25, this.codec_info.computeSize());
      }
      i = paramInt;
      if (this.aaPg != null) {
        i = paramInt + i.a.a.b.b.a.h(30, this.aaPg);
      }
      i += i.a.a.b.b.a.q(31, this.aaPh);
      paramInt = i;
      if (this.aaPi != null) {
        paramInt = i + i.a.a.b.b.a.h(32, this.aaPi);
      }
      i = paramInt;
      if (this.aaPj != null) {
        i = paramInt + i.a.a.b.b.a.h(33, this.aaPj);
      }
      paramInt = i;
      if (this.aaPk != null) {
        paramInt = i + i.a.a.b.b.a.h(34, this.aaPk);
      }
      i = paramInt;
      if (this.full_url != null) {
        i = paramInt + i.a.a.b.b.a.h(35, this.full_url);
      }
      i = i + (i.a.a.b.b.a.ko(36) + 4) + (i.a.a.b.b.a.ko(37) + 4);
      paramInt = i;
      if (this.full_md5sum != null) {
        paramInt = i + i.a.a.b.b.a.h(38, this.full_md5sum);
      }
      i = paramInt + i.a.a.b.b.a.cJ(39, this.full_file_size) + i.a.a.b.b.a.cJ(40, this.full_bitrate);
      paramInt = i;
      if (this.aaPl != null) {
        paramInt = i + i.a.a.a.qC(41, this.aaPl.computeSize());
      }
      i = paramInt;
      if (this.aaPm != null) {
        i = paramInt + i.a.a.b.b.a.h(42, this.aaPm);
      }
      paramInt = i;
      if (this.aaPn != null) {
        paramInt = i + i.a.a.b.b.a.h(43, this.aaPn);
      }
      i = paramInt;
      if (this.aaPo != null) {
        i = paramInt + i.a.a.a.qC(44, this.aaPo.computeSize());
      }
      i = i + (i.a.a.b.b.a.ko(45) + 1) + i.a.a.b.b.a.cJ(46, this.hot_flag);
      paramInt = i;
      if (this.aaPq != null) {
        paramInt = i + i.a.a.b.b.a.h(47, this.aaPq);
      }
      i = paramInt;
      if (this.HaI != null) {
        i = paramInt + i.a.a.b.b.a.h(48, this.HaI);
      }
      paramInt = i;
      if (this.full_cover_url_token != null) {
        paramInt = i + i.a.a.b.b.a.h(49, this.full_cover_url_token);
      }
      i = paramInt + i.a.a.a.c(50, 8, this.aaPr) + i.a.a.a.c(51, 8, this.aaPs);
      paramInt = i;
      if (this.aaPt != null) {
        paramInt = i + i.a.a.a.qC(100, this.aaPt.computeSize());
      }
      AppMethodBeat.o(169080);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.spec.clear();
        this.aaPr.clear();
        this.aaPs.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169080);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dji localdji = (dji)paramVarArgs[1];
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
          localdji.url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 2: 
          localdji.thumbUrl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 3: 
          localdji.mediaType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169080);
          return 0;
        case 4: 
          localdji.videoDuration = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169080);
          return 0;
        case 5: 
          localdji.width = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(169080);
          return 0;
        case 6: 
          localdji.height = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(169080);
          return 0;
        case 7: 
          localdji.md5sum = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 8: 
          localdji.fileSize = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169080);
          return 0;
        case 9: 
          localdji.bitrate = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169080);
          return 0;
        case 10: 
          localdji.mediaId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 11: 
          localdji.aaPc = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169080);
          return 0;
        case 12: 
          localdji.aaPd = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 13: 
          localdji.aaPe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 14: 
          localdji.aaPf = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(169080);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dju();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dju)localObject2).parseFrom((byte[])localObject1);
            }
            localdji.EDC = ((dju)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new boz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((boz)localObject2).parseFrom((byte[])localObject1);
            }
            localdji.spec.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 17: 
          localdji.coverUrl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 20: 
          localdji.decodeKey = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 21: 
          localdji.url_token = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 22: 
          localdji.thumb_url_token = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 23: 
          localdji.cover_url_token = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 24: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new afb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((afb)localObject2).parseFrom((byte[])localObject1);
            }
            localdji.aaDI = ((afb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 25: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new boy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((boy)localObject2).parseFrom((byte[])localObject1);
            }
            localdji.codec_info = ((boy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 30: 
          localdji.aaPg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 31: 
          localdji.aaPh = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169080);
          return 0;
        case 32: 
          localdji.aaPi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 33: 
          localdji.aaPj = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 34: 
          localdji.aaPk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 35: 
          localdji.full_url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 36: 
          localdji.full_width = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(169080);
          return 0;
        case 37: 
          localdji.full_height = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(169080);
          return 0;
        case 38: 
          localdji.full_md5sum = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 39: 
          localdji.full_file_size = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169080);
          return 0;
        case 40: 
          localdji.full_bitrate = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169080);
          return 0;
        case 41: 
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
            localdji.aaPl = ((bbn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 42: 
          localdji.aaPm = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 43: 
          localdji.aaPn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 44: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cyv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cyv)localObject2).parseFrom((byte[])localObject1);
            }
            localdji.aaPo = ((cyv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 45: 
          localdji.aaPp = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(169080);
          return 0;
        case 46: 
          localdji.hot_flag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169080);
          return 0;
        case 47: 
          localdji.aaPq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 48: 
          localdji.HaI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 49: 
          localdji.full_cover_url_token = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 50: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bbp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bbp)localObject2).parseFrom((byte[])localObject1);
            }
            localdji.aaPr.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 51: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new boz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((boz)localObject2).parseFrom((byte[])localObject1);
            }
            localdji.aaPs.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderMediaReportObject();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderMediaReportObject)localObject2).parseFrom((byte[])localObject1);
          }
          localdji.aaPt = ((FinderMediaReportObject)localObject2);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dji
 * JD-Core Version:    0.7.0.1
 */