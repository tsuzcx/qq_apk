package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bnm
  extends com.tencent.mm.bw.a
{
  public String Fdk;
  public String Fdl;
  public String Fdm;
  public String Fdn;
  public String lze;
  public int vjP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(108147);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.vjP);
      if (this.lze != null) {
        paramVarArgs.d(2, this.lze);
      }
      if (this.Fdk != null) {
        paramVarArgs.d(3, this.Fdk);
      }
      if (this.Fdl != null) {
        paramVarArgs.d(4, this.Fdl);
      }
      if (this.Fdm != null) {
        paramVarArgs.d(5, this.Fdm);
      }
      if (this.Fdn != null) {
        paramVarArgs.d(6, this.Fdn);
      }
      AppMethodBeat.o(108147);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.vjP) + 0;
      paramInt = i;
      if (this.lze != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.lze);
      }
      i = paramInt;
      if (this.Fdk != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fdk);
      }
      paramInt = i;
      if (this.Fdl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fdl);
      }
      i = paramInt;
      if (this.Fdm != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Fdm);
      }
      paramInt = i;
      if (this.Fdn != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fdn);
      }
      AppMethodBeat.o(108147);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(108147);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bnm localbnm = (bnm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(108147);
        return -1;
      case 1: 
        localbnm.vjP = locala.LVo.xF();
        AppMethodBeat.o(108147);
        return 0;
      case 2: 
        localbnm.lze = locala.LVo.readString();
        AppMethodBeat.o(108147);
        return 0;
      case 3: 
        localbnm.Fdk = locala.LVo.readString();
        AppMethodBeat.o(108147);
        return 0;
      case 4: 
        localbnm.Fdl = locala.LVo.readString();
        AppMethodBeat.o(108147);
        return 0;
      case 5: 
        localbnm.Fdm = locala.LVo.readString();
        AppMethodBeat.o(108147);
        return 0;
      }
      localbnm.Fdn = locala.LVo.readString();
      AppMethodBeat.o(108147);
      return 0;
    }
    AppMethodBeat.o(108147);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnm
 * JD-Core Version:    0.7.0.1
 */