package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bhs
  extends cvw
{
  public bb Ghz;
  public String Gnp;
  public String session_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91508);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Ghz != null)
      {
        paramVarArgs.lJ(2, this.Ghz.computeSize());
        this.Ghz.writeFields(paramVarArgs);
      }
      if (this.Gnp != null) {
        paramVarArgs.d(3, this.Gnp);
      }
      if (this.session_id != null) {
        paramVarArgs.d(4, this.session_id);
      }
      AppMethodBeat.o(91508);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label586;
      }
    }
    label586:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ghz != null) {
        paramInt = i + f.a.a.a.lI(2, this.Ghz.computeSize());
      }
      i = paramInt;
      if (this.Gnp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gnp);
      }
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.session_id);
      }
      AppMethodBeat.o(91508);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91508);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bhs localbhs = (bhs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91508);
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
            localbhs.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91508);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhs.Ghz = ((bb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91508);
          return 0;
        case 3: 
          localbhs.Gnp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91508);
          return 0;
        }
        localbhs.session_id = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91508);
        return 0;
      }
      AppMethodBeat.o(91508);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhs
 * JD-Core Version:    0.7.0.1
 */