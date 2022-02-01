package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bqs
  extends com.tencent.mm.bw.a
{
  public int FfM;
  public String FfN;
  public String FfO;
  public boolean FfP;
  public yo FfQ;
  public String FfR;
  public FinderMediaReportObject FfS;
  public int bitrate;
  public String coverUrl;
  public String cover_url_token;
  public String decodeKey;
  public int fileSize;
  public float height;
  public String md5sum;
  public String mediaId;
  public int mediaType;
  public brc rvh;
  public LinkedList<alw> spec;
  public String thumbUrl;
  public String thumb_url_token;
  public String url;
  public String url_token;
  public int videoDuration;
  public float width;
  
  public bqs()
  {
    AppMethodBeat.i(195126);
    this.spec = new LinkedList();
    AppMethodBeat.o(195126);
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
      paramVarArgs.aR(3, this.mediaType);
      paramVarArgs.aR(4, this.videoDuration);
      paramVarArgs.x(5, this.width);
      paramVarArgs.x(6, this.height);
      if (this.md5sum != null) {
        paramVarArgs.d(7, this.md5sum);
      }
      paramVarArgs.aR(8, this.fileSize);
      paramVarArgs.aR(9, this.bitrate);
      if (this.mediaId != null) {
        paramVarArgs.d(10, this.mediaId);
      }
      paramVarArgs.aR(11, this.FfM);
      if (this.FfN != null) {
        paramVarArgs.d(12, this.FfN);
      }
      if (this.FfO != null) {
        paramVarArgs.d(13, this.FfO);
      }
      paramVarArgs.bl(14, this.FfP);
      if (this.rvh != null)
      {
        paramVarArgs.ln(15, this.rvh.computeSize());
        this.rvh.writeFields(paramVarArgs);
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
      if (this.FfQ != null)
      {
        paramVarArgs.ln(24, this.FfQ.computeSize());
        this.FfQ.writeFields(paramVarArgs);
      }
      if (this.FfR != null) {
        paramVarArgs.d(30, this.FfR);
      }
      if (this.FfS != null)
      {
        paramVarArgs.ln(100, this.FfS.computeSize());
        this.FfS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169080);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label1952;
      }
    }
    label1952:
    for (paramInt = f.a.a.b.b.a.e(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.thumbUrl);
      }
      i = i + f.a.a.b.b.a.bx(3, this.mediaType) + f.a.a.b.b.a.bx(4, this.videoDuration) + (f.a.a.b.b.a.fK(5) + 4) + (f.a.a.b.b.a.fK(6) + 4);
      paramInt = i;
      if (this.md5sum != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.md5sum);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.fileSize) + f.a.a.b.b.a.bx(9, this.bitrate);
      paramInt = i;
      if (this.mediaId != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.mediaId);
      }
      i = paramInt + f.a.a.b.b.a.bx(11, this.FfM);
      paramInt = i;
      if (this.FfN != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FfN);
      }
      i = paramInt;
      if (this.FfO != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.FfO);
      }
      i += f.a.a.b.b.a.fK(14) + 1;
      paramInt = i;
      if (this.rvh != null) {
        paramInt = i + f.a.a.a.lm(15, this.rvh.computeSize());
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
      if (this.FfQ != null) {
        i = paramInt + f.a.a.a.lm(24, this.FfQ.computeSize());
      }
      paramInt = i;
      if (this.FfR != null) {
        paramInt = i + f.a.a.b.b.a.e(30, this.FfR);
      }
      i = paramInt;
      if (this.FfS != null) {
        i = paramInt + f.a.a.a.lm(100, this.FfS.computeSize());
      }
      AppMethodBeat.o(169080);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.spec.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(169080);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bqs localbqs = (bqs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169080);
          return -1;
        case 1: 
          localbqs.url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 2: 
          localbqs.thumbUrl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 3: 
          localbqs.mediaType = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169080);
          return 0;
        case 4: 
          localbqs.videoDuration = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169080);
          return 0;
        case 5: 
          localbqs.width = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(169080);
          return 0;
        case 6: 
          localbqs.height = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(169080);
          return 0;
        case 7: 
          localbqs.md5sum = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 8: 
          localbqs.fileSize = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169080);
          return 0;
        case 9: 
          localbqs.bitrate = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169080);
          return 0;
        case 10: 
          localbqs.mediaId = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 11: 
          localbqs.FfM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169080);
          return 0;
        case 12: 
          localbqs.FfN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 13: 
          localbqs.FfO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 14: 
          localbqs.FfP = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(169080);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new brc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((brc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqs.rvh = ((brc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqs.spec.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 17: 
          localbqs.coverUrl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 20: 
          localbqs.decodeKey = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 21: 
          localbqs.url_token = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 22: 
          localbqs.thumb_url_token = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 23: 
          localbqs.cover_url_token = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 24: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqs.FfQ = ((yo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 30: 
          localbqs.FfR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169080);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderMediaReportObject();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderMediaReportObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbqs.FfS = ((FinderMediaReportObject)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqs
 * JD-Core Version:    0.7.0.1
 */