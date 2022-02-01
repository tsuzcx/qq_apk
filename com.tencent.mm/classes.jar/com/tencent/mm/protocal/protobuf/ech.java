package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ech
  extends com.tencent.mm.bw.a
{
  public ecg Ncw;
  public ecg Ncx;
  public ecg Ncy;
  public int Ncz;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123655);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ncw != null)
      {
        paramVarArgs.ni(1, this.Ncw.computeSize());
        this.Ncw.writeFields(paramVarArgs);
      }
      if (this.Ncx != null)
      {
        paramVarArgs.ni(2, this.Ncx.computeSize());
        this.Ncx.writeFields(paramVarArgs);
      }
      if (this.Ncy != null)
      {
        paramVarArgs.ni(3, this.Ncy.computeSize());
        this.Ncy.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.scene);
      paramVarArgs.aM(5, this.Ncz);
      AppMethodBeat.o(123655);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ncw == null) {
        break label710;
      }
    }
    label710:
    for (int i = g.a.a.a.nh(1, this.Ncw.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ncx != null) {
        paramInt = i + g.a.a.a.nh(2, this.Ncx.computeSize());
      }
      i = paramInt;
      if (this.Ncy != null) {
        i = paramInt + g.a.a.a.nh(3, this.Ncy.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(4, this.scene);
      int j = g.a.a.b.b.a.bu(5, this.Ncz);
      AppMethodBeat.o(123655);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123655);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ech localech = (ech)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123655);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localech.Ncw = ((ecg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123655);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localech.Ncx = ((ecg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123655);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localech.Ncy = ((ecg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123655);
          return 0;
        case 4: 
          localech.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123655);
          return 0;
        }
        localech.Ncz = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(123655);
        return 0;
      }
      AppMethodBeat.o(123655);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ech
 * JD-Core Version:    0.7.0.1
 */