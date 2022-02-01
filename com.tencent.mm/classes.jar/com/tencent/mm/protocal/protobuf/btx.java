package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class btx
  extends cvw
{
  public String HgV;
  public String HgW;
  public String HgX;
  public int doj;
  public String query;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153288);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HgV != null) {
        paramVarArgs.d(2, this.HgV);
      }
      if (this.query != null) {
        paramVarArgs.d(3, this.query);
      }
      if (this.HgW != null) {
        paramVarArgs.d(4, this.HgW);
      }
      if (this.HgX != null) {
        paramVarArgs.d(5, this.HgX);
      }
      paramVarArgs.aS(6, this.doj);
      AppMethodBeat.o(153288);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HgV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HgV);
      }
      i = paramInt;
      if (this.query != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.query);
      }
      paramInt = i;
      if (this.HgW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HgW);
      }
      i = paramInt;
      if (this.HgX != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HgX);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.doj);
      AppMethodBeat.o(153288);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153288);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        btx localbtx = (btx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153288);
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
            localbtx.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153288);
          return 0;
        case 2: 
          localbtx.HgV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153288);
          return 0;
        case 3: 
          localbtx.query = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153288);
          return 0;
        case 4: 
          localbtx.HgW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153288);
          return 0;
        case 5: 
          localbtx.HgX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153288);
          return 0;
        }
        localbtx.doj = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(153288);
        return 0;
      }
      AppMethodBeat.o(153288);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btx
 * JD-Core Version:    0.7.0.1
 */