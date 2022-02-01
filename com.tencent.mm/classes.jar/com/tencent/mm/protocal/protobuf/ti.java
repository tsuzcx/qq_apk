package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ti
  extends com.tencent.mm.cd.a
{
  public String Sdb;
  public int Sdc;
  public String Sdd;
  public String Sde;
  public String nqp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116466);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Sdb != null) {
        paramVarArgs.f(1, this.Sdb);
      }
      paramVarArgs.aY(2, this.Sdc);
      if (this.Sdd != null) {
        paramVarArgs.f(3, this.Sdd);
      }
      if (this.nqp != null) {
        paramVarArgs.f(4, this.nqp);
      }
      if (this.Sde != null) {
        paramVarArgs.f(5, this.Sde);
      }
      AppMethodBeat.o(116466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Sdb == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = g.a.a.b.b.a.g(1, this.Sdb) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Sdc);
      paramInt = i;
      if (this.Sdd != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.Sdd);
      }
      i = paramInt;
      if (this.nqp != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.nqp);
      }
      paramInt = i;
      if (this.Sde != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Sde);
      }
      AppMethodBeat.o(116466);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(116466);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ti localti = (ti)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116466);
          return -1;
        case 1: 
          localti.Sdb = locala.abFh.readString();
          AppMethodBeat.o(116466);
          return 0;
        case 2: 
          localti.Sdc = locala.abFh.AK();
          AppMethodBeat.o(116466);
          return 0;
        case 3: 
          localti.Sdd = locala.abFh.readString();
          AppMethodBeat.o(116466);
          return 0;
        case 4: 
          localti.nqp = locala.abFh.readString();
          AppMethodBeat.o(116466);
          return 0;
        }
        localti.Sde = locala.abFh.readString();
        AppMethodBeat.o(116466);
        return 0;
      }
      AppMethodBeat.o(116466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ti
 * JD-Core Version:    0.7.0.1
 */