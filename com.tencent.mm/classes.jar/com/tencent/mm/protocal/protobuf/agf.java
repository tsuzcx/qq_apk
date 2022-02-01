package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class agf
  extends com.tencent.mm.bx.a
{
  public boolean Diq = false;
  public boolean Dir = false;
  public boolean Dis = false;
  public boolean Dit = false;
  public boolean Diu = false;
  public int dpd;
  public String dtN;
  public String label;
  public double lat;
  public double lng;
  
  public final agf B(double paramDouble)
  {
    this.lng = paramDouble;
    this.Diq = true;
    return this;
  }
  
  public final agf C(double paramDouble)
  {
    this.lat = paramDouble;
    this.Dir = true;
    return this;
  }
  
  public final agf VI(int paramInt)
  {
    this.dpd = paramInt;
    this.Dis = true;
    return this;
  }
  
  public final agf aEc(String paramString)
  {
    this.label = paramString;
    this.Dit = true;
    return this;
  }
  
  public final agf aEd(String paramString)
  {
    this.dtN = paramString;
    this.Diu = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127466);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Diq == true) {
        paramVarArgs.e(1, this.lng);
      }
      if (this.Dir == true) {
        paramVarArgs.e(2, this.lat);
      }
      if (this.Dis == true) {
        paramVarArgs.aR(3, this.dpd);
      }
      if (this.label != null) {
        paramVarArgs.d(4, this.label);
      }
      if (this.dtN != null) {
        paramVarArgs.d(5, this.dtN);
      }
      AppMethodBeat.o(127466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Diq != true) {
        break label494;
      }
    }
    label494:
    for (int i = f.a.a.b.b.a.fY(1) + 8 + 0;; i = 0)
    {
      paramInt = i;
      if (this.Dir == true) {
        paramInt = i + (f.a.a.b.b.a.fY(2) + 8);
      }
      i = paramInt;
      if (this.Dis == true) {
        i = paramInt + f.a.a.b.b.a.bA(3, this.dpd);
      }
      paramInt = i;
      if (this.label != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.label);
      }
      i = paramInt;
      if (this.dtN != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dtN);
      }
      AppMethodBeat.o(127466);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(127466);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        agf localagf = (agf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127466);
          return -1;
        case 1: 
          localagf.lng = Double.longBitsToDouble(locala.KhF.fHy());
          localagf.Diq = true;
          AppMethodBeat.o(127466);
          return 0;
        case 2: 
          localagf.lat = Double.longBitsToDouble(locala.KhF.fHy());
          localagf.Dir = true;
          AppMethodBeat.o(127466);
          return 0;
        case 3: 
          localagf.dpd = locala.KhF.xS();
          localagf.Dis = true;
          AppMethodBeat.o(127466);
          return 0;
        case 4: 
          localagf.label = locala.KhF.readString();
          localagf.Dit = true;
          AppMethodBeat.o(127466);
          return 0;
        }
        localagf.dtN = locala.KhF.readString();
        localagf.Diu = true;
        AppMethodBeat.o(127466);
        return 0;
      }
      AppMethodBeat.o(127466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agf
 * JD-Core Version:    0.7.0.1
 */