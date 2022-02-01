package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bow
  extends com.tencent.mm.bw.a
{
  public long Hcm;
  public long Hcn;
  public LinkedList<cie> Hco;
  public int Hcp;
  public LinkedList<cia> Hcq;
  public int Hcr;
  public int Hcs;
  public boolean Hct;
  public long gvD;
  
  public bow()
  {
    AppMethodBeat.i(122515);
    this.Hcm = 0L;
    this.Hcn = 0L;
    this.Hco = new LinkedList();
    this.Hcp = -1;
    this.Hcq = new LinkedList();
    this.Hcr = -1;
    this.Hcs = -1;
    this.gvD = 0L;
    this.Hct = false;
    AppMethodBeat.o(122515);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122516);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.Hcm);
      paramVarArgs.aZ(2, this.Hcn);
      paramVarArgs.e(3, 8, this.Hco);
      paramVarArgs.aS(4, this.Hcp);
      paramVarArgs.e(5, 8, this.Hcq);
      paramVarArgs.aS(6, this.Hcr);
      paramVarArgs.aS(7, this.Hcs);
      paramVarArgs.aZ(8, this.gvD);
      paramVarArgs.bC(9, this.Hct);
      AppMethodBeat.o(122516);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.Hcm);
      i = f.a.a.b.b.a.p(2, this.Hcn);
      int j = f.a.a.a.c(3, 8, this.Hco);
      int k = f.a.a.b.b.a.bz(4, this.Hcp);
      int m = f.a.a.a.c(5, 8, this.Hcq);
      int n = f.a.a.b.b.a.bz(6, this.Hcr);
      int i1 = f.a.a.b.b.a.bz(7, this.Hcs);
      int i2 = f.a.a.b.b.a.p(8, this.gvD);
      int i3 = f.a.a.b.b.a.amF(9);
      AppMethodBeat.o(122516);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Hco.clear();
      this.Hcq.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(122516);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bow localbow = (bow)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122516);
        return -1;
      case 1: 
        localbow.Hcm = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(122516);
        return 0;
      case 2: 
        localbow.Hcn = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(122516);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cie();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cie)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbow.Hco.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122516);
        return 0;
      case 4: 
        localbow.Hcp = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(122516);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cia();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cia)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbow.Hcq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122516);
        return 0;
      case 6: 
        localbow.Hcr = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(122516);
        return 0;
      case 7: 
        localbow.Hcs = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(122516);
        return 0;
      case 8: 
        localbow.gvD = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(122516);
        return 0;
      }
      localbow.Hct = ((f.a.a.a.a)localObject1).OmT.gvY();
      AppMethodBeat.o(122516);
      return 0;
    }
    AppMethodBeat.o(122516);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bow
 * JD-Core Version:    0.7.0.1
 */