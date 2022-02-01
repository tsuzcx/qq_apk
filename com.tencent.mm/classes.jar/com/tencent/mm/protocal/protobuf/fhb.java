package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fhb
  extends com.tencent.mm.bx.a
{
  public String abHA;
  public String abHB;
  public int abHw;
  public double abHx;
  public double abHy;
  public int abHz;
  public int fZW;
  public int show_type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257645);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abHw);
      paramVarArgs.bS(2, this.show_type);
      paramVarArgs.d(3, this.abHx);
      paramVarArgs.d(4, this.abHy);
      paramVarArgs.bS(5, this.abHz);
      paramVarArgs.bS(6, this.fZW);
      if (this.abHA != null) {
        paramVarArgs.g(7, this.abHA);
      }
      if (this.abHB != null) {
        paramVarArgs.g(8, this.abHB);
      }
      AppMethodBeat.o(257645);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.abHw) + 0 + i.a.a.b.b.a.cJ(2, this.show_type) + (i.a.a.b.b.a.ko(3) + 8) + (i.a.a.b.b.a.ko(4) + 8) + i.a.a.b.b.a.cJ(5, this.abHz) + i.a.a.b.b.a.cJ(6, this.fZW);
      paramInt = i;
      if (this.abHA != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abHA);
      }
      i = paramInt;
      if (this.abHB != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.abHB);
      }
      AppMethodBeat.o(257645);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257645);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fhb localfhb = (fhb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257645);
        return -1;
      case 1: 
        localfhb.abHw = locala.ajGk.aar();
        AppMethodBeat.o(257645);
        return 0;
      case 2: 
        localfhb.show_type = locala.ajGk.aar();
        AppMethodBeat.o(257645);
        return 0;
      case 3: 
        localfhb.abHx = Double.longBitsToDouble(locala.ajGk.aay());
        AppMethodBeat.o(257645);
        return 0;
      case 4: 
        localfhb.abHy = Double.longBitsToDouble(locala.ajGk.aay());
        AppMethodBeat.o(257645);
        return 0;
      case 5: 
        localfhb.abHz = locala.ajGk.aar();
        AppMethodBeat.o(257645);
        return 0;
      case 6: 
        localfhb.fZW = locala.ajGk.aar();
        AppMethodBeat.o(257645);
        return 0;
      case 7: 
        localfhb.abHA = locala.ajGk.readString();
        AppMethodBeat.o(257645);
        return 0;
      }
      localfhb.abHB = locala.ajGk.readString();
      AppMethodBeat.o(257645);
      return 0;
    }
    AppMethodBeat.o(257645);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhb
 * JD-Core Version:    0.7.0.1
 */