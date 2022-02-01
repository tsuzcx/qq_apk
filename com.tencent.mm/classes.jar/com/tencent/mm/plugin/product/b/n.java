package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bx.a
{
  public String MRI;
  public String appid;
  public int eQp;
  public String name;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91282);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      if (this.name != null) {
        paramVarArgs.g(2, this.name);
      }
      if (this.MRI != null) {
        paramVarArgs.g(3, this.MRI);
      }
      if (this.username != null) {
        paramVarArgs.g(4, this.username);
      }
      paramVarArgs.bS(5, this.eQp);
      AppMethodBeat.o(91282);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label434;
      }
    }
    label434:
    for (int i = i.a.a.b.b.a.h(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.name != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.name);
      }
      i = paramInt;
      if (this.MRI != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.MRI);
      }
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.username);
      }
      i = i.a.a.b.b.a.cJ(5, this.eQp);
      AppMethodBeat.o(91282);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91282);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91282);
          return -1;
        case 1: 
          localn.appid = locala.ajGk.readString();
          AppMethodBeat.o(91282);
          return 0;
        case 2: 
          localn.name = locala.ajGk.readString();
          AppMethodBeat.o(91282);
          return 0;
        case 3: 
          localn.MRI = locala.ajGk.readString();
          AppMethodBeat.o(91282);
          return 0;
        case 4: 
          localn.username = locala.ajGk.readString();
          AppMethodBeat.o(91282);
          return 0;
        }
        localn.eQp = locala.ajGk.aar();
        AppMethodBeat.o(91282);
        return 0;
      }
      AppMethodBeat.o(91282);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.n
 * JD-Core Version:    0.7.0.1
 */