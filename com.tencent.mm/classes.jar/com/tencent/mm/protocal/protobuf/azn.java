package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class azn
  extends com.tencent.mm.bw.a
{
  public String LJn;
  public String LJo;
  public String LJp;
  public String LJq;
  public int LJr;
  public String LJs;
  public String LJt;
  public String appName;
  public String kog;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169017);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LJn != null) {
        paramVarArgs.e(1, this.LJn);
      }
      if (this.LJo != null) {
        paramVarArgs.e(2, this.LJo);
      }
      if (this.LJp != null) {
        paramVarArgs.e(3, this.LJp);
      }
      if (this.appName != null) {
        paramVarArgs.e(4, this.appName);
      }
      if (this.LJq != null) {
        paramVarArgs.e(5, this.LJq);
      }
      if (this.kog != null) {
        paramVarArgs.e(6, this.kog);
      }
      paramVarArgs.aM(7, this.LJr);
      if (this.LJs != null) {
        paramVarArgs.e(8, this.LJs);
      }
      if (this.LJt != null) {
        paramVarArgs.e(9, this.LJt);
      }
      AppMethodBeat.o(169017);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LJn == null) {
        break label686;
      }
    }
    label686:
    for (int i = g.a.a.b.b.a.f(1, this.LJn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LJo != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LJo);
      }
      i = paramInt;
      if (this.LJp != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LJp);
      }
      paramInt = i;
      if (this.appName != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.appName);
      }
      i = paramInt;
      if (this.LJq != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LJq);
      }
      paramInt = i;
      if (this.kog != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.kog);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.LJr);
      paramInt = i;
      if (this.LJs != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.LJs);
      }
      i = paramInt;
      if (this.LJt != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.LJt);
      }
      AppMethodBeat.o(169017);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169017);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        azn localazn = (azn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169017);
          return -1;
        case 1: 
          localazn.LJn = locala.UbS.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 2: 
          localazn.LJo = locala.UbS.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 3: 
          localazn.LJp = locala.UbS.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 4: 
          localazn.appName = locala.UbS.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 5: 
          localazn.LJq = locala.UbS.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 6: 
          localazn.kog = locala.UbS.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 7: 
          localazn.LJr = locala.UbS.zi();
          AppMethodBeat.o(169017);
          return 0;
        case 8: 
          localazn.LJs = locala.UbS.readString();
          AppMethodBeat.o(169017);
          return 0;
        }
        localazn.LJt = locala.UbS.readString();
        AppMethodBeat.o(169017);
        return 0;
      }
      AppMethodBeat.o(169017);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azn
 * JD-Core Version:    0.7.0.1
 */