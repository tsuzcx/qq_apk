package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends com.tencent.mm.bw.a
{
  public String HER;
  public String HES;
  public String HET = "0";
  public String HEU = "0";
  public int HEV = 0;
  public int HEW;
  public String HEX;
  public String HEm;
  public String desc;
  public String id;
  public String name;
  public int status;
  public int type;
  public String url;
  public String weappPath;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91303);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.e(1, this.id);
      }
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      if (this.desc != null) {
        paramVarArgs.e(3, this.desc);
      }
      paramVarArgs.aM(4, this.status);
      if (this.url != null) {
        paramVarArgs.e(5, this.url);
      }
      paramVarArgs.aM(6, this.type);
      if (this.HER != null) {
        paramVarArgs.e(7, this.HER);
      }
      if (this.HES != null) {
        paramVarArgs.e(8, this.HES);
      }
      if (this.HET != null) {
        paramVarArgs.e(9, this.HET);
      }
      if (this.HEU != null) {
        paramVarArgs.e(10, this.HEU);
      }
      paramVarArgs.aM(11, this.HEV);
      if (this.HEm != null) {
        paramVarArgs.e(12, this.HEm);
      }
      if (this.weappPath != null) {
        paramVarArgs.e(13, this.weappPath);
      }
      paramVarArgs.aM(14, this.HEW);
      if (this.HEX != null) {
        paramVarArgs.e(15, this.HEX);
      }
      AppMethodBeat.o(91303);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label1010;
      }
    }
    label1010:
    for (int i = g.a.a.b.b.a.f(1, this.id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.name != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.name);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.desc);
      }
      i += g.a.a.b.b.a.bu(4, this.status);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.url);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.type);
      paramInt = i;
      if (this.HER != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.HER);
      }
      i = paramInt;
      if (this.HES != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.HES);
      }
      paramInt = i;
      if (this.HET != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.HET);
      }
      i = paramInt;
      if (this.HEU != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.HEU);
      }
      i += g.a.a.b.b.a.bu(11, this.HEV);
      paramInt = i;
      if (this.HEm != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.HEm);
      }
      i = paramInt;
      if (this.weappPath != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.weappPath);
      }
      i += g.a.a.b.b.a.bu(14, this.HEW);
      paramInt = i;
      if (this.HEX != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.HEX);
      }
      AppMethodBeat.o(91303);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91303);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        q localq = (q)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91303);
          return -1;
        case 1: 
          localq.id = locala.UbS.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 2: 
          localq.name = locala.UbS.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 3: 
          localq.desc = locala.UbS.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 4: 
          localq.status = locala.UbS.zi();
          AppMethodBeat.o(91303);
          return 0;
        case 5: 
          localq.url = locala.UbS.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 6: 
          localq.type = locala.UbS.zi();
          AppMethodBeat.o(91303);
          return 0;
        case 7: 
          localq.HER = locala.UbS.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 8: 
          localq.HES = locala.UbS.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 9: 
          localq.HET = locala.UbS.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 10: 
          localq.HEU = locala.UbS.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 11: 
          localq.HEV = locala.UbS.zi();
          AppMethodBeat.o(91303);
          return 0;
        case 12: 
          localq.HEm = locala.UbS.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 13: 
          localq.weappPath = locala.UbS.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 14: 
          localq.HEW = locala.UbS.zi();
          AppMethodBeat.o(91303);
          return 0;
        }
        localq.HEX = locala.UbS.readString();
        AppMethodBeat.o(91303);
        return 0;
      }
      AppMethodBeat.o(91303);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.q
 * JD-Core Version:    0.7.0.1
 */