package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ef
  extends com.tencent.mm.bw.a
{
  public String FOA;
  public String FOB;
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
      if (this.FOA != null) {
        paramVarArgs.d(2, this.FOA);
      }
      if (this.FOB != null) {
        paramVarArgs.d(3, this.FOB);
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
      if (this.FOA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FOA);
      }
      i = paramInt;
      if (this.FOB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FOB);
      }
      AppMethodBeat.o(50079);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
        ef localef = (ef)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50079);
          return -1;
        case 1: 
          localef.content = locala.OmT.readString();
          AppMethodBeat.o(50079);
          return 0;
        case 2: 
          localef.FOA = locala.OmT.readString();
          AppMethodBeat.o(50079);
          return 0;
        }
        localef.FOB = locala.OmT.readString();
        AppMethodBeat.o(50079);
        return 0;
      }
      AppMethodBeat.o(50079);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ef
 * JD-Core Version:    0.7.0.1
 */