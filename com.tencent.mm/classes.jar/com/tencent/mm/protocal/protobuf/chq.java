package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class chq
  extends com.tencent.mm.cd.a
{
  public int CqV;
  public String RQy;
  public String Tav;
  public String ToX;
  public String ToY;
  public String UserName;
  public String rWI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155421);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RQy != null) {
        paramVarArgs.f(1, this.RQy);
      }
      if (this.UserName != null) {
        paramVarArgs.f(2, this.UserName);
      }
      if (this.ToX != null) {
        paramVarArgs.f(3, this.ToX);
      }
      if (this.ToY != null) {
        paramVarArgs.f(4, this.ToY);
      }
      paramVarArgs.aY(5, this.CqV);
      if (this.rWI != null) {
        paramVarArgs.f(6, this.rWI);
      }
      if (this.Tav != null) {
        paramVarArgs.f(7, this.Tav);
      }
      AppMethodBeat.o(155421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RQy == null) {
        break label562;
      }
    }
    label562:
    for (int i = g.a.a.b.b.a.g(1, this.RQy) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UserName);
      }
      i = paramInt;
      if (this.ToX != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ToX);
      }
      paramInt = i;
      if (this.ToY != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.ToY);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.CqV);
      paramInt = i;
      if (this.rWI != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.rWI);
      }
      i = paramInt;
      if (this.Tav != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Tav);
      }
      AppMethodBeat.o(155421);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(155421);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        chq localchq = (chq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(155421);
          return -1;
        case 1: 
          localchq.RQy = locala.abFh.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 2: 
          localchq.UserName = locala.abFh.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 3: 
          localchq.ToX = locala.abFh.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 4: 
          localchq.ToY = locala.abFh.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 5: 
          localchq.CqV = locala.abFh.AK();
          AppMethodBeat.o(155421);
          return 0;
        case 6: 
          localchq.rWI = locala.abFh.readString();
          AppMethodBeat.o(155421);
          return 0;
        }
        localchq.Tav = locala.abFh.readString();
        AppMethodBeat.o(155421);
        return 0;
      }
      AppMethodBeat.o(155421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chq
 * JD-Core Version:    0.7.0.1
 */