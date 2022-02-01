package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eqr
  extends dyl
{
  public int CPw;
  public int RIt;
  public int Svu;
  public long Svv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32464);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Svu);
      paramVarArgs.bm(3, this.Svv);
      paramVarArgs.aY(4, this.RIt);
      paramVarArgs.aY(5, this.CPw);
      AppMethodBeat.o(32464);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label483;
      }
    }
    label483:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.Svu);
      int j = g.a.a.b.b.a.p(3, this.Svv);
      int k = g.a.a.b.b.a.bM(4, this.RIt);
      int m = g.a.a.b.b.a.bM(5, this.CPw);
      AppMethodBeat.o(32464);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32464);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        eqr localeqr = (eqr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32464);
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
            localeqr.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(32464);
          return 0;
        case 2: 
          localeqr.Svu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32464);
          return 0;
        case 3: 
          localeqr.Svv = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(32464);
          return 0;
        case 4: 
          localeqr.RIt = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32464);
          return 0;
        }
        localeqr.CPw = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32464);
        return 0;
      }
      AppMethodBeat.o(32464);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqr
 * JD-Core Version:    0.7.0.1
 */