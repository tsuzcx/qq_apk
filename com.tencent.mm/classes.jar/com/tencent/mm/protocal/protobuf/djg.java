package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class djg
  extends com.tencent.mm.bx.a
{
  public long GlB;
  public FinderAuthInfo authInfo;
  public int index;
  public String nVM;
  public String nickname;
  public int type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259855);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      if (this.nVM != null) {
        paramVarArgs.g(2, this.nVM);
      }
      if (this.nickname != null) {
        paramVarArgs.g(3, this.nickname);
      }
      if (this.authInfo != null)
      {
        paramVarArgs.qD(4, this.authInfo.computeSize());
        this.authInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(5, this.GlB);
      paramVarArgs.bS(6, this.type);
      paramVarArgs.bS(7, this.index);
      AppMethodBeat.o(259855);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label604;
      }
    }
    label604:
    for (int i = i.a.a.b.b.a.h(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nVM != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nVM);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.nickname);
      }
      paramInt = i;
      if (this.authInfo != null) {
        paramInt = i + i.a.a.a.qC(4, this.authInfo.computeSize());
      }
      i = i.a.a.b.b.a.q(5, this.GlB);
      int j = i.a.a.b.b.a.cJ(6, this.type);
      int k = i.a.a.b.b.a.cJ(7, this.index);
      AppMethodBeat.o(259855);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259855);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        djg localdjg = (djg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259855);
          return -1;
        case 1: 
          localdjg.username = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259855);
          return 0;
        case 2: 
          localdjg.nVM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259855);
          return 0;
        case 3: 
          localdjg.nickname = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259855);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            FinderAuthInfo localFinderAuthInfo = new FinderAuthInfo();
            if ((localObject != null) && (localObject.length > 0)) {
              localFinderAuthInfo.parseFrom((byte[])localObject);
            }
            localdjg.authInfo = localFinderAuthInfo;
            paramInt += 1;
          }
          AppMethodBeat.o(259855);
          return 0;
        case 5: 
          localdjg.GlB = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259855);
          return 0;
        case 6: 
          localdjg.type = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259855);
          return 0;
        }
        localdjg.index = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259855);
        return 0;
      }
      AppMethodBeat.o(259855);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djg
 * JD-Core Version:    0.7.0.1
 */