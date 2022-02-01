package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class eys
  extends com.tencent.mm.bw.a
{
  public int KIy;
  public String Lox;
  public String Nvp;
  public String Nvq;
  public String Nvr;
  public String Nvs;
  public String Nvt;
  public String Nvu;
  public String fMj;
  public String oTJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32531);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nvp == null)
      {
        paramVarArgs = new b("Not all required fields were included: LocalNodeId");
        AppMethodBeat.o(32531);
        throw paramVarArgs;
      }
      if (this.Nvp != null) {
        paramVarArgs.e(1, this.Nvp);
      }
      if (this.oTJ != null) {
        paramVarArgs.e(2, this.oTJ);
      }
      if (this.Nvq != null) {
        paramVarArgs.e(3, this.Nvq);
      }
      if (this.fMj != null) {
        paramVarArgs.e(4, this.fMj);
      }
      if (this.Nvr != null) {
        paramVarArgs.e(5, this.Nvr);
      }
      if (this.Lox != null) {
        paramVarArgs.e(6, this.Lox);
      }
      if (this.Nvs != null) {
        paramVarArgs.e(7, this.Nvs);
      }
      if (this.Nvt != null) {
        paramVarArgs.e(8, this.Nvt);
      }
      if (this.Nvu != null) {
        paramVarArgs.e(9, this.Nvu);
      }
      paramVarArgs.aM(10, this.KIy);
      AppMethodBeat.o(32531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Nvp == null) {
        break label814;
      }
    }
    label814:
    for (int i = g.a.a.b.b.a.f(1, this.Nvp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oTJ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.oTJ);
      }
      i = paramInt;
      if (this.Nvq != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Nvq);
      }
      paramInt = i;
      if (this.fMj != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.fMj);
      }
      i = paramInt;
      if (this.Nvr != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Nvr);
      }
      paramInt = i;
      if (this.Lox != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Lox);
      }
      i = paramInt;
      if (this.Nvs != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Nvs);
      }
      paramInt = i;
      if (this.Nvt != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Nvt);
      }
      i = paramInt;
      if (this.Nvu != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.Nvu);
      }
      paramInt = g.a.a.b.b.a.bu(10, this.KIy);
      AppMethodBeat.o(32531);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Nvp == null)
        {
          paramVarArgs = new b("Not all required fields were included: LocalNodeId");
          AppMethodBeat.o(32531);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32531);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eys localeys = (eys)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32531);
          return -1;
        case 1: 
          localeys.Nvp = locala.UbS.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 2: 
          localeys.oTJ = locala.UbS.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 3: 
          localeys.Nvq = locala.UbS.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 4: 
          localeys.fMj = locala.UbS.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 5: 
          localeys.Nvr = locala.UbS.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 6: 
          localeys.Lox = locala.UbS.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 7: 
          localeys.Nvs = locala.UbS.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 8: 
          localeys.Nvt = locala.UbS.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 9: 
          localeys.Nvu = locala.UbS.readString();
          AppMethodBeat.o(32531);
          return 0;
        }
        localeys.KIy = locala.UbS.zi();
        AppMethodBeat.o(32531);
        return 0;
      }
      AppMethodBeat.o(32531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eys
 * JD-Core Version:    0.7.0.1
 */