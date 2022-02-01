package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bcj
  extends com.tencent.mm.bw.a
{
  public String LLw;
  public String LLx;
  public int dJl;
  public String desc;
  public long localId;
  public LinkedList<bch> mediaList;
  public String nickname;
  public String objectId;
  public String objectNonceId;
  public String uNR;
  public String username;
  public int vXJ;
  
  public bcj()
  {
    AppMethodBeat.i(164046);
    this.mediaList = new LinkedList();
    AppMethodBeat.o(164046);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(164047);
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
      paramVarArgs.aM(6, this.vXJ);
      paramVarArgs.aM(7, this.dJl);
      paramVarArgs.e(8, 8, this.mediaList);
      if (this.objectNonceId != null) {
        paramVarArgs.e(9, this.objectNonceId);
      }
      paramVarArgs.bb(10, this.localId);
      if (this.LLw != null) {
        paramVarArgs.e(11, this.LLw);
      }
      if (this.LLx != null) {
        paramVarArgs.e(12, this.LLx);
      }
      AppMethodBeat.o(164047);
      return 0;
    }
    if (paramInt == 1) {
      if (this.objectId == null) {
        break label918;
      }
    }
    label918:
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
      i = i + g.a.a.b.b.a.bu(6, this.vXJ) + g.a.a.b.b.a.bu(7, this.dJl) + g.a.a.a.c(8, 8, this.mediaList);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.objectNonceId);
      }
      i = paramInt + g.a.a.b.b.a.r(10, this.localId);
      paramInt = i;
      if (this.LLw != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.LLw);
      }
      i = paramInt;
      if (this.LLx != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.LLx);
      }
      AppMethodBeat.o(164047);
      return i;
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
        AppMethodBeat.o(164047);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bcj localbcj = (bcj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(164047);
          return -1;
        case 1: 
          localbcj.objectId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 2: 
          localbcj.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 3: 
          localbcj.nickname = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 4: 
          localbcj.uNR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 5: 
          localbcj.desc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 6: 
          localbcj.vXJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(164047);
          return 0;
        case 7: 
          localbcj.dJl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(164047);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bch();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bch)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbcj.mediaList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(164047);
          return 0;
        case 9: 
          localbcj.objectNonceId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 10: 
          localbcj.localId = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(164047);
          return 0;
        case 11: 
          localbcj.LLw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(164047);
          return 0;
        }
        localbcj.LLx = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(164047);
        return 0;
      }
      AppMethodBeat.o(164047);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcj
 * JD-Core Version:    0.7.0.1
 */