package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gy
  extends cvw
{
  public int FMa;
  public LinkedList<String> FRM;
  public boolean FRN;
  public int FRO;
  public int doj;
  public String dwb;
  
  public gy()
  {
    AppMethodBeat.i(147758);
    this.FRM = new LinkedList();
    AppMethodBeat.o(147758);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147759);
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
      paramVarArgs.e(3, 1, this.FRM);
      paramVarArgs.bC(4, this.FRN);
      paramVarArgs.aS(5, this.FRO);
      paramVarArgs.aS(6, this.doj);
      paramVarArgs.aS(7, this.FMa);
      AppMethodBeat.o(147759);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dwb != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dwb);
      }
      paramInt = f.a.a.a.c(3, 1, this.FRM);
      int j = f.a.a.b.b.a.amF(4);
      int k = f.a.a.b.b.a.bz(5, this.FRO);
      int m = f.a.a.b.b.a.bz(6, this.doj);
      int n = f.a.a.b.b.a.bz(7, this.FMa);
      AppMethodBeat.o(147759);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FRM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(147759);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        gy localgy = (gy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147759);
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
            localgy.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147759);
          return 0;
        case 2: 
          localgy.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(147759);
          return 0;
        case 3: 
          localgy.FRM.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(147759);
          return 0;
        case 4: 
          localgy.FRN = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(147759);
          return 0;
        case 5: 
          localgy.FRO = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(147759);
          return 0;
        case 6: 
          localgy.doj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(147759);
          return 0;
        }
        localgy.FMa = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(147759);
        return 0;
      }
      AppMethodBeat.o(147759);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gy
 * JD-Core Version:    0.7.0.1
 */