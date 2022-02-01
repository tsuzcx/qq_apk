package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vk
  extends cvc
{
  public boolean FUO;
  public boolean FUP;
  public LinkedList<Integer> FUk;
  public String desc;
  
  public vk()
  {
    AppMethodBeat.i(72444);
    this.FUk = new LinkedList();
    AppMethodBeat.o(72444);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72445);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 2, this.FUk);
      if (this.desc != null) {
        paramVarArgs.d(3, this.desc);
      }
      paramVarArgs.bt(4, this.FUO);
      paramVarArgs.bt(5, this.FUP);
      AppMethodBeat.o(72445);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label513;
      }
    }
    label513:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 2, this.FUk);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.desc);
      }
      i = f.a.a.b.b.a.alV(4);
      int j = f.a.a.b.b.a.alV(5);
      AppMethodBeat.o(72445);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FUk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72445);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vk localvk = (vk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72445);
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
            localvk.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72445);
          return 0;
        case 2: 
          localvk.FUk.add(Integer.valueOf(((f.a.a.a.a)localObject1).NPN.zc()));
          AppMethodBeat.o(72445);
          return 0;
        case 3: 
          localvk.desc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72445);
          return 0;
        case 4: 
          localvk.FUO = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(72445);
          return 0;
        }
        localvk.FUP = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(72445);
        return 0;
      }
      AppMethodBeat.o(72445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vk
 * JD-Core Version:    0.7.0.1
 */