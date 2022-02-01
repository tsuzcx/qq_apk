package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public class bwg
  extends dyy
{
  public clq Tgb;
  public b Tgc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(213353);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Tgb != null)
      {
        paramVarArgs.oE(2, this.Tgb.computeSize());
        this.Tgb.writeFields(paramVarArgs);
      }
      if (this.Tgc != null) {
        paramVarArgs.c(3, this.Tgc);
      }
      AppMethodBeat.o(213353);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label482;
      }
    }
    label482:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Tgb != null) {
        paramInt = i + g.a.a.a.oD(2, this.Tgb.computeSize());
      }
      i = paramInt;
      if (this.Tgc != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.Tgc);
      }
      AppMethodBeat.o(213353);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(213353);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bwg localbwg = (bwg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(213353);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localbwg.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(213353);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new clq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((clq)localObject2).parseFrom((byte[])localObject1);
            }
            localbwg.Tgb = ((clq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(213353);
          return 0;
        }
        localbwg.Tgc = ((g.a.a.a.a)localObject1).abFh.iUw();
        AppMethodBeat.o(213353);
        return 0;
      }
      AppMethodBeat.o(213353);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwg
 * JD-Core Version:    0.7.0.1
 */