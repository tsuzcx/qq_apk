package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class awq
  extends com.tencent.mm.bw.a
{
  public avn LHp;
  public String LHq;
  public String content;
  public String fQY;
  public String headUrl;
  public String nickname;
  public long seq;
  public int type;
  public String username;
  public int wBG;
  public b ybi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209541);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.nickname != null) {
        paramVarArgs.e(1, this.nickname);
      }
      if (this.headUrl != null) {
        paramVarArgs.e(2, this.headUrl);
      }
      if (this.content != null) {
        paramVarArgs.e(3, this.content);
      }
      paramVarArgs.aM(4, this.type);
      if (this.username != null) {
        paramVarArgs.e(5, this.username);
      }
      paramVarArgs.bb(6, this.seq);
      if (this.fQY != null) {
        paramVarArgs.e(7, this.fQY);
      }
      paramVarArgs.aM(8, this.wBG);
      if (this.LHp != null)
      {
        paramVarArgs.ni(9, this.LHp.computeSize());
        this.LHp.writeFields(paramVarArgs);
      }
      if (this.LHq != null) {
        paramVarArgs.e(10, this.LHq);
      }
      if (this.ybi != null) {
        paramVarArgs.c(11, this.ybi);
      }
      AppMethodBeat.o(209541);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickname == null) {
        break label874;
      }
    }
    label874:
    for (int i = g.a.a.b.b.a.f(1, this.nickname) + 0;; i = 0)
    {
      paramInt = i;
      if (this.headUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.headUrl);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.content);
      }
      i += g.a.a.b.b.a.bu(4, this.type);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.username);
      }
      i = paramInt + g.a.a.b.b.a.r(6, this.seq);
      paramInt = i;
      if (this.fQY != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.fQY);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.wBG);
      paramInt = i;
      if (this.LHp != null) {
        paramInt = i + g.a.a.a.nh(9, this.LHp.computeSize());
      }
      i = paramInt;
      if (this.LHq != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.LHq);
      }
      paramInt = i;
      if (this.ybi != null) {
        paramInt = i + g.a.a.b.b.a.b(11, this.ybi);
      }
      AppMethodBeat.o(209541);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209541);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        awq localawq = (awq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209541);
          return -1;
        case 1: 
          localawq.nickname = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209541);
          return 0;
        case 2: 
          localawq.headUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209541);
          return 0;
        case 3: 
          localawq.content = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209541);
          return 0;
        case 4: 
          localawq.type = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209541);
          return 0;
        case 5: 
          localawq.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209541);
          return 0;
        case 6: 
          localawq.seq = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209541);
          return 0;
        case 7: 
          localawq.fQY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209541);
          return 0;
        case 8: 
          localawq.wBG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209541);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((avn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localawq.LHp = ((avn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209541);
          return 0;
        case 10: 
          localawq.LHq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209541);
          return 0;
        }
        localawq.ybi = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(209541);
        return 0;
      }
      AppMethodBeat.o(209541);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awq
 * JD-Core Version:    0.7.0.1
 */