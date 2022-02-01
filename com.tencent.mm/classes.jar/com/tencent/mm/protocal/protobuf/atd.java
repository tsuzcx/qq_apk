package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class atd
  extends dyl
{
  public aqe SFL;
  public int fSo;
  public long xee;
  public String xef;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205128);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SFL != null)
      {
        paramVarArgs.oE(2, this.SFL.computeSize());
        this.SFL.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.fSo);
      paramVarArgs.bm(4, this.xee);
      if (this.xef != null) {
        paramVarArgs.f(5, this.xef);
      }
      AppMethodBeat.o(205128);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label566;
      }
    }
    label566:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SFL != null) {
        i = paramInt + g.a.a.a.oD(2, this.SFL.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(3, this.fSo) + g.a.a.b.b.a.p(4, this.xee);
      paramInt = i;
      if (this.xef != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.xef);
      }
      AppMethodBeat.o(205128);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205128);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        atd localatd = (atd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(205128);
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
            localatd.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(205128);
          return 0;
        case 2: 
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
            localatd.SFL = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(205128);
          return 0;
        case 3: 
          localatd.fSo = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(205128);
          return 0;
        case 4: 
          localatd.xee = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(205128);
          return 0;
        }
        localatd.xef = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(205128);
        return 0;
      }
      AppMethodBeat.o(205128);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atd
 * JD-Core Version:    0.7.0.1
 */