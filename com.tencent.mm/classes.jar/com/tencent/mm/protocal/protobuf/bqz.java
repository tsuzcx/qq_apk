package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bqz
  extends com.tencent.mm.bx.a
{
  public int ZZa;
  public String groupId;
  public bqj musicInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257536);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.musicInfo != null)
      {
        paramVarArgs.qD(1, this.musicInfo.computeSize());
        this.musicInfo.writeFields(paramVarArgs);
      }
      if (this.groupId != null) {
        paramVarArgs.g(2, this.groupId);
      }
      paramVarArgs.bS(3, this.ZZa);
      AppMethodBeat.o(257536);
      return 0;
    }
    if (paramInt == 1) {
      if (this.musicInfo == null) {
        break label388;
      }
    }
    label388:
    for (paramInt = i.a.a.a.qC(1, this.musicInfo.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.groupId != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.groupId);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.ZZa);
      AppMethodBeat.o(257536);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257536);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bqz localbqz = (bqz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257536);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bqj localbqj = new bqj();
            if ((localObject != null) && (localObject.length > 0)) {
              localbqj.parseFrom((byte[])localObject);
            }
            localbqz.musicInfo = localbqj;
            paramInt += 1;
          }
          AppMethodBeat.o(257536);
          return 0;
        case 2: 
          localbqz.groupId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257536);
          return 0;
        }
        localbqz.ZZa = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257536);
        return 0;
      }
      AppMethodBeat.o(257536);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqz
 * JD-Core Version:    0.7.0.1
 */