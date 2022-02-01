package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class tl
  extends com.tencent.mm.bx.a
{
  public String FRk;
  public String FRl;
  public String country;
  public float dAp;
  public String descriptor;
  public float dyz;
  public String ePu;
  public String ePv;
  public String hWY;
  public String name;
  public String oyb;
  public String ozD;
  public float zxp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113969);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.d(1, this.name);
      }
      if (this.descriptor != null) {
        paramVarArgs.d(2, this.descriptor);
      }
      if (this.oyb != null) {
        paramVarArgs.d(3, this.oyb);
      }
      if (this.country != null) {
        paramVarArgs.d(4, this.country);
      }
      if (this.ePu != null) {
        paramVarArgs.d(5, this.ePu);
      }
      if (this.ePv != null) {
        paramVarArgs.d(6, this.ePv);
      }
      if (this.hWY != null) {
        paramVarArgs.d(7, this.hWY);
      }
      paramVarArgs.z(8, this.zxp);
      paramVarArgs.z(9, this.dAp);
      paramVarArgs.z(10, this.dyz);
      if (this.ozD != null) {
        paramVarArgs.d(11, this.ozD);
      }
      if (this.FRk != null) {
        paramVarArgs.d(12, this.FRk);
      }
      if (this.FRl != null) {
        paramVarArgs.d(13, this.FRl);
      }
      AppMethodBeat.o(113969);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label895;
      }
    }
    label895:
    for (int i = f.a.a.b.b.a.e(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.descriptor != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.descriptor);
      }
      i = paramInt;
      if (this.oyb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oyb);
      }
      paramInt = i;
      if (this.country != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.country);
      }
      i = paramInt;
      if (this.ePu != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ePu);
      }
      paramInt = i;
      if (this.ePv != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ePv);
      }
      i = paramInt;
      if (this.hWY != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.hWY);
      }
      i = i + f.a.a.b.b.a.alU(8) + f.a.a.b.b.a.alU(9) + f.a.a.b.b.a.alU(10);
      paramInt = i;
      if (this.ozD != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.ozD);
      }
      i = paramInt;
      if (this.FRk != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.FRk);
      }
      paramInt = i;
      if (this.FRl != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FRl);
      }
      AppMethodBeat.o(113969);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(113969);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        tl localtl = (tl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113969);
          return -1;
        case 1: 
          localtl.name = locala.NPN.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 2: 
          localtl.descriptor = locala.NPN.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 3: 
          localtl.oyb = locala.NPN.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 4: 
          localtl.country = locala.NPN.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 5: 
          localtl.ePu = locala.NPN.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 6: 
          localtl.ePv = locala.NPN.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 7: 
          localtl.hWY = locala.NPN.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 8: 
          localtl.zxp = Float.intBitsToFloat(locala.NPN.grz());
          AppMethodBeat.o(113969);
          return 0;
        case 9: 
          localtl.dAp = Float.intBitsToFloat(locala.NPN.grz());
          AppMethodBeat.o(113969);
          return 0;
        case 10: 
          localtl.dyz = Float.intBitsToFloat(locala.NPN.grz());
          AppMethodBeat.o(113969);
          return 0;
        case 11: 
          localtl.ozD = locala.NPN.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 12: 
          localtl.FRk = locala.NPN.readString();
          AppMethodBeat.o(113969);
          return 0;
        }
        localtl.FRl = locala.NPN.readString();
        AppMethodBeat.o(113969);
        return 0;
      }
      AppMethodBeat.o(113969);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tl
 * JD-Core Version:    0.7.0.1
 */