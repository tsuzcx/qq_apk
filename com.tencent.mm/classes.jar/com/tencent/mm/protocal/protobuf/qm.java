package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class qm
  extends com.tencent.mm.bw.a
{
  public String KSj;
  public int KUx;
  public int KUy;
  public int KXq;
  public String KXr;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124464);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KUx);
      paramVarArgs.aM(2, this.KUy);
      paramVarArgs.aM(3, this.KXq);
      if (this.Title != null) {
        paramVarArgs.e(4, this.Title);
      }
      if (this.KXr != null) {
        paramVarArgs.e(5, this.KXr);
      }
      if (this.KSj != null) {
        paramVarArgs.e(6, this.KSj);
      }
      AppMethodBeat.o(124464);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.KUx) + 0 + g.a.a.b.b.a.bu(2, this.KUy) + g.a.a.b.b.a.bu(3, this.KXq);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Title);
      }
      i = paramInt;
      if (this.KXr != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KXr);
      }
      paramInt = i;
      if (this.KSj != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KSj);
      }
      AppMethodBeat.o(124464);
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
      AppMethodBeat.o(124464);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      qm localqm = (qm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124464);
        return -1;
      case 1: 
        localqm.KUx = locala.UbS.zi();
        AppMethodBeat.o(124464);
        return 0;
      case 2: 
        localqm.KUy = locala.UbS.zi();
        AppMethodBeat.o(124464);
        return 0;
      case 3: 
        localqm.KXq = locala.UbS.zi();
        AppMethodBeat.o(124464);
        return 0;
      case 4: 
        localqm.Title = locala.UbS.readString();
        AppMethodBeat.o(124464);
        return 0;
      case 5: 
        localqm.KXr = locala.UbS.readString();
        AppMethodBeat.o(124464);
        return 0;
      }
      localqm.KSj = locala.UbS.readString();
      AppMethodBeat.o(124464);
      return 0;
    }
    AppMethodBeat.o(124464);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qm
 * JD-Core Version:    0.7.0.1
 */