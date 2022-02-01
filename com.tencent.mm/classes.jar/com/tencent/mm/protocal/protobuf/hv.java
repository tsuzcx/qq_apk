package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class hv
  extends com.tencent.mm.bx.a
{
  public int FAq;
  public clq FAr;
  public String duW;
  public String token;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153260);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      paramVarArgs.aS(2, this.FAq);
      if (this.FAr != null)
      {
        paramVarArgs.lC(3, this.FAr.computeSize());
        this.FAr.writeFields(paramVarArgs);
      }
      if (this.token != null) {
        paramVarArgs.d(4, this.token);
      }
      if (this.duW != null) {
        paramVarArgs.d(5, this.duW);
      }
      AppMethodBeat.o(153260);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FAq);
      paramInt = i;
      if (this.FAr != null) {
        paramInt = i + f.a.a.a.lB(3, this.FAr.computeSize());
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.token);
      }
      paramInt = i;
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.duW);
      }
      AppMethodBeat.o(153260);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153260);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        hv localhv = (hv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153260);
          return -1;
        case 1: 
          localhv.username = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153260);
          return 0;
        case 2: 
          localhv.FAq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153260);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((clq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhv.FAr = ((clq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153260);
          return 0;
        case 4: 
          localhv.token = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153260);
          return 0;
        }
        localhv.duW = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(153260);
        return 0;
      }
      AppMethodBeat.o(153260);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hv
 * JD-Core Version:    0.7.0.1
 */