package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class cxf
  extends com.tencent.mm.cd.a
{
  public String TFL;
  public String TFM;
  public String TFN;
  public int TFO;
  public int type;
  public String url;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91538);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wording == null)
      {
        paramVarArgs = new b("Not all required fields were included: wording");
        AppMethodBeat.o(91538);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.type);
      if (this.wording != null) {
        paramVarArgs.f(2, this.wording);
      }
      if (this.url != null) {
        paramVarArgs.f(3, this.url);
      }
      if (this.TFL != null) {
        paramVarArgs.f(4, this.TFL);
      }
      if (this.TFM != null) {
        paramVarArgs.f(5, this.TFM);
      }
      if (this.TFN != null) {
        paramVarArgs.f(6, this.TFN);
      }
      paramVarArgs.aY(7, this.TFO);
      AppMethodBeat.o(91538);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.type) + 0;
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.wording);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.url);
      }
      paramInt = i;
      if (this.TFL != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TFL);
      }
      i = paramInt;
      if (this.TFM != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TFM);
      }
      paramInt = i;
      if (this.TFN != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TFN);
      }
      i = g.a.a.b.b.a.bM(7, this.TFO);
      AppMethodBeat.o(91538);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.wording == null)
      {
        paramVarArgs = new b("Not all required fields were included: wording");
        AppMethodBeat.o(91538);
        throw paramVarArgs;
      }
      AppMethodBeat.o(91538);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cxf localcxf = (cxf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91538);
        return -1;
      case 1: 
        localcxf.type = locala.abFh.AK();
        AppMethodBeat.o(91538);
        return 0;
      case 2: 
        localcxf.wording = locala.abFh.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 3: 
        localcxf.url = locala.abFh.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 4: 
        localcxf.TFL = locala.abFh.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 5: 
        localcxf.TFM = locala.abFh.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 6: 
        localcxf.TFN = locala.abFh.readString();
        AppMethodBeat.o(91538);
        return 0;
      }
      localcxf.TFO = locala.abFh.AK();
      AppMethodBeat.o(91538);
      return 0;
    }
    AppMethodBeat.o(91538);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxf
 * JD-Core Version:    0.7.0.1
 */