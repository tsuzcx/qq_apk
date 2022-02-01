package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class sh
  extends com.tencent.mm.cd.a
{
  public int LhN;
  public int LhO;
  public int SbK;
  public String SbL;
  public String SbM;
  public String SbN;
  public int Sbw;
  public String aeskey;
  public String jEd;
  public int length;
  public String md5;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(247713);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.aeskey == null)
      {
        paramVarArgs = new b("Not all required fields were included: aeskey");
        AppMethodBeat.o(247713);
        throw paramVarArgs;
      }
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(247713);
        throw paramVarArgs;
      }
      if (this.aeskey != null) {
        paramVarArgs.f(1, this.aeskey);
      }
      if (this.url != null) {
        paramVarArgs.f(2, this.url);
      }
      paramVarArgs.aY(3, this.type);
      paramVarArgs.aY(4, this.length);
      paramVarArgs.aY(5, this.SbK);
      if (this.SbL != null) {
        paramVarArgs.f(6, this.SbL);
      }
      if (this.jEd != null) {
        paramVarArgs.f(7, this.jEd);
      }
      paramVarArgs.aY(8, this.Sbw);
      paramVarArgs.aY(9, this.LhN);
      paramVarArgs.aY(10, this.LhO);
      if (this.md5 != null) {
        paramVarArgs.f(11, this.md5);
      }
      if (this.SbM != null) {
        paramVarArgs.f(12, this.SbM);
      }
      if (this.SbN != null) {
        paramVarArgs.f(13, this.SbN);
      }
      AppMethodBeat.o(247713);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aeskey == null) {
        break label942;
      }
    }
    label942:
    for (paramInt = g.a.a.b.b.a.g(1, this.aeskey) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.url);
      }
      i = i + g.a.a.b.b.a.bM(3, this.type) + g.a.a.b.b.a.bM(4, this.length) + g.a.a.b.b.a.bM(5, this.SbK);
      paramInt = i;
      if (this.SbL != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SbL);
      }
      i = paramInt;
      if (this.jEd != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.jEd);
      }
      i = i + g.a.a.b.b.a.bM(8, this.Sbw) + g.a.a.b.b.a.bM(9, this.LhN) + g.a.a.b.b.a.bM(10, this.LhO);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.md5);
      }
      i = paramInt;
      if (this.SbM != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.SbM);
      }
      paramInt = i;
      if (this.SbN != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.SbN);
      }
      AppMethodBeat.o(247713);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.aeskey == null)
        {
          paramVarArgs = new b("Not all required fields were included: aeskey");
          AppMethodBeat.o(247713);
          throw paramVarArgs;
        }
        if (this.url == null)
        {
          paramVarArgs = new b("Not all required fields were included: url");
          AppMethodBeat.o(247713);
          throw paramVarArgs;
        }
        AppMethodBeat.o(247713);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        sh localsh = (sh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(247713);
          return -1;
        case 1: 
          localsh.aeskey = locala.abFh.readString();
          AppMethodBeat.o(247713);
          return 0;
        case 2: 
          localsh.url = locala.abFh.readString();
          AppMethodBeat.o(247713);
          return 0;
        case 3: 
          localsh.type = locala.abFh.AK();
          AppMethodBeat.o(247713);
          return 0;
        case 4: 
          localsh.length = locala.abFh.AK();
          AppMethodBeat.o(247713);
          return 0;
        case 5: 
          localsh.SbK = locala.abFh.AK();
          AppMethodBeat.o(247713);
          return 0;
        case 6: 
          localsh.SbL = locala.abFh.readString();
          AppMethodBeat.o(247713);
          return 0;
        case 7: 
          localsh.jEd = locala.abFh.readString();
          AppMethodBeat.o(247713);
          return 0;
        case 8: 
          localsh.Sbw = locala.abFh.AK();
          AppMethodBeat.o(247713);
          return 0;
        case 9: 
          localsh.LhN = locala.abFh.AK();
          AppMethodBeat.o(247713);
          return 0;
        case 10: 
          localsh.LhO = locala.abFh.AK();
          AppMethodBeat.o(247713);
          return 0;
        case 11: 
          localsh.md5 = locala.abFh.readString();
          AppMethodBeat.o(247713);
          return 0;
        case 12: 
          localsh.SbM = locala.abFh.readString();
          AppMethodBeat.o(247713);
          return 0;
        }
        localsh.SbN = locala.abFh.readString();
        AppMethodBeat.o(247713);
        return 0;
      }
      AppMethodBeat.o(247713);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sh
 * JD-Core Version:    0.7.0.1
 */