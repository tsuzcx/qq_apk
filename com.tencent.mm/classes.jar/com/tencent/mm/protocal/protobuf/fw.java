package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fw
  extends com.tencent.mm.bv.a
{
  public String cwl;
  public String cwm;
  public int utd;
  public boolean wsh;
  public String wsi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145224);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.wsh);
      paramVarArgs.aO(2, this.utd);
      if (this.cwl != null) {
        paramVarArgs.e(3, this.cwl);
      }
      if (this.cwm != null) {
        paramVarArgs.e(4, this.cwm);
      }
      if (this.wsi != null) {
        paramVarArgs.e(5, this.wsi);
      }
      AppMethodBeat.o(145224);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.eW(1) + 1 + 0 + e.a.a.b.b.a.bl(2, this.utd);
      paramInt = i;
      if (this.cwl != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.cwl);
      }
      i = paramInt;
      if (this.cwm != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.cwm);
      }
      paramInt = i;
      if (this.wsi != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wsi);
      }
      AppMethodBeat.o(145224);
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
      AppMethodBeat.o(145224);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      fw localfw = (fw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(145224);
        return -1;
      case 1: 
        localfw.wsh = locala.CLY.emu();
        AppMethodBeat.o(145224);
        return 0;
      case 2: 
        localfw.utd = locala.CLY.sl();
        AppMethodBeat.o(145224);
        return 0;
      case 3: 
        localfw.cwl = locala.CLY.readString();
        AppMethodBeat.o(145224);
        return 0;
      case 4: 
        localfw.cwm = locala.CLY.readString();
        AppMethodBeat.o(145224);
        return 0;
      }
      localfw.wsi = locala.CLY.readString();
      AppMethodBeat.o(145224);
      return 0;
    }
    AppMethodBeat.o(145224);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fw
 * JD-Core Version:    0.7.0.1
 */