package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class uf
  extends cvc
{
  public String FTz;
  public String nickname;
  public String oBW;
  public int vls;
  public String xYJ;
  public String xYK;
  public String xYy;
  public String xZb;
  public String xZe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91400);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.vls);
      if (this.oBW != null) {
        paramVarArgs.d(3, this.oBW);
      }
      if (this.xZb != null) {
        paramVarArgs.d(4, this.xZb);
      }
      if (this.FTz != null) {
        paramVarArgs.d(5, this.FTz);
      }
      if (this.xYJ != null) {
        paramVarArgs.d(6, this.xYJ);
      }
      if (this.xYK != null) {
        paramVarArgs.d(7, this.xYK);
      }
      if (this.xZe != null) {
        paramVarArgs.d(8, this.xZe);
      }
      if (this.nickname != null) {
        paramVarArgs.d(9, this.nickname);
      }
      if (this.xYy != null) {
        paramVarArgs.d(10, this.xYy);
      }
      AppMethodBeat.o(91400);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label846;
      }
    }
    label846:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.vls);
      paramInt = i;
      if (this.oBW != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oBW);
      }
      i = paramInt;
      if (this.xZb != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.xZb);
      }
      paramInt = i;
      if (this.FTz != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FTz);
      }
      i = paramInt;
      if (this.xYJ != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.xYJ);
      }
      paramInt = i;
      if (this.xYK != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.xYK);
      }
      i = paramInt;
      if (this.xZe != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.xZe);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.nickname);
      }
      i = paramInt;
      if (this.xYy != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.xYy);
      }
      AppMethodBeat.o(91400);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91400);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        uf localuf = (uf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91400);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localuf.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91400);
          return 0;
        case 2: 
          localuf.vls = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91400);
          return 0;
        case 3: 
          localuf.oBW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 4: 
          localuf.xZb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 5: 
          localuf.FTz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 6: 
          localuf.xYJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 7: 
          localuf.xYK = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 8: 
          localuf.xZe = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 9: 
          localuf.nickname = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91400);
          return 0;
        }
        localuf.xYy = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91400);
        return 0;
      }
      AppMethodBeat.o(91400);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uf
 * JD-Core Version:    0.7.0.1
 */