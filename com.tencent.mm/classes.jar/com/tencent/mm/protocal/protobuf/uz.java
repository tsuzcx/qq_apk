package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class uz
  extends dyl
{
  public int SfH;
  public eae SfI;
  public cqd SfJ;
  public int SfK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(93330);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SfI == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(93330);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.SfH);
      if (this.SfI != null)
      {
        paramVarArgs.oE(3, this.SfI.computeSize());
        this.SfI.writeFields(paramVarArgs);
      }
      if (this.SfJ != null)
      {
        paramVarArgs.oE(4, this.SfJ.computeSize());
        this.SfJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.SfK);
      AppMethodBeat.o(93330);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label688;
      }
    }
    label688:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.SfH);
      paramInt = i;
      if (this.SfI != null) {
        paramInt = i + g.a.a.a.oD(3, this.SfI.computeSize());
      }
      i = paramInt;
      if (this.SfJ != null) {
        i = paramInt + g.a.a.a.oD(4, this.SfJ.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(5, this.SfK);
      AppMethodBeat.o(93330);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.SfI == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(93330);
          throw paramVarArgs;
        }
        AppMethodBeat.o(93330);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        uz localuz = (uz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(93330);
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
            localuz.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(93330);
          return 0;
        case 2: 
          localuz.SfH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(93330);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localuz.SfI = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(93330);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cqd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cqd)localObject2).parseFrom((byte[])localObject1);
            }
            localuz.SfJ = ((cqd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(93330);
          return 0;
        }
        localuz.SfK = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(93330);
        return 0;
      }
      AppMethodBeat.o(93330);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uz
 * JD-Core Version:    0.7.0.1
 */