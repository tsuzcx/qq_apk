package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bgj
  extends com.tencent.mm.bx.a
{
  public String CWy;
  public int DEk;
  public long DEl;
  public long DEm;
  public long Dbe;
  public String Duy;
  public String dub;
  public int lpz;
  public String nsJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72504);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CWy != null) {
        paramVarArgs.d(1, this.CWy);
      }
      paramVarArgs.aG(2, this.Dbe);
      paramVarArgs.aR(3, this.DEk);
      paramVarArgs.aG(4, this.DEl);
      paramVarArgs.aG(5, this.DEm);
      if (this.Duy != null) {
        paramVarArgs.d(6, this.Duy);
      }
      if (this.nsJ != null) {
        paramVarArgs.d(7, this.nsJ);
      }
      paramVarArgs.aR(8, this.lpz);
      if (this.dub != null) {
        paramVarArgs.d(9, this.dub);
      }
      AppMethodBeat.o(72504);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CWy == null) {
        break label618;
      }
    }
    label618:
    for (paramInt = f.a.a.b.b.a.e(1, this.CWy) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.Dbe) + f.a.a.b.b.a.bA(3, this.DEk) + f.a.a.b.b.a.q(4, this.DEl) + f.a.a.b.b.a.q(5, this.DEm);
      paramInt = i;
      if (this.Duy != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Duy);
      }
      i = paramInt;
      if (this.nsJ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.nsJ);
      }
      i += f.a.a.b.b.a.bA(8, this.lpz);
      paramInt = i;
      if (this.dub != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.dub);
      }
      AppMethodBeat.o(72504);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72504);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bgj localbgj = (bgj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72504);
          return -1;
        case 1: 
          localbgj.CWy = locala.KhF.readString();
          AppMethodBeat.o(72504);
          return 0;
        case 2: 
          localbgj.Dbe = locala.KhF.xT();
          AppMethodBeat.o(72504);
          return 0;
        case 3: 
          localbgj.DEk = locala.KhF.xS();
          AppMethodBeat.o(72504);
          return 0;
        case 4: 
          localbgj.DEl = locala.KhF.xT();
          AppMethodBeat.o(72504);
          return 0;
        case 5: 
          localbgj.DEm = locala.KhF.xT();
          AppMethodBeat.o(72504);
          return 0;
        case 6: 
          localbgj.Duy = locala.KhF.readString();
          AppMethodBeat.o(72504);
          return 0;
        case 7: 
          localbgj.nsJ = locala.KhF.readString();
          AppMethodBeat.o(72504);
          return 0;
        case 8: 
          localbgj.lpz = locala.KhF.xS();
          AppMethodBeat.o(72504);
          return 0;
        }
        localbgj.dub = locala.KhF.readString();
        AppMethodBeat.o(72504);
        return 0;
      }
      AppMethodBeat.o(72504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgj
 * JD-Core Version:    0.7.0.1
 */