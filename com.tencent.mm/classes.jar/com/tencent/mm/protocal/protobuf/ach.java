package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ach
  extends com.tencent.mm.bv.a
{
  public String cDl;
  public int cyX;
  public String label;
  public double lat;
  public double lng;
  public boolean wUN = false;
  public boolean wUO = false;
  public boolean wUP = false;
  public boolean wUQ = false;
  public boolean wUR = false;
  
  public final ach C(double paramDouble)
  {
    this.lng = paramDouble;
    this.wUN = true;
    return this;
  }
  
  public final ach D(double paramDouble)
  {
    this.lat = paramDouble;
    this.wUO = true;
    return this;
  }
  
  public final ach MN(int paramInt)
  {
    this.cyX = paramInt;
    this.wUP = true;
    return this;
  }
  
  public final ach aoe(String paramString)
  {
    this.label = paramString;
    this.wUQ = true;
    return this;
  }
  
  public final ach aof(String paramString)
  {
    this.cDl = paramString;
    this.wUR = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51399);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wUN == true) {
        paramVarArgs.f(1, this.lng);
      }
      if (this.wUO == true) {
        paramVarArgs.f(2, this.lat);
      }
      if (this.wUP == true) {
        paramVarArgs.aO(3, this.cyX);
      }
      if (this.label != null) {
        paramVarArgs.e(4, this.label);
      }
      if (this.cDl != null) {
        paramVarArgs.e(5, this.cDl);
      }
      AppMethodBeat.o(51399);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wUN != true) {
        break label494;
      }
    }
    label494:
    for (int i = e.a.a.b.b.a.eW(1) + 8 + 0;; i = 0)
    {
      paramInt = i;
      if (this.wUO == true) {
        paramInt = i + (e.a.a.b.b.a.eW(2) + 8);
      }
      i = paramInt;
      if (this.wUP == true) {
        i = paramInt + e.a.a.b.b.a.bl(3, this.cyX);
      }
      paramInt = i;
      if (this.label != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.label);
      }
      i = paramInt;
      if (this.cDl != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.cDl);
      }
      AppMethodBeat.o(51399);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(51399);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ach localach = (ach)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(51399);
          return -1;
        case 1: 
          localach.lng = Double.longBitsToDouble(locala.CLY.emy());
          localach.wUN = true;
          AppMethodBeat.o(51399);
          return 0;
        case 2: 
          localach.lat = Double.longBitsToDouble(locala.CLY.emy());
          localach.wUO = true;
          AppMethodBeat.o(51399);
          return 0;
        case 3: 
          localach.cyX = locala.CLY.sl();
          localach.wUP = true;
          AppMethodBeat.o(51399);
          return 0;
        case 4: 
          localach.label = locala.CLY.readString();
          localach.wUQ = true;
          AppMethodBeat.o(51399);
          return 0;
        }
        localach.cDl = locala.CLY.readString();
        localach.wUR = true;
        AppMethodBeat.o(51399);
        return 0;
      }
      AppMethodBeat.o(51399);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ach
 * JD-Core Version:    0.7.0.1
 */