package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cjv
  extends com.tencent.mm.cd.a
{
  public String IfQ;
  public String Saj;
  public String Trl;
  public long Trm;
  public String Trn;
  public String Tro;
  public String Trp;
  public int state;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72500);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Saj != null) {
        paramVarArgs.f(1, this.Saj);
      }
      paramVarArgs.aY(2, this.state);
      if (this.title != null) {
        paramVarArgs.f(3, this.title);
      }
      if (this.Trl != null) {
        paramVarArgs.f(4, this.Trl);
      }
      paramVarArgs.bm(5, this.Trm);
      if (this.Trn != null) {
        paramVarArgs.f(6, this.Trn);
      }
      if (this.IfQ != null) {
        paramVarArgs.f(7, this.IfQ);
      }
      if (this.Tro != null) {
        paramVarArgs.f(8, this.Tro);
      }
      if (this.Trp != null) {
        paramVarArgs.f(9, this.Trp);
      }
      AppMethodBeat.o(72500);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Saj == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = g.a.a.b.b.a.g(1, this.Saj) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.state);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.title);
      }
      i = paramInt;
      if (this.Trl != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.Trl);
      }
      i += g.a.a.b.b.a.p(5, this.Trm);
      paramInt = i;
      if (this.Trn != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Trn);
      }
      i = paramInt;
      if (this.IfQ != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.IfQ);
      }
      paramInt = i;
      if (this.Tro != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Tro);
      }
      i = paramInt;
      if (this.Trp != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.Trp);
      }
      AppMethodBeat.o(72500);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72500);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cjv localcjv = (cjv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72500);
          return -1;
        case 1: 
          localcjv.Saj = locala.abFh.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 2: 
          localcjv.state = locala.abFh.AK();
          AppMethodBeat.o(72500);
          return 0;
        case 3: 
          localcjv.title = locala.abFh.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 4: 
          localcjv.Trl = locala.abFh.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 5: 
          localcjv.Trm = locala.abFh.AN();
          AppMethodBeat.o(72500);
          return 0;
        case 6: 
          localcjv.Trn = locala.abFh.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 7: 
          localcjv.IfQ = locala.abFh.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 8: 
          localcjv.Tro = locala.abFh.readString();
          AppMethodBeat.o(72500);
          return 0;
        }
        localcjv.Trp = locala.abFh.readString();
        AppMethodBeat.o(72500);
        return 0;
      }
      AppMethodBeat.o(72500);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjv
 * JD-Core Version:    0.7.0.1
 */