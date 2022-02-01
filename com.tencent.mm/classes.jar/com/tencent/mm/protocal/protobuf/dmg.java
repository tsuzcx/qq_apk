package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmg
  extends com.tencent.mm.bw.a
{
  public String FUn;
  public int HCb;
  public int HTF;
  public afc HTG;
  public afc HTH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91706);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HCb);
      paramVarArgs.aS(2, this.HTF);
      if (this.FUn != null) {
        paramVarArgs.d(3, this.FUn);
      }
      if (this.HTG != null)
      {
        paramVarArgs.lJ(4, this.HTG.computeSize());
        this.HTG.writeFields(paramVarArgs);
      }
      if (this.HTH != null)
      {
        paramVarArgs.lJ(5, this.HTH.computeSize());
        this.HTH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91706);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HCb) + 0 + f.a.a.b.b.a.bz(2, this.HTF);
      paramInt = i;
      if (this.FUn != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FUn);
      }
      i = paramInt;
      if (this.HTG != null) {
        i = paramInt + f.a.a.a.lI(4, this.HTG.computeSize());
      }
      paramInt = i;
      if (this.HTH != null) {
        paramInt = i + f.a.a.a.lI(5, this.HTH.computeSize());
      }
      AppMethodBeat.o(91706);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91706);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dmg localdmg = (dmg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91706);
        return -1;
      case 1: 
        localdmg.HCb = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91706);
        return 0;
      case 2: 
        localdmg.HTF = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91706);
        return 0;
      case 3: 
        localdmg.FUn = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91706);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new afc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((afc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdmg.HTG = ((afc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91706);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new afc();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((afc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdmg.HTH = ((afc)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91706);
      return 0;
    }
    AppMethodBeat.o(91706);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmg
 * JD-Core Version:    0.7.0.1
 */