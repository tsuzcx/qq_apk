package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqv
  extends com.tencent.mm.cd.a
{
  public String CMP;
  public String LensId;
  public dkv TdN;
  public cqu Tym;
  public cqx Tyn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104818);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LensId != null) {
        paramVarArgs.f(1, this.LensId);
      }
      if (this.Tym != null)
      {
        paramVarArgs.oE(2, this.Tym.computeSize());
        this.Tym.writeFields(paramVarArgs);
      }
      if (this.CMP != null) {
        paramVarArgs.f(3, this.CMP);
      }
      if (this.TdN != null)
      {
        paramVarArgs.oE(4, this.TdN.computeSize());
        this.TdN.writeFields(paramVarArgs);
      }
      if (this.Tyn != null)
      {
        paramVarArgs.oE(5, this.Tyn.computeSize());
        this.Tyn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104818);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LensId == null) {
        break label672;
      }
    }
    label672:
    for (int i = g.a.a.b.b.a.g(1, this.LensId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Tym != null) {
        paramInt = i + g.a.a.a.oD(2, this.Tym.computeSize());
      }
      i = paramInt;
      if (this.CMP != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CMP);
      }
      paramInt = i;
      if (this.TdN != null) {
        paramInt = i + g.a.a.a.oD(4, this.TdN.computeSize());
      }
      i = paramInt;
      if (this.Tyn != null) {
        i = paramInt + g.a.a.a.oD(5, this.Tyn.computeSize());
      }
      AppMethodBeat.o(104818);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(104818);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cqv localcqv = (cqv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104818);
          return -1;
        case 1: 
          localcqv.LensId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104818);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cqu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cqu)localObject2).parseFrom((byte[])localObject1);
            }
            localcqv.Tym = ((cqu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104818);
          return 0;
        case 3: 
          localcqv.CMP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104818);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dkv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dkv)localObject2).parseFrom((byte[])localObject1);
            }
            localcqv.TdN = ((dkv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104818);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cqx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cqx)localObject2).parseFrom((byte[])localObject1);
          }
          localcqv.Tyn = ((cqx)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(104818);
        return 0;
      }
      AppMethodBeat.o(104818);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqv
 * JD-Core Version:    0.7.0.1
 */