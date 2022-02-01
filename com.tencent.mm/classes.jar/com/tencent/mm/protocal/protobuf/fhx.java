package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class fhx
  extends com.tencent.mm.bx.a
{
  public b abIJ;
  public amk abIK;
  public amj abIL;
  public int height;
  public String path;
  public int type;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257361);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.path != null) {
        paramVarArgs.g(2, this.path);
      }
      if (this.abIJ != null) {
        paramVarArgs.d(3, this.abIJ);
      }
      paramVarArgs.bS(4, this.width);
      paramVarArgs.bS(5, this.height);
      if (this.abIK != null)
      {
        paramVarArgs.qD(6, this.abIK.computeSize());
        this.abIK.writeFields(paramVarArgs);
      }
      if (this.abIL != null)
      {
        paramVarArgs.qD(7, this.abIL.computeSize());
        this.abIL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257361);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.path != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.path);
      }
      i = paramInt;
      if (this.abIJ != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.abIJ);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.width) + i.a.a.b.b.a.cJ(5, this.height);
      paramInt = i;
      if (this.abIK != null) {
        paramInt = i + i.a.a.a.qC(6, this.abIK.computeSize());
      }
      i = paramInt;
      if (this.abIL != null) {
        i = paramInt + i.a.a.a.qC(7, this.abIL.computeSize());
      }
      AppMethodBeat.o(257361);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257361);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      fhx localfhx = (fhx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257361);
        return -1;
      case 1: 
        localfhx.type = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257361);
        return 0;
      case 2: 
        localfhx.path = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257361);
        return 0;
      case 3: 
        localfhx.abIJ = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(257361);
        return 0;
      case 4: 
        localfhx.width = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257361);
        return 0;
      case 5: 
        localfhx.height = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257361);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new amk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((amk)localObject2).parseFrom((byte[])localObject1);
          }
          localfhx.abIK = ((amk)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257361);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new amj();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((amj)localObject2).parseFrom((byte[])localObject1);
        }
        localfhx.abIL = ((amj)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(257361);
      return 0;
    }
    AppMethodBeat.o(257361);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhx
 * JD-Core Version:    0.7.0.1
 */