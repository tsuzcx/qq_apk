package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbj
  extends com.tencent.mm.bw.a
{
  public String Lli;
  public boolean MGs;
  public boolean MGt;
  public String bxK;
  public String dSf;
  public String nzu;
  public String nzv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123634);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dSf != null) {
        paramVarArgs.e(1, this.dSf);
      }
      if (this.Lli != null) {
        paramVarArgs.e(2, this.Lli);
      }
      paramVarArgs.cc(3, this.MGs);
      paramVarArgs.cc(4, this.MGt);
      if (this.nzu != null) {
        paramVarArgs.e(5, this.nzu);
      }
      if (this.bxK != null) {
        paramVarArgs.e(6, this.bxK);
      }
      if (this.nzv != null) {
        paramVarArgs.e(7, this.nzv);
      }
      AppMethodBeat.o(123634);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dSf == null) {
        break label542;
      }
    }
    label542:
    for (paramInt = g.a.a.b.b.a.f(1, this.dSf) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Lli != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Lli);
      }
      i = i + (g.a.a.b.b.a.fS(3) + 1) + (g.a.a.b.b.a.fS(4) + 1);
      paramInt = i;
      if (this.nzu != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.nzu);
      }
      i = paramInt;
      if (this.bxK != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.bxK);
      }
      paramInt = i;
      if (this.nzv != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.nzv);
      }
      AppMethodBeat.o(123634);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123634);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dbj localdbj = (dbj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123634);
          return -1;
        case 1: 
          localdbj.dSf = locala.UbS.readString();
          AppMethodBeat.o(123634);
          return 0;
        case 2: 
          localdbj.Lli = locala.UbS.readString();
          AppMethodBeat.o(123634);
          return 0;
        case 3: 
          localdbj.MGs = locala.UbS.yZ();
          AppMethodBeat.o(123634);
          return 0;
        case 4: 
          localdbj.MGt = locala.UbS.yZ();
          AppMethodBeat.o(123634);
          return 0;
        case 5: 
          localdbj.nzu = locala.UbS.readString();
          AppMethodBeat.o(123634);
          return 0;
        case 6: 
          localdbj.bxK = locala.UbS.readString();
          AppMethodBeat.o(123634);
          return 0;
        }
        localdbj.nzv = locala.UbS.readString();
        AppMethodBeat.o(123634);
        return 0;
      }
      AppMethodBeat.o(123634);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbj
 * JD-Core Version:    0.7.0.1
 */