package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oq
  extends com.tencent.mm.bv.a
{
  public String wFg;
  public String wFh;
  public String wFi;
  public int wFj;
  public String wFk;
  public ou wFl;
  public String wFm;
  public int wFn;
  public int wFo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152202);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wFg != null) {
        paramVarArgs.e(1, this.wFg);
      }
      if (this.wFh != null) {
        paramVarArgs.e(2, this.wFh);
      }
      if (this.wFi != null) {
        paramVarArgs.e(3, this.wFi);
      }
      paramVarArgs.aO(4, this.wFj);
      if (this.wFk != null) {
        paramVarArgs.e(5, this.wFk);
      }
      if (this.wFl != null)
      {
        paramVarArgs.iQ(6, this.wFl.computeSize());
        this.wFl.writeFields(paramVarArgs);
      }
      if (this.wFm != null) {
        paramVarArgs.e(7, this.wFm);
      }
      paramVarArgs.aO(8, this.wFn);
      paramVarArgs.aO(9, this.wFo);
      AppMethodBeat.o(152202);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wFg == null) {
        break label754;
      }
    }
    label754:
    for (int i = e.a.a.b.b.a.f(1, this.wFg) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wFh != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wFh);
      }
      i = paramInt;
      if (this.wFi != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wFi);
      }
      i += e.a.a.b.b.a.bl(4, this.wFj);
      paramInt = i;
      if (this.wFk != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wFk);
      }
      i = paramInt;
      if (this.wFl != null) {
        i = paramInt + e.a.a.a.iP(6, this.wFl.computeSize());
      }
      paramInt = i;
      if (this.wFm != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wFm);
      }
      i = e.a.a.b.b.a.bl(8, this.wFn);
      int j = e.a.a.b.b.a.bl(9, this.wFo);
      AppMethodBeat.o(152202);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(152202);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        oq localoq = (oq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152202);
          return -1;
        case 1: 
          localoq.wFg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(152202);
          return 0;
        case 2: 
          localoq.wFh = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(152202);
          return 0;
        case 3: 
          localoq.wFi = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(152202);
          return 0;
        case 4: 
          localoq.wFj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(152202);
          return 0;
        case 5: 
          localoq.wFk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(152202);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ou();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ou)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localoq.wFl = ((ou)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152202);
          return 0;
        case 7: 
          localoq.wFm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(152202);
          return 0;
        case 8: 
          localoq.wFn = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(152202);
          return 0;
        }
        localoq.wFo = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(152202);
        return 0;
      }
      AppMethodBeat.o(152202);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oq
 * JD-Core Version:    0.7.0.1
 */