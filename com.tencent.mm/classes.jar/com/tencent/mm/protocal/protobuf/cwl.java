package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class cwl
  extends com.tencent.mm.cd.a
{
  public LinkedList<bed> TFg;
  public int TFh;
  public int TFi;
  public int TFj;
  public LinkedList<FinderObject> TFk;
  public long TFl;
  public String key;
  public b lastBuffer;
  
  public cwl()
  {
    AppMethodBeat.i(202786);
    this.TFg = new LinkedList();
    this.TFk = new LinkedList();
    AppMethodBeat.o(202786);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202809);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.key != null) {
        paramVarArgs.f(1, this.key);
      }
      paramVarArgs.e(2, 8, this.TFg);
      paramVarArgs.aY(3, this.TFh);
      paramVarArgs.aY(4, this.TFi);
      if (this.lastBuffer != null) {
        paramVarArgs.c(5, this.lastBuffer);
      }
      paramVarArgs.aY(6, this.TFj);
      paramVarArgs.e(7, 8, this.TFk);
      paramVarArgs.bm(8, this.TFl);
      AppMethodBeat.o(202809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = g.a.a.b.b.a.g(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.TFg) + g.a.a.b.b.a.bM(3, this.TFh) + g.a.a.b.b.a.bM(4, this.TFi);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.lastBuffer);
      }
      i = g.a.a.b.b.a.bM(6, this.TFj);
      int j = g.a.a.a.c(7, 8, this.TFk);
      int k = g.a.a.b.b.a.p(8, this.TFl);
      AppMethodBeat.o(202809);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TFg.clear();
        this.TFk.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(202809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cwl localcwl = (cwl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(202809);
          return -1;
        case 1: 
          localcwl.key = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(202809);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bed();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bed)localObject2).parseFrom((byte[])localObject1);
            }
            localcwl.TFg.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(202809);
          return 0;
        case 3: 
          localcwl.TFh = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(202809);
          return 0;
        case 4: 
          localcwl.TFi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(202809);
          return 0;
        case 5: 
          localcwl.lastBuffer = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(202809);
          return 0;
        case 6: 
          localcwl.TFj = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(202809);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localcwl.TFk.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(202809);
          return 0;
        }
        localcwl.TFl = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(202809);
        return 0;
      }
      AppMethodBeat.o(202809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwl
 * JD-Core Version:    0.7.0.1
 */