package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderMedia
  extends com.tencent.mm.bx.a
{
  public int bitrate;
  public boy codec_info;
  public String coverUrl;
  public String cover_url_token;
  public String decodeKey;
  public int fileSize;
  public int full_bitrate;
  public String full_cover_url;
  public String full_cover_url_token;
  public int full_file_size;
  public float full_height;
  public String full_md5sum;
  public String full_thumb_url;
  public String full_thumb_url_token;
  public String full_url;
  public String full_url_token;
  public float full_width;
  public bbn half_rect;
  public bbo hdr_spec;
  public float height;
  public bbq hls_spec;
  public int hot_flag;
  public bjj live_spec;
  public String md5sum;
  public int mediaType;
  public LinkedList<boz> spec;
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
      paramVarArgs.e(10, 8, this.spec);
      if (this.coverUrl != null) {
        paramVarArgs.g(11, this.coverUrl);
      }
      if (this.decodeKey != null) {
        paramVarArgs.g(12, this.decodeKey);
      }
      if (this.url_token != null) {
        paramVarArgs.g(13, this.url_token);
      }
      if (this.thumb_url_token != null) {
        paramVarArgs.g(14, this.thumb_url_token);
      }
      if (this.cover_url_token != null) {
        paramVarArgs.g(15, this.cover_url_token);
      }
      if (this.codec_info != null)
      {
        paramVarArgs.qD(16, this.codec_info.computeSize());
        this.codec_info.writeFields(paramVarArgs);
      }
      if (this.live_spec != null)
      {
        paramVarArgs.qD(17, this.live_spec.computeSize());
        this.live_spec.writeFields(paramVarArgs);
      }
      if (this.hls_spec != null)
      {
        paramVarArgs.qD(18, this.hls_spec.computeSize());
        this.hls_spec.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(19, this.hot_flag);
      if (this.half_rect != null)
      {
        paramVarArgs.qD(20, this.half_rect.computeSize());
        this.half_rect.writeFields(paramVarArgs);
      }
      if (this.full_thumb_url != null) {
        paramVarArgs.g(21, this.full_thumb_url);
      }
      if (this.full_thumb_url_token != null) {
        paramVarArgs.g(22, this.full_thumb_url_token);
      }
      if (this.full_url != null) {
        paramVarArgs.g(23, this.full_url);
      }
      paramVarArgs.l(24, this.full_width);
      paramVarArgs.l(25, this.full_height);
      if (this.full_md5sum != null) {
        paramVarArgs.g(26, this.full_md5sum);
      }
      paramVarArgs.bS(27, this.full_file_size);
      paramVarArgs.bS(28, this.full_bitrate);
      if (this.full_url_token != null) {
        paramVarArgs.g(29, this.full_url_token);
      }
      if (this.full_cover_url != null) {
        paramVarArgs.g(30, this.full_cover_url);
      }
      if (this.full_cover_url_token != null) {
        paramVarArgs.g(31, this.full_cover_url_token);
      }
      if (this.hdr_spec != null)
      {
        paramVarArgs.qD(32, this.hdr_spec.computeSize());
        this.hdr_spec.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169005);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label2362;
      }
    }
    label2362:
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
      i = paramInt + i.a.a.b.b.a.cJ(8, this.fileSize) + i.a.a.b.b.a.cJ(9, this.bitrate) + i.a.a.a.c(10, 8, this.spec);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.coverUrl);
      }
      i = paramInt;
      if (this.decodeKey != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.decodeKey);
      }
      paramInt = i;
      if (this.url_token != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.url_token);
      }
      i = paramInt;
      if (this.thumb_url_token != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.thumb_url_token);
      }
      paramInt = i;
      if (this.cover_url_token != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.cover_url_token);
      }
      i = paramInt;
      if (this.codec_info != null) {
        i = paramInt + i.a.a.a.qC(16, this.codec_info.computeSize());
      }
      paramInt = i;
      if (this.live_spec != null) {
        paramInt = i + i.a.a.a.qC(17, this.live_spec.computeSize());
      }
      i = paramInt;
      if (this.hls_spec != null) {
        i = paramInt + i.a.a.a.qC(18, this.hls_spec.computeSize());
      }
      i += i.a.a.b.b.a.cJ(19, this.hot_flag);
      paramInt = i;
      if (this.half_rect != null) {
        paramInt = i + i.a.a.a.qC(20, this.half_rect.computeSize());
      }
      i = paramInt;
      if (this.full_thumb_url != null) {
        i = paramInt + i.a.a.b.b.a.h(21, this.full_thumb_url);
      }
      paramInt = i;
      if (this.full_thumb_url_token != null) {
        paramInt = i + i.a.a.b.b.a.h(22, this.full_thumb_url_token);
      }
      i = paramInt;
      if (this.full_url != null) {
        i = paramInt + i.a.a.b.b.a.h(23, this.full_url);
      }
      i = i + (i.a.a.b.b.a.ko(24) + 4) + (i.a.a.b.b.a.ko(25) + 4);
      paramInt = i;
      if (this.full_md5sum != null) {
        paramInt = i + i.a.a.b.b.a.h(26, this.full_md5sum);
      }
      i = paramInt + i.a.a.b.b.a.cJ(27, this.full_file_size) + i.a.a.b.b.a.cJ(28, this.full_bitrate);
      paramInt = i;
      if (this.full_url_token != null) {
        paramInt = i + i.a.a.b.b.a.h(29, this.full_url_token);
      }
      i = paramInt;
      if (this.full_cover_url != null) {
        i = paramInt + i.a.a.b.b.a.h(30, this.full_cover_url);
      }
      paramInt = i;
      if (this.full_cover_url_token != null) {
        paramInt = i + i.a.a.b.b.a.h(31, this.full_cover_url_token);
      }
      i = paramInt;
      if (this.hdr_spec != null) {
        i = paramInt + i.a.a.a.qC(32, this.hdr_spec.computeSize());
      }
      AppMethodBeat.o(169005);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.spec.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169005);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        FinderMedia localFinderMedia = (FinderMedia)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169005);
          return -1;
        case 1: 
          localFinderMedia.url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 2: 
          localFinderMedia.thumbUrl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 3: 
          localFinderMedia.mediaType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169005);
          return 0;
        case 4: 
          localFinderMedia.videoDuration = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169005);
          return 0;
        case 5: 
          localFinderMedia.width = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(169005);
          return 0;
        case 6: 
          localFinderMedia.height = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(169005);
          return 0;
        case 7: 
          localFinderMedia.md5sum = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 8: 
          localFinderMedia.fileSize = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169005);
          return 0;
        case 9: 
          localFinderMedia.bitrate = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169005);
          return 0;
        case 10: 
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
            localFinderMedia.spec.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169005);
          return 0;
        case 11: 
          localFinderMedia.coverUrl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 12: 
          localFinderMedia.decodeKey = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 13: 
          localFinderMedia.url_token = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 14: 
          localFinderMedia.thumb_url_token = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 15: 
          localFinderMedia.cover_url_token = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 16: 
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
            localFinderMedia.codec_info = ((boy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169005);
          return 0;
        case 17: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bjj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bjj)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderMedia.live_spec = ((bjj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169005);
          return 0;
        case 18: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bbq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bbq)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderMedia.hls_spec = ((bbq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169005);
          return 0;
        case 19: 
          localFinderMedia.hot_flag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169005);
          return 0;
        case 20: 
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
            localFinderMedia.half_rect = ((bbn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169005);
          return 0;
        case 21: 
          localFinderMedia.full_thumb_url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 22: 
          localFinderMedia.full_thumb_url_token = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 23: 
          localFinderMedia.full_url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 24: 
          localFinderMedia.full_width = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(169005);
          return 0;
        case 25: 
          localFinderMedia.full_height = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(169005);
          return 0;
        case 26: 
          localFinderMedia.full_md5sum = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 27: 
          localFinderMedia.full_file_size = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169005);
          return 0;
        case 28: 
          localFinderMedia.full_bitrate = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169005);
          return 0;
        case 29: 
          localFinderMedia.full_url_token = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 30: 
          localFinderMedia.full_cover_url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 31: 
          localFinderMedia.full_cover_url_token = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169005);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bbo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bbo)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderMedia.hdr_spec = ((bbo)localObject2);
          paramInt += 1;
        }
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