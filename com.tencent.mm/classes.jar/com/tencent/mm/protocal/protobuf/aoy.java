package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aoy
  extends com.tencent.mm.bx.a
{
  public String Gnu;
  public float dAp;
  public float dyz;
  public String ePu;
  public String ePv;
  public String inD;
  public String jDf;
  public String zSk;
  public int zSm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169004);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.z(1, this.dAp);
      paramVarArgs.z(2, this.dyz);
      if (this.ePv != null) {
        paramVarArgs.d(3, this.ePv);
      }
      if (this.jDf != null) {
        paramVarArgs.d(4, this.jDf);
      }
      if (this.zSk != null) {
        paramVarArgs.d(5, this.zSk);
      }
      if (this.Gnu != null) {
        paramVarArgs.d(6, this.Gnu);
      }
      paramVarArgs.aS(7, this.zSm);
      if (this.ePu != null) {
        paramVarArgs.d(8, this.ePu);
      }
      if (this.inD != null) {
        paramVarArgs.d(9, this.inD);
      }
      AppMethodBeat.o(169004);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.alU(1) + 0 + f.a.a.b.b.a.alU(2);
      paramInt = i;
      if (this.ePv != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ePv);
      }
      i = paramInt;
      if (this.jDf != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.jDf);
      }
      paramInt = i;
      if (this.zSk != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.zSk);
      }
      i = paramInt;
      if (this.Gnu != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Gnu);
      }
      i += f.a.a.b.b.a.bz(7, this.zSm);
      paramInt = i;
      if (this.ePu != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.ePu);
      }
      i = paramInt;
      if (this.inD != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.inD);
      }
      AppMethodBeat.o(169004);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(169004);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aoy localaoy = (aoy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169004);
        return -1;
      case 1: 
        localaoy.dAp = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(169004);
        return 0;
      case 2: 
        localaoy.dyz = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(169004);
        return 0;
      case 3: 
        localaoy.ePv = locala.NPN.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 4: 
        localaoy.jDf = locala.NPN.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 5: 
        localaoy.zSk = locala.NPN.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 6: 
        localaoy.Gnu = locala.NPN.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 7: 
        localaoy.zSm = locala.NPN.zc();
        AppMethodBeat.o(169004);
        return 0;
      case 8: 
        localaoy.ePu = locala.NPN.readString();
        AppMethodBeat.o(169004);
        return 0;
      }
      localaoy.inD = locala.NPN.readString();
      AppMethodBeat.o(169004);
      return 0;
    }
    AppMethodBeat.o(169004);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoy
 * JD-Core Version:    0.7.0.1
 */