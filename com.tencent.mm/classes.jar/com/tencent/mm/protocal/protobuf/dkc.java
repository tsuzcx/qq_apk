package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dkc
  extends com.tencent.mm.bx.a
{
  public String UUID;
  public String UserName;
  public String YOy;
  public String aaPV;
  public int aaPW;
  public int aaiS;
  public String vhX;
  public int vhk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259532);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UUID != null) {
        paramVarArgs.g(1, this.UUID);
      }
      paramVarArgs.bS(2, this.vhk);
      if (this.UserName != null) {
        paramVarArgs.g(3, this.UserName);
      }
      if (this.YOy != null) {
        paramVarArgs.g(4, this.YOy);
      }
      if (this.aaPV != null) {
        paramVarArgs.g(5, this.aaPV);
      }
      paramVarArgs.bS(6, this.aaPW);
      if (this.vhX != null) {
        paramVarArgs.g(7, this.vhX);
      }
      paramVarArgs.bS(8, this.aaiS);
      AppMethodBeat.o(259532);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UUID == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = i.a.a.b.b.a.h(1, this.UUID) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.vhk);
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.UserName);
      }
      i = paramInt;
      if (this.YOy != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.YOy);
      }
      paramInt = i;
      if (this.aaPV != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aaPV);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.aaPW);
      paramInt = i;
      if (this.vhX != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.vhX);
      }
      i = i.a.a.b.b.a.cJ(8, this.aaiS);
      AppMethodBeat.o(259532);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259532);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dkc localdkc = (dkc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259532);
          return -1;
        case 1: 
          localdkc.UUID = locala.ajGk.readString();
          AppMethodBeat.o(259532);
          return 0;
        case 2: 
          localdkc.vhk = locala.ajGk.aar();
          AppMethodBeat.o(259532);
          return 0;
        case 3: 
          localdkc.UserName = locala.ajGk.readString();
          AppMethodBeat.o(259532);
          return 0;
        case 4: 
          localdkc.YOy = locala.ajGk.readString();
          AppMethodBeat.o(259532);
          return 0;
        case 5: 
          localdkc.aaPV = locala.ajGk.readString();
          AppMethodBeat.o(259532);
          return 0;
        case 6: 
          localdkc.aaPW = locala.ajGk.aar();
          AppMethodBeat.o(259532);
          return 0;
        case 7: 
          localdkc.vhX = locala.ajGk.readString();
          AppMethodBeat.o(259532);
          return 0;
        }
        localdkc.aaiS = locala.ajGk.aar();
        AppMethodBeat.o(259532);
        return 0;
      }
      AppMethodBeat.o(259532);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkc
 * JD-Core Version:    0.7.0.1
 */