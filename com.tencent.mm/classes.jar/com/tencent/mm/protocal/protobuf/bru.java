package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bru
  extends com.tencent.mm.bx.a
{
  public aaw GMK;
  public LinkedList<bsg> GML;
  public int dDp;
  public String duO;
  
  public bru()
  {
    AppMethodBeat.i(210602);
    this.dDp = 0;
    this.GML = new LinkedList();
    AppMethodBeat.o(210602);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210603);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GMK == null)
      {
        paramVarArgs = new b("Not all required fields were included: idInfo");
        AppMethodBeat.o(210603);
        throw paramVarArgs;
      }
      if (this.GMK != null)
      {
        paramVarArgs.lC(1, this.GMK.computeSize());
        this.GMK.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dDp);
      if (this.duO != null) {
        paramVarArgs.d(3, this.duO);
      }
      paramVarArgs.e(4, 8, this.GML);
      AppMethodBeat.o(210603);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GMK == null) {
        break label602;
      }
    }
    label602:
    for (paramInt = f.a.a.a.lB(1, this.GMK.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dDp);
      paramInt = i;
      if (this.duO != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.duO);
      }
      i = f.a.a.a.c(4, 8, this.GML);
      AppMethodBeat.o(210603);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GML.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GMK == null)
        {
          paramVarArgs = new b("Not all required fields were included: idInfo");
          AppMethodBeat.o(210603);
          throw paramVarArgs;
        }
        AppMethodBeat.o(210603);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bru localbru = (bru)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(210603);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aaw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aaw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbru.GMK = ((aaw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(210603);
          return 0;
        case 2: 
          localbru.dDp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(210603);
          return 0;
        case 3: 
          localbru.duO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(210603);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bsg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bsg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbru.GML.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(210603);
        return 0;
      }
      AppMethodBeat.o(210603);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bru
 * JD-Core Version:    0.7.0.1
 */