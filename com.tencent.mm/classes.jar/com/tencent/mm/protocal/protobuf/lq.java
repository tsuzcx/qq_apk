package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lq
  extends com.tencent.mm.bx.a
{
  public int Idd;
  public String YNe;
  public String YNj;
  public dph YNk;
  public cyx YNl;
  public String vgW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82393);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Idd);
      if (this.YNj != null) {
        paramVarArgs.g(2, this.YNj);
      }
      if (this.YNk != null)
      {
        paramVarArgs.qD(3, this.YNk.computeSize());
        this.YNk.writeFields(paramVarArgs);
      }
      if (this.YNe != null) {
        paramVarArgs.g(4, this.YNe);
      }
      if (this.vgW != null) {
        paramVarArgs.g(5, this.vgW);
      }
      if (this.YNl != null)
      {
        paramVarArgs.qD(6, this.YNl.computeSize());
        this.YNl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(82393);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.Idd) + 0;
      paramInt = i;
      if (this.YNj != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YNj);
      }
      i = paramInt;
      if (this.YNk != null) {
        i = paramInt + i.a.a.a.qC(3, this.YNk.computeSize());
      }
      paramInt = i;
      if (this.YNe != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YNe);
      }
      i = paramInt;
      if (this.vgW != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.vgW);
      }
      paramInt = i;
      if (this.YNl != null) {
        paramInt = i + i.a.a.a.qC(6, this.YNl.computeSize());
      }
      AppMethodBeat.o(82393);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(82393);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      lq locallq = (lq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(82393);
        return -1;
      case 1: 
        locallq.Idd = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(82393);
        return 0;
      case 2: 
        locallq.YNj = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(82393);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dph();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dph)localObject2).parseFrom((byte[])localObject1);
          }
          locallq.YNk = ((dph)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(82393);
        return 0;
      case 4: 
        locallq.YNe = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(82393);
        return 0;
      case 5: 
        locallq.vgW = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(82393);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new cyx();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((cyx)localObject2).parseFrom((byte[])localObject1);
        }
        locallq.YNl = ((cyx)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(82393);
      return 0;
    }
    AppMethodBeat.o(82393);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lq
 * JD-Core Version:    0.7.0.1
 */