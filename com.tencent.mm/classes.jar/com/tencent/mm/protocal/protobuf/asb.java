package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class asb
  extends cvc
{
  public String BRs;
  public alk Gnf;
  public String rTn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194943);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gnf != null)
      {
        paramVarArgs.lC(2, this.Gnf.computeSize());
        this.Gnf.writeFields(paramVarArgs);
      }
      if (this.rTn != null) {
        paramVarArgs.d(3, this.rTn);
      }
      if (this.BRs != null) {
        paramVarArgs.d(4, this.BRs);
      }
      AppMethodBeat.o(194943);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label586;
      }
    }
    label586:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gnf != null) {
        paramInt = i + f.a.a.a.lB(2, this.Gnf.computeSize());
      }
      i = paramInt;
      if (this.rTn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.rTn);
      }
      paramInt = i;
      if (this.BRs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.BRs);
      }
      AppMethodBeat.o(194943);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(194943);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        asb localasb = (asb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194943);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasb.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194943);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasb.Gnf = ((alk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194943);
          return 0;
        case 3: 
          localasb.rTn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(194943);
          return 0;
        }
        localasb.BRs = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(194943);
        return 0;
      }
      AppMethodBeat.o(194943);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asb
 * JD-Core Version:    0.7.0.1
 */