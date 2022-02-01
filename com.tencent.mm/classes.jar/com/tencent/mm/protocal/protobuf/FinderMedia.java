package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderMedia
  extends com.tencent.mm.bx.a
{
  public int bitrate;
  public String coverUrl;
  public String cover_url_token;
  public String decodeKey;
  public int fileSize;
  public float height;
  public String md5sum;
  public int mediaType;
  public LinkedList<ajt> spec;
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
      paramVarArgs.aR(3, this.mediaType);
      paramVarArgs.aR(4, this.videoDuration);
      paramVarArgs.x(5, this.width);
      paramVarArgs.x(6, this.height);
      if (this.md5sum != null) {
        paramVarArgs.d(7, this.md5sum);
      }
      paramVarArgs.aR(8, this.fileSize);
      paramVarArgs.aR(9, this.bitrate);
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
      AppMethodBeat.o(169005);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label1052;
      }
    }
    label1052:
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
      i = paramInt + f.a.a.b.b.a.bA(8, this.fileSize) + f.a.a.b.b.a.bA(9, this.bitrate) + f.a.a.a.c(10, 8, this.spec);
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
      AppMethodBeat.o(169005);
      return paramInt;
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
        AppMethodBeat.o(169005);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        FinderMedia localFinderMedia = (FinderMedia)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169005);
          return -1;
        case 1: 
          localFinderMedia.url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 2: 
          localFinderMedia.thumbUrl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 3: 
          localFinderMedia.mediaType = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169005);
          return 0;
        case 4: 
          localFinderMedia.videoDuration = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169005);
          return 0;
        case 5: 
          localFinderMedia.width = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(169005);
          return 0;
        case 6: 
          localFinderMedia.height = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(169005);
          return 0;
        case 7: 
          localFinderMedia.md5sum = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 8: 
          localFinderMedia.fileSize = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169005);
          return 0;
        case 9: 
          localFinderMedia.bitrate = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169005);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ajt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ajt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localFinderMedia.spec.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169005);
          return 0;
        case 11: 
          localFinderMedia.coverUrl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 12: 
          localFinderMedia.decodeKey = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 13: 
          localFinderMedia.url_token = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169005);
          return 0;
        case 14: 
          localFinderMedia.thumb_url_token = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169005);
          return 0;
        }
        localFinderMedia.cover_url_token = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(169005);
        return 0;
      }
      AppMethodBeat.o(169005);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderMedia
 * JD-Core Version:    0.7.0.1
 */