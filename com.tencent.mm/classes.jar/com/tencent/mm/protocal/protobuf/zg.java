package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zg
  extends com.tencent.mm.bx.a
{
  public bsp Dbp;
  public LinkedList<abt> Dbq;
  public LinkedList<dkr> Dbr;
  public String Dbs;
  
  public zg()
  {
    AppMethodBeat.i(91431);
    this.Dbq = new LinkedList();
    this.Dbr = new LinkedList();
    AppMethodBeat.o(91431);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91432);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dbp != null)
      {
        paramVarArgs.kX(1, this.Dbp.computeSize());
        this.Dbp.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Dbq);
      paramVarArgs.e(3, 8, this.Dbr);
      if (this.Dbs != null) {
        paramVarArgs.d(4, this.Dbs);
      }
      AppMethodBeat.o(91432);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Dbp == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = f.a.a.a.kW(1, this.Dbp.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.Dbq) + f.a.a.a.c(3, 8, this.Dbr);
      paramInt = i;
      if (this.Dbs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dbs);
      }
      AppMethodBeat.o(91432);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dbq.clear();
        this.Dbr.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91432);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        zg localzg = (zg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91432);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzg.Dbp = ((bsp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91432);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new abt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((abt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzg.Dbq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91432);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dkr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzg.Dbr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91432);
          return 0;
        }
        localzg.Dbs = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91432);
        return 0;
      }
      AppMethodBeat.o(91432);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zg
 * JD-Core Version:    0.7.0.1
 */