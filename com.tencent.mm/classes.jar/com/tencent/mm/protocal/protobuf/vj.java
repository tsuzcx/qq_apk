package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class vj
  extends com.tencent.mm.bw.a
{
  public String Leo;
  public String Lep;
  public long LfD;
  public String LfE;
  public String LfF;
  public String pRY;
  public String pWf;
  public String qGB;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113980);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.pRY != null) {
        paramVarArgs.e(2, this.pRY);
      }
      if (this.pWf != null) {
        paramVarArgs.e(3, this.pWf);
      }
      if (this.url != null) {
        paramVarArgs.e(4, this.url);
      }
      paramVarArgs.bb(5, this.LfD);
      if (this.LfE != null) {
        paramVarArgs.e(6, this.LfE);
      }
      if (this.LfF != null) {
        paramVarArgs.e(7, this.LfF);
      }
      if (this.qGB != null) {
        paramVarArgs.e(8, this.qGB);
      }
      if (this.Leo != null) {
        paramVarArgs.e(9, this.Leo);
      }
      if (this.Lep != null) {
        paramVarArgs.e(10, this.Lep);
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
    for (int i = g.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pRY != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.pRY);
      }
      i = paramInt;
      if (this.pWf != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.pWf);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.url);
      }
      i = paramInt + g.a.a.b.b.a.r(5, this.LfD);
      paramInt = i;
      if (this.LfE != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LfE);
      }
      i = paramInt;
      if (this.LfF != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.LfF);
      }
      paramInt = i;
      if (this.qGB != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.qGB);
      }
      i = paramInt;
      if (this.Leo != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.Leo);
      }
      paramInt = i;
      if (this.Lep != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.Lep);
      }
      AppMethodBeat.o(113980);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(113980);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        vj localvj = (vj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113980);
          return -1;
        case 1: 
          localvj.title = locala.UbS.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 2: 
          localvj.pRY = locala.UbS.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 3: 
          localvj.pWf = locala.UbS.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 4: 
          localvj.url = locala.UbS.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 5: 
          localvj.LfD = locala.UbS.zl();
          AppMethodBeat.o(113980);
          return 0;
        case 6: 
          localvj.LfE = locala.UbS.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 7: 
          localvj.LfF = locala.UbS.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 8: 
          localvj.qGB = locala.UbS.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 9: 
          localvj.Leo = locala.UbS.readString();
          AppMethodBeat.o(113980);
          return 0;
        }
        localvj.Lep = locala.UbS.readString();
        AppMethodBeat.o(113980);
        return 0;
      }
      AppMethodBeat.o(113980);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vj
 * JD-Core Version:    0.7.0.1
 */