package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dar
  extends com.tencent.mm.bx.a
{
  public String IKJ;
  public String Url;
  public String ZjC;
  public String aaGk;
  public String aaGl;
  public String aaGm;
  public String aaGn;
  public int aaGo;
  public String aaGp;
  public String hAP;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32327);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.aaGk != null) {
        paramVarArgs.g(2, this.aaGk);
      }
      paramVarArgs.bS(3, this.vhJ);
      if (this.Url != null) {
        paramVarArgs.g(4, this.Url);
      }
      if (this.aaGl != null) {
        paramVarArgs.g(5, this.aaGl);
      }
      if (this.ZjC != null) {
        paramVarArgs.g(6, this.ZjC);
      }
      if (this.aaGm != null) {
        paramVarArgs.g(7, this.aaGm);
      }
      if (this.IKJ != null) {
        paramVarArgs.g(8, this.IKJ);
      }
      if (this.aaGn != null) {
        paramVarArgs.g(9, this.aaGn);
      }
      paramVarArgs.bS(10, this.aaGo);
      if (this.aaGp != null) {
        paramVarArgs.g(11, this.aaGp);
      }
      AppMethodBeat.o(32327);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label807;
      }
    }
    label807:
    for (paramInt = i.a.a.b.b.a.h(1, this.hAP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaGk != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.aaGk);
      }
      i += i.a.a.b.b.a.cJ(3, this.vhJ);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Url);
      }
      i = paramInt;
      if (this.aaGl != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaGl);
      }
      paramInt = i;
      if (this.ZjC != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZjC);
      }
      i = paramInt;
      if (this.aaGm != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aaGm);
      }
      paramInt = i;
      if (this.IKJ != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.IKJ);
      }
      i = paramInt;
      if (this.aaGn != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.aaGn);
      }
      i += i.a.a.b.b.a.cJ(10, this.aaGo);
      paramInt = i;
      if (this.aaGp != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.aaGp);
      }
      AppMethodBeat.o(32327);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32327);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dar localdar = (dar)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32327);
          return -1;
        case 1: 
          localdar.hAP = locala.ajGk.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 2: 
          localdar.aaGk = locala.ajGk.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 3: 
          localdar.vhJ = locala.ajGk.aar();
          AppMethodBeat.o(32327);
          return 0;
        case 4: 
          localdar.Url = locala.ajGk.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 5: 
          localdar.aaGl = locala.ajGk.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 6: 
          localdar.ZjC = locala.ajGk.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 7: 
          localdar.aaGm = locala.ajGk.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 8: 
          localdar.IKJ = locala.ajGk.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 9: 
          localdar.aaGn = locala.ajGk.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 10: 
          localdar.aaGo = locala.ajGk.aar();
          AppMethodBeat.o(32327);
          return 0;
        }
        localdar.aaGp = locala.ajGk.readString();
        AppMethodBeat.o(32327);
        return 0;
      }
      AppMethodBeat.o(32327);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dar
 * JD-Core Version:    0.7.0.1
 */