package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class col
  extends com.tencent.mm.bw.a
{
  public String MuF;
  public String MuG;
  public int dJl;
  public String desc;
  public LinkedList<cok> mediaList;
  public String nickname;
  public String objectId;
  public String objectNonceId;
  public String uNR;
  public String username;
  
  public col()
  {
    AppMethodBeat.i(196098);
    this.mediaList = new LinkedList();
    AppMethodBeat.o(196098);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196099);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.objectId != null) {
        paramVarArgs.e(1, this.objectId);
      }
      if (this.username != null) {
        paramVarArgs.e(2, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.e(3, this.nickname);
      }
      if (this.uNR != null) {
        paramVarArgs.e(4, this.uNR);
      }
      if (this.desc != null) {
        paramVarArgs.e(5, this.desc);
      }
      paramVarArgs.aM(6, this.dJl);
      paramVarArgs.e(7, 8, this.mediaList);
      if (this.objectNonceId != null) {
        paramVarArgs.e(8, this.objectNonceId);
      }
      if (this.MuF != null) {
        paramVarArgs.e(9, this.MuF);
      }
      if (this.MuG != null) {
        paramVarArgs.e(10, this.MuG);
      }
      AppMethodBeat.o(196099);
      return 0;
    }
    if (paramInt == 1) {
      if (this.objectId == null) {
        break label830;
      }
    }
    label830:
    for (int i = g.a.a.b.b.a.f(1, this.objectId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.username);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.nickname);
      }
      paramInt = i;
      if (this.uNR != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.uNR);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.desc);
      }
      i = i + g.a.a.b.b.a.bu(6, this.dJl) + g.a.a.a.c(7, 8, this.mediaList);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.objectNonceId);
      }
      i = paramInt;
      if (this.MuF != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.MuF);
      }
      paramInt = i;
      if (this.MuG != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.MuG);
      }
      AppMethodBeat.o(196099);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.mediaList.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(196099);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        col localcol = (col)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(196099);
          return -1;
        case 1: 
          localcol.objectId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(196099);
          return 0;
        case 2: 
          localcol.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(196099);
          return 0;
        case 3: 
          localcol.nickname = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(196099);
          return 0;
        case 4: 
          localcol.uNR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(196099);
          return 0;
        case 5: 
          localcol.desc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(196099);
          return 0;
        case 6: 
          localcol.dJl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(196099);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cok();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cok)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcol.mediaList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196099);
          return 0;
        case 8: 
          localcol.objectNonceId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(196099);
          return 0;
        case 9: 
          localcol.MuF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(196099);
          return 0;
        }
        localcol.MuG = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(196099);
        return 0;
      }
      AppMethodBeat.o(196099);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.col
 * JD-Core Version:    0.7.0.1
 */