package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ant
  extends com.tencent.mm.cd.a
{
  public boolean SAo = false;
  public boolean SAp = false;
  public boolean SAq = false;
  public boolean SAr = false;
  public boolean SAs = false;
  public int fKJ;
  public String fPN;
  public String label;
  public double lat;
  public double lng;
  
  public final ant D(double paramDouble)
  {
    this.lng = paramDouble;
    this.SAo = true;
    return this;
  }
  
  public final ant E(double paramDouble)
  {
    this.lat = paramDouble;
    this.SAp = true;
    return this;
  }
  
  public final ant arv(int paramInt)
  {
    this.fKJ = paramInt;
    this.SAq = true;
    return this;
  }
  
  public final ant bto(String paramString)
  {
    this.label = paramString;
    this.SAr = true;
    return this;
  }
  
  public final ant btp(String paramString)
  {
    this.fPN = paramString;
    this.SAs = true;
    return this;
  }
  
  public final int hpD()
  {
    return this.fKJ;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127466);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SAo == true) {
        paramVarArgs.e(1, this.lng);
      }
      if (this.SAp == true) {
        paramVarArgs.e(2, this.lat);
      }
      if (this.SAq == true) {
        paramVarArgs.aY(3, this.fKJ);
      }
      if (this.label != null) {
        paramVarArgs.f(4, this.label);
      }
      if (this.fPN != null) {
        paramVarArgs.f(5, this.fPN);
      }
      AppMethodBeat.o(127466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SAo != true) {
        break label494;
      }
    }
    label494:
    for (int i = g.a.a.b.b.a.gL(1) + 8 + 0;; i = 0)
    {
      paramInt = i;
      if (this.SAp == true) {
        paramInt = i + (g.a.a.b.b.a.gL(2) + 8);
      }
      i = paramInt;
      if (this.SAq == true) {
        i = paramInt + g.a.a.b.b.a.bM(3, this.fKJ);
      }
      paramInt = i;
      if (this.label != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.label);
      }
      i = paramInt;
      if (this.fPN != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.fPN);
      }
      AppMethodBeat.o(127466);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(127466);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ant localant = (ant)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127466);
          return -1;
        case 1: 
          localant.lng = Double.longBitsToDouble(locala.abFh.AP());
          localant.SAo = true;
          AppMethodBeat.o(127466);
          return 0;
        case 2: 
          localant.lat = Double.longBitsToDouble(locala.abFh.AP());
          localant.SAp = true;
          AppMethodBeat.o(127466);
          return 0;
        case 3: 
          localant.fKJ = locala.abFh.AK();
          localant.SAq = true;
          AppMethodBeat.o(127466);
          return 0;
        case 4: 
          localant.label = locala.abFh.readString();
          localant.SAr = true;
          AppMethodBeat.o(127466);
          return 0;
        }
        localant.fPN = locala.abFh.readString();
        localant.SAs = true;
        AppMethodBeat.o(127466);
        return 0;
      }
      AppMethodBeat.o(127466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ant
 * JD-Core Version:    0.7.0.1
 */