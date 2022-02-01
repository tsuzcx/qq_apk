package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eby
  extends cvc
{
  public LinkedList<Integer> HOu;
  public String duW;
  public int id;
  public String query;
  
  public eby()
  {
    AppMethodBeat.i(121118);
    this.HOu = new LinkedList();
    AppMethodBeat.o(121118);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121119);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.duW != null) {
        paramVarArgs.d(2, this.duW);
      }
      paramVarArgs.aS(3, this.id);
      paramVarArgs.e(4, 2, this.HOu);
      if (this.query != null) {
        paramVarArgs.d(5, this.query);
      }
      AppMethodBeat.o(121119);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label533;
      }
    }
    label533:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.duW != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.duW);
      }
      i = i + f.a.a.b.b.a.bz(3, this.id) + f.a.a.a.c(4, 2, this.HOu);
      paramInt = i;
      if (this.query != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.query);
      }
      AppMethodBeat.o(121119);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HOu.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(121119);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eby localeby = (eby)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(121119);
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
            localeby.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(121119);
          return 0;
        case 2: 
          localeby.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(121119);
          return 0;
        case 3: 
          localeby.id = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(121119);
          return 0;
        case 4: 
          localeby.HOu.add(Integer.valueOf(((f.a.a.a.a)localObject1).NPN.zc()));
          AppMethodBeat.o(121119);
          return 0;
        }
        localeby.query = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(121119);
        return 0;
      }
      AppMethodBeat.o(121119);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eby
 * JD-Core Version:    0.7.0.1
 */