package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class vy
  extends dyl
{
  public int Scm;
  public b Sip;
  public b Siq;
  public int amount;
  public String tVM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91408);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.amount);
      if (this.Sip != null) {
        paramVarArgs.c(3, this.Sip);
      }
      if (this.Siq != null) {
        paramVarArgs.c(4, this.Siq);
      }
      if (this.tVM != null) {
        paramVarArgs.f(5, this.tVM);
      }
      paramVarArgs.aY(6, this.Scm);
      AppMethodBeat.o(91408);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label560;
      }
    }
    label560:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.amount);
      paramInt = i;
      if (this.Sip != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.Sip);
      }
      i = paramInt;
      if (this.Siq != null) {
        i = paramInt + g.a.a.b.b.a.b(4, this.Siq);
      }
      paramInt = i;
      if (this.tVM != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.tVM);
      }
      i = g.a.a.b.b.a.bM(6, this.Scm);
      AppMethodBeat.o(91408);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91408);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        vy localvy = (vy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91408);
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
            localvy.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91408);
          return 0;
        case 2: 
          localvy.amount = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91408);
          return 0;
        case 3: 
          localvy.Sip = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(91408);
          return 0;
        case 4: 
          localvy.Siq = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(91408);
          return 0;
        case 5: 
          localvy.tVM = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91408);
          return 0;
        }
        localvy.Scm = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91408);
        return 0;
      }
      AppMethodBeat.o(91408);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vy
 * JD-Core Version:    0.7.0.1
 */