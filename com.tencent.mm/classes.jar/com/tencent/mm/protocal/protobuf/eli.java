package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eli
  extends com.tencent.mm.bw.a
{
  public String ANo;
  public String KNs;
  public String KNt;
  public String dDj;
  public String iwv;
  public String ynT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72615);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dDj != null) {
        paramVarArgs.e(1, this.dDj);
      }
      if (this.iwv != null) {
        paramVarArgs.e(2, this.iwv);
      }
      if (this.ynT != null) {
        paramVarArgs.e(3, this.ynT);
      }
      if (this.ANo != null) {
        paramVarArgs.e(4, this.ANo);
      }
      if (this.KNs != null) {
        paramVarArgs.e(5, this.KNs);
      }
      if (this.KNt != null) {
        paramVarArgs.e(6, this.KNt);
      }
      AppMethodBeat.o(72615);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dDj == null) {
        break label518;
      }
    }
    label518:
    for (int i = g.a.a.b.b.a.f(1, this.dDj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iwv != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.iwv);
      }
      i = paramInt;
      if (this.ynT != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.ynT);
      }
      paramInt = i;
      if (this.ANo != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.ANo);
      }
      i = paramInt;
      if (this.KNs != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KNs);
      }
      paramInt = i;
      if (this.KNt != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KNt);
      }
      AppMethodBeat.o(72615);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72615);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eli localeli = (eli)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72615);
          return -1;
        case 1: 
          localeli.dDj = locala.UbS.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 2: 
          localeli.iwv = locala.UbS.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 3: 
          localeli.ynT = locala.UbS.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 4: 
          localeli.ANo = locala.UbS.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 5: 
          localeli.KNs = locala.UbS.readString();
          AppMethodBeat.o(72615);
          return 0;
        }
        localeli.KNt = locala.UbS.readString();
        AppMethodBeat.o(72615);
        return 0;
      }
      AppMethodBeat.o(72615);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eli
 * JD-Core Version:    0.7.0.1
 */