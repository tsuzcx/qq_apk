package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class TextStatusTopicInfo
  extends com.tencent.mm.cd.a
{
  public ClusterShowInfo clusterShowInfo;
  public LinkedList<ad> iconActions;
  public String iconId;
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
    AppMethodBeat.i(243739);
    this.topics = new LinkedList();
    this.jumpInfos = new LinkedList();
    this.sourceJumpInfos = new LinkedList();
    this.iconActions = new LinkedList();
    AppMethodBeat.o(243739);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243745);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.topicId != null) {
        paramVarArgs.f(1, this.topicId);
      }
      if (this.sourceId != null) {
        paramVarArgs.f(2, this.sourceId);
      }
      if (this.sourceActivityId != null) {
        paramVarArgs.f(3, this.sourceActivityId);
      }
      if (this.sourceName != null) {
        paramVarArgs.f(4, this.sourceName);
      }
      if (this.sourceIcon != null) {
        paramVarArgs.f(5, this.sourceIcon);
      }
      if (this.iconId != null) {
        paramVarArgs.f(10, this.iconId);
      }
      paramVarArgs.e(13, 1, this.topics);
      if (this.clusterShowInfo != null)
      {
        paramVarArgs.oE(14, this.clusterShowInfo.computeSize());
        this.clusterShowInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.e(15, 8, this.jumpInfos);
      if (this.verifyInfo != null) {
        paramVarArgs.f(16, this.verifyInfo);
      }
      if (this.title != null) {
        paramVarArgs.f(17, this.title);
      }
      paramVarArgs.e(18, 8, this.sourceJumpInfos);
      paramVarArgs.e(19, 8, this.iconActions);
      AppMethodBeat.o(243745);
      return 0;
    }
    if (paramInt == 1) {
      if (this.topicId == null) {
        break label1222;
      }
    }
    label1222:
    for (int i = g.a.a.b.b.a.g(1, this.topicId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sourceId != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.sourceId);
      }
      i = paramInt;
      if (this.sourceActivityId != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.sourceActivityId);
      }
      paramInt = i;
      if (this.sourceName != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.sourceName);
      }
      i = paramInt;
      if (this.sourceIcon != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.sourceIcon);
      }
      paramInt = i;
      if (this.iconId != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.iconId);
      }
      i = paramInt + g.a.a.a.c(13, 1, this.topics);
      paramInt = i;
      if (this.clusterShowInfo != null) {
        paramInt = i + g.a.a.a.oD(14, this.clusterShowInfo.computeSize());
      }
      i = paramInt + g.a.a.a.c(15, 8, this.jumpInfos);
      paramInt = i;
      if (this.verifyInfo != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.verifyInfo);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.title);
      }
      paramInt = g.a.a.a.c(18, 8, this.sourceJumpInfos);
      int j = g.a.a.a.c(19, 8, this.iconActions);
      AppMethodBeat.o(243745);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.topics.clear();
        this.jumpInfos.clear();
        this.sourceJumpInfos.clear();
        this.iconActions.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(243745);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
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
          AppMethodBeat.o(243745);
          return -1;
        case 1: 
          localTextStatusTopicInfo.topicId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(243745);
          return 0;
        case 2: 
          localTextStatusTopicInfo.sourceId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(243745);
          return 0;
        case 3: 
          localTextStatusTopicInfo.sourceActivityId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(243745);
          return 0;
        case 4: 
          localTextStatusTopicInfo.sourceName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(243745);
          return 0;
        case 5: 
          localTextStatusTopicInfo.sourceIcon = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(243745);
          return 0;
        case 10: 
          localTextStatusTopicInfo.iconId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(243745);
          return 0;
        case 13: 
          localTextStatusTopicInfo.topics.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(243745);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
          AppMethodBeat.o(243745);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
          AppMethodBeat.o(243745);
          return 0;
        case 16: 
          localTextStatusTopicInfo.verifyInfo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(243745);
          return 0;
        case 17: 
          localTextStatusTopicInfo.title = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(243745);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
          AppMethodBeat.o(243745);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ad();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ad)localObject2).parseFrom((byte[])localObject1);
          }
          localTextStatusTopicInfo.iconActions.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(243745);
        return 0;
      }
      AppMethodBeat.o(243745);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo
 * JD-Core Version:    0.7.0.1
 */