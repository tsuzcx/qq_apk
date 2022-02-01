package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bkq
  extends com.tencent.mm.cd.a
{
  public String audioTrackUrl;
  public FinderContact contact;
  public String groupId;
  public bfg musicInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206577);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.contact != null)
      {
        paramVarArgs.oE(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      if (this.musicInfo != null)
      {
        paramVarArgs.oE(2, this.musicInfo.computeSize());
        this.musicInfo.writeFields(paramVarArgs);
      }
      if (this.audioTrackUrl != null) {
        paramVarArgs.f(3, this.audioTrackUrl);
      }
      if (this.groupId != null) {
        paramVarArgs.f(4, this.groupId);
      }
      AppMethodBeat.o(206577);
      return 0;
    }
    if (paramInt == 1) {
      if (this.contact == null) {
        break label542;
      }
    }
    label542:
    for (int i = g.a.a.a.oD(1, this.contact.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.musicInfo != null) {
        paramInt = i + g.a.a.a.oD(2, this.musicInfo.computeSize());
      }
      i = paramInt;
      if (this.audioTrackUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.audioTrackUrl);
      }
      paramInt = i;
      if (this.groupId != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.groupId);
      }
      AppMethodBeat.o(206577);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(206577);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bkq localbkq = (bkq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(206577);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localbkq.contact = ((FinderContact)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(206577);
          return 0;
        case 2: 
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
            localbkq.musicInfo = ((bfg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(206577);
          return 0;
        case 3: 
          localbkq.audioTrackUrl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(206577);
          return 0;
        }
        localbkq.groupId = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(206577);
        return 0;
      }
      AppMethodBeat.o(206577);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkq
 * JD-Core Version:    0.7.0.1
 */