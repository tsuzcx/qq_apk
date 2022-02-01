package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class doy
  extends com.tencent.mm.bx.a
{
  public String UserName;
  public String ZhO;
  public String ZhP;
  public int aaVH;
  public int aaVI;
  public int pSf;
  public String pSg;
  public String pSh;
  public String pSi;
  public String pSo;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32348);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      paramVarArgs.bS(2, this.vhJ);
      paramVarArgs.bS(3, this.pSf);
      if (this.pSh != null) {
        paramVarArgs.g(4, this.pSh);
      }
      if (this.pSg != null) {
        paramVarArgs.g(5, this.pSg);
      }
      if (this.pSi != null) {
        paramVarArgs.g(6, this.pSi);
      }
      paramVarArgs.bS(7, this.aaVH);
      paramVarArgs.bS(8, this.aaVI);
      if (this.pSo != null) {
        paramVarArgs.g(9, this.pSo);
      }
      if (this.ZhO != null) {
        paramVarArgs.g(10, this.ZhO);
      }
      if (this.ZhP != null) {
        paramVarArgs.g(11, this.ZhP);
      }
      AppMethodBeat.o(32348);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label771;
      }
    }
    label771:
    for (paramInt = i.a.a.b.b.a.h(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.vhJ) + i.a.a.b.b.a.cJ(3, this.pSf);
      paramInt = i;
      if (this.pSh != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.pSh);
      }
      i = paramInt;
      if (this.pSg != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.pSg);
      }
      paramInt = i;
      if (this.pSi != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.pSi);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.aaVH) + i.a.a.b.b.a.cJ(8, this.aaVI);
      paramInt = i;
      if (this.pSo != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.pSo);
      }
      i = paramInt;
      if (this.ZhO != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.ZhO);
      }
      paramInt = i;
      if (this.ZhP != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.ZhP);
      }
      AppMethodBeat.o(32348);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32348);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        doy localdoy = (doy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32348);
          return -1;
        case 1: 
          localdoy.UserName = locala.ajGk.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 2: 
          localdoy.vhJ = locala.ajGk.aar();
          AppMethodBeat.o(32348);
          return 0;
        case 3: 
          localdoy.pSf = locala.ajGk.aar();
          AppMethodBeat.o(32348);
          return 0;
        case 4: 
          localdoy.pSh = locala.ajGk.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 5: 
          localdoy.pSg = locala.ajGk.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 6: 
          localdoy.pSi = locala.ajGk.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 7: 
          localdoy.aaVH = locala.ajGk.aar();
          AppMethodBeat.o(32348);
          return 0;
        case 8: 
          localdoy.aaVI = locala.ajGk.aar();
          AppMethodBeat.o(32348);
          return 0;
        case 9: 
          localdoy.pSo = locala.ajGk.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 10: 
          localdoy.ZhO = locala.ajGk.readString();
          AppMethodBeat.o(32348);
          return 0;
        }
        localdoy.ZhP = locala.ajGk.readString();
        AppMethodBeat.o(32348);
        return 0;
      }
      AppMethodBeat.o(32348);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doy
 * JD-Core Version:    0.7.0.1
 */