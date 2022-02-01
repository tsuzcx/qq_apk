package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class abs
  extends cvc
{
  public LinkedList<bys> FuN;
  public cwt Gbo;
  public SKBuiltinBuffer_t Gbp;
  public String Gbq;
  public int Scene;
  public int fLb;
  public String iht;
  
  public abs()
  {
    AppMethodBeat.i(101797);
    this.FuN = new LinkedList();
    AppMethodBeat.o(101797);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101798);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gbo == null)
      {
        paramVarArgs = new b("Not all required fields were included: Topic");
        AppMethodBeat.o(101798);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gbo != null)
      {
        paramVarArgs.lC(2, this.Gbo.computeSize());
        this.Gbo.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.fLb);
      paramVarArgs.e(4, 8, this.FuN);
      paramVarArgs.aS(5, this.Scene);
      if (this.Gbp != null)
      {
        paramVarArgs.lC(6, this.Gbp.computeSize());
        this.Gbp.writeFields(paramVarArgs);
      }
      if (this.Gbq != null) {
        paramVarArgs.d(7, this.Gbq);
      }
      if (this.iht != null) {
        paramVarArgs.d(8, this.iht);
      }
      AppMethodBeat.o(101798);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1018;
      }
    }
    label1018:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gbo != null) {
        i = paramInt + f.a.a.a.lB(2, this.Gbo.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(3, this.fLb) + f.a.a.a.c(4, 8, this.FuN) + f.a.a.b.b.a.bz(5, this.Scene);
      paramInt = i;
      if (this.Gbp != null) {
        paramInt = i + f.a.a.a.lB(6, this.Gbp.computeSize());
      }
      i = paramInt;
      if (this.Gbq != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Gbq);
      }
      paramInt = i;
      if (this.iht != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.iht);
      }
      AppMethodBeat.o(101798);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FuN.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Gbo == null)
        {
          paramVarArgs = new b("Not all required fields were included: Topic");
          AppMethodBeat.o(101798);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101798);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        abs localabs = (abs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101798);
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
            localabs.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabs.Gbo = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 3: 
          localabs.fLb = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101798);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bys();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bys)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabs.FuN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 5: 
          localabs.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101798);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabs.Gbp = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 7: 
          localabs.Gbq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101798);
          return 0;
        }
        localabs.iht = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(101798);
        return 0;
      }
      AppMethodBeat.o(101798);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abs
 * JD-Core Version:    0.7.0.1
 */