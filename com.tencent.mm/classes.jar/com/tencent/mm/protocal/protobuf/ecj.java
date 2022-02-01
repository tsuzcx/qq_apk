package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ecj
  extends com.tencent.mm.bw.a
{
  public String FWK;
  public String FWL;
  public SKBuiltinBuffer_t FWO;
  public String IhI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133206);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FWO == null)
      {
        paramVarArgs = new b("Not all required fields were included: KSid");
        AppMethodBeat.o(133206);
        throw paramVarArgs;
      }
      if (this.FWK != null) {
        paramVarArgs.d(1, this.FWK);
      }
      if (this.FWL != null) {
        paramVarArgs.d(2, this.FWL);
      }
      if (this.IhI != null) {
        paramVarArgs.d(3, this.IhI);
      }
      if (this.FWO != null)
      {
        paramVarArgs.lJ(4, this.FWO.computeSize());
        this.FWO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133206);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FWK == null) {
        break label538;
      }
    }
    label538:
    for (int i = f.a.a.b.b.a.e(1, this.FWK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FWL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FWL);
      }
      i = paramInt;
      if (this.IhI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.IhI);
      }
      paramInt = i;
      if (this.FWO != null) {
        paramInt = i + f.a.a.a.lI(4, this.FWO.computeSize());
      }
      AppMethodBeat.o(133206);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FWO == null)
        {
          paramVarArgs = new b("Not all required fields were included: KSid");
          AppMethodBeat.o(133206);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133206);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ecj localecj = (ecj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133206);
          return -1;
        case 1: 
          localecj.FWK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133206);
          return 0;
        case 2: 
          localecj.FWL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133206);
          return 0;
        case 3: 
          localecj.IhI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133206);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localecj.FWO = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133206);
        return 0;
      }
      AppMethodBeat.o(133206);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecj
 * JD-Core Version:    0.7.0.1
 */