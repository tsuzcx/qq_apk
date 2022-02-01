package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class qs
  extends dyl
{
  public String ImY;
  public String InV;
  public String RJf;
  public String RJg;
  public int RJi;
  public b RZb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91365);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RJf != null) {
        paramVarArgs.f(2, this.RJf);
      }
      if (this.InV != null) {
        paramVarArgs.f(3, this.InV);
      }
      if (this.ImY != null) {
        paramVarArgs.f(4, this.ImY);
      }
      paramVarArgs.aY(5, this.RJi);
      if (this.RZb != null) {
        paramVarArgs.c(6, this.RZb);
      }
      if (this.RJg != null) {
        paramVarArgs.f(7, this.RJg);
      }
      AppMethodBeat.o(91365);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label636;
      }
    }
    label636:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RJf != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RJf);
      }
      i = paramInt;
      if (this.InV != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.InV);
      }
      paramInt = i;
      if (this.ImY != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.ImY);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.RJi);
      paramInt = i;
      if (this.RZb != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.RZb);
      }
      i = paramInt;
      if (this.RJg != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.RJg);
      }
      AppMethodBeat.o(91365);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91365);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        qs localqs = (qs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91365);
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
            localqs.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91365);
          return 0;
        case 2: 
          localqs.RJf = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91365);
          return 0;
        case 3: 
          localqs.InV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91365);
          return 0;
        case 4: 
          localqs.ImY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91365);
          return 0;
        case 5: 
          localqs.RJi = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91365);
          return 0;
        case 6: 
          localqs.RZb = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(91365);
          return 0;
        }
        localqs.RJg = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91365);
        return 0;
      }
      AppMethodBeat.o(91365);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qs
 * JD-Core Version:    0.7.0.1
 */