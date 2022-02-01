package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avl
  extends dyy
{
  public String SHP;
  public int SHQ;
  public String SHR;
  public bff SHS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197922);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.SHP != null) {
        paramVarArgs.f(2, this.SHP);
      }
      paramVarArgs.aY(3, this.SHQ);
      if (this.SHR != null) {
        paramVarArgs.f(4, this.SHR);
      }
      if (this.SHS != null)
      {
        paramVarArgs.oE(5, this.SHS.computeSize());
        this.SHS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(197922);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label586;
      }
    }
    label586:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SHP != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.SHP);
      }
      i += g.a.a.b.b.a.bM(3, this.SHQ);
      paramInt = i;
      if (this.SHR != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SHR);
      }
      i = paramInt;
      if (this.SHS != null) {
        i = paramInt + g.a.a.a.oD(5, this.SHS.computeSize());
      }
      AppMethodBeat.o(197922);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(197922);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        avl localavl = (avl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(197922);
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
            localavl.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(197922);
          return 0;
        case 2: 
          localavl.SHP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(197922);
          return 0;
        case 3: 
          localavl.SHQ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(197922);
          return 0;
        case 4: 
          localavl.SHR = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(197922);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bff();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bff)localObject2).parseFrom((byte[])localObject1);
          }
          localavl.SHS = ((bff)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(197922);
        return 0;
      }
      AppMethodBeat.o(197922);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avl
 * JD-Core Version:    0.7.0.1
 */