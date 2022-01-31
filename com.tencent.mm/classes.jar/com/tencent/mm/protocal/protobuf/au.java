package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class au
  extends com.tencent.mm.bv.a
{
  public String IconUrl;
  public String Name;
  public int jKs;
  public String ntu;
  public String puI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56696);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Name != null) {
        paramVarArgs.e(1, this.Name);
      }
      if (this.puI != null) {
        paramVarArgs.e(2, this.puI);
      }
      paramVarArgs.aO(3, this.jKs);
      if (this.ntu != null) {
        paramVarArgs.e(4, this.ntu);
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(5, this.IconUrl);
      }
      AppMethodBeat.o(56696);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = e.a.a.b.b.a.f(1, this.Name) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.puI != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.puI);
      }
      i += e.a.a.b.b.a.bl(3, this.jKs);
      paramInt = i;
      if (this.ntu != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.ntu);
      }
      i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.IconUrl);
      }
      AppMethodBeat.o(56696);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56696);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        au localau = (au)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56696);
          return -1;
        case 1: 
          localau.Name = locala.CLY.readString();
          AppMethodBeat.o(56696);
          return 0;
        case 2: 
          localau.puI = locala.CLY.readString();
          AppMethodBeat.o(56696);
          return 0;
        case 3: 
          localau.jKs = locala.CLY.sl();
          AppMethodBeat.o(56696);
          return 0;
        case 4: 
          localau.ntu = locala.CLY.readString();
          AppMethodBeat.o(56696);
          return 0;
        }
        localau.IconUrl = locala.CLY.readString();
        AppMethodBeat.o(56696);
        return 0;
      }
      AppMethodBeat.o(56696);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.au
 * JD-Core Version:    0.7.0.1
 */