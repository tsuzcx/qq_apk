package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avo
  extends com.tencent.mm.bw.a
{
  public LinkedList<byz> BXX;
  public long FVA;
  public boolean FVC;
  public long FVz;
  public dbo GMB;
  public long GMC;
  public long GMD;
  public long GME;
  public long GMF;
  public long GMG;
  public long uin;
  
  public avo()
  {
    AppMethodBeat.i(110895);
    this.BXX = new LinkedList();
    this.GMC = 10L;
    this.GMD = 0L;
    this.FVC = false;
    this.GME = 0L;
    this.GMF = 0L;
    this.GMG = 0L;
    AppMethodBeat.o(110895);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110896);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.FVz);
      paramVarArgs.aZ(2, this.uin);
      paramVarArgs.aZ(3, this.FVA);
      paramVarArgs.e(4, 8, this.BXX);
      if (this.GMB != null)
      {
        paramVarArgs.lJ(5, this.GMB.computeSize());
        this.GMB.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(6, this.GMC);
      paramVarArgs.aZ(7, this.GMD);
      paramVarArgs.bC(8, this.FVC);
      paramVarArgs.aZ(9, this.GME);
      paramVarArgs.aZ(10, this.GMF);
      paramVarArgs.aZ(11, this.GMG);
      AppMethodBeat.o(110896);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.FVz) + 0 + f.a.a.b.b.a.p(2, this.uin) + f.a.a.b.b.a.p(3, this.FVA) + f.a.a.a.c(4, 8, this.BXX);
      paramInt = i;
      if (this.GMB != null) {
        paramInt = i + f.a.a.a.lI(5, this.GMB.computeSize());
      }
      i = f.a.a.b.b.a.p(6, this.GMC);
      int j = f.a.a.b.b.a.p(7, this.GMD);
      int k = f.a.a.b.b.a.amF(8);
      int m = f.a.a.b.b.a.p(9, this.GME);
      int n = f.a.a.b.b.a.p(10, this.GMF);
      int i1 = f.a.a.b.b.a.p(11, this.GMG);
      AppMethodBeat.o(110896);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.BXX.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(110896);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      avo localavo = (avo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110896);
        return -1;
      case 1: 
        localavo.FVz = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110896);
        return 0;
      case 2: 
        localavo.uin = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110896);
        return 0;
      case 3: 
        localavo.FVA = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110896);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new byz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((byz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localavo.BXX.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110896);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dbo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dbo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localavo.GMB = ((dbo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110896);
        return 0;
      case 6: 
        localavo.GMC = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110896);
        return 0;
      case 7: 
        localavo.GMD = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110896);
        return 0;
      case 8: 
        localavo.FVC = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(110896);
        return 0;
      case 9: 
        localavo.GME = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110896);
        return 0;
      case 10: 
        localavo.GMF = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110896);
        return 0;
      }
      localavo.GMG = ((f.a.a.a.a)localObject1).OmT.zd();
      AppMethodBeat.o(110896);
      return 0;
    }
    AppMethodBeat.o(110896);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avo
 * JD-Core Version:    0.7.0.1
 */