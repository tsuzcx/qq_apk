package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csc
  extends cvw
{
  public String DgJ;
  public String DlK;
  public int HDi;
  public String dwj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(174536);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DgJ != null) {
        paramVarArgs.d(2, this.DgJ);
      }
      if (this.DlK != null) {
        paramVarArgs.d(3, this.DlK);
      }
      paramVarArgs.aS(4, this.HDi);
      if (this.dwj != null) {
        paramVarArgs.d(5, this.dwj);
      }
      AppMethodBeat.o(174536);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label534;
      }
    }
    label534:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DgJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DgJ);
      }
      i = paramInt;
      if (this.DlK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DlK);
      }
      i += f.a.a.b.b.a.bz(4, this.HDi);
      paramInt = i;
      if (this.dwj != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dwj);
      }
      AppMethodBeat.o(174536);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(174536);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        csc localcsc = (csc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(174536);
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
            localcsc.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(174536);
          return 0;
        case 2: 
          localcsc.DgJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(174536);
          return 0;
        case 3: 
          localcsc.DlK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(174536);
          return 0;
        case 4: 
          localcsc.HDi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(174536);
          return 0;
        }
        localcsc.dwj = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(174536);
        return 0;
      }
      AppMethodBeat.o(174536);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csc
 * JD-Core Version:    0.7.0.1
 */