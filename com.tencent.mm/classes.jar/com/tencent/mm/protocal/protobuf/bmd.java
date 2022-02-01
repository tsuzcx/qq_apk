package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmd
  extends com.tencent.mm.bx.a
{
  public int DJA;
  public String DJB;
  public String DJC;
  public boolean DJD;
  public FinderMediaReportObject DJE;
  public dxw LzL;
  public String LzM;
  public int bitrate;
  public String coverUrl;
  public String cover_url_token;
  public String decodeKey;
  public int fileSize;
  public float height;
  public String md5sum;
  public String mediaId;
  public int mediaType;
  public bmm qDR;
  public LinkedList<ajt> spec;
  public String thumbUrl;
  public String thumb_url_token;
  public String url;
  public String url_token;
  public int videoDuration;
  public float width;
  
  public bmd()
  {
    AppMethodBeat.i(190570);
    this.spec = new LinkedList();
    AppMethodBeat.o(190570);
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
      paramVarArgs.aR(11, this.DJA);
      if (this.DJB != null) {
        paramVarArgs.d(12, this.DJB);
      }
      if (this.DJC != null) {
        paramVarArgs.d(13, this.DJC);
      }
      paramVarArgs.bg(14, this.DJD);
      if (this.qDR != null)
      {
        paramVarArgs.kX(15, this.qDR.computeSize());
        this.qDR.writeFields(paramVarArgs);
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
      if (this.LzL != null)
      {
        paramVarArgs.kX(24, this.LzL.computeSize());
        this.LzL.writeFields(paramVarArgs);
      }
      if (this.LzM != null) {
        paramVarArgs.d(30, this.LzM);
      }
      if (this.DJE != null)
      {
        paramVarArgs.kX(100, this.DJE.computeSize());
        this.DJE.writeFields(paramVarArgs);
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
      i = i + f.a.a.b.b.a.bA(3, this.mediaType) + f.a.a.b.b.a.bA(4, this.videoDuration) + (f.a.a.b.b.a.fY(5) + 4) + (f.a.a.b.b.a.fY(6) + 4);
      paramInt = i;
      if (this.md5sum != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.md5sum);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.fileSize) + f.a.a.b.b.a.bA(9, this.bitrate);
      paramInt = i;
      if (this.mediaId != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.mediaId);
      }
      i = paramInt + f.a.a.b.b.a.bA(11, this.DJA);
      paramInt = i;
      if (this.DJB != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DJB);
      }
      i = paramInt;
      if (this.DJC != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.DJC);
      }
      i += f.a.a.b.b.a.fY(14) + 1;
      paramInt = i;
      if (this.qDR != null) {
        paramInt = i + f.a.a.a.kW(15, this.qDR.computeSize());
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
      if (this.LzL != null) {
        i = paramInt + f.a.a.a.kW(24, this.LzL.computeSize());
      }
      paramInt = i;
      if (this.LzM != null) {
        paramInt = i + f.a.a.b.b.a.e(30, this.LzM);
      }
      i = paramInt;
      if (this.DJE != null) {
        i = paramInt + f.a.a.a.kW(100, this.DJE.computeSize());
      }
      AppMethodBeat.o(169080);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.spec.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(169080);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bmd localbmd = (bmd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169080);
          return -1;
        case 1: 
          localbmd.url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 2: 
          localbmd.thumbUrl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 3: 
          localbmd.mediaType = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169080);
          return 0;
        case 4: 
          localbmd.videoDuration = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169080);
          return 0;
        case 5: 
          localbmd.width = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(169080);
          return 0;
        case 6: 
          localbmd.height = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(169080);
          return 0;
        case 7: 
          localbmd.md5sum = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 8: 
          localbmd.fileSize = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169080);
          return 0;
        case 9: 
          localbmd.bitrate = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169080);
          return 0;
        case 10: 
          localbmd.mediaId = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 11: 
          localbmd.DJA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169080);
          return 0;
        case 12: 
          localbmd.DJB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 13: 
          localbmd.DJC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 14: 
          localbmd.DJD = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(169080);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmd.qDR = ((bmm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ajt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ajt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmd.spec.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 17: 
          localbmd.coverUrl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 20: 
          localbmd.decodeKey = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 21: 
          localbmd.url_token = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 22: 
          localbmd.thumb_url_token = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 23: 
          localbmd.cover_url_token = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169080);
          return 0;
        case 24: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dxw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dxw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmd.LzL = ((dxw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169080);
          return 0;
        case 30: 
          localbmd.LzM = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169080);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderMediaReportObject();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderMediaReportObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbmd.DJE = ((FinderMediaReportObject)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmd
 * JD-Core Version:    0.7.0.1
 */