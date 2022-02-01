package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ens
  extends dyy
{
  public int SXb;
  public String UlA;
  public int Unb;
  public long Uqk;
  public int Uqw;
  public LinkedList<enq> Uqx;
  
  public ens()
  {
    AppMethodBeat.i(118450);
    this.Uqx = new LinkedList();
    AppMethodBeat.o(118450);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118451);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118451);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.UlA != null) {
        paramVarArgs.f(2, this.UlA);
      }
      paramVarArgs.aY(3, this.Uqw);
      paramVarArgs.e(4, 8, this.Uqx);
      paramVarArgs.aY(5, this.Unb);
      paramVarArgs.bm(6, this.Uqk);
      paramVarArgs.aY(7, this.SXb);
      AppMethodBeat.o(118451);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label702;
      }
    }
    label702:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UlA != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UlA);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.Uqw);
      int j = g.a.a.a.c(4, 8, this.Uqx);
      int k = g.a.a.b.b.a.bM(5, this.Unb);
      int m = g.a.a.b.b.a.p(6, this.Uqk);
      int n = g.a.a.b.b.a.bM(7, this.SXb);
      AppMethodBeat.o(118451);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Uqx.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(118451);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118451);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ens localens = (ens)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118451);
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
            localens.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(118451);
          return 0;
        case 2: 
          localens.UlA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(118451);
          return 0;
        case 3: 
          localens.Uqw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(118451);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new enq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((enq)localObject2).parseFrom((byte[])localObject1);
            }
            localens.Uqx.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(118451);
          return 0;
        case 5: 
          localens.Unb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(118451);
          return 0;
        case 6: 
          localens.Uqk = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(118451);
          return 0;
        }
        localens.SXb = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(118451);
        return 0;
      }
      AppMethodBeat.o(118451);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ens
 * JD-Core Version:    0.7.0.1
 */