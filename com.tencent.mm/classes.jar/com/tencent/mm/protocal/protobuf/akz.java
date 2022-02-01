package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akz
  extends com.tencent.mm.bx.a
{
  public long Rsc;
  public int Zoz;
  public long Zsi;
  public long Zsj;
  public String Zsk;
  public String Zsl;
  public int mNd;
  public long wwF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258223);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.Zsi);
      paramVarArgs.bv(2, this.Zsj);
      paramVarArgs.bv(3, this.Rsc);
      paramVarArgs.bv(4, this.wwF);
      paramVarArgs.bS(5, this.Zoz);
      if (this.Zsk != null) {
        paramVarArgs.g(6, this.Zsk);
      }
      paramVarArgs.bS(7, this.mNd);
      if (this.Zsl != null) {
        paramVarArgs.g(8, this.Zsl);
      }
      AppMethodBeat.o(258223);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.Zsi) + 0 + i.a.a.b.b.a.q(2, this.Zsj) + i.a.a.b.b.a.q(3, this.Rsc) + i.a.a.b.b.a.q(4, this.wwF) + i.a.a.b.b.a.cJ(5, this.Zoz);
      paramInt = i;
      if (this.Zsk != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Zsk);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.mNd);
      paramInt = i;
      if (this.Zsl != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.Zsl);
      }
      AppMethodBeat.o(258223);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258223);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      akz localakz = (akz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258223);
        return -1;
      case 1: 
        localakz.Zsi = locala.ajGk.aaw();
        AppMethodBeat.o(258223);
        return 0;
      case 2: 
        localakz.Zsj = locala.ajGk.aaw();
        AppMethodBeat.o(258223);
        return 0;
      case 3: 
        localakz.Rsc = locala.ajGk.aaw();
        AppMethodBeat.o(258223);
        return 0;
      case 4: 
        localakz.wwF = locala.ajGk.aaw();
        AppMethodBeat.o(258223);
        return 0;
      case 5: 
        localakz.Zoz = locala.ajGk.aar();
        AppMethodBeat.o(258223);
        return 0;
      case 6: 
        localakz.Zsk = locala.ajGk.readString();
        AppMethodBeat.o(258223);
        return 0;
      case 7: 
        localakz.mNd = locala.ajGk.aar();
        AppMethodBeat.o(258223);
        return 0;
      }
      localakz.Zsl = locala.ajGk.readString();
      AppMethodBeat.o(258223);
      return 0;
    }
    AppMethodBeat.o(258223);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akz
 * JD-Core Version:    0.7.0.1
 */