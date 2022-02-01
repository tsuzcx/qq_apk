package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cem
  extends dop
{
  public LinkedList<String> MjX;
  public int MjY;
  public int MjZ;
  public fdg Mka;
  public String jfi;
  
  public cem()
  {
    AppMethodBeat.i(123604);
    this.MjX = new LinkedList();
    AppMethodBeat.o(123604);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123605);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.jfi != null) {
        paramVarArgs.e(2, this.jfi);
      }
      paramVarArgs.e(3, 1, this.MjX);
      paramVarArgs.aM(4, this.MjY);
      paramVarArgs.aM(5, this.MjZ);
      if (this.Mka != null)
      {
        paramVarArgs.ni(6, this.Mka.computeSize());
        this.Mka.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123605);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jfi != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.jfi);
      }
      i = i + g.a.a.a.c(3, 1, this.MjX) + g.a.a.b.b.a.bu(4, this.MjY) + g.a.a.b.b.a.bu(5, this.MjZ);
      paramInt = i;
      if (this.Mka != null) {
        paramInt = i + g.a.a.a.nh(6, this.Mka.computeSize());
      }
      AppMethodBeat.o(123605);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MjX.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123605);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cem localcem = (cem)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123605);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcem.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123605);
          return 0;
        case 2: 
          localcem.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123605);
          return 0;
        case 3: 
          localcem.MjX.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(123605);
          return 0;
        case 4: 
          localcem.MjY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123605);
          return 0;
        case 5: 
          localcem.MjZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123605);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fdg();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((fdg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcem.Mka = ((fdg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123605);
        return 0;
      }
      AppMethodBeat.o(123605);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cem
 * JD-Core Version:    0.7.0.1
 */