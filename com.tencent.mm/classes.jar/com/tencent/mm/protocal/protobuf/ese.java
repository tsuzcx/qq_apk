package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public class ese
  extends com.tencent.mm.cd.a
{
  public long KcG;
  public String POG;
  public String UtX;
  public String UtY;
  public String ktM;
  public String md5;
  public int reportId;
  public int sNh = -1;
  public String smT;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206498);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.POG == null)
      {
        paramVarArgs = new b("Not all required fields were included: initUrl");
        AppMethodBeat.o(206498);
        throw paramVarArgs;
      }
      if (this.UtX == null)
      {
        paramVarArgs = new b("Not all required fields were included: initFilePath");
        AppMethodBeat.o(206498);
        throw paramVarArgs;
      }
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(206498);
        throw paramVarArgs;
      }
      if (this.ktM == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(206498);
        throw paramVarArgs;
      }
      if (this.UtY == null)
      {
        paramVarArgs = new b("Not all required fields were included: headers");
        AppMethodBeat.o(206498);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.sNh);
      paramVarArgs.aY(2, this.version);
      if (this.POG != null) {
        paramVarArgs.f(3, this.POG);
      }
      if (this.UtX != null) {
        paramVarArgs.f(4, this.UtX);
      }
      if (this.md5 != null) {
        paramVarArgs.f(5, this.md5);
      }
      if (this.ktM != null) {
        paramVarArgs.f(6, this.ktM);
      }
      if (this.UtY != null) {
        paramVarArgs.f(7, this.UtY);
      }
      paramVarArgs.bm(8, this.KcG);
      paramVarArgs.aY(9, this.reportId);
      if (this.smT != null) {
        paramVarArgs.f(10, this.smT);
      }
      AppMethodBeat.o(206498);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.sNh) + 0 + g.a.a.b.b.a.bM(2, this.version);
      paramInt = i;
      if (this.POG != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.POG);
      }
      i = paramInt;
      if (this.UtX != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.UtX);
      }
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.md5);
      }
      i = paramInt;
      if (this.ktM != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.ktM);
      }
      paramInt = i;
      if (this.UtY != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.UtY);
      }
      i = paramInt + g.a.a.b.b.a.p(8, this.KcG) + g.a.a.b.b.a.bM(9, this.reportId);
      paramInt = i;
      if (this.smT != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.smT);
      }
      AppMethodBeat.o(206498);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.POG == null)
      {
        paramVarArgs = new b("Not all required fields were included: initUrl");
        AppMethodBeat.o(206498);
        throw paramVarArgs;
      }
      if (this.UtX == null)
      {
        paramVarArgs = new b("Not all required fields were included: initFilePath");
        AppMethodBeat.o(206498);
        throw paramVarArgs;
      }
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(206498);
        throw paramVarArgs;
      }
      if (this.ktM == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(206498);
        throw paramVarArgs;
      }
      if (this.UtY == null)
      {
        paramVarArgs = new b("Not all required fields were included: headers");
        AppMethodBeat.o(206498);
        throw paramVarArgs;
      }
      AppMethodBeat.o(206498);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ese localese = (ese)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(206498);
        return -1;
      case 1: 
        localese.sNh = locala.abFh.AK();
        AppMethodBeat.o(206498);
        return 0;
      case 2: 
        localese.version = locala.abFh.AK();
        AppMethodBeat.o(206498);
        return 0;
      case 3: 
        localese.POG = locala.abFh.readString();
        AppMethodBeat.o(206498);
        return 0;
      case 4: 
        localese.UtX = locala.abFh.readString();
        AppMethodBeat.o(206498);
        return 0;
      case 5: 
        localese.md5 = locala.abFh.readString();
        AppMethodBeat.o(206498);
        return 0;
      case 6: 
        localese.ktM = locala.abFh.readString();
        AppMethodBeat.o(206498);
        return 0;
      case 7: 
        localese.UtY = locala.abFh.readString();
        AppMethodBeat.o(206498);
        return 0;
      case 8: 
        localese.KcG = locala.abFh.AN();
        AppMethodBeat.o(206498);
        return 0;
      case 9: 
        localese.reportId = locala.abFh.AK();
        AppMethodBeat.o(206498);
        return 0;
      }
      localese.smT = locala.abFh.readString();
      AppMethodBeat.o(206498);
      return 0;
    }
    AppMethodBeat.o(206498);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ese
 * JD-Core Version:    0.7.0.1
 */