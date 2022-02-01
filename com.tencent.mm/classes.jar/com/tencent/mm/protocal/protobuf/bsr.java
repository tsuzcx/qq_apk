package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsr
  extends com.tencent.mm.bw.a
{
  public String Hgn;
  public String Hgo;
  public String Hgp;
  public String Hgq;
  public String mdj;
  public int uIW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(108147);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.uIW);
      if (this.mdj != null) {
        paramVarArgs.d(2, this.mdj);
      }
      if (this.Hgn != null) {
        paramVarArgs.d(3, this.Hgn);
      }
      if (this.Hgo != null) {
        paramVarArgs.d(4, this.Hgo);
      }
      if (this.Hgp != null) {
        paramVarArgs.d(5, this.Hgp);
      }
      if (this.Hgq != null) {
        paramVarArgs.d(6, this.Hgq);
      }
      AppMethodBeat.o(108147);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.uIW) + 0;
      paramInt = i;
      if (this.mdj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mdj);
      }
      i = paramInt;
      if (this.Hgn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hgn);
      }
      paramInt = i;
      if (this.Hgo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hgo);
      }
      i = paramInt;
      if (this.Hgp != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Hgp);
      }
      paramInt = i;
      if (this.Hgq != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Hgq);
      }
      AppMethodBeat.o(108147);
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
      AppMethodBeat.o(108147);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bsr localbsr = (bsr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(108147);
        return -1;
      case 1: 
        localbsr.uIW = locala.OmT.zc();
        AppMethodBeat.o(108147);
        return 0;
      case 2: 
        localbsr.mdj = locala.OmT.readString();
        AppMethodBeat.o(108147);
        return 0;
      case 3: 
        localbsr.Hgn = locala.OmT.readString();
        AppMethodBeat.o(108147);
        return 0;
      case 4: 
        localbsr.Hgo = locala.OmT.readString();
        AppMethodBeat.o(108147);
        return 0;
      case 5: 
        localbsr.Hgp = locala.OmT.readString();
        AppMethodBeat.o(108147);
        return 0;
      }
      localbsr.Hgq = locala.OmT.readString();
      AppMethodBeat.o(108147);
      return 0;
    }
    AppMethodBeat.o(108147);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsr
 * JD-Core Version:    0.7.0.1
 */