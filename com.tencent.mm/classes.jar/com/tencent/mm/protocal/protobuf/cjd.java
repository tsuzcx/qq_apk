package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjd
  extends com.tencent.mm.cd.a
{
  public jb Tqe;
  public ti Tqf;
  public cxb Tqg;
  public ena Tqh;
  public ebc Tqi;
  public abw Tqj;
  public aou Tqk;
  public bnd Tql;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116471);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Tqe != null)
      {
        paramVarArgs.oE(1, this.Tqe.computeSize());
        this.Tqe.writeFields(paramVarArgs);
      }
      if (this.Tqf != null)
      {
        paramVarArgs.oE(2, this.Tqf.computeSize());
        this.Tqf.writeFields(paramVarArgs);
      }
      if (this.Tqg != null)
      {
        paramVarArgs.oE(3, this.Tqg.computeSize());
        this.Tqg.writeFields(paramVarArgs);
      }
      if (this.Tqh != null)
      {
        paramVarArgs.oE(4, this.Tqh.computeSize());
        this.Tqh.writeFields(paramVarArgs);
      }
      if (this.Tqi != null)
      {
        paramVarArgs.oE(6, this.Tqi.computeSize());
        this.Tqi.writeFields(paramVarArgs);
      }
      if (this.Tqj != null)
      {
        paramVarArgs.oE(7, this.Tqj.computeSize());
        this.Tqj.writeFields(paramVarArgs);
      }
      if (this.Tqk != null)
      {
        paramVarArgs.oE(8, this.Tqk.computeSize());
        this.Tqk.writeFields(paramVarArgs);
      }
      if (this.Tql != null)
      {
        paramVarArgs.oE(9, this.Tql.computeSize());
        this.Tql.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(116471);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Tqe == null) {
        break label1226;
      }
    }
    label1226:
    for (int i = g.a.a.a.oD(1, this.Tqe.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Tqf != null) {
        paramInt = i + g.a.a.a.oD(2, this.Tqf.computeSize());
      }
      i = paramInt;
      if (this.Tqg != null) {
        i = paramInt + g.a.a.a.oD(3, this.Tqg.computeSize());
      }
      paramInt = i;
      if (this.Tqh != null) {
        paramInt = i + g.a.a.a.oD(4, this.Tqh.computeSize());
      }
      i = paramInt;
      if (this.Tqi != null) {
        i = paramInt + g.a.a.a.oD(6, this.Tqi.computeSize());
      }
      paramInt = i;
      if (this.Tqj != null) {
        paramInt = i + g.a.a.a.oD(7, this.Tqj.computeSize());
      }
      i = paramInt;
      if (this.Tqk != null) {
        i = paramInt + g.a.a.a.oD(8, this.Tqk.computeSize());
      }
      paramInt = i;
      if (this.Tql != null) {
        paramInt = i + g.a.a.a.oD(9, this.Tql.computeSize());
      }
      AppMethodBeat.o(116471);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(116471);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cjd localcjd = (cjd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(116471);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jb)localObject2).parseFrom((byte[])localObject1);
            }
            localcjd.Tqe = ((jb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ti();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ti)localObject2).parseFrom((byte[])localObject1);
            }
            localcjd.Tqf = ((ti)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cxb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cxb)localObject2).parseFrom((byte[])localObject1);
            }
            localcjd.Tqg = ((cxb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ena();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ena)localObject2).parseFrom((byte[])localObject1);
            }
            localcjd.Tqh = ((ena)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ebc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ebc)localObject2).parseFrom((byte[])localObject1);
            }
            localcjd.Tqi = ((ebc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new abw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((abw)localObject2).parseFrom((byte[])localObject1);
            }
            localcjd.Tqj = ((abw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aou();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aou)localObject2).parseFrom((byte[])localObject1);
            }
            localcjd.Tqk = ((aou)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bnd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bnd)localObject2).parseFrom((byte[])localObject1);
          }
          localcjd.Tql = ((bnd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(116471);
        return 0;
      }
      AppMethodBeat.o(116471);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjd
 * JD-Core Version:    0.7.0.1
 */