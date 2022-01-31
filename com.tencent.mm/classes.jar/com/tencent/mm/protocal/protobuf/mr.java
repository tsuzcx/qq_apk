package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mr
  extends buy
{
  public cz wAZ;
  public int wBD;
  public int wBE;
  public long wBF;
  public String wBo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56726);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wAZ != null)
      {
        paramVarArgs.iQ(2, this.wAZ.computeSize());
        this.wAZ.writeFields(paramVarArgs);
      }
      if (this.wBo != null) {
        paramVarArgs.e(3, this.wBo);
      }
      paramVarArgs.aO(4, this.wBD);
      paramVarArgs.aO(5, this.wBE);
      paramVarArgs.am(6, this.wBF);
      AppMethodBeat.o(56726);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label662;
      }
    }
    label662:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wAZ != null) {
        paramInt = i + e.a.a.a.iP(2, this.wAZ.computeSize());
      }
      i = paramInt;
      if (this.wBo != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wBo);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.wBD);
      int j = e.a.a.b.b.a.bl(5, this.wBE);
      int k = e.a.a.b.b.a.p(6, this.wBF);
      AppMethodBeat.o(56726);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56726);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        mr localmr = (mr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56726);
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
            localmr.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56726);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cz();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localmr.wAZ = ((cz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56726);
          return 0;
        case 3: 
          localmr.wBo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56726);
          return 0;
        case 4: 
          localmr.wBD = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56726);
          return 0;
        case 5: 
          localmr.wBE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56726);
          return 0;
        }
        localmr.wBF = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(56726);
        return 0;
      }
      AppMethodBeat.o(56726);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mr
 * JD-Core Version:    0.7.0.1
 */