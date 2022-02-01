package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class boe
  extends com.tencent.mm.bx.a
{
  public long GIK;
  public long GIL;
  public LinkedList<chk> GIM;
  public int GIN;
  public LinkedList<chg> GIO;
  public int GIP;
  public int GIQ;
  public long GIR;
  public boolean GIS;
  
  public boe()
  {
    AppMethodBeat.i(122515);
    this.GIK = 0L;
    this.GIL = 0L;
    this.GIM = new LinkedList();
    this.GIN = -1;
    this.GIO = new LinkedList();
    this.GIP = -1;
    this.GIQ = -1;
    this.GIR = 0L;
    this.GIS = false;
    AppMethodBeat.o(122515);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122516);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.GIK);
      paramVarArgs.aY(2, this.GIL);
      paramVarArgs.e(3, 8, this.GIM);
      paramVarArgs.aS(4, this.GIN);
      paramVarArgs.e(5, 8, this.GIO);
      paramVarArgs.aS(6, this.GIP);
      paramVarArgs.aS(7, this.GIQ);
      paramVarArgs.aY(8, this.GIR);
      paramVarArgs.bt(9, this.GIS);
      AppMethodBeat.o(122516);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.GIK);
      i = f.a.a.b.b.a.p(2, this.GIL);
      int j = f.a.a.a.c(3, 8, this.GIM);
      int k = f.a.a.b.b.a.bz(4, this.GIN);
      int m = f.a.a.a.c(5, 8, this.GIO);
      int n = f.a.a.b.b.a.bz(6, this.GIP);
      int i1 = f.a.a.b.b.a.bz(7, this.GIQ);
      int i2 = f.a.a.b.b.a.p(8, this.GIR);
      int i3 = f.a.a.b.b.a.alV(9);
      AppMethodBeat.o(122516);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GIM.clear();
      this.GIO.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(122516);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      boe localboe = (boe)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122516);
        return -1;
      case 1: 
        localboe.GIK = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(122516);
        return 0;
      case 2: 
        localboe.GIL = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(122516);
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
          localboe.GIM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122516);
        return 0;
      case 4: 
        localboe.GIN = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(122516);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new chg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((chg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localboe.GIO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122516);
        return 0;
      case 6: 
        localboe.GIP = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(122516);
        return 0;
      case 7: 
        localboe.GIQ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(122516);
        return 0;
      case 8: 
        localboe.GIR = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(122516);
        return 0;
      }
      localboe.GIS = ((f.a.a.a.a)localObject1).NPN.grw();
      AppMethodBeat.o(122516);
      return 0;
    }
    AppMethodBeat.o(122516);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boe
 * JD-Core Version:    0.7.0.1
 */