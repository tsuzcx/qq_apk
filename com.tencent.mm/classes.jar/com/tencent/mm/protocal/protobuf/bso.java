package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bso
  extends com.tencent.mm.bv.a
{
  public long bqN;
  public String cwc;
  public String nickname;
  public String pvi;
  public String username;
  public String xFZ;
  public double xGa;
  public LinkedList<pl> xGb;
  public String xGc;
  public LinkedList<bvu> xGd;
  
  public bso()
  {
    AppMethodBeat.i(134441);
    this.xGb = new LinkedList();
    this.xGd = new LinkedList();
    AppMethodBeat.o(134441);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134442);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cwc != null) {
        paramVarArgs.e(1, this.cwc);
      }
      if (this.username != null) {
        paramVarArgs.e(2, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.e(3, this.nickname);
      }
      if (this.pvi != null) {
        paramVarArgs.e(4, this.pvi);
      }
      paramVarArgs.am(5, this.bqN);
      if (this.xFZ != null) {
        paramVarArgs.e(6, this.xFZ);
      }
      paramVarArgs.f(7, this.xGa);
      paramVarArgs.e(16, 8, this.xGb);
      if (this.xGc != null) {
        paramVarArgs.e(17, this.xGc);
      }
      paramVarArgs.e(19, 8, this.xGd);
      AppMethodBeat.o(134442);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cwc == null) {
        break label929;
      }
    }
    label929:
    for (int i = e.a.a.b.b.a.f(1, this.cwc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.username);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nickname);
      }
      paramInt = i;
      if (this.pvi != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.pvi);
      }
      i = paramInt + e.a.a.b.b.a.p(5, this.bqN);
      paramInt = i;
      if (this.xFZ != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xFZ);
      }
      i = paramInt + (e.a.a.b.b.a.eW(7) + 8) + e.a.a.a.c(16, 8, this.xGb);
      paramInt = i;
      if (this.xGc != null) {
        paramInt = i + e.a.a.b.b.a.f(17, this.xGc);
      }
      i = e.a.a.a.c(19, 8, this.xGd);
      AppMethodBeat.o(134442);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xGb.clear();
        this.xGd.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(134442);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bso localbso = (bso)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 18: 
        default: 
          AppMethodBeat.o(134442);
          return -1;
        case 1: 
          localbso.cwc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(134442);
          return 0;
        case 2: 
          localbso.username = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(134442);
          return 0;
        case 3: 
          localbso.nickname = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(134442);
          return 0;
        case 4: 
          localbso.pvi = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(134442);
          return 0;
        case 5: 
          localbso.bqN = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(134442);
          return 0;
        case 6: 
          localbso.xFZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(134442);
          return 0;
        case 7: 
          localbso.xGa = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(134442);
          return 0;
        case 16: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pl();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pl)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbso.xGb.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134442);
          return 0;
        case 17: 
          localbso.xGc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(134442);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvu();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbso.xGd.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(134442);
        return 0;
      }
      AppMethodBeat.o(134442);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bso
 * JD-Core Version:    0.7.0.1
 */