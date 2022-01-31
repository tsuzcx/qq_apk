package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbh
  extends com.tencent.mm.bv.a
{
  public LinkedList<Integer> xYZ;
  public dbg yhA;
  public LinkedList<Integer> yhB;
  public int yhC;
  public int yhD;
  
  public dbh()
  {
    AppMethodBeat.i(115016);
    this.yhB = new LinkedList();
    this.xYZ = new LinkedList();
    AppMethodBeat.o(115016);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115017);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.yhA != null)
      {
        paramVarArgs.iQ(1, this.yhA.computeSize());
        this.yhA.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 2, this.yhB);
      paramVarArgs.e(3, 2, this.xYZ);
      paramVarArgs.aO(4, this.yhC);
      paramVarArgs.aO(5, this.yhD);
      AppMethodBeat.o(115017);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yhA == null) {
        break label528;
      }
    }
    label528:
    for (paramInt = e.a.a.a.iP(1, this.yhA.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.a.c(2, 2, this.yhB);
      int j = e.a.a.a.c(3, 2, this.xYZ);
      int k = e.a.a.b.b.a.bl(4, this.yhC);
      int m = e.a.a.b.b.a.bl(5, this.yhD);
      AppMethodBeat.o(115017);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.yhB.clear();
        this.xYZ.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(115017);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        dbh localdbh = (dbh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115017);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dbg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localdbh.yhA = ((dbg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115017);
          return 0;
        case 2: 
          localdbh.yhB.add(Integer.valueOf(((e.a.a.a.a)localObject1).CLY.sl()));
          AppMethodBeat.o(115017);
          return 0;
        case 3: 
          localdbh.xYZ.add(Integer.valueOf(((e.a.a.a.a)localObject1).CLY.sl()));
          AppMethodBeat.o(115017);
          return 0;
        case 4: 
          localdbh.yhC = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(115017);
          return 0;
        }
        localdbh.yhD = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(115017);
        return 0;
      }
      AppMethodBeat.o(115017);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbh
 * JD-Core Version:    0.7.0.1
 */