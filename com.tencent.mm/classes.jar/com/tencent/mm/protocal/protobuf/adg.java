package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adg
  extends com.tencent.mm.bv.a
{
  public String qiO;
  public LinkedList<adh> wAS;
  public String wIJ;
  public String wVK;
  public long wVL;
  public long wVM;
  public String wVN;
  public long wVO;
  
  public adg()
  {
    AppMethodBeat.i(56790);
    this.wAS = new LinkedList();
    AppMethodBeat.o(56790);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56791);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wVK != null) {
        paramVarArgs.e(1, this.wVK);
      }
      paramVarArgs.e(2, 8, this.wAS);
      paramVarArgs.am(3, this.wVL);
      paramVarArgs.am(4, this.wVM);
      if (this.wVN != null) {
        paramVarArgs.e(5, this.wVN);
      }
      if (this.qiO != null) {
        paramVarArgs.e(6, this.qiO);
      }
      paramVarArgs.am(7, this.wVO);
      if (this.wIJ != null) {
        paramVarArgs.e(8, this.wIJ);
      }
      AppMethodBeat.o(56791);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wVK == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = e.a.a.b.b.a.f(1, this.wVK) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.wAS) + e.a.a.b.b.a.p(3, this.wVL) + e.a.a.b.b.a.p(4, this.wVM);
      paramInt = i;
      if (this.wVN != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wVN);
      }
      i = paramInt;
      if (this.qiO != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.qiO);
      }
      i += e.a.a.b.b.a.p(7, this.wVO);
      paramInt = i;
      if (this.wIJ != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wIJ);
      }
      AppMethodBeat.o(56791);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wAS.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56791);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        adg localadg = (adg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56791);
          return -1;
        case 1: 
          localadg.wVK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56791);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new adh();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((adh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localadg.wAS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56791);
          return 0;
        case 3: 
          localadg.wVL = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56791);
          return 0;
        case 4: 
          localadg.wVM = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56791);
          return 0;
        case 5: 
          localadg.wVN = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56791);
          return 0;
        case 6: 
          localadg.qiO = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56791);
          return 0;
        case 7: 
          localadg.wVO = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56791);
          return 0;
        }
        localadg.wIJ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56791);
        return 0;
      }
      AppMethodBeat.o(56791);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adg
 * JD-Core Version:    0.7.0.1
 */