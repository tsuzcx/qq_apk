package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cih
  extends com.tencent.mm.bx.a
{
  public int YIq;
  public int ZtG;
  public int ZtX;
  public gol aaqV;
  public String aaqW;
  public int aaqX;
  public long aaqY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104784);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YIq);
      paramVarArgs.bS(2, this.ZtX);
      if (this.aaqV != null)
      {
        paramVarArgs.qD(3, this.aaqV.computeSize());
        this.aaqV.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.ZtG);
      if (this.aaqW != null) {
        paramVarArgs.g(5, this.aaqW);
      }
      paramVarArgs.bS(6, this.aaqX);
      paramVarArgs.bv(7, this.aaqY);
      AppMethodBeat.o(104784);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.YIq) + 0 + i.a.a.b.b.a.cJ(2, this.ZtX);
      paramInt = i;
      if (this.aaqV != null) {
        paramInt = i + i.a.a.a.qC(3, this.aaqV.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.ZtG);
      paramInt = i;
      if (this.aaqW != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aaqW);
      }
      i = i.a.a.b.b.a.cJ(6, this.aaqX);
      int j = i.a.a.b.b.a.q(7, this.aaqY);
      AppMethodBeat.o(104784);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(104784);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      cih localcih = (cih)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(104784);
        return -1;
      case 1: 
        localcih.YIq = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(104784);
        return 0;
      case 2: 
        localcih.ZtX = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(104784);
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
          localcih.aaqV = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(104784);
        return 0;
      case 4: 
        localcih.ZtG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(104784);
        return 0;
      case 5: 
        localcih.aaqW = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(104784);
        return 0;
      case 6: 
        localcih.aaqX = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(104784);
        return 0;
      }
      localcih.aaqY = ((i.a.a.a.a)localObject).ajGk.aaw();
      AppMethodBeat.o(104784);
      return 0;
    }
    AppMethodBeat.o(104784);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cih
 * JD-Core Version:    0.7.0.1
 */