package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbf
  extends com.tencent.mm.bw.a
{
  public String MgT;
  public String MgU;
  public String MgV;
  public String MgW;
  public String MgX;
  public String MgY;
  public String MgZ;
  public String igW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91521);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MgT != null) {
        paramVarArgs.e(1, this.MgT);
      }
      if (this.MgU != null) {
        paramVarArgs.e(2, this.MgU);
      }
      if (this.igW != null) {
        paramVarArgs.e(3, this.igW);
      }
      if (this.MgV != null) {
        paramVarArgs.e(4, this.MgV);
      }
      if (this.MgW != null) {
        paramVarArgs.e(5, this.MgW);
      }
      if (this.MgX != null) {
        paramVarArgs.e(6, this.MgX);
      }
      if (this.MgY != null) {
        paramVarArgs.e(7, this.MgY);
      }
      if (this.MgZ != null) {
        paramVarArgs.e(8, this.MgZ);
      }
      AppMethodBeat.o(91521);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MgT == null) {
        break label642;
      }
    }
    label642:
    for (int i = g.a.a.b.b.a.f(1, this.MgT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MgU != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MgU);
      }
      i = paramInt;
      if (this.igW != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.igW);
      }
      paramInt = i;
      if (this.MgV != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MgV);
      }
      i = paramInt;
      if (this.MgW != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MgW);
      }
      paramInt = i;
      if (this.MgX != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MgX);
      }
      i = paramInt;
      if (this.MgY != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.MgY);
      }
      paramInt = i;
      if (this.MgZ != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.MgZ);
      }
      AppMethodBeat.o(91521);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91521);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cbf localcbf = (cbf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91521);
          return -1;
        case 1: 
          localcbf.MgT = locala.UbS.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 2: 
          localcbf.MgU = locala.UbS.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 3: 
          localcbf.igW = locala.UbS.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 4: 
          localcbf.MgV = locala.UbS.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 5: 
          localcbf.MgW = locala.UbS.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 6: 
          localcbf.MgX = locala.UbS.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 7: 
          localcbf.MgY = locala.UbS.readString();
          AppMethodBeat.o(91521);
          return 0;
        }
        localcbf.MgZ = locala.UbS.readString();
        AppMethodBeat.o(91521);
        return 0;
      }
      AppMethodBeat.o(91521);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbf
 * JD-Core Version:    0.7.0.1
 */