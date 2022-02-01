package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class byo
  extends dyy
{
  public int Tdw;
  public did ThG;
  public die ThH;
  public die ThI;
  public dif ThJ;
  public int tqa;
  public String tqb;
  public int ufi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114033);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114033);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tqa);
      if (this.tqb != null) {
        paramVarArgs.f(3, this.tqb);
      }
      paramVarArgs.aY(4, this.ufi);
      paramVarArgs.aY(5, this.Tdw);
      if (this.ThG != null)
      {
        paramVarArgs.oE(6, this.ThG.computeSize());
        this.ThG.writeFields(paramVarArgs);
      }
      if (this.ThH != null)
      {
        paramVarArgs.oE(7, this.ThH.computeSize());
        this.ThH.writeFields(paramVarArgs);
      }
      if (this.ThI != null)
      {
        paramVarArgs.oE(8, this.ThI.computeSize());
        this.ThI.writeFields(paramVarArgs);
      }
      if (this.ThJ != null)
      {
        paramVarArgs.oE(9, this.ThJ.computeSize());
        this.ThJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114033);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1064;
      }
    }
    label1064:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.ufi) + g.a.a.b.b.a.bM(5, this.Tdw);
      paramInt = i;
      if (this.ThG != null) {
        paramInt = i + g.a.a.a.oD(6, this.ThG.computeSize());
      }
      i = paramInt;
      if (this.ThH != null) {
        i = paramInt + g.a.a.a.oD(7, this.ThH.computeSize());
      }
      paramInt = i;
      if (this.ThI != null) {
        paramInt = i + g.a.a.a.oD(8, this.ThI.computeSize());
      }
      i = paramInt;
      if (this.ThJ != null) {
        i = paramInt + g.a.a.a.oD(9, this.ThJ.computeSize());
      }
      AppMethodBeat.o(114033);
      return i;
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
          AppMethodBeat.o(114033);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114033);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        byo localbyo = (byo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114033);
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
            localbyo.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114033);
          return 0;
        case 2: 
          localbyo.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(114033);
          return 0;
        case 3: 
          localbyo.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(114033);
          return 0;
        case 4: 
          localbyo.ufi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(114033);
          return 0;
        case 5: 
          localbyo.Tdw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(114033);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new did();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((did)localObject2).parseFrom((byte[])localObject1);
            }
            localbyo.ThG = ((did)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114033);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new die();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((die)localObject2).parseFrom((byte[])localObject1);
            }
            localbyo.ThH = ((die)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114033);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new die();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((die)localObject2).parseFrom((byte[])localObject1);
            }
            localbyo.ThI = ((die)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114033);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dif();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dif)localObject2).parseFrom((byte[])localObject1);
          }
          localbyo.ThJ = ((dif)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(114033);
        return 0;
      }
      AppMethodBeat.o(114033);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byo
 * JD-Core Version:    0.7.0.1
 */