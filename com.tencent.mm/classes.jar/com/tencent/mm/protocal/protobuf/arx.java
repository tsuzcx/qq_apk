package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class arx
  extends com.tencent.mm.bx.a
{
  public int AcJ;
  public String AcL;
  public int icP;
  public int index;
  public String query;
  public int scene;
  public String sessionId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127475);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.scene);
      paramVarArgs.bS(2, this.AcJ);
      paramVarArgs.bS(3, this.index);
      if (this.sessionId != null) {
        paramVarArgs.g(4, this.sessionId);
      }
      if (this.query != null) {
        paramVarArgs.g(5, this.query);
      }
      if (this.AcL != null) {
        paramVarArgs.g(6, this.AcL);
      }
      paramVarArgs.bS(7, this.icP);
      AppMethodBeat.o(127475);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.scene) + 0 + i.a.a.b.b.a.cJ(2, this.AcJ) + i.a.a.b.b.a.cJ(3, this.index);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.sessionId);
      }
      i = paramInt;
      if (this.query != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.query);
      }
      paramInt = i;
      if (this.AcL != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.AcL);
      }
      i = i.a.a.b.b.a.cJ(7, this.icP);
      AppMethodBeat.o(127475);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(127475);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      arx localarx = (arx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127475);
        return -1;
      case 1: 
        localarx.scene = locala.ajGk.aar();
        AppMethodBeat.o(127475);
        return 0;
      case 2: 
        localarx.AcJ = locala.ajGk.aar();
        AppMethodBeat.o(127475);
        return 0;
      case 3: 
        localarx.index = locala.ajGk.aar();
        AppMethodBeat.o(127475);
        return 0;
      case 4: 
        localarx.sessionId = locala.ajGk.readString();
        AppMethodBeat.o(127475);
        return 0;
      case 5: 
        localarx.query = locala.ajGk.readString();
        AppMethodBeat.o(127475);
        return 0;
      case 6: 
        localarx.AcL = locala.ajGk.readString();
        AppMethodBeat.o(127475);
        return 0;
      }
      localarx.icP = locala.ajGk.aar();
      AppMethodBeat.o(127475);
      return 0;
    }
    AppMethodBeat.o(127475);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arx
 * JD-Core Version:    0.7.0.1
 */