package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yj
  extends com.tencent.mm.bv.a
{
  public int wPA;
  public int wPB;
  public int wPC;
  public int wPw;
  public yh wPx;
  public yh wPy;
  public int wPz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145887);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wPw);
      if (this.wPx != null)
      {
        paramVarArgs.iQ(2, this.wPx.computeSize());
        this.wPx.writeFields(paramVarArgs);
      }
      if (this.wPy != null)
      {
        paramVarArgs.iQ(3, this.wPy.computeSize());
        this.wPy.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.wPz);
      paramVarArgs.aO(5, this.wPA);
      paramVarArgs.aO(6, this.wPB);
      paramVarArgs.aO(7, this.wPC);
      AppMethodBeat.o(145887);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.wPw) + 0;
      paramInt = i;
      if (this.wPx != null) {
        paramInt = i + e.a.a.a.iP(2, this.wPx.computeSize());
      }
      i = paramInt;
      if (this.wPy != null) {
        i = paramInt + e.a.a.a.iP(3, this.wPy.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(4, this.wPz);
      int j = e.a.a.b.b.a.bl(5, this.wPA);
      int k = e.a.a.b.b.a.bl(6, this.wPB);
      int m = e.a.a.b.b.a.bl(7, this.wPC);
      AppMethodBeat.o(145887);
      return i + paramInt + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(145887);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      yj localyj = (yj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(145887);
        return -1;
      case 1: 
        localyj.wPw = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(145887);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yh();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localyj.wPx = ((yh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(145887);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yh();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localyj.wPy = ((yh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(145887);
        return 0;
      case 4: 
        localyj.wPz = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(145887);
        return 0;
      case 5: 
        localyj.wPA = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(145887);
        return 0;
      case 6: 
        localyj.wPB = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(145887);
        return 0;
      }
      localyj.wPC = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(145887);
      return 0;
    }
    AppMethodBeat.o(145887);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yj
 * JD-Core Version:    0.7.0.1
 */