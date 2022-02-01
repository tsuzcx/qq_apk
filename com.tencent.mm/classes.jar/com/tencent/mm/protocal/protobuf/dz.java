package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dz
  extends com.tencent.mm.bx.a
{
  public String Cyo;
  public String Cyp;
  public String content;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50079);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.content == null)
      {
        paramVarArgs = new b("Not all required fields were included: content");
        AppMethodBeat.o(50079);
        throw paramVarArgs;
      }
      if (this.content != null) {
        paramVarArgs.d(1, this.content);
      }
      if (this.Cyo != null) {
        paramVarArgs.d(2, this.Cyo);
      }
      if (this.Cyp != null) {
        paramVarArgs.d(3, this.Cyp);
      }
      AppMethodBeat.o(50079);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label382;
      }
    }
    label382:
    for (int i = f.a.a.b.b.a.e(1, this.content) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Cyo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Cyo);
      }
      i = paramInt;
      if (this.Cyp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Cyp);
      }
      AppMethodBeat.o(50079);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.content == null)
        {
          paramVarArgs = new b("Not all required fields were included: content");
          AppMethodBeat.o(50079);
          throw paramVarArgs;
        }
        AppMethodBeat.o(50079);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dz localdz = (dz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50079);
          return -1;
        case 1: 
          localdz.content = locala.KhF.readString();
          AppMethodBeat.o(50079);
          return 0;
        case 2: 
          localdz.Cyo = locala.KhF.readString();
          AppMethodBeat.o(50079);
          return 0;
        }
        localdz.Cyp = locala.KhF.readString();
        AppMethodBeat.o(50079);
        return 0;
      }
      AppMethodBeat.o(50079);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dz
 * JD-Core Version:    0.7.0.1
 */