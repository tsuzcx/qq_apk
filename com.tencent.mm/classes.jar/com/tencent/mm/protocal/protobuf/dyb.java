package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dyb
  extends com.tencent.mm.bx.a
{
  public int Lxf;
  public String Lxg;
  public String Lxh;
  public boolean enable;
  public String jBp;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203821);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bg(1, this.enable);
      paramVarArgs.aR(2, this.Lxf);
      if (this.jBp != null) {
        paramVarArgs.d(3, this.jBp);
      }
      if (this.Lxg != null) {
        paramVarArgs.d(4, this.Lxg);
      }
      if (this.Lxh != null) {
        paramVarArgs.d(5, this.Lxh);
      }
      if (this.title != null) {
        paramVarArgs.d(6, this.title);
      }
      AppMethodBeat.o(203821);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fY(1) + 1 + 0 + f.a.a.b.b.a.bA(2, this.Lxf);
      paramInt = i;
      if (this.jBp != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.jBp);
      }
      i = paramInt;
      if (this.Lxg != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Lxg);
      }
      paramInt = i;
      if (this.Lxh != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Lxh);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.title);
      }
      AppMethodBeat.o(203821);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(203821);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dyb localdyb = (dyb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(203821);
        return -1;
      case 1: 
        localdyb.enable = locala.KhF.fHu();
        AppMethodBeat.o(203821);
        return 0;
      case 2: 
        localdyb.Lxf = locala.KhF.xS();
        AppMethodBeat.o(203821);
        return 0;
      case 3: 
        localdyb.jBp = locala.KhF.readString();
        AppMethodBeat.o(203821);
        return 0;
      case 4: 
        localdyb.Lxg = locala.KhF.readString();
        AppMethodBeat.o(203821);
        return 0;
      case 5: 
        localdyb.Lxh = locala.KhF.readString();
        AppMethodBeat.o(203821);
        return 0;
      }
      localdyb.title = locala.KhF.readString();
      AppMethodBeat.o(203821);
      return 0;
    }
    AppMethodBeat.o(203821);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyb
 * JD-Core Version:    0.7.0.1
 */