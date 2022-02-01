package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbn
  extends dyy
{
  public long yiz;
  public long zaI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231104);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.yiz);
      paramVarArgs.bm(3, this.zaI);
      AppMethodBeat.o(231104);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label380;
      }
    }
    label380:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.p(2, this.yiz);
      int j = g.a.a.b.b.a.p(3, this.zaI);
      AppMethodBeat.o(231104);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231104);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bbn localbbn = (bbn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231104);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localbbn.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(231104);
          return 0;
        case 2: 
          localbbn.yiz = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(231104);
          return 0;
        }
        localbbn.zaI = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(231104);
        return 0;
      }
      AppMethodBeat.o(231104);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbn
 * JD-Core Version:    0.7.0.1
 */