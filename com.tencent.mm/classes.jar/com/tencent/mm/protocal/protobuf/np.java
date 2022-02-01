package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class np
  extends dyy
{
  public dsk RUv;
  public LinkedList<nn> RUw;
  public boolean RUx;
  
  public np()
  {
    AppMethodBeat.i(124423);
    this.RUw = new LinkedList();
    AppMethodBeat.o(124423);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124424);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124424);
        throw paramVarArgs;
      }
      if (this.RUv == null)
      {
        paramVarArgs = new b("Not all required fields were included: qy_base_resp");
        AppMethodBeat.o(124424);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.RUv != null)
      {
        paramVarArgs.oE(2, this.RUv.computeSize());
        this.RUv.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.RUw);
      paramVarArgs.co(4, this.RUx);
      AppMethodBeat.o(124424);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label680;
      }
    }
    label680:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RUv != null) {
        i = paramInt + g.a.a.a.oD(2, this.RUv.computeSize());
      }
      paramInt = g.a.a.a.c(3, 8, this.RUw);
      int j = g.a.a.b.b.a.gL(4);
      AppMethodBeat.o(124424);
      return i + paramInt + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RUw.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124424);
          throw paramVarArgs;
        }
        if (this.RUv == null)
        {
          paramVarArgs = new b("Not all required fields were included: qy_base_resp");
          AppMethodBeat.o(124424);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124424);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        np localnp = (np)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124424);
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
            localnp.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124424);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dsk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dsk)localObject2).parseFrom((byte[])localObject1);
            }
            localnp.RUv = ((dsk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124424);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new nn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((nn)localObject2).parseFrom((byte[])localObject1);
            }
            localnp.RUw.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124424);
          return 0;
        }
        localnp.RUx = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(124424);
        return 0;
      }
      AppMethodBeat.o(124424);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.np
 * JD-Core Version:    0.7.0.1
 */