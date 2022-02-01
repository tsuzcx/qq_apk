package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbv
  extends com.tencent.mm.bw.a
{
  public LinkedList<dbx> HKu;
  public LinkedList<dbu> HKv;
  public dbw HKw;
  public LinkedList<dbz> HKx;
  public boolean fTh;
  public boolean rHX;
  
  public dbv()
  {
    AppMethodBeat.i(122527);
    this.fTh = true;
    this.rHX = false;
    this.HKu = new LinkedList();
    this.HKv = new LinkedList();
    this.HKx = new LinkedList();
    AppMethodBeat.o(122527);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122528);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bC(1, this.fTh);
      paramVarArgs.bC(2, this.rHX);
      paramVarArgs.e(3, 8, this.HKu);
      paramVarArgs.e(4, 8, this.HKv);
      if (this.HKw != null)
      {
        paramVarArgs.lJ(5, this.HKw.computeSize());
        this.HKw.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.HKx);
      AppMethodBeat.o(122528);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.amF(1) + 0 + f.a.a.b.b.a.amF(2) + f.a.a.a.c(3, 8, this.HKu) + f.a.a.a.c(4, 8, this.HKv);
      paramInt = i;
      if (this.HKw != null) {
        paramInt = i + f.a.a.a.lI(5, this.HKw.computeSize());
      }
      i = f.a.a.a.c(6, 8, this.HKx);
      AppMethodBeat.o(122528);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HKu.clear();
      this.HKv.clear();
      this.HKx.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(122528);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dbv localdbv = (dbv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122528);
        return -1;
      case 1: 
        localdbv.fTh = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(122528);
        return 0;
      case 2: 
        localdbv.rHX = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(122528);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dbx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dbx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdbv.HKu.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122528);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dbu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dbu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdbv.HKv.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122528);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dbw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dbw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdbv.HKw = ((dbw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122528);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dbz();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dbz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdbv.HKx.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(122528);
      return 0;
    }
    AppMethodBeat.o(122528);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbv
 * JD-Core Version:    0.7.0.1
 */