package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqj
  extends buy
{
  public int nqn;
  public LinkedList<bwc> nsF;
  public int nsV;
  public int nsW;
  public String nsa;
  public int xfN;
  
  public aqj()
  {
    AppMethodBeat.i(80097);
    this.nsF = new LinkedList();
    AppMethodBeat.o(80097);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80098);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.nqn);
      paramVarArgs.aO(3, this.nsV);
      paramVarArgs.aO(4, this.nsW);
      if (this.nsa != null) {
        paramVarArgs.e(5, this.nsa);
      }
      paramVarArgs.aO(6, this.xfN);
      paramVarArgs.e(7, 8, this.nsF);
      AppMethodBeat.o(80098);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.nqn) + e.a.a.b.b.a.bl(3, this.nsV) + e.a.a.b.b.a.bl(4, this.nsW);
      paramInt = i;
      if (this.nsa != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.nsa);
      }
      i = e.a.a.b.b.a.bl(6, this.xfN);
      int j = e.a.a.a.c(7, 8, this.nsF);
      AppMethodBeat.o(80098);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nsF.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80098);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aqj localaqj = (aqj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80098);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaqj.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80098);
          return 0;
        case 2: 
          localaqj.nqn = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80098);
          return 0;
        case 3: 
          localaqj.nsV = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80098);
          return 0;
        case 4: 
          localaqj.nsW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80098);
          return 0;
        case 5: 
          localaqj.nsa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80098);
          return 0;
        case 6: 
          localaqj.xfN = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80098);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaqj.nsF.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(80098);
        return 0;
      }
      AppMethodBeat.o(80098);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqj
 * JD-Core Version:    0.7.0.1
 */