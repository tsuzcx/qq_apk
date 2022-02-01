package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class TextStatusTopicInfo
  extends com.tencent.mm.bx.a
{
  public ClusterShowInfo clusterShowInfo;
  public LinkedList<aq> iconActions;
  public String iconId;
  public LinkedList<au> jumpElements;
  public LinkedList<TextStatusJumpInfo> jumpInfos;
  public String sourceActivityId;
  public String sourceIcon;
  public String sourceId;
  public LinkedList<TextStatusJumpInfo> sourceJumpInfos;
  public String sourceName;
  public String title;
  public String topicId;
  public LinkedList<String> topics;
  public String verifyInfo;
  
  public TextStatusTopicInfo()
  {
    AppMethodBeat.i(290018);
    this.topics = new LinkedList();
    this.jumpInfos = new LinkedList();
    this.sourceJumpInfos = new LinkedList();
    this.iconActions = new LinkedList();
    this.jumpElements = new LinkedList();
    AppMethodBeat.o(290018);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(290035);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.topicId != null) {
        paramVarArgs.g(1, this.topicId);
      }
      if (this.sourceId != null) {
        paramVarArgs.g(2, this.sourceId);
      }
      if (this.sourceActivityId != null) {
        paramVarArgs.g(3, this.sourceActivityId);
      }
      if (this.sourceName != null) {
        paramVarArgs.g(4, this.sourceName);
      }
      if (this.sourceIcon != null) {
        paramVarArgs.g(5, this.sourceIcon);
      }
      if (this.iconId != null) {
        paramVarArgs.g(10, this.iconId);
      }
      paramVarArgs.e(13, 1, this.topics);
      if (this.clusterShowInfo != null)
      {
        paramVarArgs.qD(14, this.clusterShowInfo.computeSize());
        this.clusterShowInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.e(15, 8, this.jumpInfos);
      if (this.verifyInfo != null) {
        paramVarArgs.g(16, this.verifyInfo);
      }
      if (this.title != null) {
        paramVarArgs.g(17, this.title);
      }
      paramVarArgs.e(18, 8, this.sourceJumpInfos);
      paramVarArgs.e(19, 8, this.iconActions);
      paramVarArgs.e(20, 8, this.jumpElements);
      AppMethodBeat.o(290035);
      return 0;
    }
    if (paramInt == 1) {
      if (this.topicId == null) {
        break label1340;
      }
    }
    label1340:
    for (int i = i.a.a.b.b.a.h(1, this.topicId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sourceId != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.sourceId);
      }
      i = paramInt;
      if (this.sourceActivityId != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.sourceActivityId);
      }
      paramInt = i;
      if (this.sourceName != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.sourceName);
      }
      i = paramInt;
      if (this.sourceIcon != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.sourceIcon);
      }
      paramInt = i;
      if (this.iconId != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.iconId);
      }
      i = paramInt + i.a.a.a.c(13, 1, this.topics);
      paramInt = i;
      if (this.clusterShowInfo != null) {
        paramInt = i + i.a.a.a.qC(14, this.clusterShowInfo.computeSize());
      }
      i = paramInt + i.a.a.a.c(15, 8, this.jumpInfos);
      paramInt = i;
      if (this.verifyInfo != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.verifyInfo);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.title);
      }
      paramInt = i.a.a.a.c(18, 8, this.sourceJumpInfos);
      int j = i.a.a.a.c(19, 8, this.iconActions);
      int k = i.a.a.a.c(20, 8, this.jumpElements);
      AppMethodBeat.o(290035);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.topics.clear();
        this.jumpInfos.clear();
        this.sourceJumpInfos.clear();
        this.iconActions.clear();
        this.jumpElements.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(290035);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        TextStatusTopicInfo localTextStatusTopicInfo = (TextStatusTopicInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        case 11: 
        case 12: 
        default: 
          AppMethodBeat.o(290035);
          return -1;
        case 1: 
          localTextStatusTopicInfo.topicId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(290035);
          return 0;
        case 2: 
          localTextStatusTopicInfo.sourceId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(290035);
          return 0;
        case 3: 
          localTextStatusTopicInfo.sourceActivityId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(290035);
          return 0;
        case 4: 
          localTextStatusTopicInfo.sourceName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(290035);
          return 0;
        case 5: 
          localTextStatusTopicInfo.sourceIcon = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(290035);
          return 0;
        case 10: 
          localTextStatusTopicInfo.iconId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(290035);
          return 0;
        case 13: 
          localTextStatusTopicInfo.topics.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(290035);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ClusterShowInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ClusterShowInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localTextStatusTopicInfo.clusterShowInfo = ((ClusterShowInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(290035);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new TextStatusJumpInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((TextStatusJumpInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localTextStatusTopicInfo.jumpInfos.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(290035);
          return 0;
        case 16: 
          localTextStatusTopicInfo.verifyInfo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(290035);
          return 0;
        case 17: 
          localTextStatusTopicInfo.title = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(290035);
          return 0;
        case 18: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new TextStatusJumpInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((TextStatusJumpInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localTextStatusTopicInfo.sourceJumpInfos.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(290035);
          return 0;
        case 19: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aq)localObject2).parseFrom((byte[])localObject1);
            }
            localTextStatusTopicInfo.iconActions.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(290035);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new au();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((au)localObject2).parseFrom((byte[])localObject1);
          }
          localTextStatusTopicInfo.jumpElements.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(290035);
        return 0;
      }
      AppMethodBeat.o(290035);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo
 * JD-Core Version:    0.7.0.1
 */