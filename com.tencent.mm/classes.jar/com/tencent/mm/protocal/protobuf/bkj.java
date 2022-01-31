package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkj
  extends com.tencent.mm.bv.a
{
  public String wmm;
  public String xyQ;
  public String xyR;
  public String xyS;
  public int xyT;
  public LinkedList<ok> xyU;
  public String xyV;
  public String xyW;
  
  public bkj()
  {
    AppMethodBeat.i(89114);
    this.xyU = new LinkedList();
    AppMethodBeat.o(89114);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89115);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wmm != null) {
        paramVarArgs.e(1, this.wmm);
      }
      if (this.xyQ != null) {
        paramVarArgs.e(2, this.xyQ);
      }
      if (this.xyR != null) {
        paramVarArgs.e(3, this.xyR);
      }
      if (this.xyS != null) {
        paramVarArgs.e(4, this.xyS);
      }
      paramVarArgs.aO(5, this.xyT);
      paramVarArgs.e(6, 8, this.xyU);
      if (this.xyV != null) {
        paramVarArgs.e(7, this.xyV);
      }
      if (this.xyW != null) {
        paramVarArgs.e(8, this.xyW);
      }
      AppMethodBeat.o(89115);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wmm == null) {
        break label706;
      }
    }
    label706:
    for (int i = e.a.a.b.b.a.f(1, this.wmm) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xyQ != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xyQ);
      }
      i = paramInt;
      if (this.xyR != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xyR);
      }
      paramInt = i;
      if (this.xyS != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xyS);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.xyT) + e.a.a.a.c(6, 8, this.xyU);
      paramInt = i;
      if (this.xyV != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xyV);
      }
      i = paramInt;
      if (this.xyW != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.xyW);
      }
      AppMethodBeat.o(89115);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xyU.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89115);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bkj localbkj = (bkj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89115);
          return -1;
        case 1: 
          localbkj.wmm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89115);
          return 0;
        case 2: 
          localbkj.xyQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89115);
          return 0;
        case 3: 
          localbkj.xyR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89115);
          return 0;
        case 4: 
          localbkj.xyS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89115);
          return 0;
        case 5: 
          localbkj.xyT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89115);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ok();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ok)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbkj.xyU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89115);
          return 0;
        case 7: 
          localbkj.xyV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89115);
          return 0;
        }
        localbkj.xyW = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(89115);
        return 0;
      }
      AppMethodBeat.o(89115);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkj
 * JD-Core Version:    0.7.0.1
 */