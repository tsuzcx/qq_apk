package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ase
  extends com.tencent.mm.bx.a
{
  public int CYj;
  public int CYk;
  public int CYl;
  public b CYn;
  public bfx CYo;
  public int Dsu;
  public int Dsv;
  public int Dsw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143973);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CYj);
      paramVarArgs.aR(2, this.CYk);
      paramVarArgs.aR(3, this.CYl);
      if (this.CYn != null) {
        paramVarArgs.c(4, this.CYn);
      }
      paramVarArgs.aR(5, this.Dsu);
      paramVarArgs.aR(6, this.Dsv);
      paramVarArgs.aR(7, this.Dsw);
      if (this.CYo != null)
      {
        paramVarArgs.kX(8, this.CYo.computeSize());
        this.CYo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143973);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.CYj) + 0 + f.a.a.b.b.a.bA(2, this.CYk) + f.a.a.b.b.a.bA(3, this.CYl);
      paramInt = i;
      if (this.CYn != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.CYn);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.Dsu) + f.a.a.b.b.a.bA(6, this.Dsv) + f.a.a.b.b.a.bA(7, this.Dsw);
      paramInt = i;
      if (this.CYo != null) {
        paramInt = i + f.a.a.a.kW(8, this.CYo.computeSize());
      }
      AppMethodBeat.o(143973);
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
      AppMethodBeat.o(143973);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ase localase = (ase)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143973);
        return -1;
      case 1: 
        localase.CYj = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143973);
        return 0;
      case 2: 
        localase.CYk = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143973);
        return 0;
      case 3: 
        localase.CYl = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143973);
        return 0;
      case 4: 
        localase.CYn = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(143973);
        return 0;
      case 5: 
        localase.Dsu = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143973);
        return 0;
      case 6: 
        localase.Dsv = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143973);
        return 0;
      case 7: 
        localase.Dsw = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143973);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bfx();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bfx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localase.CYo = ((bfx)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143973);
      return 0;
    }
    AppMethodBeat.o(143973);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ase
 * JD-Core Version:    0.7.0.1
 */