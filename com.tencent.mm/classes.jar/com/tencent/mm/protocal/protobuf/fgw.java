package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fgw
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public String CNP;
  public String ProductID;
  public int RIs;
  public String TVo;
  public String UHh;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32508);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      if (this.TVo != null) {
        paramVarArgs.f(2, this.TVo);
      }
      if (this.CNP != null) {
        paramVarArgs.f(3, this.CNP);
      }
      if (this.CMB != null) {
        paramVarArgs.f(4, this.CMB);
      }
      if (this.UHh != null) {
        paramVarArgs.f(5, this.UHh);
      }
      paramVarArgs.aY(6, this.RIs);
      if (this.ProductID != null) {
        paramVarArgs.f(7, this.ProductID);
      }
      AppMethodBeat.o(32508);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label575;
      }
    }
    label575:
    for (int i = g.a.a.b.b.a.g(1, this.fwr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TVo != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TVo);
      }
      i = paramInt;
      if (this.CNP != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CNP);
      }
      paramInt = i;
      if (this.CMB != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CMB);
      }
      i = paramInt;
      if (this.UHh != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UHh);
      }
      i += g.a.a.b.b.a.bM(6, this.RIs);
      paramInt = i;
      if (this.ProductID != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.ProductID);
      }
      AppMethodBeat.o(32508);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32508);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fgw localfgw = (fgw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32508);
          return -1;
        case 1: 
          localfgw.fwr = locala.abFh.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 2: 
          localfgw.TVo = locala.abFh.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 3: 
          localfgw.CNP = locala.abFh.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 4: 
          localfgw.CMB = locala.abFh.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 5: 
          localfgw.UHh = locala.abFh.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 6: 
          localfgw.RIs = locala.abFh.AK();
          AppMethodBeat.o(32508);
          return 0;
        }
        localfgw.ProductID = locala.abFh.readString();
        AppMethodBeat.o(32508);
        return 0;
      }
      AppMethodBeat.o(32508);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fgw
 * JD-Core Version:    0.7.0.1
 */