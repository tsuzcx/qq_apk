package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bxt
  extends com.tencent.mm.bx.a
{
  public String audioTrackUrl;
  public FinderContact contact;
  public String groupId;
  public bqj musicInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258189);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.contact != null)
      {
        paramVarArgs.qD(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      if (this.musicInfo != null)
      {
        paramVarArgs.qD(2, this.musicInfo.computeSize());
        this.musicInfo.writeFields(paramVarArgs);
      }
      if (this.audioTrackUrl != null) {
        paramVarArgs.g(3, this.audioTrackUrl);
      }
      if (this.groupId != null) {
        paramVarArgs.g(4, this.groupId);
      }
      AppMethodBeat.o(258189);
      return 0;
    }
    if (paramInt == 1) {
      if (this.contact == null) {
        break label538;
      }
    }
    label538:
    for (int i = i.a.a.a.qC(1, this.contact.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.musicInfo != null) {
        paramInt = i + i.a.a.a.qC(2, this.musicInfo.computeSize());
      }
      i = paramInt;
      if (this.audioTrackUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.audioTrackUrl);
      }
      paramInt = i;
      if (this.groupId != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.groupId);
      }
      AppMethodBeat.o(258189);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258189);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bxt localbxt = (bxt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258189);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localbxt.contact = ((FinderContact)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258189);
          return 0;
        case 2: 
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
            localbxt.musicInfo = ((bqj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258189);
          return 0;
        case 3: 
          localbxt.audioTrackUrl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258189);
          return 0;
        }
        localbxt.groupId = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258189);
        return 0;
      }
      AppMethodBeat.o(258189);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxt
 * JD-Core Version:    0.7.0.1
 */