package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends com.tencent.mm.cd.a
{
  public String OwK;
  public String OwL;
  public String OwM = "0";
  public String OwN = "0";
  public int OwO = 0;
  public int OwP;
  public String OwQ;
  public String Owf;
  public String desc;
  public String id;
  public String lpQ;
  public String name;
  public int status;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91303);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.f(1, this.id);
      }
      if (this.name != null) {
        paramVarArgs.f(2, this.name);
      }
      if (this.desc != null) {
        paramVarArgs.f(3, this.desc);
      }
      paramVarArgs.aY(4, this.status);
      if (this.url != null) {
        paramVarArgs.f(5, this.url);
      }
      paramVarArgs.aY(6, this.type);
      if (this.OwK != null) {
        paramVarArgs.f(7, this.OwK);
      }
      if (this.OwL != null) {
        paramVarArgs.f(8, this.OwL);
      }
      if (this.OwM != null) {
        paramVarArgs.f(9, this.OwM);
      }
      if (this.OwN != null) {
        paramVarArgs.f(10, this.OwN);
      }
      paramVarArgs.aY(11, this.OwO);
      if (this.Owf != null) {
        paramVarArgs.f(12, this.Owf);
      }
      if (this.lpQ != null) {
        paramVarArgs.f(13, this.lpQ);
      }
      paramVarArgs.aY(14, this.OwP);
      if (this.OwQ != null) {
        paramVarArgs.f(15, this.OwQ);
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
    for (int i = g.a.a.b.b.a.g(1, this.id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.name != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.name);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.desc);
      }
      i += g.a.a.b.b.a.bM(4, this.status);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.url);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.type);
      paramInt = i;
      if (this.OwK != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.OwK);
      }
      i = paramInt;
      if (this.OwL != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.OwL);
      }
      paramInt = i;
      if (this.OwM != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.OwM);
      }
      i = paramInt;
      if (this.OwN != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.OwN);
      }
      i += g.a.a.b.b.a.bM(11, this.OwO);
      paramInt = i;
      if (this.Owf != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.Owf);
      }
      i = paramInt;
      if (this.lpQ != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.lpQ);
      }
      i += g.a.a.b.b.a.bM(14, this.OwP);
      paramInt = i;
      if (this.OwQ != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.OwQ);
      }
      AppMethodBeat.o(91303);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
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
          localq.id = locala.abFh.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 2: 
          localq.name = locala.abFh.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 3: 
          localq.desc = locala.abFh.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 4: 
          localq.status = locala.abFh.AK();
          AppMethodBeat.o(91303);
          return 0;
        case 5: 
          localq.url = locala.abFh.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 6: 
          localq.type = locala.abFh.AK();
          AppMethodBeat.o(91303);
          return 0;
        case 7: 
          localq.OwK = locala.abFh.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 8: 
          localq.OwL = locala.abFh.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 9: 
          localq.OwM = locala.abFh.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 10: 
          localq.OwN = locala.abFh.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 11: 
          localq.OwO = locala.abFh.AK();
          AppMethodBeat.o(91303);
          return 0;
        case 12: 
          localq.Owf = locala.abFh.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 13: 
          localq.lpQ = locala.abFh.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 14: 
          localq.OwP = locala.abFh.AK();
          AppMethodBeat.o(91303);
          return 0;
        }
        localq.OwQ = locala.abFh.readString();
        AppMethodBeat.o(91303);
        return 0;
      }
      AppMethodBeat.o(91303);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.q
 * JD-Core Version:    0.7.0.1
 */