package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dpj
  extends dyy
{
  public LinkedList<doy> RNx;
  public int Svu;
  public long Svv;
  public LinkedList<doy> TWn;
  
  public dpj()
  {
    AppMethodBeat.i(32384);
    this.RNx = new LinkedList();
    this.TWn = new LinkedList();
    AppMethodBeat.o(32384);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32385);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32385);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Svu);
      paramVarArgs.bm(3, this.Svv);
      paramVarArgs.e(4, 8, this.RNx);
      paramVarArgs.e(5, 8, this.TWn);
      AppMethodBeat.o(32385);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label679;
      }
    }
    label679:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.Svu);
      int j = g.a.a.b.b.a.p(3, this.Svv);
      int k = g.a.a.a.c(4, 8, this.RNx);
      int m = g.a.a.a.c(5, 8, this.TWn);
      AppMethodBeat.o(32385);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RNx.clear();
        this.TWn.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32385);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32385);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dpj localdpj = (dpj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32385);
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
            localdpj.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32385);
          return 0;
        case 2: 
          localdpj.Svu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32385);
          return 0;
        case 3: 
          localdpj.Svv = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(32385);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new doy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((doy)localObject2).parseFrom((byte[])localObject1);
            }
            localdpj.RNx.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32385);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new doy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((doy)localObject2).parseFrom((byte[])localObject1);
          }
          localdpj.TWn.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32385);
        return 0;
      }
      AppMethodBeat.o(32385);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpj
 * JD-Core Version:    0.7.0.1
 */