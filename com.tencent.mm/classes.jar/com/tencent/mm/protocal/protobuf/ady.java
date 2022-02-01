package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ady
  extends com.tencent.mm.bx.a
{
  public String Zme;
  public String Zmf;
  public LinkedList<doq> Zmg;
  
  public ady()
  {
    AppMethodBeat.i(116467);
    this.Zmg = new LinkedList();
    AppMethodBeat.o(116467);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116468);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zme != null) {
        paramVarArgs.g(1, this.Zme);
      }
      if (this.Zmf != null) {
        paramVarArgs.g(2, this.Zmf);
      }
      paramVarArgs.e(3, 8, this.Zmg);
      AppMethodBeat.o(116468);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zme == null) {
        break label392;
      }
    }
    label392:
    for (paramInt = i.a.a.b.b.a.h(1, this.Zme) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Zmf != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Zmf);
      }
      paramInt = i.a.a.a.c(3, 8, this.Zmg);
      AppMethodBeat.o(116468);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Zmg.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(116468);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ady localady = (ady)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116468);
          return -1;
        case 1: 
          localady.Zme = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116468);
          return 0;
        case 2: 
          localady.Zmf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116468);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          doq localdoq = new doq();
          if ((localObject != null) && (localObject.length > 0)) {
            localdoq.parseFrom((byte[])localObject);
          }
          localady.Zmg.add(localdoq);
          paramInt += 1;
        }
        AppMethodBeat.o(116468);
        return 0;
      }
      AppMethodBeat.o(116468);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ady
 * JD-Core Version:    0.7.0.1
 */