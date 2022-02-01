package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dvq
  extends com.tencent.mm.bx.a
{
  public int HHV;
  public String HHW;
  public String HHX;
  public int HHY;
  public String HHZ;
  public int HIa;
  public int HIb;
  public String HIc;
  public String HqF;
  public String duW;
  public int guN;
  public String hzB;
  public String title;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176157);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.duW != null) {
        paramVarArgs.d(2, this.duW);
      }
      paramVarArgs.aS(3, this.version);
      if (this.hzB != null) {
        paramVarArgs.d(4, this.hzB);
      }
      paramVarArgs.aS(5, this.HHV);
      if (this.HHW != null) {
        paramVarArgs.d(6, this.HHW);
      }
      if (this.HHX != null) {
        paramVarArgs.d(7, this.HHX);
      }
      paramVarArgs.aS(8, this.HHY);
      if (this.HHZ != null) {
        paramVarArgs.d(9, this.HHZ);
      }
      paramVarArgs.aS(10, this.guN);
      paramVarArgs.aS(11, this.HIa);
      paramVarArgs.aS(12, this.HIb);
      if (this.HIc != null) {
        paramVarArgs.d(13, this.HIc);
      }
      if (this.HqF != null) {
        paramVarArgs.d(14, this.HqF);
      }
      AppMethodBeat.o(176157);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label914;
      }
    }
    label914:
    for (paramInt = f.a.a.b.b.a.e(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.duW != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.duW);
      }
      i += f.a.a.b.b.a.bz(3, this.version);
      paramInt = i;
      if (this.hzB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hzB);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.HHV);
      paramInt = i;
      if (this.HHW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HHW);
      }
      i = paramInt;
      if (this.HHX != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HHX);
      }
      i += f.a.a.b.b.a.bz(8, this.HHY);
      paramInt = i;
      if (this.HHZ != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.HHZ);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.guN) + f.a.a.b.b.a.bz(11, this.HIa) + f.a.a.b.b.a.bz(12, this.HIb);
      paramInt = i;
      if (this.HIc != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.HIc);
      }
      i = paramInt;
      if (this.HqF != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.HqF);
      }
      AppMethodBeat.o(176157);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(176157);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dvq localdvq = (dvq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(176157);
          return -1;
        case 1: 
          localdvq.title = locala.NPN.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 2: 
          localdvq.duW = locala.NPN.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 3: 
          localdvq.version = locala.NPN.zc();
          AppMethodBeat.o(176157);
          return 0;
        case 4: 
          localdvq.hzB = locala.NPN.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 5: 
          localdvq.HHV = locala.NPN.zc();
          AppMethodBeat.o(176157);
          return 0;
        case 6: 
          localdvq.HHW = locala.NPN.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 7: 
          localdvq.HHX = locala.NPN.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 8: 
          localdvq.HHY = locala.NPN.zc();
          AppMethodBeat.o(176157);
          return 0;
        case 9: 
          localdvq.HHZ = locala.NPN.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 10: 
          localdvq.guN = locala.NPN.zc();
          AppMethodBeat.o(176157);
          return 0;
        case 11: 
          localdvq.HIa = locala.NPN.zc();
          AppMethodBeat.o(176157);
          return 0;
        case 12: 
          localdvq.HIb = locala.NPN.zc();
          AppMethodBeat.o(176157);
          return 0;
        case 13: 
          localdvq.HIc = locala.NPN.readString();
          AppMethodBeat.o(176157);
          return 0;
        }
        localdvq.HqF = locala.NPN.readString();
        AppMethodBeat.o(176157);
        return 0;
      }
      AppMethodBeat.o(176157);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvq
 * JD-Core Version:    0.7.0.1
 */