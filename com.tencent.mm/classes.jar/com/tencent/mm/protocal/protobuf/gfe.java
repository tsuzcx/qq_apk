package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gfe
  extends com.tencent.mm.bx.a
{
  public String YJY;
  public String accB;
  public String accC;
  public String accD;
  public String mut;
  public String muu;
  public String muv;
  public String muw;
  public String vgW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116822);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YJY != null) {
        paramVarArgs.g(1, this.YJY);
      }
      if (this.muu != null) {
        paramVarArgs.g(2, this.muu);
      }
      if (this.mut != null) {
        paramVarArgs.g(3, this.mut);
      }
      if (this.vgW != null) {
        paramVarArgs.g(4, this.vgW);
      }
      if (this.accB != null) {
        paramVarArgs.g(5, this.accB);
      }
      if (this.muv != null) {
        paramVarArgs.g(6, this.muv);
      }
      if (this.muw != null) {
        paramVarArgs.g(7, this.muw);
      }
      if (this.accC != null) {
        paramVarArgs.g(8, this.accC);
      }
      if (this.accD != null) {
        paramVarArgs.g(9, this.accD);
      }
      AppMethodBeat.o(116822);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YJY == null) {
        break label698;
      }
    }
    label698:
    for (int i = i.a.a.b.b.a.h(1, this.YJY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.muu != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.muu);
      }
      i = paramInt;
      if (this.mut != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.mut);
      }
      paramInt = i;
      if (this.vgW != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.vgW);
      }
      i = paramInt;
      if (this.accB != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.accB);
      }
      paramInt = i;
      if (this.muv != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.muv);
      }
      i = paramInt;
      if (this.muw != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.muw);
      }
      paramInt = i;
      if (this.accC != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.accC);
      }
      i = paramInt;
      if (this.accD != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.accD);
      }
      AppMethodBeat.o(116822);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(116822);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gfe localgfe = (gfe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116822);
          return -1;
        case 1: 
          localgfe.YJY = locala.ajGk.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 2: 
          localgfe.muu = locala.ajGk.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 3: 
          localgfe.mut = locala.ajGk.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 4: 
          localgfe.vgW = locala.ajGk.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 5: 
          localgfe.accB = locala.ajGk.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 6: 
          localgfe.muv = locala.ajGk.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 7: 
          localgfe.muw = locala.ajGk.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 8: 
          localgfe.accC = locala.ajGk.readString();
          AppMethodBeat.o(116822);
          return 0;
        }
        localgfe.accD = locala.ajGk.readString();
        AppMethodBeat.o(116822);
        return 0;
      }
      AppMethodBeat.o(116822);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gfe
 * JD-Core Version:    0.7.0.1
 */