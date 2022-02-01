package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fkh
  extends com.tencent.mm.cd.a
{
  public String CRQ;
  public int CreateTime;
  public String RII;
  public int TFR;
  public int UIZ;
  public int rVx;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32560);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CRQ != null) {
        paramVarArgs.f(1, this.CRQ);
      }
      paramVarArgs.aY(2, this.rWu);
      paramVarArgs.aY(3, this.rVx);
      paramVarArgs.aY(4, this.CreateTime);
      paramVarArgs.aY(5, this.TFR);
      if (this.RII != null) {
        paramVarArgs.f(6, this.RII);
      }
      paramVarArgs.aY(7, this.UIZ);
      AppMethodBeat.o(32560);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CRQ == null) {
        break label507;
      }
    }
    label507:
    for (paramInt = g.a.a.b.b.a.g(1, this.CRQ) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.rWu) + g.a.a.b.b.a.bM(3, this.rVx) + g.a.a.b.b.a.bM(4, this.CreateTime) + g.a.a.b.b.a.bM(5, this.TFR);
      paramInt = i;
      if (this.RII != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RII);
      }
      i = g.a.a.b.b.a.bM(7, this.UIZ);
      AppMethodBeat.o(32560);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32560);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fkh localfkh = (fkh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32560);
          return -1;
        case 1: 
          localfkh.CRQ = locala.abFh.readString();
          AppMethodBeat.o(32560);
          return 0;
        case 2: 
          localfkh.rWu = locala.abFh.AK();
          AppMethodBeat.o(32560);
          return 0;
        case 3: 
          localfkh.rVx = locala.abFh.AK();
          AppMethodBeat.o(32560);
          return 0;
        case 4: 
          localfkh.CreateTime = locala.abFh.AK();
          AppMethodBeat.o(32560);
          return 0;
        case 5: 
          localfkh.TFR = locala.abFh.AK();
          AppMethodBeat.o(32560);
          return 0;
        case 6: 
          localfkh.RII = locala.abFh.readString();
          AppMethodBeat.o(32560);
          return 0;
        }
        localfkh.UIZ = locala.abFh.AK();
        AppMethodBeat.o(32560);
        return 0;
      }
      AppMethodBeat.o(32560);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fkh
 * JD-Core Version:    0.7.0.1
 */