package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cyc
  extends cvw
{
  public clx HIt;
  public float HIu;
  public float HIv;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152679);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HIt == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserPos");
        AppMethodBeat.o(152679);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HIt != null)
      {
        paramVarArgs.lJ(2, this.HIt.computeSize());
        this.HIt.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.Scene);
      paramVarArgs.y(4, this.HIu);
      paramVarArgs.y(5, this.HIv);
      AppMethodBeat.o(152679);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label648;
      }
    }
    label648:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HIt != null) {
        i = paramInt + f.a.a.a.lI(2, this.HIt.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(3, this.Scene);
      int j = f.a.a.b.b.a.amE(4);
      int k = f.a.a.b.b.a.amE(5);
      AppMethodBeat.o(152679);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HIt == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserPos");
          AppMethodBeat.o(152679);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152679);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cyc localcyc = (cyc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152679);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyc.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152679);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((clx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyc.HIt = ((clx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152679);
          return 0;
        case 3: 
          localcyc.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152679);
          return 0;
        case 4: 
          localcyc.HIu = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(152679);
          return 0;
        }
        localcyc.HIv = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
        AppMethodBeat.o(152679);
        return 0;
      }
      AppMethodBeat.o(152679);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyc
 * JD-Core Version:    0.7.0.1
 */