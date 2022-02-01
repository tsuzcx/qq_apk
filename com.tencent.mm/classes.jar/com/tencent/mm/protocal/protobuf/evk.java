package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class evk
  extends com.tencent.mm.bx.a
{
  public gol aaqV;
  public String aaqW;
  public long aaqY;
  public int nUz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104834);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaqW == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(104834);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.nUz);
      if (this.aaqW != null) {
        paramVarArgs.g(2, this.aaqW);
      }
      if (this.aaqV != null)
      {
        paramVarArgs.qD(3, this.aaqV.computeSize());
        this.aaqV.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(4, this.aaqY);
      AppMethodBeat.o(104834);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.nUz) + 0;
      paramInt = i;
      if (this.aaqW != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaqW);
      }
      i = paramInt;
      if (this.aaqV != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaqV.computeSize());
      }
      paramInt = i.a.a.b.b.a.q(4, this.aaqY);
      AppMethodBeat.o(104834);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.aaqW == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(104834);
        throw paramVarArgs;
      }
      AppMethodBeat.o(104834);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      evk localevk = (evk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(104834);
        return -1;
      case 1: 
        localevk.nUz = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(104834);
        return 0;
      case 2: 
        localevk.aaqW = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(104834);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          gol localgol = new gol();
          if ((localObject != null) && (localObject.length > 0)) {
            localgol.dg((byte[])localObject);
          }
          localevk.aaqV = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(104834);
        return 0;
      }
      localevk.aaqY = ((i.a.a.a.a)localObject).ajGk.aaw();
      AppMethodBeat.o(104834);
      return 0;
    }
    AppMethodBeat.o(104834);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evk
 * JD-Core Version:    0.7.0.1
 */