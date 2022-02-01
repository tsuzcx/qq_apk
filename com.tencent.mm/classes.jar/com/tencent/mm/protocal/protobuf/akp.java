package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class akp
  extends dyy
{
  public LinkedList<equ> RIk;
  public int RNw;
  public LinkedList<eqt> RNx;
  public int Svu;
  public long Svv;
  public int Svw;
  public int Svx;
  public int Svy;
  
  public akp()
  {
    AppMethodBeat.i(32191);
    this.RIk = new LinkedList();
    this.RNx = new LinkedList();
    AppMethodBeat.o(32191);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32192);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32192);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Svu);
      paramVarArgs.bm(3, this.Svv);
      paramVarArgs.aY(4, this.Svw);
      paramVarArgs.aY(5, this.Svx);
      paramVarArgs.e(6, 8, this.RIk);
      paramVarArgs.aY(7, this.Svy);
      paramVarArgs.aY(8, this.RNw);
      paramVarArgs.e(9, 8, this.RNx);
      AppMethodBeat.o(32192);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label875;
      }
    }
    label875:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.Svu);
      int j = g.a.a.b.b.a.p(3, this.Svv);
      int k = g.a.a.b.b.a.bM(4, this.Svw);
      int m = g.a.a.b.b.a.bM(5, this.Svx);
      int n = g.a.a.a.c(6, 8, this.RIk);
      int i1 = g.a.a.b.b.a.bM(7, this.Svy);
      int i2 = g.a.a.b.b.a.bM(8, this.RNw);
      int i3 = g.a.a.a.c(9, 8, this.RNx);
      AppMethodBeat.o(32192);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RIk.clear();
        this.RNx.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32192);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32192);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        akp localakp = (akp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32192);
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
            localakp.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32192);
          return 0;
        case 2: 
          localakp.Svu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32192);
          return 0;
        case 3: 
          localakp.Svv = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(32192);
          return 0;
        case 4: 
          localakp.Svw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32192);
          return 0;
        case 5: 
          localakp.Svx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32192);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new equ();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((equ)localObject2).parseFrom((byte[])localObject1);
            }
            localakp.RIk.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32192);
          return 0;
        case 7: 
          localakp.Svy = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32192);
          return 0;
        case 8: 
          localakp.RNw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32192);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eqt();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eqt)localObject2).parseFrom((byte[])localObject1);
          }
          localakp.RNx.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32192);
        return 0;
      }
      AppMethodBeat.o(32192);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akp
 * JD-Core Version:    0.7.0.1
 */