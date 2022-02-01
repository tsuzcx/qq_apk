package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class duv
  extends com.tencent.mm.cd.a
{
  public String GUf;
  public long Tkj;
  public String Ubd;
  public double Ube;
  public LinkedList<vg> Ubf;
  public String Ubg;
  public LinkedList<dzk> Ubh;
  public String appid;
  public String nickname;
  public String username;
  
  public duv()
  {
    AppMethodBeat.i(50103);
    this.Ubf = new LinkedList();
    this.Ubh = new LinkedList();
    AppMethodBeat.o(50103);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50104);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.f(1, this.appid);
      }
      if (this.username != null) {
        paramVarArgs.f(2, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.f(3, this.nickname);
      }
      if (this.GUf != null) {
        paramVarArgs.f(4, this.GUf);
      }
      paramVarArgs.bm(5, this.Tkj);
      if (this.Ubd != null) {
        paramVarArgs.f(6, this.Ubd);
      }
      paramVarArgs.e(7, this.Ube);
      paramVarArgs.e(16, 8, this.Ubf);
      if (this.Ubg != null) {
        paramVarArgs.f(17, this.Ubg);
      }
      paramVarArgs.e(19, 8, this.Ubh);
      AppMethodBeat.o(50104);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label885;
      }
    }
    label885:
    for (int i = g.a.a.b.b.a.g(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.username);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.nickname);
      }
      paramInt = i;
      if (this.GUf != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.GUf);
      }
      i = paramInt + g.a.a.b.b.a.p(5, this.Tkj);
      paramInt = i;
      if (this.Ubd != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Ubd);
      }
      i = paramInt + (g.a.a.b.b.a.gL(7) + 8) + g.a.a.a.c(16, 8, this.Ubf);
      paramInt = i;
      if (this.Ubg != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.Ubg);
      }
      i = g.a.a.a.c(19, 8, this.Ubh);
      AppMethodBeat.o(50104);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ubf.clear();
        this.Ubh.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(50104);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        duv localduv = (duv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
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
          localduv.appid = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 2: 
          localduv.username = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 3: 
          localduv.nickname = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 4: 
          localduv.GUf = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 5: 
          localduv.Tkj = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(50104);
          return 0;
        case 6: 
          localduv.Ubd = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 7: 
          localduv.Ube = Double.longBitsToDouble(((g.a.a.a.a)localObject1).abFh.AP());
          AppMethodBeat.o(50104);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new vg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((vg)localObject2).parseFrom((byte[])localObject1);
            }
            localduv.Ubf.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50104);
          return 0;
        case 17: 
          localduv.Ubg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(50104);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dzk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dzk)localObject2).parseFrom((byte[])localObject1);
          }
          localduv.Ubh.add(localObject2);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duv
 * JD-Core Version:    0.7.0.1
 */