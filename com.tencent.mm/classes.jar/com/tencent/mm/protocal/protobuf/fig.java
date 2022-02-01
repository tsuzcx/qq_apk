package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fig
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public String GIG;
  public String TPZ;
  public String Tky;
  public String UIb;
  public String UIc;
  public String UId;
  public String UIe;
  public String UIf;
  public int mUq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121110);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UIb != null) {
        paramVarArgs.f(1, this.UIb);
      }
      if (this.UIc != null) {
        paramVarArgs.f(2, this.UIc);
      }
      if (this.Tky != null) {
        paramVarArgs.f(3, this.Tky);
      }
      if (this.TPZ != null) {
        paramVarArgs.f(4, this.TPZ);
      }
      paramVarArgs.aY(5, this.mUq);
      if (this.GIG != null) {
        paramVarArgs.f(6, this.GIG);
      }
      if (this.UId != null) {
        paramVarArgs.f(7, this.UId);
      }
      if (this.UIe != null) {
        paramVarArgs.f(8, this.UIe);
      }
      paramVarArgs.aY(9, this.CPw);
      if (this.UIf != null) {
        paramVarArgs.f(19, this.UIf);
      }
      AppMethodBeat.o(121110);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UIb == null) {
        break label770;
      }
    }
    label770:
    for (int i = g.a.a.b.b.a.g(1, this.UIb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UIc != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UIc);
      }
      i = paramInt;
      if (this.Tky != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Tky);
      }
      paramInt = i;
      if (this.TPZ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TPZ);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.mUq);
      paramInt = i;
      if (this.GIG != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.GIG);
      }
      i = paramInt;
      if (this.UId != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.UId);
      }
      paramInt = i;
      if (this.UIe != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.UIe);
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.CPw);
      paramInt = i;
      if (this.UIf != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.UIf);
      }
      AppMethodBeat.o(121110);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(121110);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fig localfig = (fig)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        default: 
          AppMethodBeat.o(121110);
          return -1;
        case 1: 
          localfig.UIb = locala.abFh.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 2: 
          localfig.UIc = locala.abFh.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 3: 
          localfig.Tky = locala.abFh.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 4: 
          localfig.TPZ = locala.abFh.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 5: 
          localfig.mUq = locala.abFh.AK();
          AppMethodBeat.o(121110);
          return 0;
        case 6: 
          localfig.GIG = locala.abFh.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 7: 
          localfig.UId = locala.abFh.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 8: 
          localfig.UIe = locala.abFh.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 9: 
          localfig.CPw = locala.abFh.AK();
          AppMethodBeat.o(121110);
          return 0;
        }
        localfig.UIf = locala.abFh.readString();
        AppMethodBeat.o(121110);
        return 0;
      }
      AppMethodBeat.o(121110);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fig
 * JD-Core Version:    0.7.0.1
 */