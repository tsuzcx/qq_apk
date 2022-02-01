package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ado
  extends com.tencent.mm.bx.a
{
  public int Def;
  public int Deg;
  public String Deh;
  public String doh;
  public String odo;
  public int rXs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(179487);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Def);
      paramVarArgs.aR(2, this.Deg);
      paramVarArgs.aR(3, this.rXs);
      if (this.doh != null) {
        paramVarArgs.d(4, this.doh);
      }
      if (this.odo != null) {
        paramVarArgs.d(5, this.odo);
      }
      if (this.Deh != null) {
        paramVarArgs.d(6, this.Deh);
      }
      AppMethodBeat.o(179487);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Def) + 0 + f.a.a.b.b.a.bA(2, this.Deg) + f.a.a.b.b.a.bA(3, this.rXs);
      paramInt = i;
      if (this.doh != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.doh);
      }
      i = paramInt;
      if (this.odo != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.odo);
      }
      paramInt = i;
      if (this.Deh != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Deh);
      }
      AppMethodBeat.o(179487);
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
      AppMethodBeat.o(179487);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ado localado = (ado)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(179487);
        return -1;
      case 1: 
        localado.Def = locala.KhF.xS();
        AppMethodBeat.o(179487);
        return 0;
      case 2: 
        localado.Deg = locala.KhF.xS();
        AppMethodBeat.o(179487);
        return 0;
      case 3: 
        localado.rXs = locala.KhF.xS();
        AppMethodBeat.o(179487);
        return 0;
      case 4: 
        localado.doh = locala.KhF.readString();
        AppMethodBeat.o(179487);
        return 0;
      case 5: 
        localado.odo = locala.KhF.readString();
        AppMethodBeat.o(179487);
        return 0;
      }
      localado.Deh = locala.KhF.readString();
      AppMethodBeat.o(179487);
      return 0;
    }
    AppMethodBeat.o(179487);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ado
 * JD-Core Version:    0.7.0.1
 */