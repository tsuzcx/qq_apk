package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dvh
  extends cvc
{
  public SKBuiltinBuffer_t FDQ;
  public String GEU;
  public dwk HHK;
  public int Hli;
  public int Hlk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32496);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HHK == null)
      {
        paramVarArgs = new b("Not all required fields were included: Piece");
        AppMethodBeat.o(32496);
        throw paramVarArgs;
      }
      if (this.FDQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(32496);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HHK != null)
      {
        paramVarArgs.lC(2, this.HHK.computeSize());
        this.HHK.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.Hli);
      paramVarArgs.aS(4, this.Hlk);
      if (this.GEU != null) {
        paramVarArgs.d(5, this.GEU);
      }
      if (this.FDQ != null)
      {
        paramVarArgs.lC(6, this.FDQ.computeSize());
        this.FDQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32496);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HHK != null) {
        i = paramInt + f.a.a.a.lB(2, this.HHK.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(3, this.Hli) + f.a.a.b.b.a.bz(4, this.Hlk);
      paramInt = i;
      if (this.GEU != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GEU);
      }
      i = paramInt;
      if (this.FDQ != null) {
        i = paramInt + f.a.a.a.lB(6, this.FDQ.computeSize());
      }
      AppMethodBeat.o(32496);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HHK == null)
        {
          paramVarArgs = new b("Not all required fields were included: Piece");
          AppMethodBeat.o(32496);
          throw paramVarArgs;
        }
        if (this.FDQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(32496);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32496);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dvh localdvh = (dvh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32496);
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
            localdvh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32496);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvh.HHK = ((dwk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32496);
          return 0;
        case 3: 
          localdvh.Hli = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32496);
          return 0;
        case 4: 
          localdvh.Hlk = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32496);
          return 0;
        case 5: 
          localdvh.GEU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32496);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdvh.FDQ = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32496);
        return 0;
      }
      AppMethodBeat.o(32496);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvh
 * JD-Core Version:    0.7.0.1
 */