package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cad
  extends com.tencent.mm.bv.a
{
  public String sid;
  public LinkedList<cac> xLG;
  public String xLx;
  public LinkedList<cae> xLz;
  public String xkf;
  
  public cad()
  {
    AppMethodBeat.i(152462);
    this.xLG = new LinkedList();
    this.xLz = new LinkedList();
    AppMethodBeat.o(152462);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152463);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.sid != null) {
        paramVarArgs.e(1, this.sid);
      }
      if (this.xLx != null) {
        paramVarArgs.e(2, this.xLx);
      }
      if (this.xkf != null) {
        paramVarArgs.e(3, this.xkf);
      }
      paramVarArgs.e(4, 8, this.xLG);
      paramVarArgs.e(5, 8, this.xLz);
      AppMethodBeat.o(152463);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sid == null) {
        break label618;
      }
    }
    label618:
    for (int i = e.a.a.b.b.a.f(1, this.sid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xLx != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xLx);
      }
      i = paramInt;
      if (this.xkf != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xkf);
      }
      paramInt = e.a.a.a.c(4, 8, this.xLG);
      int j = e.a.a.a.c(5, 8, this.xLz);
      AppMethodBeat.o(152463);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xLG.clear();
        this.xLz.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(152463);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cad localcad = (cad)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152463);
          return -1;
        case 1: 
          localcad.sid = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(152463);
          return 0;
        case 2: 
          localcad.xLx = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(152463);
          return 0;
        case 3: 
          localcad.xkf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(152463);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cac();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cac)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcad.xLG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152463);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cae();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cae)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcad.xLz.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152463);
        return 0;
      }
      AppMethodBeat.o(152463);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cad
 * JD-Core Version:    0.7.0.1
 */