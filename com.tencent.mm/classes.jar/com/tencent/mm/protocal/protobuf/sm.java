package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class sm
  extends com.tencent.mm.bw.a
{
  public String KDR;
  public String KGL;
  public sk LaA;
  public String Lav;
  public b Law;
  public sn Lax;
  public sl Lay;
  public so Laz;
  public String pPy;
  public String pPz;
  public int ybm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(226006);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.ybm);
      if (this.pPy != null) {
        paramVarArgs.e(2, this.pPy);
      }
      if (this.pPz != null) {
        paramVarArgs.e(3, this.pPz);
      }
      if (this.KDR != null) {
        paramVarArgs.e(4, this.KDR);
      }
      if (this.Lav != null) {
        paramVarArgs.e(5, this.Lav);
      }
      if (this.Law != null) {
        paramVarArgs.c(6, this.Law);
      }
      if (this.KGL != null) {
        paramVarArgs.e(7, this.KGL);
      }
      if (this.Lax != null)
      {
        paramVarArgs.ni(101, this.Lax.computeSize());
        this.Lax.writeFields(paramVarArgs);
      }
      if (this.Lay != null)
      {
        paramVarArgs.ni(102, this.Lay.computeSize());
        this.Lay.writeFields(paramVarArgs);
      }
      if (this.Laz != null)
      {
        paramVarArgs.ni(103, this.Laz.computeSize());
        this.Laz.writeFields(paramVarArgs);
      }
      if (this.LaA != null)
      {
        paramVarArgs.ni(107, this.LaA.computeSize());
        this.LaA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(226006);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.ybm) + 0;
      paramInt = i;
      if (this.pPy != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.pPy);
      }
      i = paramInt;
      if (this.pPz != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.pPz);
      }
      paramInt = i;
      if (this.KDR != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KDR);
      }
      i = paramInt;
      if (this.Lav != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Lav);
      }
      paramInt = i;
      if (this.Law != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.Law);
      }
      i = paramInt;
      if (this.KGL != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.KGL);
      }
      paramInt = i;
      if (this.Lax != null) {
        paramInt = i + g.a.a.a.nh(101, this.Lax.computeSize());
      }
      i = paramInt;
      if (this.Lay != null) {
        i = paramInt + g.a.a.a.nh(102, this.Lay.computeSize());
      }
      paramInt = i;
      if (this.Laz != null) {
        paramInt = i + g.a.a.a.nh(103, this.Laz.computeSize());
      }
      i = paramInt;
      if (this.LaA != null) {
        i = paramInt + g.a.a.a.nh(107, this.LaA.computeSize());
      }
      AppMethodBeat.o(226006);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(226006);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      sm localsm = (sm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(226006);
        return -1;
      case 1: 
        localsm.ybm = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(226006);
        return 0;
      case 2: 
        localsm.pPy = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(226006);
        return 0;
      case 3: 
        localsm.pPz = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(226006);
        return 0;
      case 4: 
        localsm.KDR = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(226006);
        return 0;
      case 5: 
        localsm.Lav = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(226006);
        return 0;
      case 6: 
        localsm.Law = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(226006);
        return 0;
      case 7: 
        localsm.KGL = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(226006);
        return 0;
      case 101: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new sn();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((sn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localsm.Lax = ((sn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(226006);
        return 0;
      case 102: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new sl();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((sl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localsm.Lay = ((sl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(226006);
        return 0;
      case 103: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new so();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((so)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localsm.Laz = ((so)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(226006);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new sk();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((sk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localsm.LaA = ((sk)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(226006);
      return 0;
    }
    AppMethodBeat.o(226006);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sm
 * JD-Core Version:    0.7.0.1
 */