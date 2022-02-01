package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gde
  extends com.tencent.mm.bx.a
{
  public String ProductID;
  public String ablY;
  public int acbh;
  public String acbi;
  public String acbj;
  public String acbk;
  public String acbl;
  public String acbm;
  public String hAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32504);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.ProductID != null) {
        paramVarArgs.g(2, this.ProductID);
      }
      paramVarArgs.bS(3, this.acbh);
      if (this.acbi != null) {
        paramVarArgs.g(4, this.acbi);
      }
      if (this.ablY != null) {
        paramVarArgs.g(5, this.ablY);
      }
      if (this.acbj != null) {
        paramVarArgs.g(6, this.acbj);
      }
      if (this.acbk != null) {
        paramVarArgs.g(7, this.acbk);
      }
      if (this.acbl != null) {
        paramVarArgs.g(8, this.acbl);
      }
      if (this.acbm != null) {
        paramVarArgs.g(9, this.acbm);
      }
      AppMethodBeat.o(32504);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label697;
      }
    }
    label697:
    for (paramInt = i.a.a.b.b.a.h(1, this.hAP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ProductID);
      }
      i += i.a.a.b.b.a.cJ(3, this.acbh);
      paramInt = i;
      if (this.acbi != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.acbi);
      }
      i = paramInt;
      if (this.ablY != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ablY);
      }
      paramInt = i;
      if (this.acbj != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.acbj);
      }
      i = paramInt;
      if (this.acbk != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.acbk);
      }
      paramInt = i;
      if (this.acbl != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.acbl);
      }
      i = paramInt;
      if (this.acbm != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.acbm);
      }
      AppMethodBeat.o(32504);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32504);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gde localgde = (gde)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32504);
          return -1;
        case 1: 
          localgde.hAP = locala.ajGk.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 2: 
          localgde.ProductID = locala.ajGk.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 3: 
          localgde.acbh = locala.ajGk.aar();
          AppMethodBeat.o(32504);
          return 0;
        case 4: 
          localgde.acbi = locala.ajGk.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 5: 
          localgde.ablY = locala.ajGk.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 6: 
          localgde.acbj = locala.ajGk.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 7: 
          localgde.acbk = locala.ajGk.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 8: 
          localgde.acbl = locala.ajGk.readString();
          AppMethodBeat.o(32504);
          return 0;
        }
        localgde.acbm = locala.ajGk.readString();
        AppMethodBeat.o(32504);
        return 0;
      }
      AppMethodBeat.o(32504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gde
 * JD-Core Version:    0.7.0.1
 */