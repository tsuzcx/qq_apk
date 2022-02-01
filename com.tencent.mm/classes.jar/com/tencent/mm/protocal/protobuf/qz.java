package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class qz
  extends com.tencent.mm.bw.a
{
  public LinkedList<ov> Gfi;
  public LinkedList<edw> Gfj;
  public LinkedList<afi> Gfk;
  public LinkedList<egz> Gfl;
  public cuu Gfm;
  public b Gfn;
  public LinkedList<ciu> Gfo;
  public int nJA;
  
  public qz()
  {
    AppMethodBeat.i(117848);
    this.Gfi = new LinkedList();
    this.Gfj = new LinkedList();
    this.Gfk = new LinkedList();
    this.Gfl = new LinkedList();
    this.Gfo = new LinkedList();
    AppMethodBeat.o(117848);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117849);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nJA);
      paramVarArgs.e(2, 8, this.Gfi);
      paramVarArgs.e(3, 8, this.Gfj);
      paramVarArgs.e(4, 8, this.Gfk);
      paramVarArgs.e(5, 8, this.Gfl);
      if (this.Gfm != null)
      {
        paramVarArgs.lJ(6, this.Gfm.computeSize());
        this.Gfm.writeFields(paramVarArgs);
      }
      if (this.Gfn != null) {
        paramVarArgs.c(7, this.Gfn);
      }
      paramVarArgs.e(8, 8, this.Gfo);
      AppMethodBeat.o(117849);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.nJA) + 0 + f.a.a.a.c(2, 8, this.Gfi) + f.a.a.a.c(3, 8, this.Gfj) + f.a.a.a.c(4, 8, this.Gfk) + f.a.a.a.c(5, 8, this.Gfl);
      paramInt = i;
      if (this.Gfm != null) {
        paramInt = i + f.a.a.a.lI(6, this.Gfm.computeSize());
      }
      i = paramInt;
      if (this.Gfn != null) {
        i = paramInt + f.a.a.b.b.a.b(7, this.Gfn);
      }
      paramInt = f.a.a.a.c(8, 8, this.Gfo);
      AppMethodBeat.o(117849);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Gfi.clear();
      this.Gfj.clear();
      this.Gfk.clear();
      this.Gfl.clear();
      this.Gfo.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(117849);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      qz localqz = (qz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117849);
        return -1;
      case 1: 
        localqz.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117849);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ov();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ov)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqz.Gfi.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new edw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((edw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqz.Gfj.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new afi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((afi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqz.Gfk.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new egz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((egz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqz.Gfl.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cuu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cuu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqz.Gfm = ((cuu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 7: 
        localqz.Gfn = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(117849);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ciu();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ciu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localqz.Gfo.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117849);
      return 0;
    }
    AppMethodBeat.o(117849);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qz
 * JD-Core Version:    0.7.0.1
 */