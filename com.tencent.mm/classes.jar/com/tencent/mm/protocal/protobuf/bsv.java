package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bsv
  extends com.tencent.mm.bx.a
{
  public bgp CGg;
  public oj CGh;
  public bsu CGi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133180);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CGg != null)
      {
        paramVarArgs.kX(1, this.CGg.computeSize());
        this.CGg.writeFields(paramVarArgs);
      }
      if (this.CGi != null)
      {
        paramVarArgs.kX(2, this.CGi.computeSize());
        this.CGi.writeFields(paramVarArgs);
      }
      if (this.CGh != null)
      {
        paramVarArgs.kX(3, this.CGh.computeSize());
        this.CGh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133180);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CGg == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.kW(1, this.CGg.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CGi != null) {
        paramInt = i + f.a.a.a.kW(2, this.CGi.computeSize());
      }
      i = paramInt;
      if (this.CGh != null) {
        i = paramInt + f.a.a.a.kW(3, this.CGh.computeSize());
      }
      AppMethodBeat.o(133180);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(133180);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bsv localbsv = (bsv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133180);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bgp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bgp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbsv.CGg = ((bgp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133180);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbsv.CGi = ((bsu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133180);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new oj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((oj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbsv.CGh = ((oj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133180);
        return 0;
      }
      AppMethodBeat.o(133180);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsv
 * JD-Core Version:    0.7.0.1
 */