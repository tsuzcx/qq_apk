package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class dcl
  extends dyl
{
  public int CPw;
  public int TJP;
  public int TJQ;
  public b TJR;
  public int TJS;
  public String TJT;
  public String TJU;
  public String TJV;
  public b TgT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(120957);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.TJP);
      paramVarArgs.aY(3, this.TJQ);
      if (this.TJR != null) {
        paramVarArgs.c(4, this.TJR);
      }
      paramVarArgs.aY(5, this.TJS);
      if (this.TgT != null) {
        paramVarArgs.c(6, this.TgT);
      }
      if (this.TJT != null) {
        paramVarArgs.f(7, this.TJT);
      }
      if (this.TJU != null) {
        paramVarArgs.f(8, this.TJU);
      }
      if (this.TJV != null) {
        paramVarArgs.f(9, this.TJV);
      }
      paramVarArgs.aY(10, this.CPw);
      AppMethodBeat.o(120957);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label772;
      }
    }
    label772:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TJP) + g.a.a.b.b.a.bM(3, this.TJQ);
      paramInt = i;
      if (this.TJR != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.TJR);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.TJS);
      paramInt = i;
      if (this.TgT != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.TgT);
      }
      i = paramInt;
      if (this.TJT != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.TJT);
      }
      paramInt = i;
      if (this.TJU != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TJU);
      }
      i = paramInt;
      if (this.TJV != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.TJV);
      }
      paramInt = g.a.a.b.b.a.bM(10, this.CPw);
      AppMethodBeat.o(120957);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(120957);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dcl localdcl = (dcl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(120957);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localdcl.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(120957);
          return 0;
        case 2: 
          localdcl.TJP = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(120957);
          return 0;
        case 3: 
          localdcl.TJQ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(120957);
          return 0;
        case 4: 
          localdcl.TJR = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(120957);
          return 0;
        case 5: 
          localdcl.TJS = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(120957);
          return 0;
        case 6: 
          localdcl.TgT = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(120957);
          return 0;
        case 7: 
          localdcl.TJT = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(120957);
          return 0;
        case 8: 
          localdcl.TJU = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(120957);
          return 0;
        case 9: 
          localdcl.TJV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(120957);
          return 0;
        }
        localdcl.CPw = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(120957);
        return 0;
      }
      AppMethodBeat.o(120957);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcl
 * JD-Core Version:    0.7.0.1
 */