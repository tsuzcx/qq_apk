package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class TimeLineObject
  extends com.tencent.mm.bx.a
{
  public fr AppInfo;
  public String ContentDesc;
  public agh ContentObj;
  public int CreateTime;
  public String Id;
  public djv Location;
  public int Privated;
  public String UserName;
  public bh actionInfo;
  public String canvasInfo;
  public int contentDescScene;
  public int contentDescShowType;
  public int contentattr;
  public dif liteappInfo;
  public String publicUserName;
  public int showFlag;
  public int sightFolded;
  public String sourceNickName;
  public String sourceUserName;
  public String statExtStr;
  public String statisticsData;
  public fjo streamvideo;
  public ffv videoTemplate;
  public gfh weappInfo;
  public gib webSearchInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125847);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.g(1, this.Id);
      }
      if (this.UserName != null) {
        paramVarArgs.g(2, this.UserName);
      }
      paramVarArgs.bS(3, this.Privated);
      paramVarArgs.bS(4, this.CreateTime);
      if (this.ContentDesc != null) {
        paramVarArgs.g(5, this.ContentDesc);
      }
      if (this.Location != null)
      {
        paramVarArgs.qD(6, this.Location.computeSize());
        this.Location.writeFields(paramVarArgs);
      }
      if (this.AppInfo != null)
      {
        paramVarArgs.qD(7, this.AppInfo.computeSize());
        this.AppInfo.writeFields(paramVarArgs);
      }
      if (this.ContentObj != null)
      {
        paramVarArgs.qD(8, this.ContentObj.computeSize());
        this.ContentObj.writeFields(paramVarArgs);
      }
      if (this.sourceUserName != null) {
        paramVarArgs.g(9, this.sourceUserName);
      }
      if (this.sourceNickName != null) {
        paramVarArgs.g(10, this.sourceNickName);
      }
      if (this.publicUserName != null) {
        paramVarArgs.g(11, this.publicUserName);
      }
      paramVarArgs.bS(12, this.contentDescShowType);
      paramVarArgs.bS(13, this.contentDescScene);
      if (this.statisticsData != null) {
        paramVarArgs.g(14, this.statisticsData);
      }
      if (this.actionInfo != null)
      {
        paramVarArgs.qD(15, this.actionInfo.computeSize());
        this.actionInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(16, this.contentattr);
      if (this.streamvideo != null)
      {
        paramVarArgs.qD(17, this.streamvideo.computeSize());
        this.streamvideo.writeFields(paramVarArgs);
      }
      if (this.statExtStr != null) {
        paramVarArgs.g(18, this.statExtStr);
      }
      if (this.canvasInfo != null) {
        paramVarArgs.g(19, this.canvasInfo);
      }
      if (this.weappInfo != null)
      {
        paramVarArgs.qD(20, this.weappInfo.computeSize());
        this.weappInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(21, this.sightFolded);
      if (this.webSearchInfo != null)
      {
        paramVarArgs.qD(22, this.webSearchInfo.computeSize());
        this.webSearchInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(23, this.showFlag);
      if (this.liteappInfo != null)
      {
        paramVarArgs.qD(24, this.liteappInfo.computeSize());
        this.liteappInfo.writeFields(paramVarArgs);
      }
      if (this.videoTemplate != null)
      {
        paramVarArgs.qD(25, this.videoTemplate.computeSize());
        this.videoTemplate.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label2224;
      }
    }
    label2224:
    for (paramInt = i.a.a.b.b.a.h(1, this.Id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UserName != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.UserName);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.Privated) + i.a.a.b.b.a.cJ(4, this.CreateTime);
      paramInt = i;
      if (this.ContentDesc != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ContentDesc);
      }
      i = paramInt;
      if (this.Location != null) {
        i = paramInt + i.a.a.a.qC(6, this.Location.computeSize());
      }
      paramInt = i;
      if (this.AppInfo != null) {
        paramInt = i + i.a.a.a.qC(7, this.AppInfo.computeSize());
      }
      i = paramInt;
      if (this.ContentObj != null) {
        i = paramInt + i.a.a.a.qC(8, this.ContentObj.computeSize());
      }
      paramInt = i;
      if (this.sourceUserName != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.sourceUserName);
      }
      i = paramInt;
      if (this.sourceNickName != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.sourceNickName);
      }
      paramInt = i;
      if (this.publicUserName != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.publicUserName);
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.contentDescShowType) + i.a.a.b.b.a.cJ(13, this.contentDescScene);
      paramInt = i;
      if (this.statisticsData != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.statisticsData);
      }
      i = paramInt;
      if (this.actionInfo != null) {
        i = paramInt + i.a.a.a.qC(15, this.actionInfo.computeSize());
      }
      i += i.a.a.b.b.a.cJ(16, this.contentattr);
      paramInt = i;
      if (this.streamvideo != null) {
        paramInt = i + i.a.a.a.qC(17, this.streamvideo.computeSize());
      }
      i = paramInt;
      if (this.statExtStr != null) {
        i = paramInt + i.a.a.b.b.a.h(18, this.statExtStr);
      }
      paramInt = i;
      if (this.canvasInfo != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.canvasInfo);
      }
      i = paramInt;
      if (this.weappInfo != null) {
        i = paramInt + i.a.a.a.qC(20, this.weappInfo.computeSize());
      }
      i += i.a.a.b.b.a.cJ(21, this.sightFolded);
      paramInt = i;
      if (this.webSearchInfo != null) {
        paramInt = i + i.a.a.a.qC(22, this.webSearchInfo.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(23, this.showFlag);
      paramInt = i;
      if (this.liteappInfo != null) {
        paramInt = i + i.a.a.a.qC(24, this.liteappInfo.computeSize());
      }
      i = paramInt;
      if (this.videoTemplate != null) {
        i = paramInt + i.a.a.a.qC(25, this.videoTemplate.computeSize());
      }
      AppMethodBeat.o(125847);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125847);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        TimeLineObject localTimeLineObject = (TimeLineObject)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125847);
          return -1;
        case 1: 
          localTimeLineObject.Id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 2: 
          localTimeLineObject.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 3: 
          localTimeLineObject.Privated = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125847);
          return 0;
        case 4: 
          localTimeLineObject.CreateTime = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125847);
          return 0;
        case 5: 
          localTimeLineObject.ContentDesc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new djv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((djv)localObject2).parseFrom((byte[])localObject1);
            }
            localTimeLineObject.Location = ((djv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fr)localObject2).parseFrom((byte[])localObject1);
            }
            localTimeLineObject.AppInfo = ((fr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new agh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((agh)localObject2).parseFrom((byte[])localObject1);
            }
            localTimeLineObject.ContentObj = ((agh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 9: 
          localTimeLineObject.sourceUserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 10: 
          localTimeLineObject.sourceNickName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 11: 
          localTimeLineObject.publicUserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 12: 
          localTimeLineObject.contentDescShowType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125847);
          return 0;
        case 13: 
          localTimeLineObject.contentDescScene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125847);
          return 0;
        case 14: 
          localTimeLineObject.statisticsData = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bh)localObject2).parseFrom((byte[])localObject1);
            }
            localTimeLineObject.actionInfo = ((bh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 16: 
          localTimeLineObject.contentattr = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125847);
          return 0;
        case 17: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fjo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fjo)localObject2).parseFrom((byte[])localObject1);
            }
            localTimeLineObject.streamvideo = ((fjo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 18: 
          localTimeLineObject.statExtStr = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 19: 
          localTimeLineObject.canvasInfo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 20: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gfh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gfh)localObject2).parseFrom((byte[])localObject1);
            }
            localTimeLineObject.weappInfo = ((gfh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 21: 
          localTimeLineObject.sightFolded = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125847);
          return 0;
        case 22: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gib();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gib)localObject2).parseFrom((byte[])localObject1);
            }
            localTimeLineObject.webSearchInfo = ((gib)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 23: 
          localTimeLineObject.showFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125847);
          return 0;
        case 24: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dif();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dif)localObject2).parseFrom((byte[])localObject1);
            }
            localTimeLineObject.liteappInfo = ((dif)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ffv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ffv)localObject2).parseFrom((byte[])localObject1);
          }
          localTimeLineObject.videoTemplate = ((ffv)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.TimeLineObject
 * JD-Core Version:    0.7.0.1
 */