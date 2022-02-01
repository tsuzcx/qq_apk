package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bqo
  extends dyl
{
  public LinkedList<ckp> TbC;
  public ckr TbE;
  public long TbF;
  
  public bqo()
  {
    AppMethodBeat.i(82406);
    this.TbC = new LinkedList();
    AppMethodBeat.o(82406);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82407);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.TbC);
      if (this.TbE != null)
      {
        paramVarArgs.oE(4, this.TbE.computeSize());
        this.TbE.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(5, this.TbF);
      AppMethodBeat.o(82407);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label588;
      }
    }
    label588:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.TbC);
      paramInt = i;
      if (this.TbE != null) {
        paramInt = i + g.a.a.a.oD(4, this.TbE.computeSize());
      }
      i = g.a.a.b.b.a.p(5, this.TbF);
      AppMethodBeat.o(82407);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TbC.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(82407);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bqo localbqo = (bqo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(82407);
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
            localbqo.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82407);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ckp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ckp)localObject2).parseFrom((byte[])localObject1);
            }
            localbqo.TbC.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82407);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ckr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ckr)localObject2).parseFrom((byte[])localObject1);
            }
            localbqo.TbE = ((ckr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82407);
          return 0;
        }
        localbqo.TbF = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(82407);
        return 0;
      }
      AppMethodBeat.o(82407);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqo
 * JD-Core Version:    0.7.0.1
 */