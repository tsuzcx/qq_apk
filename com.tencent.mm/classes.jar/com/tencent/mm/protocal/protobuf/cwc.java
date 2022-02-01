package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwc
  extends com.tencent.mm.cd.a
{
  public String TEW;
  public cwp TEX;
  public cwg TEY;
  public cwp TEZ;
  public String description;
  public LinkedList<cwq> media;
  public int mediaType;
  
  public cwc()
  {
    AppMethodBeat.i(203382);
    this.media = new LinkedList();
    AppMethodBeat.o(203382);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203393);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.description != null) {
        paramVarArgs.f(1, this.description);
      }
      paramVarArgs.e(2, 8, this.media);
      paramVarArgs.aY(3, this.mediaType);
      if (this.TEW != null) {
        paramVarArgs.f(4, this.TEW);
      }
      if (this.TEX != null)
      {
        paramVarArgs.oE(5, this.TEX.computeSize());
        this.TEX.writeFields(paramVarArgs);
      }
      if (this.TEY != null)
      {
        paramVarArgs.oE(6, this.TEY.computeSize());
        this.TEY.writeFields(paramVarArgs);
      }
      if (this.TEZ != null)
      {
        paramVarArgs.oE(7, this.TEZ.computeSize());
        this.TEZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(203393);
      return 0;
    }
    if (paramInt == 1) {
      if (this.description == null) {
        break label838;
      }
    }
    label838:
    for (paramInt = g.a.a.b.b.a.g(1, this.description) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.media) + g.a.a.b.b.a.bM(3, this.mediaType);
      paramInt = i;
      if (this.TEW != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TEW);
      }
      i = paramInt;
      if (this.TEX != null) {
        i = paramInt + g.a.a.a.oD(5, this.TEX.computeSize());
      }
      paramInt = i;
      if (this.TEY != null) {
        paramInt = i + g.a.a.a.oD(6, this.TEY.computeSize());
      }
      i = paramInt;
      if (this.TEZ != null) {
        i = paramInt + g.a.a.a.oD(7, this.TEZ.computeSize());
      }
      AppMethodBeat.o(203393);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.media.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(203393);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cwc localcwc = (cwc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(203393);
          return -1;
        case 1: 
          localcwc.description = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(203393);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cwq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cwq)localObject2).parseFrom((byte[])localObject1);
            }
            localcwc.media.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(203393);
          return 0;
        case 3: 
          localcwc.mediaType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(203393);
          return 0;
        case 4: 
          localcwc.TEW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(203393);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cwp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cwp)localObject2).parseFrom((byte[])localObject1);
            }
            localcwc.TEX = ((cwp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(203393);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cwg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cwg)localObject2).parseFrom((byte[])localObject1);
            }
            localcwc.TEY = ((cwg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(203393);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cwp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cwp)localObject2).parseFrom((byte[])localObject1);
          }
          localcwc.TEZ = ((cwp)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(203393);
        return 0;
      }
      AppMethodBeat.o(203393);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwc
 * JD-Core Version:    0.7.0.1
 */