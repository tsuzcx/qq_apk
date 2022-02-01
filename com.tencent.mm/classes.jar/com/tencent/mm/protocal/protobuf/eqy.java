package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class eqy
  extends com.tencent.mm.bw.a
{
  public boolean GAH;
  public String IFw;
  public long duration;
  public String iiv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201304);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.IFw == null)
      {
        paramVarArgs = new b("Not all required fields were included: templatePath");
        AppMethodBeat.o(201304);
        throw paramVarArgs;
      }
      if (this.iiv == null)
      {
        paramVarArgs = new b("Not all required fields were included: musicPath");
        AppMethodBeat.o(201304);
        throw paramVarArgs;
      }
      if (this.IFw != null) {
        paramVarArgs.e(1, this.IFw);
      }
      if (this.iiv != null) {
        paramVarArgs.e(2, this.iiv);
      }
      paramVarArgs.bb(3, this.duration);
      paramVarArgs.cc(4, this.GAH);
      AppMethodBeat.o(201304);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IFw == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = g.a.a.b.b.a.f(1, this.IFw) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.iiv != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.iiv);
      }
      paramInt = g.a.a.b.b.a.r(3, this.duration);
      int j = g.a.a.b.b.a.fS(4);
      AppMethodBeat.o(201304);
      return i + paramInt + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.IFw == null)
        {
          paramVarArgs = new b("Not all required fields were included: templatePath");
          AppMethodBeat.o(201304);
          throw paramVarArgs;
        }
        if (this.iiv == null)
        {
          paramVarArgs = new b("Not all required fields were included: musicPath");
          AppMethodBeat.o(201304);
          throw paramVarArgs;
        }
        AppMethodBeat.o(201304);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eqy localeqy = (eqy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(201304);
          return -1;
        case 1: 
          localeqy.IFw = locala.UbS.readString();
          AppMethodBeat.o(201304);
          return 0;
        case 2: 
          localeqy.iiv = locala.UbS.readString();
          AppMethodBeat.o(201304);
          return 0;
        case 3: 
          localeqy.duration = locala.UbS.zl();
          AppMethodBeat.o(201304);
          return 0;
        }
        localeqy.GAH = locala.UbS.yZ();
        AppMethodBeat.o(201304);
        return 0;
      }
      AppMethodBeat.o(201304);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqy
 * JD-Core Version:    0.7.0.1
 */