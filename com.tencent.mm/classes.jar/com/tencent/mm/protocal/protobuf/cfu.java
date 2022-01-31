package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cfu
  extends com.tencent.mm.bv.a
{
  public int xQb;
  public int xQc;
  public int xQd;
  public crm xQe;
  public int xQf;
  public int xQg;
  public int xQh;
  public int xQi;
  public LinkedList<Integer> xQj;
  public int xQk;
  public LinkedList<Integer> xQl;
  public int xQm;
  public LinkedList<Integer> xQn;
  
  public cfu()
  {
    AppMethodBeat.i(5219);
    this.xQj = new LinkedList();
    this.xQl = new LinkedList();
    this.xQn = new LinkedList();
    AppMethodBeat.o(5219);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5220);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xQe == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Addr");
        AppMethodBeat.o(5220);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.xQb);
      paramVarArgs.aO(2, this.xQc);
      paramVarArgs.aO(3, this.xQd);
      if (this.xQe != null)
      {
        paramVarArgs.iQ(4, this.xQe.computeSize());
        this.xQe.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.xQf);
      paramVarArgs.aO(6, this.xQg);
      paramVarArgs.aO(7, this.xQh);
      paramVarArgs.aO(8, this.xQi);
      paramVarArgs.f(9, 2, this.xQj);
      paramVarArgs.aO(10, this.xQk);
      paramVarArgs.f(11, 2, this.xQl);
      paramVarArgs.aO(12, this.xQm);
      paramVarArgs.f(13, 2, this.xQn);
      AppMethodBeat.o(5220);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.xQb) + 0 + e.a.a.b.b.a.bl(2, this.xQc) + e.a.a.b.b.a.bl(3, this.xQd);
      paramInt = i;
      if (this.xQe != null) {
        paramInt = i + e.a.a.a.iP(4, this.xQe.computeSize());
      }
      i = e.a.a.b.b.a.bl(5, this.xQf);
      int j = e.a.a.b.b.a.bl(6, this.xQg);
      int k = e.a.a.b.b.a.bl(7, this.xQh);
      int m = e.a.a.b.b.a.bl(8, this.xQi);
      int n = e.a.a.a.d(9, 2, this.xQj);
      int i1 = e.a.a.b.b.a.bl(10, this.xQk);
      int i2 = e.a.a.a.d(11, 2, this.xQl);
      int i3 = e.a.a.b.b.a.bl(12, this.xQm);
      int i4 = e.a.a.a.d(13, 2, this.xQn);
      AppMethodBeat.o(5220);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xQj.clear();
      this.xQl.clear();
      this.xQn.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.xQe == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Addr");
        AppMethodBeat.o(5220);
        throw paramVarArgs;
      }
      AppMethodBeat.o(5220);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      cfu localcfu = (cfu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(5220);
        return -1;
      case 1: 
        localcfu.xQb = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5220);
        return 0;
      case 2: 
        localcfu.xQc = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5220);
        return 0;
      case 3: 
        localcfu.xQd = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5220);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcfu.xQe = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(5220);
        return 0;
      case 5: 
        localcfu.xQf = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5220);
        return 0;
      case 6: 
        localcfu.xQg = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5220);
        return 0;
      case 7: 
        localcfu.xQh = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5220);
        return 0;
      case 8: 
        localcfu.xQi = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5220);
        return 0;
      case 9: 
        localcfu.xQj = new e.a.a.a.a(((e.a.a.a.a)localObject1).CLY.eqS().pW, unknownTagHandler).CLY.eqR();
        AppMethodBeat.o(5220);
        return 0;
      case 10: 
        localcfu.xQk = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5220);
        return 0;
      case 11: 
        localcfu.xQl = new e.a.a.a.a(((e.a.a.a.a)localObject1).CLY.eqS().pW, unknownTagHandler).CLY.eqR();
        AppMethodBeat.o(5220);
        return 0;
      case 12: 
        localcfu.xQm = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5220);
        return 0;
      }
      localcfu.xQn = new e.a.a.a.a(((e.a.a.a.a)localObject1).CLY.eqS().pW, unknownTagHandler).CLY.eqR();
      AppMethodBeat.o(5220);
      return 0;
    }
    AppMethodBeat.o(5220);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfu
 * JD-Core Version:    0.7.0.1
 */