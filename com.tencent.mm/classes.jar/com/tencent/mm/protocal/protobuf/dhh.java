package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhh
  extends dyy
{
  public String GIL;
  public String TOo;
  public dhk TOs;
  public LinkedList<dhh> TOt;
  public int TOu;
  public String type;
  
  public dhh()
  {
    AppMethodBeat.i(117539);
    this.TOt = new LinkedList();
    AppMethodBeat.o(117539);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117540);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.TOs != null)
      {
        paramVarArgs.oE(2, this.TOs.computeSize());
        this.TOs.writeFields(paramVarArgs);
      }
      if (this.TOo != null) {
        paramVarArgs.f(3, this.TOo);
      }
      if (this.GIL != null) {
        paramVarArgs.f(4, this.GIL);
      }
      if (this.type != null) {
        paramVarArgs.f(5, this.type);
      }
      paramVarArgs.e(6, 8, this.TOt);
      paramVarArgs.aY(7, this.TOu);
      AppMethodBeat.o(117540);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label768;
      }
    }
    label768:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TOs != null) {
        paramInt = i + g.a.a.a.oD(2, this.TOs.computeSize());
      }
      i = paramInt;
      if (this.TOo != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TOo);
      }
      paramInt = i;
      if (this.GIL != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.GIL);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.type);
      }
      paramInt = g.a.a.a.c(6, 8, this.TOt);
      int j = g.a.a.b.b.a.bM(7, this.TOu);
      AppMethodBeat.o(117540);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TOt.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117540);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dhh localdhh = (dhh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117540);
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
            localdhh.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117540);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhk)localObject2).parseFrom((byte[])localObject1);
            }
            localdhh.TOs = ((dhk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117540);
          return 0;
        case 3: 
          localdhh.TOo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117540);
          return 0;
        case 4: 
          localdhh.GIL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117540);
          return 0;
        case 5: 
          localdhh.type = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117540);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhh)localObject2).parseFrom((byte[])localObject1);
            }
            localdhh.TOt.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117540);
          return 0;
        }
        localdhh.TOu = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117540);
        return 0;
      }
      AppMethodBeat.o(117540);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhh
 * JD-Core Version:    0.7.0.1
 */