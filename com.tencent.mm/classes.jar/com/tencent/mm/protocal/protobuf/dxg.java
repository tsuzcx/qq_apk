package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dxg
  extends com.tencent.mm.bw.a
{
  public String KDf;
  public String KDg;
  public int KDh;
  public String KJM;
  public String eaO;
  public String eaP;
  public String pRX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114073);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.eaO != null) {
        paramVarArgs.e(1, this.eaO);
      }
      if (this.pRX != null) {
        paramVarArgs.e(2, this.pRX);
      }
      if (this.eaP != null) {
        paramVarArgs.e(3, this.eaP);
      }
      if (this.KDf != null) {
        paramVarArgs.e(4, this.KDf);
      }
      if (this.KDg != null) {
        paramVarArgs.e(5, this.KDg);
      }
      paramVarArgs.aM(6, this.KDh);
      if (this.KJM != null) {
        paramVarArgs.e(7, this.KJM);
      }
      AppMethodBeat.o(114073);
      return 0;
    }
    if (paramInt == 1) {
      if (this.eaO == null) {
        break label562;
      }
    }
    label562:
    for (int i = g.a.a.b.b.a.f(1, this.eaO) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pRX != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.pRX);
      }
      i = paramInt;
      if (this.eaP != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.eaP);
      }
      paramInt = i;
      if (this.KDf != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KDf);
      }
      i = paramInt;
      if (this.KDg != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KDg);
      }
      i += g.a.a.b.b.a.bu(6, this.KDh);
      paramInt = i;
      if (this.KJM != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.KJM);
      }
      AppMethodBeat.o(114073);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(114073);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dxg localdxg = (dxg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114073);
          return -1;
        case 1: 
          localdxg.eaO = locala.UbS.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 2: 
          localdxg.pRX = locala.UbS.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 3: 
          localdxg.eaP = locala.UbS.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 4: 
          localdxg.KDf = locala.UbS.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 5: 
          localdxg.KDg = locala.UbS.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 6: 
          localdxg.KDh = locala.UbS.zi();
          AppMethodBeat.o(114073);
          return 0;
        }
        localdxg.KJM = locala.UbS.readString();
        AppMethodBeat.o(114073);
        return 0;
      }
      AppMethodBeat.o(114073);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxg
 * JD-Core Version:    0.7.0.1
 */