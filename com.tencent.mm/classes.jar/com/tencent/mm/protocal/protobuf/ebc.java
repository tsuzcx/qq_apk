package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ebc
  extends com.tencent.mm.bx.a
{
  public long Lbz;
  public FinderAuthInfo authInfo;
  public int index;
  public String itN;
  public String nickname;
  public int type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203889);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.itN != null) {
        paramVarArgs.d(2, this.itN);
      }
      if (this.nickname != null) {
        paramVarArgs.d(3, this.nickname);
      }
      if (this.authInfo != null)
      {
        paramVarArgs.kX(4, this.authInfo.computeSize());
        this.authInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(5, this.Lbz);
      paramVarArgs.aR(6, this.type);
      paramVarArgs.aR(7, this.index);
      AppMethodBeat.o(203889);
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
      if (this.itN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.itN);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nickname);
      }
      paramInt = i;
      if (this.authInfo != null) {
        paramInt = i + f.a.a.a.kW(4, this.authInfo.computeSize());
      }
      i = f.a.a.b.b.a.q(5, this.Lbz);
      int j = f.a.a.b.b.a.bA(6, this.type);
      int k = f.a.a.b.b.a.bA(7, this.index);
      AppMethodBeat.o(203889);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(203889);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ebc localebc = (ebc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(203889);
          return -1;
        case 1: 
          localebc.username = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(203889);
          return 0;
        case 2: 
          localebc.itN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(203889);
          return 0;
        case 3: 
          localebc.nickname = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(203889);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderAuthInfo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((FinderAuthInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localebc.authInfo = ((FinderAuthInfo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(203889);
          return 0;
        case 5: 
          localebc.Lbz = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(203889);
          return 0;
        case 6: 
          localebc.type = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(203889);
          return 0;
        }
        localebc.index = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(203889);
        return 0;
      }
      AppMethodBeat.o(203889);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebc
 * JD-Core Version:    0.7.0.1
 */