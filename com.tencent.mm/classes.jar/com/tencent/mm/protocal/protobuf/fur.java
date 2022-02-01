package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fur
  extends com.tencent.mm.bx.a
{
  public LinkedList<fus> abaX;
  public boolean rGY;
  public int rGZ;
  public int rHa;
  public String rHb;
  public String rHc;
  public String rHd;
  public String rHe;
  
  public fur()
  {
    AppMethodBeat.i(123670);
    this.abaX = new LinkedList();
    AppMethodBeat.o(123670);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123671);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.abaX);
      paramVarArgs.di(2, this.rGY);
      paramVarArgs.bS(3, this.rGZ);
      paramVarArgs.bS(4, this.rHa);
      if (this.rHb != null) {
        paramVarArgs.g(5, this.rHb);
      }
      if (this.rHc != null) {
        paramVarArgs.g(6, this.rHc);
      }
      if (this.rHd != null) {
        paramVarArgs.g(7, this.rHd);
      }
      if (this.rHe != null) {
        paramVarArgs.g(8, this.rHe);
      }
      AppMethodBeat.o(123671);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.abaX) + 0 + (i.a.a.b.b.a.ko(2) + 1) + i.a.a.b.b.a.cJ(3, this.rGZ) + i.a.a.b.b.a.cJ(4, this.rHa);
      paramInt = i;
      if (this.rHb != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.rHb);
      }
      i = paramInt;
      if (this.rHc != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.rHc);
      }
      paramInt = i;
      if (this.rHd != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.rHd);
      }
      i = paramInt;
      if (this.rHe != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.rHe);
      }
      AppMethodBeat.o(123671);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abaX.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(123671);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fur localfur = (fur)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(123671);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fus localfus = new fus();
          if ((localObject != null) && (localObject.length > 0)) {
            localfus.parseFrom((byte[])localObject);
          }
          localfur.abaX.add(localfus);
          paramInt += 1;
        }
        AppMethodBeat.o(123671);
        return 0;
      case 2: 
        localfur.rGY = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(123671);
        return 0;
      case 3: 
        localfur.rGZ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(123671);
        return 0;
      case 4: 
        localfur.rHa = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(123671);
        return 0;
      case 5: 
        localfur.rHb = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(123671);
        return 0;
      case 6: 
        localfur.rHc = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(123671);
        return 0;
      case 7: 
        localfur.rHd = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(123671);
        return 0;
      }
      localfur.rHe = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(123671);
      return 0;
    }
    AppMethodBeat.o(123671);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fur
 * JD-Core Version:    0.7.0.1
 */