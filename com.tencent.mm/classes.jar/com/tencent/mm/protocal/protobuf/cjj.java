package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjj
  extends com.tencent.mm.bw.a
{
  public FinderAuthInfo authInfo;
  public int index;
  public String kog;
  public String nickname;
  public int type;
  public String username;
  public long wal;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209728);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.kog != null) {
        paramVarArgs.e(2, this.kog);
      }
      if (this.nickname != null) {
        paramVarArgs.e(3, this.nickname);
      }
      if (this.authInfo != null)
      {
        paramVarArgs.ni(4, this.authInfo.computeSize());
        this.authInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(5, this.wal);
      paramVarArgs.aM(6, this.type);
      paramVarArgs.aM(7, this.index);
      AppMethodBeat.o(209728);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label630;
      }
    }
    label630:
    for (int i = g.a.a.b.b.a.f(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kog != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.kog);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.nickname);
      }
      paramInt = i;
      if (this.authInfo != null) {
        paramInt = i + g.a.a.a.nh(4, this.authInfo.computeSize());
      }
      i = g.a.a.b.b.a.r(5, this.wal);
      int j = g.a.a.b.b.a.bu(6, this.type);
      int k = g.a.a.b.b.a.bu(7, this.index);
      AppMethodBeat.o(209728);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209728);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cjj localcjj = (cjj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209728);
          return -1;
        case 1: 
          localcjj.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209728);
          return 0;
        case 2: 
          localcjj.kog = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209728);
          return 0;
        case 3: 
          localcjj.nickname = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209728);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderAuthInfo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((FinderAuthInfo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcjj.authInfo = ((FinderAuthInfo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209728);
          return 0;
        case 5: 
          localcjj.wal = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209728);
          return 0;
        case 6: 
          localcjj.type = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209728);
          return 0;
        }
        localcjj.index = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209728);
        return 0;
      }
      AppMethodBeat.o(209728);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjj
 * JD-Core Version:    0.7.0.1
 */