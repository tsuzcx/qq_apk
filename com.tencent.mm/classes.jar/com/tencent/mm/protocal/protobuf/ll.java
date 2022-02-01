package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ll
  extends dyl
{
  public String OTh;
  public String RQs;
  public String RQt;
  public String RQu;
  public int fOu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72422);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RQs != null) {
        paramVarArgs.f(2, this.RQs);
      }
      if (this.RQt != null) {
        paramVarArgs.f(3, this.RQt);
      }
      if (this.OTh != null) {
        paramVarArgs.f(4, this.OTh);
      }
      if (this.RQu != null) {
        paramVarArgs.f(5, this.RQu);
      }
      paramVarArgs.aY(7, this.fOu);
      AppMethodBeat.o(72422);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label580;
      }
    }
    label580:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RQs != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RQs);
      }
      i = paramInt;
      if (this.RQt != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RQt);
      }
      paramInt = i;
      if (this.OTh != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.OTh);
      }
      i = paramInt;
      if (this.RQu != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RQu);
      }
      paramInt = g.a.a.b.b.a.bM(7, this.fOu);
      AppMethodBeat.o(72422);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72422);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ll localll = (ll)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(72422);
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
            localll.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(72422);
          return 0;
        case 2: 
          localll.RQs = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72422);
          return 0;
        case 3: 
          localll.RQt = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72422);
          return 0;
        case 4: 
          localll.OTh = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72422);
          return 0;
        case 5: 
          localll.RQu = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72422);
          return 0;
        }
        localll.fOu = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(72422);
        return 0;
      }
      AppMethodBeat.o(72422);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ll
 * JD-Core Version:    0.7.0.1
 */