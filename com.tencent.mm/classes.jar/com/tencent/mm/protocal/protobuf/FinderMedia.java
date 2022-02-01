package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderMedia
  extends com.tencent.mm.bx.a
{
  public int bitrate;
  public apb codec_info;
  public String coverUrl;
  public String cover_url_token;
  public String decodeKey;
  public int fileSize;
  public float height;
  public String md5sum;
  public int mediaType;
  public LinkedList<apc> spec;
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
      paramVarArgs.e(10, 8, this.spec);
      if (this.coverUrl != null) {
        paramVarArgs.d(11, this.coverUrl);
      }
      if (this.decodeKey != null) {
        paramVarArgs.d(12, this.decodeKey);
      }
      if (this.url_token != null) {
        paramVarArgs.d(13, this.url_token);
      }
      if (this.thumb_url_token != null) {
        paramVarArgs.d(14, this.thumb_url_token);
      }
      if (this.cover_url_token != null) {
        paramVarArgs.d(15, this.cover_url_token);
      }
      if (this.codec_info != null)
      {
        paramVarArgs.lC(16, this.codec_info.computeSize());
        this.codec_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169005);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label1204;
      }
    }
    label1204:
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
      i = paramInt + f.a.a.b.b.a.bz(8, this.fileSize) + f.a.a.b.b.a.bz(9, this.bitrate) + f.a.a.a.c(10, 8, this.spec);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.coverUrl);
      }
      i = paramInt;
      if (this.decodeKey != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.decodeKey);
      }
      paramInt = i;
      if (this.url_token != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.url_token);
      }
      i = paramInt;
      if (this.thumb_url_token != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.thumb_url_token);
      }
      paramInt = i;
      if (this.cover_url_token != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.cover_url_token);
      }
      i = paramInt;
      if (this.codec_info != null) {
        i = paramInt + f.a.a.a.lB(16, this.codec_info.computeSize());
      }
      AppMethodBeat.o(169005);
      return i;
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
        AppMethodBeat.o(169005);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        FinderMedia localFinderMedia = (FinderMedia)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169005);
          return -1;
        case 1: 
          localFinderMedia.url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 2: 
          localFinderMedia.thumbUrl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 3: 
          localFinderMedia.mediaType = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169005);
          return 0;
        case 4: 
          localFinderMedia.videoDuration = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169005);
          return 0;
        case 5: 
          localFinderMedia.width = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(169005);
          return 0;
        case 6: 
          localFinderMedia.height = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(169005);
          return 0;
        case 7: 
          localFinderMedia.md5sum = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 8: 
          localFinderMedia.fileSize = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169005);
          return 0;
        case 9: 
          localFinderMedia.bitrate = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169005);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localFinderMedia.spec.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169005);
          return 0;
        case 11: 
          localFinderMedia.coverUrl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 12: 
          localFinderMedia.decodeKey = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 13: 
          localFinderMedia.url_token = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 14: 
          localFinderMedia.thumb_url_token = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 15: 
          localFinderMedia.cover_url_token = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169005);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new apb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((apb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localFinderMedia.codec_info = ((apb)localObject1);
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