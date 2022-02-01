package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class diw
  extends com.tencent.mm.bx.a
{
  public String CBS;
  public String DCE;
  public String DVw;
  public String Daj;
  public long Ezf;
  public String IconUrl;
  public String mAU;
  public String scR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32491);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Daj != null) {
        paramVarArgs.d(1, this.Daj);
      }
      if (this.CBS != null) {
        paramVarArgs.d(2, this.CBS);
      }
      if (this.DVw != null) {
        paramVarArgs.d(3, this.DVw);
      }
      if (this.scR != null) {
        paramVarArgs.d(4, this.scR);
      }
      if (this.mAU != null) {
        paramVarArgs.d(5, this.mAU);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(6, this.IconUrl);
      }
      if (this.DCE != null) {
        paramVarArgs.d(7, this.DCE);
      }
      paramVarArgs.aG(8, this.Ezf);
      AppMethodBeat.o(32491);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Daj == null) {
        break label640;
      }
    }
    label640:
    for (int i = f.a.a.b.b.a.e(1, this.Daj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CBS != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CBS);
      }
      i = paramInt;
      if (this.DVw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DVw);
      }
      paramInt = i;
      if (this.scR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.scR);
      }
      i = paramInt;
      if (this.mAU != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.mAU);
      }
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.IconUrl);
      }
      i = paramInt;
      if (this.DCE != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DCE);
      }
      paramInt = f.a.a.b.b.a.q(8, this.Ezf);
      AppMethodBeat.o(32491);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32491);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        diw localdiw = (diw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32491);
          return -1;
        case 1: 
          localdiw.Daj = locala.KhF.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 2: 
          localdiw.CBS = locala.KhF.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 3: 
          localdiw.DVw = locala.KhF.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 4: 
          localdiw.scR = locala.KhF.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 5: 
          localdiw.mAU = locala.KhF.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 6: 
          localdiw.IconUrl = locala.KhF.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 7: 
          localdiw.DCE = locala.KhF.readString();
          AppMethodBeat.o(32491);
          return 0;
        }
        localdiw.Ezf = locala.KhF.xT();
        AppMethodBeat.o(32491);
        return 0;
      }
      AppMethodBeat.o(32491);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.diw
 * JD-Core Version:    0.7.0.1
 */