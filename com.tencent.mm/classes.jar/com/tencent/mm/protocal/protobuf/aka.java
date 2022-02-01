package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aka
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public String Sus;
  public String Tet;
  public String Teu;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104775);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      if (this.Sus != null) {
        paramVarArgs.f(2, this.Sus);
      }
      if (this.Tet != null) {
        paramVarArgs.f(3, this.Tet);
      }
      if (this.CMB != null) {
        paramVarArgs.f(4, this.CMB);
      }
      if (this.Teu != null) {
        paramVarArgs.f(5, this.Teu);
      }
      AppMethodBeat.o(104775);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label454;
      }
    }
    label454:
    for (int i = g.a.a.b.b.a.g(1, this.fwr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Sus != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Sus);
      }
      i = paramInt;
      if (this.Tet != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Tet);
      }
      paramInt = i;
      if (this.CMB != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CMB);
      }
      i = paramInt;
      if (this.Teu != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Teu);
      }
      AppMethodBeat.o(104775);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(104775);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aka localaka = (aka)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104775);
          return -1;
        case 1: 
          localaka.fwr = locala.abFh.readString();
          AppMethodBeat.o(104775);
          return 0;
        case 2: 
          localaka.Sus = locala.abFh.readString();
          AppMethodBeat.o(104775);
          return 0;
        case 3: 
          localaka.Tet = locala.abFh.readString();
          AppMethodBeat.o(104775);
          return 0;
        case 4: 
          localaka.CMB = locala.abFh.readString();
          AppMethodBeat.o(104775);
          return 0;
        }
        localaka.Teu = locala.abFh.readString();
        AppMethodBeat.o(104775);
        return 0;
      }
      AppMethodBeat.o(104775);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aka
 * JD-Core Version:    0.7.0.1
 */