package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aze
  extends com.tencent.mm.cd.a
{
  public String SLb;
  public String jumpUrl;
  public String title;
  public int type;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206117);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      if (this.wording != null) {
        paramVarArgs.f(2, this.wording);
      }
      if (this.title != null) {
        paramVarArgs.f(3, this.title);
      }
      if (this.jumpUrl != null) {
        paramVarArgs.f(4, this.jumpUrl);
      }
      if (this.SLb != null) {
        paramVarArgs.f(5, this.SLb);
      }
      AppMethodBeat.o(206117);
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
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.title);
      }
      paramInt = i;
      if (this.jumpUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.jumpUrl);
      }
      i = paramInt;
      if (this.SLb != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SLb);
      }
      AppMethodBeat.o(206117);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(206117);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      aze localaze = (aze)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(206117);
        return -1;
      case 1: 
        localaze.type = locala.abFh.AK();
        AppMethodBeat.o(206117);
        return 0;
      case 2: 
        localaze.wording = locala.abFh.readString();
        AppMethodBeat.o(206117);
        return 0;
      case 3: 
        localaze.title = locala.abFh.readString();
        AppMethodBeat.o(206117);
        return 0;
      case 4: 
        localaze.jumpUrl = locala.abFh.readString();
        AppMethodBeat.o(206117);
        return 0;
      }
      localaze.SLb = locala.abFh.readString();
      AppMethodBeat.o(206117);
      return 0;
    }
    AppMethodBeat.o(206117);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aze
 * JD-Core Version:    0.7.0.1
 */