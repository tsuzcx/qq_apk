package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class atw
  extends com.tencent.mm.bx.a
{
  public ebd GrP;
  public eba GrQ;
  public ebc GrR;
  public boolean GrS;
  public boolean GrT;
  public String GrU;
  public String GrV;
  public int GrW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209402);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GrP != null)
      {
        paramVarArgs.lC(1, this.GrP.computeSize());
        this.GrP.writeFields(paramVarArgs);
      }
      if (this.GrQ != null)
      {
        paramVarArgs.lC(2, this.GrQ.computeSize());
        this.GrQ.writeFields(paramVarArgs);
      }
      if (this.GrR != null)
      {
        paramVarArgs.lC(3, this.GrR.computeSize());
        this.GrR.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(4, this.GrS);
      paramVarArgs.bt(5, this.GrT);
      if (this.GrU != null) {
        paramVarArgs.d(6, this.GrU);
      }
      if (this.GrV != null) {
        paramVarArgs.d(7, this.GrV);
      }
      paramVarArgs.aS(99, this.GrW);
      AppMethodBeat.o(209402);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GrP == null) {
        break label894;
      }
    }
    label894:
    for (int i = f.a.a.a.lB(1, this.GrP.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GrQ != null) {
        paramInt = i + f.a.a.a.lB(2, this.GrQ.computeSize());
      }
      i = paramInt;
      if (this.GrR != null) {
        i = paramInt + f.a.a.a.lB(3, this.GrR.computeSize());
      }
      i = i + f.a.a.b.b.a.alV(4) + f.a.a.b.b.a.alV(5);
      paramInt = i;
      if (this.GrU != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GrU);
      }
      i = paramInt;
      if (this.GrV != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GrV);
      }
      paramInt = f.a.a.b.b.a.bz(99, this.GrW);
      AppMethodBeat.o(209402);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209402);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        atw localatw = (atw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209402);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localatw.GrP = ((ebd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209402);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eba();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eba)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localatw.GrQ = ((eba)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209402);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localatw.GrR = ((ebc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209402);
          return 0;
        case 4: 
          localatw.GrS = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(209402);
          return 0;
        case 5: 
          localatw.GrT = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(209402);
          return 0;
        case 6: 
          localatw.GrU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209402);
          return 0;
        case 7: 
          localatw.GrV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209402);
          return 0;
        }
        localatw.GrW = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(209402);
        return 0;
      }
      AppMethodBeat.o(209402);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atw
 * JD-Core Version:    0.7.0.1
 */