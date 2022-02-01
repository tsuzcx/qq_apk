package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dtk
  extends com.tencent.mm.bx.a
{
  public String FST;
  public int aaYP;
  public String aaYQ;
  public int aaYR;
  public int aaYS;
  public int aaYT;
  public long aaYU;
  public long aaYV;
  public long aaYW;
  public int aaYX;
  public int aaYY;
  public int aaYZ;
  public int aaZa;
  public long aaZb;
  public int aaZc;
  public int aaZd;
  public int aaZe;
  public int scene;
  public String zIO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259333);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.scene);
      if (this.zIO != null) {
        paramVarArgs.g(2, this.zIO);
      }
      paramVarArgs.bS(3, this.aaYP);
      if (this.aaYQ != null) {
        paramVarArgs.g(4, this.aaYQ);
      }
      paramVarArgs.bS(5, this.aaYR);
      if (this.FST != null) {
        paramVarArgs.g(6, this.FST);
      }
      paramVarArgs.bS(7, this.aaYS);
      paramVarArgs.bS(8, this.aaYT);
      paramVarArgs.bv(9, this.aaYU);
      paramVarArgs.bv(10, this.aaYV);
      paramVarArgs.bv(11, this.aaYW);
      paramVarArgs.bS(12, this.aaYX);
      paramVarArgs.bS(13, this.aaYY);
      paramVarArgs.bS(14, this.aaYZ);
      paramVarArgs.bS(15, this.aaZa);
      paramVarArgs.bv(16, this.aaZb);
      paramVarArgs.bS(17, this.aaZc);
      paramVarArgs.bS(18, this.aaZd);
      paramVarArgs.bS(19, this.aaZe);
      AppMethodBeat.o(259333);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.scene) + 0;
      paramInt = i;
      if (this.zIO != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.zIO);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.aaYP);
      paramInt = i;
      if (this.aaYQ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaYQ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.aaYR);
      paramInt = i;
      if (this.FST != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.FST);
      }
      i = i.a.a.b.b.a.cJ(7, this.aaYS);
      int j = i.a.a.b.b.a.cJ(8, this.aaYT);
      int k = i.a.a.b.b.a.q(9, this.aaYU);
      int m = i.a.a.b.b.a.q(10, this.aaYV);
      int n = i.a.a.b.b.a.q(11, this.aaYW);
      int i1 = i.a.a.b.b.a.cJ(12, this.aaYX);
      int i2 = i.a.a.b.b.a.cJ(13, this.aaYY);
      int i3 = i.a.a.b.b.a.cJ(14, this.aaYZ);
      int i4 = i.a.a.b.b.a.cJ(15, this.aaZa);
      int i5 = i.a.a.b.b.a.q(16, this.aaZb);
      int i6 = i.a.a.b.b.a.cJ(17, this.aaZc);
      int i7 = i.a.a.b.b.a.cJ(18, this.aaZd);
      int i8 = i.a.a.b.b.a.cJ(19, this.aaZe);
      AppMethodBeat.o(259333);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259333);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dtk localdtk = (dtk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259333);
        return -1;
      case 1: 
        localdtk.scene = locala.ajGk.aar();
        AppMethodBeat.o(259333);
        return 0;
      case 2: 
        localdtk.zIO = locala.ajGk.readString();
        AppMethodBeat.o(259333);
        return 0;
      case 3: 
        localdtk.aaYP = locala.ajGk.aar();
        AppMethodBeat.o(259333);
        return 0;
      case 4: 
        localdtk.aaYQ = locala.ajGk.readString();
        AppMethodBeat.o(259333);
        return 0;
      case 5: 
        localdtk.aaYR = locala.ajGk.aar();
        AppMethodBeat.o(259333);
        return 0;
      case 6: 
        localdtk.FST = locala.ajGk.readString();
        AppMethodBeat.o(259333);
        return 0;
      case 7: 
        localdtk.aaYS = locala.ajGk.aar();
        AppMethodBeat.o(259333);
        return 0;
      case 8: 
        localdtk.aaYT = locala.ajGk.aar();
        AppMethodBeat.o(259333);
        return 0;
      case 9: 
        localdtk.aaYU = locala.ajGk.aaw();
        AppMethodBeat.o(259333);
        return 0;
      case 10: 
        localdtk.aaYV = locala.ajGk.aaw();
        AppMethodBeat.o(259333);
        return 0;
      case 11: 
        localdtk.aaYW = locala.ajGk.aaw();
        AppMethodBeat.o(259333);
        return 0;
      case 12: 
        localdtk.aaYX = locala.ajGk.aar();
        AppMethodBeat.o(259333);
        return 0;
      case 13: 
        localdtk.aaYY = locala.ajGk.aar();
        AppMethodBeat.o(259333);
        return 0;
      case 14: 
        localdtk.aaYZ = locala.ajGk.aar();
        AppMethodBeat.o(259333);
        return 0;
      case 15: 
        localdtk.aaZa = locala.ajGk.aar();
        AppMethodBeat.o(259333);
        return 0;
      case 16: 
        localdtk.aaZb = locala.ajGk.aaw();
        AppMethodBeat.o(259333);
        return 0;
      case 17: 
        localdtk.aaZc = locala.ajGk.aar();
        AppMethodBeat.o(259333);
        return 0;
      case 18: 
        localdtk.aaZd = locala.ajGk.aar();
        AppMethodBeat.o(259333);
        return 0;
      }
      localdtk.aaZe = locala.ajGk.aar();
      AppMethodBeat.o(259333);
      return 0;
    }
    AppMethodBeat.o(259333);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtk
 * JD-Core Version:    0.7.0.1
 */