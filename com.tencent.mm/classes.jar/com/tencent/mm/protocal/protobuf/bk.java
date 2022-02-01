package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bk
  extends com.tencent.mm.bw.a
{
  public boolean KES = false;
  public boolean KET = false;
  public boolean KEU = false;
  public boolean KEV = false;
  public String KEW = "";
  public String KEX = "";
  public String KEZ = "";
  public String KFa = "";
  public int KFb = -1;
  public String sII = "";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122480);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.cc(1, this.KES);
      paramVarArgs.cc(2, this.KET);
      paramVarArgs.cc(3, this.KEU);
      paramVarArgs.cc(4, this.KEV);
      if (this.KEW != null) {
        paramVarArgs.e(5, this.KEW);
      }
      if (this.KEX != null) {
        paramVarArgs.e(6, this.KEX);
      }
      if (this.KEZ != null) {
        paramVarArgs.e(7, this.KEZ);
      }
      if (this.KFa != null) {
        paramVarArgs.e(8, this.KFa);
      }
      paramVarArgs.aM(9, this.KFb);
      if (this.sII != null) {
        paramVarArgs.e(10, this.sII);
      }
      AppMethodBeat.o(122480);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.fS(1) + 1 + 0 + (g.a.a.b.b.a.fS(2) + 1) + (g.a.a.b.b.a.fS(3) + 1) + (g.a.a.b.b.a.fS(4) + 1);
      paramInt = i;
      if (this.KEW != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KEW);
      }
      i = paramInt;
      if (this.KEX != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.KEX);
      }
      paramInt = i;
      if (this.KEZ != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.KEZ);
      }
      i = paramInt;
      if (this.KFa != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.KFa);
      }
      i += g.a.a.b.b.a.bu(9, this.KFb);
      paramInt = i;
      if (this.sII != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.sII);
      }
      AppMethodBeat.o(122480);
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
      AppMethodBeat.o(122480);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bk localbk = (bk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122480);
        return -1;
      case 1: 
        localbk.KES = locala.UbS.yZ();
        AppMethodBeat.o(122480);
        return 0;
      case 2: 
        localbk.KET = locala.UbS.yZ();
        AppMethodBeat.o(122480);
        return 0;
      case 3: 
        localbk.KEU = locala.UbS.yZ();
        AppMethodBeat.o(122480);
        return 0;
      case 4: 
        localbk.KEV = locala.UbS.yZ();
        AppMethodBeat.o(122480);
        return 0;
      case 5: 
        localbk.KEW = locala.UbS.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 6: 
        localbk.KEX = locala.UbS.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 7: 
        localbk.KEZ = locala.UbS.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 8: 
        localbk.KFa = locala.UbS.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 9: 
        localbk.KFb = locala.UbS.zi();
        AppMethodBeat.o(122480);
        return 0;
      }
      localbk.sII = locala.UbS.readString();
      AppMethodBeat.o(122480);
      return 0;
    }
    AppMethodBeat.o(122480);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bk
 * JD-Core Version:    0.7.0.1
 */