package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbk
  extends com.tencent.mm.bx.a
{
  public String Gsk;
  public long Gsl;
  public boolean Hrd;
  public LinkedList<boc> Hre;
  public String dyV;
  public int index;
  public boolean ssW;
  
  public dbk()
  {
    AppMethodBeat.i(177411);
    this.index = -1;
    this.Hrd = false;
    this.dyV = "";
    this.Gsl = -1L;
    this.Gsk = "";
    this.Hre = new LinkedList();
    this.ssW = false;
    AppMethodBeat.o(177411);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(177412);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.index);
      paramVarArgs.bt(2, this.Hrd);
      if (this.dyV != null) {
        paramVarArgs.d(3, this.dyV);
      }
      paramVarArgs.aY(4, this.Gsl);
      if (this.Gsk != null) {
        paramVarArgs.d(5, this.Gsk);
      }
      paramVarArgs.e(6, 8, this.Hre);
      paramVarArgs.bt(7, this.ssW);
      AppMethodBeat.o(177412);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.index) + 0 + f.a.a.b.b.a.alV(2);
      paramInt = i;
      if (this.dyV != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dyV);
      }
      i = paramInt + f.a.a.b.b.a.p(4, this.Gsl);
      paramInt = i;
      if (this.Gsk != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Gsk);
      }
      i = f.a.a.a.c(6, 8, this.Hre);
      int j = f.a.a.b.b.a.alV(7);
      AppMethodBeat.o(177412);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Hre.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(177412);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dbk localdbk = (dbk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(177412);
        return -1;
      case 1: 
        localdbk.index = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(177412);
        return 0;
      case 2: 
        localdbk.Hrd = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(177412);
        return 0;
      case 3: 
        localdbk.dyV = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(177412);
        return 0;
      case 4: 
        localdbk.Gsl = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(177412);
        return 0;
      case 5: 
        localdbk.Gsk = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(177412);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new boc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((boc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdbk.Hre.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(177412);
        return 0;
      }
      localdbk.ssW = ((f.a.a.a.a)localObject1).NPN.grw();
      AppMethodBeat.o(177412);
      return 0;
    }
    AppMethodBeat.o(177412);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbk
 * JD-Core Version:    0.7.0.1
 */