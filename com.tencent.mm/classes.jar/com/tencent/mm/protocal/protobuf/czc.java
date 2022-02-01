package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czc
  extends com.tencent.mm.bw.a
{
  public int KWb;
  public String Lrs;
  public int Lrt;
  public String Lru;
  public String MEn;
  public String MEo;
  public String MEp;
  public String UserName;
  public String query;
  public String xIy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117887);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KWb);
      if (this.xIy != null) {
        paramVarArgs.e(2, this.xIy);
      }
      if (this.UserName != null) {
        paramVarArgs.e(3, this.UserName);
      }
      if (this.Lrs != null) {
        paramVarArgs.e(4, this.Lrs);
      }
      paramVarArgs.aM(5, this.Lrt);
      if (this.Lru != null) {
        paramVarArgs.e(6, this.Lru);
      }
      if (this.MEn != null) {
        paramVarArgs.e(7, this.MEn);
      }
      if (this.MEo != null) {
        paramVarArgs.e(8, this.MEo);
      }
      if (this.query != null) {
        paramVarArgs.e(100, this.query);
      }
      if (this.MEp != null) {
        paramVarArgs.e(101, this.MEp);
      }
      AppMethodBeat.o(117887);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.KWb) + 0;
      paramInt = i;
      if (this.xIy != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xIy);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.UserName);
      }
      paramInt = i;
      if (this.Lrs != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Lrs);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.Lrt);
      paramInt = i;
      if (this.Lru != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Lru);
      }
      i = paramInt;
      if (this.MEn != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.MEn);
      }
      paramInt = i;
      if (this.MEo != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.MEo);
      }
      i = paramInt;
      if (this.query != null) {
        i = paramInt + g.a.a.b.b.a.f(100, this.query);
      }
      paramInt = i;
      if (this.MEp != null) {
        paramInt = i + g.a.a.b.b.a.f(101, this.MEp);
      }
      AppMethodBeat.o(117887);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(117887);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      czc localczc = (czc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117887);
        return -1;
      case 1: 
        localczc.KWb = locala.UbS.zi();
        AppMethodBeat.o(117887);
        return 0;
      case 2: 
        localczc.xIy = locala.UbS.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 3: 
        localczc.UserName = locala.UbS.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 4: 
        localczc.Lrs = locala.UbS.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 5: 
        localczc.Lrt = locala.UbS.zi();
        AppMethodBeat.o(117887);
        return 0;
      case 6: 
        localczc.Lru = locala.UbS.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 7: 
        localczc.MEn = locala.UbS.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 8: 
        localczc.MEo = locala.UbS.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 100: 
        localczc.query = locala.UbS.readString();
        AppMethodBeat.o(117887);
        return 0;
      }
      localczc.MEp = locala.UbS.readString();
      AppMethodBeat.o(117887);
      return 0;
    }
    AppMethodBeat.o(117887);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czc
 * JD-Core Version:    0.7.0.1
 */