package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bew
  extends dyl
{
  public aqe RLM;
  public LinkedList<Long> SPJ;
  public LinkedList<cyn> SPK;
  public int fSo;
  public String finderUsername;
  
  public bew()
  {
    AppMethodBeat.i(203810);
    this.SPJ = new LinkedList();
    this.SPK = new LinkedList();
    AppMethodBeat.o(203810);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203815);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.fSo);
      if (this.finderUsername != null) {
        paramVarArgs.f(3, this.finderUsername);
      }
      paramVarArgs.e(4, 3, this.SPJ);
      if (this.RLM != null)
      {
        paramVarArgs.oE(5, this.RLM.computeSize());
        this.RLM.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.SPK);
      AppMethodBeat.o(203815);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label707;
      }
    }
    label707:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fSo);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.finderUsername);
      }
      i = paramInt + g.a.a.a.c(4, 3, this.SPJ);
      paramInt = i;
      if (this.RLM != null) {
        paramInt = i + g.a.a.a.oD(5, this.RLM.computeSize());
      }
      i = g.a.a.a.c(6, 8, this.SPK);
      AppMethodBeat.o(203815);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SPJ.clear();
        this.SPK.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(203815);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bew localbew = (bew)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(203815);
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
            localbew.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(203815);
          return 0;
        case 2: 
          localbew.fSo = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(203815);
          return 0;
        case 3: 
          localbew.finderUsername = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(203815);
          return 0;
        case 4: 
          localbew.SPJ.add(Long.valueOf(((g.a.a.a.a)localObject1).abFh.AN()));
          AppMethodBeat.o(203815);
          return 0;
        case 5: 
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
            localbew.RLM = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(203815);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cyn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cyn)localObject2).parseFrom((byte[])localObject1);
          }
          localbew.SPK.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(203815);
        return 0;
      }
      AppMethodBeat.o(203815);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bew
 * JD-Core Version:    0.7.0.1
 */