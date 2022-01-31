package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cpe
  extends com.tencent.mm.bv.a
{
  public int apptype;
  public String cwc;
  public String fhP;
  public String kqb;
  public LinkedList<cpf> xXW;
  public String xXX;
  public int xXY;
  public int xuc;
  
  public cpe()
  {
    AppMethodBeat.i(127735);
    this.xXW = new LinkedList();
    AppMethodBeat.o(127735);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127736);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cwc != null) {
        paramVarArgs.e(1, this.cwc);
      }
      if (this.fhP != null) {
        paramVarArgs.e(2, this.fhP);
      }
      paramVarArgs.aO(3, this.apptype);
      paramVarArgs.e(4, 8, this.xXW);
      paramVarArgs.aO(5, this.xuc);
      if (this.xXX != null) {
        paramVarArgs.e(6, this.xXX);
      }
      if (this.kqb != null) {
        paramVarArgs.e(7, this.kqb);
      }
      paramVarArgs.aO(8, this.xXY);
      AppMethodBeat.o(127736);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cwc == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = e.a.a.b.b.a.f(1, this.cwc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fhP != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.fhP);
      }
      i = i + e.a.a.b.b.a.bl(3, this.apptype) + e.a.a.a.c(4, 8, this.xXW) + e.a.a.b.b.a.bl(5, this.xuc);
      paramInt = i;
      if (this.xXX != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xXX);
      }
      i = paramInt;
      if (this.kqb != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.kqb);
      }
      paramInt = e.a.a.b.b.a.bl(8, this.xXY);
      AppMethodBeat.o(127736);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xXW.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(127736);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cpe localcpe = (cpe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127736);
          return -1;
        case 1: 
          localcpe.cwc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(127736);
          return 0;
        case 2: 
          localcpe.fhP = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(127736);
          return 0;
        case 3: 
          localcpe.apptype = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(127736);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cpf();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cpf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcpe.xXW.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127736);
          return 0;
        case 5: 
          localcpe.xuc = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(127736);
          return 0;
        case 6: 
          localcpe.xXX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(127736);
          return 0;
        case 7: 
          localcpe.kqb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(127736);
          return 0;
        }
        localcpe.xXY = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(127736);
        return 0;
      }
      AppMethodBeat.o(127736);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpe
 * JD-Core Version:    0.7.0.1
 */