package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cik
  extends com.tencent.mm.bw.a
{
  public String Cyk;
  public String LRO;
  public String Lir;
  public String Lis;
  public String UserName;
  public int oTW;
  public String oUJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155433);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Cyk != null) {
        paramVarArgs.e(1, this.Cyk);
      }
      if (this.UserName != null) {
        paramVarArgs.e(2, this.UserName);
      }
      paramVarArgs.aM(3, this.oTW);
      if (this.Lir != null) {
        paramVarArgs.e(4, this.Lir);
      }
      if (this.Lis != null) {
        paramVarArgs.e(5, this.Lis);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(6, this.oUJ);
      }
      if (this.LRO != null) {
        paramVarArgs.e(7, this.LRO);
      }
      AppMethodBeat.o(155433);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Cyk == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = g.a.a.b.b.a.f(1, this.Cyk) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.UserName);
      }
      i += g.a.a.b.b.a.bu(3, this.oTW);
      paramInt = i;
      if (this.Lir != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Lir);
      }
      i = paramInt;
      if (this.Lis != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Lis);
      }
      paramInt = i;
      if (this.oUJ != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.oUJ);
      }
      i = paramInt;
      if (this.LRO != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.LRO);
      }
      AppMethodBeat.o(155433);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(155433);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cik localcik = (cik)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(155433);
          return -1;
        case 1: 
          localcik.Cyk = locala.UbS.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 2: 
          localcik.UserName = locala.UbS.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 3: 
          localcik.oTW = locala.UbS.zi();
          AppMethodBeat.o(155433);
          return 0;
        case 4: 
          localcik.Lir = locala.UbS.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 5: 
          localcik.Lis = locala.UbS.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 6: 
          localcik.oUJ = locala.UbS.readString();
          AppMethodBeat.o(155433);
          return 0;
        }
        localcik.LRO = locala.UbS.readString();
        AppMethodBeat.o(155433);
        return 0;
      }
      AppMethodBeat.o(155433);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cik
 * JD-Core Version:    0.7.0.1
 */