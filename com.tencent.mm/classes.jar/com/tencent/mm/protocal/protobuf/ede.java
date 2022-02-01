package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ede
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b HOD;
  public boolean HOU;
  public boolean HOV;
  public boolean HOW;
  public String Hnp;
  public int Hrp;
  public String Title;
  public String hDa;
  public int ukh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32545);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hnp == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.Title == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Title");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.hDa == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.ukh);
      if (this.Hnp != null) {
        paramVarArgs.d(2, this.Hnp);
      }
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      if (this.hDa != null) {
        paramVarArgs.d(4, this.hDa);
      }
      paramVarArgs.aS(5, this.Hrp);
      if (this.HOD != null) {
        paramVarArgs.c(6, this.HOD);
      }
      paramVarArgs.bt(7, this.HOU);
      paramVarArgs.bt(8, this.HOV);
      paramVarArgs.bt(9, this.HOW);
      AppMethodBeat.o(32545);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.ukh) + 0;
      paramInt = i;
      if (this.Hnp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hnp);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Title);
      }
      paramInt = i;
      if (this.hDa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hDa);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Hrp);
      paramInt = i;
      if (this.HOD != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.HOD);
      }
      i = f.a.a.b.b.a.alV(7);
      int j = f.a.a.b.b.a.alV(8);
      int k = f.a.a.b.b.a.alV(9);
      AppMethodBeat.o(32545);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.Hnp == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.Title == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Title");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.hDa == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32545);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ede localede = (ede)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32545);
        return -1;
      case 1: 
        localede.ukh = locala.NPN.zc();
        AppMethodBeat.o(32545);
        return 0;
      case 2: 
        localede.Hnp = locala.NPN.readString();
        AppMethodBeat.o(32545);
        return 0;
      case 3: 
        localede.Title = locala.NPN.readString();
        AppMethodBeat.o(32545);
        return 0;
      case 4: 
        localede.hDa = locala.NPN.readString();
        AppMethodBeat.o(32545);
        return 0;
      case 5: 
        localede.Hrp = locala.NPN.zc();
        AppMethodBeat.o(32545);
        return 0;
      case 6: 
        localede.HOD = locala.NPN.gxI();
        AppMethodBeat.o(32545);
        return 0;
      case 7: 
        localede.HOU = locala.NPN.grw();
        AppMethodBeat.o(32545);
        return 0;
      case 8: 
        localede.HOV = locala.NPN.grw();
        AppMethodBeat.o(32545);
        return 0;
      }
      localede.HOW = locala.NPN.grw();
      AppMethodBeat.o(32545);
      return 0;
    }
    AppMethodBeat.o(32545);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ede
 * JD-Core Version:    0.7.0.1
 */