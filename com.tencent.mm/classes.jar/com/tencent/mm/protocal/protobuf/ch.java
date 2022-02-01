package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ch
  extends cvw
{
  public String FNj;
  public LinkedList<String> FNk;
  
  public ch()
  {
    AppMethodBeat.i(138165);
    this.FNk = new LinkedList();
    AppMethodBeat.o(138165);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138166);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FNj == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(138166);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FNj != null) {
        paramVarArgs.d(2, this.FNj);
      }
      paramVarArgs.e(3, 1, this.FNk);
      AppMethodBeat.o(138166);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label478;
      }
    }
    label478:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FNj != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FNj);
      }
      paramInt = f.a.a.a.c(3, 1, this.FNk);
      AppMethodBeat.o(138166);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FNk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FNj == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(138166);
          throw paramVarArgs;
        }
        AppMethodBeat.o(138166);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ch localch = (ch)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(138166);
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
            localch.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(138166);
          return 0;
        case 2: 
          localch.FNj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(138166);
          return 0;
        }
        localch.FNk.add(((f.a.a.a.a)localObject1).OmT.readString());
        AppMethodBeat.o(138166);
        return 0;
      }
      AppMethodBeat.o(138166);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ch
 * JD-Core Version:    0.7.0.1
 */