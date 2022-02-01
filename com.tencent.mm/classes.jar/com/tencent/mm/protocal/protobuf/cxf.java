package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cxf
  extends cvw
{
  public String FNj;
  public cxh HHL;
  public String HHM;
  public String HHN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181510);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FNj != null) {
        paramVarArgs.d(2, this.FNj);
      }
      if (this.HHM != null) {
        paramVarArgs.d(3, this.HHM);
      }
      if (this.HHN != null) {
        paramVarArgs.d(4, this.HHN);
      }
      if (this.HHL != null)
      {
        paramVarArgs.lJ(5, this.HHL.computeSize());
        this.HHL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(181510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label646;
      }
    }
    label646:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FNj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FNj);
      }
      i = paramInt;
      if (this.HHM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HHM);
      }
      paramInt = i;
      if (this.HHN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HHN);
      }
      i = paramInt;
      if (this.HHL != null) {
        i = paramInt + f.a.a.a.lI(5, this.HHL.computeSize());
      }
      AppMethodBeat.o(181510);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(181510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cxf localcxf = (cxf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(181510);
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
            localcxf.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(181510);
          return 0;
        case 2: 
          localcxf.FNj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(181510);
          return 0;
        case 3: 
          localcxf.HHM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(181510);
          return 0;
        case 4: 
          localcxf.HHN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(181510);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcxf.HHL = ((cxh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(181510);
        return 0;
      }
      AppMethodBeat.o(181510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxf
 * JD-Core Version:    0.7.0.1
 */