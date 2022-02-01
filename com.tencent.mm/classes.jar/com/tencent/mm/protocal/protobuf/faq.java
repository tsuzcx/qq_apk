package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class faq
  extends com.tencent.mm.bw.a
{
  public long KZg;
  public int MaY;
  public chl MlQ;
  public aah MlR;
  public LinkedList<String> NwT;
  public LinkedList<aca> NwU;
  public int Scene;
  public String pLm;
  public String rBI;
  
  public faq()
  {
    AppMethodBeat.i(117951);
    this.NwT = new LinkedList();
    this.NwU = new LinkedList();
    AppMethodBeat.o(117951);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117952);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.NwT);
      paramVarArgs.aM(2, this.MaY);
      if (this.rBI != null) {
        paramVarArgs.e(3, this.rBI);
      }
      paramVarArgs.aM(4, this.Scene);
      paramVarArgs.bb(5, this.KZg);
      if (this.pLm != null) {
        paramVarArgs.e(6, this.pLm);
      }
      if (this.MlQ != null)
      {
        paramVarArgs.ni(7, this.MlQ.computeSize());
        this.MlQ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.NwU);
      if (this.MlR != null)
      {
        paramVarArgs.ni(9, this.MlR.computeSize());
        this.MlR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117952);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 1, this.NwT) + 0 + g.a.a.b.b.a.bu(2, this.MaY);
      paramInt = i;
      if (this.rBI != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.rBI);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.Scene) + g.a.a.b.b.a.r(5, this.KZg);
      paramInt = i;
      if (this.pLm != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.pLm);
      }
      i = paramInt;
      if (this.MlQ != null) {
        i = paramInt + g.a.a.a.nh(7, this.MlQ.computeSize());
      }
      i += g.a.a.a.c(8, 8, this.NwU);
      paramInt = i;
      if (this.MlR != null) {
        paramInt = i + g.a.a.a.nh(9, this.MlR.computeSize());
      }
      AppMethodBeat.o(117952);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.NwT.clear();
      this.NwU.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(117952);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      faq localfaq = (faq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117952);
        return -1;
      case 1: 
        localfaq.NwT.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(117952);
        return 0;
      case 2: 
        localfaq.MaY = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117952);
        return 0;
      case 3: 
        localfaq.rBI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117952);
        return 0;
      case 4: 
        localfaq.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117952);
        return 0;
      case 5: 
        localfaq.KZg = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(117952);
        return 0;
      case 6: 
        localfaq.pLm = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117952);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new chl();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((chl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localfaq.MlQ = ((chl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117952);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aca();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aca)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localfaq.NwU.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117952);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aah();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((aah)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localfaq.MlR = ((aah)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117952);
      return 0;
    }
    AppMethodBeat.o(117952);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.faq
 * JD-Core Version:    0.7.0.1
 */