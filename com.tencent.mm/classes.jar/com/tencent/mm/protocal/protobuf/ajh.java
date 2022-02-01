package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ajh
  extends dyy
{
  public String HlB;
  public eii RMf;
  public cke RRh;
  public qr RRi;
  public dca RRj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155403);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(155403);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HlB != null) {
        paramVarArgs.f(2, this.HlB);
      }
      if (this.RRi != null)
      {
        paramVarArgs.oE(3, this.RRi.computeSize());
        this.RRi.writeFields(paramVarArgs);
      }
      if (this.RRh != null)
      {
        paramVarArgs.oE(4, this.RRh.computeSize());
        this.RRh.writeFields(paramVarArgs);
      }
      if (this.RMf != null)
      {
        paramVarArgs.oE(5, this.RMf.computeSize());
        this.RMf.writeFields(paramVarArgs);
      }
      if (this.RRj != null)
      {
        paramVarArgs.oE(6, this.RRj.computeSize());
        this.RRj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155403);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label928;
      }
    }
    label928:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HlB != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.HlB);
      }
      i = paramInt;
      if (this.RRi != null) {
        i = paramInt + g.a.a.a.oD(3, this.RRi.computeSize());
      }
      paramInt = i;
      if (this.RRh != null) {
        paramInt = i + g.a.a.a.oD(4, this.RRh.computeSize());
      }
      i = paramInt;
      if (this.RMf != null) {
        i = paramInt + g.a.a.a.oD(5, this.RMf.computeSize());
      }
      paramInt = i;
      if (this.RRj != null) {
        paramInt = i + g.a.a.a.oD(6, this.RRj.computeSize());
      }
      AppMethodBeat.o(155403);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(155403);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155403);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ajh localajh = (ajh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155403);
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
            localajh.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155403);
          return 0;
        case 2: 
          localajh.HlB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155403);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new qr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((qr)localObject2).parseFrom((byte[])localObject1);
            }
            localajh.RRi = ((qr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155403);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cke();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cke)localObject2).parseFrom((byte[])localObject1);
            }
            localajh.RRh = ((cke)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155403);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eii();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eii)localObject2).parseFrom((byte[])localObject1);
            }
            localajh.RMf = ((eii)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155403);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dca();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dca)localObject2).parseFrom((byte[])localObject1);
          }
          localajh.RRj = ((dca)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(155403);
        return 0;
      }
      AppMethodBeat.o(155403);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajh
 * JD-Core Version:    0.7.0.1
 */