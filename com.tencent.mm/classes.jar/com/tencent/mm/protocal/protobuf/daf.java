package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class daf
  extends com.tencent.mm.bx.a
{
  public String Zje;
  public long Zqa;
  public int aaFH;
  public long aaFI;
  public long aaFJ;
  public String aatc;
  public String icon;
  public int tNW;
  public String wtN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72504);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zje != null) {
        paramVarArgs.g(1, this.Zje);
      }
      paramVarArgs.bv(2, this.Zqa);
      paramVarArgs.bS(3, this.aaFH);
      paramVarArgs.bv(4, this.aaFI);
      paramVarArgs.bv(5, this.aaFJ);
      if (this.aatc != null) {
        paramVarArgs.g(6, this.aatc);
      }
      if (this.wtN != null) {
        paramVarArgs.g(7, this.wtN);
      }
      paramVarArgs.bS(8, this.tNW);
      if (this.icon != null) {
        paramVarArgs.g(9, this.icon);
      }
      AppMethodBeat.o(72504);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zje == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = i.a.a.b.b.a.h(1, this.Zje) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.Zqa) + i.a.a.b.b.a.cJ(3, this.aaFH) + i.a.a.b.b.a.q(4, this.aaFI) + i.a.a.b.b.a.q(5, this.aaFJ);
      paramInt = i;
      if (this.aatc != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aatc);
      }
      i = paramInt;
      if (this.wtN != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.wtN);
      }
      i += i.a.a.b.b.a.cJ(8, this.tNW);
      paramInt = i;
      if (this.icon != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.icon);
      }
      AppMethodBeat.o(72504);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72504);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        daf localdaf = (daf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72504);
          return -1;
        case 1: 
          localdaf.Zje = locala.ajGk.readString();
          AppMethodBeat.o(72504);
          return 0;
        case 2: 
          localdaf.Zqa = locala.ajGk.aaw();
          AppMethodBeat.o(72504);
          return 0;
        case 3: 
          localdaf.aaFH = locala.ajGk.aar();
          AppMethodBeat.o(72504);
          return 0;
        case 4: 
          localdaf.aaFI = locala.ajGk.aaw();
          AppMethodBeat.o(72504);
          return 0;
        case 5: 
          localdaf.aaFJ = locala.ajGk.aaw();
          AppMethodBeat.o(72504);
          return 0;
        case 6: 
          localdaf.aatc = locala.ajGk.readString();
          AppMethodBeat.o(72504);
          return 0;
        case 7: 
          localdaf.wtN = locala.ajGk.readString();
          AppMethodBeat.o(72504);
          return 0;
        case 8: 
          localdaf.tNW = locala.ajGk.aar();
          AppMethodBeat.o(72504);
          return 0;
        }
        localdaf.icon = locala.ajGk.readString();
        AppMethodBeat.o(72504);
        return 0;
      }
      AppMethodBeat.o(72504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.daf
 * JD-Core Version:    0.7.0.1
 */