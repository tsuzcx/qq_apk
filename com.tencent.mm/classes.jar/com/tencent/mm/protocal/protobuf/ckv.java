package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckv
  extends com.tencent.mm.bx.a
{
  public float FOA;
  public float FOB;
  public String GJH;
  public String Hei;
  public String Hej;
  public long Hek;
  public String jde;
  public String jdl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117892);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hei != null) {
        paramVarArgs.d(1, this.Hei);
      }
      if (this.jdl != null) {
        paramVarArgs.d(2, this.jdl);
      }
      if (this.jde != null) {
        paramVarArgs.d(3, this.jde);
      }
      if (this.GJH != null) {
        paramVarArgs.d(4, this.GJH);
      }
      paramVarArgs.z(5, this.FOB);
      paramVarArgs.z(6, this.FOA);
      if (this.Hej != null) {
        paramVarArgs.d(7, this.Hej);
      }
      paramVarArgs.aY(8, this.Hek);
      AppMethodBeat.o(117892);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hei == null) {
        break label588;
      }
    }
    label588:
    for (int i = f.a.a.b.b.a.e(1, this.Hei) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jdl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.jdl);
      }
      i = paramInt;
      if (this.jde != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.jde);
      }
      paramInt = i;
      if (this.GJH != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GJH);
      }
      i = paramInt + f.a.a.b.b.a.alU(5) + f.a.a.b.b.a.alU(6);
      paramInt = i;
      if (this.Hej != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Hej);
      }
      i = f.a.a.b.b.a.p(8, this.Hek);
      AppMethodBeat.o(117892);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117892);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ckv localckv = (ckv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117892);
          return -1;
        case 1: 
          localckv.Hei = locala.NPN.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 2: 
          localckv.jdl = locala.NPN.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 3: 
          localckv.jde = locala.NPN.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 4: 
          localckv.GJH = locala.NPN.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 5: 
          localckv.FOB = Float.intBitsToFloat(locala.NPN.grz());
          AppMethodBeat.o(117892);
          return 0;
        case 6: 
          localckv.FOA = Float.intBitsToFloat(locala.NPN.grz());
          AppMethodBeat.o(117892);
          return 0;
        case 7: 
          localckv.Hej = locala.NPN.readString();
          AppMethodBeat.o(117892);
          return 0;
        }
        localckv.Hek = locala.NPN.zd();
        AppMethodBeat.o(117892);
        return 0;
      }
      AppMethodBeat.o(117892);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckv
 * JD-Core Version:    0.7.0.1
 */