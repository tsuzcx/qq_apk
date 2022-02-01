package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fop
  extends dyl
{
  public ack RPD;
  public LinkedList<for> ULx;
  
  public fop()
  {
    AppMethodBeat.i(187447);
    this.ULx = new LinkedList();
    AppMethodBeat.o(187447);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187448);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ULx);
      if (this.RPD != null)
      {
        paramVarArgs.oE(3, this.RPD.computeSize());
        this.RPD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(187448);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label540;
      }
    }
    label540:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.ULx);
      paramInt = i;
      if (this.RPD != null) {
        paramInt = i + g.a.a.a.oD(3, this.RPD.computeSize());
      }
      AppMethodBeat.o(187448);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ULx.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(187448);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fop localfop = (fop)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(187448);
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
            localfop.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(187448);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new for();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((for)localObject2).parseFrom((byte[])localObject1);
            }
            localfop.ULx.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(187448);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ack();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ack)localObject2).parseFrom((byte[])localObject1);
          }
          localfop.RPD = ((ack)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(187448);
        return 0;
      }
      AppMethodBeat.o(187448);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fop
 * JD-Core Version:    0.7.0.1
 */