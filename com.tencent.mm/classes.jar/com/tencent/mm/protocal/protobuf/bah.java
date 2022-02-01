package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bah
  extends com.tencent.mm.cd.a
{
  public String SMl;
  public boolean SMm;
  public String SMn;
  public String SMo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230719);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SMl != null) {
        paramVarArgs.f(1, this.SMl);
      }
      paramVarArgs.co(2, this.SMm);
      if (this.SMn != null) {
        paramVarArgs.f(3, this.SMn);
      }
      if (this.SMo != null) {
        paramVarArgs.f(4, this.SMo);
      }
      AppMethodBeat.o(230719);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SMl == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = g.a.a.b.b.a.g(1, this.SMl) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.gL(2) + 1);
      paramInt = i;
      if (this.SMn != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SMn);
      }
      i = paramInt;
      if (this.SMo != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.SMo);
      }
      AppMethodBeat.o(230719);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230719);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bah localbah = (bah)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(230719);
          return -1;
        case 1: 
          localbah.SMl = locala.abFh.readString();
          AppMethodBeat.o(230719);
          return 0;
        case 2: 
          localbah.SMm = locala.abFh.AB();
          AppMethodBeat.o(230719);
          return 0;
        case 3: 
          localbah.SMn = locala.abFh.readString();
          AppMethodBeat.o(230719);
          return 0;
        }
        localbah.SMo = locala.abFh.readString();
        AppMethodBeat.o(230719);
        return 0;
      }
      AppMethodBeat.o(230719);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bah
 * JD-Core Version:    0.7.0.1
 */