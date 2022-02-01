package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class be
  extends com.tencent.mm.bw.a
{
  public fb KEA;
  public fb KEB;
  public String KEt;
  public String KEu;
  public String KEv;
  public bc KEw;
  public String KEx;
  public ek KEy;
  public fc KEz;
  public int Scene;
  public String Url;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125689);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.oUv);
      if (this.Url != null) {
        paramVarArgs.e(2, this.Url);
      }
      paramVarArgs.aM(3, this.Scene);
      if (this.KEt != null) {
        paramVarArgs.e(4, this.KEt);
      }
      if (this.KEu != null) {
        paramVarArgs.e(5, this.KEu);
      }
      if (this.KEv != null) {
        paramVarArgs.e(6, this.KEv);
      }
      if (this.KEw != null)
      {
        paramVarArgs.ni(7, this.KEw.computeSize());
        this.KEw.writeFields(paramVarArgs);
      }
      if (this.KEx != null) {
        paramVarArgs.e(8, this.KEx);
      }
      if (this.KEy != null)
      {
        paramVarArgs.ni(9, this.KEy.computeSize());
        this.KEy.writeFields(paramVarArgs);
      }
      if (this.KEz != null)
      {
        paramVarArgs.ni(10, this.KEz.computeSize());
        this.KEz.writeFields(paramVarArgs);
      }
      if (this.KEA != null)
      {
        paramVarArgs.ni(11, this.KEA.computeSize());
        this.KEA.writeFields(paramVarArgs);
      }
      if (this.KEB != null)
      {
        paramVarArgs.ni(12, this.KEB.computeSize());
        this.KEB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125689);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.oUv) + 0;
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Url);
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.Scene);
      paramInt = i;
      if (this.KEt != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KEt);
      }
      i = paramInt;
      if (this.KEu != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KEu);
      }
      paramInt = i;
      if (this.KEv != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KEv);
      }
      i = paramInt;
      if (this.KEw != null) {
        i = paramInt + g.a.a.a.nh(7, this.KEw.computeSize());
      }
      paramInt = i;
      if (this.KEx != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.KEx);
      }
      i = paramInt;
      if (this.KEy != null) {
        i = paramInt + g.a.a.a.nh(9, this.KEy.computeSize());
      }
      paramInt = i;
      if (this.KEz != null) {
        paramInt = i + g.a.a.a.nh(10, this.KEz.computeSize());
      }
      i = paramInt;
      if (this.KEA != null) {
        i = paramInt + g.a.a.a.nh(11, this.KEA.computeSize());
      }
      paramInt = i;
      if (this.KEB != null) {
        paramInt = i + g.a.a.a.nh(12, this.KEB.computeSize());
      }
      AppMethodBeat.o(125689);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(125689);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      be localbe = (be)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125689);
        return -1;
      case 1: 
        localbe.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125689);
        return 0;
      case 2: 
        localbe.Url = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 3: 
        localbe.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125689);
        return 0;
      case 4: 
        localbe.KEt = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 5: 
        localbe.KEu = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 6: 
        localbe.KEv = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bc();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbe.KEw = ((bc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      case 8: 
        localbe.KEx = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ek();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ek)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbe.KEy = ((ek)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      case 10: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fc();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((fc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbe.KEz = ((fc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fb();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((fb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbe.KEA = ((fb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new fb();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((fb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localbe.KEB = ((fb)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(125689);
      return 0;
    }
    AppMethodBeat.o(125689);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.be
 * JD-Core Version:    0.7.0.1
 */