package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cqj
  extends dyy
{
  public int JWa;
  public int Tdj;
  public LinkedList<cqe> Tdk;
  public int TxT;
  public int TxU;
  public int TxV;
  
  public cqj()
  {
    AppMethodBeat.i(89927);
    this.Tdk = new LinkedList();
    AppMethodBeat.o(89927);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89928);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(89928);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Tdj);
      paramVarArgs.e(3, 8, this.Tdk);
      paramVarArgs.aY(4, this.JWa);
      paramVarArgs.aY(5, this.TxT);
      paramVarArgs.aY(6, this.TxU);
      paramVarArgs.aY(7, this.TxV);
      AppMethodBeat.o(89928);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.Tdj);
      int j = g.a.a.a.c(3, 8, this.Tdk);
      int k = g.a.a.b.b.a.bM(4, this.JWa);
      int m = g.a.a.b.b.a.bM(5, this.TxT);
      int n = g.a.a.b.b.a.bM(6, this.TxU);
      int i1 = g.a.a.b.b.a.bM(7, this.TxV);
      AppMethodBeat.o(89928);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tdk.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(89928);
          throw paramVarArgs;
        }
        AppMethodBeat.o(89928);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cqj localcqj = (cqj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89928);
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
            localcqj.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(89928);
          return 0;
        case 2: 
          localcqj.Tdj = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(89928);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cqe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cqe)localObject2).parseFrom((byte[])localObject1);
            }
            localcqj.Tdk.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(89928);
          return 0;
        case 4: 
          localcqj.JWa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(89928);
          return 0;
        case 5: 
          localcqj.TxT = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(89928);
          return 0;
        case 6: 
          localcqj.TxU = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(89928);
          return 0;
        }
        localcqj.TxV = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(89928);
        return 0;
      }
      AppMethodBeat.o(89928);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqj
 * JD-Core Version:    0.7.0.1
 */