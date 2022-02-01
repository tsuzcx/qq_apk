package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ib
  extends cvc
{
  public String FAA;
  public String FAB;
  public String FAC;
  public int FAx;
  public LinkedList<aba> FAy;
  public String FAz;
  public int Scene;
  public long nDC;
  
  public ib()
  {
    AppMethodBeat.i(32131);
    this.FAy = new LinkedList();
    AppMethodBeat.o(32131);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32132);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FAx);
      paramVarArgs.e(3, 8, this.FAy);
      if (this.FAz != null) {
        paramVarArgs.d(4, this.FAz);
      }
      if (this.FAA != null) {
        paramVarArgs.d(5, this.FAA);
      }
      paramVarArgs.aS(6, this.Scene);
      paramVarArgs.aY(7, this.nDC);
      if (this.FAB != null) {
        paramVarArgs.d(8, this.FAB);
      }
      if (this.FAC != null) {
        paramVarArgs.d(9, this.FAC);
      }
      AppMethodBeat.o(32132);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label841;
      }
    }
    label841:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FAx) + f.a.a.a.c(3, 8, this.FAy);
      paramInt = i;
      if (this.FAz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FAz);
      }
      i = paramInt;
      if (this.FAA != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FAA);
      }
      i = i + f.a.a.b.b.a.bz(6, this.Scene) + f.a.a.b.b.a.p(7, this.nDC);
      paramInt = i;
      if (this.FAB != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FAB);
      }
      i = paramInt;
      if (this.FAC != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FAC);
      }
      AppMethodBeat.o(32132);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FAy.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32132);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ib localib = (ib)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32132);
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
            localib.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32132);
          return 0;
        case 2: 
          localib.FAx = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32132);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aba();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aba)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localib.FAy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32132);
          return 0;
        case 4: 
          localib.FAz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32132);
          return 0;
        case 5: 
          localib.FAA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32132);
          return 0;
        case 6: 
          localib.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32132);
          return 0;
        case 7: 
          localib.nDC = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(32132);
          return 0;
        case 8: 
          localib.FAB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32132);
          return 0;
        }
        localib.FAC = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32132);
        return 0;
      }
      AppMethodBeat.o(32132);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ib
 * JD-Core Version:    0.7.0.1
 */