package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ake
  extends com.tencent.mm.bw.a
{
  public boolean GBR = false;
  public boolean GBS = false;
  public boolean GBT = false;
  public boolean GBU = false;
  public boolean GBV = false;
  public String dEv;
  public int dzG;
  public String label;
  public double lat;
  public double lng;
  
  public final ake A(double paramDouble)
  {
    this.lng = paramDouble;
    this.GBR = true;
    return this;
  }
  
  public final ake B(double paramDouble)
  {
    this.lat = paramDouble;
    this.GBS = true;
    return this;
  }
  
  public final ake aQt(String paramString)
  {
    this.label = paramString;
    this.GBU = true;
    return this;
  }
  
  public final ake aQu(String paramString)
  {
    this.dEv = paramString;
    this.GBV = true;
    return this;
  }
  
  public final ake aat(int paramInt)
  {
    this.dzG = paramInt;
    this.GBT = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127466);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GBR == true) {
        paramVarArgs.e(1, this.lng);
      }
      if (this.GBS == true) {
        paramVarArgs.e(2, this.lat);
      }
      if (this.GBT == true) {
        paramVarArgs.aS(3, this.dzG);
      }
      if (this.label != null) {
        paramVarArgs.d(4, this.label);
      }
      if (this.dEv != null) {
        paramVarArgs.d(5, this.dEv);
      }
      AppMethodBeat.o(127466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GBR != true) {
        break label490;
      }
    }
    label490:
    for (int i = f.a.a.b.b.a.amD(1) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GBS == true) {
        paramInt = i + f.a.a.b.b.a.amD(2);
      }
      i = paramInt;
      if (this.GBT == true) {
        i = paramInt + f.a.a.b.b.a.bz(3, this.dzG);
      }
      paramInt = i;
      if (this.label != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.label);
      }
      i = paramInt;
      if (this.dEv != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dEv);
      }
      AppMethodBeat.o(127466);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(127466);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ake localake = (ake)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127466);
          return -1;
        case 1: 
          localake.lng = Double.longBitsToDouble(locala.OmT.gwc());
          localake.GBR = true;
          AppMethodBeat.o(127466);
          return 0;
        case 2: 
          localake.lat = Double.longBitsToDouble(locala.OmT.gwc());
          localake.GBS = true;
          AppMethodBeat.o(127466);
          return 0;
        case 3: 
          localake.dzG = locala.OmT.zc();
          localake.GBT = true;
          AppMethodBeat.o(127466);
          return 0;
        case 4: 
          localake.label = locala.OmT.readString();
          localake.GBU = true;
          AppMethodBeat.o(127466);
          return 0;
        }
        localake.dEv = locala.OmT.readString();
        localake.GBV = true;
        AppMethodBeat.o(127466);
        return 0;
      }
      AppMethodBeat.o(127466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ake
 * JD-Core Version:    0.7.0.1
 */