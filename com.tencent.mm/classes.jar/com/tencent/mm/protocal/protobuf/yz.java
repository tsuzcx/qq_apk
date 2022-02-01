package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class yz
  extends com.tencent.mm.bw.a
{
  public String LjZ;
  public String Lka;
  public String Lkb;
  public String Lkc;
  public String Lkd;
  public String Lke;
  public int Scene;
  public int oUv;
  public String yiZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127628);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Scene);
      paramVarArgs.aM(2, this.oUv);
      if (this.LjZ != null) {
        paramVarArgs.e(3, this.LjZ);
      }
      if (this.Lka != null) {
        paramVarArgs.e(4, this.Lka);
      }
      if (this.yiZ != null) {
        paramVarArgs.e(5, this.yiZ);
      }
      if (this.Lkb != null) {
        paramVarArgs.e(6, this.Lkb);
      }
      if (this.Lkc != null) {
        paramVarArgs.e(7, this.Lkc);
      }
      if (this.Lkd != null) {
        paramVarArgs.e(8, this.Lkd);
      }
      if (this.Lke != null) {
        paramVarArgs.e(9, this.Lke);
      }
      AppMethodBeat.o(127628);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Scene) + 0 + g.a.a.b.b.a.bu(2, this.oUv);
      paramInt = i;
      if (this.LjZ != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.LjZ);
      }
      i = paramInt;
      if (this.Lka != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.Lka);
      }
      paramInt = i;
      if (this.yiZ != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.yiZ);
      }
      i = paramInt;
      if (this.Lkb != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.Lkb);
      }
      paramInt = i;
      if (this.Lkc != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Lkc);
      }
      i = paramInt;
      if (this.Lkd != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.Lkd);
      }
      paramInt = i;
      if (this.Lke != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.Lke);
      }
      AppMethodBeat.o(127628);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(127628);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      yz localyz = (yz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127628);
        return -1;
      case 1: 
        localyz.Scene = locala.UbS.zi();
        AppMethodBeat.o(127628);
        return 0;
      case 2: 
        localyz.oUv = locala.UbS.zi();
        AppMethodBeat.o(127628);
        return 0;
      case 3: 
        localyz.LjZ = locala.UbS.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 4: 
        localyz.Lka = locala.UbS.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 5: 
        localyz.yiZ = locala.UbS.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 6: 
        localyz.Lkb = locala.UbS.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 7: 
        localyz.Lkc = locala.UbS.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 8: 
        localyz.Lkd = locala.UbS.readString();
        AppMethodBeat.o(127628);
        return 0;
      }
      localyz.Lke = locala.UbS.readString();
      AppMethodBeat.o(127628);
      return 0;
    }
    AppMethodBeat.o(127628);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yz
 * JD-Core Version:    0.7.0.1
 */