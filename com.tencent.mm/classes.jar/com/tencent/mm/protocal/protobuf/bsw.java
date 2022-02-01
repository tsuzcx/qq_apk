package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bsw
  extends dyy
{
  public LinkedList<qj> RLp;
  public int RMi;
  public int Saq;
  public int Sat;
  public long TaE;
  public int Tda;
  
  public bsw()
  {
    AppMethodBeat.i(117869);
    this.RLp = new LinkedList();
    AppMethodBeat.o(117869);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117870);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.RLp);
      paramVarArgs.aY(3, this.Saq);
      paramVarArgs.aY(4, this.Tda);
      paramVarArgs.aY(5, this.RMi);
      paramVarArgs.bm(6, this.TaE);
      paramVarArgs.aY(7, this.Sat);
      AppMethodBeat.o(117870);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.RLp);
      int j = g.a.a.b.b.a.bM(3, this.Saq);
      int k = g.a.a.b.b.a.bM(4, this.Tda);
      int m = g.a.a.b.b.a.bM(5, this.RMi);
      int n = g.a.a.b.b.a.p(6, this.TaE);
      int i1 = g.a.a.b.b.a.bM(7, this.Sat);
      AppMethodBeat.o(117870);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RLp.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117870);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bsw localbsw = (bsw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117870);
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
            localbsw.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117870);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new qj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((qj)localObject2).parseFrom((byte[])localObject1);
            }
            localbsw.RLp.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117870);
          return 0;
        case 3: 
          localbsw.Saq = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117870);
          return 0;
        case 4: 
          localbsw.Tda = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117870);
          return 0;
        case 5: 
          localbsw.RMi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117870);
          return 0;
        case 6: 
          localbsw.TaE = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(117870);
          return 0;
        }
        localbsw.Sat = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117870);
        return 0;
      }
      AppMethodBeat.o(117870);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsw
 * JD-Core Version:    0.7.0.1
 */