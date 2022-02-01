package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bg
  extends com.tencent.mm.bx.a
{
  public boolean FsU = false;
  public boolean FsV = false;
  public boolean FsW = false;
  public boolean FsX = false;
  public String FsY = "";
  public String FsZ = "";
  public String Fta = "";
  public String Ftb = "";
  public int Ftc = -1;
  public String qZg = "";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122480);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bt(1, this.FsU);
      paramVarArgs.bt(2, this.FsV);
      paramVarArgs.bt(3, this.FsW);
      paramVarArgs.bt(4, this.FsX);
      if (this.FsY != null) {
        paramVarArgs.d(5, this.FsY);
      }
      if (this.FsZ != null) {
        paramVarArgs.d(6, this.FsZ);
      }
      if (this.Fta != null) {
        paramVarArgs.d(7, this.Fta);
      }
      if (this.Ftb != null) {
        paramVarArgs.d(8, this.Ftb);
      }
      paramVarArgs.aS(9, this.Ftc);
      if (this.qZg != null) {
        paramVarArgs.d(10, this.qZg);
      }
      AppMethodBeat.o(122480);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.alV(1) + 0 + f.a.a.b.b.a.alV(2) + f.a.a.b.b.a.alV(3) + f.a.a.b.b.a.alV(4);
      paramInt = i;
      if (this.FsY != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FsY);
      }
      i = paramInt;
      if (this.FsZ != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FsZ);
      }
      paramInt = i;
      if (this.Fta != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Fta);
      }
      i = paramInt;
      if (this.Ftb != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Ftb);
      }
      i += f.a.a.b.b.a.bz(9, this.Ftc);
      paramInt = i;
      if (this.qZg != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.qZg);
      }
      AppMethodBeat.o(122480);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(122480);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bg localbg = (bg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122480);
        return -1;
      case 1: 
        localbg.FsU = locala.NPN.grw();
        AppMethodBeat.o(122480);
        return 0;
      case 2: 
        localbg.FsV = locala.NPN.grw();
        AppMethodBeat.o(122480);
        return 0;
      case 3: 
        localbg.FsW = locala.NPN.grw();
        AppMethodBeat.o(122480);
        return 0;
      case 4: 
        localbg.FsX = locala.NPN.grw();
        AppMethodBeat.o(122480);
        return 0;
      case 5: 
        localbg.FsY = locala.NPN.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 6: 
        localbg.FsZ = locala.NPN.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 7: 
        localbg.Fta = locala.NPN.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 8: 
        localbg.Ftb = locala.NPN.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 9: 
        localbg.Ftc = locala.NPN.zc();
        AppMethodBeat.o(122480);
        return 0;
      }
      localbg.qZg = locala.NPN.readString();
      AppMethodBeat.o(122480);
      return 0;
    }
    AppMethodBeat.o(122480);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bg
 * JD-Core Version:    0.7.0.1
 */