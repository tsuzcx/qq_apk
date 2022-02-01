package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gdi
  extends com.tencent.mm.bx.a
{
  public String IGG;
  public String IHZ;
  public String ProductID;
  public int YFu;
  public String ablY;
  public String acbr;
  public String hAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32508);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.ablY != null) {
        paramVarArgs.g(2, this.ablY);
      }
      if (this.IHZ != null) {
        paramVarArgs.g(3, this.IHZ);
      }
      if (this.IGG != null) {
        paramVarArgs.g(4, this.IGG);
      }
      if (this.acbr != null) {
        paramVarArgs.g(5, this.acbr);
      }
      paramVarArgs.bS(6, this.YFu);
      if (this.ProductID != null) {
        paramVarArgs.g(7, this.ProductID);
      }
      AppMethodBeat.o(32508);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label571;
      }
    }
    label571:
    for (int i = i.a.a.b.b.a.h(1, this.hAP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ablY != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ablY);
      }
      i = paramInt;
      if (this.IHZ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IHZ);
      }
      paramInt = i;
      if (this.IGG != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IGG);
      }
      i = paramInt;
      if (this.acbr != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.acbr);
      }
      i += i.a.a.b.b.a.cJ(6, this.YFu);
      paramInt = i;
      if (this.ProductID != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.ProductID);
      }
      AppMethodBeat.o(32508);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32508);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gdi localgdi = (gdi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32508);
          return -1;
        case 1: 
          localgdi.hAP = locala.ajGk.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 2: 
          localgdi.ablY = locala.ajGk.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 3: 
          localgdi.IHZ = locala.ajGk.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 4: 
          localgdi.IGG = locala.ajGk.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 5: 
          localgdi.acbr = locala.ajGk.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 6: 
          localgdi.YFu = locala.ajGk.aar();
          AppMethodBeat.o(32508);
          return 0;
        }
        localgdi.ProductID = locala.ajGk.readString();
        AppMethodBeat.o(32508);
        return 0;
      }
      AppMethodBeat.o(32508);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gdi
 * JD-Core Version:    0.7.0.1
 */