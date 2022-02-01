package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class acr
  extends cvc
{
  public String FuL;
  public LinkedList<String> FuM;
  
  public acr()
  {
    AppMethodBeat.i(138171);
    this.FuM = new LinkedList();
    AppMethodBeat.o(138171);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138172);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FuL == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(138172);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FuL != null) {
        paramVarArgs.d(2, this.FuL);
      }
      paramVarArgs.e(3, 1, this.FuM);
      AppMethodBeat.o(138172);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label478;
      }
    }
    label478:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FuL != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FuL);
      }
      paramInt = f.a.a.a.c(3, 1, this.FuM);
      AppMethodBeat.o(138172);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FuM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FuL == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(138172);
          throw paramVarArgs;
        }
        AppMethodBeat.o(138172);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        acr localacr = (acr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(138172);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacr.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(138172);
          return 0;
        case 2: 
          localacr.FuL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(138172);
          return 0;
        }
        localacr.FuM.add(((f.a.a.a.a)localObject1).NPN.readString());
        AppMethodBeat.o(138172);
        return 0;
      }
      AppMethodBeat.o(138172);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acr
 * JD-Core Version:    0.7.0.1
 */