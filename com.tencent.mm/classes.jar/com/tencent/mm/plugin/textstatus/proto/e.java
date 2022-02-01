package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.cd.a
{
  public String MER;
  public String MES;
  public String MET;
  public LinkedList<String> MEU;
  
  public e()
  {
    AppMethodBeat.i(243812);
    this.MEU = new LinkedList();
    AppMethodBeat.o(243812);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243813);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MER != null) {
        paramVarArgs.f(1, this.MER);
      }
      if (this.MES != null) {
        paramVarArgs.f(2, this.MES);
      }
      if (this.MET != null) {
        paramVarArgs.f(3, this.MET);
      }
      paramVarArgs.e(4, 1, this.MEU);
      AppMethodBeat.o(243813);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MER == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.g(1, this.MER) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MES != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.MES);
      }
      i = paramInt;
      if (this.MET != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.MET);
      }
      paramInt = g.a.a.a.c(4, 1, this.MEU);
      AppMethodBeat.o(243813);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MEU.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(243813);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(243813);
          return -1;
        case 1: 
          locale.MER = locala.abFh.readString();
          AppMethodBeat.o(243813);
          return 0;
        case 2: 
          locale.MES = locala.abFh.readString();
          AppMethodBeat.o(243813);
          return 0;
        case 3: 
          locale.MET = locala.abFh.readString();
          AppMethodBeat.o(243813);
          return 0;
        }
        locale.MEU.add(locala.abFh.readString());
        AppMethodBeat.o(243813);
        return 0;
      }
      AppMethodBeat.o(243813);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.e
 * JD-Core Version:    0.7.0.1
 */