package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awr
  extends com.tencent.mm.cd.a
{
  public int SJo;
  public long SJp;
  public arg SJq;
  public String fGe;
  public int likeFlag;
  public String lqp;
  public String nickName;
  public int unreadFlag;
  public long xaG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198541);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.nickName != null) {
        paramVarArgs.f(1, this.nickName);
      }
      if (this.lqp != null) {
        paramVarArgs.f(2, this.lqp);
      }
      paramVarArgs.bm(3, this.xaG);
      paramVarArgs.aY(4, this.likeFlag);
      paramVarArgs.aY(5, this.SJo);
      if (this.fGe != null) {
        paramVarArgs.f(6, this.fGe);
      }
      paramVarArgs.bm(7, this.SJp);
      paramVarArgs.aY(8, this.unreadFlag);
      if (this.SJq != null)
      {
        paramVarArgs.oE(9, this.SJq.computeSize());
        this.SJq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(198541);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickName == null) {
        break label692;
      }
    }
    label692:
    for (paramInt = g.a.a.b.b.a.g(1, this.nickName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lqp != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.lqp);
      }
      i = i + g.a.a.b.b.a.p(3, this.xaG) + g.a.a.b.b.a.bM(4, this.likeFlag) + g.a.a.b.b.a.bM(5, this.SJo);
      paramInt = i;
      if (this.fGe != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.fGe);
      }
      i = paramInt + g.a.a.b.b.a.p(7, this.SJp) + g.a.a.b.b.a.bM(8, this.unreadFlag);
      paramInt = i;
      if (this.SJq != null) {
        paramInt = i + g.a.a.a.oD(9, this.SJq.computeSize());
      }
      AppMethodBeat.o(198541);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(198541);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        awr localawr = (awr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(198541);
          return -1;
        case 1: 
          localawr.nickName = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(198541);
          return 0;
        case 2: 
          localawr.lqp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(198541);
          return 0;
        case 3: 
          localawr.xaG = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(198541);
          return 0;
        case 4: 
          localawr.likeFlag = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(198541);
          return 0;
        case 5: 
          localawr.SJo = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(198541);
          return 0;
        case 6: 
          localawr.fGe = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(198541);
          return 0;
        case 7: 
          localawr.SJp = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(198541);
          return 0;
        case 8: 
          localawr.unreadFlag = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(198541);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          arg localarg = new arg();
          if ((localObject != null) && (localObject.length > 0)) {
            localarg.parseFrom((byte[])localObject);
          }
          localawr.SJq = localarg;
          paramInt += 1;
        }
        AppMethodBeat.o(198541);
        return 0;
      }
      AppMethodBeat.o(198541);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awr
 * JD-Core Version:    0.7.0.1
 */