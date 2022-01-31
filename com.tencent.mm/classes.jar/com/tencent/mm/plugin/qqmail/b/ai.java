package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class ai
  extends com.tencent.mm.bv.a
{
  public String name;
  public long pKF;
  public String pKG;
  public String path;
  public long size;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(68075);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.path == null)
      {
        paramVarArgs = new b("Not all required fields were included: path");
        AppMethodBeat.o(68075);
        throw paramVarArgs;
      }
      if (this.name == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(68075);
        throw paramVarArgs;
      }
      if (this.path != null) {
        paramVarArgs.e(1, this.path);
      }
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      paramVarArgs.am(3, this.size);
      paramVarArgs.aO(4, this.state);
      paramVarArgs.am(5, this.pKF);
      if (this.pKG != null) {
        paramVarArgs.e(6, this.pKG);
      }
      AppMethodBeat.o(68075);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = e.a.a.b.b.a.f(1, this.path) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.name != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.name);
      }
      i = i + e.a.a.b.b.a.p(3, this.size) + e.a.a.b.b.a.bl(4, this.state) + e.a.a.b.b.a.p(5, this.pKF);
      paramInt = i;
      if (this.pKG != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.pKG);
      }
      AppMethodBeat.o(68075);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.path == null)
        {
          paramVarArgs = new b("Not all required fields were included: path");
          AppMethodBeat.o(68075);
          throw paramVarArgs;
        }
        if (this.name == null)
        {
          paramVarArgs = new b("Not all required fields were included: name");
          AppMethodBeat.o(68075);
          throw paramVarArgs;
        }
        AppMethodBeat.o(68075);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ai localai = (ai)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(68075);
          return -1;
        case 1: 
          localai.path = locala.CLY.readString();
          AppMethodBeat.o(68075);
          return 0;
        case 2: 
          localai.name = locala.CLY.readString();
          AppMethodBeat.o(68075);
          return 0;
        case 3: 
          localai.size = locala.CLY.sm();
          AppMethodBeat.o(68075);
          return 0;
        case 4: 
          localai.state = locala.CLY.sl();
          AppMethodBeat.o(68075);
          return 0;
        case 5: 
          localai.pKF = locala.CLY.sm();
          AppMethodBeat.o(68075);
          return 0;
        }
        localai.pKG = locala.CLY.readString();
        AppMethodBeat.o(68075);
        return 0;
      }
      AppMethodBeat.o(68075);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.ai
 * JD-Core Version:    0.7.0.1
 */