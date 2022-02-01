package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzg
  extends dyl
{
  public String CRQ;
  public String CRR;
  public int CreateTime;
  public String RJQ;
  public int UeO;
  public int UeP;
  public int UeQ;
  public long UeR;
  public String UeS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32415);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RJQ != null) {
        paramVarArgs.f(2, this.RJQ);
      }
      paramVarArgs.aY(3, this.UeO);
      paramVarArgs.aY(4, this.CreateTime);
      paramVarArgs.aY(5, this.UeP);
      if (this.CRR != null) {
        paramVarArgs.f(6, this.CRR);
      }
      if (this.CRQ != null) {
        paramVarArgs.f(7, this.CRQ);
      }
      paramVarArgs.aY(8, this.UeQ);
      paramVarArgs.bm(9, this.UeR);
      if (this.UeS != null) {
        paramVarArgs.f(10, this.UeS);
      }
      AppMethodBeat.o(32415);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label768;
      }
    }
    label768:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RJQ != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RJQ);
      }
      i = i + g.a.a.b.b.a.bM(3, this.UeO) + g.a.a.b.b.a.bM(4, this.CreateTime) + g.a.a.b.b.a.bM(5, this.UeP);
      paramInt = i;
      if (this.CRR != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.CRR);
      }
      i = paramInt;
      if (this.CRQ != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.CRQ);
      }
      i = i + g.a.a.b.b.a.bM(8, this.UeQ) + g.a.a.b.b.a.p(9, this.UeR);
      paramInt = i;
      if (this.UeS != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.UeS);
      }
      AppMethodBeat.o(32415);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32415);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dzg localdzg = (dzg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32415);
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
            localdzg.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(32415);
          return 0;
        case 2: 
          localdzg.RJQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32415);
          return 0;
        case 3: 
          localdzg.UeO = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32415);
          return 0;
        case 4: 
          localdzg.CreateTime = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32415);
          return 0;
        case 5: 
          localdzg.UeP = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32415);
          return 0;
        case 6: 
          localdzg.CRR = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32415);
          return 0;
        case 7: 
          localdzg.CRQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32415);
          return 0;
        case 8: 
          localdzg.UeQ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32415);
          return 0;
        case 9: 
          localdzg.UeR = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(32415);
          return 0;
        }
        localdzg.UeS = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(32415);
        return 0;
      }
      AppMethodBeat.o(32415);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzg
 * JD-Core Version:    0.7.0.1
 */