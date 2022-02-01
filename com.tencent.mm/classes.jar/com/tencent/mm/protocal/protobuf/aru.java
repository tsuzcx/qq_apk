package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class aru
  extends dyl
{
  public b SFi;
  public ard SFj;
  public int SFk;
  public int SFl;
  public ard SFm;
  public int SFn;
  public String lqp;
  public String nickname;
  public String signature;
  public aqe yjp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168948);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nickname != null) {
        paramVarArgs.f(2, this.nickname);
      }
      if (this.SFi != null) {
        paramVarArgs.c(3, this.SFi);
      }
      if (this.lqp != null) {
        paramVarArgs.f(4, this.lqp);
      }
      if (this.yjp != null)
      {
        paramVarArgs.oE(5, this.yjp.computeSize());
        this.yjp.writeFields(paramVarArgs);
      }
      if (this.signature != null) {
        paramVarArgs.f(6, this.signature);
      }
      if (this.SFj != null)
      {
        paramVarArgs.oE(7, this.SFj.computeSize());
        this.SFj.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.SFk);
      paramVarArgs.aY(9, this.SFl);
      if (this.SFm != null)
      {
        paramVarArgs.oE(10, this.SFm.computeSize());
        this.SFm.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(11, this.SFn);
      AppMethodBeat.o(168948);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1066;
      }
    }
    label1066:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.nickname);
      }
      i = paramInt;
      if (this.SFi != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.SFi);
      }
      paramInt = i;
      if (this.lqp != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.lqp);
      }
      i = paramInt;
      if (this.yjp != null) {
        i = paramInt + g.a.a.a.oD(5, this.yjp.computeSize());
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.signature);
      }
      i = paramInt;
      if (this.SFj != null) {
        i = paramInt + g.a.a.a.oD(7, this.SFj.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(8, this.SFk) + g.a.a.b.b.a.bM(9, this.SFl);
      paramInt = i;
      if (this.SFm != null) {
        paramInt = i + g.a.a.a.oD(10, this.SFm.computeSize());
      }
      i = g.a.a.b.b.a.bM(11, this.SFn);
      AppMethodBeat.o(168948);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(168948);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aru localaru = (aru)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168948);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localaru.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168948);
          return 0;
        case 2: 
          localaru.nickname = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168948);
          return 0;
        case 3: 
          localaru.SFi = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(168948);
          return 0;
        case 4: 
          localaru.lqp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168948);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqe)localObject2).parseFrom((byte[])localObject1);
            }
            localaru.yjp = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168948);
          return 0;
        case 6: 
          localaru.signature = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168948);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ard();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ard)localObject2).parseFrom((byte[])localObject1);
            }
            localaru.SFj = ((ard)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168948);
          return 0;
        case 8: 
          localaru.SFk = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168948);
          return 0;
        case 9: 
          localaru.SFl = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168948);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ard();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ard)localObject2).parseFrom((byte[])localObject1);
            }
            localaru.SFm = ((ard)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168948);
          return 0;
        }
        localaru.SFn = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(168948);
        return 0;
      }
      AppMethodBeat.o(168948);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aru
 * JD-Core Version:    0.7.0.1
 */