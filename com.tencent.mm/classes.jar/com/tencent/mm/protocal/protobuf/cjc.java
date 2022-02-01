package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjc
  extends cvc
{
  public int HcM;
  public String HcO;
  public String HcP;
  public String HcQ;
  public String language;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91587);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HcM);
      if (this.language != null) {
        paramVarArgs.d(3, this.language);
      }
      if (this.HcO != null) {
        paramVarArgs.d(4, this.HcO);
      }
      if (this.HcP != null) {
        paramVarArgs.d(5, this.HcP);
      }
      if (this.HcQ != null) {
        paramVarArgs.d(6, this.HcQ);
      }
      AppMethodBeat.o(91587);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HcM);
      paramInt = i;
      if (this.language != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.language);
      }
      i = paramInt;
      if (this.HcO != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HcO);
      }
      paramInt = i;
      if (this.HcP != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HcP);
      }
      i = paramInt;
      if (this.HcQ != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.HcQ);
      }
      AppMethodBeat.o(91587);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91587);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjc localcjc = (cjc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91587);
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
            localcjc.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91587);
          return 0;
        case 2: 
          localcjc.HcM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91587);
          return 0;
        case 3: 
          localcjc.language = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91587);
          return 0;
        case 4: 
          localcjc.HcO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91587);
          return 0;
        case 5: 
          localcjc.HcP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91587);
          return 0;
        }
        localcjc.HcQ = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91587);
        return 0;
      }
      AppMethodBeat.o(91587);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjc
 * JD-Core Version:    0.7.0.1
 */