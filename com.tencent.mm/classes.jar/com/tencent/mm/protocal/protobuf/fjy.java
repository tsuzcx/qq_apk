package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fjy
  extends com.tencent.mm.cd.a
{
  public com.tencent.mm.cd.b UIT;
  public com.tencent.mm.cd.b UIU;
  public String UIV;
  public String UIW;
  public String Uht;
  public int Upv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32550);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Uht == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Msg");
        AppMethodBeat.o(32550);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.Upv);
      if (this.Uht != null) {
        paramVarArgs.f(2, this.Uht);
      }
      if (this.UIT != null) {
        paramVarArgs.c(3, this.UIT);
      }
      if (this.UIU != null) {
        paramVarArgs.c(4, this.UIU);
      }
      if (this.UIV != null) {
        paramVarArgs.f(5, this.UIV);
      }
      if (this.UIW != null) {
        paramVarArgs.f(6, this.UIW);
      }
      AppMethodBeat.o(32550);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.Upv) + 0;
      paramInt = i;
      if (this.Uht != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Uht);
      }
      i = paramInt;
      if (this.UIT != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.UIT);
      }
      paramInt = i;
      if (this.UIU != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.UIU);
      }
      i = paramInt;
      if (this.UIV != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UIV);
      }
      paramInt = i;
      if (this.UIW != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.UIW);
      }
      AppMethodBeat.o(32550);
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
      if (this.Uht == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Msg");
        AppMethodBeat.o(32550);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32550);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fjy localfjy = (fjy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32550);
        return -1;
      case 1: 
        localfjy.Upv = locala.abFh.AK();
        AppMethodBeat.o(32550);
        return 0;
      case 2: 
        localfjy.Uht = locala.abFh.readString();
        AppMethodBeat.o(32550);
        return 0;
      case 3: 
        localfjy.UIT = locala.abFh.iUw();
        AppMethodBeat.o(32550);
        return 0;
      case 4: 
        localfjy.UIU = locala.abFh.iUw();
        AppMethodBeat.o(32550);
        return 0;
      case 5: 
        localfjy.UIV = locala.abFh.readString();
        AppMethodBeat.o(32550);
        return 0;
      }
      localfjy.UIW = locala.abFh.readString();
      AppMethodBeat.o(32550);
      return 0;
    }
    AppMethodBeat.o(32550);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fjy
 * JD-Core Version:    0.7.0.1
 */