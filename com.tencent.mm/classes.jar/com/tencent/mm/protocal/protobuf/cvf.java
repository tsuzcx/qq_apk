package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvf
  extends dyl
{
  public int TCQ;
  public int TCR;
  public String fUL;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114044);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fUL != null) {
        paramVarArgs.f(2, this.fUL);
      }
      paramVarArgs.aY(3, this.TCQ);
      paramVarArgs.aY(4, this.TCR);
      paramVarArgs.aY(5, this.scene);
      AppMethodBeat.o(114044);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label484;
      }
    }
    label484:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fUL != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.fUL);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.TCQ);
      int j = g.a.a.b.b.a.bM(4, this.TCR);
      int k = g.a.a.b.b.a.bM(5, this.scene);
      AppMethodBeat.o(114044);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(114044);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cvf localcvf = (cvf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114044);
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
            localcvf.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(114044);
          return 0;
        case 2: 
          localcvf.fUL = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114044);
          return 0;
        case 3: 
          localcvf.TCQ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(114044);
          return 0;
        case 4: 
          localcvf.TCR = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(114044);
          return 0;
        }
        localcvf.scene = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(114044);
        return 0;
      }
      AppMethodBeat.o(114044);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvf
 * JD-Core Version:    0.7.0.1
 */