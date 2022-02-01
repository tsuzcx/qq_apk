package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzi
  extends com.tencent.mm.bx.a
{
  public int CRV;
  public String Dol;
  public String FUP;
  public String abed;
  public String abee;
  public String feedID;
  public String sessionBuffer;
  public String userName;
  public String zIO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257521);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abed != null) {
        paramVarArgs.g(1, this.abed);
      }
      if (this.feedID != null) {
        paramVarArgs.g(2, this.feedID);
      }
      if (this.userName != null) {
        paramVarArgs.g(3, this.userName);
      }
      if (this.FUP != null) {
        paramVarArgs.g(4, this.FUP);
      }
      if (this.Dol != null) {
        paramVarArgs.g(5, this.Dol);
      }
      if (this.zIO != null) {
        paramVarArgs.g(6, this.zIO);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.g(7, this.sessionBuffer);
      }
      paramVarArgs.bS(8, this.CRV);
      if (this.abee != null) {
        paramVarArgs.g(9, this.abee);
      }
      AppMethodBeat.o(257521);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abed == null) {
        break label682;
      }
    }
    label682:
    for (int i = i.a.a.b.b.a.h(1, this.abed) + 0;; i = 0)
    {
      paramInt = i;
      if (this.feedID != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.feedID);
      }
      i = paramInt;
      if (this.userName != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.userName);
      }
      paramInt = i;
      if (this.FUP != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.FUP);
      }
      i = paramInt;
      if (this.Dol != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.Dol);
      }
      paramInt = i;
      if (this.zIO != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.zIO);
      }
      i = paramInt;
      if (this.sessionBuffer != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.sessionBuffer);
      }
      i += i.a.a.b.b.a.cJ(8, this.CRV);
      paramInt = i;
      if (this.abee != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.abee);
      }
      AppMethodBeat.o(257521);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257521);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dzi localdzi = (dzi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257521);
          return -1;
        case 1: 
          localdzi.abed = locala.ajGk.readString();
          AppMethodBeat.o(257521);
          return 0;
        case 2: 
          localdzi.feedID = locala.ajGk.readString();
          AppMethodBeat.o(257521);
          return 0;
        case 3: 
          localdzi.userName = locala.ajGk.readString();
          AppMethodBeat.o(257521);
          return 0;
        case 4: 
          localdzi.FUP = locala.ajGk.readString();
          AppMethodBeat.o(257521);
          return 0;
        case 5: 
          localdzi.Dol = locala.ajGk.readString();
          AppMethodBeat.o(257521);
          return 0;
        case 6: 
          localdzi.zIO = locala.ajGk.readString();
          AppMethodBeat.o(257521);
          return 0;
        case 7: 
          localdzi.sessionBuffer = locala.ajGk.readString();
          AppMethodBeat.o(257521);
          return 0;
        case 8: 
          localdzi.CRV = locala.ajGk.aar();
          AppMethodBeat.o(257521);
          return 0;
        }
        localdzi.abee = locala.ajGk.readString();
        AppMethodBeat.o(257521);
        return 0;
      }
      AppMethodBeat.o(257521);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzi
 * JD-Core Version:    0.7.0.1
 */