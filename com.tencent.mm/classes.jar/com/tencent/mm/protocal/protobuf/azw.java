package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azw
  extends dyy
{
  public blm SKr;
  public String SLt;
  public bcs SLu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229591);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.SLu != null)
      {
        paramVarArgs.oE(2, this.SLu.computeSize());
        this.SLu.writeFields(paramVarArgs);
      }
      if (this.SLt != null) {
        paramVarArgs.f(3, this.SLt);
      }
      if (this.SKr != null)
      {
        paramVarArgs.oE(4, this.SKr.computeSize());
        this.SKr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(229591);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label612;
      }
    }
    label612:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SLu != null) {
        paramInt = i + g.a.a.a.oD(2, this.SLu.computeSize());
      }
      i = paramInt;
      if (this.SLt != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SLt);
      }
      paramInt = i;
      if (this.SKr != null) {
        paramInt = i + g.a.a.a.oD(4, this.SKr.computeSize());
      }
      AppMethodBeat.o(229591);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229591);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        azw localazw = (azw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(229591);
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
            localazw.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229591);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bcs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bcs)localObject2).parseFrom((byte[])localObject1);
            }
            localazw.SLu = ((bcs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229591);
          return 0;
        case 3: 
          localazw.SLt = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(229591);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new blm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((blm)localObject2).parseFrom((byte[])localObject1);
          }
          localazw.SKr = ((blm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(229591);
        return 0;
      }
      AppMethodBeat.o(229591);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azw
 * JD-Core Version:    0.7.0.1
 */