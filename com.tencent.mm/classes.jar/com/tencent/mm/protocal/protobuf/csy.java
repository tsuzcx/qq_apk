package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csy
  extends buy
{
  public int wQP;
  public long wQQ;
  public int xCv;
  public int ybZ;
  public int yca;
  public LinkedList<ctb> ycb;
  public int ycc;
  
  public csy()
  {
    AppMethodBeat.i(5259);
    this.ycb = new LinkedList();
    AppMethodBeat.o(5259);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5260);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wQP);
      paramVarArgs.am(3, this.wQQ);
      paramVarArgs.aO(4, this.xCv);
      paramVarArgs.aO(5, this.ybZ);
      paramVarArgs.aO(6, this.yca);
      paramVarArgs.e(7, 8, this.ycb);
      paramVarArgs.aO(8, this.ycc);
      AppMethodBeat.o(5260);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label748;
      }
    }
    label748:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.wQP);
      int j = e.a.a.b.b.a.p(3, this.wQQ);
      int k = e.a.a.b.b.a.bl(4, this.xCv);
      int m = e.a.a.b.b.a.bl(5, this.ybZ);
      int n = e.a.a.b.b.a.bl(6, this.yca);
      int i1 = e.a.a.a.c(7, 8, this.ycb);
      int i2 = e.a.a.b.b.a.bl(8, this.ycc);
      AppMethodBeat.o(5260);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ycb.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(5260);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        csy localcsy = (csy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5260);
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
            localcsy.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5260);
          return 0;
        case 2: 
          localcsy.wQP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5260);
          return 0;
        case 3: 
          localcsy.wQQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(5260);
          return 0;
        case 4: 
          localcsy.xCv = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5260);
          return 0;
        case 5: 
          localcsy.ybZ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5260);
          return 0;
        case 6: 
          localcsy.yca = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5260);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctb();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctb)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcsy.ycb.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5260);
          return 0;
        }
        localcsy.ycc = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5260);
        return 0;
      }
      AppMethodBeat.o(5260);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csy
 * JD-Core Version:    0.7.0.1
 */