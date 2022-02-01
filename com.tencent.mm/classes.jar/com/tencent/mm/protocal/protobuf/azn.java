package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azn
  extends cvp
{
  public int FMr;
  public int FMu;
  public LinkedList<pn> Fys;
  public int Fzh;
  public long Guq;
  public int GwL;
  
  public azn()
  {
    AppMethodBeat.i(117869);
    this.Fys = new LinkedList();
    AppMethodBeat.o(117869);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117870);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Fys);
      paramVarArgs.aS(3, this.FMr);
      paramVarArgs.aS(4, this.GwL);
      paramVarArgs.aS(5, this.Fzh);
      paramVarArgs.aY(6, this.Guq);
      paramVarArgs.aS(7, this.FMu);
      AppMethodBeat.o(117870);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label686;
      }
    }
    label686:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.Fys);
      int j = f.a.a.b.b.a.bz(3, this.FMr);
      int k = f.a.a.b.b.a.bz(4, this.GwL);
      int m = f.a.a.b.b.a.bz(5, this.Fzh);
      int n = f.a.a.b.b.a.p(6, this.Guq);
      int i1 = f.a.a.b.b.a.bz(7, this.FMu);
      AppMethodBeat.o(117870);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Fys.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117870);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        azn localazn = (azn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117870);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117870);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazn.Fys.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117870);
          return 0;
        case 3: 
          localazn.FMr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117870);
          return 0;
        case 4: 
          localazn.GwL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117870);
          return 0;
        case 5: 
          localazn.Fzh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117870);
          return 0;
        case 6: 
          localazn.Guq = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(117870);
          return 0;
        }
        localazn.FMu = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117870);
        return 0;
      }
      AppMethodBeat.o(117870);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azn
 * JD-Core Version:    0.7.0.1
 */