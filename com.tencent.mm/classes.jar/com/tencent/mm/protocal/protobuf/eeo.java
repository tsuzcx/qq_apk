package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eeo
  extends com.tencent.mm.bx.a
{
  public long FMq;
  public int GDa;
  public btn GRt;
  public LinkedList<String> HPN;
  public LinkedList<aag> HPO;
  public int Scene;
  public String orm;
  public String qei;
  
  public eeo()
  {
    AppMethodBeat.i(117951);
    this.HPN = new LinkedList();
    this.HPO = new LinkedList();
    AppMethodBeat.o(117951);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117952);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.HPN);
      paramVarArgs.aS(2, this.GDa);
      if (this.qei != null) {
        paramVarArgs.d(3, this.qei);
      }
      paramVarArgs.aS(4, this.Scene);
      paramVarArgs.aY(5, this.FMq);
      if (this.orm != null) {
        paramVarArgs.d(6, this.orm);
      }
      if (this.GRt != null)
      {
        paramVarArgs.lC(7, this.GRt.computeSize());
        this.GRt.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.HPO);
      AppMethodBeat.o(117952);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 1, this.HPN) + 0 + f.a.a.b.b.a.bz(2, this.GDa);
      paramInt = i;
      if (this.qei != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.qei);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.Scene) + f.a.a.b.b.a.p(5, this.FMq);
      paramInt = i;
      if (this.orm != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.orm);
      }
      i = paramInt;
      if (this.GRt != null) {
        i = paramInt + f.a.a.a.lB(7, this.GRt.computeSize());
      }
      paramInt = f.a.a.a.c(8, 8, this.HPO);
      AppMethodBeat.o(117952);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HPN.clear();
      this.HPO.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(117952);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      eeo localeeo = (eeo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117952);
        return -1;
      case 1: 
        localeeo.HPN.add(((f.a.a.a.a)localObject1).NPN.readString());
        AppMethodBeat.o(117952);
        return 0;
      case 2: 
        localeeo.GDa = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117952);
        return 0;
      case 3: 
        localeeo.qei = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117952);
        return 0;
      case 4: 
        localeeo.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117952);
        return 0;
      case 5: 
        localeeo.FMq = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(117952);
        return 0;
      case 6: 
        localeeo.orm = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117952);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((btn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeeo.GRt = ((btn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117952);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aag();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((aag)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localeeo.HPO.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117952);
      return 0;
    }
    AppMethodBeat.o(117952);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eeo
 * JD-Core Version:    0.7.0.1
 */