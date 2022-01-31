package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bof
  extends buy
{
  public String nul;
  public String num;
  public int wLO;
  public long xCj;
  public int xCk;
  public String xCl;
  public int xCs;
  public int xCt;
  public int xCu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28581);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.num != null) {
        paramVarArgs.e(2, this.num);
      }
      if (this.xCl != null) {
        paramVarArgs.e(3, this.xCl);
      }
      paramVarArgs.aO(4, this.wLO);
      paramVarArgs.am(5, this.xCj);
      paramVarArgs.aO(6, this.xCk);
      if (this.nul != null) {
        paramVarArgs.e(7, this.nul);
      }
      paramVarArgs.aO(8, this.xCt);
      paramVarArgs.aO(9, this.xCs);
      paramVarArgs.aO(10, this.xCu);
      AppMethodBeat.o(28581);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label782;
      }
    }
    label782:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.num != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.num);
      }
      i = paramInt;
      if (this.xCl != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xCl);
      }
      i = i + e.a.a.b.b.a.bl(4, this.wLO) + e.a.a.b.b.a.p(5, this.xCj) + e.a.a.b.b.a.bl(6, this.xCk);
      paramInt = i;
      if (this.nul != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.nul);
      }
      i = e.a.a.b.b.a.bl(8, this.xCt);
      int j = e.a.a.b.b.a.bl(9, this.xCs);
      int k = e.a.a.b.b.a.bl(10, this.xCu);
      AppMethodBeat.o(28581);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28581);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bof localbof = (bof)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28581);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbof.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28581);
          return 0;
        case 2: 
          localbof.num = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28581);
          return 0;
        case 3: 
          localbof.xCl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28581);
          return 0;
        case 4: 
          localbof.wLO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28581);
          return 0;
        case 5: 
          localbof.xCj = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(28581);
          return 0;
        case 6: 
          localbof.xCk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28581);
          return 0;
        case 7: 
          localbof.nul = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28581);
          return 0;
        case 8: 
          localbof.xCt = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28581);
          return 0;
        case 9: 
          localbof.xCs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28581);
          return 0;
        }
        localbof.xCu = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28581);
        return 0;
      }
      AppMethodBeat.o(28581);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bof
 * JD-Core Version:    0.7.0.1
 */