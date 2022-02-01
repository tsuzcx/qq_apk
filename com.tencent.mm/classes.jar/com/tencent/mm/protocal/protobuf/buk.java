package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class buk
  extends cvc
{
  public int GOt;
  public LinkedList<cwt> GOu;
  public int GOv;
  public LinkedList<cwt> GOw;
  public String xbo;
  
  public buk()
  {
    AppMethodBeat.i(155434);
    this.GOu = new LinkedList();
    this.GOw = new LinkedList();
    AppMethodBeat.o(155434);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155435);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xbo != null) {
        paramVarArgs.d(2, this.xbo);
      }
      paramVarArgs.aS(3, this.GOt);
      paramVarArgs.e(4, 8, this.GOu);
      paramVarArgs.aS(5, this.GOv);
      paramVarArgs.e(6, 8, this.GOw);
      AppMethodBeat.o(155435);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label746;
      }
    }
    label746:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xbo != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.xbo);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.GOt);
      int j = f.a.a.a.c(4, 8, this.GOu);
      int k = f.a.a.b.b.a.bz(5, this.GOv);
      int m = f.a.a.a.c(6, 8, this.GOw);
      AppMethodBeat.o(155435);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GOu.clear();
        this.GOw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(155435);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        buk localbuk = (buk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155435);
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
            localbuk.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155435);
          return 0;
        case 2: 
          localbuk.xbo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155435);
          return 0;
        case 3: 
          localbuk.GOt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(155435);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbuk.GOu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155435);
          return 0;
        case 5: 
          localbuk.GOv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(155435);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbuk.GOw.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155435);
        return 0;
      }
      AppMethodBeat.o(155435);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buk
 * JD-Core Version:    0.7.0.1
 */