package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderObjectDesc
  extends com.tencent.mm.cd.a
{
  public String description;
  public long draftObjectId;
  public bfv event;
  public asl extReading;
  public bfs feedBgmInfo;
  public bdm feed_location;
  public ati fromApp;
  public bfg imgFeedBgmInfo;
  public azd liveDesc;
  public bdm location;
  public bdn longVideoDesc;
  public LinkedList<FinderMedia> media;
  public FinderMediaExtra mediaExtra;
  public int mediaType;
  public LinkedList<bej> mentionedMusics;
  public LinkedList<bek> mentionedUser;
  public bdp mvInfo;
  public bkj tmpl_info;
  public bkp topic;
  
  public FinderObjectDesc()
  {
    AppMethodBeat.i(169023);
    this.media = new LinkedList();
    this.mentionedUser = new LinkedList();
    this.mentionedMusics = new LinkedList();
    AppMethodBeat.o(169023);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169024);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.description != null) {
        paramVarArgs.f(1, this.description);
      }
      paramVarArgs.e(2, 8, this.media);
      paramVarArgs.aY(3, this.mediaType);
      if (this.mediaExtra != null)
      {
        paramVarArgs.oE(4, this.mediaExtra.computeSize());
        this.mediaExtra.writeFields(paramVarArgs);
      }
      if (this.location != null)
      {
        paramVarArgs.oE(5, this.location.computeSize());
        this.location.writeFields(paramVarArgs);
      }
      if (this.extReading != null)
      {
        paramVarArgs.oE(6, this.extReading.computeSize());
        this.extReading.writeFields(paramVarArgs);
      }
      if (this.topic != null)
      {
        paramVarArgs.oE(7, this.topic.computeSize());
        this.topic.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.mentionedUser);
      if (this.liveDesc != null)
      {
        paramVarArgs.oE(9, this.liveDesc.computeSize());
        this.liveDesc.writeFields(paramVarArgs);
      }
      if (this.feed_location != null)
      {
        paramVarArgs.oE(10, this.feed_location.computeSize());
        this.feed_location.writeFields(paramVarArgs);
      }
      paramVarArgs.e(11, 8, this.mentionedMusics);
      if (this.longVideoDesc != null)
      {
        paramVarArgs.oE(12, this.longVideoDesc.computeSize());
        this.longVideoDesc.writeFields(paramVarArgs);
      }
      if (this.imgFeedBgmInfo != null)
      {
        paramVarArgs.oE(13, this.imgFeedBgmInfo.computeSize());
        this.imgFeedBgmInfo.writeFields(paramVarArgs);
      }
      if (this.feedBgmInfo != null)
      {
        paramVarArgs.oE(14, this.feedBgmInfo.computeSize());
        this.feedBgmInfo.writeFields(paramVarArgs);
      }
      if (this.fromApp != null)
      {
        paramVarArgs.oE(15, this.fromApp.computeSize());
        this.fromApp.writeFields(paramVarArgs);
      }
      if (this.tmpl_info != null)
      {
        paramVarArgs.oE(16, this.tmpl_info.computeSize());
        this.tmpl_info.writeFields(paramVarArgs);
      }
      if (this.event != null)
      {
        paramVarArgs.oE(17, this.event.computeSize());
        this.event.writeFields(paramVarArgs);
      }
      if (this.mvInfo != null)
      {
        paramVarArgs.oE(18, this.mvInfo.computeSize());
        this.mvInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(19, this.draftObjectId);
      AppMethodBeat.o(169024);
      return 0;
    }
    if (paramInt == 1) {
      if (this.description == null) {
        break label2398;
      }
    }
    label2398:
    for (paramInt = g.a.a.b.b.a.g(1, this.description) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.media) + g.a.a.b.b.a.bM(3, this.mediaType);
      paramInt = i;
      if (this.mediaExtra != null) {
        paramInt = i + g.a.a.a.oD(4, this.mediaExtra.computeSize());
      }
      i = paramInt;
      if (this.location != null) {
        i = paramInt + g.a.a.a.oD(5, this.location.computeSize());
      }
      paramInt = i;
      if (this.extReading != null) {
        paramInt = i + g.a.a.a.oD(6, this.extReading.computeSize());
      }
      i = paramInt;
      if (this.topic != null) {
        i = paramInt + g.a.a.a.oD(7, this.topic.computeSize());
      }
      i += g.a.a.a.c(8, 8, this.mentionedUser);
      paramInt = i;
      if (this.liveDesc != null) {
        paramInt = i + g.a.a.a.oD(9, this.liveDesc.computeSize());
      }
      i = paramInt;
      if (this.feed_location != null) {
        i = paramInt + g.a.a.a.oD(10, this.feed_location.computeSize());
      }
      i += g.a.a.a.c(11, 8, this.mentionedMusics);
      paramInt = i;
      if (this.longVideoDesc != null) {
        paramInt = i + g.a.a.a.oD(12, this.longVideoDesc.computeSize());
      }
      i = paramInt;
      if (this.imgFeedBgmInfo != null) {
        i = paramInt + g.a.a.a.oD(13, this.imgFeedBgmInfo.computeSize());
      }
      paramInt = i;
      if (this.feedBgmInfo != null) {
        paramInt = i + g.a.a.a.oD(14, this.feedBgmInfo.computeSize());
      }
      i = paramInt;
      if (this.fromApp != null) {
        i = paramInt + g.a.a.a.oD(15, this.fromApp.computeSize());
      }
      paramInt = i;
      if (this.tmpl_info != null) {
        paramInt = i + g.a.a.a.oD(16, this.tmpl_info.computeSize());
      }
      i = paramInt;
      if (this.event != null) {
        i = paramInt + g.a.a.a.oD(17, this.event.computeSize());
      }
      paramInt = i;
      if (this.mvInfo != null) {
        paramInt = i + g.a.a.a.oD(18, this.mvInfo.computeSize());
      }
      i = g.a.a.b.b.a.p(19, this.draftObjectId);
      AppMethodBeat.o(169024);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.media.clear();
        this.mentionedUser.clear();
        this.mentionedMusics.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169024);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        FinderObjectDesc localFinderObjectDesc = (FinderObjectDesc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169024);
          return -1;
        case 1: 
          localFinderObjectDesc.description = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169024);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderMedia();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderMedia)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.media.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 3: 
          localFinderObjectDesc.mediaType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169024);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderMediaExtra();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderMediaExtra)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.mediaExtra = ((FinderMediaExtra)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bdm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bdm)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.location = ((bdm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new asl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((asl)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.extReading = ((asl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bkp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bkp)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.topic = ((bkp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bek();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bek)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.mentionedUser.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new azd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((azd)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.liveDesc = ((azd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bdm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bdm)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.feed_location = ((bdm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bej();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bej)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.mentionedMusics.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bdn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bdn)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.longVideoDesc = ((bdn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfg)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.imgFeedBgmInfo = ((bfg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfs)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.feedBgmInfo = ((bfs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ati();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ati)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.fromApp = ((ati)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bkj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bkj)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.tmpl_info = ((bkj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfv)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.event = ((bfv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bdp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bdp)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.mvInfo = ((bdp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        }
        localFinderObjectDesc.draftObjectId = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(169024);
        return 0;
      }
      AppMethodBeat.o(169024);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderObjectDesc
 * JD-Core Version:    0.7.0.1
 */