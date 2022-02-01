package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bg
  extends com.tencent.mm.bw.a
{
  public int FLA = -1;
  public boolean FLs = false;
  public boolean FLt = false;
  public boolean FLu = false;
  public boolean FLv = false;
  public String FLw = "";
  public String FLx = "";
  public String FLy = "";
  public String FLz = "";
  public String rhm = "";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122480);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bC(1, this.FLs);
      paramVarArgs.bC(2, this.FLt);
      paramVarArgs.bC(3, this.FLu);
      paramVarArgs.bC(4, this.FLv);
      if (this.FLw != null) {
        paramVarArgs.d(5, this.FLw);
      }
      if (this.FLx != null) {
        paramVarArgs.d(6, this.FLx);
      }
      if (this.FLy != null) {
        paramVarArgs.d(7, this.FLy);
      }
      if (this.FLz != null) {
        paramVarArgs.d(8, this.FLz);
      }
      paramVarArgs.aS(9, this.FLA);
      if (this.rhm != null) {
        paramVarArgs.d(10, this.rhm);
      }
      AppMethodBeat.o(122480);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.amF(1) + 0 + f.a.a.b.b.a.amF(2) + f.a.a.b.b.a.amF(3) + f.a.a.b.b.a.amF(4);
      paramInt = i;
      if (this.FLw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FLw);
      }
      i = paramInt;
      if (this.FLx != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FLx);
      }
      paramInt = i;
      if (this.FLy != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FLy);
      }
      i = paramInt;
      if (this.FLz != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FLz);
      }
      i += f.a.a.b.b.a.bz(9, this.FLA);
      paramInt = i;
      if (this.rhm != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.rhm);
      }
      AppMethodBeat.o(122480);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
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
        localbg.FLs = locala.OmT.gvY();
        AppMethodBeat.o(122480);
        return 0;
      case 2: 
        localbg.FLt = locala.OmT.gvY();
        AppMethodBeat.o(122480);
        return 0;
      case 3: 
        localbg.FLu = locala.OmT.gvY();
        AppMethodBeat.o(122480);
        return 0;
      case 4: 
        localbg.FLv = locala.OmT.gvY();
        AppMethodBeat.o(122480);
        return 0;
      case 5: 
        localbg.FLw = locala.OmT.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 6: 
        localbg.FLx = locala.OmT.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 7: 
        localbg.FLy = locala.OmT.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 8: 
        localbg.FLz = locala.OmT.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 9: 
        localbg.FLA = locala.OmT.zc();
        AppMethodBeat.o(122480);
        return 0;
      }
      localbg.rhm = locala.OmT.readString();
      AppMethodBeat.o(122480);
      return 0;
    }
    AppMethodBeat.o(122480);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bg
 * JD-Core Version:    0.7.0.1
 */