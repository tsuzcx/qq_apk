package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class etw
  extends dyy
{
  public dtj Sih;
  public int UvH;
  public dwg UvI;
  public int tqa;
  public String tqb;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72589);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tqa);
      if (this.tqb != null) {
        paramVarArgs.f(3, this.tqb);
      }
      if (this.Sih != null)
      {
        paramVarArgs.oE(4, this.Sih.computeSize());
        this.Sih.writeFields(paramVarArgs);
      }
      if (this.UvI != null)
      {
        paramVarArgs.oE(5, this.UvI.computeSize());
        this.UvI.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.UvH);
      if (this.wording != null) {
        paramVarArgs.f(7, this.wording);
      }
      AppMethodBeat.o(72589);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label764;
      }
    }
    label764:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt;
      if (this.Sih != null) {
        i = paramInt + g.a.a.a.oD(4, this.Sih.computeSize());
      }
      paramInt = i;
      if (this.UvI != null) {
        paramInt = i + g.a.a.a.oD(5, this.UvI.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.UvH);
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.wording);
      }
      AppMethodBeat.o(72589);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72589);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        etw localetw = (etw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72589);
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
            localetw.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72589);
          return 0;
        case 2: 
          localetw.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72589);
          return 0;
        case 3: 
          localetw.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72589);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtj)localObject2).parseFrom((byte[])localObject1);
            }
            localetw.Sih = ((dtj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72589);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dwg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dwg)localObject2).parseFrom((byte[])localObject1);
            }
            localetw.UvI = ((dwg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72589);
          return 0;
        case 6: 
          localetw.UvH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72589);
          return 0;
        }
        localetw.wording = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(72589);
        return 0;
      }
      AppMethodBeat.o(72589);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.etw
 * JD-Core Version:    0.7.0.1
 */