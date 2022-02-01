package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ano
  extends cvc
{
  public alk Gle;
  public b lastBuffer;
  public b likeBuffer;
  public String objectNonceId;
  public long rIZ;
  public String rTn;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209300);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gle != null)
      {
        paramVarArgs.lC(2, this.Gle.computeSize());
        this.Gle.writeFields(paramVarArgs);
      }
      if (this.rTn != null) {
        paramVarArgs.d(3, this.rTn);
      }
      paramVarArgs.aS(4, this.scene);
      if (this.lastBuffer != null) {
        paramVarArgs.c(5, this.lastBuffer);
      }
      paramVarArgs.aY(6, this.rIZ);
      if (this.objectNonceId != null) {
        paramVarArgs.d(7, this.objectNonceId);
      }
      if (this.likeBuffer != null) {
        paramVarArgs.c(8, this.likeBuffer);
      }
      AppMethodBeat.o(209300);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label798;
      }
    }
    label798:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gle != null) {
        paramInt = i + f.a.a.a.lB(2, this.Gle.computeSize());
      }
      i = paramInt;
      if (this.rTn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.rTn);
      }
      i += f.a.a.b.b.a.bz(4, this.scene);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.lastBuffer);
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.rIZ);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.objectNonceId);
      }
      i = paramInt;
      if (this.likeBuffer != null) {
        i = paramInt + f.a.a.b.b.a.b(8, this.likeBuffer);
      }
      AppMethodBeat.o(209300);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209300);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ano localano = (ano)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209300);
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
            localano.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209300);
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
            localano.Gle = ((alk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209300);
          return 0;
        case 3: 
          localano.rTn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209300);
          return 0;
        case 4: 
          localano.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(209300);
          return 0;
        case 5: 
          localano.lastBuffer = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(209300);
          return 0;
        case 6: 
          localano.rIZ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(209300);
          return 0;
        case 7: 
          localano.objectNonceId = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209300);
          return 0;
        }
        localano.likeBuffer = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(209300);
        return 0;
      }
      AppMethodBeat.o(209300);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ano
 * JD-Core Version:    0.7.0.1
 */