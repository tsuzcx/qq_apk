package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderObjectDesc
  extends com.tencent.mm.bw.a
{
  public String description;
  public amz extReading;
  public apl feed_location;
  public apj liveDesc;
  public apl location;
  public LinkedList<FinderMedia> media;
  public FinderMediaExtra mediaExtra;
  public int mediaType;
  public LinkedList<apv> mentionedUser;
  public asu topic;
  
  public FinderObjectDesc()
  {
    AppMethodBeat.i(169023);
    this.media = new LinkedList();
    this.mentionedUser = new LinkedList();
    AppMethodBeat.o(169023);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169024);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.description != null) {
        paramVarArgs.d(1, this.description);
      }
      paramVarArgs.e(2, 8, this.media);
      paramVarArgs.aS(3, this.mediaType);
      if (this.mediaExtra != null)
      {
        paramVarArgs.lJ(4, this.mediaExtra.computeSize());
        this.mediaExtra.writeFields(paramVarArgs);
      }
      if (this.location != null)
      {
        paramVarArgs.lJ(5, this.location.computeSize());
        this.location.writeFields(paramVarArgs);
      }
      if (this.extReading != null)
      {
        paramVarArgs.lJ(6, this.extReading.computeSize());
        this.extReading.writeFields(paramVarArgs);
      }
      if (this.topic != null)
      {
        paramVarArgs.lJ(7, this.topic.computeSize());
        this.topic.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.mentionedUser);
      if (this.liveDesc != null)
      {
        paramVarArgs.lJ(9, this.liveDesc.computeSize());
        this.liveDesc.writeFields(paramVarArgs);
      }
      if (this.feed_location != null)
      {
        paramVarArgs.lJ(10, this.feed_location.computeSize());
        this.feed_location.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169024);
      return 0;
    }
    if (paramInt == 1) {
      if (this.description == null) {
        break label1474;
      }
    }
    label1474:
    for (paramInt = f.a.a.b.b.a.e(1, this.description) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.media) + f.a.a.b.b.a.bz(3, this.mediaType);
      paramInt = i;
      if (this.mediaExtra != null) {
        paramInt = i + f.a.a.a.lI(4, this.mediaExtra.computeSize());
      }
      i = paramInt;
      if (this.location != null) {
        i = paramInt + f.a.a.a.lI(5, this.location.computeSize());
      }
      paramInt = i;
      if (this.extReading != null) {
        paramInt = i + f.a.a.a.lI(6, this.extReading.computeSize());
      }
      i = paramInt;
      if (this.topic != null) {
        i = paramInt + f.a.a.a.lI(7, this.topic.computeSize());
      }
      i += f.a.a.a.c(8, 8, this.mentionedUser);
      paramInt = i;
      if (this.liveDesc != null) {
        paramInt = i + f.a.a.a.lI(9, this.liveDesc.computeSize());
      }
      i = paramInt;
      if (this.feed_location != null) {
        i = paramInt + f.a.a.a.lI(10, this.feed_location.computeSize());
      }
      AppMethodBeat.o(169024);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.media.clear();
        this.mentionedUser.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(169024);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
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
          localFinderObjectDesc.description = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169024);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderMedia();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderMedia)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localFinderObjectDesc.media.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 3: 
          localFinderObjectDesc.mediaType = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169024);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderMediaExtra();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderMediaExtra)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localFinderObjectDesc.mediaExtra = ((FinderMediaExtra)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localFinderObjectDesc.location = ((apl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new amz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((amz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localFinderObjectDesc.extReading = ((amz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new asu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((asu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localFinderObjectDesc.topic = ((asu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localFinderObjectDesc.mentionedUser.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localFinderObjectDesc.liveDesc = ((apj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169024);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new apl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((apl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localFinderObjectDesc.feed_location = ((apl)localObject1);
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