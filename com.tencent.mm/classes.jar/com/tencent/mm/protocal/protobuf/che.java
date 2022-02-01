package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class che
  extends dyl
{
  public int ToD;
  public int ToE;
  public int ToF;
  public int bnA;
  public int oRY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123598);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.bnA);
      paramVarArgs.aY(3, this.oRY);
      paramVarArgs.aY(4, this.ToD);
      paramVarArgs.aY(5, this.ToE);
      paramVarArgs.aY(6, this.ToF);
      AppMethodBeat.o(123598);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label520;
      }
    }
    label520:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.bnA);
      int j = g.a.a.b.b.a.bM(3, this.oRY);
      int k = g.a.a.b.b.a.bM(4, this.ToD);
      int m = g.a.a.b.b.a.bM(5, this.ToE);
      int n = g.a.a.b.b.a.bM(6, this.ToF);
      AppMethodBeat.o(123598);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123598);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        che localche = (che)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123598);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localche.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(123598);
          return 0;
        case 2: 
          localche.bnA = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(123598);
          return 0;
        case 3: 
          localche.oRY = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(123598);
          return 0;
        case 4: 
          localche.ToD = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(123598);
          return 0;
        case 5: 
          localche.ToE = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(123598);
          return 0;
        }
        localche.ToF = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(123598);
        return 0;
      }
      AppMethodBeat.o(123598);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.che
 * JD-Core Version:    0.7.0.1
 */