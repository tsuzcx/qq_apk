package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsz
  extends com.tencent.mm.bw.a
{
  public boolean FhY;
  public boolean FhZ;
  public int Fia;
  public String Fib;
  public boolean Fic;
  public boolean Fid;
  public String Fie;
  public String djj;
  public int rNU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127172);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bl(1, this.FhY);
      paramVarArgs.bl(2, this.FhZ);
      paramVarArgs.aR(3, this.rNU);
      paramVarArgs.aR(4, this.Fia);
      if (this.Fib != null) {
        paramVarArgs.d(5, this.Fib);
      }
      paramVarArgs.bl(6, this.Fic);
      if (this.djj != null) {
        paramVarArgs.d(7, this.djj);
      }
      paramVarArgs.bl(8, this.Fid);
      if (this.Fie != null) {
        paramVarArgs.d(9, this.Fie);
      }
      AppMethodBeat.o(127172);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fK(1) + 1 + 0 + (f.a.a.b.b.a.fK(2) + 1) + f.a.a.b.b.a.bx(3, this.rNU) + f.a.a.b.b.a.bx(4, this.Fia);
      paramInt = i;
      if (this.Fib != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Fib);
      }
      i = paramInt + (f.a.a.b.b.a.fK(6) + 1);
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.djj);
      }
      i = paramInt + (f.a.a.b.b.a.fK(8) + 1);
      paramInt = i;
      if (this.Fie != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Fie);
      }
      AppMethodBeat.o(127172);
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
      AppMethodBeat.o(127172);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bsz localbsz = (bsz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127172);
        return -1;
      case 1: 
        localbsz.FhY = locala.LVo.fZX();
        AppMethodBeat.o(127172);
        return 0;
      case 2: 
        localbsz.FhZ = locala.LVo.fZX();
        AppMethodBeat.o(127172);
        return 0;
      case 3: 
        localbsz.rNU = locala.LVo.xF();
        AppMethodBeat.o(127172);
        return 0;
      case 4: 
        localbsz.Fia = locala.LVo.xF();
        AppMethodBeat.o(127172);
        return 0;
      case 5: 
        localbsz.Fib = locala.LVo.readString();
        AppMethodBeat.o(127172);
        return 0;
      case 6: 
        localbsz.Fic = locala.LVo.fZX();
        AppMethodBeat.o(127172);
        return 0;
      case 7: 
        localbsz.djj = locala.LVo.readString();
        AppMethodBeat.o(127172);
        return 0;
      case 8: 
        localbsz.Fid = locala.LVo.fZX();
        AppMethodBeat.o(127172);
        return 0;
      }
      localbsz.Fie = locala.LVo.readString();
      AppMethodBeat.o(127172);
      return 0;
    }
    AppMethodBeat.o(127172);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsz
 * JD-Core Version:    0.7.0.1
 */