package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class hp
  extends com.tencent.mm.bw.a
{
  public ho KLA;
  public bhx KLB;
  public String KLC;
  public String KLD;
  public String KLE;
  public drf KLF;
  public hw KLG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123544);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KLA != null)
      {
        paramVarArgs.ni(1, this.KLA.computeSize());
        this.KLA.writeFields(paramVarArgs);
      }
      if (this.KLB != null)
      {
        paramVarArgs.ni(2, this.KLB.computeSize());
        this.KLB.writeFields(paramVarArgs);
      }
      if (this.KLC != null) {
        paramVarArgs.e(3, this.KLC);
      }
      if (this.KLD != null) {
        paramVarArgs.e(4, this.KLD);
      }
      if (this.KLE != null) {
        paramVarArgs.e(5, this.KLE);
      }
      if (this.KLF != null)
      {
        paramVarArgs.ni(6, this.KLF.computeSize());
        this.KLF.writeFields(paramVarArgs);
      }
      if (this.KLG != null)
      {
        paramVarArgs.ni(7, this.KLG.computeSize());
        this.KLG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123544);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KLA == null) {
        break label958;
      }
    }
    label958:
    for (int i = g.a.a.a.nh(1, this.KLA.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KLB != null) {
        paramInt = i + g.a.a.a.nh(2, this.KLB.computeSize());
      }
      i = paramInt;
      if (this.KLC != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KLC);
      }
      paramInt = i;
      if (this.KLD != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KLD);
      }
      i = paramInt;
      if (this.KLE != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KLE);
      }
      paramInt = i;
      if (this.KLF != null) {
        paramInt = i + g.a.a.a.nh(6, this.KLF.computeSize());
      }
      i = paramInt;
      if (this.KLG != null) {
        i = paramInt + g.a.a.a.nh(7, this.KLG.computeSize());
      }
      AppMethodBeat.o(123544);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123544);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        hp localhp = (hp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123544);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ho();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ho)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localhp.KLA = ((ho)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123544);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bhx();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bhx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localhp.KLB = ((bhx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123544);
          return 0;
        case 3: 
          localhp.KLC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123544);
          return 0;
        case 4: 
          localhp.KLD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123544);
          return 0;
        case 5: 
          localhp.KLE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123544);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new drf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((drf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localhp.KLF = ((drf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123544);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new hw();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((hw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localhp.KLG = ((hw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123544);
        return 0;
      }
      AppMethodBeat.o(123544);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hp
 * JD-Core Version:    0.7.0.1
 */