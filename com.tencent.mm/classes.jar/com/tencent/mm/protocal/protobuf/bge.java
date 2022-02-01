package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bge
  extends com.tencent.mm.bx.a
{
  public long DDR;
  public long DDS;
  public LinkedList<bxx> DDT;
  public int DDU;
  public LinkedList<bxt> DDV;
  public int DDW;
  public int DDX;
  public long DDY;
  public boolean DDZ;
  
  public bge()
  {
    AppMethodBeat.i(122515);
    this.DDR = 0L;
    this.DDS = 0L;
    this.DDT = new LinkedList();
    this.DDU = -1;
    this.DDV = new LinkedList();
    this.DDW = -1;
    this.DDX = -1;
    this.DDY = 0L;
    this.DDZ = false;
    AppMethodBeat.o(122515);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122516);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.DDR);
      paramVarArgs.aG(2, this.DDS);
      paramVarArgs.e(3, 8, this.DDT);
      paramVarArgs.aR(4, this.DDU);
      paramVarArgs.e(5, 8, this.DDV);
      paramVarArgs.aR(6, this.DDW);
      paramVarArgs.aR(7, this.DDX);
      paramVarArgs.aG(8, this.DDY);
      paramVarArgs.bg(9, this.DDZ);
      AppMethodBeat.o(122516);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.q(1, this.DDR);
      i = f.a.a.b.b.a.q(2, this.DDS);
      int j = f.a.a.a.c(3, 8, this.DDT);
      int k = f.a.a.b.b.a.bA(4, this.DDU);
      int m = f.a.a.a.c(5, 8, this.DDV);
      int n = f.a.a.b.b.a.bA(6, this.DDW);
      int i1 = f.a.a.b.b.a.bA(7, this.DDX);
      int i2 = f.a.a.b.b.a.q(8, this.DDY);
      int i3 = f.a.a.b.b.a.fY(9);
      AppMethodBeat.o(122516);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + (i3 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DDT.clear();
      this.DDV.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(122516);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bge localbge = (bge)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122516);
        return -1;
      case 1: 
        localbge.DDR = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(122516);
        return 0;
      case 2: 
        localbge.DDS = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(122516);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bxx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbge.DDT.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122516);
        return 0;
      case 4: 
        localbge.DDU = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(122516);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bxt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbge.DDV.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122516);
        return 0;
      case 6: 
        localbge.DDW = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(122516);
        return 0;
      case 7: 
        localbge.DDX = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(122516);
        return 0;
      case 8: 
        localbge.DDY = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(122516);
        return 0;
      }
      localbge.DDZ = ((f.a.a.a.a)localObject1).KhF.fHu();
      AppMethodBeat.o(122516);
      return 0;
    }
    AppMethodBeat.o(122516);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bge
 * JD-Core Version:    0.7.0.1
 */