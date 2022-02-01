package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dek
  extends com.tencent.mm.bx.a
{
  public String Poo;
  public int aaJT;
  public LinkedList<String> aaJU;
  public String scope;
  
  public dek()
  {
    AppMethodBeat.i(82449);
    this.aaJU = new LinkedList();
    AppMethodBeat.o(82449);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82450);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.g(1, this.scope);
      }
      paramVarArgs.bS(2, this.aaJT);
      if (this.Poo != null) {
        paramVarArgs.g(3, this.Poo);
      }
      paramVarArgs.e(4, 1, this.aaJU);
      AppMethodBeat.o(82450);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label374;
      }
    }
    label374:
    for (paramInt = i.a.a.b.b.a.h(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aaJT);
      paramInt = i;
      if (this.Poo != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.Poo);
      }
      i = i.a.a.a.c(4, 1, this.aaJU);
      AppMethodBeat.o(82450);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaJU.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(82450);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dek localdek = (dek)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82450);
          return -1;
        case 1: 
          localdek.scope = locala.ajGk.readString();
          AppMethodBeat.o(82450);
          return 0;
        case 2: 
          localdek.aaJT = locala.ajGk.aar();
          AppMethodBeat.o(82450);
          return 0;
        case 3: 
          localdek.Poo = locala.ajGk.readString();
          AppMethodBeat.o(82450);
          return 0;
        }
        localdek.aaJU.add(locala.ajGk.readString());
        AppMethodBeat.o(82450);
        return 0;
      }
      AppMethodBeat.o(82450);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dek
 * JD-Core Version:    0.7.0.1
 */