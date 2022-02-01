package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class anw
  extends cvc
{
  public alk Glv;
  public long GmH;
  public String Gmz;
  public b lastBuffer;
  public String rJp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168985);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.GmH);
      if (this.Gmz != null) {
        paramVarArgs.d(3, this.Gmz);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(4, this.lastBuffer);
      }
      if (this.Glv != null)
      {
        paramVarArgs.lC(5, this.Glv.computeSize());
        this.Glv.writeFields(paramVarArgs);
      }
      if (this.rJp != null) {
        paramVarArgs.d(6, this.rJp);
      }
      AppMethodBeat.o(168985);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.GmH);
      paramInt = i;
      if (this.Gmz != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Gmz);
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.lastBuffer);
      }
      paramInt = i;
      if (this.Glv != null) {
        paramInt = i + f.a.a.a.lB(5, this.Glv.computeSize());
      }
      i = paramInt;
      if (this.rJp != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.rJp);
      }
      AppMethodBeat.o(168985);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(168985);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        anw localanw = (anw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168985);
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
            localanw.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168985);
          return 0;
        case 2: 
          localanw.GmH = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(168985);
          return 0;
        case 3: 
          localanw.Gmz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168985);
          return 0;
        case 4: 
          localanw.lastBuffer = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(168985);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localanw.Glv = ((alk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168985);
          return 0;
        }
        localanw.rJp = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(168985);
        return 0;
      }
      AppMethodBeat.o(168985);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anw
 * JD-Core Version:    0.7.0.1
 */