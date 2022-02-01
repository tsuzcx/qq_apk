package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmc
  extends com.tencent.mm.bx.a
{
  public LinkedList<abt> Dbq;
  public dca Ehg;
  public abs Ehh;
  public int Ehi;
  public boolean Ehj;
  public zg Ehk;
  public bd Ehl;
  public int type;
  public String url;
  
  public cmc()
  {
    AppMethodBeat.i(91676);
    this.Dbq = new LinkedList();
    AppMethodBeat.o(91676);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91677);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.Ehg != null)
      {
        paramVarArgs.kX(3, this.Ehg.computeSize());
        this.Ehg.writeFields(paramVarArgs);
      }
      if (this.Ehh != null)
      {
        paramVarArgs.kX(4, this.Ehh.computeSize());
        this.Ehh.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.Ehi);
      paramVarArgs.bg(6, this.Ehj);
      paramVarArgs.e(7, 8, this.Dbq);
      if (this.Ehk != null)
      {
        paramVarArgs.kX(8, this.Ehk.computeSize());
        this.Ehk.writeFields(paramVarArgs);
      }
      if (this.Ehl != null)
      {
        paramVarArgs.kX(9, this.Ehl.computeSize());
        this.Ehl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91677);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.type) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.Ehg != null) {
        i = paramInt + f.a.a.a.kW(3, this.Ehg.computeSize());
      }
      paramInt = i;
      if (this.Ehh != null) {
        paramInt = i + f.a.a.a.kW(4, this.Ehh.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.Ehi) + (f.a.a.b.b.a.fY(6) + 1) + f.a.a.a.c(7, 8, this.Dbq);
      paramInt = i;
      if (this.Ehk != null) {
        paramInt = i + f.a.a.a.kW(8, this.Ehk.computeSize());
      }
      i = paramInt;
      if (this.Ehl != null) {
        i = paramInt + f.a.a.a.kW(9, this.Ehl.computeSize());
      }
      AppMethodBeat.o(91677);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Dbq.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(91677);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cmc localcmc = (cmc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91677);
        return -1;
      case 1: 
        localcmc.type = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91677);
        return 0;
      case 2: 
        localcmc.url = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91677);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dca();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dca)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcmc.Ehg = ((dca)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcmc.Ehh = ((abs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      case 5: 
        localcmc.Ehi = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91677);
        return 0;
      case 6: 
        localcmc.Ehj = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(91677);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcmc.Dbq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new zg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((zg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcmc.Ehk = ((zg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bd();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcmc.Ehl = ((bd)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91677);
      return 0;
    }
    AppMethodBeat.o(91677);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmc
 * JD-Core Version:    0.7.0.1
 */