package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class hv
  extends com.tencent.mm.bw.a
{
  public int FSN;
  public cmk FSO;
  public String dwb;
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
      paramVarArgs.aS(2, this.FSN);
      if (this.FSO != null)
      {
        paramVarArgs.lJ(3, this.FSO.computeSize());
        this.FSO.writeFields(paramVarArgs);
      }
      if (this.token != null) {
        paramVarArgs.d(4, this.token);
      }
      if (this.dwb != null) {
        paramVarArgs.d(5, this.dwb);
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
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FSN);
      paramInt = i;
      if (this.FSO != null) {
        paramInt = i + f.a.a.a.lI(3, this.FSO.computeSize());
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.token);
      }
      paramInt = i;
      if (this.dwb != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dwb);
      }
      AppMethodBeat.o(153260);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
          localhv.username = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153260);
          return 0;
        case 2: 
          localhv.FSN = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153260);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cmk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhv.FSO = ((cmk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153260);
          return 0;
        case 4: 
          localhv.token = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153260);
          return 0;
        }
        localhv.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
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