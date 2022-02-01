package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxk
  extends com.tencent.mm.cd.a
{
  public String TFS;
  public String TFT;
  public String TFU;
  public String TFV;
  public String TFW;
  public String pf;
  public String session_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(270267);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TFS != null) {
        paramVarArgs.f(1, this.TFS);
      }
      if (this.TFT != null) {
        paramVarArgs.f(2, this.TFT);
      }
      if (this.TFU != null) {
        paramVarArgs.f(3, this.TFU);
      }
      if (this.session_id != null) {
        paramVarArgs.f(4, this.session_id);
      }
      if (this.TFV != null) {
        paramVarArgs.f(5, this.TFV);
      }
      if (this.pf != null) {
        paramVarArgs.f(6, this.pf);
      }
      if (this.TFW != null) {
        paramVarArgs.f(7, this.TFW);
      }
      AppMethodBeat.o(270267);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TFS == null) {
        break label578;
      }
    }
    label578:
    for (int i = g.a.a.b.b.a.g(1, this.TFS) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TFT != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TFT);
      }
      i = paramInt;
      if (this.TFU != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TFU);
      }
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.session_id);
      }
      i = paramInt;
      if (this.TFV != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TFV);
      }
      paramInt = i;
      if (this.pf != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.pf);
      }
      i = paramInt;
      if (this.TFW != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.TFW);
      }
      AppMethodBeat.o(270267);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(270267);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cxk localcxk = (cxk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(270267);
          return -1;
        case 1: 
          localcxk.TFS = locala.abFh.readString();
          AppMethodBeat.o(270267);
          return 0;
        case 2: 
          localcxk.TFT = locala.abFh.readString();
          AppMethodBeat.o(270267);
          return 0;
        case 3: 
          localcxk.TFU = locala.abFh.readString();
          AppMethodBeat.o(270267);
          return 0;
        case 4: 
          localcxk.session_id = locala.abFh.readString();
          AppMethodBeat.o(270267);
          return 0;
        case 5: 
          localcxk.TFV = locala.abFh.readString();
          AppMethodBeat.o(270267);
          return 0;
        case 6: 
          localcxk.pf = locala.abFh.readString();
          AppMethodBeat.o(270267);
          return 0;
        }
        localcxk.TFW = locala.abFh.readString();
        AppMethodBeat.o(270267);
        return 0;
      }
      AppMethodBeat.o(270267);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxk
 * JD-Core Version:    0.7.0.1
 */