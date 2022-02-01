package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ClusterShowInfo
  extends com.tencent.mm.bx.a
{
  public LinkedList<aq> iconActions;
  public String iconId;
  public String sourceActivityId;
  public String sourceIcon;
  public String sourceId;
  public String sourceName;
  public String topic;
  
  public ClusterShowInfo()
  {
    AppMethodBeat.i(289907);
    this.iconActions = new LinkedList();
    AppMethodBeat.o(289907);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(289937);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.sourceName != null) {
        paramVarArgs.g(1, this.sourceName);
      }
      if (this.sourceIcon != null) {
        paramVarArgs.g(2, this.sourceIcon);
      }
      if (this.iconId != null) {
        paramVarArgs.g(3, this.iconId);
      }
      if (this.topic != null) {
        paramVarArgs.g(4, this.topic);
      }
      if (this.sourceId != null) {
        paramVarArgs.g(5, this.sourceId);
      }
      if (this.sourceActivityId != null) {
        paramVarArgs.g(6, this.sourceActivityId);
      }
      paramVarArgs.e(8, 8, this.iconActions);
      AppMethodBeat.o(289937);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sourceName == null) {
        break label640;
      }
    }
    label640:
    for (int i = i.a.a.b.b.a.h(1, this.sourceName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sourceIcon != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.sourceIcon);
      }
      i = paramInt;
      if (this.iconId != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.iconId);
      }
      paramInt = i;
      if (this.topic != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.topic);
      }
      i = paramInt;
      if (this.sourceId != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.sourceId);
      }
      paramInt = i;
      if (this.sourceActivityId != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.sourceActivityId);
      }
      i = i.a.a.a.c(8, 8, this.iconActions);
      AppMethodBeat.o(289937);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.iconActions.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(289937);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ClusterShowInfo localClusterShowInfo = (ClusterShowInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 7: 
        default: 
          AppMethodBeat.o(289937);
          return -1;
        case 1: 
          localClusterShowInfo.sourceName = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289937);
          return 0;
        case 2: 
          localClusterShowInfo.sourceIcon = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289937);
          return 0;
        case 3: 
          localClusterShowInfo.iconId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289937);
          return 0;
        case 4: 
          localClusterShowInfo.topic = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289937);
          return 0;
        case 5: 
          localClusterShowInfo.sourceId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289937);
          return 0;
        case 6: 
          localClusterShowInfo.sourceActivityId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289937);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          aq localaq = new aq();
          if ((localObject != null) && (localObject.length > 0)) {
            localaq.parseFrom((byte[])localObject);
          }
          localClusterShowInfo.iconActions.add(localaq);
          paramInt += 1;
        }
        AppMethodBeat.o(289937);
        return 0;
      }
      AppMethodBeat.o(289937);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.ClusterShowInfo
 * JD-Core Version:    0.7.0.1
 */