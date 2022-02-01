package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxq
  extends com.tencent.mm.bx.a
{
  public int Idd;
  public String UserName;
  public String YNO;
  public String aaCZ;
  public String aaDa;
  public String aant;
  public String vhX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155421);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YNO != null) {
        paramVarArgs.g(1, this.YNO);
      }
      if (this.UserName != null) {
        paramVarArgs.g(2, this.UserName);
      }
      if (this.aaCZ != null) {
        paramVarArgs.g(3, this.aaCZ);
      }
      if (this.aaDa != null) {
        paramVarArgs.g(4, this.aaDa);
      }
      paramVarArgs.bS(5, this.Idd);
      if (this.vhX != null) {
        paramVarArgs.g(6, this.vhX);
      }
      if (this.aant != null) {
        paramVarArgs.g(7, this.aant);
      }
      AppMethodBeat.o(155421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YNO == null) {
        break label558;
      }
    }
    label558:
    for (int i = i.a.a.b.b.a.h(1, this.YNO) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.UserName);
      }
      i = paramInt;
      if (this.aaCZ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaCZ);
      }
      paramInt = i;
      if (this.aaDa != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaDa);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.Idd);
      paramInt = i;
      if (this.vhX != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.vhX);
      }
      i = paramInt;
      if (this.aant != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aant);
      }
      AppMethodBeat.o(155421);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(155421);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cxq localcxq = (cxq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(155421);
          return -1;
        case 1: 
          localcxq.YNO = locala.ajGk.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 2: 
          localcxq.UserName = locala.ajGk.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 3: 
          localcxq.aaCZ = locala.ajGk.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 4: 
          localcxq.aaDa = locala.ajGk.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 5: 
          localcxq.Idd = locala.ajGk.aar();
          AppMethodBeat.o(155421);
          return 0;
        case 6: 
          localcxq.vhX = locala.ajGk.readString();
          AppMethodBeat.o(155421);
          return 0;
        }
        localcxq.aant = locala.ajGk.readString();
        AppMethodBeat.o(155421);
        return 0;
      }
      AppMethodBeat.o(155421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxq
 * JD-Core Version:    0.7.0.1
 */