package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gw
  extends com.tencent.mm.bx.a
{
  public String FyO;
  public dtu FyP;
  public String FyQ;
  public cxo FyR;
  public String scope;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147757);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.d(1, this.scope);
      }
      if (this.FyO != null) {
        paramVarArgs.d(2, this.FyO);
      }
      paramVarArgs.aS(3, this.state);
      if (this.FyP != null)
      {
        paramVarArgs.lC(4, this.FyP.computeSize());
        this.FyP.writeFields(paramVarArgs);
      }
      if (this.FyQ != null) {
        paramVarArgs.d(5, this.FyQ);
      }
      if (this.FyR != null)
      {
        paramVarArgs.lC(6, this.FyR.computeSize());
        this.FyR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(147757);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = f.a.a.b.b.a.e(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FyO != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FyO);
      }
      i += f.a.a.b.b.a.bz(3, this.state);
      paramInt = i;
      if (this.FyP != null) {
        paramInt = i + f.a.a.a.lB(4, this.FyP.computeSize());
      }
      i = paramInt;
      if (this.FyQ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FyQ);
      }
      paramInt = i;
      if (this.FyR != null) {
        paramInt = i + f.a.a.a.lB(6, this.FyR.computeSize());
      }
      AppMethodBeat.o(147757);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(147757);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        gw localgw = (gw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147757);
          return -1;
        case 1: 
          localgw.scope = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(147757);
          return 0;
        case 2: 
          localgw.FyO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(147757);
          return 0;
        case 3: 
          localgw.state = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(147757);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dtu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dtu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgw.FyP = ((dtu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147757);
          return 0;
        case 5: 
          localgw.FyQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(147757);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgw.FyR = ((cxo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(147757);
        return 0;
      }
      AppMethodBeat.o(147757);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gw
 * JD-Core Version:    0.7.0.1
 */