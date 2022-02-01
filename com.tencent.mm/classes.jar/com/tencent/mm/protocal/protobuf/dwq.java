package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwq
  extends dyl
{
  public int RSi;
  public LinkedList<on> Ucs;
  public int Uct;
  public int Ucu;
  public long Ucv;
  public int Ucw;
  public long Ucx;
  public int scene;
  
  public dwq()
  {
    AppMethodBeat.i(6424);
    this.Ucs = new LinkedList();
    AppMethodBeat.o(6424);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6425);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Ucs);
      paramVarArgs.aY(3, this.Uct);
      paramVarArgs.aY(4, this.Ucu);
      paramVarArgs.aY(5, this.RSi);
      paramVarArgs.bm(6, this.Ucv);
      paramVarArgs.aY(7, this.scene);
      paramVarArgs.aY(8, this.Ucw);
      paramVarArgs.bm(9, this.Ucx);
      AppMethodBeat.o(6425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label753;
      }
    }
    label753:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.Ucs);
      int j = g.a.a.b.b.a.bM(3, this.Uct);
      int k = g.a.a.b.b.a.bM(4, this.Ucu);
      int m = g.a.a.b.b.a.bM(5, this.RSi);
      int n = g.a.a.b.b.a.p(6, this.Ucv);
      int i1 = g.a.a.b.b.a.bM(7, this.scene);
      int i2 = g.a.a.b.b.a.bM(8, this.Ucw);
      int i3 = g.a.a.b.b.a.p(9, this.Ucx);
      AppMethodBeat.o(6425);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ucs.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(6425);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dwq localdwq = (dwq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6425);
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
            localdwq.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6425);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new on();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((on)localObject2).parseFrom((byte[])localObject1);
            }
            localdwq.Ucs.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6425);
          return 0;
        case 3: 
          localdwq.Uct = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(6425);
          return 0;
        case 4: 
          localdwq.Ucu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(6425);
          return 0;
        case 5: 
          localdwq.RSi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(6425);
          return 0;
        case 6: 
          localdwq.Ucv = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(6425);
          return 0;
        case 7: 
          localdwq.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(6425);
          return 0;
        case 8: 
          localdwq.Ucw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(6425);
          return 0;
        }
        localdwq.Ucx = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(6425);
        return 0;
      }
      AppMethodBeat.o(6425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwq
 * JD-Core Version:    0.7.0.1
 */