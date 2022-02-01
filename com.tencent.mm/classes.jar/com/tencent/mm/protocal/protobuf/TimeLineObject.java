package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class TimeLineObject
  extends com.tencent.mm.cd.a
{
  public ex AppInfo;
  public String ContentDesc;
  public adw ContentObj;
  public int CreateTime;
  public String Id;
  public cst Location;
  public int Privated;
  public String UserName;
  public bc actionInfo;
  public String canvasInfo;
  public int contentDescScene;
  public int contentDescShowType;
  public int contentattr;
  public crk liteappInfo;
  public String publicUserName;
  public int showFlag;
  public int sightFolded;
  public String sourceNickName;
  public String sourceUserName;
  public String statExtStr;
  public String statisticsData;
  public eoq streamvideo;
  public fiu weappInfo;
  public flm webSearchInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125847);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.f(1, this.Id);
      }
      if (this.UserName != null) {
        paramVarArgs.f(2, this.UserName);
      }
      paramVarArgs.aY(3, this.Privated);
      paramVarArgs.aY(4, this.CreateTime);
      if (this.ContentDesc != null) {
        paramVarArgs.f(5, this.ContentDesc);
      }
      if (this.Location != null)
      {
        paramVarArgs.oE(6, this.Location.computeSize());
        this.Location.writeFields(paramVarArgs);
      }
      if (this.AppInfo != null)
      {
        paramVarArgs.oE(7, this.AppInfo.computeSize());
        this.AppInfo.writeFields(paramVarArgs);
      }
      if (this.ContentObj != null)
      {
        paramVarArgs.oE(8, this.ContentObj.computeSize());
        this.ContentObj.writeFields(paramVarArgs);
      }
      if (this.sourceUserName != null) {
        paramVarArgs.f(9, this.sourceUserName);
      }
      if (this.sourceNickName != null) {
        paramVarArgs.f(10, this.sourceNickName);
      }
      if (this.publicUserName != null) {
        paramVarArgs.f(11, this.publicUserName);
      }
      paramVarArgs.aY(12, this.contentDescShowType);
      paramVarArgs.aY(13, this.contentDescScene);
      if (this.statisticsData != null) {
        paramVarArgs.f(14, this.statisticsData);
      }
      if (this.actionInfo != null)
      {
        paramVarArgs.oE(15, this.actionInfo.computeSize());
        this.actionInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(16, this.contentattr);
      if (this.streamvideo != null)
      {
        paramVarArgs.oE(17, this.streamvideo.computeSize());
        this.streamvideo.writeFields(paramVarArgs);
      }
      if (this.statExtStr != null) {
        paramVarArgs.f(18, this.statExtStr);
      }
      if (this.canvasInfo != null) {
        paramVarArgs.f(19, this.canvasInfo);
      }
      if (this.weappInfo != null)
      {
        paramVarArgs.oE(20, this.weappInfo.computeSize());
        this.weappInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(21, this.sightFolded);
      if (this.webSearchInfo != null)
      {
        paramVarArgs.oE(22, this.webSearchInfo.computeSize());
        this.webSearchInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(23, this.showFlag);
      if (this.liteappInfo != null)
      {
        paramVarArgs.oE(24, this.liteappInfo.computeSize());
        this.liteappInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label2094;
      }
    }
    label2094:
    for (paramInt = g.a.a.b.b.a.g(1, this.Id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UserName);
      }
      i = i + g.a.a.b.b.a.bM(3, this.Privated) + g.a.a.b.b.a.bM(4, this.CreateTime);
      paramInt = i;
      if (this.ContentDesc != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.ContentDesc);
      }
      i = paramInt;
      if (this.Location != null) {
        i = paramInt + g.a.a.a.oD(6, this.Location.computeSize());
      }
      paramInt = i;
      if (this.AppInfo != null) {
        paramInt = i + g.a.a.a.oD(7, this.AppInfo.computeSize());
      }
      i = paramInt;
      if (this.ContentObj != null) {
        i = paramInt + g.a.a.a.oD(8, this.ContentObj.computeSize());
      }
      paramInt = i;
      if (this.sourceUserName != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.sourceUserName);
      }
      i = paramInt;
      if (this.sourceNickName != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.sourceNickName);
      }
      paramInt = i;
      if (this.publicUserName != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.publicUserName);
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.contentDescShowType) + g.a.a.b.b.a.bM(13, this.contentDescScene);
      paramInt = i;
      if (this.statisticsData != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.statisticsData);
      }
      i = paramInt;
      if (this.actionInfo != null) {
        i = paramInt + g.a.a.a.oD(15, this.actionInfo.computeSize());
      }
      i += g.a.a.b.b.a.bM(16, this.contentattr);
      paramInt = i;
      if (this.streamvideo != null) {
        paramInt = i + g.a.a.a.oD(17, this.streamvideo.computeSize());
      }
      i = paramInt;
      if (this.statExtStr != null) {
        i = paramInt + g.a.a.b.b.a.g(18, this.statExtStr);
      }
      paramInt = i;
      if (this.canvasInfo != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.canvasInfo);
      }
      i = paramInt;
      if (this.weappInfo != null) {
        i = paramInt + g.a.a.a.oD(20, this.weappInfo.computeSize());
      }
      i += g.a.a.b.b.a.bM(21, this.sightFolded);
      paramInt = i;
      if (this.webSearchInfo != null) {
        paramInt = i + g.a.a.a.oD(22, this.webSearchInfo.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(23, this.showFlag);
      paramInt = i;
      if (this.liteappInfo != null) {
        paramInt = i + g.a.a.a.oD(24, this.liteappInfo.computeSize());
      }
      AppMethodBeat.o(125847);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
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
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125847);
          return -1;
        case 1: 
          localTimeLineObject.Id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 2: 
          localTimeLineObject.UserName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 3: 
          localTimeLineObject.Privated = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125847);
          return 0;
        case 4: 
          localTimeLineObject.CreateTime = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125847);
          return 0;
        case 5: 
          localTimeLineObject.ContentDesc = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cst();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cst)localObject2).parseFrom((byte[])localObject1);
            }
            localTimeLineObject.Location = ((cst)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ex();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ex)localObject2).parseFrom((byte[])localObject1);
            }
            localTimeLineObject.AppInfo = ((ex)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new adw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((adw)localObject2).parseFrom((byte[])localObject1);
            }
            localTimeLineObject.ContentObj = ((adw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 9: 
          localTimeLineObject.sourceUserName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 10: 
          localTimeLineObject.sourceNickName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 11: 
          localTimeLineObject.publicUserName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 12: 
          localTimeLineObject.contentDescShowType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125847);
          return 0;
        case 13: 
          localTimeLineObject.contentDescScene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125847);
          return 0;
        case 14: 
          localTimeLineObject.statisticsData = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bc)localObject2).parseFrom((byte[])localObject1);
            }
            localTimeLineObject.actionInfo = ((bc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 16: 
          localTimeLineObject.contentattr = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125847);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eoq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eoq)localObject2).parseFrom((byte[])localObject1);
            }
            localTimeLineObject.streamvideo = ((eoq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 18: 
          localTimeLineObject.statExtStr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 19: 
          localTimeLineObject.canvasInfo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fiu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fiu)localObject2).parseFrom((byte[])localObject1);
            }
            localTimeLineObject.weappInfo = ((fiu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 21: 
          localTimeLineObject.sightFolded = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125847);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new flm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((flm)localObject2).parseFrom((byte[])localObject1);
            }
            localTimeLineObject.webSearchInfo = ((flm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 23: 
          localTimeLineObject.showFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125847);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new crk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((crk)localObject2).parseFrom((byte[])localObject1);
          }
          localTimeLineObject.liteappInfo = ((crk)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.TimeLineObject
 * JD-Core Version:    0.7.0.1
 */