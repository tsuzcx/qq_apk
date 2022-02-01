package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dig
  extends cvw
{
  public String AXb;
  public String AXc;
  public int HPA;
  public int HPz;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91696);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.scene);
      if (this.AXb != null) {
        paramVarArgs.d(3, this.AXb);
      }
      if (this.AXc != null) {
        paramVarArgs.d(4, this.AXc);
      }
      paramVarArgs.aS(5, this.HPz);
      paramVarArgs.aS(6, this.HPA);
      AppMethodBeat.o(91696);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label566;
      }
    }
    label566:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.scene);
      paramInt = i;
      if (this.AXb != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.AXb);
      }
      i = paramInt;
      if (this.AXc != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.AXc);
      }
      paramInt = f.a.a.b.b.a.bz(5, this.HPz);
      int j = f.a.a.b.b.a.bz(6, this.HPA);
      AppMethodBeat.o(91696);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91696);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dig localdig = (dig)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91696);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdig.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91696);
          return 0;
        case 2: 
          localdig.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91696);
          return 0;
        case 3: 
          localdig.AXb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91696);
          return 0;
        case 4: 
          localdig.AXc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91696);
          return 0;
        case 5: 
          localdig.HPz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91696);
          return 0;
        }
        localdig.HPA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91696);
        return 0;
      }
      AppMethodBeat.o(91696);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dig
 * JD-Core Version:    0.7.0.1
 */