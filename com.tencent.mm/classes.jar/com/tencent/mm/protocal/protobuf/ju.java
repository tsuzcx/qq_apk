package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ju
  extends dyl
{
  public LinkedList<String> RPt;
  public LinkedList<dyh> RPu;
  public long RPv;
  public int RPw;
  public int RPx;
  public String sSU;
  
  public ju()
  {
    AppMethodBeat.i(6394);
    this.RPt = new LinkedList();
    this.RPu = new LinkedList();
    AppMethodBeat.o(6394);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6395);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.RPt);
      paramVarArgs.e(3, 8, this.RPu);
      if (this.sSU != null) {
        paramVarArgs.f(4, this.sSU);
      }
      paramVarArgs.bm(5, this.RPv);
      paramVarArgs.aY(6, this.RPw);
      paramVarArgs.aY(7, this.RPx);
      AppMethodBeat.o(6395);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label675;
      }
    }
    label675:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 1, this.RPt) + g.a.a.a.c(3, 8, this.RPu);
      paramInt = i;
      if (this.sSU != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.sSU);
      }
      i = g.a.a.b.b.a.p(5, this.RPv);
      int j = g.a.a.b.b.a.bM(6, this.RPw);
      int k = g.a.a.b.b.a.bM(7, this.RPx);
      AppMethodBeat.o(6395);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RPt.clear();
        this.RPu.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(6395);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ju localju = (ju)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6395);
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
            localju.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6395);
          return 0;
        case 2: 
          localju.RPt.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(6395);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dyh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dyh)localObject2).parseFrom((byte[])localObject1);
            }
            localju.RPu.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6395);
          return 0;
        case 4: 
          localju.sSU = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(6395);
          return 0;
        case 5: 
          localju.RPv = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(6395);
          return 0;
        case 6: 
          localju.RPw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(6395);
          return 0;
        }
        localju.RPx = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(6395);
        return 0;
      }
      AppMethodBeat.o(6395);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ju
 * JD-Core Version:    0.7.0.1
 */