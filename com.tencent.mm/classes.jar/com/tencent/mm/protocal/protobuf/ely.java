package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ely
  extends com.tencent.mm.cd.a
{
  public String UnT;
  public String UnU;
  public String UnV;
  public String UnW;
  public String UnX;
  public String UnY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250292);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UnT != null) {
        paramVarArgs.f(1, this.UnT);
      }
      if (this.UnU != null) {
        paramVarArgs.f(2, this.UnU);
      }
      if (this.UnV != null) {
        paramVarArgs.f(3, this.UnV);
      }
      if (this.UnW != null) {
        paramVarArgs.f(4, this.UnW);
      }
      if (this.UnX != null) {
        paramVarArgs.f(5, this.UnX);
      }
      if (this.UnY != null) {
        paramVarArgs.f(6, this.UnY);
      }
      AppMethodBeat.o(250292);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UnT == null) {
        break label518;
      }
    }
    label518:
    for (int i = g.a.a.b.b.a.g(1, this.UnT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UnU != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UnU);
      }
      i = paramInt;
      if (this.UnV != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UnV);
      }
      paramInt = i;
      if (this.UnW != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UnW);
      }
      i = paramInt;
      if (this.UnX != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UnX);
      }
      paramInt = i;
      if (this.UnY != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.UnY);
      }
      AppMethodBeat.o(250292);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(250292);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ely localely = (ely)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(250292);
          return -1;
        case 1: 
          localely.UnT = locala.abFh.readString();
          AppMethodBeat.o(250292);
          return 0;
        case 2: 
          localely.UnU = locala.abFh.readString();
          AppMethodBeat.o(250292);
          return 0;
        case 3: 
          localely.UnV = locala.abFh.readString();
          AppMethodBeat.o(250292);
          return 0;
        case 4: 
          localely.UnW = locala.abFh.readString();
          AppMethodBeat.o(250292);
          return 0;
        case 5: 
          localely.UnX = locala.abFh.readString();
          AppMethodBeat.o(250292);
          return 0;
        }
        localely.UnY = locala.abFh.readString();
        AppMethodBeat.o(250292);
        return 0;
      }
      AppMethodBeat.o(250292);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ely
 * JD-Core Version:    0.7.0.1
 */