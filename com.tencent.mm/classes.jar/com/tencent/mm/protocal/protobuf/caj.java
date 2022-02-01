package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class caj
  extends com.tencent.mm.bx.a
{
  public String CXY;
  public boolean DWU;
  public boolean DWV;
  public String boU;
  public String dpO;
  public String lkd;
  public String lke;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123634);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dpO != null) {
        paramVarArgs.d(1, this.dpO);
      }
      if (this.CXY != null) {
        paramVarArgs.d(2, this.CXY);
      }
      paramVarArgs.bg(3, this.DWU);
      paramVarArgs.bg(4, this.DWV);
      if (this.lkd != null) {
        paramVarArgs.d(5, this.lkd);
      }
      if (this.boU != null) {
        paramVarArgs.d(6, this.boU);
      }
      if (this.lke != null) {
        paramVarArgs.d(7, this.lke);
      }
      AppMethodBeat.o(123634);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dpO == null) {
        break label542;
      }
    }
    label542:
    for (paramInt = f.a.a.b.b.a.e(1, this.dpO) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CXY != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.CXY);
      }
      i = i + (f.a.a.b.b.a.fY(3) + 1) + (f.a.a.b.b.a.fY(4) + 1);
      paramInt = i;
      if (this.lkd != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.lkd);
      }
      i = paramInt;
      if (this.boU != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.boU);
      }
      paramInt = i;
      if (this.lke != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.lke);
      }
      AppMethodBeat.o(123634);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123634);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        caj localcaj = (caj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123634);
          return -1;
        case 1: 
          localcaj.dpO = locala.KhF.readString();
          AppMethodBeat.o(123634);
          return 0;
        case 2: 
          localcaj.CXY = locala.KhF.readString();
          AppMethodBeat.o(123634);
          return 0;
        case 3: 
          localcaj.DWU = locala.KhF.fHu();
          AppMethodBeat.o(123634);
          return 0;
        case 4: 
          localcaj.DWV = locala.KhF.fHu();
          AppMethodBeat.o(123634);
          return 0;
        case 5: 
          localcaj.lkd = locala.KhF.readString();
          AppMethodBeat.o(123634);
          return 0;
        case 6: 
          localcaj.boU = locala.KhF.readString();
          AppMethodBeat.o(123634);
          return 0;
        }
        localcaj.lke = locala.KhF.readString();
        AppMethodBeat.o(123634);
        return 0;
      }
      AppMethodBeat.o(123634);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.caj
 * JD-Core Version:    0.7.0.1
 */