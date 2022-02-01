package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahe
  extends com.tencent.mm.bw.a
{
  public boolean EBA = false;
  public boolean EBw = false;
  public boolean EBx = false;
  public boolean EBy = false;
  public boolean EBz = false;
  public int dmN;
  public String dry;
  public String label;
  public double lat;
  public double lng;
  
  public final ahe A(double paramDouble)
  {
    this.lng = paramDouble;
    this.EBw = true;
    return this;
  }
  
  public final ahe B(double paramDouble)
  {
    this.lat = paramDouble;
    this.EBx = true;
    return this;
  }
  
  public final ahe XR(int paramInt)
  {
    this.dmN = paramInt;
    this.EBy = true;
    return this;
  }
  
  public final ahe aJt(String paramString)
  {
    this.label = paramString;
    this.EBz = true;
    return this;
  }
  
  public final ahe aJu(String paramString)
  {
    this.dry = paramString;
    this.EBA = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127466);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EBw == true) {
        paramVarArgs.e(1, this.lng);
      }
      if (this.EBx == true) {
        paramVarArgs.e(2, this.lat);
      }
      if (this.EBy == true) {
        paramVarArgs.aR(3, this.dmN);
      }
      if (this.label != null) {
        paramVarArgs.d(4, this.label);
      }
      if (this.dry != null) {
        paramVarArgs.d(5, this.dry);
      }
      AppMethodBeat.o(127466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EBw != true) {
        break label494;
      }
    }
    label494:
    for (int i = f.a.a.b.b.a.fK(1) + 8 + 0;; i = 0)
    {
      paramInt = i;
      if (this.EBx == true) {
        paramInt = i + (f.a.a.b.b.a.fK(2) + 8);
      }
      i = paramInt;
      if (this.EBy == true) {
        i = paramInt + f.a.a.b.b.a.bx(3, this.dmN);
      }
      paramInt = i;
      if (this.label != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.label);
      }
      i = paramInt;
      if (this.dry != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dry);
      }
      AppMethodBeat.o(127466);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(127466);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ahe localahe = (ahe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127466);
          return -1;
        case 1: 
          localahe.lng = Double.longBitsToDouble(locala.LVo.gab());
          localahe.EBw = true;
          AppMethodBeat.o(127466);
          return 0;
        case 2: 
          localahe.lat = Double.longBitsToDouble(locala.LVo.gab());
          localahe.EBx = true;
          AppMethodBeat.o(127466);
          return 0;
        case 3: 
          localahe.dmN = locala.LVo.xF();
          localahe.EBy = true;
          AppMethodBeat.o(127466);
          return 0;
        case 4: 
          localahe.label = locala.LVo.readString();
          localahe.EBz = true;
          AppMethodBeat.o(127466);
          return 0;
        }
        localahe.dry = locala.LVo.readString();
        localahe.EBA = true;
        AppMethodBeat.o(127466);
        return 0;
      }
      AppMethodBeat.o(127466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahe
 * JD-Core Version:    0.7.0.1
 */