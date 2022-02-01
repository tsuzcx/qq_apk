package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aly
  extends com.tencent.mm.bx.a
{
  public int DkD;
  public int DkE;
  public int DmX;
  public akv DmY;
  public int LyK;
  public int LyL;
  public int count;
  public String gLg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169077);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.count);
      paramVarArgs.aR(2, this.DkD);
      paramVarArgs.aR(3, this.DkE);
      paramVarArgs.aR(4, this.DmX);
      if (this.gLg != null) {
        paramVarArgs.d(5, this.gLg);
      }
      if (this.DmY != null)
      {
        paramVarArgs.kX(6, this.DmY.computeSize());
        this.DmY.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.LyK);
      paramVarArgs.aR(8, this.LyL);
      AppMethodBeat.o(169077);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.count) + 0 + f.a.a.b.b.a.bA(2, this.DkD) + f.a.a.b.b.a.bA(3, this.DkE) + f.a.a.b.b.a.bA(4, this.DmX);
      paramInt = i;
      if (this.gLg != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.gLg);
      }
      i = paramInt;
      if (this.DmY != null) {
        i = paramInt + f.a.a.a.kW(6, this.DmY.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(7, this.LyK);
      int j = f.a.a.b.b.a.bA(8, this.LyL);
      AppMethodBeat.o(169077);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(169077);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aly localaly = (aly)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169077);
        return -1;
      case 1: 
        localaly.count = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(169077);
        return 0;
      case 2: 
        localaly.DkD = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(169077);
        return 0;
      case 3: 
        localaly.DkE = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(169077);
        return 0;
      case 4: 
        localaly.DmX = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(169077);
        return 0;
      case 5: 
        localaly.gLg = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(169077);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new akv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((akv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaly.DmY = ((akv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169077);
        return 0;
      case 7: 
        localaly.LyK = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(169077);
        return 0;
      }
      localaly.LyL = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(169077);
      return 0;
    }
    AppMethodBeat.o(169077);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aly
 * JD-Core Version:    0.7.0.1
 */