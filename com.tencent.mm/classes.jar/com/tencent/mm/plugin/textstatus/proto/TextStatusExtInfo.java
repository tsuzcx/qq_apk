package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class TextStatusExtInfo
  extends com.tencent.mm.bx.a
{
  public String backgroundId;
  public String brand_key_info;
  public int createTime;
  public String description;
  public String duplicateTextStatusId;
  public String duplicateUsername;
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
    AppMethodBeat.i(290088);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, this.longitude);
      paramVarArgs.d(2, this.latitude);
      paramVarArgs.bS(3, this.mediaType);
      if (this.topicInfo != null)
      {
        paramVarArgs.qD(4, this.topicInfo.computeSize());
        this.topicInfo.writeFields(paramVarArgs);
      }
      if (this.mediaUrl != null) {
        paramVarArgs.g(5, this.mediaUrl);
      }
      if (this.mediaAesKey != null) {
        paramVarArgs.g(6, this.mediaAesKey);
      }
      if (this.mediaThumbUrl != null) {
        paramVarArgs.g(7, this.mediaThumbUrl);
      }
      if (this.mediaThumbAesKey != null) {
        paramVarArgs.g(8, this.mediaThumbAesKey);
      }
      paramVarArgs.bS(9, this.visibility);
      if (this.description != null) {
        paramVarArgs.g(10, this.description);
      }
      paramVarArgs.bS(11, this.createTime);
      paramVarArgs.bS(12, this.expireTime);
      if (this.poiId != null) {
        paramVarArgs.g(13, this.poiId);
      }
      if (this.poiName != null) {
        paramVarArgs.g(14, this.poiName);
      }
      paramVarArgs.bv(15, this.option);
      paramVarArgs.bS(16, this.mediaWidth);
      paramVarArgs.bS(17, this.mediaHeight);
      if (this.backgroundId != null) {
        paramVarArgs.g(18, this.backgroundId);
      }
      if (this.emojiInfo != null)
      {
        paramVarArgs.qD(20, this.emojiInfo.computeSize());
        this.emojiInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(21, this.modifyTime);
      paramVarArgs.bS(22, this.modifyCount);
      paramVarArgs.bS(23, this.serverCreateTime);
      if (this.referenceUsername != null) {
        paramVarArgs.g(24, this.referenceUsername);
      }
      if (this.referenceTextStatusId != null) {
        paramVarArgs.g(25, this.referenceTextStatusId);
      }
      paramVarArgs.bS(26, this.sceneType);
      if (this.duplicateUsername != null) {
        paramVarArgs.g(27, this.duplicateUsername);
      }
      if (this.duplicateTextStatusId != null) {
        paramVarArgs.g(28, this.duplicateTextStatusId);
      }
      if (this.brand_key_info != null) {
        paramVarArgs.g(29, this.brand_key_info);
      }
      AppMethodBeat.o(290088);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.ko(1) + 8 + 0 + (i.a.a.b.b.a.ko(2) + 8) + i.a.a.b.b.a.cJ(3, this.mediaType);
      paramInt = i;
      if (this.topicInfo != null) {
        paramInt = i + i.a.a.a.qC(4, this.topicInfo.computeSize());
      }
      i = paramInt;
      if (this.mediaUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.mediaUrl);
      }
      paramInt = i;
      if (this.mediaAesKey != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.mediaAesKey);
      }
      i = paramInt;
      if (this.mediaThumbUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.mediaThumbUrl);
      }
      paramInt = i;
      if (this.mediaThumbAesKey != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.mediaThumbAesKey);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.visibility);
      paramInt = i;
      if (this.description != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.description);
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.createTime) + i.a.a.b.b.a.cJ(12, this.expireTime);
      paramInt = i;
      if (this.poiId != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.poiId);
      }
      i = paramInt;
      if (this.poiName != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.poiName);
      }
      i = i + i.a.a.b.b.a.q(15, this.option) + i.a.a.b.b.a.cJ(16, this.mediaWidth) + i.a.a.b.b.a.cJ(17, this.mediaHeight);
      paramInt = i;
      if (this.backgroundId != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.backgroundId);
      }
      i = paramInt;
      if (this.emojiInfo != null) {
        i = paramInt + i.a.a.a.qC(20, this.emojiInfo.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(21, this.modifyTime) + i.a.a.b.b.a.cJ(22, this.modifyCount) + i.a.a.b.b.a.cJ(23, this.serverCreateTime);
      paramInt = i;
      if (this.referenceUsername != null) {
        paramInt = i + i.a.a.b.b.a.h(24, this.referenceUsername);
      }
      i = paramInt;
      if (this.referenceTextStatusId != null) {
        i = paramInt + i.a.a.b.b.a.h(25, this.referenceTextStatusId);
      }
      i += i.a.a.b.b.a.cJ(26, this.sceneType);
      paramInt = i;
      if (this.duplicateUsername != null) {
        paramInt = i + i.a.a.b.b.a.h(27, this.duplicateUsername);
      }
      i = paramInt;
      if (this.duplicateTextStatusId != null) {
        i = paramInt + i.a.a.b.b.a.h(28, this.duplicateTextStatusId);
      }
      paramInt = i;
      if (this.brand_key_info != null) {
        paramInt = i + i.a.a.b.b.a.h(29, this.brand_key_info);
      }
      AppMethodBeat.o(290088);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(290088);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      TextStatusExtInfo localTextStatusExtInfo = (TextStatusExtInfo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      case 19: 
      default: 
        AppMethodBeat.o(290088);
        return -1;
      case 1: 
        localTextStatusExtInfo.longitude = Double.longBitsToDouble(((i.a.a.a.a)localObject1).ajGk.aay());
        AppMethodBeat.o(290088);
        return 0;
      case 2: 
        localTextStatusExtInfo.latitude = Double.longBitsToDouble(((i.a.a.a.a)localObject1).ajGk.aay());
        AppMethodBeat.o(290088);
        return 0;
      case 3: 
        localTextStatusExtInfo.mediaType = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(290088);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
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
        AppMethodBeat.o(290088);
        return 0;
      case 5: 
        localTextStatusExtInfo.mediaUrl = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(290088);
        return 0;
      case 6: 
        localTextStatusExtInfo.mediaAesKey = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(290088);
        return 0;
      case 7: 
        localTextStatusExtInfo.mediaThumbUrl = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(290088);
        return 0;
      case 8: 
        localTextStatusExtInfo.mediaThumbAesKey = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(290088);
        return 0;
      case 9: 
        localTextStatusExtInfo.visibility = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(290088);
        return 0;
      case 10: 
        localTextStatusExtInfo.description = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(290088);
        return 0;
      case 11: 
        localTextStatusExtInfo.createTime = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(290088);
        return 0;
      case 12: 
        localTextStatusExtInfo.expireTime = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(290088);
        return 0;
      case 13: 
        localTextStatusExtInfo.poiId = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(290088);
        return 0;
      case 14: 
        localTextStatusExtInfo.poiName = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(290088);
        return 0;
      case 15: 
        localTextStatusExtInfo.option = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(290088);
        return 0;
      case 16: 
        localTextStatusExtInfo.mediaWidth = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(290088);
        return 0;
      case 17: 
        localTextStatusExtInfo.mediaHeight = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(290088);
        return 0;
      case 18: 
        localTextStatusExtInfo.backgroundId = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(290088);
        return 0;
      case 20: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
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
        AppMethodBeat.o(290088);
        return 0;
      case 21: 
        localTextStatusExtInfo.modifyTime = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(290088);
        return 0;
      case 22: 
        localTextStatusExtInfo.modifyCount = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(290088);
        return 0;
      case 23: 
        localTextStatusExtInfo.serverCreateTime = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(290088);
        return 0;
      case 24: 
        localTextStatusExtInfo.referenceUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(290088);
        return 0;
      case 25: 
        localTextStatusExtInfo.referenceTextStatusId = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(290088);
        return 0;
      case 26: 
        localTextStatusExtInfo.sceneType = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(290088);
        return 0;
      case 27: 
        localTextStatusExtInfo.duplicateUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(290088);
        return 0;
      case 28: 
        localTextStatusExtInfo.duplicateTextStatusId = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(290088);
        return 0;
      }
      localTextStatusExtInfo.brand_key_info = ((i.a.a.a.a)localObject1).ajGk.readString();
      AppMethodBeat.o(290088);
      return 0;
    }
    AppMethodBeat.o(290088);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo
 * JD-Core Version:    0.7.0.1
 */