package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bko
  extends cvw
{
  public int FMa;
  public boolean GXQ;
  public LinkedList<String> GXR;
  public int doj;
  public String dwb;
  
  public bko()
  {
    AppMethodBeat.i(147765);
    this.GXR = new LinkedList();
    AppMethodBeat.o(147765);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147766);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dwb != null) {
        paramVarArgs.d(2, this.dwb);
      }
      paramVarArgs.bC(3, this.GXQ);
      paramVarArgs.e(4, 1, this.GXR);
      paramVarArgs.aS(5, this.doj);
      paramVarArgs.aS(6, this.FMa);
      AppMethodBeat.o(147766);
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
      int i = paramInt;
      if (this.dwb != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dwb);
      }
      paramInt = f.a.a.b.b.a.amF(3);
      int j = f.a.a.a.c(4, 1, this.GXR);
      int k = f.a.a.b.b.a.bz(5, this.doj);
      int m = f.a.a.b.b.a.bz(6, this.FMa);
      AppMethodBeat.o(147766);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GXR.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(147766);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bko localbko = (bko)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147766);
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
            localbko.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147766);
          return 0;
        case 2: 
          localbko.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(147766);
          return 0;
        case 3: 
          localbko.GXQ = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(147766);
          return 0;
        case 4: 
          localbko.GXR.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(147766);
          return 0;
        case 5: 
          localbko.doj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(147766);
          return 0;
        }
        localbko.FMa = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(147766);
        return 0;
      }
      AppMethodBeat.o(147766);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bko
 * JD-Core Version:    0.7.0.1
 */