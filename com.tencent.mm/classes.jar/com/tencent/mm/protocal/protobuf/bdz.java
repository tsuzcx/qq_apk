package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bdz
  extends buy
{
  public int Scene;
  public int woD;
  public LinkedList<beb> wuP;
  public int xtM;
  public LinkedList<bdy> xtN;
  public int xtO;
  public String xtP;
  
  public bdz()
  {
    AppMethodBeat.i(51429);
    this.xtN = new LinkedList();
    this.wuP = new LinkedList();
    AppMethodBeat.o(51429);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51430);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.woD);
      paramVarArgs.aO(3, this.xtM);
      paramVarArgs.e(4, 8, this.xtN);
      paramVarArgs.aO(5, this.xtO);
      paramVarArgs.e(6, 8, this.wuP);
      if (this.xtP != null) {
        paramVarArgs.e(7, this.xtP);
      }
      paramVarArgs.aO(8, this.Scene);
      AppMethodBeat.o(51430);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label826;
      }
    }
    label826:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.woD) + e.a.a.b.b.a.bl(3, this.xtM) + e.a.a.a.c(4, 8, this.xtN) + e.a.a.b.b.a.bl(5, this.xtO) + e.a.a.a.c(6, 8, this.wuP);
      paramInt = i;
      if (this.xtP != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xtP);
      }
      i = e.a.a.b.b.a.bl(8, this.Scene);
      AppMethodBeat.o(51430);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xtN.clear();
        this.wuP.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(51430);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bdz localbdz = (bdz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(51430);
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
            localbdz.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(51430);
          return 0;
        case 2: 
          localbdz.woD = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51430);
          return 0;
        case 3: 
          localbdz.xtM = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51430);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bdy();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bdy)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbdz.xtN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(51430);
          return 0;
        case 5: 
          localbdz.xtO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51430);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new beb();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((beb)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbdz.wuP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(51430);
          return 0;
        case 7: 
          localbdz.xtP = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51430);
          return 0;
        }
        localbdz.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(51430);
        return 0;
      }
      AppMethodBeat.o(51430);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdz
 * JD-Core Version:    0.7.0.1
 */