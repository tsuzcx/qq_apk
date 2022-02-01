package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dib
  extends com.tencent.mm.bx.a
{
  public String OzQ;
  public String UserName;
  public String ZhO;
  public String ZhP;
  public String aant;
  public String vhX;
  public int vhk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155433);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.OzQ != null) {
        paramVarArgs.g(1, this.OzQ);
      }
      if (this.UserName != null) {
        paramVarArgs.g(2, this.UserName);
      }
      paramVarArgs.bS(3, this.vhk);
      if (this.ZhO != null) {
        paramVarArgs.g(4, this.ZhO);
      }
      if (this.ZhP != null) {
        paramVarArgs.g(5, this.ZhP);
      }
      if (this.vhX != null) {
        paramVarArgs.g(6, this.vhX);
      }
      if (this.aant != null) {
        paramVarArgs.g(7, this.aant);
      }
      AppMethodBeat.o(155433);
      return 0;
    }
    if (paramInt == 1) {
      if (this.OzQ == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = i.a.a.b.b.a.h(1, this.OzQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UserName != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.UserName);
      }
      i += i.a.a.b.b.a.cJ(3, this.vhk);
      paramInt = i;
      if (this.ZhO != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZhO);
      }
      i = paramInt;
      if (this.ZhP != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZhP);
      }
      paramInt = i;
      if (this.vhX != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.vhX);
      }
      i = paramInt;
      if (this.aant != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aant);
      }
      AppMethodBeat.o(155433);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(155433);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dib localdib = (dib)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(155433);
          return -1;
        case 1: 
          localdib.OzQ = locala.ajGk.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 2: 
          localdib.UserName = locala.ajGk.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 3: 
          localdib.vhk = locala.ajGk.aar();
          AppMethodBeat.o(155433);
          return 0;
        case 4: 
          localdib.ZhO = locala.ajGk.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 5: 
          localdib.ZhP = locala.ajGk.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 6: 
          localdib.vhX = locala.ajGk.readString();
          AppMethodBeat.o(155433);
          return 0;
        }
        localdib.aant = locala.ajGk.readString();
        AppMethodBeat.o(155433);
        return 0;
      }
      AppMethodBeat.o(155433);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dib
 * JD-Core Version:    0.7.0.1
 */