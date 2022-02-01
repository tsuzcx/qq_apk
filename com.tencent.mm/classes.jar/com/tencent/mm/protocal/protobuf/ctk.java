package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ctk
  extends cvw
{
  public String GxB;
  public duy HEv;
  public dpk HEw;
  public int gvw;
  public int nJA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56259);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HEv == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserPosition");
        AppMethodBeat.o(56259);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GxB != null) {
        paramVarArgs.d(2, this.GxB);
      }
      paramVarArgs.aS(3, this.nJA);
      if (this.HEv != null)
      {
        paramVarArgs.lJ(4, this.HEv.computeSize());
        this.HEv.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.gvw);
      if (this.HEw != null)
      {
        paramVarArgs.lJ(6, this.HEw.computeSize());
        this.HEw.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GxB != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GxB);
      }
      i += f.a.a.b.b.a.bz(3, this.nJA);
      paramInt = i;
      if (this.HEv != null) {
        paramInt = i + f.a.a.a.lI(4, this.HEv.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.gvw);
      paramInt = i;
      if (this.HEw != null) {
        paramInt = i + f.a.a.a.lI(6, this.HEw.computeSize());
      }
      AppMethodBeat.o(56259);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HEv == null)
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
        ctk localctk = (ctk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56259);
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
            localctk.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56259);
          return 0;
        case 2: 
          localctk.GxB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(56259);
          return 0;
        case 3: 
          localctk.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(56259);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new duy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((duy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localctk.HEv = ((duy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56259);
          return 0;
        case 5: 
          localctk.gvw = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(56259);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dpk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dpk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localctk.HEw = ((dpk)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctk
 * JD-Core Version:    0.7.0.1
 */