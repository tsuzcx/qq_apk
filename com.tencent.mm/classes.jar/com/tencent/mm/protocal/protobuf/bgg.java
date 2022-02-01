package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bgg
  extends com.tencent.mm.bx.a
{
  public String CNj;
  public String DEa;
  public long DEb;
  public String DEc;
  public String DEd;
  public String DEe;
  public int state;
  public String title;
  public String vur;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72500);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CNj != null) {
        paramVarArgs.d(1, this.CNj);
      }
      paramVarArgs.aR(2, this.state);
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      if (this.DEa != null) {
        paramVarArgs.d(4, this.DEa);
      }
      paramVarArgs.aG(5, this.DEb);
      if (this.DEc != null) {
        paramVarArgs.d(6, this.DEc);
      }
      if (this.vur != null) {
        paramVarArgs.d(7, this.vur);
      }
      if (this.DEd != null) {
        paramVarArgs.d(8, this.DEd);
      }
      if (this.DEe != null) {
        paramVarArgs.d(9, this.DEe);
      }
      AppMethodBeat.o(72500);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CNj == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = f.a.a.b.b.a.e(1, this.CNj) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.state);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.title);
      }
      i = paramInt;
      if (this.DEa != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.DEa);
      }
      i += f.a.a.b.b.a.q(5, this.DEb);
      paramInt = i;
      if (this.DEc != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DEc);
      }
      i = paramInt;
      if (this.vur != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.vur);
      }
      paramInt = i;
      if (this.DEd != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DEd);
      }
      i = paramInt;
      if (this.DEe != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.DEe);
      }
      AppMethodBeat.o(72500);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72500);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bgg localbgg = (bgg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72500);
          return -1;
        case 1: 
          localbgg.CNj = locala.KhF.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 2: 
          localbgg.state = locala.KhF.xS();
          AppMethodBeat.o(72500);
          return 0;
        case 3: 
          localbgg.title = locala.KhF.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 4: 
          localbgg.DEa = locala.KhF.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 5: 
          localbgg.DEb = locala.KhF.xT();
          AppMethodBeat.o(72500);
          return 0;
        case 6: 
          localbgg.DEc = locala.KhF.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 7: 
          localbgg.vur = locala.KhF.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 8: 
          localbgg.DEd = locala.KhF.readString();
          AppMethodBeat.o(72500);
          return 0;
        }
        localbgg.DEe = locala.KhF.readString();
        AppMethodBeat.o(72500);
        return 0;
      }
      AppMethodBeat.o(72500);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgg
 * JD-Core Version:    0.7.0.1
 */