package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class va
  extends dyy
{
  public int Saq;
  public eae SfI;
  public abv SfL;
  public int SfM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(93331);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(93331);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.SfL != null)
      {
        paramVarArgs.oE(2, this.SfL.computeSize());
        this.SfL.writeFields(paramVarArgs);
      }
      if (this.SfI != null)
      {
        paramVarArgs.oE(3, this.SfI.computeSize());
        this.SfI.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.Saq);
      paramVarArgs.aY(5, this.SfM);
      AppMethodBeat.o(93331);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label692;
      }
    }
    label692:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SfL != null) {
        paramInt = i + g.a.a.a.oD(2, this.SfL.computeSize());
      }
      i = paramInt;
      if (this.SfI != null) {
        i = paramInt + g.a.a.a.oD(3, this.SfI.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(4, this.Saq);
      int j = g.a.a.b.b.a.bM(5, this.SfM);
      AppMethodBeat.o(93331);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(93331);
          throw paramVarArgs;
        }
        AppMethodBeat.o(93331);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        va localva = (va)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(93331);
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
            localva.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(93331);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new abv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((abv)localObject2).parseFrom((byte[])localObject1);
            }
            localva.SfL = ((abv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(93331);
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
            localva.SfI = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(93331);
          return 0;
        case 4: 
          localva.Saq = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(93331);
          return 0;
        }
        localva.SfM = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(93331);
        return 0;
      }
      AppMethodBeat.o(93331);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.va
 * JD-Core Version:    0.7.0.1
 */