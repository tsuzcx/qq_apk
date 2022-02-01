package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class va
  extends cvc
{
  public String FUv;
  public String FUw;
  public String FUy;
  public String FvI;
  public String dve;
  public int vls;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72435);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dve != null) {
        paramVarArgs.d(2, this.dve);
      }
      if (this.FUy != null) {
        paramVarArgs.d(3, this.FUy);
      }
      if (this.FvI != null) {
        paramVarArgs.d(4, this.FvI);
      }
      paramVarArgs.aS(5, this.vls);
      if (this.FUw != null) {
        paramVarArgs.d(6, this.FUw);
      }
      if (this.FUv != null) {
        paramVarArgs.d(7, this.FUv);
      }
      AppMethodBeat.o(72435);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dve != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dve);
      }
      i = paramInt;
      if (this.FUy != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FUy);
      }
      paramInt = i;
      if (this.FvI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FvI);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.vls);
      paramInt = i;
      if (this.FUw != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FUw);
      }
      i = paramInt;
      if (this.FUv != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FUv);
      }
      AppMethodBeat.o(72435);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72435);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        va localva = (va)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72435);
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
            localva.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72435);
          return 0;
        case 2: 
          localva.dve = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72435);
          return 0;
        case 3: 
          localva.FUy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72435);
          return 0;
        case 4: 
          localva.FvI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72435);
          return 0;
        case 5: 
          localva.vls = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72435);
          return 0;
        case 6: 
          localva.FUw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72435);
          return 0;
        }
        localva.FUv = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72435);
        return 0;
      }
      AppMethodBeat.o(72435);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.va
 * JD-Core Version:    0.7.0.1
 */