package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class egc
  extends com.tencent.mm.bw.a
{
  public String KSV;
  public LinkedList<String> KUB;
  public int KUh;
  public long KWz;
  public String Luh;
  public String NfW;
  
  public egc()
  {
    AppMethodBeat.i(124560);
    this.KUB = new LinkedList();
    AppMethodBeat.o(124560);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124561);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.KWz);
      if (this.KSV != null) {
        paramVarArgs.e(2, this.KSV);
      }
      paramVarArgs.e(3, 1, this.KUB);
      if (this.Luh != null) {
        paramVarArgs.e(4, this.Luh);
      }
      if (this.NfW != null) {
        paramVarArgs.e(5, this.NfW);
      }
      paramVarArgs.aM(6, this.KUh);
      AppMethodBeat.o(124561);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.KWz) + 0;
      paramInt = i;
      if (this.KSV != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KSV);
      }
      i = paramInt + g.a.a.a.c(3, 1, this.KUB);
      paramInt = i;
      if (this.Luh != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Luh);
      }
      i = paramInt;
      if (this.NfW != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.NfW);
      }
      paramInt = g.a.a.b.b.a.bu(6, this.KUh);
      AppMethodBeat.o(124561);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KUB.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(124561);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      egc localegc = (egc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124561);
        return -1;
      case 1: 
        localegc.KWz = locala.UbS.zl();
        AppMethodBeat.o(124561);
        return 0;
      case 2: 
        localegc.KSV = locala.UbS.readString();
        AppMethodBeat.o(124561);
        return 0;
      case 3: 
        localegc.KUB.add(locala.UbS.readString());
        AppMethodBeat.o(124561);
        return 0;
      case 4: 
        localegc.Luh = locala.UbS.readString();
        AppMethodBeat.o(124561);
        return 0;
      case 5: 
        localegc.NfW = locala.UbS.readString();
        AppMethodBeat.o(124561);
        return 0;
      }
      localegc.KUh = locala.UbS.zi();
      AppMethodBeat.o(124561);
      return 0;
    }
    AppMethodBeat.o(124561);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egc
 * JD-Core Version:    0.7.0.1
 */