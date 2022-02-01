package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.anw;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.cd.a
{
  public String HCx;
  public anw RDh;
  public String desc;
  public LinkedList<anm> lpz;
  public String title;
  public long uTt;
  
  public c()
  {
    AppMethodBeat.i(94808);
    this.lpz = new LinkedList();
    AppMethodBeat.o(94808);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94809);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.f(2, this.desc);
      }
      paramVarArgs.e(3, 8, this.lpz);
      if (this.HCx != null) {
        paramVarArgs.f(4, this.HCx);
      }
      if (this.RDh != null)
      {
        paramVarArgs.oE(5, this.RDh.computeSize());
        this.RDh.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(6, this.uTt);
      AppMethodBeat.o(94809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label634;
      }
    }
    label634:
    for (paramInt = g.a.a.b.b.a.g(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.desc);
      }
      i += g.a.a.a.c(3, 8, this.lpz);
      paramInt = i;
      if (this.HCx != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.HCx);
      }
      i = paramInt;
      if (this.RDh != null) {
        i = paramInt + g.a.a.a.oD(5, this.RDh.computeSize());
      }
      paramInt = g.a.a.b.b.a.p(6, this.uTt);
      AppMethodBeat.o(94809);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.lpz.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(94809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94809);
          return -1;
        case 1: 
          localc.title = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(94809);
          return 0;
        case 2: 
          localc.desc = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(94809);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new anm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((anm)localObject2).parseFrom((byte[])localObject1);
            }
            localc.lpz.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(94809);
          return 0;
        case 4: 
          localc.HCx = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(94809);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new anw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((anw)localObject2).parseFrom((byte[])localObject1);
            }
            localc.RDh = ((anw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(94809);
          return 0;
        }
        localc.uTt = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(94809);
        return 0;
      }
      AppMethodBeat.o(94809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.c
 * JD-Core Version:    0.7.0.1
 */