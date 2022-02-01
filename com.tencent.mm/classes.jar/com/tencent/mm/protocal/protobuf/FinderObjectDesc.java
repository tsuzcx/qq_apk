package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderObjectDesc
  extends com.tencent.mm.bx.a
{
  public auq client_draft_ext_info;
  public String description;
  public long draftObjectId;
  public brg event;
  public axa extReading;
  public bqz feedBgmInfo;
  public boi feed_location;
  public axw fromApp;
  public ayb generalReportInfo;
  public bqj imgFeedBgmInfo;
  public bgk liveDesc;
  public boi location;
  public boj longVideoDesc;
  public LinkedList<FinderMedia> media;
  public FinderMediaExtra mediaExtra;
  public int mediaType;
  public LinkedList<bpi> mentionedMusics;
  public LinkedList<bpj> mentionedUser;
  public bqj musicInfo;
  public bol mvInfo;
  public dzl originalsound_info;
  public bxm tmpl_info;
  public bxs topic;
  public byy video_tmpl_info;
  
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
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.description != null) {
        paramVarArgs.g(1, this.description);
      }
      paramVarArgs.e(2, 8, this.media);
      paramVarArgs.bS(3, this.mediaType);
      if (this.mediaExtra != null)
      {
        paramVarArgs.qD(4, this.mediaExtra.computeSize());
        this.mediaExtra.writeFields(paramVarArgs);
      }
      if (this.location != null)
      {
        paramVarArgs.qD(5, this.location.computeSize());
        this.location.writeFields(paramVarArgs);
      }
      if (this.extReading != null)
      {
        paramVarArgs.qD(6, this.extReading.computeSize());
        this.extReading.writeFields(paramVarArgs);
      }
      if (this.topic != null)
      {
        paramVarArgs.qD(7, this.topic.computeSize());
        this.topic.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.mentionedUser);
      if (this.liveDesc != null)
      {
        paramVarArgs.qD(9, this.liveDesc.computeSize());
        this.liveDesc.writeFields(paramVarArgs);
      }
      if (this.feed_location != null)
      {
        paramVarArgs.qD(10, this.feed_location.computeSize());
        this.feed_location.writeFields(paramVarArgs);
      }
      paramVarArgs.e(11, 8, this.mentionedMusics);
      if (this.longVideoDesc != null)
      {
        paramVarArgs.qD(12, this.longVideoDesc.computeSize());
        this.longVideoDesc.writeFields(paramVarArgs);
      }
      if (this.imgFeedBgmInfo != null)
      {
        paramVarArgs.qD(13, this.imgFeedBgmInfo.computeSize());
        this.imgFeedBgmInfo.writeFields(paramVarArgs);
      }
      if (this.feedBgmInfo != null)
      {
        paramVarArgs.qD(14, this.feedBgmInfo.computeSize());
        this.feedBgmInfo.writeFields(paramVarArgs);
      }
      if (this.fromApp != null)
      {
        paramVarArgs.qD(15, this.fromApp.computeSize());
        this.fromApp.writeFields(paramVarArgs);
      }
      if (this.tmpl_info != null)
      {
        paramVarArgs.qD(16, this.tmpl_info.computeSize());
        this.tmpl_info.writeFields(paramVarArgs);
      }
      if (this.event != null)
      {
        paramVarArgs.qD(17, this.event.computeSize());
        this.event.writeFields(paramVarArgs);
      }
      if (this.mvInfo != null)
      {
        paramVarArgs.qD(18, this.mvInfo.computeSize());
        this.mvInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(19, this.draftObjectId);
      if (this.client_draft_ext_info != null)
      {
        paramVarArgs.qD(20, this.client_draft_ext_info.computeSize());
        this.client_draft_ext_info.writeFields(paramVarArgs);
      }
      if (this.musicInfo != null)
      {
        paramVarArgs.qD(21, this.musicInfo.computeSize());
        this.musicInfo.writeFields(paramVarArgs);
      }
      if (this.video_tmpl_info != null)
      {
        paramVarArgs.qD(22, this.video_tmpl_info.computeSize());
        this.video_tmpl_info.writeFields(paramVarArgs);
      }
      if (this.generalReportInfo != null)
      {
        paramVarArgs.qD(23, this.generalReportInfo.computeSize());
        this.generalReportInfo.writeFields(paramVarArgs);
      }
      if (this.originalsound_info != null)
      {
        paramVarArgs.qD(24, this.originalsound_info.computeSize());
        this.originalsound_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169024);
      return 0;
    }
    if (paramInt == 1) {
      if (this.description == null) {
        break label3068;
      }
    }
    label3068:
    for (paramInt = i.a.a.b.b.a.h(1, this.description) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.media) + i.a.a.b.b.a.cJ(3, this.mediaType);
      paramInt = i;
      if (this.mediaExtra != null) {
        paramInt = i + i.a.a.a.qC(4, this.mediaExtra.computeSize());
      }
      i = paramInt;
      if (this.location != null) {
        i = paramInt + i.a.a.a.qC(5, this.location.computeSize());
      }
      paramInt = i;
      if (this.extReading != null) {
        paramInt = i + i.a.a.a.qC(6, this.extReading.computeSize());
      }
      i = paramInt;
      if (this.topic != null) {
        i = paramInt + i.a.a.a.qC(7, this.topic.computeSize());
      }
      i += i.a.a.a.c(8, 8, this.mentionedUser);
      paramInt = i;
      if (this.liveDesc != null) {
        paramInt = i + i.a.a.a.qC(9, this.liveDesc.computeSize());
      }
      i = paramInt;
      if (this.feed_location != null) {
        i = paramInt + i.a.a.a.qC(10, this.feed_location.computeSize());
      }
      i += i.a.a.a.c(11, 8, this.mentionedMusics);
      paramInt = i;
      if (this.longVideoDesc != null) {
        paramInt = i + i.a.a.a.qC(12, this.longVideoDesc.computeSize());
      }
      i = paramInt;
      if (this.imgFeedBgmInfo != null) {
        i = paramInt + i.a.a.a.qC(13, this.imgFeedBgmInfo.computeSize());
      }
      paramInt = i;
      if (this.feedBgmInfo != null) {
        paramInt = i + i.a.a.a.qC(14, this.feedBgmInfo.computeSize());
      }
      i = paramInt;
      if (this.fromApp != null) {
        i = paramInt + i.a.a.a.qC(15, this.fromApp.computeSize());
      }
      paramInt = i;
      if (this.tmpl_info != null) {
        paramInt = i + i.a.a.a.qC(16, this.tmpl_info.computeSize());
      }
      i = paramInt;
      if (this.event != null) {
        i = paramInt + i.a.a.a.qC(17, this.event.computeSize());
      }
      paramInt = i;
      if (this.mvInfo != null) {
        paramInt = i + i.a.a.a.qC(18, this.mvInfo.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.q(19, this.draftObjectId);
      paramInt = i;
      if (this.client_draft_ext_info != null) {
        paramInt = i + i.a.a.a.qC(20, this.client_draft_ext_info.computeSize());
      }
      i = paramInt;
      if (this.musicInfo != null) {
        i = paramInt + i.a.a.a.qC(21, this.musicInfo.computeSize());
      }
      paramInt = i;
      if (this.video_tmpl_info != null) {
        paramInt = i + i.a.a.a.qC(22, this.video_tmpl_info.computeSize());
      }
      i = paramInt;
      if (this.generalReportInfo != null) {
        i = paramInt + i.a.a.a.qC(23, this.generalReportInfo.computeSize());
      }
      paramInt = i;
      if (this.originalsound_info != null) {
        paramInt = i + i.a.a.a.qC(24, this.originalsound_info.computeSize());
      }
      AppMethodBeat.o(169024);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.media.clear();
        this.mentionedUser.clear();
        this.mentionedMusics.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169024);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        FinderObjectDesc localFinderObjectDesc = (FinderObjectDesc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169024);
          return -1;
        case 1: 
          localFinderObjectDesc.description = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169024);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
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
          localFinderObjectDesc.mediaType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169024);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
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
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new boi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((boi)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.location = ((boi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new axa();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((axa)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.extReading = ((axa)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bxs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bxs)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.topic = ((bxs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bpj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bpj)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.mentionedUser.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bgk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bgk)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.liveDesc = ((bgk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new boi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((boi)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.feed_location = ((boi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bpi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bpi)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.mentionedMusics.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new boj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((boj)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.longVideoDesc = ((boj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bqj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bqj)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.imgFeedBgmInfo = ((bqj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bqz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bqz)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.feedBgmInfo = ((bqz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new axw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((axw)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.fromApp = ((axw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bxm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bxm)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.tmpl_info = ((bxm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 17: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new brg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((brg)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.event = ((brg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 18: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bol)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.mvInfo = ((bol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 19: 
          localFinderObjectDesc.draftObjectId = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169024);
          return 0;
        case 20: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new auq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((auq)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.client_draft_ext_info = ((auq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 21: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bqj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bqj)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.musicInfo = ((bqj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 22: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new byy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((byy)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.video_tmpl_info = ((byy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 23: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ayb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ayb)localObject2).parseFrom((byte[])localObject1);
            }
            localFinderObjectDesc.generalReportInfo = ((ayb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dzl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dzl)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderObjectDesc.originalsound_info = ((dzl)localObject2);
          paramInt += 1;
        }
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