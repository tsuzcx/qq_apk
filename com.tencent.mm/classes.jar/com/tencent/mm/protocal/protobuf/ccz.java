package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class ccz
  extends com.tencent.mm.bx.a
{
  public String IcT;
  public String UserName;
  public String aamu;
  public String aamv;
  public b aamw;
  public b aamx;
  public int muC;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257694);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IcT != null) {
        paramVarArgs.g(1, this.IcT);
      }
      if (this.aamu != null) {
        paramVarArgs.g(2, this.aamu);
      }
      if (this.aamv != null) {
        paramVarArgs.g(3, this.aamv);
      }
      paramVarArgs.bS(4, this.muC);
      if (this.aamw != null) {
        paramVarArgs.d(5, this.aamw);
      }
      if (this.oOI != null) {
        paramVarArgs.g(6, this.oOI);
      }
      if (this.UserName != null) {
        paramVarArgs.g(7, this.UserName);
      }
      if (this.aamx != null) {
        paramVarArgs.d(9, this.aamx);
      }
      AppMethodBeat.o(257694);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IcT == null) {
        break label626;
      }
    }
    label626:
    for (int i = i.a.a.b.b.a.h(1, this.IcT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aamu != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aamu);
      }
      i = paramInt;
      if (this.aamv != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aamv);
      }
      i += i.a.a.b.b.a.cJ(4, this.muC);
      paramInt = i;
      if (this.aamw != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.aamw);
      }
      i = paramInt;
      if (this.oOI != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.oOI);
      }
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.UserName);
      }
      i = paramInt;
      if (this.aamx != null) {
        i = paramInt + i.a.a.b.b.a.c(9, this.aamx);
      }
      AppMethodBeat.o(257694);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257694);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ccz localccz = (ccz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 8: 
        default: 
          AppMethodBeat.o(257694);
          return -1;
        case 1: 
          localccz.IcT = locala.ajGk.readString();
          AppMethodBeat.o(257694);
          return 0;
        case 2: 
          localccz.aamu = locala.ajGk.readString();
          AppMethodBeat.o(257694);
          return 0;
        case 3: 
          localccz.aamv = locala.ajGk.readString();
          AppMethodBeat.o(257694);
          return 0;
        case 4: 
          localccz.muC = locala.ajGk.aar();
          AppMethodBeat.o(257694);
          return 0;
        case 5: 
          localccz.aamw = locala.ajGk.kFX();
          AppMethodBeat.o(257694);
          return 0;
        case 6: 
          localccz.oOI = locala.ajGk.readString();
          AppMethodBeat.o(257694);
          return 0;
        case 7: 
          localccz.UserName = locala.ajGk.readString();
          AppMethodBeat.o(257694);
          return 0;
        }
        localccz.aamx = locala.ajGk.kFX();
        AppMethodBeat.o(257694);
        return 0;
      }
      AppMethodBeat.o(257694);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccz
 * JD-Core Version:    0.7.0.1
 */