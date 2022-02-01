package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dna
  extends com.tencent.mm.bw.a
{
  public String KSV;
  public long MQr;
  public int MQs;
  public boolean MQt;
  public boolean MQu;
  public int MQv;
  public boolean MQw;
  public int xNc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124546);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KSV != null) {
        paramVarArgs.e(1, this.KSV);
      }
      paramVarArgs.bb(2, this.MQr);
      paramVarArgs.aM(3, this.MQs);
      paramVarArgs.cc(4, this.MQt);
      paramVarArgs.cc(5, this.MQu);
      paramVarArgs.aM(6, this.MQv);
      paramVarArgs.aM(7, this.xNc);
      paramVarArgs.cc(8, this.MQw);
      AppMethodBeat.o(124546);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KSV == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = g.a.a.b.b.a.f(1, this.KSV) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.r(2, this.MQr);
      int j = g.a.a.b.b.a.bu(3, this.MQs);
      int k = g.a.a.b.b.a.fS(4);
      int m = g.a.a.b.b.a.fS(5);
      int n = g.a.a.b.b.a.bu(6, this.MQv);
      int i1 = g.a.a.b.b.a.bu(7, this.xNc);
      int i2 = g.a.a.b.b.a.fS(8);
      AppMethodBeat.o(124546);
      return paramInt + i + j + (k + 1) + (m + 1) + n + i1 + (i2 + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124546);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dna localdna = (dna)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124546);
          return -1;
        case 1: 
          localdna.KSV = locala.UbS.readString();
          AppMethodBeat.o(124546);
          return 0;
        case 2: 
          localdna.MQr = locala.UbS.zl();
          AppMethodBeat.o(124546);
          return 0;
        case 3: 
          localdna.MQs = locala.UbS.zi();
          AppMethodBeat.o(124546);
          return 0;
        case 4: 
          localdna.MQt = locala.UbS.yZ();
          AppMethodBeat.o(124546);
          return 0;
        case 5: 
          localdna.MQu = locala.UbS.yZ();
          AppMethodBeat.o(124546);
          return 0;
        case 6: 
          localdna.MQv = locala.UbS.zi();
          AppMethodBeat.o(124546);
          return 0;
        case 7: 
          localdna.xNc = locala.UbS.zi();
          AppMethodBeat.o(124546);
          return 0;
        }
        localdna.MQw = locala.UbS.yZ();
        AppMethodBeat.o(124546);
        return 0;
      }
      AppMethodBeat.o(124546);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dna
 * JD-Core Version:    0.7.0.1
 */