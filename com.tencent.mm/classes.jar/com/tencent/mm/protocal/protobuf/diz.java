package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class diz
  extends cvc
{
  public String FxN;
  public dix HxS;
  public dix HxT;
  public int HxU;
  public int HxV;
  public String hCW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118439);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HxS == null)
      {
        paramVarArgs = new b("Not all required fields were included: CommentDetail");
        AppMethodBeat.o(118439);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hCW != null) {
        paramVarArgs.d(2, this.hCW);
      }
      if (this.HxS != null)
      {
        paramVarArgs.lC(3, this.HxS.computeSize());
        this.HxS.writeFields(paramVarArgs);
      }
      if (this.HxT != null)
      {
        paramVarArgs.lC(6, this.HxT.computeSize());
        this.HxT.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.HxU);
      paramVarArgs.aS(5, this.HxV);
      if (this.FxN != null) {
        paramVarArgs.d(7, this.FxN);
      }
      AppMethodBeat.o(118439);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label878;
      }
    }
    label878:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hCW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hCW);
      }
      i = paramInt;
      if (this.HxS != null) {
        i = paramInt + f.a.a.a.lB(3, this.HxS.computeSize());
      }
      paramInt = i;
      if (this.HxT != null) {
        paramInt = i + f.a.a.a.lB(6, this.HxT.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.HxU) + f.a.a.b.b.a.bz(5, this.HxV);
      paramInt = i;
      if (this.FxN != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FxN);
      }
      AppMethodBeat.o(118439);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HxS == null)
        {
          paramVarArgs = new b("Not all required fields were included: CommentDetail");
          AppMethodBeat.o(118439);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        diz localdiz = (diz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118439);
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
            localdiz.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118439);
          return 0;
        case 2: 
          localdiz.hCW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(118439);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dix();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dix)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdiz.HxS = ((dix)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118439);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dix();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dix)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdiz.HxT = ((dix)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118439);
          return 0;
        case 4: 
          localdiz.HxU = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(118439);
          return 0;
        case 5: 
          localdiz.HxV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(118439);
          return 0;
        }
        localdiz.FxN = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(118439);
        return 0;
      }
      AppMethodBeat.o(118439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.diz
 * JD-Core Version:    0.7.0.1
 */