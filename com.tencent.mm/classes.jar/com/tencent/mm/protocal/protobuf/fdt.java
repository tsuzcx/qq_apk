package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fdt
  extends com.tencent.mm.bw.a
{
  public String Meq;
  public String Mer;
  public String Nzo;
  public String dPS;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123707);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nzo != null) {
        paramVarArgs.e(1, this.Nzo);
      }
      paramVarArgs.aM(2, this.version);
      if (this.url != null) {
        paramVarArgs.e(3, this.url);
      }
      if (this.dPS != null) {
        paramVarArgs.e(4, this.dPS);
      }
      if (this.Meq != null) {
        paramVarArgs.e(5, this.Meq);
      }
      if (this.Mer != null) {
        paramVarArgs.e(6, this.Mer);
      }
      AppMethodBeat.o(123707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Nzo == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = g.a.a.b.b.a.f(1, this.Nzo) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.version);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.url);
      }
      i = paramInt;
      if (this.dPS != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.dPS);
      }
      paramInt = i;
      if (this.Meq != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Meq);
      }
      i = paramInt;
      if (this.Mer != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.Mer);
      }
      AppMethodBeat.o(123707);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123707);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fdt localfdt = (fdt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123707);
          return -1;
        case 1: 
          localfdt.Nzo = locala.UbS.readString();
          AppMethodBeat.o(123707);
          return 0;
        case 2: 
          localfdt.version = locala.UbS.zi();
          AppMethodBeat.o(123707);
          return 0;
        case 3: 
          localfdt.url = locala.UbS.readString();
          AppMethodBeat.o(123707);
          return 0;
        case 4: 
          localfdt.dPS = locala.UbS.readString();
          AppMethodBeat.o(123707);
          return 0;
        case 5: 
          localfdt.Meq = locala.UbS.readString();
          AppMethodBeat.o(123707);
          return 0;
        }
        localfdt.Mer = locala.UbS.readString();
        AppMethodBeat.o(123707);
        return 0;
      }
      AppMethodBeat.o(123707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdt
 * JD-Core Version:    0.7.0.1
 */