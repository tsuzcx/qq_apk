package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class arm
  extends com.tencent.mm.bx.a
{
  public boolean ZBg = false;
  public boolean ZBh = false;
  public boolean ZBi = false;
  public boolean ZBj = false;
  public boolean ZBk = false;
  public int hQp;
  public String hVI;
  public String label;
  public double lat;
  public double lng;
  
  public final arm V(double paramDouble)
  {
    this.lng = paramDouble;
    this.ZBg = true;
    return this;
  }
  
  public final arm W(double paramDouble)
  {
    this.lat = paramDouble;
    this.ZBh = true;
    return this;
  }
  
  public final arm axD(int paramInt)
  {
    this.hQp = paramInt;
    this.ZBi = true;
    return this;
  }
  
  public final arm btf(String paramString)
  {
    this.label = paramString;
    this.ZBj = true;
    return this;
  }
  
  public final arm btg(String paramString)
  {
    this.hVI = paramString;
    this.ZBk = true;
    return this;
  }
  
  public final int iQr()
  {
    return this.hQp;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127466);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZBg == true) {
        paramVarArgs.d(1, this.lng);
      }
      if (this.ZBh == true) {
        paramVarArgs.d(2, this.lat);
      }
      if (this.ZBi == true) {
        paramVarArgs.bS(3, this.hQp);
      }
      if (this.label != null) {
        paramVarArgs.g(4, this.label);
      }
      if (this.hVI != null) {
        paramVarArgs.g(5, this.hVI);
      }
      AppMethodBeat.o(127466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZBg != true) {
        break label490;
      }
    }
    label490:
    for (int i = i.a.a.b.b.a.ko(1) + 8 + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZBh == true) {
        paramInt = i + (i.a.a.b.b.a.ko(2) + 8);
      }
      i = paramInt;
      if (this.ZBi == true) {
        i = paramInt + i.a.a.b.b.a.cJ(3, this.hQp);
      }
      paramInt = i;
      if (this.label != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.label);
      }
      i = paramInt;
      if (this.hVI != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.hVI);
      }
      AppMethodBeat.o(127466);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(127466);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        arm localarm = (arm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127466);
          return -1;
        case 1: 
          localarm.lng = Double.longBitsToDouble(locala.ajGk.aay());
          localarm.ZBg = true;
          AppMethodBeat.o(127466);
          return 0;
        case 2: 
          localarm.lat = Double.longBitsToDouble(locala.ajGk.aay());
          localarm.ZBh = true;
          AppMethodBeat.o(127466);
          return 0;
        case 3: 
          localarm.hQp = locala.ajGk.aar();
          localarm.ZBi = true;
          AppMethodBeat.o(127466);
          return 0;
        case 4: 
          localarm.label = locala.ajGk.readString();
          localarm.ZBj = true;
          AppMethodBeat.o(127466);
          return 0;
        }
        localarm.hVI = locala.ajGk.readString();
        localarm.ZBk = true;
        AppMethodBeat.o(127466);
        return 0;
      }
      AppMethodBeat.o(127466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arm
 * JD-Core Version:    0.7.0.1
 */