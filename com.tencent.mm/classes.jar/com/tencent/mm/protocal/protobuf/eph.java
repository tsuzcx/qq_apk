package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eph
  extends dop
{
  public int LSk;
  public ccu LSo;
  public ccv LSp;
  public int dUT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72622);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LSk);
      paramVarArgs.aM(3, this.dUT);
      if (this.LSo != null)
      {
        paramVarArgs.ni(4, this.LSo.computeSize());
        this.LSo.writeFields(paramVarArgs);
      }
      if (this.LSp != null)
      {
        paramVarArgs.ni(5, this.LSp.computeSize());
        this.LSp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72622);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label706;
      }
    }
    label706:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LSk) + g.a.a.b.b.a.bu(3, this.dUT);
      paramInt = i;
      if (this.LSo != null) {
        paramInt = i + g.a.a.a.nh(4, this.LSo.computeSize());
      }
      i = paramInt;
      if (this.LSp != null) {
        i = paramInt + g.a.a.a.nh(5, this.LSp.computeSize());
      }
      AppMethodBeat.o(72622);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72622);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eph localeph = (eph)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72622);
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
            localeph.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72622);
          return 0;
        case 2: 
          localeph.LSk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72622);
          return 0;
        case 3: 
          localeph.dUT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72622);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeph.LSo = ((ccu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72622);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccv();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeph.LSp = ((ccv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72622);
        return 0;
      }
      AppMethodBeat.o(72622);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eph
 * JD-Core Version:    0.7.0.1
 */