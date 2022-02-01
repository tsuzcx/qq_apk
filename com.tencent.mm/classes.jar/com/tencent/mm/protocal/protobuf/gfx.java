package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class gfx
  extends com.tencent.mm.bx.a
{
  public int YHj;
  public String ZoO;
  public String accI;
  public String accJ;
  public String accK;
  public String accL;
  public String accM;
  public String accN;
  public String kDl;
  public String vgX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32531);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.accI == null)
      {
        paramVarArgs = new b("Not all required fields were included: LocalNodeId");
        AppMethodBeat.o(32531);
        throw paramVarArgs;
      }
      if (this.accI != null) {
        paramVarArgs.g(1, this.accI);
      }
      if (this.vgX != null) {
        paramVarArgs.g(2, this.vgX);
      }
      if (this.accJ != null) {
        paramVarArgs.g(3, this.accJ);
      }
      if (this.kDl != null) {
        paramVarArgs.g(4, this.kDl);
      }
      if (this.accK != null) {
        paramVarArgs.g(5, this.accK);
      }
      if (this.ZoO != null) {
        paramVarArgs.g(6, this.ZoO);
      }
      if (this.accL != null) {
        paramVarArgs.g(7, this.accL);
      }
      if (this.accM != null) {
        paramVarArgs.g(8, this.accM);
      }
      if (this.accN != null) {
        paramVarArgs.g(9, this.accN);
      }
      paramVarArgs.bS(10, this.YHj);
      AppMethodBeat.o(32531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.accI == null) {
        break label810;
      }
    }
    label810:
    for (int i = i.a.a.b.b.a.h(1, this.accI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vgX != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.vgX);
      }
      i = paramInt;
      if (this.accJ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.accJ);
      }
      paramInt = i;
      if (this.kDl != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.kDl);
      }
      i = paramInt;
      if (this.accK != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.accK);
      }
      paramInt = i;
      if (this.ZoO != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZoO);
      }
      i = paramInt;
      if (this.accL != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.accL);
      }
      paramInt = i;
      if (this.accM != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.accM);
      }
      i = paramInt;
      if (this.accN != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.accN);
      }
      paramInt = i.a.a.b.b.a.cJ(10, this.YHj);
      AppMethodBeat.o(32531);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.accI == null)
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
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gfx localgfx = (gfx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32531);
          return -1;
        case 1: 
          localgfx.accI = locala.ajGk.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 2: 
          localgfx.vgX = locala.ajGk.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 3: 
          localgfx.accJ = locala.ajGk.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 4: 
          localgfx.kDl = locala.ajGk.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 5: 
          localgfx.accK = locala.ajGk.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 6: 
          localgfx.ZoO = locala.ajGk.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 7: 
          localgfx.accL = locala.ajGk.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 8: 
          localgfx.accM = locala.ajGk.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 9: 
          localgfx.accN = locala.ajGk.readString();
          AppMethodBeat.o(32531);
          return 0;
        }
        localgfx.YHj = locala.ajGk.aar();
        AppMethodBeat.o(32531);
        return 0;
      }
      AppMethodBeat.o(32531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gfx
 * JD-Core Version:    0.7.0.1
 */