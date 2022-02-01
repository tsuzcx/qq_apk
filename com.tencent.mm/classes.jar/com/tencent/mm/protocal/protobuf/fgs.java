package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fgs
  extends com.tencent.mm.cd.a
{
  public String ProductID;
  public String TVo;
  public int UGY;
  public String UGZ;
  public String UHa;
  public String UHb;
  public String UHc;
  public String UHd;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32504);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      if (this.ProductID != null) {
        paramVarArgs.f(2, this.ProductID);
      }
      paramVarArgs.aY(3, this.UGY);
      if (this.UGZ != null) {
        paramVarArgs.f(4, this.UGZ);
      }
      if (this.TVo != null) {
        paramVarArgs.f(5, this.TVo);
      }
      if (this.UHa != null) {
        paramVarArgs.f(6, this.UHa);
      }
      if (this.UHb != null) {
        paramVarArgs.f(7, this.UHb);
      }
      if (this.UHc != null) {
        paramVarArgs.f(8, this.UHc);
      }
      if (this.UHd != null) {
        paramVarArgs.f(9, this.UHd);
      }
      AppMethodBeat.o(32504);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label701;
      }
    }
    label701:
    for (paramInt = g.a.a.b.b.a.g(1, this.fwr) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.ProductID);
      }
      i += g.a.a.b.b.a.bM(3, this.UGY);
      paramInt = i;
      if (this.UGZ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UGZ);
      }
      i = paramInt;
      if (this.TVo != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TVo);
      }
      paramInt = i;
      if (this.UHa != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.UHa);
      }
      i = paramInt;
      if (this.UHb != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.UHb);
      }
      paramInt = i;
      if (this.UHc != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.UHc);
      }
      i = paramInt;
      if (this.UHd != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.UHd);
      }
      AppMethodBeat.o(32504);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32504);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fgs localfgs = (fgs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32504);
          return -1;
        case 1: 
          localfgs.fwr = locala.abFh.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 2: 
          localfgs.ProductID = locala.abFh.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 3: 
          localfgs.UGY = locala.abFh.AK();
          AppMethodBeat.o(32504);
          return 0;
        case 4: 
          localfgs.UGZ = locala.abFh.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 5: 
          localfgs.TVo = locala.abFh.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 6: 
          localfgs.UHa = locala.abFh.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 7: 
          localfgs.UHb = locala.abFh.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 8: 
          localfgs.UHc = locala.abFh.readString();
          AppMethodBeat.o(32504);
          return 0;
        }
        localfgs.UHd = locala.abFh.readString();
        AppMethodBeat.o(32504);
        return 0;
      }
      AppMethodBeat.o(32504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fgs
 * JD-Core Version:    0.7.0.1
 */