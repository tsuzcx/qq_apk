package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbg
  extends com.tencent.mm.bx.a
{
  public dew DXy;
  public int DuF;
  public String DuG;
  public String DuH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32369);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DuF);
      if (this.DuG != null) {
        paramVarArgs.d(2, this.DuG);
      }
      if (this.DuH != null) {
        paramVarArgs.d(3, this.DuH);
      }
      if (this.DXy != null)
      {
        paramVarArgs.kX(4, this.DXy.computeSize());
        this.DXy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32369);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.DuF) + 0;
      paramInt = i;
      if (this.DuG != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DuG);
      }
      i = paramInt;
      if (this.DuH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DuH);
      }
      paramInt = i;
      if (this.DXy != null) {
        paramInt = i + f.a.a.a.kW(4, this.DXy.computeSize());
      }
      AppMethodBeat.o(32369);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(32369);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cbg localcbg = (cbg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32369);
        return -1;
      case 1: 
        localcbg.DuF = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32369);
        return 0;
      case 2: 
        localcbg.DuG = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32369);
        return 0;
      case 3: 
        localcbg.DuH = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32369);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dew();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dew)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcbg.DXy = ((dew)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32369);
      return 0;
    }
    AppMethodBeat.o(32369);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbg
 * JD-Core Version:    0.7.0.1
 */