package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dle
  extends com.tencent.mm.bw.a
{
  public String Bah;
  public String MPb;
  public double MPc;
  public LinkedList<ve> MPd;
  public String MPe;
  public LinkedList<dpo> MPf;
  public long clK;
  public String dNI;
  public String nickname;
  public String username;
  
  public dle()
  {
    AppMethodBeat.i(50103);
    this.MPd = new LinkedList();
    this.MPf = new LinkedList();
    AppMethodBeat.o(50103);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50104);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dNI != null) {
        paramVarArgs.e(1, this.dNI);
      }
      if (this.username != null) {
        paramVarArgs.e(2, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.e(3, this.nickname);
      }
      if (this.Bah != null) {
        paramVarArgs.e(4, this.Bah);
      }
      paramVarArgs.bb(5, this.clK);
      if (this.MPb != null) {
        paramVarArgs.e(6, this.MPb);
      }
      paramVarArgs.e(7, this.MPc);
      paramVarArgs.e(16, 8, this.MPd);
      if (this.MPe != null) {
        paramVarArgs.e(17, this.MPe);
      }
      paramVarArgs.e(19, 8, this.MPf);
      AppMethodBeat.o(50104);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dNI == null) {
        break label929;
      }
    }
    label929:
    for (int i = g.a.a.b.b.a.f(1, this.dNI) + 0;; i = 0)
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
      if (this.Bah != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Bah);
      }
      i = paramInt + g.a.a.b.b.a.r(5, this.clK);
      paramInt = i;
      if (this.MPb != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MPb);
      }
      i = paramInt + (g.a.a.b.b.a.fS(7) + 8) + g.a.a.a.c(16, 8, this.MPd);
      paramInt = i;
      if (this.MPe != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.MPe);
      }
      i = g.a.a.a.c(19, 8, this.MPf);
      AppMethodBeat.o(50104);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MPd.clear();
        this.MPf.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(50104);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dle localdle = (dle)paramVarArgs[1];
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
          localdle.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 2: 
          localdle.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 3: 
          localdle.nickname = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 4: 
          localdle.Bah = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 5: 
          localdle.clK = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(50104);
          return 0;
        case 6: 
          localdle.MPb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 7: 
          localdle.MPc = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(50104);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ve();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ve)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdle.MPd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50104);
          return 0;
        case 17: 
          localdle.MPe = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(50104);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dpo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dpo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdle.MPf.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dle
 * JD-Core Version:    0.7.0.1
 */