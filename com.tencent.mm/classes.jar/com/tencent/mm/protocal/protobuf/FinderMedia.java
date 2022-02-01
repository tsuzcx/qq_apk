package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderMedia
  extends com.tencent.mm.cd.a
{
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
  public String full_thumb_url;
  public String full_thumb_url_token;
  public String full_url;
  public float full_width;
  public awc half_rect;
  public float height;
  public awe hls_spec;
  public int hot_flag;
  public bar live_spec;
  public String md5sum;
  public int mediaType;
  public LinkedList<beb> spec;
  public String thumbUrl;
  public String thumb_url_token;
  public String url;
  public String url_token;
  public int videoDuration;
  public float width;
  
  public FinderMedia()
  {
    AppMethodBeat.i(184202);
    this.spec = new LinkedList();
    AppMethodBeat.o(184202);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169005);
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
      paramVarArgs.e(10, 8, this.spec);
      if (this.coverUrl != null) {
        paramVarArgs.f(11, this.coverUrl);
      }
      if (this.decodeKey != null) {
        paramVarArgs.f(12, this.decodeKey);
      }
      if (this.url_token != null) {
        paramVarArgs.f(13, this.url_token);
      }
      if (this.thumb_url_token != null) {
        paramVarArgs.f(14, this.thumb_url_token);
      }
      if (this.cover_url_token != null) {
        paramVarArgs.f(15, this.cover_url_token);
      }
      if (this.codec_info != null)
      {
        paramVarArgs.oE(16, this.codec_info.computeSize());
        this.codec_info.writeFields(paramVarArgs);
      }
      if (this.live_spec != null)
      {
        paramVarArgs.oE(17, this.live_spec.computeSize());
        this.live_spec.writeFields(paramVarArgs);
      }
      if (this.hls_spec != null)
      {
        paramVarArgs.oE(18, this.hls_spec.computeSize());
        this.hls_spec.writeFields(paramVarArgs);
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
      if (this.full_url != null) {
        paramVarArgs.f(23, this.full_url);
      }
      paramVarArgs.i(24, this.full_width);
      paramVarArgs.i(25, this.full_height);
      if (this.full_md5sum != null) {
        paramVarArgs.f(26, this.full_md5sum);
      }
      paramVarArgs.aY(27, this.full_file_size);
      paramVarArgs.aY(28, this.full_bitrate);
      AppMethodBeat.o(169005);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label2048;
      }
    }
    label2048:
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
      i = paramInt + g.a.a.b.b.a.bM(8, this.fileSize) + g.a.a.b.b.a.bM(9, this.bitrate) + g.a.a.a.c(10, 8, this.spec);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.coverUrl);
      }
      i = paramInt;
      if (this.decodeKey != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.decodeKey);
      }
      paramInt = i;
      if (this.url_token != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.url_token);
      }
      i = paramInt;
      if (this.thumb_url_token != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.thumb_url_token);
      }
      paramInt = i;
      if (this.cover_url_token != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.cover_url_token);
      }
      i = paramInt;
      if (this.codec_info != null) {
        i = paramInt + g.a.a.a.oD(16, this.codec_info.computeSize());
      }
      paramInt = i;
      if (this.live_spec != null) {
        paramInt = i + g.a.a.a.oD(17, this.live_spec.computeSize());
      }
      i = paramInt;
      if (this.hls_spec != null) {
        i = paramInt + g.a.a.a.oD(18, this.hls_spec.computeSize());
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
      i = paramInt;
      if (this.full_url != null) {
        i = paramInt + g.a.a.b.b.a.g(23, this.full_url);
      }
      i = i + (g.a.a.b.b.a.gL(24) + 4) + (g.a.a.b.b.a.gL(25) + 4);
      paramInt = i;
      if (this.full_md5sum != null) {
        paramInt = i + g.a.a.b.b.a.g(26, this.full_md5sum);
      }
      i = g.a.a.b.b.a.bM(27, this.full_file_size);
      int j = g.a.a.b.b.a.bM(28, this.full_bitrate);
      AppMethodBeat.o(169005);
      return paramInt + i + j;
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
        AppMethodBeat.o(169005);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        FinderMedia localFinderMedia = (FinderMedia)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169005);
          return -1;
        case 1: 
          localFinderMedia.url = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 2: 
          localFinderMedia.thumbUrl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 3: 
          localFinderMedia.mediaType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169005);
          return 0;
        case 4: 
          localFinderMedia.videoDuration = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169005);
          return 0;
        case 5: 
          localFinderMedia.width = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(169005);
          return 0;
        case 6: 
          localFinderMedia.height = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(169005);
          return 0;
        case 7: 
          localFinderMedia.md5sum = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 8: 
          localFinderMedia.fileSize = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169005);
          return 0;
        case 9: 
          localFinderMedia.bitrate = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169005);
          return 0;
        case 10: 
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
            localFinderMedia.spec.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169005);
          return 0;
        case 11: 
          localFinderMedia.coverUrl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 12: 
          localFinderMedia.decodeKey = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 13: 
          localFinderMedia.url_token = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 14: 
          localFinderMedia.thumb_url_token = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 15: 
          localFinderMedia.cover_url_token = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 16: 
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
            localFinderMedia.codec_info = ((bea)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169005);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bar();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bar)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderMedia.live_spec = ((bar)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169005);
          return 0;
        case 18: 
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
            localFinderMedia.hls_spec = ((awe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169005);
          return 0;
        case 19: 
          localFinderMedia.hot_flag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169005);
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
            localFinderMedia.half_rect = ((awc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169005);
          return 0;
        case 21: 
          localFinderMedia.full_thumb_url = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 22: 
          localFinderMedia.full_thumb_url_token = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 23: 
          localFinderMedia.full_url = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 24: 
          localFinderMedia.full_width = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(169005);
          return 0;
        case 25: 
          localFinderMedia.full_height = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(169005);
          return 0;
        case 26: 
          localFinderMedia.full_md5sum = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 27: 
          localFinderMedia.full_file_size = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169005);
          return 0;
        }
        localFinderMedia.full_bitrate = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169005);
        return 0;
      }
      AppMethodBeat.o(169005);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderMedia
 * JD-Core Version:    0.7.0.1
 */