package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class btk
  extends dyl
{
  public String SkY;
  public long SqZ;
  public dji TdD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72483);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SkY != null) {
        paramVarArgs.f(2, this.SkY);
      }
      paramVarArgs.bm(3, this.SqZ);
      if (this.TdD != null)
      {
        paramVarArgs.oE(4, this.TdD.computeSize());
        this.TdD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72483);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label526;
      }
    }
    label526:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SkY != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.SkY);
      }
      i += g.a.a.b.b.a.p(3, this.SqZ);
      paramInt = i;
      if (this.TdD != null) {
        paramInt = i + g.a.a.a.oD(4, this.TdD.computeSize());
      }
      AppMethodBeat.o(72483);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72483);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        btk localbtk = (btk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72483);
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
            localbtk.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72483);
          return 0;
        case 2: 
          localbtk.SkY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72483);
          return 0;
        case 3: 
          localbtk.SqZ = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(72483);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dji();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dji)localObject2).parseFrom((byte[])localObject1);
          }
          localbtk.TdD = ((dji)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72483);
        return 0;
      }
      AppMethodBeat.o(72483);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btk
 * JD-Core Version:    0.7.0.1
 */