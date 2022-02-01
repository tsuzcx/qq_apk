package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awk
  extends cvp
{
  public LinkedList<String> GuX;
  public String GuY;
  public String pkw;
  public String title;
  
  public awk()
  {
    AppMethodBeat.i(181502);
    this.GuX = new LinkedList();
    AppMethodBeat.o(181502);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181503);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.pkw != null) {
        paramVarArgs.d(2, this.pkw);
      }
      paramVarArgs.e(3, 1, this.GuX);
      if (this.GuY != null) {
        paramVarArgs.d(4, this.GuY);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      AppMethodBeat.o(181503);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label550;
      }
    }
    label550:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pkw != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.pkw);
      }
      i += f.a.a.a.c(3, 1, this.GuX);
      paramInt = i;
      if (this.GuY != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GuY);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.title);
      }
      AppMethodBeat.o(181503);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GuX.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(181503);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        awk localawk = (awk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(181503);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(181503);
          return 0;
        case 2: 
          localawk.pkw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(181503);
          return 0;
        case 3: 
          localawk.GuX.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(181503);
          return 0;
        case 4: 
          localawk.GuY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(181503);
          return 0;
        }
        localawk.title = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(181503);
        return 0;
      }
      AppMethodBeat.o(181503);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awk
 * JD-Core Version:    0.7.0.1
 */