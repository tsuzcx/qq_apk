package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cih
  extends com.tencent.mm.cd.a
{
  public String EtG;
  public long Tpi;
  public long Tpj;
  public int Tpk;
  public String Tpl;
  public String nickname;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91519);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.Tpi);
      paramVarArgs.bm(2, this.Tpj);
      if (this.nickname != null) {
        paramVarArgs.f(3, this.nickname);
      }
      if (this.EtG != null) {
        paramVarArgs.f(4, this.EtG);
      }
      paramVarArgs.aY(5, this.Tpk);
      if (this.username != null) {
        paramVarArgs.f(6, this.username);
      }
      if (this.Tpl != null) {
        paramVarArgs.f(7, this.Tpl);
      }
      AppMethodBeat.o(91519);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.Tpi) + 0 + g.a.a.b.b.a.p(2, this.Tpj);
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.nickname);
      }
      i = paramInt;
      if (this.EtG != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.EtG);
      }
      i += g.a.a.b.b.a.bM(5, this.Tpk);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.username);
      }
      i = paramInt;
      if (this.Tpl != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Tpl);
      }
      AppMethodBeat.o(91519);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91519);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cih localcih = (cih)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91519);
        return -1;
      case 1: 
        localcih.Tpi = locala.abFh.AN();
        AppMethodBeat.o(91519);
        return 0;
      case 2: 
        localcih.Tpj = locala.abFh.AN();
        AppMethodBeat.o(91519);
        return 0;
      case 3: 
        localcih.nickname = locala.abFh.readString();
        AppMethodBeat.o(91519);
        return 0;
      case 4: 
        localcih.EtG = locala.abFh.readString();
        AppMethodBeat.o(91519);
        return 0;
      case 5: 
        localcih.Tpk = locala.abFh.AK();
        AppMethodBeat.o(91519);
        return 0;
      case 6: 
        localcih.username = locala.abFh.readString();
        AppMethodBeat.o(91519);
        return 0;
      }
      localcih.Tpl = locala.abFh.readString();
      AppMethodBeat.o(91519);
      return 0;
    }
    AppMethodBeat.o(91519);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cih
 * JD-Core Version:    0.7.0.1
 */