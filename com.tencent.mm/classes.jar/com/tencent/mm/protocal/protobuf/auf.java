package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class auf
  extends cvc
{
  public String Gsr;
  public LinkedList<String> Gss;
  public String uhu;
  
  public auf()
  {
    AppMethodBeat.i(42633);
    this.Gss = new LinkedList();
    AppMethodBeat.o(42633);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42634);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gsr != null) {
        paramVarArgs.d(2, this.Gsr);
      }
      paramVarArgs.e(3, 1, this.Gss);
      if (this.uhu != null) {
        paramVarArgs.d(4, this.uhu);
      }
      AppMethodBeat.o(42634);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label490;
      }
    }
    label490:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gsr != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Gsr);
      }
      i += f.a.a.a.c(3, 1, this.Gss);
      paramInt = i;
      if (this.uhu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uhu);
      }
      AppMethodBeat.o(42634);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gss.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(42634);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        auf localauf = (auf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42634);
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
            localauf.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42634);
          return 0;
        case 2: 
          localauf.Gsr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(42634);
          return 0;
        case 3: 
          localauf.Gss.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(42634);
          return 0;
        }
        localauf.uhu = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(42634);
        return 0;
      }
      AppMethodBeat.o(42634);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auf
 * JD-Core Version:    0.7.0.1
 */