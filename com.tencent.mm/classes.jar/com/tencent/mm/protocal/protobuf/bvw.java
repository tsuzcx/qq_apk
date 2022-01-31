package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvw
  extends com.tencent.mm.bv.a
{
  public cjw wNE;
  public bvz wna;
  public String wug;
  public int xJs;
  public int xJt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48959);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xJs);
      paramVarArgs.aO(2, this.xJt);
      if (this.wna != null)
      {
        paramVarArgs.iQ(3, this.wna.computeSize());
        this.wna.writeFields(paramVarArgs);
      }
      if (this.wNE != null)
      {
        paramVarArgs.iQ(4, this.wNE.computeSize());
        this.wNE.writeFields(paramVarArgs);
      }
      if (this.wug != null) {
        paramVarArgs.e(5, this.wug);
      }
      AppMethodBeat.o(48959);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.xJs) + 0 + e.a.a.b.b.a.bl(2, this.xJt);
      paramInt = i;
      if (this.wna != null) {
        paramInt = i + e.a.a.a.iP(3, this.wna.computeSize());
      }
      i = paramInt;
      if (this.wNE != null) {
        i = paramInt + e.a.a.a.iP(4, this.wNE.computeSize());
      }
      paramInt = i;
      if (this.wug != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wug);
      }
      AppMethodBeat.o(48959);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(48959);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bvw localbvw = (bvw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(48959);
        return -1;
      case 1: 
        localbvw.xJs = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(48959);
        return 0;
      case 2: 
        localbvw.xJt = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(48959);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvz();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbvw.wna = ((bvz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48959);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cjw();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cjw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbvw.wNE = ((cjw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48959);
        return 0;
      }
      localbvw.wug = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(48959);
      return 0;
    }
    AppMethodBeat.o(48959);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvw
 * JD-Core Version:    0.7.0.1
 */