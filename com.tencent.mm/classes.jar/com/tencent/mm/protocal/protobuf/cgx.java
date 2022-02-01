package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgx
  extends dyl
{
  public foi Tom;
  public foj Ton;
  public fok Too;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50092);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lVG != null) {
        paramVarArgs.f(2, this.lVG);
      }
      if (this.Tom != null)
      {
        paramVarArgs.oE(3, this.Tom.computeSize());
        this.Tom.writeFields(paramVarArgs);
      }
      if (this.Ton != null)
      {
        paramVarArgs.oE(6, this.Ton.computeSize());
        this.Ton.writeFields(paramVarArgs);
      }
      if (this.Too != null)
      {
        paramVarArgs.oE(7, this.Too.computeSize());
        this.Too.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(50092);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label758;
      }
    }
    label758:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lVG != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.lVG);
      }
      i = paramInt;
      if (this.Tom != null) {
        i = paramInt + g.a.a.a.oD(3, this.Tom.computeSize());
      }
      paramInt = i;
      if (this.Ton != null) {
        paramInt = i + g.a.a.a.oD(6, this.Ton.computeSize());
      }
      i = paramInt;
      if (this.Too != null) {
        i = paramInt + g.a.a.a.oD(7, this.Too.computeSize());
      }
      AppMethodBeat.o(50092);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(50092);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cgx localcgx = (cgx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 4: 
        case 5: 
        default: 
          AppMethodBeat.o(50092);
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
            localcgx.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50092);
          return 0;
        case 2: 
          localcgx.lVG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(50092);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new foi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((foi)localObject2).parseFrom((byte[])localObject1);
            }
            localcgx.Tom = ((foi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50092);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new foj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((foj)localObject2).parseFrom((byte[])localObject1);
            }
            localcgx.Ton = ((foj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50092);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fok();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fok)localObject2).parseFrom((byte[])localObject1);
          }
          localcgx.Too = ((fok)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(50092);
        return 0;
      }
      AppMethodBeat.o(50092);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgx
 * JD-Core Version:    0.7.0.1
 */