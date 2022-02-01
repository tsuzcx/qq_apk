package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aif
  extends com.tencent.mm.bw.a
{
  public boolean ECL;
  public boolean ECM;
  public boolean ECN;
  public boolean ECO;
  public boolean ECP;
  public boolean ECQ;
  public boolean ECR;
  public boolean ECS;
  public boolean ECT;
  public boolean ECU;
  public boolean ECV;
  public boolean ECW;
  public boolean ECX;
  public boolean ECY;
  public boolean ECZ;
  public boolean EDa;
  public boolean EDb;
  public boolean EDc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116469);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bl(1, this.ECL);
      paramVarArgs.bl(2, this.ECM);
      paramVarArgs.bl(3, this.ECN);
      paramVarArgs.bl(4, this.ECO);
      paramVarArgs.bl(5, this.ECP);
      paramVarArgs.bl(6, this.ECQ);
      paramVarArgs.bl(7, this.ECR);
      paramVarArgs.bl(8, this.ECS);
      paramVarArgs.bl(9, this.ECT);
      paramVarArgs.bl(10, this.ECU);
      paramVarArgs.bl(11, this.ECV);
      paramVarArgs.bl(12, this.ECW);
      paramVarArgs.bl(13, this.ECX);
      paramVarArgs.bl(14, this.ECY);
      paramVarArgs.bl(15, this.ECZ);
      paramVarArgs.bl(16, this.EDa);
      paramVarArgs.bl(17, this.EDb);
      paramVarArgs.bl(18, this.EDc);
      AppMethodBeat.o(116469);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fK(1);
      int i = f.a.a.b.b.a.fK(2);
      int j = f.a.a.b.b.a.fK(3);
      int k = f.a.a.b.b.a.fK(4);
      int m = f.a.a.b.b.a.fK(5);
      int n = f.a.a.b.b.a.fK(6);
      int i1 = f.a.a.b.b.a.fK(7);
      int i2 = f.a.a.b.b.a.fK(8);
      int i3 = f.a.a.b.b.a.fK(9);
      int i4 = f.a.a.b.b.a.fK(10);
      int i5 = f.a.a.b.b.a.fK(11);
      int i6 = f.a.a.b.b.a.fK(12);
      int i7 = f.a.a.b.b.a.fK(13);
      int i8 = f.a.a.b.b.a.fK(14);
      int i9 = f.a.a.b.b.a.fK(15);
      int i10 = f.a.a.b.b.a.fK(16);
      int i11 = f.a.a.b.b.a.fK(17);
      int i12 = f.a.a.b.b.a.fK(18);
      AppMethodBeat.o(116469);
      return paramInt + 1 + 0 + (i + 1) + (j + 1) + (k + 1) + (m + 1) + (n + 1) + (i1 + 1) + (i2 + 1) + (i3 + 1) + (i4 + 1) + (i5 + 1) + (i6 + 1) + (i7 + 1) + (i8 + 1) + (i9 + 1) + (i10 + 1) + (i11 + 1) + (i12 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(116469);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aif localaif = (aif)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116469);
        return -1;
      case 1: 
        localaif.ECL = locala.LVo.fZX();
        AppMethodBeat.o(116469);
        return 0;
      case 2: 
        localaif.ECM = locala.LVo.fZX();
        AppMethodBeat.o(116469);
        return 0;
      case 3: 
        localaif.ECN = locala.LVo.fZX();
        AppMethodBeat.o(116469);
        return 0;
      case 4: 
        localaif.ECO = locala.LVo.fZX();
        AppMethodBeat.o(116469);
        return 0;
      case 5: 
        localaif.ECP = locala.LVo.fZX();
        AppMethodBeat.o(116469);
        return 0;
      case 6: 
        localaif.ECQ = locala.LVo.fZX();
        AppMethodBeat.o(116469);
        return 0;
      case 7: 
        localaif.ECR = locala.LVo.fZX();
        AppMethodBeat.o(116469);
        return 0;
      case 8: 
        localaif.ECS = locala.LVo.fZX();
        AppMethodBeat.o(116469);
        return 0;
      case 9: 
        localaif.ECT = locala.LVo.fZX();
        AppMethodBeat.o(116469);
        return 0;
      case 10: 
        localaif.ECU = locala.LVo.fZX();
        AppMethodBeat.o(116469);
        return 0;
      case 11: 
        localaif.ECV = locala.LVo.fZX();
        AppMethodBeat.o(116469);
        return 0;
      case 12: 
        localaif.ECW = locala.LVo.fZX();
        AppMethodBeat.o(116469);
        return 0;
      case 13: 
        localaif.ECX = locala.LVo.fZX();
        AppMethodBeat.o(116469);
        return 0;
      case 14: 
        localaif.ECY = locala.LVo.fZX();
        AppMethodBeat.o(116469);
        return 0;
      case 15: 
        localaif.ECZ = locala.LVo.fZX();
        AppMethodBeat.o(116469);
        return 0;
      case 16: 
        localaif.EDa = locala.LVo.fZX();
        AppMethodBeat.o(116469);
        return 0;
      case 17: 
        localaif.EDb = locala.LVo.fZX();
        AppMethodBeat.o(116469);
        return 0;
      }
      localaif.EDc = locala.LVo.fZX();
      AppMethodBeat.o(116469);
      return 0;
    }
    AppMethodBeat.o(116469);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aif
 * JD-Core Version:    0.7.0.1
 */