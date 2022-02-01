package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abu
  extends com.tencent.mm.bx.a
{
  public int Dch;
  public String Dci;
  public String Dcj;
  public int Dck;
  public int Dcl;
  public int Dcm;
  public dli Dcn;
  public int Dco;
  public LinkedList<dmw> Dcp;
  public int Dcq;
  public int Dcr;
  
  public abu()
  {
    AppMethodBeat.i(115835);
    this.Dcp = new LinkedList();
    AppMethodBeat.o(115835);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115836);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Dch);
      if (this.Dci != null) {
        paramVarArgs.d(2, this.Dci);
      }
      if (this.Dcj != null) {
        paramVarArgs.d(3, this.Dcj);
      }
      paramVarArgs.aR(4, this.Dck);
      paramVarArgs.aR(5, this.Dcl);
      paramVarArgs.aR(6, this.Dcm);
      if (this.Dcn != null)
      {
        paramVarArgs.kX(7, this.Dcn.computeSize());
        this.Dcn.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.Dco);
      paramVarArgs.e(9, 8, this.Dcp);
      paramVarArgs.aR(10, this.Dcq);
      paramVarArgs.aR(11, this.Dcr);
      AppMethodBeat.o(115836);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.Dch) + 0;
      paramInt = i;
      if (this.Dci != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Dci);
      }
      i = paramInt;
      if (this.Dcj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Dcj);
      }
      i = i + f.a.a.b.b.a.bA(4, this.Dck) + f.a.a.b.b.a.bA(5, this.Dcl) + f.a.a.b.b.a.bA(6, this.Dcm);
      paramInt = i;
      if (this.Dcn != null) {
        paramInt = i + f.a.a.a.kW(7, this.Dcn.computeSize());
      }
      i = f.a.a.b.b.a.bA(8, this.Dco);
      int j = f.a.a.a.c(9, 8, this.Dcp);
      int k = f.a.a.b.b.a.bA(10, this.Dcq);
      int m = f.a.a.b.b.a.bA(11, this.Dcr);
      AppMethodBeat.o(115836);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Dcp.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(115836);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      abu localabu = (abu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115836);
        return -1;
      case 1: 
        localabu.Dch = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115836);
        return 0;
      case 2: 
        localabu.Dci = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(115836);
        return 0;
      case 3: 
        localabu.Dcj = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(115836);
        return 0;
      case 4: 
        localabu.Dck = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115836);
        return 0;
      case 5: 
        localabu.Dcl = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115836);
        return 0;
      case 6: 
        localabu.Dcm = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115836);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dli();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dli)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localabu.Dcn = ((dli)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115836);
        return 0;
      case 8: 
        localabu.Dco = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115836);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dmw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dmw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localabu.Dcp.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115836);
        return 0;
      case 10: 
        localabu.Dcq = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115836);
        return 0;
      }
      localabu.Dcr = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(115836);
      return 0;
    }
    AppMethodBeat.o(115836);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abu
 * JD-Core Version:    0.7.0.1
 */