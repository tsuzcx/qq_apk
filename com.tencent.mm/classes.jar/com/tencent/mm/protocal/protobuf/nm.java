package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class nm
  extends com.tencent.mm.bv.a
{
  public String cDz;
  public String title;
  public int type;
  public String uiP;
  public String urC;
  public String url;
  public int wCA;
  public String wCy;
  public String wCz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56733);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.type);
      if (this.urC != null) {
        paramVarArgs.e(2, this.urC);
      }
      if (this.cDz != null) {
        paramVarArgs.e(3, this.cDz);
      }
      if (this.title != null) {
        paramVarArgs.e(4, this.title);
      }
      if (this.uiP != null) {
        paramVarArgs.e(5, this.uiP);
      }
      if (this.url != null) {
        paramVarArgs.e(6, this.url);
      }
      if (this.wCy != null) {
        paramVarArgs.e(7, this.wCy);
      }
      if (this.wCz != null) {
        paramVarArgs.e(8, this.wCz);
      }
      paramVarArgs.aO(9, this.wCA);
      AppMethodBeat.o(56733);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.type) + 0;
      paramInt = i;
      if (this.urC != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.urC);
      }
      i = paramInt;
      if (this.cDz != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.cDz);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.title);
      }
      i = paramInt;
      if (this.uiP != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.uiP);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.url);
      }
      i = paramInt;
      if (this.wCy != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wCy);
      }
      paramInt = i;
      if (this.wCz != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wCz);
      }
      i = e.a.a.b.b.a.bl(9, this.wCA);
      AppMethodBeat.o(56733);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56733);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      nm localnm = (nm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56733);
        return -1;
      case 1: 
        localnm.type = locala.CLY.sl();
        AppMethodBeat.o(56733);
        return 0;
      case 2: 
        localnm.urC = locala.CLY.readString();
        AppMethodBeat.o(56733);
        return 0;
      case 3: 
        localnm.cDz = locala.CLY.readString();
        AppMethodBeat.o(56733);
        return 0;
      case 4: 
        localnm.title = locala.CLY.readString();
        AppMethodBeat.o(56733);
        return 0;
      case 5: 
        localnm.uiP = locala.CLY.readString();
        AppMethodBeat.o(56733);
        return 0;
      case 6: 
        localnm.url = locala.CLY.readString();
        AppMethodBeat.o(56733);
        return 0;
      case 7: 
        localnm.wCy = locala.CLY.readString();
        AppMethodBeat.o(56733);
        return 0;
      case 8: 
        localnm.wCz = locala.CLY.readString();
        AppMethodBeat.o(56733);
        return 0;
      }
      localnm.wCA = locala.CLY.sl();
      AppMethodBeat.o(56733);
      return 0;
    }
    AppMethodBeat.o(56733);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nm
 * JD-Core Version:    0.7.0.1
 */