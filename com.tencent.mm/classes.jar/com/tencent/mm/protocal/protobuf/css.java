package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class css
  extends com.tencent.mm.cd.a
{
  public fbq TAv;
  public blk TAw;
  public fbq TAx;
  public int endTime;
  public int fod;
  public int height;
  public int retryCount;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169087);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TAv != null)
      {
        paramVarArgs.oE(1, this.TAv.computeSize());
        this.TAv.writeFields(paramVarArgs);
      }
      if (this.TAw != null)
      {
        paramVarArgs.oE(2, this.TAw.computeSize());
        this.TAw.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.fod);
      paramVarArgs.aY(4, this.endTime);
      paramVarArgs.aY(5, this.width);
      paramVarArgs.aY(6, this.height);
      if (this.TAx != null)
      {
        paramVarArgs.oE(7, this.TAx.computeSize());
        this.TAx.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.retryCount);
      AppMethodBeat.o(169087);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TAv == null) {
        break label772;
      }
    }
    label772:
    for (paramInt = g.a.a.a.oD(1, this.TAv.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TAw != null) {
        i = paramInt + g.a.a.a.oD(2, this.TAw.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(3, this.fod) + g.a.a.b.b.a.bM(4, this.endTime) + g.a.a.b.b.a.bM(5, this.width) + g.a.a.b.b.a.bM(6, this.height);
      paramInt = i;
      if (this.TAx != null) {
        paramInt = i + g.a.a.a.oD(7, this.TAx.computeSize());
      }
      i = g.a.a.b.b.a.bM(8, this.retryCount);
      AppMethodBeat.o(169087);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169087);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        css localcss = (css)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169087);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fbq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fbq)localObject2).parseFrom((byte[])localObject1);
            }
            localcss.TAv = ((fbq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169087);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new blk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((blk)localObject2).parseFrom((byte[])localObject1);
            }
            localcss.TAw = ((blk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169087);
          return 0;
        case 3: 
          localcss.fod = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169087);
          return 0;
        case 4: 
          localcss.endTime = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169087);
          return 0;
        case 5: 
          localcss.width = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169087);
          return 0;
        case 6: 
          localcss.height = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169087);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fbq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fbq)localObject2).parseFrom((byte[])localObject1);
            }
            localcss.TAx = ((fbq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169087);
          return 0;
        }
        localcss.retryCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169087);
        return 0;
      }
      AppMethodBeat.o(169087);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.css
 * JD-Core Version:    0.7.0.1
 */