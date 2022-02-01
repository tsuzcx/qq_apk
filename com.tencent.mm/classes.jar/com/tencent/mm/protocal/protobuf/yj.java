package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yj
  extends cvc
{
  public String FKD;
  public dwj FXS;
  public int Scene;
  public String uki;
  public String ukj;
  public int xbr;
  public long xbt;
  public int xcK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32166);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FKD != null) {
        paramVarArgs.d(2, this.FKD);
      }
      paramVarArgs.aS(3, this.xcK);
      paramVarArgs.aS(4, this.xbr);
      if (this.FXS != null)
      {
        paramVarArgs.lC(5, this.FXS.computeSize());
        this.FXS.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.xbt);
      paramVarArgs.aS(7, this.Scene);
      if (this.ukj != null) {
        paramVarArgs.d(8, this.ukj);
      }
      if (this.uki != null) {
        paramVarArgs.d(9, this.uki);
      }
      AppMethodBeat.o(32166);
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
      int i = paramInt;
      if (this.FKD != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FKD);
      }
      i = i + f.a.a.b.b.a.bz(3, this.xcK) + f.a.a.b.b.a.bz(4, this.xbr);
      paramInt = i;
      if (this.FXS != null) {
        paramInt = i + f.a.a.a.lB(5, this.FXS.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.xbt) + f.a.a.b.b.a.bz(7, this.Scene);
      paramInt = i;
      if (this.ukj != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.ukj);
      }
      i = paramInt;
      if (this.uki != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.uki);
      }
      AppMethodBeat.o(32166);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32166);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        yj localyj = (yj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32166);
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
            localyj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32166);
          return 0;
        case 2: 
          localyj.FKD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32166);
          return 0;
        case 3: 
          localyj.xcK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32166);
          return 0;
        case 4: 
          localyj.xbr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32166);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyj.FXS = ((dwj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32166);
          return 0;
        case 6: 
          localyj.xbt = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(32166);
          return 0;
        case 7: 
          localyj.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32166);
          return 0;
        case 8: 
          localyj.ukj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32166);
          return 0;
        }
        localyj.uki = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32166);
        return 0;
      }
      AppMethodBeat.o(32166);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yj
 * JD-Core Version:    0.7.0.1
 */