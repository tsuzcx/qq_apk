package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ebo
  extends dyl
{
  public eae RJA;
  public int RLe;
  public eaf SrH;
  public int TUY;
  public int Ugu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152682);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SrH == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(152682);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SrH != null)
      {
        paramVarArgs.oE(2, this.SrH.computeSize());
        this.SrH.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.RLe);
      if (this.RJA != null)
      {
        paramVarArgs.oE(4, this.RJA.computeSize());
        this.RJA.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.TUY);
      paramVarArgs.aY(6, this.Ugu);
      AppMethodBeat.o(152682);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label736;
      }
    }
    label736:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SrH != null) {
        i = paramInt + g.a.a.a.oD(2, this.SrH.computeSize());
      }
      i += g.a.a.b.b.a.bM(3, this.RLe);
      paramInt = i;
      if (this.RJA != null) {
        paramInt = i + g.a.a.a.oD(4, this.RJA.computeSize());
      }
      i = g.a.a.b.b.a.bM(5, this.TUY);
      int j = g.a.a.b.b.a.bM(6, this.Ugu);
      AppMethodBeat.o(152682);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.SrH == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(152682);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152682);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ebo localebo = (ebo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152682);
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
            localebo.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152682);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localebo.SrH = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152682);
          return 0;
        case 3: 
          localebo.RLe = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152682);
          return 0;
        case 4: 
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
            localebo.RJA = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152682);
          return 0;
        case 5: 
          localebo.TUY = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152682);
          return 0;
        }
        localebo.Ugu = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(152682);
        return 0;
      }
      AppMethodBeat.o(152682);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebo
 * JD-Core Version:    0.7.0.1
 */