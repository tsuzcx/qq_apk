package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bli
  extends dyy
{
  public blf SWu;
  public blg SWv;
  public bfg musicInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(204738);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.SWu != null)
      {
        paramVarArgs.oE(2, this.SWu.computeSize());
        this.SWu.writeFields(paramVarArgs);
      }
      if (this.SWv != null)
      {
        paramVarArgs.oE(3, this.SWv.computeSize());
        this.SWv.writeFields(paramVarArgs);
      }
      if (this.musicInfo != null)
      {
        paramVarArgs.oE(4, this.musicInfo.computeSize());
        this.musicInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(204738);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label686;
      }
    }
    label686:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SWu != null) {
        paramInt = i + g.a.a.a.oD(2, this.SWu.computeSize());
      }
      i = paramInt;
      if (this.SWv != null) {
        i = paramInt + g.a.a.a.oD(3, this.SWv.computeSize());
      }
      paramInt = i;
      if (this.musicInfo != null) {
        paramInt = i + g.a.a.a.oD(4, this.musicInfo.computeSize());
      }
      AppMethodBeat.o(204738);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(204738);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bli localbli = (bli)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(204738);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localbli.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(204738);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new blf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((blf)localObject2).parseFrom((byte[])localObject1);
            }
            localbli.SWu = ((blf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(204738);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new blg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((blg)localObject2).parseFrom((byte[])localObject1);
            }
            localbli.SWv = ((blg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(204738);
          return 0;
        }
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
          localbli.musicInfo = ((bfg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(204738);
        return 0;
      }
      AppMethodBeat.o(204738);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bli
 * JD-Core Version:    0.7.0.1
 */