package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvz
  extends com.tencent.mm.bw.a
{
  public int HiS;
  public String HiT;
  public String HiU;
  public boolean HiV;
  public aaq HiW;
  public String HiX;
  public FinderMediaReportObject HiY;
  public int bitrate;
  public apo codec_info;
  public String coverUrl;
  public String cover_url_token;
  public String decodeKey;
  public int fileSize;
  public float height;
  public String md5sum;
  public String mediaId;
  public int mediaType;
  public LinkedList<app> spec;
  public bwj stz;
  public String thumbUrl;
  public String thumb_url_token;
  public String url;
  public String url_token;
  public int videoDuration;
  public float width;
  
  public bvz()
  {
    AppMethodBeat.i(189425);
    this.spec = new LinkedList();
    AppMethodBeat.o(189425);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169080);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.d(2, this.thumbUrl);
      }
      paramVarArgs.aS(3, this.mediaType);
      paramVarArgs.aS(4, this.videoDuration);
      paramVarArgs.y(5, this.width);
      paramVarArgs.y(6, this.height);
      if (this.md5sum != null) {
        paramVarArgs.d(7, this.md5sum);
      }
      paramVarArgs.aS(8, this.fileSize);
      paramVarArgs.aS(9, this.bitrate);
      if (this.mediaId != null) {
        paramVarArgs.d(10, this.mediaId);
      }
      paramVarArgs.aS(11, this.HiS);
      if (this.HiT != null) {
        paramVarArgs.d(12, this.HiT);
      }
      if (this.HiU != null) {
        paramVarArgs.d(13, this.HiU);
      }
      paramVarArgs.bC(14, this.HiV);
      if (this.stz != null)
      {
        paramVarArgs.lJ(15, this.stz.computeSize());
        this.stz.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.spec);
      if (this.coverUrl != null) {
        paramVarArgs.d(17, this.coverUrl);
      }
      if (this.decodeKey != null) {
        paramVarArgs.d(20, this.decodeKey);
      }
      if (this.url_token != null) {
        paramVarArgs.d(21, this.url_token);
      }
      if (this.thumb_url_token != null) {
        paramVarArgs.d(22, this.thumb_url_token);
      }
      if (this.cover_url_token != null) {
        paramVarArgs.d(23, this.cover_url_token);
      }
      if (this.HiW != null)
      {
        paramVarArgs.lJ(24, this.HiW.computeSize());
        this.HiW.writeFields(paramVarArgs);
      }
      if (this.codec_info != null)
      {
        paramVarArgs.lJ(25, this.codec_info.computeSize());
        this.codec_info.writeFields(paramVarArgs);
      }
      if (this.HiX != null) {
        paramVarArgs.d(30, this.HiX);
      }
      if (this.HiY != null)
      {
        paramVarArgs.lJ(100, this.HiY.computeSize());
        this.HiY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169080);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label2108;
      }
    }
    label2108:
    for (paramInt = f.a.a.b.b.a.e(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.thumbUrl);
      }
      i = i + f.a.a.b.b.a.bz(3, this.mediaType) + f.a.a.b.b.a.bz(4, this.videoDuration) + f.a.a.b.b.a.amE(5) + f.a.a.b.b.a.amE(6);
      paramInt = i;
      if (this.md5sum != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.md5sum);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.fileSize) + f.a.a.b.b.a.bz(9, this.bitrate);
      paramInt = i;
      if (this.mediaId != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.mediaId);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.HiS);
      paramInt = i;
      if (this.HiT != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.HiT);
      }
      i = paramInt;
      if (this.HiU != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.HiU);
      }
      i += f.a.a.b.b.a.amF(14);
      paramInt = i;
      if (this.stz != null) {
        paramInt = i + f.a.a.a.lI(15, this.stz.computeSize());
      }
      i = paramInt + f.a.a.a.c(16, 8, this.spec);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.coverUrl);
      }
      i = paramInt;
      if (this.decodeKey != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.decodeKey);
      }
      paramInt = i;
      if (this.url_token != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.url_token);
      }
      i = paramInt;
      if (this.thumb_url_token != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.thumb_url_token);
      }
      paramInt = i;
      if (this.cover_url_token != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.cover_url_token);
      }
      i = paramInt;
      if (this.HiW != null) {
        i = paramInt + f.a.a.a.lI(24, this.HiW.computeSize());
      }
      paramInt = i;
      if (this.codec_info != null) {
        paramInt = i + f.a.a.a.lI(25, this.codec_info.computeSize());
      }
      i = paramInt;
      if (this.HiX != null) {
        i = paramInt + f.a.a.b.b.a.e(30, this.HiX);
      }
      paramInt = i;
      if (this.HiY != null) {
        paramInt = i + f.a.a.a.lI(100, this.HiY.computeSize());
      }
      AppMethodBeat.o(169080);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.spec.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(169080);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bvz localbvz = (bvz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169080);
          return -1;
        case 1: 
          localbvz.url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 2: 
          localbvz.thumbUrl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 3: 
          localbvz.mediaType = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169080);
          return 0;
        case 4: 
          localbvz.videoDuration = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169080);
          return 0;
        case 5: 
          localbvz.width = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(169080);
          return 0;
        case 6: 
          localbvz.height = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(169080);
          return 0;
        case 7: 
          localbvz.md5sum = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 8: 
          localbvz.fileSize = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169080);
          return 0;
        case 9: 
          localbvz.bitrate = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169080);
          return 0;
        case 10: 
          localbvz.mediaId = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 11: 
          localbvz.HiS = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169080);
          return 0;
        case 12: 
          localbvz.HiT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 13: 
          localbvz.HiU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 14: 
          localbvz.HiV = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(169080);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvz.stz = ((bwj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new app();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((app)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvz.spec.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 17: 
          localbvz.coverUrl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 20: 
          localbvz.decodeKey = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 21: 
          localbvz.url_token = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 22: 
          localbvz.thumb_url_token = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 23: 
          localbvz.cover_url_token = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 24: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aaq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aaq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvz.HiW = ((aaq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 25: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvz.codec_info = ((apo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 30: 
          localbvz.HiX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169080);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderMediaReportObject();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderMediaReportObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbvz.HiY = ((FinderMediaReportObject)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvz
 * JD-Core Version:    0.7.0.1
 */