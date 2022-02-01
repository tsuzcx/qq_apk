package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akl
  extends com.tencent.mm.bw.a
{
  public int Ltq;
  public int Ltr;
  public int Lts;
  public String Ltt;
  public int Ltu;
  public String Ltv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122488);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Ltq);
      paramVarArgs.aM(2, this.Ltr);
      paramVarArgs.aM(3, this.Lts);
      if (this.Ltt != null) {
        paramVarArgs.e(4, this.Ltt);
      }
      paramVarArgs.aM(5, this.Ltu);
      if (this.Ltv != null) {
        paramVarArgs.e(6, this.Ltv);
      }
      AppMethodBeat.o(122488);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Ltq) + 0 + g.a.a.b.b.a.bu(2, this.Ltr) + g.a.a.b.b.a.bu(3, this.Lts);
      paramInt = i;
      if (this.Ltt != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Ltt);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.Ltu);
      paramInt = i;
      if (this.Ltv != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Ltv);
      }
      AppMethodBeat.o(122488);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(122488);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      akl localakl = (akl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122488);
        return -1;
      case 1: 
        localakl.Ltq = locala.UbS.zi();
        AppMethodBeat.o(122488);
        return 0;
      case 2: 
        localakl.Ltr = locala.UbS.zi();
        AppMethodBeat.o(122488);
        return 0;
      case 3: 
        localakl.Lts = locala.UbS.zi();
        AppMethodBeat.o(122488);
        return 0;
      case 4: 
        localakl.Ltt = locala.UbS.readString();
        AppMethodBeat.o(122488);
        return 0;
      case 5: 
        localakl.Ltu = locala.UbS.zi();
        AppMethodBeat.o(122488);
        return 0;
      }
      localakl.Ltv = locala.UbS.readString();
      AppMethodBeat.o(122488);
      return 0;
    }
    AppMethodBeat.o(122488);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akl
 * JD-Core Version:    0.7.0.1
 */