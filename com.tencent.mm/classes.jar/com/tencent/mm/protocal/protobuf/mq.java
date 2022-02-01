package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mq
  extends dyl
{
  public int ROx;
  public long RSC;
  public String RSD;
  public String RSE;
  public long RSk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208426);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.RSC);
      if (this.RSD != null) {
        paramVarArgs.f(4, this.RSD);
      }
      if (this.RSE != null) {
        paramVarArgs.f(5, this.RSE);
      }
      paramVarArgs.bm(18, this.RSk);
      paramVarArgs.aY(22, this.ROx);
      AppMethodBeat.o(208426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label568;
      }
    }
    label568:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.RSC);
      paramInt = i;
      if (this.RSD != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RSD);
      }
      i = paramInt;
      if (this.RSE != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RSE);
      }
      paramInt = g.a.a.b.b.a.p(18, this.RSk);
      int j = g.a.a.b.b.a.bM(22, this.ROx);
      AppMethodBeat.o(208426);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(208426);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        mq localmq = (mq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(208426);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localmq.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(208426);
          return 0;
        case 2: 
          localmq.RSC = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(208426);
          return 0;
        case 4: 
          localmq.RSD = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(208426);
          return 0;
        case 5: 
          localmq.RSE = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(208426);
          return 0;
        case 18: 
          localmq.RSk = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(208426);
          return 0;
        }
        localmq.ROx = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(208426);
        return 0;
      }
      AppMethodBeat.o(208426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mq
 * JD-Core Version:    0.7.0.1
 */