package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class blu
  extends dyl
{
  public String GIM;
  public String HlB;
  public String RQN;
  public String SWQ;
  public String SWR;
  public String SWS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91466);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SWQ != null) {
        paramVarArgs.f(2, this.SWQ);
      }
      if (this.RQN != null) {
        paramVarArgs.f(3, this.RQN);
      }
      if (this.GIM != null) {
        paramVarArgs.f(4, this.GIM);
      }
      if (this.SWR != null) {
        paramVarArgs.f(5, this.SWR);
      }
      if (this.SWS != null) {
        paramVarArgs.f(6, this.SWS);
      }
      if (this.HlB != null) {
        paramVarArgs.f(7, this.HlB);
      }
      AppMethodBeat.o(91466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label652;
      }
    }
    label652:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SWQ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SWQ);
      }
      i = paramInt;
      if (this.RQN != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RQN);
      }
      paramInt = i;
      if (this.GIM != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.GIM);
      }
      i = paramInt;
      if (this.SWR != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SWR);
      }
      paramInt = i;
      if (this.SWS != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SWS);
      }
      i = paramInt;
      if (this.HlB != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.HlB);
      }
      AppMethodBeat.o(91466);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91466);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        blu localblu = (blu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91466);
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
            localblu.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91466);
          return 0;
        case 2: 
          localblu.SWQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 3: 
          localblu.RQN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 4: 
          localblu.GIM = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 5: 
          localblu.SWR = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 6: 
          localblu.SWS = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91466);
          return 0;
        }
        localblu.HlB = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91466);
        return 0;
      }
      AppMethodBeat.o(91466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blu
 * JD-Core Version:    0.7.0.1
 */