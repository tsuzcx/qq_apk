package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fm
  extends com.tencent.mm.bv.a
{
  public String crs;
  public String gfK;
  public bia wrB;
  public LinkedList<bia> wrC;
  
  public fm()
  {
    AppMethodBeat.i(80020);
    this.wrC = new LinkedList();
    AppMethodBeat.o(80020);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80021);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.gfK != null) {
        paramVarArgs.e(1, this.gfK);
      }
      if (this.wrB != null)
      {
        paramVarArgs.iQ(2, this.wrB.computeSize());
        this.wrB.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.wrC);
      if (this.crs != null) {
        paramVarArgs.e(4, this.crs);
      }
      AppMethodBeat.o(80021);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gfK == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = e.a.a.b.b.a.f(1, this.gfK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wrB != null) {
        i = paramInt + e.a.a.a.iP(2, this.wrB.computeSize());
      }
      i += e.a.a.a.c(3, 8, this.wrC);
      paramInt = i;
      if (this.crs != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.crs);
      }
      AppMethodBeat.o(80021);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wrC.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80021);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        fm localfm = (fm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80021);
          return -1;
        case 1: 
          localfm.gfK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80021);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bia();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bia)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localfm.wrB = ((bia)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80021);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bia();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bia)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localfm.wrC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80021);
          return 0;
        }
        localfm.crs = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(80021);
        return 0;
      }
      AppMethodBeat.o(80021);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fm
 * JD-Core Version:    0.7.0.1
 */