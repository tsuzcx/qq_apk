package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public class fld
  extends com.tencent.mm.cd.a
{
  public int UJU;
  public int UJV;
  public int dQ;
  public int fod;
  public int kqZ;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205174);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(205174);
        throw paramVarArgs;
      }
      if (this.url != null) {
        paramVarArgs.f(1, this.url);
      }
      paramVarArgs.aY(2, this.dQ);
      paramVarArgs.aY(3, this.kqZ);
      paramVarArgs.aY(4, this.fod);
      paramVarArgs.aY(5, this.UJU);
      paramVarArgs.aY(6, this.UJV);
      if (this.title != null) {
        paramVarArgs.f(7, this.title);
      }
      AppMethodBeat.o(205174);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label538;
      }
    }
    label538:
    for (paramInt = g.a.a.b.b.a.g(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.dQ) + g.a.a.b.b.a.bM(3, this.kqZ) + g.a.a.b.b.a.bM(4, this.fod) + g.a.a.b.b.a.bM(5, this.UJU) + g.a.a.b.b.a.bM(6, this.UJV);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.title);
      }
      AppMethodBeat.o(205174);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.url == null)
        {
          paramVarArgs = new b("Not all required fields were included: url");
          AppMethodBeat.o(205174);
          throw paramVarArgs;
        }
        AppMethodBeat.o(205174);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fld localfld = (fld)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(205174);
          return -1;
        case 1: 
          localfld.url = locala.abFh.readString();
          AppMethodBeat.o(205174);
          return 0;
        case 2: 
          localfld.dQ = locala.abFh.AK();
          AppMethodBeat.o(205174);
          return 0;
        case 3: 
          localfld.kqZ = locala.abFh.AK();
          AppMethodBeat.o(205174);
          return 0;
        case 4: 
          localfld.fod = locala.abFh.AK();
          AppMethodBeat.o(205174);
          return 0;
        case 5: 
          localfld.UJU = locala.abFh.AK();
          AppMethodBeat.o(205174);
          return 0;
        case 6: 
          localfld.UJV = locala.abFh.AK();
          AppMethodBeat.o(205174);
          return 0;
        }
        localfld.title = locala.abFh.readString();
        AppMethodBeat.o(205174);
        return 0;
      }
      AppMethodBeat.o(205174);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fld
 * JD-Core Version:    0.7.0.1
 */