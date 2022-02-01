package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class hk
  extends com.tencent.mm.bx.a
{
  public int CCy;
  public cbp CCz;
  public String dlB;
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
      paramVarArgs.aR(2, this.CCy);
      if (this.CCz != null)
      {
        paramVarArgs.kX(3, this.CCz.computeSize());
        this.CCz.writeFields(paramVarArgs);
      }
      if (this.token != null) {
        paramVarArgs.d(4, this.token);
      }
      if (this.dlB != null) {
        paramVarArgs.d(5, this.dlB);
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
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CCy);
      paramInt = i;
      if (this.CCz != null) {
        paramInt = i + f.a.a.a.kW(3, this.CCz.computeSize());
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.token);
      }
      paramInt = i;
      if (this.dlB != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dlB);
      }
      AppMethodBeat.o(153260);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153260);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        hk localhk = (hk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153260);
          return -1;
        case 1: 
          localhk.username = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153260);
          return 0;
        case 2: 
          localhk.CCy = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153260);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cbp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhk.CCz = ((cbp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153260);
          return 0;
        case 4: 
          localhk.token = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153260);
          return 0;
        }
        localhk.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(153260);
        return 0;
      }
      AppMethodBeat.o(153260);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hk
 * JD-Core Version:    0.7.0.1
 */