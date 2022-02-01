package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aju
  extends com.tencent.mm.bx.a
{
  public boolean Gji = false;
  public boolean Gjj = false;
  public boolean Gjk = false;
  public boolean Gjl = false;
  public boolean Gjm = false;
  public String dDq;
  public int dyB;
  public String label;
  public double lat;
  public double lng;
  
  public final aju A(double paramDouble)
  {
    this.lng = paramDouble;
    this.Gji = true;
    return this;
  }
  
  public final aju B(double paramDouble)
  {
    this.lat = paramDouble;
    this.Gjj = true;
    return this;
  }
  
  public final aju ZN(int paramInt)
  {
    this.dyB = paramInt;
    this.Gjk = true;
    return this;
  }
  
  public final aju aOW(String paramString)
  {
    this.label = paramString;
    this.Gjl = true;
    return this;
  }
  
  public final aju aOX(String paramString)
  {
    this.dDq = paramString;
    this.Gjm = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127466);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gji == true) {
        paramVarArgs.e(1, this.lng);
      }
      if (this.Gjj == true) {
        paramVarArgs.e(2, this.lat);
      }
      if (this.Gjk == true) {
        paramVarArgs.aS(3, this.dyB);
      }
      if (this.label != null) {
        paramVarArgs.d(4, this.label);
      }
      if (this.dDq != null) {
        paramVarArgs.d(5, this.dDq);
      }
      AppMethodBeat.o(127466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gji != true) {
        break label490;
      }
    }
    label490:
    for (int i = f.a.a.b.b.a.alT(1) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gjj == true) {
        paramInt = i + f.a.a.b.b.a.alT(2);
      }
      i = paramInt;
      if (this.Gjk == true) {
        i = paramInt + f.a.a.b.b.a.bz(3, this.dyB);
      }
      paramInt = i;
      if (this.label != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.label);
      }
      i = paramInt;
      if (this.dDq != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dDq);
      }
      AppMethodBeat.o(127466);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(127466);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aju localaju = (aju)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127466);
          return -1;
        case 1: 
          localaju.lng = Double.longBitsToDouble(locala.NPN.grA());
          localaju.Gji = true;
          AppMethodBeat.o(127466);
          return 0;
        case 2: 
          localaju.lat = Double.longBitsToDouble(locala.NPN.grA());
          localaju.Gjj = true;
          AppMethodBeat.o(127466);
          return 0;
        case 3: 
          localaju.dyB = locala.NPN.zc();
          localaju.Gjk = true;
          AppMethodBeat.o(127466);
          return 0;
        case 4: 
          localaju.label = locala.NPN.readString();
          localaju.Gjl = true;
          AppMethodBeat.o(127466);
          return 0;
        }
        localaju.dDq = locala.NPN.readString();
        localaju.Gjm = true;
        AppMethodBeat.o(127466);
        return 0;
      }
      AppMethodBeat.o(127466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aju
 * JD-Core Version:    0.7.0.1
 */