package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chm
  extends com.tencent.mm.bv.a
{
  public String cqq;
  public int ePG;
  public int nkT;
  public String pIw;
  public int xSq;
  public chk xSr;
  public String xSs;
  public boolean xSt;
  public long xst;
  public int xsx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56528);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.pIw != null) {
        paramVarArgs.e(1, this.pIw);
      }
      paramVarArgs.aO(2, this.ePG);
      paramVarArgs.am(3, this.xst);
      paramVarArgs.aO(4, this.xsx);
      if (this.cqq != null) {
        paramVarArgs.e(5, this.cqq);
      }
      paramVarArgs.aO(6, this.nkT);
      paramVarArgs.aO(7, this.xSq);
      if (this.xSr != null)
      {
        paramVarArgs.iQ(8, this.xSr.computeSize());
        this.xSr.writeFields(paramVarArgs);
      }
      if (this.xSs != null) {
        paramVarArgs.e(9, this.xSs);
      }
      paramVarArgs.aS(10, this.xSt);
      AppMethodBeat.o(56528);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pIw == null) {
        break label758;
      }
    }
    label758:
    for (paramInt = e.a.a.b.b.a.f(1, this.pIw) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.ePG) + e.a.a.b.b.a.p(3, this.xst) + e.a.a.b.b.a.bl(4, this.xsx);
      paramInt = i;
      if (this.cqq != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.cqq);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.nkT) + e.a.a.b.b.a.bl(7, this.xSq);
      paramInt = i;
      if (this.xSr != null) {
        paramInt = i + e.a.a.a.iP(8, this.xSr.computeSize());
      }
      i = paramInt;
      if (this.xSs != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.xSs);
      }
      paramInt = e.a.a.b.b.a.eW(10);
      AppMethodBeat.o(56528);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56528);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        chm localchm = (chm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56528);
          return -1;
        case 1: 
          localchm.pIw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56528);
          return 0;
        case 2: 
          localchm.ePG = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56528);
          return 0;
        case 3: 
          localchm.xst = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56528);
          return 0;
        case 4: 
          localchm.xsx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56528);
          return 0;
        case 5: 
          localchm.cqq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56528);
          return 0;
        case 6: 
          localchm.nkT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56528);
          return 0;
        case 7: 
          localchm.xSq = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56528);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chk();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((chk)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localchm.xSr = ((chk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56528);
          return 0;
        case 9: 
          localchm.xSs = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56528);
          return 0;
        }
        localchm.xSt = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(56528);
        return 0;
      }
      AppMethodBeat.o(56528);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chm
 * JD-Core Version:    0.7.0.1
 */