package com.tencent.mm.plugin.wallet.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends com.tencent.mm.bx.a
{
  public String VlV;
  public String VlW;
  public String VlX = "0";
  public String VlY = "0";
  public int VlZ = 0;
  public String Vlq;
  public int Vma;
  public String Vmb;
  public String desc;
  public String id;
  public String nUS;
  public String name;
  public int status;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91303);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.g(1, this.id);
      }
      if (this.name != null) {
        paramVarArgs.g(2, this.name);
      }
      if (this.desc != null) {
        paramVarArgs.g(3, this.desc);
      }
      paramVarArgs.bS(4, this.status);
      if (this.url != null) {
        paramVarArgs.g(5, this.url);
      }
      paramVarArgs.bS(6, this.type);
      if (this.VlV != null) {
        paramVarArgs.g(7, this.VlV);
      }
      if (this.VlW != null) {
        paramVarArgs.g(8, this.VlW);
      }
      if (this.VlX != null) {
        paramVarArgs.g(9, this.VlX);
      }
      if (this.VlY != null) {
        paramVarArgs.g(10, this.VlY);
      }
      paramVarArgs.bS(11, this.VlZ);
      if (this.Vlq != null) {
        paramVarArgs.g(12, this.Vlq);
      }
      if (this.nUS != null) {
        paramVarArgs.g(13, this.nUS);
      }
      paramVarArgs.bS(14, this.Vma);
      if (this.Vmb != null) {
        paramVarArgs.g(15, this.Vmb);
      }
      AppMethodBeat.o(91303);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label1006;
      }
    }
    label1006:
    for (int i = i.a.a.b.b.a.h(1, this.id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.name != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.name);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.desc);
      }
      i += i.a.a.b.b.a.cJ(4, this.status);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.url);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.type);
      paramInt = i;
      if (this.VlV != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.VlV);
      }
      i = paramInt;
      if (this.VlW != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.VlW);
      }
      paramInt = i;
      if (this.VlX != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.VlX);
      }
      i = paramInt;
      if (this.VlY != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.VlY);
      }
      i += i.a.a.b.b.a.cJ(11, this.VlZ);
      paramInt = i;
      if (this.Vlq != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.Vlq);
      }
      i = paramInt;
      if (this.nUS != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.nUS);
      }
      i += i.a.a.b.b.a.cJ(14, this.Vma);
      paramInt = i;
      if (this.Vmb != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.Vmb);
      }
      AppMethodBeat.o(91303);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91303);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        o localo = (o)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91303);
          return -1;
        case 1: 
          localo.id = locala.ajGk.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 2: 
          localo.name = locala.ajGk.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 3: 
          localo.desc = locala.ajGk.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 4: 
          localo.status = locala.ajGk.aar();
          AppMethodBeat.o(91303);
          return 0;
        case 5: 
          localo.url = locala.ajGk.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 6: 
          localo.type = locala.ajGk.aar();
          AppMethodBeat.o(91303);
          return 0;
        case 7: 
          localo.VlV = locala.ajGk.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 8: 
          localo.VlW = locala.ajGk.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 9: 
          localo.VlX = locala.ajGk.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 10: 
          localo.VlY = locala.ajGk.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 11: 
          localo.VlZ = locala.ajGk.aar();
          AppMethodBeat.o(91303);
          return 0;
        case 12: 
          localo.Vlq = locala.ajGk.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 13: 
          localo.nUS = locala.ajGk.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 14: 
          localo.Vma = locala.ajGk.aar();
          AppMethodBeat.o(91303);
          return 0;
        }
        localo.Vmb = locala.ajGk.readString();
        AppMethodBeat.o(91303);
        return 0;
      }
      AppMethodBeat.o(91303);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.model.o
 * JD-Core Version:    0.7.0.1
 */