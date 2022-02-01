package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class dzx
  extends com.tencent.mm.cd.a
{
  public String CqK;
  public String Uff;
  public String Ufg;
  public b Ufh;
  public long Ufi;
  public String Ufj;
  public String Ufk;
  public String Ufl;
  public String Username;
  public String fwr;
  public int vhF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181512);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ufg != null) {
        paramVarArgs.f(1, this.Ufg);
      }
      if (this.Username != null) {
        paramVarArgs.f(2, this.Username);
      }
      if (this.CqK != null) {
        paramVarArgs.f(3, this.CqK);
      }
      paramVarArgs.aY(4, this.vhF);
      if (this.Ufh != null) {
        paramVarArgs.c(5, this.Ufh);
      }
      if (this.fwr != null) {
        paramVarArgs.f(6, this.fwr);
      }
      if (this.Uff != null) {
        paramVarArgs.f(7, this.Uff);
      }
      paramVarArgs.bm(8, this.Ufi);
      if (this.Ufj != null) {
        paramVarArgs.f(9, this.Ufj);
      }
      if (this.Ufk != null) {
        paramVarArgs.f(10, this.Ufk);
      }
      if (this.Ufl != null) {
        paramVarArgs.f(11, this.Ufl);
      }
      AppMethodBeat.o(181512);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ufg == null) {
        break label794;
      }
    }
    label794:
    for (int i = g.a.a.b.b.a.g(1, this.Ufg) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Username != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Username);
      }
      i = paramInt;
      if (this.CqK != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CqK);
      }
      i += g.a.a.b.b.a.bM(4, this.vhF);
      paramInt = i;
      if (this.Ufh != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.Ufh);
      }
      i = paramInt;
      if (this.fwr != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.fwr);
      }
      paramInt = i;
      if (this.Uff != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Uff);
      }
      i = paramInt + g.a.a.b.b.a.p(8, this.Ufi);
      paramInt = i;
      if (this.Ufj != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.Ufj);
      }
      i = paramInt;
      if (this.Ufk != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.Ufk);
      }
      paramInt = i;
      if (this.Ufl != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.Ufl);
      }
      AppMethodBeat.o(181512);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(181512);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dzx localdzx = (dzx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(181512);
          return -1;
        case 1: 
          localdzx.Ufg = locala.abFh.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 2: 
          localdzx.Username = locala.abFh.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 3: 
          localdzx.CqK = locala.abFh.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 4: 
          localdzx.vhF = locala.abFh.AK();
          AppMethodBeat.o(181512);
          return 0;
        case 5: 
          localdzx.Ufh = locala.abFh.iUw();
          AppMethodBeat.o(181512);
          return 0;
        case 6: 
          localdzx.fwr = locala.abFh.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 7: 
          localdzx.Uff = locala.abFh.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 8: 
          localdzx.Ufi = locala.abFh.AN();
          AppMethodBeat.o(181512);
          return 0;
        case 9: 
          localdzx.Ufj = locala.abFh.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 10: 
          localdzx.Ufk = locala.abFh.readString();
          AppMethodBeat.o(181512);
          return 0;
        }
        localdzx.Ufl = locala.abFh.readString();
        AppMethodBeat.o(181512);
        return 0;
      }
      AppMethodBeat.o(181512);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzx
 * JD-Core Version:    0.7.0.1
 */