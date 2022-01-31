package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String fjP;
  public String id;
  public String name;
  public int status;
  public String tTY;
  public String tUE;
  public String tUF;
  public String tUG = "0";
  public String tUH = "0";
  public int tUI = 0;
  public int tUJ;
  public String tUK;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56660);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.e(1, this.id);
      }
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      if (this.desc != null) {
        paramVarArgs.e(3, this.desc);
      }
      paramVarArgs.aO(4, this.status);
      if (this.url != null) {
        paramVarArgs.e(5, this.url);
      }
      paramVarArgs.aO(6, this.type);
      if (this.tUE != null) {
        paramVarArgs.e(7, this.tUE);
      }
      if (this.tUF != null) {
        paramVarArgs.e(8, this.tUF);
      }
      if (this.tUG != null) {
        paramVarArgs.e(9, this.tUG);
      }
      if (this.tUH != null) {
        paramVarArgs.e(10, this.tUH);
      }
      paramVarArgs.aO(11, this.tUI);
      if (this.tTY != null) {
        paramVarArgs.e(12, this.tTY);
      }
      if (this.fjP != null) {
        paramVarArgs.e(13, this.fjP);
      }
      paramVarArgs.aO(14, this.tUJ);
      if (this.tUK != null) {
        paramVarArgs.e(15, this.tUK);
      }
      AppMethodBeat.o(56660);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label1010;
      }
    }
    label1010:
    for (int i = e.a.a.b.b.a.f(1, this.id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.name != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.name);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.desc);
      }
      i += e.a.a.b.b.a.bl(4, this.status);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.url);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.type);
      paramInt = i;
      if (this.tUE != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.tUE);
      }
      i = paramInt;
      if (this.tUF != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.tUF);
      }
      paramInt = i;
      if (this.tUG != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.tUG);
      }
      i = paramInt;
      if (this.tUH != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.tUH);
      }
      i += e.a.a.b.b.a.bl(11, this.tUI);
      paramInt = i;
      if (this.tTY != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.tTY);
      }
      i = paramInt;
      if (this.fjP != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.fjP);
      }
      i += e.a.a.b.b.a.bl(14, this.tUJ);
      paramInt = i;
      if (this.tUK != null) {
        paramInt = i + e.a.a.b.b.a.f(15, this.tUK);
      }
      AppMethodBeat.o(56660);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56660);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        q localq = (q)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56660);
          return -1;
        case 1: 
          localq.id = locala.CLY.readString();
          AppMethodBeat.o(56660);
          return 0;
        case 2: 
          localq.name = locala.CLY.readString();
          AppMethodBeat.o(56660);
          return 0;
        case 3: 
          localq.desc = locala.CLY.readString();
          AppMethodBeat.o(56660);
          return 0;
        case 4: 
          localq.status = locala.CLY.sl();
          AppMethodBeat.o(56660);
          return 0;
        case 5: 
          localq.url = locala.CLY.readString();
          AppMethodBeat.o(56660);
          return 0;
        case 6: 
          localq.type = locala.CLY.sl();
          AppMethodBeat.o(56660);
          return 0;
        case 7: 
          localq.tUE = locala.CLY.readString();
          AppMethodBeat.o(56660);
          return 0;
        case 8: 
          localq.tUF = locala.CLY.readString();
          AppMethodBeat.o(56660);
          return 0;
        case 9: 
          localq.tUG = locala.CLY.readString();
          AppMethodBeat.o(56660);
          return 0;
        case 10: 
          localq.tUH = locala.CLY.readString();
          AppMethodBeat.o(56660);
          return 0;
        case 11: 
          localq.tUI = locala.CLY.sl();
          AppMethodBeat.o(56660);
          return 0;
        case 12: 
          localq.tTY = locala.CLY.readString();
          AppMethodBeat.o(56660);
          return 0;
        case 13: 
          localq.fjP = locala.CLY.readString();
          AppMethodBeat.o(56660);
          return 0;
        case 14: 
          localq.tUJ = locala.CLY.sl();
          AppMethodBeat.o(56660);
          return 0;
        }
        localq.tUK = locala.CLY.readString();
        AppMethodBeat.o(56660);
        return 0;
      }
      AppMethodBeat.o(56660);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.q
 * JD-Core Version:    0.7.0.1
 */