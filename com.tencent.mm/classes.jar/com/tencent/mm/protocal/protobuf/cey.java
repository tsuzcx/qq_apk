package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cey
  extends com.tencent.mm.bw.a
{
  public String CYp;
  public int Mkv;
  public LinkedList<String> Mkw;
  public String scope;
  
  public cey()
  {
    AppMethodBeat.i(82449);
    this.Mkw = new LinkedList();
    AppMethodBeat.o(82449);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82450);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.e(1, this.scope);
      }
      paramVarArgs.aM(2, this.Mkv);
      if (this.CYp != null) {
        paramVarArgs.e(3, this.CYp);
      }
      paramVarArgs.e(4, 1, this.Mkw);
      AppMethodBeat.o(82450);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = g.a.a.b.b.a.f(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.Mkv);
      paramInt = i;
      if (this.CYp != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.CYp);
      }
      i = g.a.a.a.c(4, 1, this.Mkw);
      AppMethodBeat.o(82450);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Mkw.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(82450);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cey localcey = (cey)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82450);
          return -1;
        case 1: 
          localcey.scope = locala.UbS.readString();
          AppMethodBeat.o(82450);
          return 0;
        case 2: 
          localcey.Mkv = locala.UbS.zi();
          AppMethodBeat.o(82450);
          return 0;
        case 3: 
          localcey.CYp = locala.UbS.readString();
          AppMethodBeat.o(82450);
          return 0;
        }
        localcey.Mkw.add(locala.UbS.readString());
        AppMethodBeat.o(82450);
        return 0;
      }
      AppMethodBeat.o(82450);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cey
 * JD-Core Version:    0.7.0.1
 */