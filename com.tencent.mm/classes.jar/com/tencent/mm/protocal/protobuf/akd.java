package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akd
  extends com.tencent.mm.bx.a
{
  public int ZnI;
  public int Zrl;
  public int Zrm;
  public int Zrn;
  public int Zro;
  public int Zrp;
  public int Zrq;
  public int channels;
  public int wUW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90964);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Zrl);
      paramVarArgs.bS(2, this.Zrm);
      paramVarArgs.bS(3, this.channels);
      paramVarArgs.bS(4, this.Zrn);
      paramVarArgs.bS(5, this.ZnI);
      paramVarArgs.bS(6, this.wUW);
      paramVarArgs.bS(7, this.Zro);
      paramVarArgs.bS(8, this.Zrp);
      paramVarArgs.bS(9, this.Zrq);
      AppMethodBeat.o(90964);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.Zrl);
      int i = i.a.a.b.b.a.cJ(2, this.Zrm);
      int j = i.a.a.b.b.a.cJ(3, this.channels);
      int k = i.a.a.b.b.a.cJ(4, this.Zrn);
      int m = i.a.a.b.b.a.cJ(5, this.ZnI);
      int n = i.a.a.b.b.a.cJ(6, this.wUW);
      int i1 = i.a.a.b.b.a.cJ(7, this.Zro);
      int i2 = i.a.a.b.b.a.cJ(8, this.Zrp);
      int i3 = i.a.a.b.b.a.cJ(9, this.Zrq);
      AppMethodBeat.o(90964);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(90964);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      akd localakd = (akd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(90964);
        return -1;
      case 1: 
        localakd.Zrl = locala.ajGk.aar();
        AppMethodBeat.o(90964);
        return 0;
      case 2: 
        localakd.Zrm = locala.ajGk.aar();
        AppMethodBeat.o(90964);
        return 0;
      case 3: 
        localakd.channels = locala.ajGk.aar();
        AppMethodBeat.o(90964);
        return 0;
      case 4: 
        localakd.Zrn = locala.ajGk.aar();
        AppMethodBeat.o(90964);
        return 0;
      case 5: 
        localakd.ZnI = locala.ajGk.aar();
        AppMethodBeat.o(90964);
        return 0;
      case 6: 
        localakd.wUW = locala.ajGk.aar();
        AppMethodBeat.o(90964);
        return 0;
      case 7: 
        localakd.Zro = locala.ajGk.aar();
        AppMethodBeat.o(90964);
        return 0;
      case 8: 
        localakd.Zrp = locala.ajGk.aar();
        AppMethodBeat.o(90964);
        return 0;
      }
      localakd.Zrq = locala.ajGk.aar();
      AppMethodBeat.o(90964);
      return 0;
    }
    AppMethodBeat.o(90964);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akd
 * JD-Core Version:    0.7.0.1
 */