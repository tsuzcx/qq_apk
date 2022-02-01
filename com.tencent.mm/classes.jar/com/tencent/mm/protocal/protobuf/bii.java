package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bii
  extends dyl
{
  public String finderUsername;
  public String query;
  public b xHE;
  public aqe yjp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199800);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.yjp != null)
      {
        paramVarArgs.oE(2, this.yjp.computeSize());
        this.yjp.writeFields(paramVarArgs);
      }
      if (this.xHE != null) {
        paramVarArgs.c(3, this.xHE);
      }
      if (this.query != null) {
        paramVarArgs.f(4, this.query);
      }
      if (this.finderUsername != null) {
        paramVarArgs.f(5, this.finderUsername);
      }
      AppMethodBeat.o(199800);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label602;
      }
    }
    label602:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.yjp != null) {
        paramInt = i + g.a.a.a.oD(2, this.yjp.computeSize());
      }
      i = paramInt;
      if (this.xHE != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.xHE);
      }
      paramInt = i;
      if (this.query != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.query);
      }
      i = paramInt;
      if (this.finderUsername != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.finderUsername);
      }
      AppMethodBeat.o(199800);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(199800);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bii localbii = (bii)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(199800);
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
            localbii.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199800);
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
            localbii.yjp = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199800);
          return 0;
        case 3: 
          localbii.xHE = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(199800);
          return 0;
        case 4: 
          localbii.query = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(199800);
          return 0;
        }
        localbii.finderUsername = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(199800);
        return 0;
      }
      AppMethodBeat.o(199800);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bii
 * JD-Core Version:    0.7.0.1
 */