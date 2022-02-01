package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fju
  extends com.tencent.mm.cd.a
{
  public int CRP;
  public boolean UIQ;
  public boolean UIR;
  public boolean UIS;
  public com.tencent.mm.cd.b UIy;
  public String Ueg;
  public int UiV;
  public String fwr;
  public String lpy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32545);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ueg == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.fwr == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Title");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.lpy == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.CRP);
      if (this.Ueg != null) {
        paramVarArgs.f(2, this.Ueg);
      }
      if (this.fwr != null) {
        paramVarArgs.f(3, this.fwr);
      }
      if (this.lpy != null) {
        paramVarArgs.f(4, this.lpy);
      }
      paramVarArgs.aY(5, this.UiV);
      if (this.UIy != null) {
        paramVarArgs.c(6, this.UIy);
      }
      paramVarArgs.co(7, this.UIQ);
      paramVarArgs.co(8, this.UIR);
      paramVarArgs.co(9, this.UIS);
      AppMethodBeat.o(32545);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.CRP) + 0;
      paramInt = i;
      if (this.Ueg != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Ueg);
      }
      i = paramInt;
      if (this.fwr != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fwr);
      }
      paramInt = i;
      if (this.lpy != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.lpy);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.UiV);
      paramInt = i;
      if (this.UIy != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.UIy);
      }
      i = g.a.a.b.b.a.gL(7);
      int j = g.a.a.b.b.a.gL(8);
      int k = g.a.a.b.b.a.gL(9);
      AppMethodBeat.o(32545);
      return paramInt + (i + 1) + (j + 1) + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.Ueg == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.fwr == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Title");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.lpy == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32545);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fju localfju = (fju)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32545);
        return -1;
      case 1: 
        localfju.CRP = locala.abFh.AK();
        AppMethodBeat.o(32545);
        return 0;
      case 2: 
        localfju.Ueg = locala.abFh.readString();
        AppMethodBeat.o(32545);
        return 0;
      case 3: 
        localfju.fwr = locala.abFh.readString();
        AppMethodBeat.o(32545);
        return 0;
      case 4: 
        localfju.lpy = locala.abFh.readString();
        AppMethodBeat.o(32545);
        return 0;
      case 5: 
        localfju.UiV = locala.abFh.AK();
        AppMethodBeat.o(32545);
        return 0;
      case 6: 
        localfju.UIy = locala.abFh.iUw();
        AppMethodBeat.o(32545);
        return 0;
      case 7: 
        localfju.UIQ = locala.abFh.AB();
        AppMethodBeat.o(32545);
        return 0;
      case 8: 
        localfju.UIR = locala.abFh.AB();
        AppMethodBeat.o(32545);
        return 0;
      }
      localfju.UIS = locala.abFh.AB();
      AppMethodBeat.o(32545);
      return 0;
    }
    AppMethodBeat.o(32545);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fju
 * JD-Core Version:    0.7.0.1
 */