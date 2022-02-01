package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dva
  extends com.tencent.mm.cd.a
{
  public long RWK;
  public String SRj;
  public String Ubj;
  public int cUP;
  public String zaX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206356);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.zaX != null) {
        paramVarArgs.f(1, this.zaX);
      }
      paramVarArgs.bm(2, this.RWK);
      paramVarArgs.aY(3, this.cUP);
      if (this.SRj != null) {
        paramVarArgs.f(4, this.SRj);
      }
      if (this.Ubj != null) {
        paramVarArgs.f(5, this.Ubj);
      }
      AppMethodBeat.o(206356);
      return 0;
    }
    if (paramInt == 1) {
      if (this.zaX == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.b.b.a.g(1, this.zaX) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.RWK) + g.a.a.b.b.a.bM(3, this.cUP);
      paramInt = i;
      if (this.SRj != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SRj);
      }
      i = paramInt;
      if (this.Ubj != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Ubj);
      }
      AppMethodBeat.o(206356);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(206356);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dva localdva = (dva)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(206356);
          return -1;
        case 1: 
          localdva.zaX = locala.abFh.readString();
          AppMethodBeat.o(206356);
          return 0;
        case 2: 
          localdva.RWK = locala.abFh.AN();
          AppMethodBeat.o(206356);
          return 0;
        case 3: 
          localdva.cUP = locala.abFh.AK();
          AppMethodBeat.o(206356);
          return 0;
        case 4: 
          localdva.SRj = locala.abFh.readString();
          AppMethodBeat.o(206356);
          return 0;
        }
        localdva.Ubj = locala.abFh.readString();
        AppMethodBeat.o(206356);
        return 0;
      }
      AppMethodBeat.o(206356);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dva
 * JD-Core Version:    0.7.0.1
 */