package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class bfc
  extends com.tencent.mm.bx.a
{
  public String dpf;
  public String dvs;
  public String iHA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152580);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iHA == null)
      {
        paramVarArgs = new b("Not all required fields were included: tp_username");
        AppMethodBeat.o(152580);
        throw paramVarArgs;
      }
      if (this.iHA != null) {
        paramVarArgs.d(1, this.iHA);
      }
      if (this.dvs != null) {
        paramVarArgs.d(2, this.dvs);
      }
      if (this.dpf != null) {
        paramVarArgs.d(3, this.dpf);
      }
      AppMethodBeat.o(152580);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iHA == null) {
        break label382;
      }
    }
    label382:
    for (int i = f.a.a.b.b.a.e(1, this.iHA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dvs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dvs);
      }
      i = paramInt;
      if (this.dpf != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dpf);
      }
      AppMethodBeat.o(152580);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.iHA == null)
        {
          paramVarArgs = new b("Not all required fields were included: tp_username");
          AppMethodBeat.o(152580);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152580);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bfc localbfc = (bfc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152580);
          return -1;
        case 1: 
          localbfc.iHA = locala.NPN.readString();
          AppMethodBeat.o(152580);
          return 0;
        case 2: 
          localbfc.dvs = locala.NPN.readString();
          AppMethodBeat.o(152580);
          return 0;
        }
        localbfc.dpf = locala.NPN.readString();
        AppMethodBeat.o(152580);
        return 0;
      }
      AppMethodBeat.o(152580);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfc
 * JD-Core Version:    0.7.0.1
 */