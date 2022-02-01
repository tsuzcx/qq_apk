package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbb
  extends com.tencent.mm.bx.a
{
  public LinkedList<dbd> HqS;
  public LinkedList<dba> HqT;
  public dbc HqU;
  public LinkedList<dbf> HqV;
  public boolean fRb;
  public boolean rzM;
  
  public dbb()
  {
    AppMethodBeat.i(122527);
    this.fRb = true;
    this.rzM = false;
    this.HqS = new LinkedList();
    this.HqT = new LinkedList();
    this.HqV = new LinkedList();
    AppMethodBeat.o(122527);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122528);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bt(1, this.fRb);
      paramVarArgs.bt(2, this.rzM);
      paramVarArgs.e(3, 8, this.HqS);
      paramVarArgs.e(4, 8, this.HqT);
      if (this.HqU != null)
      {
        paramVarArgs.lC(5, this.HqU.computeSize());
        this.HqU.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.HqV);
      AppMethodBeat.o(122528);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.alV(1) + 0 + f.a.a.b.b.a.alV(2) + f.a.a.a.c(3, 8, this.HqS) + f.a.a.a.c(4, 8, this.HqT);
      paramInt = i;
      if (this.HqU != null) {
        paramInt = i + f.a.a.a.lB(5, this.HqU.computeSize());
      }
      i = f.a.a.a.c(6, 8, this.HqV);
      AppMethodBeat.o(122528);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HqS.clear();
      this.HqT.clear();
      this.HqV.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(122528);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dbb localdbb = (dbb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122528);
        return -1;
      case 1: 
        localdbb.fRb = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(122528);
        return 0;
      case 2: 
        localdbb.rzM = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(122528);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dbd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dbd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdbb.HqS.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122528);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dba();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dba)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdbb.HqT.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122528);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dbc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dbc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdbb.HqU = ((dbc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122528);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dbf();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dbf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdbb.HqV.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(122528);
      return 0;
    }
    AppMethodBeat.o(122528);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbb
 * JD-Core Version:    0.7.0.1
 */