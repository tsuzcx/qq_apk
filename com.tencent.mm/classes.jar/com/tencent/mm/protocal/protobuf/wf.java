package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wf
  extends cvw
{
  public String FIf;
  public String dwb;
  public String oOY;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209900);
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
      if (this.FIf != null) {
        paramVarArgs.d(3, this.FIf);
      }
      if (this.oOY != null) {
        paramVarArgs.d(4, this.oOY);
      }
      if (this.signature != null) {
        paramVarArgs.d(5, this.signature);
      }
      AppMethodBeat.o(209900);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dwb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dwb);
      }
      i = paramInt;
      if (this.FIf != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FIf);
      }
      paramInt = i;
      if (this.oOY != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oOY);
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.signature);
      }
      AppMethodBeat.o(209900);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(209900);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        wf localwf = (wf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209900);
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
            localwf.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209900);
          return 0;
        case 2: 
          localwf.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(209900);
          return 0;
        case 3: 
          localwf.FIf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(209900);
          return 0;
        case 4: 
          localwf.oOY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(209900);
          return 0;
        }
        localwf.signature = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(209900);
        return 0;
      }
      AppMethodBeat.o(209900);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wf
 * JD-Core Version:    0.7.0.1
 */