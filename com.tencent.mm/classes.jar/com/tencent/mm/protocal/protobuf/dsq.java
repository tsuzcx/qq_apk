package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dsq
  extends com.tencent.mm.cd.a
{
  public String Sus;
  public String Sxx;
  public int TYY;
  public String Tav;
  public String UserName;
  public String rWI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127295);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.f(1, this.UserName);
      }
      paramVarArgs.aY(2, this.TYY);
      if (this.rWI != null) {
        paramVarArgs.f(3, this.rWI);
      }
      if (this.Sus != null) {
        paramVarArgs.f(4, this.Sus);
      }
      if (this.Sxx != null) {
        paramVarArgs.f(5, this.Sxx);
      }
      if (this.Tav != null) {
        paramVarArgs.f(6, this.Tav);
      }
      AppMethodBeat.o(127295);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = g.a.a.b.b.a.g(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TYY);
      paramInt = i;
      if (this.rWI != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.rWI);
      }
      i = paramInt;
      if (this.Sus != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.Sus);
      }
      paramInt = i;
      if (this.Sxx != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Sxx);
      }
      i = paramInt;
      if (this.Tav != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.Tav);
      }
      AppMethodBeat.o(127295);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(127295);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dsq localdsq = (dsq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127295);
          return -1;
        case 1: 
          localdsq.UserName = locala.abFh.readString();
          AppMethodBeat.o(127295);
          return 0;
        case 2: 
          localdsq.TYY = locala.abFh.AK();
          AppMethodBeat.o(127295);
          return 0;
        case 3: 
          localdsq.rWI = locala.abFh.readString();
          AppMethodBeat.o(127295);
          return 0;
        case 4: 
          localdsq.Sus = locala.abFh.readString();
          AppMethodBeat.o(127295);
          return 0;
        case 5: 
          localdsq.Sxx = locala.abFh.readString();
          AppMethodBeat.o(127295);
          return 0;
        }
        localdsq.Tav = locala.abFh.readString();
        AppMethodBeat.o(127295);
        return 0;
      }
      AppMethodBeat.o(127295);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsq
 * JD-Core Version:    0.7.0.1
 */