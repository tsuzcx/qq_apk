package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zg
  extends com.tencent.mm.bx.a
{
  public int YGJ;
  public LinkedList<zi> YGK;
  public LinkedList<zh> ZhK;
  public int ZhL;
  public etl ZhM;
  public int lyF;
  
  public zg()
  {
    AppMethodBeat.i(43085);
    this.ZhK = new LinkedList();
    this.YGK = new LinkedList();
    AppMethodBeat.o(43085);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43086);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.lyF);
      paramVarArgs.e(2, 8, this.ZhK);
      paramVarArgs.bS(3, this.ZhL);
      if (this.ZhM != null)
      {
        paramVarArgs.qD(4, this.ZhM.computeSize());
        this.ZhM.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.YGJ);
      paramVarArgs.e(6, 8, this.YGK);
      AppMethodBeat.o(43086);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.lyF) + 0 + i.a.a.a.c(2, 8, this.ZhK) + i.a.a.b.b.a.cJ(3, this.ZhL);
      paramInt = i;
      if (this.ZhM != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZhM.computeSize());
      }
      i = i.a.a.b.b.a.cJ(5, this.YGJ);
      int j = i.a.a.a.c(6, 8, this.YGK);
      AppMethodBeat.o(43086);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZhK.clear();
      this.YGK.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(43086);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      zg localzg = (zg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43086);
        return -1;
      case 1: 
        localzg.lyF = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(43086);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new zh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((zh)localObject2).parseFrom((byte[])localObject1);
          }
          localzg.ZhK.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(43086);
        return 0;
      case 3: 
        localzg.ZhL = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(43086);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etl)localObject2).dh((byte[])localObject1);
          }
          localzg.ZhM = ((etl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(43086);
        return 0;
      case 5: 
        localzg.YGJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(43086);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new zi();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((zi)localObject2).parseFrom((byte[])localObject1);
        }
        localzg.YGK.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(43086);
      return 0;
    }
    AppMethodBeat.o(43086);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zg
 * JD-Core Version:    0.7.0.1
 */