package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cnn
  extends cpx
{
  public String Exq;
  public dok FAH;
  public diy FAI;
  public int fZy;
  public int ndI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56259);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FAH == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserPosition");
        AppMethodBeat.o(56259);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Exq != null) {
        paramVarArgs.d(2, this.Exq);
      }
      paramVarArgs.aR(3, this.ndI);
      if (this.FAH != null)
      {
        paramVarArgs.ln(4, this.FAH.computeSize());
        this.FAH.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.fZy);
      if (this.FAI != null)
      {
        paramVarArgs.ln(6, this.FAI.computeSize());
        this.FAI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(56259);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label818;
      }
    }
    label818:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Exq != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Exq);
      }
      i += f.a.a.b.b.a.bx(3, this.ndI);
      paramInt = i;
      if (this.FAH != null) {
        paramInt = i + f.a.a.a.lm(4, this.FAH.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.fZy);
      paramInt = i;
      if (this.FAI != null) {
        paramInt = i + f.a.a.a.lm(6, this.FAI.computeSize());
      }
      AppMethodBeat.o(56259);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FAH == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserPosition");
          AppMethodBeat.o(56259);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56259);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cnn localcnn = (cnn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56259);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnn.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56259);
          return 0;
        case 2: 
          localcnn.Exq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(56259);
          return 0;
        case 3: 
          localcnn.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(56259);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dok();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dok)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnn.FAH = ((dok)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56259);
          return 0;
        case 5: 
          localcnn.fZy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(56259);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new diy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((diy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcnn.FAI = ((diy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56259);
        return 0;
      }
      AppMethodBeat.o(56259);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnn
 * JD-Core Version:    0.7.0.1
 */