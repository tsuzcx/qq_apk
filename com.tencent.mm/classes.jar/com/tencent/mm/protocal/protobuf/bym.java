package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bym
  extends com.tencent.mm.bx.a
{
  public String DVl;
  public int DVm;
  public long createTime;
  public String dpv;
  public String gLo;
  public long muT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(186492);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dpv != null) {
        paramVarArgs.d(1, this.dpv);
      }
      if (this.DVl != null) {
        paramVarArgs.d(2, this.DVl);
      }
      if (this.gLo != null) {
        paramVarArgs.d(3, this.gLo);
      }
      paramVarArgs.aG(4, this.createTime);
      paramVarArgs.aR(5, this.DVm);
      paramVarArgs.aG(6, this.muT);
      AppMethodBeat.o(186492);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dpv == null) {
        break label474;
      }
    }
    label474:
    for (int i = f.a.a.b.b.a.e(1, this.dpv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DVl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DVl);
      }
      i = paramInt;
      if (this.gLo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gLo);
      }
      paramInt = f.a.a.b.b.a.q(4, this.createTime);
      int j = f.a.a.b.b.a.bA(5, this.DVm);
      int k = f.a.a.b.b.a.q(6, this.muT);
      AppMethodBeat.o(186492);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(186492);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bym localbym = (bym)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(186492);
          return -1;
        case 1: 
          localbym.dpv = locala.KhF.readString();
          AppMethodBeat.o(186492);
          return 0;
        case 2: 
          localbym.DVl = locala.KhF.readString();
          AppMethodBeat.o(186492);
          return 0;
        case 3: 
          localbym.gLo = locala.KhF.readString();
          AppMethodBeat.o(186492);
          return 0;
        case 4: 
          localbym.createTime = locala.KhF.xT();
          AppMethodBeat.o(186492);
          return 0;
        case 5: 
          localbym.DVm = locala.KhF.xS();
          AppMethodBeat.o(186492);
          return 0;
        }
        localbym.muT = locala.KhF.xT();
        AppMethodBeat.o(186492);
        return 0;
      }
      AppMethodBeat.o(186492);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bym
 * JD-Core Version:    0.7.0.1
 */