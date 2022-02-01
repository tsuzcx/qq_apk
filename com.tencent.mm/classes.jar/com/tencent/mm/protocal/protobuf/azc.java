package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azc
  extends dyy
{
  public aze SFh;
  public bal xHW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230726);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xHW != null)
      {
        paramVarArgs.oE(2, this.xHW.computeSize());
        this.xHW.writeFields(paramVarArgs);
      }
      if (this.SFh != null)
      {
        paramVarArgs.oE(3, this.SFh.computeSize());
        this.SFh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(230726);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label552;
      }
    }
    label552:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xHW != null) {
        paramInt = i + g.a.a.a.oD(2, this.xHW.computeSize());
      }
      i = paramInt;
      if (this.SFh != null) {
        i = paramInt + g.a.a.a.oD(3, this.SFh.computeSize());
      }
      AppMethodBeat.o(230726);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230726);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        azc localazc = (azc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230726);
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
            localazc.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230726);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bal();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bal)localObject2).parseFrom((byte[])localObject1);
            }
            localazc.xHW = ((bal)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230726);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aze();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aze)localObject2).parseFrom((byte[])localObject1);
          }
          localazc.SFh = ((aze)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(230726);
        return 0;
      }
      AppMethodBeat.o(230726);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azc
 * JD-Core Version:    0.7.0.1
 */