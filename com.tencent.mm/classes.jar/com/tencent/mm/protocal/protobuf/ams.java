package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ams
  extends com.tencent.mm.bw.a
{
  public boolean LxN = false;
  public boolean LxO = false;
  public boolean LxP = false;
  public boolean LxQ = false;
  public boolean LxR = false;
  public int dRt;
  public String dWi;
  public String label;
  public double lat;
  public double lng;
  
  public final ams B(double paramDouble)
  {
    this.lng = paramDouble;
    this.LxN = true;
    return this;
  }
  
  public final ams C(double paramDouble)
  {
    this.lat = paramDouble;
    this.LxO = true;
    return this;
  }
  
  public final ams aji(int paramInt)
  {
    this.dRt = paramInt;
    this.LxP = true;
    return this;
  }
  
  public final ams bgW(String paramString)
  {
    this.label = paramString;
    this.LxQ = true;
    return this;
  }
  
  public final ams bgX(String paramString)
  {
    this.dWi = paramString;
    this.LxR = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127466);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LxN == true) {
        paramVarArgs.e(1, this.lng);
      }
      if (this.LxO == true) {
        paramVarArgs.e(2, this.lat);
      }
      if (this.LxP == true) {
        paramVarArgs.aM(3, this.dRt);
      }
      if (this.label != null) {
        paramVarArgs.e(4, this.label);
      }
      if (this.dWi != null) {
        paramVarArgs.e(5, this.dWi);
      }
      AppMethodBeat.o(127466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LxN != true) {
        break label494;
      }
    }
    label494:
    for (int i = g.a.a.b.b.a.fS(1) + 8 + 0;; i = 0)
    {
      paramInt = i;
      if (this.LxO == true) {
        paramInt = i + (g.a.a.b.b.a.fS(2) + 8);
      }
      i = paramInt;
      if (this.LxP == true) {
        i = paramInt + g.a.a.b.b.a.bu(3, this.dRt);
      }
      paramInt = i;
      if (this.label != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.label);
      }
      i = paramInt;
      if (this.dWi != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.dWi);
      }
      AppMethodBeat.o(127466);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(127466);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ams localams = (ams)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127466);
          return -1;
        case 1: 
          localams.lng = Double.longBitsToDouble(locala.UbS.zn());
          localams.LxN = true;
          AppMethodBeat.o(127466);
          return 0;
        case 2: 
          localams.lat = Double.longBitsToDouble(locala.UbS.zn());
          localams.LxO = true;
          AppMethodBeat.o(127466);
          return 0;
        case 3: 
          localams.dRt = locala.UbS.zi();
          localams.LxP = true;
          AppMethodBeat.o(127466);
          return 0;
        case 4: 
          localams.label = locala.UbS.readString();
          localams.LxQ = true;
          AppMethodBeat.o(127466);
          return 0;
        }
        localams.dWi = locala.UbS.readString();
        localams.LxR = true;
        AppMethodBeat.o(127466);
        return 0;
      }
      AppMethodBeat.o(127466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ams
 * JD-Core Version:    0.7.0.1
 */