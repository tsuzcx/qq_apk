package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class TextStatusExtInfo
  extends com.tencent.mm.cd.a
{
  public String backgroundId;
  public int createTime;
  public String description;
  public TextStatusEmojiInfo emojiInfo;
  public int expireTime;
  public double latitude;
  public double longitude;
  public String mediaAesKey;
  public int mediaHeight;
  public String mediaThumbAesKey;
  public String mediaThumbUrl;
  public int mediaType;
  public String mediaUrl;
  public int mediaWidth;
  public int modifyCount;
  public int modifyTime;
  public long option;
  public String poiId;
  public String poiName;
  public String referenceTextStatusId;
  public String referenceUsername;
  public int sceneType;
  public int serverCreateTime;
  public TextStatusTopicInfo topicInfo;
  public int visibility;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243613);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.longitude);
      paramVarArgs.e(2, this.latitude);
      paramVarArgs.aY(3, this.mediaType);
      if (this.topicInfo != null)
      {
        paramVarArgs.oE(4, this.topicInfo.computeSize());
        this.topicInfo.writeFields(paramVarArgs);
      }
      if (this.mediaUrl != null) {
        paramVarArgs.f(5, this.mediaUrl);
      }
      if (this.mediaAesKey != null) {
        paramVarArgs.f(6, this.mediaAesKey);
      }
      if (this.mediaThumbUrl != null) {
        paramVarArgs.f(7, this.mediaThumbUrl);
      }
      if (this.mediaThumbAesKey != null) {
        paramVarArgs.f(8, this.mediaThumbAesKey);
      }
      paramVarArgs.aY(9, this.visibility);
      if (this.description != null) {
        paramVarArgs.f(10, this.description);
      }
      paramVarArgs.aY(11, this.createTime);
      paramVarArgs.aY(12, this.expireTime);
      if (this.poiId != null) {
        paramVarArgs.f(13, this.poiId);
      }
      if (this.poiName != null) {
        paramVarArgs.f(14, this.poiName);
      }
      paramVarArgs.bm(15, this.option);
      paramVarArgs.aY(16, this.mediaWidth);
      paramVarArgs.aY(17, this.mediaHeight);
      if (this.backgroundId != null) {
        paramVarArgs.f(18, this.backgroundId);
      }
      if (this.emojiInfo != null)
      {
        paramVarArgs.oE(20, this.emojiInfo.computeSize());
        this.emojiInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(21, this.modifyTime);
      paramVarArgs.aY(22, this.modifyCount);
      paramVarArgs.aY(23, this.serverCreateTime);
      if (this.referenceUsername != null) {
        paramVarArgs.f(24, this.referenceUsername);
      }
      if (this.referenceTextStatusId != null) {
        paramVarArgs.f(25, this.referenceTextStatusId);
      }
      paramVarArgs.aY(26, this.sceneType);
      AppMethodBeat.o(243613);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.gL(1) + 8 + 0 + (g.a.a.b.b.a.gL(2) + 8) + g.a.a.b.b.a.bM(3, this.mediaType);
      paramInt = i;
      if (this.topicInfo != null) {
        paramInt = i + g.a.a.a.oD(4, this.topicInfo.computeSize());
      }
      i = paramInt;
      if (this.mediaUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.mediaUrl);
      }
      paramInt = i;
      if (this.mediaAesKey != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.mediaAesKey);
      }
      i = paramInt;
      if (this.mediaThumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.mediaThumbUrl);
      }
      paramInt = i;
      if (this.mediaThumbAesKey != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.mediaThumbAesKey);
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.visibility);
      paramInt = i;
      if (this.description != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.description);
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.createTime) + g.a.a.b.b.a.bM(12, this.expireTime);
      paramInt = i;
      if (this.poiId != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.poiId);
      }
      i = paramInt;
      if (this.poiName != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.poiName);
      }
      i = i + g.a.a.b.b.a.p(15, this.option) + g.a.a.b.b.a.bM(16, this.mediaWidth) + g.a.a.b.b.a.bM(17, this.mediaHeight);
      paramInt = i;
      if (this.backgroundId != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.backgroundId);
      }
      i = paramInt;
      if (this.emojiInfo != null) {
        i = paramInt + g.a.a.a.oD(20, this.emojiInfo.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(21, this.modifyTime) + g.a.a.b.b.a.bM(22, this.modifyCount) + g.a.a.b.b.a.bM(23, this.serverCreateTime);
      paramInt = i;
      if (this.referenceUsername != null) {
        paramInt = i + g.a.a.b.b.a.g(24, this.referenceUsername);
      }
      i = paramInt;
      if (this.referenceTextStatusId != null) {
        i = paramInt + g.a.a.b.b.a.g(25, this.referenceTextStatusId);
      }
      paramInt = g.a.a.b.b.a.bM(26, this.sceneType);
      AppMethodBeat.o(243613);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(243613);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      TextStatusExtInfo localTextStatusExtInfo = (TextStatusExtInfo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      case 19: 
      default: 
        AppMethodBeat.o(243613);
        return -1;
      case 1: 
        localTextStatusExtInfo.longitude = Double.longBitsToDouble(((g.a.a.a.a)localObject1).abFh.AP());
        AppMethodBeat.o(243613);
        return 0;
      case 2: 
        localTextStatusExtInfo.latitude = Double.longBitsToDouble(((g.a.a.a.a)localObject1).abFh.AP());
        AppMethodBeat.o(243613);
        return 0;
      case 3: 
        localTextStatusExtInfo.mediaType = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(243613);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new TextStatusTopicInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((TextStatusTopicInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localTextStatusExtInfo.topicInfo = ((TextStatusTopicInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(243613);
        return 0;
      case 5: 
        localTextStatusExtInfo.mediaUrl = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(243613);
        return 0;
      case 6: 
        localTextStatusExtInfo.mediaAesKey = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(243613);
        return 0;
      case 7: 
        localTextStatusExtInfo.mediaThumbUrl = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(243613);
        return 0;
      case 8: 
        localTextStatusExtInfo.mediaThumbAesKey = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(243613);
        return 0;
      case 9: 
        localTextStatusExtInfo.visibility = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(243613);
        return 0;
      case 10: 
        localTextStatusExtInfo.description = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(243613);
        return 0;
      case 11: 
        localTextStatusExtInfo.createTime = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(243613);
        return 0;
      case 12: 
        localTextStatusExtInfo.expireTime = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(243613);
        return 0;
      case 13: 
        localTextStatusExtInfo.poiId = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(243613);
        return 0;
      case 14: 
        localTextStatusExtInfo.poiName = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(243613);
        return 0;
      case 15: 
        localTextStatusExtInfo.option = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(243613);
        return 0;
      case 16: 
        localTextStatusExtInfo.mediaWidth = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(243613);
        return 0;
      case 17: 
        localTextStatusExtInfo.mediaHeight = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(243613);
        return 0;
      case 18: 
        localTextStatusExtInfo.backgroundId = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(243613);
        return 0;
      case 20: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new TextStatusEmojiInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((TextStatusEmojiInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localTextStatusExtInfo.emojiInfo = ((TextStatusEmojiInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(243613);
        return 0;
      case 21: 
        localTextStatusExtInfo.modifyTime = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(243613);
        return 0;
      case 22: 
        localTextStatusExtInfo.modifyCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(243613);
        return 0;
      case 23: 
        localTextStatusExtInfo.serverCreateTime = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(243613);
        return 0;
      case 24: 
        localTextStatusExtInfo.referenceUsername = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(243613);
        return 0;
      case 25: 
        localTextStatusExtInfo.referenceTextStatusId = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(243613);
        return 0;
      }
      localTextStatusExtInfo.sceneType = ((g.a.a.a.a)localObject1).abFh.AK();
      AppMethodBeat.o(243613);
      return 0;
    }
    AppMethodBeat.o(243613);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo
 * JD-Core Version:    0.7.0.1
 */