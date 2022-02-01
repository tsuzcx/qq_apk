package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderObjectDesc
  extends com.tencent.mm.bw.a
{
  public String description;
  public long draftObjectId;
  public azs event;
  public aqp extReading;
  public azr feedBgmInfo;
  public axt feed_location;
  public arm fromApp;
  public azk imgFeedBgmInfo;
  public avq liveDesc;
  public axt location;
  public axu longVideoDesc;
  public LinkedList<FinderMedia> media;
  public FinderMediaExtra mediaExtra;
  public int mediaType;
  public LinkedList<ayp> mentionedMusics;
  public LinkedList<ayq> mentionedUser;
  public axw mvInfo;
  public bdl tmpl_info;
  public bdq topic;
  
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
        paramVarArgs.e(1, this.description);
      }
      paramVarArgs.e(2, 8, this.media);
      paramVarArgs.aM(3, this.mediaType);
      if (this.mediaExtra != null)
      {
        paramVarArgs.ni(4, this.mediaExtra.computeSize());
        this.mediaExtra.writeFields(paramVarArgs);
      }
      if (this.location != null)
      {
        paramVarArgs.ni(5, this.location.computeSize());
        this.location.writeFields(paramVarArgs);
      }
      if (this.extReading != null)
      {
        paramVarArgs.ni(6, this.extReading.computeSize());
        this.extReading.writeFields(paramVarArgs);
      }
      if (this.topic != null)
      {
        paramVarArgs.ni(7, this.topic.computeSize());
        this.topic.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.mentionedUser);
      if (this.liveDesc != null)
      {
        paramVarArgs.ni(9, this.liveDesc.computeSize());
        this.liveDesc.writeFields(paramVarArgs);
      }
      if (this.feed_location != null)
      {
        paramVarArgs.ni(10, this.feed_location.computeSize());
        this.feed_location.writeFields(paramVarArgs);
      }
      paramVarArgs.e(11, 8, this.mentionedMusics);
      if (this.longVideoDesc != null)
      {
        paramVarArgs.ni(12, this.longVideoDesc.computeSize());
        this.longVideoDesc.writeFields(paramVarArgs);
      }
      if (this.imgFeedBgmInfo != null)
      {
        paramVarArgs.ni(13, this.imgFeedBgmInfo.computeSize());
        this.imgFeedBgmInfo.writeFields(paramVarArgs);
      }
      if (this.feedBgmInfo != null)
      {
        paramVarArgs.ni(14, this.feedBgmInfo.computeSize());
        this.feedBgmInfo.writeFields(paramVarArgs);
      }
      if (this.fromApp != null)
      {
        paramVarArgs.ni(15, this.fromApp.computeSize());
        this.fromApp.writeFields(paramVarArgs);
      }
      if (this.tmpl_info != null)
      {
        paramVarArgs.ni(16, this.tmpl_info.computeSize());
        this.tmpl_info.writeFields(paramVarArgs);
      }
      if (this.event != null)
      {
        paramVarArgs.ni(17, this.event.computeSize());
        this.event.writeFields(paramVarArgs);
      }
      if (this.mvInfo != null)
      {
        paramVarArgs.ni(18, this.mvInfo.computeSize());
        this.mvInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(19, this.draftObjectId);
      AppMethodBeat.o(169024);
      return 0;
    }
    if (paramInt == 1) {
      if (this.description == null) {
        break label2750;
      }
    }
    label2750:
    for (paramInt = g.a.a.b.b.a.f(1, this.description) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.media) + g.a.a.b.b.a.bu(3, this.mediaType);
      paramInt = i;
      if (this.mediaExtra != null) {
        paramInt = i + g.a.a.a.nh(4, this.mediaExtra.computeSize());
      }
      i = paramInt;
      if (this.location != null) {
        i = paramInt + g.a.a.a.nh(5, this.location.computeSize());
      }
      paramInt = i;
      if (this.extReading != null) {
        paramInt = i + g.a.a.a.nh(6, this.extReading.computeSize());
      }
      i = paramInt;
      if (this.topic != null) {
        i = paramInt + g.a.a.a.nh(7, this.topic.computeSize());
      }
      i += g.a.a.a.c(8, 8, this.mentionedUser);
      paramInt = i;
      if (this.liveDesc != null) {
        paramInt = i + g.a.a.a.nh(9, this.liveDesc.computeSize());
      }
      i = paramInt;
      if (this.feed_location != null) {
        i = paramInt + g.a.a.a.nh(10, this.feed_location.computeSize());
      }
      i += g.a.a.a.c(11, 8, this.mentionedMusics);
      paramInt = i;
      if (this.longVideoDesc != null) {
        paramInt = i + g.a.a.a.nh(12, this.longVideoDesc.computeSize());
      }
      i = paramInt;
      if (this.imgFeedBgmInfo != null) {
        i = paramInt + g.a.a.a.nh(13, this.imgFeedBgmInfo.computeSize());
      }
      paramInt = i;
      if (this.feedBgmInfo != null) {
        paramInt = i + g.a.a.a.nh(14, this.feedBgmInfo.computeSize());
      }
      i = paramInt;
      if (this.fromApp != null) {
        i = paramInt + g.a.a.a.nh(15, this.fromApp.computeSize());
      }
      paramInt = i;
      if (this.tmpl_info != null) {
        paramInt = i + g.a.a.a.nh(16, this.tmpl_info.computeSize());
      }
      i = paramInt;
      if (this.event != null) {
        i = paramInt + g.a.a.a.nh(17, this.event.computeSize());
      }
      paramInt = i;
      if (this.mvInfo != null) {
        paramInt = i + g.a.a.a.nh(18, this.mvInfo.computeSize());
      }
      i = g.a.a.b.b.a.r(19, this.draftObjectId);
      AppMethodBeat.o(169024);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.media.clear();
        this.mentionedUser.clear();
        this.mentionedMusics.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169024);
          return -1;
        case 1: 
          localFinderObjectDesc.description = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169024);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderMedia();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderMedia)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderObjectDesc.media.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 3: 
          localFinderObjectDesc.mediaType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169024);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderMediaExtra();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderMediaExtra)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderObjectDesc.mediaExtra = ((FinderMediaExtra)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderObjectDesc.location = ((axt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aqp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aqp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderObjectDesc.extReading = ((aqp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bdq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bdq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderObjectDesc.topic = ((bdq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ayq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ayq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderObjectDesc.mentionedUser.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderObjectDesc.liveDesc = ((avq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderObjectDesc.feed_location = ((axt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ayp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ayp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderObjectDesc.mentionedMusics.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderObjectDesc.longVideoDesc = ((axu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new azk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((azk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderObjectDesc.imgFeedBgmInfo = ((azk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new azr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((azr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderObjectDesc.feedBgmInfo = ((azr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new arm();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((arm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderObjectDesc.fromApp = ((arm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bdl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bdl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderObjectDesc.tmpl_info = ((bdl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new azs();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((azs)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderObjectDesc.event = ((azs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderObjectDesc.mvInfo = ((axw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        }
        localFinderObjectDesc.draftObjectId = ((g.a.a.a.a)localObject1).UbS.zl();
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