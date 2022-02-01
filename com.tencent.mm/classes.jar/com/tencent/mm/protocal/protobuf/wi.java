package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class wi
  extends com.tencent.mm.bx.a
{
  public int CYj;
  public int CYk;
  public int CYl;
  public LinkedList<wh> CYm;
  public b CYn;
  public bfx CYo;
  
  public wi()
  {
    AppMethodBeat.i(143967);
    this.CYm = new LinkedList();
    AppMethodBeat.o(143967);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143968);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CYj);
      paramVarArgs.aR(2, this.CYk);
      paramVarArgs.aR(3, this.CYl);
      paramVarArgs.e(4, 8, this.CYm);
      if (this.CYn != null) {
        paramVarArgs.c(5, this.CYn);
      }
      if (this.CYo != null)
      {
        paramVarArgs.kX(6, this.CYo.computeSize());
        this.CYo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143968);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.CYj) + 0 + f.a.a.b.b.a.bA(2, this.CYk) + f.a.a.b.b.a.bA(3, this.CYl) + f.a.a.a.c(4, 8, this.CYm);
      paramInt = i;
      if (this.CYn != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.CYn);
      }
      i = paramInt;
      if (this.CYo != null) {
        i = paramInt + f.a.a.a.kW(6, this.CYo.computeSize());
      }
      AppMethodBeat.o(143968);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CYm.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(143968);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      wi localwi = (wi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143968);
        return -1;
      case 1: 
        localwi.CYj = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143968);
        return 0;
      case 2: 
        localwi.CYk = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143968);
        return 0;
      case 3: 
        localwi.CYl = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143968);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new wh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((wh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localwi.CYm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143968);
        return 0;
      case 5: 
        localwi.CYn = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(143968);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bfx();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bfx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localwi.CYo = ((bfx)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143968);
      return 0;
    }
    AppMethodBeat.o(143968);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wi
 * JD-Core Version:    0.7.0.1
 */