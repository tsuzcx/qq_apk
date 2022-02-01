package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class fq
  extends com.tencent.mm.bx.a
{
  public LinkedList<dyj> YCk;
  public int YHa;
  public LinkedList<dyi> hrh;
  
  public fq()
  {
    AppMethodBeat.i(152492);
    this.YCk = new LinkedList();
    this.hrh = new LinkedList();
    AppMethodBeat.o(152492);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152493);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YHa);
      paramVarArgs.e(2, 8, this.YCk);
      paramVarArgs.e(3, 8, this.hrh);
      AppMethodBeat.o(152493);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.YHa);
      i = i.a.a.a.c(2, 8, this.YCk);
      int j = i.a.a.a.c(3, 8, this.hrh);
      AppMethodBeat.o(152493);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YCk.clear();
      this.hrh.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(152493);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      fq localfq = (fq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152493);
        return -1;
      case 1: 
        localfq.YHa = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(152493);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dyj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dyj)localObject2).parseFrom((byte[])localObject1);
          }
          localfq.YCk.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152493);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new dyi();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((dyi)localObject2).parseFrom((byte[])localObject1);
        }
        localfq.hrh.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(152493);
      return 0;
    }
    AppMethodBeat.o(152493);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fq
 * JD-Core Version:    0.7.0.1
 */