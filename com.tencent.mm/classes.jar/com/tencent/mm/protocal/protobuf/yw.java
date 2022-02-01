package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yw
  extends com.tencent.mm.bw.a
  implements dfi
{
  public int GqI;
  public int GqJ;
  public int GqK;
  public LinkedList<dlb> GqL;
  public LinkedList<dlb> GqM;
  public LinkedList<dlb> GqN;
  public int GqO;
  public int GqP;
  public int GqQ;
  public boq GqR;
  public int Ret;
  
  public yw()
  {
    AppMethodBeat.i(143969);
    this.GqL = new LinkedList();
    this.GqM = new LinkedList();
    this.GqN = new LinkedList();
    AppMethodBeat.o(143969);
  }
  
  public final int getRet()
  {
    return this.Ret;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143970);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Ret);
      paramVarArgs.aS(2, this.GqI);
      paramVarArgs.aS(3, this.GqJ);
      paramVarArgs.aS(4, this.GqK);
      paramVarArgs.e(5, 8, this.GqL);
      paramVarArgs.e(6, 8, this.GqM);
      paramVarArgs.e(7, 8, this.GqN);
      paramVarArgs.aS(8, this.GqO);
      paramVarArgs.aS(9, this.GqP);
      paramVarArgs.aS(10, this.GqQ);
      if (this.GqR != null)
      {
        paramVarArgs.lJ(11, this.GqR.computeSize());
        this.GqR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143970);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Ret) + 0 + f.a.a.b.b.a.bz(2, this.GqI) + f.a.a.b.b.a.bz(3, this.GqJ) + f.a.a.b.b.a.bz(4, this.GqK) + f.a.a.a.c(5, 8, this.GqL) + f.a.a.a.c(6, 8, this.GqM) + f.a.a.a.c(7, 8, this.GqN) + f.a.a.b.b.a.bz(8, this.GqO) + f.a.a.b.b.a.bz(9, this.GqP) + f.a.a.b.b.a.bz(10, this.GqQ);
      paramInt = i;
      if (this.GqR != null) {
        paramInt = i + f.a.a.a.lI(11, this.GqR.computeSize());
      }
      AppMethodBeat.o(143970);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GqL.clear();
      this.GqM.clear();
      this.GqN.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(143970);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      yw localyw = (yw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143970);
        return -1;
      case 1: 
        localyw.Ret = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143970);
        return 0;
      case 2: 
        localyw.GqI = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143970);
        return 0;
      case 3: 
        localyw.GqJ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143970);
        return 0;
      case 4: 
        localyw.GqK = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143970);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dlb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dlb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyw.GqL.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143970);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dlb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dlb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyw.GqM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143970);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dlb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dlb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyw.GqN.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143970);
        return 0;
      case 8: 
        localyw.GqO = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143970);
        return 0;
      case 9: 
        localyw.GqP = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143970);
        return 0;
      case 10: 
        localyw.GqQ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143970);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new boq();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((boq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localyw.GqR = ((boq)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143970);
      return 0;
    }
    AppMethodBeat.o(143970);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yw
 * JD-Core Version:    0.7.0.1
 */