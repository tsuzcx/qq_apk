package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvd
  extends com.tencent.mm.bx.a
{
  public FinderAuthInfo authInfo;
  public int index;
  public String jna;
  public String nickname;
  public long sMP;
  public int type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209379);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.jna != null) {
        paramVarArgs.d(2, this.jna);
      }
      if (this.nickname != null) {
        paramVarArgs.d(3, this.nickname);
      }
      if (this.authInfo != null)
      {
        paramVarArgs.lC(4, this.authInfo.computeSize());
        this.authInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.sMP);
      paramVarArgs.aS(6, this.type);
      paramVarArgs.aS(7, this.index);
      AppMethodBeat.o(209379);
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
      if (this.jna != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.jna);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nickname);
      }
      paramInt = i;
      if (this.authInfo != null) {
        paramInt = i + f.a.a.a.lB(4, this.authInfo.computeSize());
      }
      i = f.a.a.b.b.a.p(5, this.sMP);
      int j = f.a.a.b.b.a.bz(6, this.type);
      int k = f.a.a.b.b.a.bz(7, this.index);
      AppMethodBeat.o(209379);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209379);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bvd localbvd = (bvd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209379);
          return -1;
        case 1: 
          localbvd.username = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209379);
          return 0;
        case 2: 
          localbvd.jna = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209379);
          return 0;
        case 3: 
          localbvd.nickname = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209379);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderAuthInfo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((FinderAuthInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvd.authInfo = ((FinderAuthInfo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209379);
          return 0;
        case 5: 
          localbvd.sMP = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(209379);
          return 0;
        case 6: 
          localbvd.type = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(209379);
          return 0;
        }
        localbvd.index = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(209379);
        return 0;
      }
      AppMethodBeat.o(209379);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvd
 * JD-Core Version:    0.7.0.1
 */