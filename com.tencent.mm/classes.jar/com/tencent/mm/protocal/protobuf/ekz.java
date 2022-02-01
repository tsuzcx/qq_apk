package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ekz
  extends dyl
{
  public int CPw;
  public String CQx;
  public int RLe;
  public long UmL;
  public int rVx;
  public LinkedList<eaf> rVy;
  
  public ekz()
  {
    AppMethodBeat.i(125821);
    this.rVy = new LinkedList();
    AppMethodBeat.o(125821);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125822);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RLe);
      paramVarArgs.bm(3, this.UmL);
      if (this.CQx != null) {
        paramVarArgs.f(4, this.CQx);
      }
      paramVarArgs.aY(5, this.rVx);
      paramVarArgs.e(6, 8, this.rVy);
      paramVarArgs.aY(7, this.CPw);
      AppMethodBeat.o(125822);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RLe) + g.a.a.b.b.a.p(3, this.UmL);
      paramInt = i;
      if (this.CQx != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CQx);
      }
      i = g.a.a.b.b.a.bM(5, this.rVx);
      int j = g.a.a.a.c(6, 8, this.rVy);
      int k = g.a.a.b.b.a.bM(7, this.CPw);
      AppMethodBeat.o(125822);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.rVy.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125822);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ekz localekz = (ekz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125822);
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
            localekz.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125822);
          return 0;
        case 2: 
          localekz.RLe = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125822);
          return 0;
        case 3: 
          localekz.UmL = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125822);
          return 0;
        case 4: 
          localekz.CQx = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125822);
          return 0;
        case 5: 
          localekz.rVx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125822);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localekz.rVy.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125822);
          return 0;
        }
        localekz.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125822);
        return 0;
      }
      AppMethodBeat.o(125822);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekz
 * JD-Core Version:    0.7.0.1
 */