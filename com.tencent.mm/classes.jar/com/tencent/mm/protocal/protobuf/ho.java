package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ho
  extends com.tencent.mm.bw.a
{
  public int DUV;
  public cgr DUW;
  public String djj;
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
      paramVarArgs.aR(2, this.DUV);
      if (this.DUW != null)
      {
        paramVarArgs.ln(3, this.DUW.computeSize());
        this.DUW.writeFields(paramVarArgs);
      }
      if (this.token != null) {
        paramVarArgs.d(4, this.token);
      }
      if (this.djj != null) {
        paramVarArgs.d(5, this.djj);
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
      int i = paramInt + f.a.a.b.b.a.bx(2, this.DUV);
      paramInt = i;
      if (this.DUW != null) {
        paramInt = i + f.a.a.a.lm(3, this.DUW.computeSize());
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.token);
      }
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.djj);
      }
      AppMethodBeat.o(153260);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153260);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ho localho = (ho)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153260);
          return -1;
        case 1: 
          localho.username = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153260);
          return 0;
        case 2: 
          localho.DUV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153260);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cgr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localho.DUW = ((cgr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153260);
          return 0;
        case 4: 
          localho.token = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153260);
          return 0;
        }
        localho.djj = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(153260);
        return 0;
      }
      AppMethodBeat.o(153260);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ho
 * JD-Core Version:    0.7.0.1
 */