package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gcf
  extends com.tencent.mm.bx.a
{
  public float YEL;
  public String Zoi;
  public String acao;
  public String acap;
  public String acaq;
  public int acar;
  public float acas;
  public String acat;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147791);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acao != null) {
        paramVarArgs.g(1, this.acao);
      }
      if (this.Zoi != null) {
        paramVarArgs.g(2, this.Zoi);
      }
      if (this.acap != null) {
        paramVarArgs.g(3, this.acap);
      }
      if (this.acaq != null) {
        paramVarArgs.g(4, this.acaq);
      }
      paramVarArgs.bS(5, this.acar);
      paramVarArgs.l(6, this.YEL);
      paramVarArgs.l(7, this.acas);
      if (this.acat != null) {
        paramVarArgs.g(8, this.acat);
      }
      AppMethodBeat.o(147791);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acao == null) {
        break label588;
      }
    }
    label588:
    for (int i = i.a.a.b.b.a.h(1, this.acao) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Zoi != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Zoi);
      }
      i = paramInt;
      if (this.acap != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.acap);
      }
      paramInt = i;
      if (this.acaq != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.acaq);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.acar) + (i.a.a.b.b.a.ko(6) + 4) + (i.a.a.b.b.a.ko(7) + 4);
      paramInt = i;
      if (this.acat != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.acat);
      }
      AppMethodBeat.o(147791);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(147791);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gcf localgcf = (gcf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147791);
          return -1;
        case 1: 
          localgcf.acao = locala.ajGk.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 2: 
          localgcf.Zoi = locala.ajGk.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 3: 
          localgcf.acap = locala.ajGk.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 4: 
          localgcf.acaq = locala.ajGk.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 5: 
          localgcf.acar = locala.ajGk.aar();
          AppMethodBeat.o(147791);
          return 0;
        case 6: 
          localgcf.YEL = Float.intBitsToFloat(locala.ajGk.aax());
          AppMethodBeat.o(147791);
          return 0;
        case 7: 
          localgcf.acas = Float.intBitsToFloat(locala.ajGk.aax());
          AppMethodBeat.o(147791);
          return 0;
        }
        localgcf.acat = locala.ajGk.readString();
        AppMethodBeat.o(147791);
        return 0;
      }
      AppMethodBeat.o(147791);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gcf
 * JD-Core Version:    0.7.0.1
 */