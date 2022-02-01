package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bqq
  extends com.tencent.mm.bw.a
{
  public FinderAuthInfo authInfo;
  public String iTS;
  public int index;
  public String nickname;
  public long rQj;
  public int type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195125);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.iTS != null) {
        paramVarArgs.d(2, this.iTS);
      }
      if (this.nickname != null) {
        paramVarArgs.d(3, this.nickname);
      }
      if (this.authInfo != null)
      {
        paramVarArgs.ln(4, this.authInfo.computeSize());
        this.authInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.rQj);
      paramVarArgs.aR(6, this.type);
      paramVarArgs.aR(7, this.index);
      AppMethodBeat.o(195125);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label630;
      }
    }
    label630:
    for (int i = f.a.a.b.b.a.e(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iTS != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iTS);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nickname);
      }
      paramInt = i;
      if (this.authInfo != null) {
        paramInt = i + f.a.a.a.lm(4, this.authInfo.computeSize());
      }
      i = f.a.a.b.b.a.p(5, this.rQj);
      int j = f.a.a.b.b.a.bx(6, this.type);
      int k = f.a.a.b.b.a.bx(7, this.index);
      AppMethodBeat.o(195125);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(195125);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bqq localbqq = (bqq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195125);
          return -1;
        case 1: 
          localbqq.username = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(195125);
          return 0;
        case 2: 
          localbqq.iTS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(195125);
          return 0;
        case 3: 
          localbqq.nickname = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(195125);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderAuthInfo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((FinderAuthInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqq.authInfo = ((FinderAuthInfo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(195125);
          return 0;
        case 5: 
          localbqq.rQj = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(195125);
          return 0;
        case 6: 
          localbqq.type = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(195125);
          return 0;
        }
        localbqq.index = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(195125);
        return 0;
      }
      AppMethodBeat.o(195125);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqq
 * JD-Core Version:    0.7.0.1
 */