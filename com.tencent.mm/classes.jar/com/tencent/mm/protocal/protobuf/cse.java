package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cse
  extends com.tencent.mm.cd.a
{
  public long AJe;
  public FinderAuthInfo authInfo;
  public int index;
  public String nfY;
  public String nickname;
  public int type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197804);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      if (this.nfY != null) {
        paramVarArgs.f(2, this.nfY);
      }
      if (this.nickname != null) {
        paramVarArgs.f(3, this.nickname);
      }
      if (this.authInfo != null)
      {
        paramVarArgs.oE(4, this.authInfo.computeSize());
        this.authInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(5, this.AJe);
      paramVarArgs.aY(6, this.type);
      paramVarArgs.aY(7, this.index);
      AppMethodBeat.o(197804);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label608;
      }
    }
    label608:
    for (int i = g.a.a.b.b.a.g(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nfY != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.nfY);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.nickname);
      }
      paramInt = i;
      if (this.authInfo != null) {
        paramInt = i + g.a.a.a.oD(4, this.authInfo.computeSize());
      }
      i = g.a.a.b.b.a.p(5, this.AJe);
      int j = g.a.a.b.b.a.bM(6, this.type);
      int k = g.a.a.b.b.a.bM(7, this.index);
      AppMethodBeat.o(197804);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(197804);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cse localcse = (cse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(197804);
          return -1;
        case 1: 
          localcse.username = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(197804);
          return 0;
        case 2: 
          localcse.nfY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(197804);
          return 0;
        case 3: 
          localcse.nickname = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(197804);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            FinderAuthInfo localFinderAuthInfo = new FinderAuthInfo();
            if ((localObject != null) && (localObject.length > 0)) {
              localFinderAuthInfo.parseFrom((byte[])localObject);
            }
            localcse.authInfo = localFinderAuthInfo;
            paramInt += 1;
          }
          AppMethodBeat.o(197804);
          return 0;
        case 5: 
          localcse.AJe = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(197804);
          return 0;
        case 6: 
          localcse.type = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(197804);
          return 0;
        }
        localcse.index = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197804);
        return 0;
      }
      AppMethodBeat.o(197804);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cse
 * JD-Core Version:    0.7.0.1
 */