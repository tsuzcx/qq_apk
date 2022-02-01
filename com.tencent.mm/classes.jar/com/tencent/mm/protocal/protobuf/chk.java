package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class chk
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public String CNj;
  public String ToN;
  public String ToO;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152610);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ToN != null) {
        paramVarArgs.f(1, this.ToN);
      }
      if (this.CNj != null) {
        paramVarArgs.f(2, this.CNj);
      }
      if (this.fwr != null) {
        paramVarArgs.f(3, this.fwr);
      }
      if (this.CMB != null) {
        paramVarArgs.f(4, this.CMB);
      }
      if (this.ToO != null) {
        paramVarArgs.f(5, this.ToO);
      }
      AppMethodBeat.o(152610);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ToN == null) {
        break label454;
      }
    }
    label454:
    for (int i = g.a.a.b.b.a.g(1, this.ToN) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CNj != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CNj);
      }
      i = paramInt;
      if (this.fwr != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fwr);
      }
      paramInt = i;
      if (this.CMB != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CMB);
      }
      i = paramInt;
      if (this.ToO != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.ToO);
      }
      AppMethodBeat.o(152610);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152610);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        chk localchk = (chk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152610);
          return -1;
        case 1: 
          localchk.ToN = locala.abFh.readString();
          AppMethodBeat.o(152610);
          return 0;
        case 2: 
          localchk.CNj = locala.abFh.readString();
          AppMethodBeat.o(152610);
          return 0;
        case 3: 
          localchk.fwr = locala.abFh.readString();
          AppMethodBeat.o(152610);
          return 0;
        case 4: 
          localchk.CMB = locala.abFh.readString();
          AppMethodBeat.o(152610);
          return 0;
        }
        localchk.ToO = locala.abFh.readString();
        AppMethodBeat.o(152610);
        return 0;
      }
      AppMethodBeat.o(152610);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chk
 * JD-Core Version:    0.7.0.1
 */