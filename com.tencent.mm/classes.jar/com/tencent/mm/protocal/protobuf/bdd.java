package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bdd
  extends bvk
{
  public int CreateTime;
  public int Ret;
  public int jKs;
  public int pIE;
  public long pIG;
  public bwc woQ;
  public int wsb;
  public int xtf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60045);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.woQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(60045);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.Ret);
      if (this.woQ != null)
      {
        paramVarArgs.iQ(2, this.woQ.computeSize());
        this.woQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.pIE);
      paramVarArgs.aO(4, this.xtf);
      paramVarArgs.aO(5, this.CreateTime);
      paramVarArgs.aO(6, this.wsb);
      paramVarArgs.aO(7, this.jKs);
      paramVarArgs.am(8, this.pIG);
      AppMethodBeat.o(60045);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.Ret) + 0;
      paramInt = i;
      if (this.woQ != null) {
        paramInt = i + e.a.a.a.iP(2, this.woQ.computeSize());
      }
      i = e.a.a.b.b.a.bl(3, this.pIE);
      int j = e.a.a.b.b.a.bl(4, this.xtf);
      int k = e.a.a.b.b.a.bl(5, this.CreateTime);
      int m = e.a.a.b.b.a.bl(6, this.wsb);
      int n = e.a.a.b.b.a.bl(7, this.jKs);
      int i1 = e.a.a.b.b.a.p(8, this.pIG);
      AppMethodBeat.o(60045);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.woQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(60045);
        throw paramVarArgs;
      }
      AppMethodBeat.o(60045);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bdd localbdd = (bdd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(60045);
        return -1;
      case 1: 
        localbdd.Ret = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60045);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbdd.woQ = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(60045);
        return 0;
      case 3: 
        localbdd.pIE = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60045);
        return 0;
      case 4: 
        localbdd.xtf = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60045);
        return 0;
      case 5: 
        localbdd.CreateTime = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60045);
        return 0;
      case 6: 
        localbdd.wsb = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60045);
        return 0;
      case 7: 
        localbdd.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60045);
        return 0;
      }
      localbdd.pIG = ((e.a.a.a.a)localObject1).CLY.sm();
      AppMethodBeat.o(60045);
      return 0;
    }
    AppMethodBeat.o(60045);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdd
 * JD-Core Version:    0.7.0.1
 */