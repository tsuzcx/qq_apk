package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ol
  extends com.tencent.mm.bv.a
{
  public int wEA;
  public String wEB;
  public int wEC;
  public String wEq;
  public String wEr;
  public String wEs;
  public String wEt;
  public String wEu;
  public LinkedList<ok> wEv;
  public int wEw;
  public String wEx;
  public String wEy;
  public String wEz;
  public String wmm;
  
  public ol()
  {
    AppMethodBeat.i(89022);
    this.wEv = new LinkedList();
    AppMethodBeat.o(89022);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89023);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wmm != null) {
        paramVarArgs.e(1, this.wmm);
      }
      if (this.wEq != null) {
        paramVarArgs.e(2, this.wEq);
      }
      if (this.wEr != null) {
        paramVarArgs.e(3, this.wEr);
      }
      if (this.wEs != null) {
        paramVarArgs.e(4, this.wEs);
      }
      if (this.wEt != null) {
        paramVarArgs.e(5, this.wEt);
      }
      if (this.wEu != null) {
        paramVarArgs.e(6, this.wEu);
      }
      paramVarArgs.e(7, 8, this.wEv);
      paramVarArgs.aO(8, this.wEw);
      if (this.wEx != null) {
        paramVarArgs.e(9, this.wEx);
      }
      if (this.wEy != null) {
        paramVarArgs.e(10, this.wEy);
      }
      if (this.wEz != null) {
        paramVarArgs.e(11, this.wEz);
      }
      paramVarArgs.aO(12, this.wEA);
      if (this.wEB != null) {
        paramVarArgs.e(13, this.wEB);
      }
      paramVarArgs.aO(14, this.wEC);
      AppMethodBeat.o(89023);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wmm == null) {
        break label1046;
      }
    }
    label1046:
    for (int i = e.a.a.b.b.a.f(1, this.wmm) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wEq != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wEq);
      }
      i = paramInt;
      if (this.wEr != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wEr);
      }
      paramInt = i;
      if (this.wEs != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wEs);
      }
      i = paramInt;
      if (this.wEt != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wEt);
      }
      paramInt = i;
      if (this.wEu != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wEu);
      }
      i = paramInt + e.a.a.a.c(7, 8, this.wEv) + e.a.a.b.b.a.bl(8, this.wEw);
      paramInt = i;
      if (this.wEx != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.wEx);
      }
      i = paramInt;
      if (this.wEy != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.wEy);
      }
      paramInt = i;
      if (this.wEz != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.wEz);
      }
      i = paramInt + e.a.a.b.b.a.bl(12, this.wEA);
      paramInt = i;
      if (this.wEB != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.wEB);
      }
      i = e.a.a.b.b.a.bl(14, this.wEC);
      AppMethodBeat.o(89023);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wEv.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89023);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ol localol = (ol)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89023);
          return -1;
        case 1: 
          localol.wmm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89023);
          return 0;
        case 2: 
          localol.wEq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89023);
          return 0;
        case 3: 
          localol.wEr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89023);
          return 0;
        case 4: 
          localol.wEs = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89023);
          return 0;
        case 5: 
          localol.wEt = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89023);
          return 0;
        case 6: 
          localol.wEu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89023);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ok();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ok)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localol.wEv.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89023);
          return 0;
        case 8: 
          localol.wEw = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89023);
          return 0;
        case 9: 
          localol.wEx = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89023);
          return 0;
        case 10: 
          localol.wEy = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89023);
          return 0;
        case 11: 
          localol.wEz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89023);
          return 0;
        case 12: 
          localol.wEA = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89023);
          return 0;
        case 13: 
          localol.wEB = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89023);
          return 0;
        }
        localol.wEC = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(89023);
        return 0;
      }
      AppMethodBeat.o(89023);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ol
 * JD-Core Version:    0.7.0.1
 */