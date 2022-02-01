package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class fjj
  extends com.tencent.mm.cd.a
{
  public int RJP;
  public String SpT;
  public String UIA;
  public String UIB;
  public String UIC;
  public String UIE;
  public String UIF;
  public String UIz;
  public String ieb;
  public String rVH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32531);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UIz == null)
      {
        paramVarArgs = new b("Not all required fields were included: LocalNodeId");
        AppMethodBeat.o(32531);
        throw paramVarArgs;
      }
      if (this.UIz != null) {
        paramVarArgs.f(1, this.UIz);
      }
      if (this.rVH != null) {
        paramVarArgs.f(2, this.rVH);
      }
      if (this.UIA != null) {
        paramVarArgs.f(3, this.UIA);
      }
      if (this.ieb != null) {
        paramVarArgs.f(4, this.ieb);
      }
      if (this.UIB != null) {
        paramVarArgs.f(5, this.UIB);
      }
      if (this.SpT != null) {
        paramVarArgs.f(6, this.SpT);
      }
      if (this.UIC != null) {
        paramVarArgs.f(7, this.UIC);
      }
      if (this.UIE != null) {
        paramVarArgs.f(8, this.UIE);
      }
      if (this.UIF != null) {
        paramVarArgs.f(9, this.UIF);
      }
      paramVarArgs.aY(10, this.RJP);
      AppMethodBeat.o(32531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UIz == null) {
        break label814;
      }
    }
    label814:
    for (int i = g.a.a.b.b.a.g(1, this.UIz) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rVH != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.rVH);
      }
      i = paramInt;
      if (this.UIA != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UIA);
      }
      paramInt = i;
      if (this.ieb != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.ieb);
      }
      i = paramInt;
      if (this.UIB != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UIB);
      }
      paramInt = i;
      if (this.SpT != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SpT);
      }
      i = paramInt;
      if (this.UIC != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.UIC);
      }
      paramInt = i;
      if (this.UIE != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.UIE);
      }
      i = paramInt;
      if (this.UIF != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.UIF);
      }
      paramInt = g.a.a.b.b.a.bM(10, this.RJP);
      AppMethodBeat.o(32531);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.UIz == null)
        {
          paramVarArgs = new b("Not all required fields were included: LocalNodeId");
          AppMethodBeat.o(32531);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32531);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fjj localfjj = (fjj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32531);
          return -1;
        case 1: 
          localfjj.UIz = locala.abFh.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 2: 
          localfjj.rVH = locala.abFh.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 3: 
          localfjj.UIA = locala.abFh.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 4: 
          localfjj.ieb = locala.abFh.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 5: 
          localfjj.UIB = locala.abFh.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 6: 
          localfjj.SpT = locala.abFh.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 7: 
          localfjj.UIC = locala.abFh.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 8: 
          localfjj.UIE = locala.abFh.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 9: 
          localfjj.UIF = locala.abFh.readString();
          AppMethodBeat.o(32531);
          return 0;
        }
        localfjj.RJP = locala.abFh.AK();
        AppMethodBeat.o(32531);
        return 0;
      }
      AppMethodBeat.o(32531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fjj
 * JD-Core Version:    0.7.0.1
 */