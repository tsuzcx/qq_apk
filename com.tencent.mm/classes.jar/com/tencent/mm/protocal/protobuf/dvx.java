package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dvx
  extends com.tencent.mm.bx.a
{
  public boolean BHz;
  public String DCE;
  public long duration;
  public String hml;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215811);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DCE == null)
      {
        paramVarArgs = new b("Not all required fields were included: templatePath");
        AppMethodBeat.o(215811);
        throw paramVarArgs;
      }
      if (this.hml == null)
      {
        paramVarArgs = new b("Not all required fields were included: musicPath");
        AppMethodBeat.o(215811);
        throw paramVarArgs;
      }
      if (this.DCE != null) {
        paramVarArgs.d(1, this.DCE);
      }
      if (this.hml != null) {
        paramVarArgs.d(2, this.hml);
      }
      paramVarArgs.aY(3, this.duration);
      paramVarArgs.bt(4, this.BHz);
      AppMethodBeat.o(215811);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DCE == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = f.a.a.b.b.a.e(1, this.DCE) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hml != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hml);
      }
      paramInt = f.a.a.b.b.a.p(3, this.duration);
      int j = f.a.a.b.b.a.alV(4);
      AppMethodBeat.o(215811);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.DCE == null)
        {
          paramVarArgs = new b("Not all required fields were included: templatePath");
          AppMethodBeat.o(215811);
          throw paramVarArgs;
        }
        if (this.hml == null)
        {
          paramVarArgs = new b("Not all required fields were included: musicPath");
          AppMethodBeat.o(215811);
          throw paramVarArgs;
        }
        AppMethodBeat.o(215811);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dvx localdvx = (dvx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(215811);
          return -1;
        case 1: 
          localdvx.DCE = locala.NPN.readString();
          AppMethodBeat.o(215811);
          return 0;
        case 2: 
          localdvx.hml = locala.NPN.readString();
          AppMethodBeat.o(215811);
          return 0;
        case 3: 
          localdvx.duration = locala.NPN.zd();
          AppMethodBeat.o(215811);
          return 0;
        }
        localdvx.BHz = locala.NPN.grw();
        AppMethodBeat.o(215811);
        return 0;
      }
      AppMethodBeat.o(215811);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvx
 * JD-Core Version:    0.7.0.1
 */