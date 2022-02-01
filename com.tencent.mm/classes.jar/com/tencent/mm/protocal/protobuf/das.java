package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class das
  extends com.tencent.mm.bx.a
{
  public String CIt;
  public int Dxp;
  public String Esp;
  public long Esq;
  public LinkedList<String> Esw;
  public String Esx;
  
  public das()
  {
    AppMethodBeat.i(124560);
    this.Esw = new LinkedList();
    AppMethodBeat.o(124560);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124561);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.Esq);
      if (this.CIt != null) {
        paramVarArgs.d(2, this.CIt);
      }
      paramVarArgs.e(3, 1, this.Esw);
      if (this.Esp != null) {
        paramVarArgs.d(4, this.Esp);
      }
      if (this.Esx != null) {
        paramVarArgs.d(5, this.Esx);
      }
      paramVarArgs.aR(6, this.Dxp);
      AppMethodBeat.o(124561);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.q(1, this.Esq) + 0;
      paramInt = i;
      if (this.CIt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CIt);
      }
      i = paramInt + f.a.a.a.c(3, 1, this.Esw);
      paramInt = i;
      if (this.Esp != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Esp);
      }
      i = paramInt;
      if (this.Esx != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Esx);
      }
      paramInt = f.a.a.b.b.a.bA(6, this.Dxp);
      AppMethodBeat.o(124561);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Esw.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(124561);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      das localdas = (das)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124561);
        return -1;
      case 1: 
        localdas.Esq = locala.KhF.xT();
        AppMethodBeat.o(124561);
        return 0;
      case 2: 
        localdas.CIt = locala.KhF.readString();
        AppMethodBeat.o(124561);
        return 0;
      case 3: 
        localdas.Esw.add(locala.KhF.readString());
        AppMethodBeat.o(124561);
        return 0;
      case 4: 
        localdas.Esp = locala.KhF.readString();
        AppMethodBeat.o(124561);
        return 0;
      case 5: 
        localdas.Esx = locala.KhF.readString();
        AppMethodBeat.o(124561);
        return 0;
      }
      localdas.Dxp = locala.KhF.xS();
      AppMethodBeat.o(124561);
      return 0;
    }
    AppMethodBeat.o(124561);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.das
 * JD-Core Version:    0.7.0.1
 */