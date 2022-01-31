package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bju
  extends com.tencent.mm.bv.a
{
  public String pqD;
  public int timestamp;
  public String type;
  public LinkedList<bju> uxU;
  public String xyg;
  public LinkedList<bjt> xyh;
  public int xyi;
  public int xyj;
  
  public bju()
  {
    AppMethodBeat.i(90697);
    this.xyh = new LinkedList();
    this.uxU = new LinkedList();
    AppMethodBeat.o(90697);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90698);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xyg != null) {
        paramVarArgs.e(1, this.xyg);
      }
      if (this.pqD != null) {
        paramVarArgs.e(2, this.pqD);
      }
      paramVarArgs.e(3, 8, this.xyh);
      paramVarArgs.aO(4, this.timestamp);
      if (this.type != null) {
        paramVarArgs.e(5, this.type);
      }
      paramVarArgs.e(6, 8, this.uxU);
      paramVarArgs.aO(7, this.xyi);
      paramVarArgs.aO(8, this.xyj);
      AppMethodBeat.o(90698);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xyg == null) {
        break label758;
      }
    }
    label758:
    for (paramInt = e.a.a.b.b.a.f(1, this.xyg) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pqD != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.pqD);
      }
      i = i + e.a.a.a.c(3, 8, this.xyh) + e.a.a.b.b.a.bl(4, this.timestamp);
      paramInt = i;
      if (this.type != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.type);
      }
      i = e.a.a.a.c(6, 8, this.uxU);
      int j = e.a.a.b.b.a.bl(7, this.xyi);
      int k = e.a.a.b.b.a.bl(8, this.xyj);
      AppMethodBeat.o(90698);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xyh.clear();
        this.uxU.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(90698);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bju localbju = (bju)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(90698);
          return -1;
        case 1: 
          localbju.xyg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(90698);
          return 0;
        case 2: 
          localbju.pqD = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(90698);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjt();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjt)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbju.xyh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(90698);
          return 0;
        case 4: 
          localbju.timestamp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(90698);
          return 0;
        case 5: 
          localbju.type = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(90698);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bju();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bju)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbju.uxU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(90698);
          return 0;
        case 7: 
          localbju.xyi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(90698);
          return 0;
        }
        localbju.xyj = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(90698);
        return 0;
      }
      AppMethodBeat.o(90698);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bju
 * JD-Core Version:    0.7.0.1
 */