package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmy
  extends com.tencent.mm.bw.a
{
  public String FAj;
  public double FAk;
  public LinkedList<sd> FAl;
  public String FAm;
  public LinkedList<cqv> FAn;
  public long bQR;
  public String djj;
  public String nickname;
  public String username;
  public String vFL;
  
  public cmy()
  {
    AppMethodBeat.i(50103);
    this.FAl = new LinkedList();
    this.FAn = new LinkedList();
    AppMethodBeat.o(50103);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50104);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.djj != null) {
        paramVarArgs.d(1, this.djj);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.d(3, this.nickname);
      }
      if (this.vFL != null) {
        paramVarArgs.d(4, this.vFL);
      }
      paramVarArgs.aO(5, this.bQR);
      if (this.FAj != null) {
        paramVarArgs.d(6, this.FAj);
      }
      paramVarArgs.e(7, this.FAk);
      paramVarArgs.e(16, 8, this.FAl);
      if (this.FAm != null) {
        paramVarArgs.d(17, this.FAm);
      }
      paramVarArgs.e(19, 8, this.FAn);
      AppMethodBeat.o(50104);
      return 0;
    }
    if (paramInt == 1) {
      if (this.djj == null) {
        break label929;
      }
    }
    label929:
    for (int i = f.a.a.b.b.a.e(1, this.djj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.username);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nickname);
      }
      paramInt = i;
      if (this.vFL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.vFL);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.bQR);
      paramInt = i;
      if (this.FAj != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FAj);
      }
      i = paramInt + (f.a.a.b.b.a.fK(7) + 8) + f.a.a.a.c(16, 8, this.FAl);
      paramInt = i;
      if (this.FAm != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.FAm);
      }
      i = f.a.a.a.c(19, 8, this.FAn);
      AppMethodBeat.o(50104);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FAl.clear();
        this.FAn.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(50104);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cmy localcmy = (cmy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 18: 
        default: 
          AppMethodBeat.o(50104);
          return -1;
        case 1: 
          localcmy.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 2: 
          localcmy.username = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 3: 
          localcmy.nickname = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 4: 
          localcmy.vFL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 5: 
          localcmy.bQR = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(50104);
          return 0;
        case 6: 
          localcmy.FAj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 7: 
          localcmy.FAk = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(50104);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcmy.FAl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50104);
          return 0;
        case 17: 
          localcmy.FAm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(50104);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cqv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cqv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcmy.FAn.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(50104);
        return 0;
      }
      AppMethodBeat.o(50104);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmy
 * JD-Core Version:    0.7.0.1
 */