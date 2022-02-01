package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqi
  extends com.tencent.mm.bx.a
{
  public LinkedList<cqk> Ejs;
  public LinkedList<cqh> Ejt;
  public cqj Eju;
  public LinkedList<cqm> Ejv;
  public boolean fuh;
  public boolean qhl;
  
  public cqi()
  {
    AppMethodBeat.i(122527);
    this.fuh = true;
    this.qhl = false;
    this.Ejs = new LinkedList();
    this.Ejt = new LinkedList();
    this.Ejv = new LinkedList();
    AppMethodBeat.o(122527);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122528);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bg(1, this.fuh);
      paramVarArgs.bg(2, this.qhl);
      paramVarArgs.e(3, 8, this.Ejs);
      paramVarArgs.e(4, 8, this.Ejt);
      if (this.Eju != null)
      {
        paramVarArgs.kX(5, this.Eju.computeSize());
        this.Eju.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.Ejv);
      AppMethodBeat.o(122528);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.fY(1) + 1 + 0 + (f.a.a.b.b.a.fY(2) + 1) + f.a.a.a.c(3, 8, this.Ejs) + f.a.a.a.c(4, 8, this.Ejt);
      paramInt = i;
      if (this.Eju != null) {
        paramInt = i + f.a.a.a.kW(5, this.Eju.computeSize());
      }
      i = f.a.a.a.c(6, 8, this.Ejv);
      AppMethodBeat.o(122528);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Ejs.clear();
      this.Ejt.clear();
      this.Ejv.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(122528);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cqi localcqi = (cqi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122528);
        return -1;
      case 1: 
        localcqi.fuh = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(122528);
        return 0;
      case 2: 
        localcqi.qhl = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(122528);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cqk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cqk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcqi.Ejs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122528);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cqh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cqh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcqi.Ejt.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122528);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cqj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cqj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcqi.Eju = ((cqj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122528);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cqm();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cqm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcqi.Ejv.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(122528);
      return 0;
    }
    AppMethodBeat.o(122528);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqi
 * JD-Core Version:    0.7.0.1
 */