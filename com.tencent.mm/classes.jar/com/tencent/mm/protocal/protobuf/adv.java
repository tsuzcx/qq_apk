package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adv
  extends com.tencent.mm.bw.a
{
  public ehf KEN;
  public String KNW;
  public LinkedList<ehf> Lee;
  public LinkedList<ehf> Lpn;
  public String Lpo;
  public int state;
  
  public adv()
  {
    AppMethodBeat.i(91427);
    this.Lee = new LinkedList();
    this.Lpn = new LinkedList();
    AppMethodBeat.o(91427);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91428);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.state);
      if (this.KEN != null)
      {
        paramVarArgs.ni(2, this.KEN.computeSize());
        this.KEN.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.Lee);
      paramVarArgs.e(4, 8, this.Lpn);
      if (this.Lpo != null) {
        paramVarArgs.e(5, this.Lpo);
      }
      if (this.KNW != null) {
        paramVarArgs.e(6, this.KNW);
      }
      AppMethodBeat.o(91428);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.state) + 0;
      paramInt = i;
      if (this.KEN != null) {
        paramInt = i + g.a.a.a.nh(2, this.KEN.computeSize());
      }
      i = paramInt + g.a.a.a.c(3, 8, this.Lee) + g.a.a.a.c(4, 8, this.Lpn);
      paramInt = i;
      if (this.Lpo != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Lpo);
      }
      i = paramInt;
      if (this.KNW != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.KNW);
      }
      AppMethodBeat.o(91428);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Lee.clear();
      this.Lpn.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91428);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      adv localadv = (adv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91428);
        return -1;
      case 1: 
        localadv.state = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91428);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ehf();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ehf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localadv.KEN = ((ehf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91428);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ehf();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ehf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localadv.Lee.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91428);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ehf();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ehf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localadv.Lpn.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91428);
        return 0;
      case 5: 
        localadv.Lpo = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91428);
        return 0;
      }
      localadv.KNW = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(91428);
      return 0;
    }
    AppMethodBeat.o(91428);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adv
 * JD-Core Version:    0.7.0.1
 */