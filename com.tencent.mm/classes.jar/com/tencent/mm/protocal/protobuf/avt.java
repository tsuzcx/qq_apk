package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avt
  extends dyl
{
  public aqe RLM;
  public LinkedList<Integer> SIj;
  
  public avt()
  {
    AppMethodBeat.i(208413);
    this.SIj = new LinkedList();
    AppMethodBeat.o(208413);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208416);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RLM != null)
      {
        paramVarArgs.oE(2, this.RLM.computeSize());
        this.RLM.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 2, this.SIj);
      AppMethodBeat.o(208416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label481;
      }
    }
    label481:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RLM != null) {
        i = paramInt + g.a.a.a.oD(2, this.RLM.computeSize());
      }
      paramInt = g.a.a.a.c(3, 2, this.SIj);
      AppMethodBeat.o(208416);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SIj.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(208416);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        avt localavt = (avt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(208416);
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
            localavt.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(208416);
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
            localavt.RLM = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(208416);
          return 0;
        }
        localavt.SIj.add(Integer.valueOf(((g.a.a.a.a)localObject1).abFh.AK()));
        AppMethodBeat.o(208416);
        return 0;
      }
      AppMethodBeat.o(208416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avt
 * JD-Core Version:    0.7.0.1
 */