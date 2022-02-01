package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvf
  extends com.tencent.mm.bx.a
{
  public int GPq;
  public String GPr;
  public String GPs;
  public boolean GPt;
  public aan GPu;
  public String GPv;
  public FinderMediaReportObject GPw;
  public int bitrate;
  public apb codec_info;
  public String coverUrl;
  public String cover_url_token;
  public String decodeKey;
  public int fileSize;
  public float height;
  public String md5sum;
  public String mediaId;
  public int mediaType;
  public bvp skC;
  public LinkedList<apc> spec;
  public String thumbUrl;
  public String thumb_url_token;
  public String url;
  public String url_token;
  public int videoDuration;
  public float width;
  
  public bvf()
  {
    AppMethodBeat.i(209380);
    this.spec = new LinkedList();
    AppMethodBeat.o(209380);
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
      paramVarArgs.z(5, this.width);
      paramVarArgs.z(6, this.height);
      if (this.md5sum != null) {
        paramVarArgs.d(7, this.md5sum);
      }
      paramVarArgs.aS(8, this.fileSize);
      paramVarArgs.aS(9, this.bitrate);
      if (this.mediaId != null) {
        paramVarArgs.d(10, this.mediaId);
      }
      paramVarArgs.aS(11, this.GPq);
      if (this.GPr != null) {
        paramVarArgs.d(12, this.GPr);
      }
      if (this.GPs != null) {
        paramVarArgs.d(13, this.GPs);
      }
      paramVarArgs.bt(14, this.GPt);
      if (this.skC != null)
      {
        paramVarArgs.lC(15, this.skC.computeSize());
        this.skC.writeFields(paramVarArgs);
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
      if (this.GPu != null)
      {
        paramVarArgs.lC(24, this.GPu.computeSize());
        this.GPu.writeFields(paramVarArgs);
      }
      if (this.codec_info != null)
      {
        paramVarArgs.lC(25, this.codec_info.computeSize());
        this.codec_info.writeFields(paramVarArgs);
      }
      if (this.GPv != null) {
        paramVarArgs.d(30, this.GPv);
      }
      if (this.GPw != null)
      {
        paramVarArgs.lC(100, this.GPw.computeSize());
        this.GPw.writeFields(paramVarArgs);
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
      i = i + f.a.a.b.b.a.bz(3, this.mediaType) + f.a.a.b.b.a.bz(4, this.videoDuration) + f.a.a.b.b.a.alU(5) + f.a.a.b.b.a.alU(6);
      paramInt = i;
      if (this.md5sum != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.md5sum);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.fileSize) + f.a.a.b.b.a.bz(9, this.bitrate);
      paramInt = i;
      if (this.mediaId != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.mediaId);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.GPq);
      paramInt = i;
      if (this.GPr != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.GPr);
      }
      i = paramInt;
      if (this.GPs != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.GPs);
      }
      i += f.a.a.b.b.a.alV(14);
      paramInt = i;
      if (this.skC != null) {
        paramInt = i + f.a.a.a.lB(15, this.skC.computeSize());
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
      if (this.GPu != null) {
        i = paramInt + f.a.a.a.lB(24, this.GPu.computeSize());
      }
      paramInt = i;
      if (this.codec_info != null) {
        paramInt = i + f.a.a.a.lB(25, this.codec_info.computeSize());
      }
      i = paramInt;
      if (this.GPv != null) {
        i = paramInt + f.a.a.b.b.a.e(30, this.GPv);
      }
      paramInt = i;
      if (this.GPw != null) {
        paramInt = i + f.a.a.a.lB(100, this.GPw.computeSize());
      }
      AppMethodBeat.o(169080);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.spec.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(169080);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bvf localbvf = (bvf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169080);
          return -1;
        case 1: 
          localbvf.url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 2: 
          localbvf.thumbUrl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 3: 
          localbvf.mediaType = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169080);
          return 0;
        case 4: 
          localbvf.videoDuration = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169080);
          return 0;
        case 5: 
          localbvf.width = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(169080);
          return 0;
        case 6: 
          localbvf.height = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(169080);
          return 0;
        case 7: 
          localbvf.md5sum = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 8: 
          localbvf.fileSize = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169080);
          return 0;
        case 9: 
          localbvf.bitrate = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169080);
          return 0;
        case 10: 
          localbvf.mediaId = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 11: 
          localbvf.GPq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169080);
          return 0;
        case 12: 
          localbvf.GPr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 13: 
          localbvf.GPs = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 14: 
          localbvf.GPt = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(169080);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvf.skC = ((bvp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvf.spec.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 17: 
          localbvf.coverUrl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 20: 
          localbvf.decodeKey = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 21: 
          localbvf.url_token = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 22: 
          localbvf.thumb_url_token = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 23: 
          localbvf.cover_url_token = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 24: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aan();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aan)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvf.GPu = ((aan)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 25: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvf.codec_info = ((apb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 30: 
          localbvf.GPv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169080);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderMediaReportObject();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderMediaReportObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbvf.GPw = ((FinderMediaReportObject)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvf
 * JD-Core Version:    0.7.0.1
 */