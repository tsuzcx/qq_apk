package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class egf
  extends com.tencent.mm.bw.a
{
  public int GWA;
  public long GeP;
  public buh HkU;
  public LinkedList<String> IjU;
  public LinkedList<aaj> IjV;
  public int Scene;
  public String oxI;
  public String qkN;
  
  public egf()
  {
    AppMethodBeat.i(117951);
    this.IjU = new LinkedList();
    this.IjV = new LinkedList();
    AppMethodBeat.o(117951);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117952);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.IjU);
      paramVarArgs.aS(2, this.GWA);
      if (this.qkN != null) {
        paramVarArgs.d(3, this.qkN);
      }
      paramVarArgs.aS(4, this.Scene);
      paramVarArgs.aZ(5, this.GeP);
      if (this.oxI != null) {
        paramVarArgs.d(6, this.oxI);
      }
      if (this.HkU != null)
      {
        paramVarArgs.lJ(7, this.HkU.computeSize());
        this.HkU.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.IjV);
      AppMethodBeat.o(117952);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 1, this.IjU) + 0 + f.a.a.b.b.a.bz(2, this.GWA);
      paramInt = i;
      if (this.qkN != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.qkN);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.Scene) + f.a.a.b.b.a.p(5, this.GeP);
      paramInt = i;
      if (this.oxI != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.oxI);
      }
      i = paramInt;
      if (this.HkU != null) {
        i = paramInt + f.a.a.a.lI(7, this.HkU.computeSize());
      }
      paramInt = f.a.a.a.c(8, 8, this.IjV);
      AppMethodBeat.o(117952);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.IjU.clear();
      this.IjV.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(117952);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      egf localegf = (egf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117952);
        return -1;
      case 1: 
        localegf.IjU.add(((f.a.a.a.a)localObject1).OmT.readString());
        AppMethodBeat.o(117952);
        return 0;
      case 2: 
        localegf.GWA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117952);
        return 0;
      case 3: 
        localegf.qkN = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117952);
        return 0;
      case 4: 
        localegf.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117952);
        return 0;
      case 5: 
        localegf.GeP = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(117952);
        return 0;
      case 6: 
        localegf.oxI = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117952);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new buh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((buh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localegf.HkU = ((buh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117952);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aaj();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((aaj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localegf.IjV.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117952);
      return 0;
    }
    AppMethodBeat.o(117952);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egf
 * JD-Core Version:    0.7.0.1
 */