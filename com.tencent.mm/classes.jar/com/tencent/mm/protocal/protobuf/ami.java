package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ami
  extends cvc
{
  public String GlV;
  public alk Glv;
  public long id;
  public String objectNonceId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168950);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.id);
      if (this.GlV != null) {
        paramVarArgs.d(3, this.GlV);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.d(4, this.objectNonceId);
      }
      if (this.Glv != null)
      {
        paramVarArgs.lC(5, this.Glv.computeSize());
        this.Glv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168950);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.id);
      paramInt = i;
      if (this.GlV != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GlV);
      }
      i = paramInt;
      if (this.objectNonceId != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.objectNonceId);
      }
      paramInt = i;
      if (this.Glv != null) {
        paramInt = i + f.a.a.a.lB(5, this.Glv.computeSize());
      }
      AppMethodBeat.o(168950);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(168950);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ami localami = (ami)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168950);
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
            localami.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168950);
          return 0;
        case 2: 
          localami.id = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(168950);
          return 0;
        case 3: 
          localami.GlV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168950);
          return 0;
        case 4: 
          localami.objectNonceId = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168950);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new alk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((alk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localami.Glv = ((alk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168950);
        return 0;
      }
      AppMethodBeat.o(168950);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ami
 * JD-Core Version:    0.7.0.1
 */