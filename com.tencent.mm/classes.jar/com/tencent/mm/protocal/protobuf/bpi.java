package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpi
  extends com.tencent.mm.bx.a
{
  public String ZXU;
  public bqj musicInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258130);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZXU != null) {
        paramVarArgs.g(1, this.ZXU);
      }
      if (this.musicInfo != null)
      {
        paramVarArgs.qD(2, this.musicInfo.computeSize());
        this.musicInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258130);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZXU == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZXU) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.musicInfo != null) {
        i = paramInt + i.a.a.a.qC(2, this.musicInfo.computeSize());
      }
      AppMethodBeat.o(258130);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258130);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bpi localbpi = (bpi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258130);
          return -1;
        case 1: 
          localbpi.ZXU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258130);
          return 0;
        }
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
          localbpi.musicInfo = localbqj;
          paramInt += 1;
        }
        AppMethodBeat.o(258130);
        return 0;
      }
      AppMethodBeat.o(258130);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpi
 * JD-Core Version:    0.7.0.1
 */