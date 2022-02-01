package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbg
  extends com.tencent.mm.bw.a
{
  public long FKv;
  public int ncL;
  public LinkedList<crm> ncM;
  public String tkJ;
  
  public dbg()
  {
    AppMethodBeat.i(125816);
    this.ncM = new LinkedList();
    AppMethodBeat.o(125816);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125817);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.FKv);
      if (this.tkJ != null) {
        paramVarArgs.d(2, this.tkJ);
      }
      paramVarArgs.aR(3, this.ncL);
      paramVarArgs.e(4, 8, this.ncM);
      AppMethodBeat.o(125817);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.FKv) + 0;
      paramInt = i;
      if (this.tkJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tkJ);
      }
      i = f.a.a.b.b.a.bx(3, this.ncL);
      int j = f.a.a.a.c(4, 8, this.ncM);
      AppMethodBeat.o(125817);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ncM.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(125817);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dbg localdbg = (dbg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125817);
        return -1;
      case 1: 
        localdbg.FKv = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(125817);
        return 0;
      case 2: 
        localdbg.tkJ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125817);
        return 0;
      case 3: 
        localdbg.ncL = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125817);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new crm();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdbg.ncM.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(125817);
      return 0;
    }
    AppMethodBeat.o(125817);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbg
 * JD-Core Version:    0.7.0.1
 */