package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbn
  extends com.tencent.mm.bx.a
{
  public chk Hrh;
  public chg Hri;
  public chk Hrj;
  public chg Hrk;
  public boolean Hrl = false;
  public boolean Hrm = false;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210618);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hrh != null)
      {
        paramVarArgs.lC(1, this.Hrh.computeSize());
        this.Hrh.writeFields(paramVarArgs);
      }
      if (this.Hri != null)
      {
        paramVarArgs.lC(2, this.Hri.computeSize());
        this.Hri.writeFields(paramVarArgs);
      }
      if (this.Hrj != null)
      {
        paramVarArgs.lC(3, this.Hrj.computeSize());
        this.Hrj.writeFields(paramVarArgs);
      }
      if (this.Hrk != null)
      {
        paramVarArgs.lC(4, this.Hrk.computeSize());
        this.Hrk.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(5, this.Hrl);
      paramVarArgs.bt(6, this.Hrm);
      AppMethodBeat.o(210618);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hrh == null) {
        break label858;
      }
    }
    label858:
    for (int i = f.a.a.a.lB(1, this.Hrh.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hri != null) {
        paramInt = i + f.a.a.a.lB(2, this.Hri.computeSize());
      }
      i = paramInt;
      if (this.Hrj != null) {
        i = paramInt + f.a.a.a.lB(3, this.Hrj.computeSize());
      }
      paramInt = i;
      if (this.Hrk != null) {
        paramInt = i + f.a.a.a.lB(4, this.Hrk.computeSize());
      }
      i = f.a.a.b.b.a.alV(5);
      int j = f.a.a.b.b.a.alV(6);
      AppMethodBeat.o(210618);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(210618);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dbn localdbn = (dbn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(210618);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbn.Hrh = ((chk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(210618);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbn.Hri = ((chg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(210618);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbn.Hrj = ((chk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(210618);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbn.Hrk = ((chg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(210618);
          return 0;
        case 5: 
          localdbn.Hrl = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(210618);
          return 0;
        }
        localdbn.Hrm = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(210618);
        return 0;
      }
      AppMethodBeat.o(210618);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbn
 * JD-Core Version:    0.7.0.1
 */