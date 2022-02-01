package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class vl
  extends com.tencent.mm.cd.a
{
  public String SfB;
  public String SfC;
  public long SgR;
  public String SgS;
  public String SgT;
  public String title;
  public String tnY;
  public String tsf;
  public String ufC;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113980);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.tnY != null) {
        paramVarArgs.f(2, this.tnY);
      }
      if (this.tsf != null) {
        paramVarArgs.f(3, this.tsf);
      }
      if (this.url != null) {
        paramVarArgs.f(4, this.url);
      }
      paramVarArgs.bm(5, this.SgR);
      if (this.SgS != null) {
        paramVarArgs.f(6, this.SgS);
      }
      if (this.SgT != null) {
        paramVarArgs.f(7, this.SgT);
      }
      if (this.ufC != null) {
        paramVarArgs.f(8, this.ufC);
      }
      if (this.SfB != null) {
        paramVarArgs.f(9, this.SfB);
      }
      if (this.SfC != null) {
        paramVarArgs.f(10, this.SfC);
      }
      AppMethodBeat.o(113980);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label750;
      }
    }
    label750:
    for (int i = g.a.a.b.b.a.g(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tnY != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.tnY);
      }
      i = paramInt;
      if (this.tsf != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.tsf);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.url);
      }
      i = paramInt + g.a.a.b.b.a.p(5, this.SgR);
      paramInt = i;
      if (this.SgS != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SgS);
      }
      i = paramInt;
      if (this.SgT != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.SgT);
      }
      paramInt = i;
      if (this.ufC != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.ufC);
      }
      i = paramInt;
      if (this.SfB != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.SfB);
      }
      paramInt = i;
      if (this.SfC != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.SfC);
      }
      AppMethodBeat.o(113980);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(113980);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        vl localvl = (vl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113980);
          return -1;
        case 1: 
          localvl.title = locala.abFh.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 2: 
          localvl.tnY = locala.abFh.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 3: 
          localvl.tsf = locala.abFh.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 4: 
          localvl.url = locala.abFh.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 5: 
          localvl.SgR = locala.abFh.AN();
          AppMethodBeat.o(113980);
          return 0;
        case 6: 
          localvl.SgS = locala.abFh.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 7: 
          localvl.SgT = locala.abFh.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 8: 
          localvl.ufC = locala.abFh.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 9: 
          localvl.SfB = locala.abFh.readString();
          AppMethodBeat.o(113980);
          return 0;
        }
        localvl.SfC = locala.abFh.readString();
        AppMethodBeat.o(113980);
        return 0;
      }
      AppMethodBeat.o(113980);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vl
 * JD-Core Version:    0.7.0.1
 */