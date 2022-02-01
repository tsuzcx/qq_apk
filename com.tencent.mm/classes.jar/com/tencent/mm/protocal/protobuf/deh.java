package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class deh
  extends com.tencent.mm.bw.a
{
  public String FNF;
  public String MD5;
  public String Title;
  public String URL;
  public String uuJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32451);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.URL != null) {
        paramVarArgs.d(1, this.URL);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.FNF != null) {
        paramVarArgs.d(3, this.FNF);
      }
      if (this.uuJ != null) {
        paramVarArgs.d(4, this.uuJ);
      }
      if (this.MD5 != null) {
        paramVarArgs.d(5, this.MD5);
      }
      AppMethodBeat.o(32451);
      return 0;
    }
    if (paramInt == 1) {
      if (this.URL == null) {
        break label465;
      }
    }
    label465:
    for (int i = f.a.a.b.b.a.e(1, this.URL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.FNF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FNF);
      }
      paramInt = i;
      if (this.uuJ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uuJ);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.MD5);
      }
      AppMethodBeat.o(32451);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32451);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        deh localdeh = (deh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32451);
          return -1;
        case 1: 
          localdeh.URL = locala.OmT.readString();
          AppMethodBeat.o(32451);
          return 0;
        case 2: 
          localdeh.Title = locala.OmT.readString();
          AppMethodBeat.o(32451);
          return 0;
        case 3: 
          localdeh.FNF = locala.OmT.readString();
          AppMethodBeat.o(32451);
          return 0;
        case 4: 
          localdeh.uuJ = locala.OmT.readString();
          AppMethodBeat.o(32451);
          return 0;
        }
        localdeh.MD5 = locala.OmT.readString();
        AppMethodBeat.o(32451);
        return 0;
      }
      AppMethodBeat.o(32451);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.deh
 * JD-Core Version:    0.7.0.1
 */