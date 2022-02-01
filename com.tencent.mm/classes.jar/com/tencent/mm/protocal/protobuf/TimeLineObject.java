package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class TimeLineObject
  extends com.tencent.mm.bw.a
{
  public fa AppInfo;
  public String ContentDesc;
  public adp ContentObj;
  public int CreateTime;
  public String Id;
  public cjy Location;
  public int Privated;
  public String UserName;
  public be actionInfo;
  public String canvasInfo;
  public int contentDescScene;
  public int contentDescShowType;
  public int contentattr;
  public cio liteappInfo;
  public String publicUserName;
  public int showFlag;
  public int sightFolded;
  public String sourceNickName;
  public String sourceUserName;
  public String statExtStr;
  public String statisticsData;
  public eep streamvideo;
  public eyd weappInfo;
  public fat webSearchInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125847);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.e(1, this.Id);
      }
      if (this.UserName != null) {
        paramVarArgs.e(2, this.UserName);
      }
      paramVarArgs.aM(3, this.Privated);
      paramVarArgs.aM(4, this.CreateTime);
      if (this.ContentDesc != null) {
        paramVarArgs.e(5, this.ContentDesc);
      }
      if (this.Location != null)
      {
        paramVarArgs.ni(6, this.Location.computeSize());
        this.Location.writeFields(paramVarArgs);
      }
      if (this.AppInfo != null)
      {
        paramVarArgs.ni(7, this.AppInfo.computeSize());
        this.AppInfo.writeFields(paramVarArgs);
      }
      if (this.ContentObj != null)
      {
        paramVarArgs.ni(8, this.ContentObj.computeSize());
        this.ContentObj.writeFields(paramVarArgs);
      }
      if (this.sourceUserName != null) {
        paramVarArgs.e(9, this.sourceUserName);
      }
      if (this.sourceNickName != null) {
        paramVarArgs.e(10, this.sourceNickName);
      }
      if (this.publicUserName != null) {
        paramVarArgs.e(11, this.publicUserName);
      }
      paramVarArgs.aM(12, this.contentDescShowType);
      paramVarArgs.aM(13, this.contentDescScene);
      if (this.statisticsData != null) {
        paramVarArgs.e(14, this.statisticsData);
      }
      if (this.actionInfo != null)
      {
        paramVarArgs.ni(15, this.actionInfo.computeSize());
        this.actionInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(16, this.contentattr);
      if (this.streamvideo != null)
      {
        paramVarArgs.ni(17, this.streamvideo.computeSize());
        this.streamvideo.writeFields(paramVarArgs);
      }
      if (this.statExtStr != null) {
        paramVarArgs.e(18, this.statExtStr);
      }
      if (this.canvasInfo != null) {
        paramVarArgs.e(19, this.canvasInfo);
      }
      if (this.weappInfo != null)
      {
        paramVarArgs.ni(20, this.weappInfo.computeSize());
        this.weappInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(21, this.sightFolded);
      if (this.webSearchInfo != null)
      {
        paramVarArgs.ni(22, this.webSearchInfo.computeSize());
        this.webSearchInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(23, this.showFlag);
      if (this.liteappInfo != null)
      {
        paramVarArgs.ni(24, this.liteappInfo.computeSize());
        this.liteappInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label2270;
      }
    }
    label2270:
    for (paramInt = g.a.a.b.b.a.f(1, this.Id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.UserName);
      }
      i = i + g.a.a.b.b.a.bu(3, this.Privated) + g.a.a.b.b.a.bu(4, this.CreateTime);
      paramInt = i;
      if (this.ContentDesc != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.ContentDesc);
      }
      i = paramInt;
      if (this.Location != null) {
        i = paramInt + g.a.a.a.nh(6, this.Location.computeSize());
      }
      paramInt = i;
      if (this.AppInfo != null) {
        paramInt = i + g.a.a.a.nh(7, this.AppInfo.computeSize());
      }
      i = paramInt;
      if (this.ContentObj != null) {
        i = paramInt + g.a.a.a.nh(8, this.ContentObj.computeSize());
      }
      paramInt = i;
      if (this.sourceUserName != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.sourceUserName);
      }
      i = paramInt;
      if (this.sourceNickName != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.sourceNickName);
      }
      paramInt = i;
      if (this.publicUserName != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.publicUserName);
      }
      i = paramInt + g.a.a.b.b.a.bu(12, this.contentDescShowType) + g.a.a.b.b.a.bu(13, this.contentDescScene);
      paramInt = i;
      if (this.statisticsData != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.statisticsData);
      }
      i = paramInt;
      if (this.actionInfo != null) {
        i = paramInt + g.a.a.a.nh(15, this.actionInfo.computeSize());
      }
      i += g.a.a.b.b.a.bu(16, this.contentattr);
      paramInt = i;
      if (this.streamvideo != null) {
        paramInt = i + g.a.a.a.nh(17, this.streamvideo.computeSize());
      }
      i = paramInt;
      if (this.statExtStr != null) {
        i = paramInt + g.a.a.b.b.a.f(18, this.statExtStr);
      }
      paramInt = i;
      if (this.canvasInfo != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.canvasInfo);
      }
      i = paramInt;
      if (this.weappInfo != null) {
        i = paramInt + g.a.a.a.nh(20, this.weappInfo.computeSize());
      }
      i += g.a.a.b.b.a.bu(21, this.sightFolded);
      paramInt = i;
      if (this.webSearchInfo != null) {
        paramInt = i + g.a.a.a.nh(22, this.webSearchInfo.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(23, this.showFlag);
      paramInt = i;
      if (this.liteappInfo != null) {
        paramInt = i + g.a.a.a.nh(24, this.liteappInfo.computeSize());
      }
      AppMethodBeat.o(125847);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(125847);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        TimeLineObject localTimeLineObject = (TimeLineObject)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125847);
          return -1;
        case 1: 
          localTimeLineObject.Id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 2: 
          localTimeLineObject.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 3: 
          localTimeLineObject.Privated = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125847);
          return 0;
        case 4: 
          localTimeLineObject.CreateTime = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125847);
          return 0;
        case 5: 
          localTimeLineObject.ContentDesc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjy();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localTimeLineObject.Location = ((cjy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fa();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fa)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localTimeLineObject.AppInfo = ((fa)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new adp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((adp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localTimeLineObject.ContentObj = ((adp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 9: 
          localTimeLineObject.sourceUserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 10: 
          localTimeLineObject.sourceNickName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 11: 
          localTimeLineObject.publicUserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 12: 
          localTimeLineObject.contentDescShowType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125847);
          return 0;
        case 13: 
          localTimeLineObject.contentDescScene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125847);
          return 0;
        case 14: 
          localTimeLineObject.statisticsData = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new be();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((be)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localTimeLineObject.actionInfo = ((be)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 16: 
          localTimeLineObject.contentattr = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125847);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eep();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eep)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localTimeLineObject.streamvideo = ((eep)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 18: 
          localTimeLineObject.statExtStr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 19: 
          localTimeLineObject.canvasInfo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eyd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eyd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localTimeLineObject.weappInfo = ((eyd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 21: 
          localTimeLineObject.sightFolded = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125847);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fat();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fat)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localTimeLineObject.webSearchInfo = ((fat)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 23: 
          localTimeLineObject.showFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125847);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cio();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cio)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localTimeLineObject.liteappInfo = ((cio)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125847);
        return 0;
      }
      AppMethodBeat.o(125847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.TimeLineObject
 * JD-Core Version:    0.7.0.1
 */