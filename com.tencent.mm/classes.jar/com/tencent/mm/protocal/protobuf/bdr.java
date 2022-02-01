package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bdr
  extends com.tencent.mm.bw.a
{
  public String audioTrackUrl;
  public FinderContact contact;
  public String groupId;
  public azk musicInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209703);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.contact != null)
      {
        paramVarArgs.ni(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      if (this.musicInfo != null)
      {
        paramVarArgs.ni(2, this.musicInfo.computeSize());
        this.musicInfo.writeFields(paramVarArgs);
      }
      if (this.audioTrackUrl != null) {
        paramVarArgs.e(3, this.audioTrackUrl);
      }
      if (this.groupId != null) {
        paramVarArgs.e(4, this.groupId);
      }
      AppMethodBeat.o(209703);
      return 0;
    }
    if (paramInt == 1) {
      if (this.contact == null) {
        break label586;
      }
    }
    label586:
    for (int i = g.a.a.a.nh(1, this.contact.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.musicInfo != null) {
        paramInt = i + g.a.a.a.nh(2, this.musicInfo.computeSize());
      }
      i = paramInt;
      if (this.audioTrackUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.audioTrackUrl);
      }
      paramInt = i;
      if (this.groupId != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.groupId);
      }
      AppMethodBeat.o(209703);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209703);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bdr localbdr = (bdr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209703);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbdr.contact = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209703);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new azk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((azk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbdr.musicInfo = ((azk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209703);
          return 0;
        case 3: 
          localbdr.audioTrackUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209703);
          return 0;
        }
        localbdr.groupId = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209703);
        return 0;
      }
      AppMethodBeat.o(209703);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdr
 * JD-Core Version:    0.7.0.1
 */