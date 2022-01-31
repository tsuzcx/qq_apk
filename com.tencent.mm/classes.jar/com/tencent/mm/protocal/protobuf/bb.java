package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bb
  extends com.tencent.mm.bv.a
{
  public String mba = "";
  public boolean wnd = false;
  public boolean wne = false;
  public boolean wnf = false;
  public boolean wng = false;
  public String wnh = "";
  public String wni = "";
  public String wnj = "";
  public String wnk = "";
  public int wnl = -1;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73642);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.wnd);
      paramVarArgs.aS(2, this.wne);
      paramVarArgs.aS(3, this.wnf);
      paramVarArgs.aS(4, this.wng);
      if (this.wnh != null) {
        paramVarArgs.e(5, this.wnh);
      }
      if (this.wni != null) {
        paramVarArgs.e(6, this.wni);
      }
      if (this.wnj != null) {
        paramVarArgs.e(7, this.wnj);
      }
      if (this.wnk != null) {
        paramVarArgs.e(8, this.wnk);
      }
      paramVarArgs.aO(9, this.wnl);
      if (this.mba != null) {
        paramVarArgs.e(10, this.mba);
      }
      AppMethodBeat.o(73642);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.eW(1) + 1 + 0 + (e.a.a.b.b.a.eW(2) + 1) + (e.a.a.b.b.a.eW(3) + 1) + (e.a.a.b.b.a.eW(4) + 1);
      paramInt = i;
      if (this.wnh != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wnh);
      }
      i = paramInt;
      if (this.wni != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.wni);
      }
      paramInt = i;
      if (this.wnj != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wnj);
      }
      i = paramInt;
      if (this.wnk != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.wnk);
      }
      i += e.a.a.b.b.a.bl(9, this.wnl);
      paramInt = i;
      if (this.mba != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.mba);
      }
      AppMethodBeat.o(73642);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(73642);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bb localbb = (bb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(73642);
        return -1;
      case 1: 
        localbb.wnd = locala.CLY.emu();
        AppMethodBeat.o(73642);
        return 0;
      case 2: 
        localbb.wne = locala.CLY.emu();
        AppMethodBeat.o(73642);
        return 0;
      case 3: 
        localbb.wnf = locala.CLY.emu();
        AppMethodBeat.o(73642);
        return 0;
      case 4: 
        localbb.wng = locala.CLY.emu();
        AppMethodBeat.o(73642);
        return 0;
      case 5: 
        localbb.wnh = locala.CLY.readString();
        AppMethodBeat.o(73642);
        return 0;
      case 6: 
        localbb.wni = locala.CLY.readString();
        AppMethodBeat.o(73642);
        return 0;
      case 7: 
        localbb.wnj = locala.CLY.readString();
        AppMethodBeat.o(73642);
        return 0;
      case 8: 
        localbb.wnk = locala.CLY.readString();
        AppMethodBeat.o(73642);
        return 0;
      case 9: 
        localbb.wnl = locala.CLY.sl();
        AppMethodBeat.o(73642);
        return 0;
      }
      localbb.mba = locala.CLY.readString();
      AppMethodBeat.o(73642);
      return 0;
    }
    AppMethodBeat.o(73642);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bb
 * JD-Core Version:    0.7.0.1
 */