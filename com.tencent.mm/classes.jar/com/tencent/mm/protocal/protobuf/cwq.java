package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwq
  extends com.tencent.mm.cd.a
{
  public String MSC;
  public int TFq;
  public long TFr;
  public String TFs;
  public awe TFt;
  public bec TFu;
  public int bitrate;
  public String coverUrl;
  public String decodeKey;
  public int fileSize;
  public String full_thumb_url;
  public String full_thumb_url_token;
  public awc half_rect;
  public float height;
  public int hot_flag;
  public String md5sum;
  public int mediaType;
  public LinkedList<cwr> spec;
  public String thumbUrl;
  public String url;
  public float width;
  public String zZu;
  
  public cwq()
  {
    AppMethodBeat.i(204230);
    this.spec = new LinkedList();
    AppMethodBeat.o(204230);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(204235);
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
      paramVarArgs.aY(4, this.TFq);
      paramVarArgs.i(5, this.width);
      paramVarArgs.i(6, this.height);
      if (this.md5sum != null) {
        paramVarArgs.f(7, this.md5sum);
      }
      paramVarArgs.aY(8, this.fileSize);
      paramVarArgs.aY(9, this.bitrate);
      if (this.decodeKey != null) {
        paramVarArgs.f(10, this.decodeKey);
      }
      if (this.coverUrl != null) {
        paramVarArgs.f(11, this.coverUrl);
      }
      paramVarArgs.bm(12, this.TFr);
      if (this.zZu != null) {
        paramVarArgs.f(13, this.zZu);
      }
      if (this.MSC != null) {
        paramVarArgs.f(14, this.MSC);
      }
      if (this.TFs != null) {
        paramVarArgs.f(15, this.TFs);
      }
      paramVarArgs.e(16, 8, this.spec);
      if (this.TFt != null)
      {
        paramVarArgs.oE(17, this.TFt.computeSize());
        this.TFt.writeFields(paramVarArgs);
      }
      if (this.TFu != null)
      {
        paramVarArgs.oE(18, this.TFu.computeSize());
        this.TFu.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(19, this.hot_flag);
      if (this.half_rect != null)
      {
        paramVarArgs.oE(20, this.half_rect.computeSize());
        this.half_rect.writeFields(paramVarArgs);
      }
      if (this.full_thumb_url != null) {
        paramVarArgs.f(21, this.full_thumb_url);
      }
      if (this.full_thumb_url_token != null) {
        paramVarArgs.f(22, this.full_thumb_url_token);
      }
      AppMethodBeat.o(204235);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label1652;
      }
    }
    label1652:
    for (paramInt = g.a.a.b.b.a.g(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.thumbUrl);
      }
      i = i + g.a.a.b.b.a.bM(3, this.mediaType) + g.a.a.b.b.a.bM(4, this.TFq) + (g.a.a.b.b.a.gL(5) + 4) + (g.a.a.b.b.a.gL(6) + 4);
      paramInt = i;
      if (this.md5sum != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.md5sum);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.fileSize) + g.a.a.b.b.a.bM(9, this.bitrate);
      paramInt = i;
      if (this.decodeKey != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.decodeKey);
      }
      i = paramInt;
      if (this.coverUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.coverUrl);
      }
      i += g.a.a.b.b.a.p(12, this.TFr);
      paramInt = i;
      if (this.zZu != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.zZu);
      }
      i = paramInt;
      if (this.MSC != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.MSC);
      }
      paramInt = i;
      if (this.TFs != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.TFs);
      }
      i = paramInt + g.a.a.a.c(16, 8, this.spec);
      paramInt = i;
      if (this.TFt != null) {
        paramInt = i + g.a.a.a.oD(17, this.TFt.computeSize());
      }
      i = paramInt;
      if (this.TFu != null) {
        i = paramInt + g.a.a.a.oD(18, this.TFu.computeSize());
      }
      i += g.a.a.b.b.a.bM(19, this.hot_flag);
      paramInt = i;
      if (this.half_rect != null) {
        paramInt = i + g.a.a.a.oD(20, this.half_rect.computeSize());
      }
      i = paramInt;
      if (this.full_thumb_url != null) {
        i = paramInt + g.a.a.b.b.a.g(21, this.full_thumb_url);
      }
      paramInt = i;
      if (this.full_thumb_url_token != null) {
        paramInt = i + g.a.a.b.b.a.g(22, this.full_thumb_url_token);
      }
      AppMethodBeat.o(204235);
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
        AppMethodBeat.o(204235);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cwq localcwq = (cwq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(204235);
          return -1;
        case 1: 
          localcwq.url = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(204235);
          return 0;
        case 2: 
          localcwq.thumbUrl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(204235);
          return 0;
        case 3: 
          localcwq.mediaType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(204235);
          return 0;
        case 4: 
          localcwq.TFq = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(204235);
          return 0;
        case 5: 
          localcwq.width = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(204235);
          return 0;
        case 6: 
          localcwq.height = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(204235);
          return 0;
        case 7: 
          localcwq.md5sum = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(204235);
          return 0;
        case 8: 
          localcwq.fileSize = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(204235);
          return 0;
        case 9: 
          localcwq.bitrate = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(204235);
          return 0;
        case 10: 
          localcwq.decodeKey = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(204235);
          return 0;
        case 11: 
          localcwq.coverUrl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(204235);
          return 0;
        case 12: 
          localcwq.TFr = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(204235);
          return 0;
        case 13: 
          localcwq.zZu = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(204235);
          return 0;
        case 14: 
          localcwq.MSC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(204235);
          return 0;
        case 15: 
          localcwq.TFs = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(204235);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cwr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cwr)localObject2).parseFrom((byte[])localObject1);
            }
            localcwq.spec.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(204235);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new awe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((awe)localObject2).parseFrom((byte[])localObject1);
            }
            localcwq.TFt = ((awe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(204235);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bec();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bec)localObject2).parseFrom((byte[])localObject1);
            }
            localcwq.TFu = ((bec)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(204235);
          return 0;
        case 19: 
          localcwq.hot_flag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(204235);
          return 0;
        case 20: 
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
            localcwq.half_rect = ((awc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(204235);
          return 0;
        case 21: 
          localcwq.full_thumb_url = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(204235);
          return 0;
        }
        localcwq.full_thumb_url_token = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(204235);
        return 0;
      }
      AppMethodBeat.o(204235);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwq
 * JD-Core Version:    0.7.0.1
 */