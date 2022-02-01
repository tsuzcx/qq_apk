package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arj
  extends dyl
{
  public aqe SDi;
  public int SEp;
  public String fGe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201488);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SDi != null)
      {
        paramVarArgs.oE(2, this.SDi.computeSize());
        this.SDi.writeFields(paramVarArgs);
      }
      if (this.fGe != null) {
        paramVarArgs.f(3, this.fGe);
      }
      paramVarArgs.aY(4, this.SEp);
      AppMethodBeat.o(201488);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label526;
      }
    }
    label526:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SDi != null) {
        paramInt = i + g.a.a.a.oD(2, this.SDi.computeSize());
      }
      i = paramInt;
      if (this.fGe != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fGe);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.SEp);
      AppMethodBeat.o(201488);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(201488);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        arj localarj = (arj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(201488);
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
            localarj.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(201488);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqe)localObject2).parseFrom((byte[])localObject1);
            }
            localarj.SDi = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(201488);
          return 0;
        case 3: 
          localarj.fGe = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(201488);
          return 0;
        }
        localarj.SEp = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(201488);
        return 0;
      }
      AppMethodBeat.o(201488);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arj
 * JD-Core Version:    0.7.0.1
 */