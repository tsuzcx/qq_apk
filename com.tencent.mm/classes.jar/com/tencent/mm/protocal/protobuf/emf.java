package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class emf
  extends dop
{
  public SKBuiltinBuffer_t KPW;
  public String NkI;
  public String NkJ;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(130921);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.NkI != null) {
        paramVarArgs.e(2, this.NkI);
      }
      if (this.NkJ != null) {
        paramVarArgs.e(3, this.NkJ);
      }
      paramVarArgs.aM(4, this.Scene);
      if (this.KPW != null)
      {
        paramVarArgs.ni(5, this.KPW.computeSize());
        this.KPW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(130921);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.NkI != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.NkI);
      }
      i = paramInt;
      if (this.NkJ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.NkJ);
      }
      i += g.a.a.b.b.a.bu(4, this.Scene);
      paramInt = i;
      if (this.KPW != null) {
        paramInt = i + g.a.a.a.nh(5, this.KPW.computeSize());
      }
      AppMethodBeat.o(130921);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(130921);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        emf localemf = (emf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(130921);
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
            localemf.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(130921);
          return 0;
        case 2: 
          localemf.NkI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(130921);
          return 0;
        case 3: 
          localemf.NkJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(130921);
          return 0;
        case 4: 
          localemf.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(130921);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localemf.KPW = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(130921);
        return 0;
      }
      AppMethodBeat.o(130921);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emf
 * JD-Core Version:    0.7.0.1
 */