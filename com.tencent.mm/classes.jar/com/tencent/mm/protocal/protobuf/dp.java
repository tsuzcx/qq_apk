package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dp
  extends com.tencent.mm.cd.a
{
  public String COk;
  public String RIX;
  public String RIY;
  public String UserName;
  public String mVA;
  public String mVH;
  public String mVz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91348);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.mVH != null) {
        paramVarArgs.f(1, this.mVH);
      }
      if (this.mVz != null) {
        paramVarArgs.f(2, this.mVz);
      }
      if (this.mVA != null) {
        paramVarArgs.f(3, this.mVA);
      }
      if (this.COk != null) {
        paramVarArgs.f(4, this.COk);
      }
      if (this.UserName != null) {
        paramVarArgs.f(5, this.UserName);
      }
      if (this.RIX != null) {
        paramVarArgs.f(6, this.RIX);
      }
      if (this.RIY != null) {
        paramVarArgs.f(7, this.RIY);
      }
      AppMethodBeat.o(91348);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mVH == null) {
        break label578;
      }
    }
    label578:
    for (int i = g.a.a.b.b.a.g(1, this.mVH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mVz != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.mVz);
      }
      i = paramInt;
      if (this.mVA != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.mVA);
      }
      paramInt = i;
      if (this.COk != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.COk);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UserName);
      }
      paramInt = i;
      if (this.RIX != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RIX);
      }
      i = paramInt;
      if (this.RIY != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.RIY);
      }
      AppMethodBeat.o(91348);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91348);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dp localdp = (dp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91348);
          return -1;
        case 1: 
          localdp.mVH = locala.abFh.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 2: 
          localdp.mVz = locala.abFh.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 3: 
          localdp.mVA = locala.abFh.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 4: 
          localdp.COk = locala.abFh.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 5: 
          localdp.UserName = locala.abFh.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 6: 
          localdp.RIX = locala.abFh.readString();
          AppMethodBeat.o(91348);
          return 0;
        }
        localdp.RIY = locala.abFh.readString();
        AppMethodBeat.o(91348);
        return 0;
      }
      AppMethodBeat.o(91348);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dp
 * JD-Core Version:    0.7.0.1
 */