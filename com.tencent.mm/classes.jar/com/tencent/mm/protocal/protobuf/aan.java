package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aan
  extends com.tencent.mm.bx.a
{
  public aao BEZ;
  public aam BFa;
  public boolean BGm;
  public boolean BGn;
  public LinkedList<dom> FZu;
  public long FZv;
  public long FZw;
  public boolean FZx;
  public LinkedList<bxn> FZy;
  public dvx FZz;
  public String hml;
  
  public aan()
  {
    AppMethodBeat.i(215799);
    this.FZu = new LinkedList();
    this.FZy = new LinkedList();
    AppMethodBeat.o(215799);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215800);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.FZu);
      paramVarArgs.aY(2, this.FZv);
      paramVarArgs.aY(3, this.FZw);
      paramVarArgs.bt(4, this.BGm);
      if (this.hml != null) {
        paramVarArgs.d(5, this.hml);
      }
      if (this.BEZ != null)
      {
        paramVarArgs.lC(6, this.BEZ.computeSize());
        this.BEZ.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(7, this.FZx);
      if (this.BFa != null)
      {
        paramVarArgs.lC(8, this.BFa.computeSize());
        this.BFa.writeFields(paramVarArgs);
      }
      paramVarArgs.e(9, 8, this.FZy);
      if (this.FZz != null)
      {
        paramVarArgs.lC(10, this.FZz.computeSize());
        this.FZz.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(11, this.BGn);
      AppMethodBeat.o(215800);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.FZu) + 0 + f.a.a.b.b.a.p(2, this.FZv) + f.a.a.b.b.a.p(3, this.FZw) + f.a.a.b.b.a.alV(4);
      paramInt = i;
      if (this.hml != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hml);
      }
      i = paramInt;
      if (this.BEZ != null) {
        i = paramInt + f.a.a.a.lB(6, this.BEZ.computeSize());
      }
      i += f.a.a.b.b.a.alV(7);
      paramInt = i;
      if (this.BFa != null) {
        paramInt = i + f.a.a.a.lB(8, this.BFa.computeSize());
      }
      i = paramInt + f.a.a.a.c(9, 8, this.FZy);
      paramInt = i;
      if (this.FZz != null) {
        paramInt = i + f.a.a.a.lB(10, this.FZz.computeSize());
      }
      i = f.a.a.b.b.a.alV(11);
      AppMethodBeat.o(215800);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FZu.clear();
      this.FZy.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(215800);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aan localaan = (aan)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(215800);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dom();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dom)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaan.FZu.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(215800);
        return 0;
      case 2: 
        localaan.FZv = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(215800);
        return 0;
      case 3: 
        localaan.FZw = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(215800);
        return 0;
      case 4: 
        localaan.BGm = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(215800);
        return 0;
      case 5: 
        localaan.hml = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(215800);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aao();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aao)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaan.BEZ = ((aao)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(215800);
        return 0;
      case 7: 
        localaan.FZx = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(215800);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aam();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aam)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaan.BFa = ((aam)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(215800);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaan.FZy.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(215800);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dvx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dvx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaan.FZz = ((dvx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(215800);
        return 0;
      }
      localaan.BGn = ((f.a.a.a.a)localObject1).NPN.grw();
      AppMethodBeat.o(215800);
      return 0;
    }
    AppMethodBeat.o(215800);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aan
 * JD-Core Version:    0.7.0.1
 */