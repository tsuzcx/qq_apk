package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class edp
  extends dyl
{
  public String UhR;
  public edo UhS;
  public String UhT;
  public String UhU;
  public int action;
  public String fCl;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(276797);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fCl != null) {
        paramVarArgs.f(2, this.fCl);
      }
      if (this.UhR != null) {
        paramVarArgs.f(3, this.UhR);
      }
      paramVarArgs.aY(4, this.action);
      if (this.UhS != null)
      {
        paramVarArgs.oE(5, this.UhS.computeSize());
        this.UhS.writeFields(paramVarArgs);
      }
      if (this.UhT != null) {
        paramVarArgs.f(6, this.UhT);
      }
      paramVarArgs.aY(7, this.version);
      if (this.UhU != null) {
        paramVarArgs.f(8, this.UhU);
      }
      AppMethodBeat.o(276797);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label754;
      }
    }
    label754:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fCl != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fCl);
      }
      i = paramInt;
      if (this.UhR != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UhR);
      }
      i += g.a.a.b.b.a.bM(4, this.action);
      paramInt = i;
      if (this.UhS != null) {
        paramInt = i + g.a.a.a.oD(5, this.UhS.computeSize());
      }
      i = paramInt;
      if (this.UhT != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.UhT);
      }
      i += g.a.a.b.b.a.bM(7, this.version);
      paramInt = i;
      if (this.UhU != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.UhU);
      }
      AppMethodBeat.o(276797);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(276797);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        edp localedp = (edp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(276797);
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
            localedp.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(276797);
          return 0;
        case 2: 
          localedp.fCl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(276797);
          return 0;
        case 3: 
          localedp.UhR = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(276797);
          return 0;
        case 4: 
          localedp.action = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(276797);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new edo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((edo)localObject2).parseFrom((byte[])localObject1);
            }
            localedp.UhS = ((edo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(276797);
          return 0;
        case 6: 
          localedp.UhT = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(276797);
          return 0;
        case 7: 
          localedp.version = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(276797);
          return 0;
        }
        localedp.UhU = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(276797);
        return 0;
      }
      AppMethodBeat.o(276797);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edp
 * JD-Core Version:    0.7.0.1
 */