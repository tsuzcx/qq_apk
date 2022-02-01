package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eia
  extends com.tencent.mm.bw.a
{
  public int FYj;
  public LinkedList<egx> GZf;
  public LinkedList<ty> Guk;
  public int IlB;
  public String IlC;
  public String IlD;
  public int IlE;
  public fv IlF;
  
  public eia()
  {
    AppMethodBeat.i(123694);
    this.Guk = new LinkedList();
    this.GZf = new LinkedList();
    AppMethodBeat.o(123694);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123695);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FYj);
      paramVarArgs.aS(2, this.IlB);
      if (this.IlC != null) {
        paramVarArgs.d(3, this.IlC);
      }
      if (this.IlD != null) {
        paramVarArgs.d(4, this.IlD);
      }
      paramVarArgs.aS(5, this.IlE);
      paramVarArgs.e(6, 8, this.Guk);
      if (this.IlF != null)
      {
        paramVarArgs.lJ(7, this.IlF.computeSize());
        this.IlF.writeFields(paramVarArgs);
      }
      paramVarArgs.e(36, 8, this.GZf);
      AppMethodBeat.o(123695);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.FYj) + 0 + f.a.a.b.b.a.bz(2, this.IlB);
      paramInt = i;
      if (this.IlC != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.IlC);
      }
      i = paramInt;
      if (this.IlD != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.IlD);
      }
      i = i + f.a.a.b.b.a.bz(5, this.IlE) + f.a.a.a.c(6, 8, this.Guk);
      paramInt = i;
      if (this.IlF != null) {
        paramInt = i + f.a.a.a.lI(7, this.IlF.computeSize());
      }
      i = f.a.a.a.c(36, 8, this.GZf);
      AppMethodBeat.o(123695);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Guk.clear();
      this.GZf.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(123695);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      eia localeia = (eia)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(123695);
        return -1;
      case 1: 
        localeia.FYj = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(123695);
        return 0;
      case 2: 
        localeia.IlB = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(123695);
        return 0;
      case 3: 
        localeia.IlC = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(123695);
        return 0;
      case 4: 
        localeia.IlD = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(123695);
        return 0;
      case 5: 
        localeia.IlE = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(123695);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ty();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ty)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeia.Guk.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123695);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((fv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeia.IlF = ((fv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123695);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new egx();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((egx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localeia.GZf.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(123695);
      return 0;
    }
    AppMethodBeat.o(123695);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eia
 * JD-Core Version:    0.7.0.1
 */