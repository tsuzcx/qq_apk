package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ClusterShowInfo
  extends com.tencent.mm.cd.a
{
  public LinkedList<ad> iconActions;
  public String iconId;
  public String sourceActivityId;
  public String sourceIcon;
  public String sourceId;
  public String sourceName;
  public String topic;
  
  public ClusterShowInfo()
  {
    AppMethodBeat.i(243828);
    this.iconActions = new LinkedList();
    AppMethodBeat.o(243828);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243829);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.sourceName != null) {
        paramVarArgs.f(1, this.sourceName);
      }
      if (this.sourceIcon != null) {
        paramVarArgs.f(2, this.sourceIcon);
      }
      if (this.iconId != null) {
        paramVarArgs.f(3, this.iconId);
      }
      if (this.topic != null) {
        paramVarArgs.f(4, this.topic);
      }
      if (this.sourceId != null) {
        paramVarArgs.f(5, this.sourceId);
      }
      if (this.sourceActivityId != null) {
        paramVarArgs.f(6, this.sourceActivityId);
      }
      paramVarArgs.e(8, 8, this.iconActions);
      AppMethodBeat.o(243829);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sourceName == null) {
        break label644;
      }
    }
    label644:
    for (int i = g.a.a.b.b.a.g(1, this.sourceName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sourceIcon != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.sourceIcon);
      }
      i = paramInt;
      if (this.iconId != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.iconId);
      }
      paramInt = i;
      if (this.topic != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.topic);
      }
      i = paramInt;
      if (this.sourceId != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.sourceId);
      }
      paramInt = i;
      if (this.sourceActivityId != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.sourceActivityId);
      }
      i = g.a.a.a.c(8, 8, this.iconActions);
      AppMethodBeat.o(243829);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.iconActions.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(243829);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ClusterShowInfo localClusterShowInfo = (ClusterShowInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 7: 
        default: 
          AppMethodBeat.o(243829);
          return -1;
        case 1: 
          localClusterShowInfo.sourceName = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(243829);
          return 0;
        case 2: 
          localClusterShowInfo.sourceIcon = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(243829);
          return 0;
        case 3: 
          localClusterShowInfo.iconId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(243829);
          return 0;
        case 4: 
          localClusterShowInfo.topic = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(243829);
          return 0;
        case 5: 
          localClusterShowInfo.sourceId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(243829);
          return 0;
        case 6: 
          localClusterShowInfo.sourceActivityId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(243829);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ad localad = new ad();
          if ((localObject != null) && (localObject.length > 0)) {
            localad.parseFrom((byte[])localObject);
          }
          localClusterShowInfo.iconActions.add(localad);
          paramInt += 1;
        }
        AppMethodBeat.o(243829);
        return 0;
      }
      AppMethodBeat.o(243829);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.ClusterShowInfo
 * JD-Core Version:    0.7.0.1
 */