package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtm
  extends com.tencent.mm.bx.a
{
  public fmp YCT;
  public dto aaZi;
  public dtn aaZj;
  public dtn aaZk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91550);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YCT != null)
      {
        paramVarArgs.qD(1, this.YCT.computeSize());
        this.YCT.writeFields(paramVarArgs);
      }
      if (this.aaZi != null)
      {
        paramVarArgs.qD(2, this.aaZi.computeSize());
        this.aaZi.writeFields(paramVarArgs);
      }
      if (this.aaZj != null)
      {
        paramVarArgs.qD(3, this.aaZj.computeSize());
        this.aaZj.writeFields(paramVarArgs);
      }
      if (this.aaZk != null)
      {
        paramVarArgs.qD(4, this.aaZk.computeSize());
        this.aaZk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91550);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YCT == null) {
        break label682;
      }
    }
    label682:
    for (int i = i.a.a.a.qC(1, this.YCT.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaZi != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaZi.computeSize());
      }
      i = paramInt;
      if (this.aaZj != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaZj.computeSize());
      }
      paramInt = i;
      if (this.aaZk != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaZk.computeSize());
      }
      AppMethodBeat.o(91550);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91550);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dtm localdtm = (dtm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91550);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fmp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fmp)localObject2).parseFrom((byte[])localObject1);
            }
            localdtm.YCT = ((fmp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91550);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dto();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dto)localObject2).parseFrom((byte[])localObject1);
            }
            localdtm.aaZi = ((dto)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91550);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtn)localObject2).parseFrom((byte[])localObject1);
            }
            localdtm.aaZj = ((dtn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91550);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dtn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dtn)localObject2).parseFrom((byte[])localObject1);
          }
          localdtm.aaZk = ((dtn)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91550);
        return 0;
      }
      AppMethodBeat.o(91550);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtm
 * JD-Core Version:    0.7.0.1
 */