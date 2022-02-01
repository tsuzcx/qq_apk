package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ege
  extends com.tencent.mm.bx.a
{
  public int FKM;
  public int FKm;
  public long HRj;
  public boolean HRk;
  public String HRl;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123692);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      paramVarArgs.aS(2, this.FKm);
      paramVarArgs.aS(3, this.FKM);
      paramVarArgs.aY(4, this.HRj);
      paramVarArgs.bt(5, this.HRk);
      if (this.HRl != null) {
        paramVarArgs.d(6, this.HRl);
      }
      AppMethodBeat.o(123692);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label442;
      }
    }
    label442:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FKm) + f.a.a.b.b.a.bz(3, this.FKM) + f.a.a.b.b.a.p(4, this.HRj) + f.a.a.b.b.a.alV(5);
      paramInt = i;
      if (this.HRl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HRl);
      }
      AppMethodBeat.o(123692);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123692);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ege localege = (ege)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123692);
          return -1;
        case 1: 
          localege.username = locala.NPN.readString();
          AppMethodBeat.o(123692);
          return 0;
        case 2: 
          localege.FKm = locala.NPN.zc();
          AppMethodBeat.o(123692);
          return 0;
        case 3: 
          localege.FKM = locala.NPN.zc();
          AppMethodBeat.o(123692);
          return 0;
        case 4: 
          localege.HRj = locala.NPN.zd();
          AppMethodBeat.o(123692);
          return 0;
        case 5: 
          localege.HRk = locala.NPN.grw();
          AppMethodBeat.o(123692);
          return 0;
        }
        localege.HRl = locala.NPN.readString();
        AppMethodBeat.o(123692);
        return 0;
      }
      AppMethodBeat.o(123692);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ege
 * JD-Core Version:    0.7.0.1
 */