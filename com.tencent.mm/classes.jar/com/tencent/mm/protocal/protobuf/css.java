package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class css
  extends buy
{
  public int wLO;
  public int wQP;
  public long wQQ;
  public String xCG;
  public int xCk;
  public int xQo;
  public cta xZX;
  public cta xZY;
  public int yaX;
  public long yab;
  public int yac;
  public int ybi;
  public LinkedList<bwc> ybj;
  public int ybk;
  
  public css()
  {
    AppMethodBeat.i(5249);
    this.ybj = new LinkedList();
    AppMethodBeat.o(5249);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5250);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xZX == null)
      {
        paramVarArgs = new b("Not all required fields were included: PeerId");
        AppMethodBeat.o(5250);
        throw paramVarArgs;
      }
      if (this.xZY == null)
      {
        paramVarArgs = new b("Not all required fields were included: CapInfo");
        AppMethodBeat.o(5250);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xCG != null) {
        paramVarArgs.e(2, this.xCG);
      }
      paramVarArgs.aO(3, this.ybi);
      paramVarArgs.e(4, 8, this.ybj);
      if (this.xZX != null)
      {
        paramVarArgs.iQ(6, this.xZX.computeSize());
        this.xZX.writeFields(paramVarArgs);
      }
      if (this.xZY != null)
      {
        paramVarArgs.iQ(7, this.xZY.computeSize());
        this.xZY.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(8, this.wLO);
      paramVarArgs.aO(9, this.xQo);
      paramVarArgs.aO(10, this.wQP);
      paramVarArgs.am(11, this.wQQ);
      paramVarArgs.aO(12, this.yaX);
      paramVarArgs.am(13, this.yab);
      paramVarArgs.aO(14, this.ybk);
      paramVarArgs.aO(15, this.xCk);
      paramVarArgs.aO(16, this.yac);
      AppMethodBeat.o(5250);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1419;
      }
    }
    label1419:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xCG != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xCG);
      }
      i = i + e.a.a.b.b.a.bl(3, this.ybi) + e.a.a.a.c(4, 8, this.ybj);
      paramInt = i;
      if (this.xZX != null) {
        paramInt = i + e.a.a.a.iP(6, this.xZX.computeSize());
      }
      i = paramInt;
      if (this.xZY != null) {
        i = paramInt + e.a.a.a.iP(7, this.xZY.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(8, this.wLO);
      int j = e.a.a.b.b.a.bl(9, this.xQo);
      int k = e.a.a.b.b.a.bl(10, this.wQP);
      int m = e.a.a.b.b.a.p(11, this.wQQ);
      int n = e.a.a.b.b.a.bl(12, this.yaX);
      int i1 = e.a.a.b.b.a.p(13, this.yab);
      int i2 = e.a.a.b.b.a.bl(14, this.ybk);
      int i3 = e.a.a.b.b.a.bl(15, this.xCk);
      int i4 = e.a.a.b.b.a.bl(16, this.yac);
      AppMethodBeat.o(5250);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ybj.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xZX == null)
        {
          paramVarArgs = new b("Not all required fields were included: PeerId");
          AppMethodBeat.o(5250);
          throw paramVarArgs;
        }
        if (this.xZY == null)
        {
          paramVarArgs = new b("Not all required fields were included: CapInfo");
          AppMethodBeat.o(5250);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5250);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        css localcss = (css)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(5250);
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
            localcss.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5250);
          return 0;
        case 2: 
          localcss.xCG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5250);
          return 0;
        case 3: 
          localcss.ybi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5250);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcss.ybj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5250);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cta();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cta)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcss.xZX = ((cta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5250);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cta();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cta)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcss.xZY = ((cta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5250);
          return 0;
        case 8: 
          localcss.wLO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5250);
          return 0;
        case 9: 
          localcss.xQo = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5250);
          return 0;
        case 10: 
          localcss.wQP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5250);
          return 0;
        case 11: 
          localcss.wQQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(5250);
          return 0;
        case 12: 
          localcss.yaX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5250);
          return 0;
        case 13: 
          localcss.yab = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(5250);
          return 0;
        case 14: 
          localcss.ybk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5250);
          return 0;
        case 15: 
          localcss.xCk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5250);
          return 0;
        }
        localcss.yac = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5250);
        return 0;
      }
      AppMethodBeat.o(5250);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.css
 * JD-Core Version:    0.7.0.1
 */