package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class asf
  extends com.tencent.mm.bx.a
  implements ctq
{
  public int CYp;
  public int CYq;
  public int CYr;
  public LinkedList<czh> CYs;
  public LinkedList<czh> CYt;
  public LinkedList<czh> CYu;
  public int CYv;
  public int CYw;
  public int CYx;
  public bfy CYy;
  public int Dsu;
  public int Dsv;
  public int Dsw;
  public LinkedList<czh> Dsx;
  public LinkedList<czh> Dsy;
  public LinkedList<czh> Dsz;
  public int Ret;
  
  public asf()
  {
    AppMethodBeat.i(143974);
    this.CYs = new LinkedList();
    this.CYt = new LinkedList();
    this.CYu = new LinkedList();
    this.Dsx = new LinkedList();
    this.Dsy = new LinkedList();
    this.Dsz = new LinkedList();
    AppMethodBeat.o(143974);
  }
  
  public final int getRet()
  {
    return this.Ret;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143975);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ret);
      paramVarArgs.aR(2, this.CYp);
      paramVarArgs.aR(3, this.CYq);
      paramVarArgs.aR(4, this.CYr);
      paramVarArgs.e(5, 8, this.CYs);
      paramVarArgs.e(6, 8, this.CYt);
      paramVarArgs.e(7, 8, this.CYu);
      paramVarArgs.aR(8, this.CYv);
      paramVarArgs.aR(9, this.CYw);
      paramVarArgs.aR(10, this.CYx);
      paramVarArgs.aR(11, this.Dsu);
      paramVarArgs.aR(12, this.Dsv);
      paramVarArgs.aR(13, this.Dsw);
      paramVarArgs.e(14, 8, this.Dsx);
      paramVarArgs.e(15, 8, this.Dsy);
      paramVarArgs.e(16, 8, this.Dsz);
      if (this.CYy != null)
      {
        paramVarArgs.kX(17, this.CYy.computeSize());
        this.CYy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143975);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.Ret) + 0 + f.a.a.b.b.a.bA(2, this.CYp) + f.a.a.b.b.a.bA(3, this.CYq) + f.a.a.b.b.a.bA(4, this.CYr) + f.a.a.a.c(5, 8, this.CYs) + f.a.a.a.c(6, 8, this.CYt) + f.a.a.a.c(7, 8, this.CYu) + f.a.a.b.b.a.bA(8, this.CYv) + f.a.a.b.b.a.bA(9, this.CYw) + f.a.a.b.b.a.bA(10, this.CYx) + f.a.a.b.b.a.bA(11, this.Dsu) + f.a.a.b.b.a.bA(12, this.Dsv) + f.a.a.b.b.a.bA(13, this.Dsw) + f.a.a.a.c(14, 8, this.Dsx) + f.a.a.a.c(15, 8, this.Dsy) + f.a.a.a.c(16, 8, this.Dsz);
      paramInt = i;
      if (this.CYy != null) {
        paramInt = i + f.a.a.a.kW(17, this.CYy.computeSize());
      }
      AppMethodBeat.o(143975);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CYs.clear();
      this.CYt.clear();
      this.CYu.clear();
      this.Dsx.clear();
      this.Dsy.clear();
      this.Dsz.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(143975);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      asf localasf = (asf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143975);
        return -1;
      case 1: 
        localasf.Ret = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143975);
        return 0;
      case 2: 
        localasf.CYp = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143975);
        return 0;
      case 3: 
        localasf.CYq = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143975);
        return 0;
      case 4: 
        localasf.CYr = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143975);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new czh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((czh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localasf.CYs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new czh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((czh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localasf.CYt.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new czh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((czh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localasf.CYu.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 8: 
        localasf.CYv = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143975);
        return 0;
      case 9: 
        localasf.CYw = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143975);
        return 0;
      case 10: 
        localasf.CYx = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143975);
        return 0;
      case 11: 
        localasf.Dsu = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143975);
        return 0;
      case 12: 
        localasf.Dsv = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143975);
        return 0;
      case 13: 
        localasf.Dsw = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143975);
        return 0;
      case 14: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new czh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((czh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localasf.Dsx.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new czh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((czh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localasf.Dsy.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new czh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((czh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localasf.Dsz.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bfy();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bfy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localasf.CYy = ((bfy)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143975);
      return 0;
    }
    AppMethodBeat.o(143975);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asf
 * JD-Core Version:    0.7.0.1
 */